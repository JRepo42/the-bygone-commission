package com.jamiedev.mod.common.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

import java.util.List;
import java.util.stream.Stream;

public class PrimordialCoralClawFeature extends PrimordialCoralFeature {
    public PrimordialCoralClawFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    protected boolean generateCoral(WorldAccess world, Random random, BlockPos pos, BlockState state) {
        if (!this.generateCoralPiece(world, random, pos, state)) {
            return false;
        } else {
            Direction direction = Direction.Type.HORIZONTAL.random(random);
            int i = random.nextInt(2) + 2;
            List<Direction> list = Util.copyShuffled(Stream.of(direction, direction.rotateYClockwise(), direction.rotateYCounterclockwise()), random);
            List<Direction> list2 = list.subList(0, i);

            for (Direction direction2 : list2) {
                BlockPos.Mutable mutable = pos.mutableCopy();
                int j = random.nextInt(2) + 1;
                mutable.move(direction2);
                int k;
                Direction direction3;
                if (direction2 == direction) {
                    direction3 = direction;
                    k = random.nextInt(3) + 2;
                } else {
                    mutable.move(Direction.UP);
                    Direction[] directions = new Direction[]{direction2, Direction.UP};
                    direction3 = (Direction) Util.getRandom(directions, random);
                    k = random.nextInt(3) + 3;
                }

                int l;
                for (l = 0; l < j && this.generateCoralPiece(world, random, mutable, state); ++l) {
                    mutable.move(direction3);
                }

                mutable.move(direction3.getOpposite());
                mutable.move(Direction.UP);

                for (l = 0; l < k; ++l) {
                    mutable.move(direction);
                    if (!this.generateCoralPiece(world, random, mutable, state)) {
                        break;
                    }

                    if (random.nextFloat() < 0.25F) {
                        mutable.move(Direction.UP);
                    }
                }
            }

            return true;
        }
    }
}
