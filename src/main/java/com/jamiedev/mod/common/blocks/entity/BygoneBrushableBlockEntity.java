package com.jamiedev.mod.common.blocks.entity;

import com.jamiedev.mod.fabric.init.JamiesModBlockEntities;
import com.mojang.logging.LogUtils;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BrushableBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.Objects;

public class BygoneBrushableBlockEntity extends BlockEntity {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final String LOOT_TABLE_NBT_KEY = "LootTable";
    private static final String LOOT_TABLE_SEED_NBT_KEY = "LootTableSeed";
    private static final String HIT_DIRECTION_NBT_KEY = "hit_direction";
    private static final String ITEM_NBT_KEY = "item";
    private static final int field_42806 = 10;
    private static final int field_42807 = 40;
    private static final int field_42808 = 10;
    private int brushesCount;
    private long nextDustTime;
    private long nextBrushTime;
    private ItemStack item;
    @Nullable
    private Direction hitDirection;
    @Nullable
    private RegistryKey<LootTable> lootTable;
    private long lootTableSeed;

    public BygoneBrushableBlockEntity(BlockPos pos, BlockState state) {
        super(JamiesModBlockEntities.BRUSHABLE_BLOCK, pos, state);
        this.item = ItemStack.EMPTY;
    }
    public BlockEntityType<?> getType() {
        return JamiesModBlockEntities.BRUSHABLE_BLOCK;
    }
    public boolean brush(long worldTime, PlayerEntity player, Direction hitDirection) {
        if (this.hitDirection == null) {
            this.hitDirection = hitDirection;
        }

        this.nextDustTime = worldTime + 40L;
        if (worldTime >= this.nextBrushTime && this.world instanceof ServerWorld) {
            this.nextBrushTime = worldTime + 10L;
            this.generateItem(player);
            int i = this.getDustedLevel();
            if (++this.brushesCount >= 10) {
                this.finishBrushing(player);
                return true;
            } else {
                this.world.scheduleBlockTick(this.getPos(), this.getCachedState().getBlock(), 2);
                int j = this.getDustedLevel();
                if (i != j) {
                    BlockState blockState = this.getCachedState();
                    BlockState blockState2 = (BlockState)blockState.with(Properties.DUSTED, j);
                    this.world.setBlockState(this.getPos(), blockState2, 3);
                }

                return false;
            }
        } else {
            return false;
        }
    }

    public void generateItem(PlayerEntity player) {
        if (this.lootTable != null && this.world != null && !this.world.isClient() && this.world.getServer() != null) {
            LootTable lootTable = this.world.getServer().getReloadableRegistries().getLootTable(this.lootTable);
            if (player instanceof ServerPlayerEntity) {
                ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)player;
                Criteria.PLAYER_GENERATES_CONTAINER_LOOT.trigger(serverPlayerEntity, this.lootTable);
            }

            LootContextParameterSet lootContextParameterSet = (new LootContextParameterSet.Builder((ServerWorld)this.world)).add(LootContextParameters.ORIGIN, Vec3d.ofCenter(this.pos)).luck(player.getLuck()).add(LootContextParameters.THIS_ENTITY, player).build(LootContextTypes.CHEST);
            ObjectArrayList<ItemStack> objectArrayList = lootTable.generateLoot(lootContextParameterSet, this.lootTableSeed);
            ItemStack var10001;
            switch (objectArrayList.size()) {
                case 0:
                    var10001 = ItemStack.EMPTY;
                    break;
                case 1:
                    var10001 = (ItemStack)objectArrayList.get(0);
                    break;
                default:
                    LOGGER.warn("Expected max 1 loot from loot table {}, but got {}", this.lootTable.getValue(), objectArrayList.size());
                    var10001 = (ItemStack)objectArrayList.get(0);
            }

            this.item = var10001;
            this.lootTable = null;
            this.markDirty();
        }
    }

    private void finishBrushing(PlayerEntity player) {
        if (this.world != null && this.world.getServer() != null) {
            this.spawnItem(player);
            BlockState blockState = this.getCachedState();
            this.world.syncWorldEvent(3008, this.getPos(), Block.getRawIdFromState(blockState));
            Block block = this.getCachedState().getBlock();
            Block block2;
            if (block instanceof BrushableBlock) {
                BrushableBlock brushableBlock = (BrushableBlock)block;
                block2 = brushableBlock.getBaseBlock();
            } else {
                block2 = Blocks.AIR;
            }

            this.world.setBlockState(this.pos, block2.getDefaultState(), 3);
        }
    }

    private void spawnItem(PlayerEntity player) {
        if (this.world != null && this.world.getServer() != null) {
            this.generateItem(player);
            if (!this.item.isEmpty()) {
                double d = (double) EntityType.ITEM.getWidth();
                double e = 1.0 - d;
                double f = d / 2.0;
                Direction direction = (Direction) Objects.requireNonNullElse(this.hitDirection, Direction.UP);
                BlockPos blockPos = this.pos.offset(direction, 1);
                double g = (double)blockPos.getX() + 0.5 * e + f;
                double h = (double)blockPos.getY() + 0.5 + (double)(EntityType.ITEM.getHeight() / 2.0F);
                double i = (double)blockPos.getZ() + 0.5 * e + f;
                ItemEntity itemEntity = new ItemEntity(this.world, g, h, i, this.item.split(this.world.random.nextInt(21) + 10));
                itemEntity.setVelocity(Vec3d.ZERO);
                this.world.spawnEntity(itemEntity);
                this.item = ItemStack.EMPTY;
            }

        }
    }

    public void scheduledTick() {
        if (this.world != null) {
            if (this.brushesCount != 0 && this.world.getTime() >= this.nextDustTime) {
                int i = this.getDustedLevel();
                this.brushesCount = Math.max(0, this.brushesCount - 2);
                int j = this.getDustedLevel();
                if (i != j) {
                    this.world.setBlockState(this.getPos(), (BlockState)this.getCachedState().with(Properties.DUSTED, j), 3);
                }

                this.nextDustTime = this.world.getTime() + 4L;
            }

            if (this.brushesCount == 0) {
                this.hitDirection = null;
                this.nextDustTime = 0L;
                this.nextBrushTime = 0L;
            } else {
                this.world.scheduleBlockTick(this.getPos(), this.getCachedState().getBlock(), 2);
            }

        }
    }

    private boolean readLootTableFromNbt(NbtCompound nbt) {
        if (nbt.contains("LootTable", 8)) {
            this.lootTable = RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(nbt.getString("LootTable")));
            this.lootTableSeed = nbt.getLong("LootTableSeed");
            return true;
        } else {
            return false;
        }
    }

    private boolean writeLootTableToNbt(NbtCompound nbt) {
        if (this.lootTable == null) {
            return false;
        } else {
            nbt.putString("LootTable", this.lootTable.getValue().toString());
            if (this.lootTableSeed != 0L) {
                nbt.putLong("LootTableSeed", this.lootTableSeed);
            }

            return true;
        }
    }

    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        NbtCompound nbtCompound = super.toInitialChunkDataNbt(registryLookup);
        if (this.hitDirection != null) {
            nbtCompound.putInt("hit_direction", this.hitDirection.ordinal());
        }

        if (!this.item.isEmpty()) {
            nbtCompound.put("item", this.item.encode(registryLookup));
        }

        return nbtCompound;
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        if (!this.readLootTableFromNbt(nbt) && nbt.contains("item")) {
            this.item = (ItemStack)ItemStack.fromNbt(registryLookup, nbt.getCompound("item")).orElse(ItemStack.EMPTY);
        } else {
            this.item = ItemStack.EMPTY;
        }

        if (nbt.contains("hit_direction")) {
            this.hitDirection = Direction.values()[nbt.getInt("hit_direction")];
        }

    }

    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        if (!this.writeLootTableToNbt(nbt) && !this.item.isEmpty()) {
            nbt.put("item", this.item.encode(registryLookup));
        }

    }

    public void setLootTable(RegistryKey<LootTable> lootTable, long seed) {
        this.lootTable = lootTable;
        this.lootTableSeed = seed;
    }

    private int getDustedLevel() {
        if (this.brushesCount == 0) {
            return 0;
        } else if (this.brushesCount < 3) {
            return 1;
        } else {
            return this.brushesCount < 6 ? 2 : 3;
        }
    }

    @Nullable
    public Direction getHitDirection() {
        return this.hitDirection;
    }

    public ItemStack getItem() {
        return this.item;
    }
}
