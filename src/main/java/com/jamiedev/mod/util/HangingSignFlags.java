package com.jamiedev.mod.util;

import net.minecraft.block.entity.BlockEntityType;

public class HangingSignFlags {
    static BlockEntityType<?> BE_TYPE_FLAG = null;
    public static void removeBETypeFlag() {
        BE_TYPE_FLAG = null;
    }
    public static void setBETypeFlag(BlockEntityType<?> blockEntityType) {
        BE_TYPE_FLAG = blockEntityType;
    }
    public static BlockEntityType<?> getBETypeFlag() {
        return BE_TYPE_FLAG;
    }
}