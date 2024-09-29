package com.jamiedev.mod.init;

import java.util.Optional;
import com.jamiedev.mod.*;

import com.jamiedev.mod.blocks.*;
import com.jamiedev.mod.items.JamiesModItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kyrptonaught.customportalapi.CustomPortalBlock;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static net.minecraft.block.Blocks.DIRT;

public class JamiesModBlocks {

   public static BlockItem createBlockItem(String blockID, Block block){
        return Registry.register(Registries.ITEM, JamiesMod.getModId(blockID), new BlockItem(block, new Item.Settings().fireproof()));
    }

    public static Block createBlockWithItem(String blockID, Block block){
        createBlockItem(blockID, block);
        return Registry.register(Registries.BLOCK, JamiesMod.getModId(blockID), block);
    }
    Blocks blocks; // using this as a reference
    public static final CustomPortalBlock BYGONE_PORTAL = (CustomPortalBlock) registerBlockWithoutBlockItem("bygone_portal",
            new CustomPortalBlock(AbstractBlock.Settings.copy(Blocks.NETHER_PORTAL).luminance((state) -> 6).dropsNothing().noCollision().strength(-1.0f,3600000.0f)), JamiesModItemGroup.JAMIES_MOD );

    public static final Block BYGONESTONE_IRON_ORE = registerBlock("bygonestone_iron_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0),
            AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.0F, 3.0F)), JamiesModItemGroup.JAMIES_MOD);
    public static final Block  BYGONESLATE_IRON_ORE = registerBlock("bygoneslate_iron_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0),
            AbstractBlock.Settings.copyShallow(BYGONESTONE_IRON_ORE).mapColor(MapColor.DEEPSLATE_GRAY).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE)), JamiesModItemGroup.JAMIES_MOD);

    public static final Block  BYGONESTONE_COAL_ORE = registerBlock("bygonestone_coal_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0),
            AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.0F, 3.0F)), JamiesModItemGroup.JAMIES_MOD);
    public static final Block BYGONESLATE_COAL_ORE = registerBlock("bygoneslate_coal_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0),
            AbstractBlock.Settings.copyShallow(BYGONESTONE_COAL_ORE).mapColor(MapColor.DEEPSLATE_GRAY).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE)), JamiesModItemGroup.JAMIES_MOD);

    public static final Block  BYGONESTONE_COPPER_ORE = registerBlock("bygonestone_copper_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0),
            AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.0F, 3.0F)), JamiesModItemGroup.JAMIES_MOD);
    public static final Block BYGONESLATE_COPPER_ORE = registerBlock("bygoneslate_copper_ore", new ExperienceDroppingBlock(ConstantIntProvider.create(0),
            AbstractBlock.Settings.copyShallow(BYGONESTONE_COPPER_ORE).mapColor(MapColor.DEEPSLATE_GRAY).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE)), JamiesModItemGroup.JAMIES_MOD);


    public static final Block JAMIES_BLOCK = createBlockWithItem("jamies_block", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7),
            AbstractBlock.Settings.copy(Blocks.OBSIDIAN).strength(52.0F, 1200.0F).instrument(NoteBlockInstrument.BANJO).pistonBehavior(PistonBehavior.NORMAL)));

    public static final Block LIMBOSTONE = registerBlock("bygonestone",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(0.8F)), JamiesModItemGroup.JAMIES_MOD);

    public static final Block LIMBOSLATE = registerBlock("bygoneslate",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.DEEPSLATE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.0F, 6.0F).sounds(BlockSoundGroup.DEEPSLATE)),  JamiesModItemGroup.JAMIES_MOD);

    public static final Block CLOUD = registerBlock("cloud",
            new TranslucentBlock(AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).strength(0.001F).slipperiness(0.989F).sounds(BlockSoundGroup.WOOL)), JamiesModItemGroup.JAMIES_MOD);

    // Start of the Ancient Forests unique Blocks

    public static  final  Block TALL_GRASS = registerBlock("tall_grass", new UpsidedownTallPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY)), JamiesModItemGroup.JAMIES_MOD);
    public static  final  Block SHORT_GRASS = registerBlock("short_grass", new UpsidedownShortPlantBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XYZ).burnable().pistonBehavior(PistonBehavior.DESTROY)), JamiesModItemGroup.JAMIES_MOD);


 public static  final  Block CAVE_VINES = registerBlockWithoutBlockItem("cave_vines", new AncientCaveVinesHeadBlock(AbstractBlock.Settings.create()
            .mapColor(MapColor.DARK_GREEN).ticksRandomly().noCollision().luminance(CaveVines.getLuminanceSupplier(5)).breakInstantly()
            .sounds(BlockSoundGroup.CAVE_VINES).pistonBehavior(PistonBehavior.DESTROY)), JamiesModItemGroup.JAMIES_MOD);
    public static  final  Block CAVE_VINES_PLANT = registerBlockWithoutBlockItem("cave_vines_plant", new AncientCaveVinesBodyBlock(AbstractBlock.Settings.create()
            .mapColor(MapColor.DARK_GREEN).noCollision().luminance(CaveVines.getLuminanceSupplier(5)).breakInstantly().sounds(BlockSoundGroup.CAVE_VINES)
            .pistonBehavior(PistonBehavior.DESTROY)), JamiesModItemGroup.JAMIES_MOD);

    public static  final Block MONTSECHIA = registerBlock("montsechia", new FlowerBlock(StatusEffects.UNLUCK, 12.0F,AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)), JamiesModItemGroup.JAMIES_MOD);

    public static  final Block POTTED_MONTSECHIA = registerBlockWithoutBlockItem("potted_montsechia", createFlowerPotBlock(MONTSECHIA), JamiesModItemGroup.JAMIES_MOD);
    public static  final Block SAGARIA = registerBlock("sagaria", new FlowerBlock(StatusEffects.LUCK, 12.0F,AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().luminance((state) -> {
     return 13;
    }).breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)), JamiesModItemGroup.JAMIES_MOD);

    public static  final Block POTTED_SAGARIA = registerBlockWithoutBlockItem("potted_sagaria", createFlowerPotBlock(SAGARIA), JamiesModItemGroup.JAMIES_MOD);
    public static  final  Block RAFFLESIA = registerBlock("rafflesia", new RafflesiaBlock(AbstractBlock.Settings.create().mapColor(MapColor.DULL_PINK).breakInstantly().noCollision().luminance((state) -> {
     return 13;
    }).sounds(BlockSoundGroup.SPORE_BLOSSOM).pistonBehavior(PistonBehavior.DESTROY)), JamiesModItemGroup.JAMIES_MOD);

    public static final Block GOURD_LANTERN = registerBlock("gourd_lantern", new LanternBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_DULL_PINK).solid().requiresTool().strength(0.2F).sounds(BlockSoundGroup.SHROOMLIGHT).luminance((state) -> {
        return 15;
    }).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)), JamiesModItemGroup.JAMIES_MOD);

    public static final Block BYSTONE = registerBlock("bystone", new Block(AbstractBlock.Settings.copyShallow(DIRT).strength(2.0F, 3.0F).sounds(BlockSoundGroup.DRIPSTONE_BLOCK)), JamiesModItemGroup.JAMIES_MOD);
    public static final Block CLAYSTONE = registerBlock("claystone", new Block(AbstractBlock.Settings.copyShallow(DIRT).strength(1.0F, 3.0F).sounds(BlockSoundGroup.PACKED_MUD)), JamiesModItemGroup.JAMIES_MOD);
    public static final Block COARSE_CLAYSTONE = registerBlock("coarse_claystone", new Block(AbstractBlock.Settings.copyShallow(DIRT).strength(1.0F, 3.0F).sounds(BlockSoundGroup.PACKED_MUD)), JamiesModItemGroup.JAMIES_MOD);
    public static final Block MOSSY_CLAYSTONE = registerBlock((String)"mossy_claystone", new GrassBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_GREEN).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS)), JamiesModItemGroup.JAMIES_MOD);
    public static final Block GRASSY_CLAYSTONE = registerBlockWithoutBlockItem((String)"grassy_claystone", new GrassBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_GREEN).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRASS)), JamiesModItemGroup.JAMIES_MOD);
    public static final Block ANCIENT_ROOTS = registerBlock("ancient_roots",
            new AncientRootBlock(AbstractBlock.Settings.create().mapColor(MapColor.LICHEN_GREEN).instrument(NoteBlockInstrument.BASS).strength(0.7F).sounds(BlockSoundGroup.MANGROVE_ROOTS).nonOpaque().suffocates(Blocks::never).blockVision(Blocks::never).nonOpaque().burnable()), JamiesModItemGroup.JAMIES_MOD);

    public static final Block ANCIENT_VINE = registerBlock("ancient_vines",
            new VineBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).replaceable().noCollision().ticksRandomly().strength(0.2F).sounds(BlockSoundGroup.VINE).burnable().pistonBehavior(PistonBehavior.DESTROY)),  JamiesModItemGroup.JAMIES_MOD);

    public static final Block ANCIENT_SAPLING = createBlockWithItem("ancient_sapling", new SaplingBlock(new SaplingGenerator(JamiesMod.getModId( "ancient_tree").toString(),
            Optional.empty(),
            Optional.of(JamiesModConfiguredFeatures.ANCIENT_TREE),
            Optional.empty()),AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));
    public static final Block ANCIENT_LOG = registerBlock("ancient_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).strength(2.0f)), JamiesModItemGroup.JAMIES_MOD);
    public static final Block ANCIENT_LEAVES = registerBlock("ancient_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)), JamiesModItemGroup.JAMIES_MOD);
    public static final Block ANCIENT_WOOD = registerBlock("ancient_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).strength(2.0f)), JamiesModItemGroup.JAMIES_MOD);

    public static final Block STRIPPED_ANCIENT_LOG = registerBlock("stripped_ancient_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).strength(2.0f)), JamiesModItemGroup.JAMIES_MOD);

    public static final Block STRIPPED_ANCIENT_WOOD = registerBlock("stripped_ancient_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).strength(2.0f)), JamiesModItemGroup.JAMIES_MOD);

    public static final Block ANCIENT_PLANKS = registerBlock("ancient_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).strength(2.0f)), JamiesModItemGroup.JAMIES_MOD);

    public static final Block ANCIENT_STAIRS = registerBlock("ancient_stairs",
            new StairsBlock(ANCIENT_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).strength(2.0f)), JamiesModItemGroup.JAMIES_MOD);

    public static final Block ANCIENT_SLAB = registerBlock("ancient_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB).strength(2.0f)), JamiesModItemGroup.JAMIES_MOD);

    public static final Block ANCIENT_FENCE = registerBlock("ancient_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE).strength(2.0f)), JamiesModItemGroup.JAMIES_MOD);

    public static final Block ANCIENT_FENCE_GATE = registerBlock("ancient_fence_gate",
            new FenceGateBlock(JamiesModWoodType.ANCIENT, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE).strength(2.0f)), JamiesModItemGroup.JAMIES_MOD);

    public static final Block ANCIENT_DOOR = registerBlock("ancient_door",
            new DoorBlock(JamiesModBlockSetType.ANCIENT, AbstractBlock.Settings.copy(Blocks.OAK_DOOR).strength(2.0f)), JamiesModItemGroup.JAMIES_MOD);

    public static final Block ANCIENT_TRAPDOOR = registerBlock("ancient_trapdoor",
            new TrapdoorBlock(JamiesModBlockSetType.ANCIENT, AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR).strength(2.0f)), JamiesModItemGroup.JAMIES_MOD);

    public static final Block ANCIENT_PRESSURE_PLATE = registerBlock("ancient_pressure_plate",
            new PressurePlateBlock(JamiesModBlockSetType.ANCIENT, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)), JamiesModItemGroup.JAMIES_MOD);
    public static final Block ANCIENT_BUTTON = registerBlock("ancient_button",
            new ButtonBlock(JamiesModBlockSetType.ANCIENT, 30, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)), JamiesModItemGroup.JAMIES_MOD);

    public static final Block ANCIENT_SIGN = registerBlockWithoutBlockItem("ancient_sign",
            new SignBlock(JamiesModWoodType.ANCIENT, AbstractBlock.Settings.copy(Blocks.OAK_SIGN).strength(1.0f).solid()), JamiesModItemGroup.JAMIES_MOD);

    public static final Block ANCIENT_WALL_SIGN = registerBlockWithoutBlockItem("ancient_wall_sign",
            new WallSignBlock(JamiesModWoodType.ANCIENT, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN).strength(1.0f).dropsLike(JamiesModBlocks.ANCIENT_SIGN).solid()), JamiesModItemGroup.JAMIES_MOD);

    public static final Block ANCIENT_HANGING_SIGN = registerBlockWithoutBlockItem("ancient_hanging_sign",
            new HangingSignBlock(JamiesModWoodType.ANCIENT, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).strength(1.0f).solid()), JamiesModItemGroup.JAMIES_MOD);

    public static final Block ANCIENT_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("ancient_wall_hanging_sign",
            new WallHangingSignBlock(JamiesModWoodType.ANCIENT, AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).strength(1.0f).dropsLike(ANCIENT_HANGING_SIGN).solid()), JamiesModItemGroup.JAMIES_MOD);

// Start of the Primordial Ocean blockset

    public static final Block BLUE_ALGAE = registerBlock("blue_algae", new BlueAlgueBlock(AbstractBlock.Settings.create().mapColor(MapColor.LICHEN_GREEN)
            .replaceable().noCollision().strength(0.2F).sounds(BlockSoundGroup.GLOW_LICHEN).luminance((state) -> {
                return 15;
            })
            .burnable().pistonBehavior(PistonBehavior.DESTROY)), JamiesModItemGroup.JAMIES_MOD);

   // public static final Block SEAGRASS = registerBlock("seagrass", new SeagrassBlock(AbstractBlock.Settings.create().mapColor(MapColor.WATER_BLUE).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.WET_GRASS).pistonBehavior(PistonBehavior.DESTROY)), JamiesModItemGroup.JAMIES_MOD);
   // public static final Block TALL_SEAGRASS = registerBlock("tall_seagrass", new TallSeagrassBlock(AbstractBlock.Settings.create().mapColor(MapColor.WATER_BLUE).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.WET_GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)), JamiesModItemGroup.JAMIES_MOD);
    public static final Block OCEANSTONE = registerBlock("oceanstone",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.WATER_BLUE).instrument(NoteBlockInstrument.XYLOPHONE).requiresTool()
                    .strength(0.8F)), JamiesModItemGroup.JAMIES_MOD);

    public static final Block PINK_SAND = registerBlock("primordial_sand",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.RAW_IRON_PINK).sounds(BlockSoundGroup.SAND).instrument(NoteBlockInstrument.XYLOPHONE).requiresTool()
                    .strength(0.1F).luminance((state) -> {
                        return 2;
                    })), JamiesModItemGroup.JAMIES_MOD);

    public static final Block MALACHITE = registerBlock("malachite",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BRIGHT_TEAL).sounds(BlockSoundGroup.AMETHYST_BLOCK).instrument(NoteBlockInstrument.XYLOPHONE).requiresTool()
                    .strength(0.8F)), JamiesModItemGroup.JAMIES_MOD);
    public static final Block MALACHITE_CHISELED = registerBlock("malachite_chiseled",
            new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.BRIGHT_TEAL).sounds(BlockSoundGroup.AMETHYST_BLOCK).instrument(NoteBlockInstrument.XYLOPHONE).requiresTool()
                    .strength(0.8F)), JamiesModItemGroup.JAMIES_MOD);
    public static final Block MALACHITE_PILLAR = registerBlock("malachite_pillar",
            new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.BRIGHT_TEAL).sounds(BlockSoundGroup.AMETHYST_BLOCK).instrument(NoteBlockInstrument.XYLOPHONE).requiresTool()
                    .strength(0.8F)), JamiesModItemGroup.JAMIES_MOD);
    public static final Block MALACHITE_TILE = registerBlock("malachite_tile",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BRIGHT_TEAL).sounds(BlockSoundGroup.AMETHYST_BLOCK).instrument(NoteBlockInstrument.XYLOPHONE).requiresTool()
                    .strength(0.8F)), JamiesModItemGroup.JAMIES_MOD);
    public static final Block MALACHITE_DOOR = registerBlock("malachite_door",
            new DoorBlock(JamiesModBlockSetType.ANCIENT, AbstractBlock.Settings.copy(Blocks.OAK_DOOR).sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(2.0f)), JamiesModItemGroup.JAMIES_MOD);

    private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, JamiesMod.getModId( name), block);
    }


    private static Block registerBlockWithoutBlockItem(String name, Block block, RegistryKey<ItemGroup> group) {
        return Registry.register(Registries.BLOCK, JamiesMod.getModId(name), block);
    }

    private static Item registerBlockItem(String name, Block block, RegistryKey<ItemGroup> group) {

        Item item = Registry.register(Registries.ITEM, JamiesMod.getModId( name),
                new BlockItem(block, new Item.Settings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static Block createFlowerPotBlock(Block flower) {
        return new FlowerPotBlock(flower, AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
    }


    private static boolean always(BlockState p_50775_, BlockPos p_50777_) {
        return true;
    }

    private static boolean never(BlockState p_50806_, BlockPos p_50808_) {
        return false;
    }
    
    public static void init()
    {
        JamiesModStrippableBlocks.registerStrippables();
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> entries.addAfter(Items.LILY_OF_THE_VALLEY, JAMIES_BLOCK));
    }
}
