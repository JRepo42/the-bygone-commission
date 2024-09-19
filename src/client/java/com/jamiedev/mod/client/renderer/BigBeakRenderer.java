package com.jamiedev.mod.client.renderer;

import com.jamiedev.mod.JamiesMod;
import com.jamiedev.mod.client.JamiesModModelLayers;
import com.jamiedev.mod.client.models.BigBeakModel;
import com.jamiedev.mod.entities.BigBeakEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class BigBeakRenderer  extends MobEntityRenderer<BigBeakEntity, BigBeakModel<BigBeakEntity>> {
    private static final Identifier TEXTURE = JamiesMod.getModId("textures/entity/big_beak.png");

    public BigBeakRenderer(EntityRendererFactory.Context context) {
        super(context, new BigBeakModel(context.getPart(JamiesModModelLayers.BIG_BEAK)), 0.3F);
    }

    public Identifier getTexture(BigBeakEntity chickenEntity) {
        return TEXTURE;
    }

    protected float getAnimationProgress(BigBeakEntity chickenEntity, float f) {
      //  float g = MathHelper.lerp(f, chickenEntity.prevFlapProgress, chickenEntity.flapProgress);
      //  float h = MathHelper.lerp(f, chickenEntity.prevMaxWingDeviation, chickenEntity.maxWingDeviation);
      //  return (MathHelper.sin(g) + 1.0F) * h;
        return f;
    }
}
