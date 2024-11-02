package com.jamiedev.mod.datagen;
import com.jamiedev.mod.init.JamiesModBlocks;
import com.jamiedev.mod.init.JamiesModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
public class JamiesModModelProvider  extends FabricModelProvider {
    public JamiesModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //BlockStateModelGenerator.BlockTexturePool malachite = blockStateModelGenerator.registerCubeAllModelTexturePool(JamiesModBlocks.MALACHITE);
        //BlockStateModelGenerator.BlockTexturePool tiles = blockStateModelGenerator.registerCubeAllModelTexturePool(JamiesModBlocks.MALACHITE_TILE);

        //malachite.family(BlockFamilies.register(JamiesModBlocks.MALACHITE).slab(JamiesModBlocks.MALACHITE_SLAB).stairs(JamiesModBlocks.MALACHITE_STAIRS).wall(JamiesModBlocks.MALACHITE_WALL).build());
        //tiles.family(BlockFamilies.register(JamiesModBlocks.MALACHITE_TILE).slab(JamiesModBlocks.MALACHITE_TILE_SLAB).stairs(JamiesModBlocks.MALACHITE_TILE_STAIRS).wall(JamiesModBlocks.MALACHITE_TILE_WALL).build());
        blockStateModelGenerator.registerGeneric(JamiesModBlocks.AMBERSTONE);
        blockStateModelGenerator.registerGeneric(JamiesModBlocks.COBBLED_AMBERSTONE);
        blockStateModelGenerator.registerGeneric(JamiesModBlocks.UMBER_BRICKS);

        BlockStateModelGenerator.BlockTexturePool stone = blockStateModelGenerator.registerCubeAllModelTexturePool(JamiesModBlocks.COBBLED_BYSTONE);
        BlockStateModelGenerator.BlockTexturePool slate = blockStateModelGenerator.registerCubeAllModelTexturePool(JamiesModBlocks.COBBLED_BYSLATE);

        stone.family(BlockFamilies.register(JamiesModBlocks.COBBLED_BYSTONE).slab(JamiesModBlocks.COBBLED_BYSTONE_SLAB).stairs(JamiesModBlocks.COBBLED_BYSTONE_STAIRS).wall(JamiesModBlocks.COBBLED_BYSTONE_WALL).build());
        slate.family(BlockFamilies.register(JamiesModBlocks.COBBLED_BYSLATE).slab(JamiesModBlocks.COBBLED_BYSLATE_SLAB).stairs(JamiesModBlocks.COBBLED_BYSLATE_STAIRS).wall(JamiesModBlocks.COBBLED_BYSLATE_WALL).build());
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
     //   itemModelGenerator.register(JamiesModItems.COELECANTH, Models.GENERATED);

    }
}