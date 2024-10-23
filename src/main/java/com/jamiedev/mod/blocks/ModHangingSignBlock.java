package com.jamiedev.mod.blocks;

import com.jamiedev.mod.blocks.entity.ModHangingSignBlockEntity;
import com.jamiedev.mod.init.JamiesModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.HangingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class ModHangingSignBlock extends HangingSignBlock
{
    public ModHangingSignBlock(WoodType woodType, Settings settings) {
        super(woodType, settings);
    }


    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ModHangingSignBlockEntity(pos, state);
    }
}