package com.jamiedev.mod.blocks;

import com.jamiedev.mod.JamiesMod;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.block.BlockSetType;

public class JamiesModBlockSetType
{
    public static final BlockSetType ANCIENT = BlockSetTypeBuilder.copyOf(BlockSetType.WARPED).register(
            JamiesMod.getModId("ancient"));

    public void init() {
    }
}
