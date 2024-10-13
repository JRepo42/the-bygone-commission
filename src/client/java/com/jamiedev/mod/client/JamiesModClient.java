package com.jamiedev.mod.client;

import com.jamiedev.mod.JamiesMod;
import com.jamiedev.mod.blocks.JamiesModWoodType;
import com.jamiedev.mod.client.particles.BlemishParticle;
import com.jamiedev.mod.client.particles.RafflesiaSporeParticle;
import com.jamiedev.mod.init.*;
import com.jamiedev.mod.network.SyncPlayerHookS2C;
import com.jamiedev.mod.client.network.SyncPlayerHookPacketHandler;
import com.jamiedev.mod.util.PlayerWithHook;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.particle.SoulParticle;
import net.minecraft.client.render.RenderLayer;
import com.jamiedev.mod.client.renderer.*;
import com.jamiedev.mod.client.models.*;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;

public class JamiesModClient implements ClientModInitializer {
    public static Identifier BYGONE = JamiesMod.getModId("bygone");
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.CLOUD, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.BYGONE_PORTAL, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.ANCIENT_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.ANCIENT_ROOTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.ANCIENT_VINE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.CHARNIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.GOURD_LANTERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.RAFFLESIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.CAVE_VINES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.CAVE_VINES_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.MONTSECHIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.SAGARIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.ANCIENT_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.ANCIENT_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.POTTED_MONTSECHIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.POTTED_SAGARIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.SHORT_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.TALL_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.BLUE_ALGAE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.MALACHITE_DOOR, RenderLayer.getCutout());


        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.CRINOID, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.PRIMORDIAL_URCHIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.PRIMORDIAL_VENT, RenderLayer.getCutout());


        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.DEAD_ORANGE_CORAL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.DEAD_ORANGE_CORAL_WALL_FAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.DEAD_ORANGE_CORAL_FAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.ORANGE_CORAL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.ORANGE_CORAL_FAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.ORANGE_CORAL_WALL_FAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.DEAD_BLUE_CORAL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.DEAD_BLUE_CORAL_WALL_FAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.DEAD_BLUE_CORAL_FAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.BLUE_CORAL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.BLUE_CORAL_FAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(JamiesModBlocks.BLUE_CORAL_WALL_FAN, RenderLayer.getCutout());

        EntityRendererRegistry.register(JamiesModEntityTypes.COELACANTH, CoelacanthRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(JamiesModModelLayers.COELACANTH, CoelacanthModel::getTexturedModelData);

        EntityRendererRegistry.register(JamiesModEntityTypes.DUCK, DuckieRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(JamiesModModelLayers.DUCKIE, DuckieModel::getTexturedModelData);

        EntityRendererRegistry.register(JamiesModEntityTypes.GLARE, GlareRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(JamiesModModelLayers.GLARE, GlareModel::getTexturedModelData);

        EntityRendererRegistry.register(JamiesModEntityTypes.JAWS, JawsRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(JamiesModModelLayers.JAWS, JawsEntityModel::getTexturedModelData);

        EntityRendererRegistry.register(JamiesModEntityTypes.SCUTTLE, ScuttleRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(JamiesModModelLayers.SCUTTLE, ScuttleModel::getTexturedModelData);

        EntityRendererRegistry.register(JamiesModEntityTypes.HOOK, HookRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(JamiesModModelLayers.SCUTTLE_SPIKE, ScuttleSpikeModel::getTexturedModelData);
        EntityRendererRegistry.register(JamiesModEntityTypes.SCUTTLE_SPIKE, ScuttleSpikeRenderer::new);

        EntityRendererRegistry.register(JamiesModEntityTypes.TRILOBITE, TrilobiteRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(JamiesModModelLayers.TRILOBITE, TrilobiteModel::getTexturedModelData);

        EntityRendererRegistry.register(JamiesModEntityTypes.BIG_BEAK, BigBeakRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(JamiesModModelLayers.BIG_BEAK, BigBeakModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(JamiesModModelLayers.BIG_BEAK_SADDLE, BigBeakModel::getTexturedModelData);

        ParticleFactoryRegistry.getInstance().register(JamiesModParticleTypes.BLEMISH, BlemishParticle.BlemishBlockProvider::new);
        ParticleFactoryRegistry.getInstance().register(JamiesModParticleTypes.RAFFLESIA_SPORES, RafflesiaSporeParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(JamiesModParticleTypes.ALGAE_BLOOM, SoulParticle.SculkSoulFactory::new);

        DimensionRenderingRegistry.registerDimensionEffects(BYGONE, BygoneDimensionEffects.INSTANCE);

        registerModelPredicateProviders();

        ClientPlayNetworking.registerGlobalReceiver(SyncPlayerHookS2C.PACkET_ID, (payload, context) -> {
            context.client().execute(() -> SyncPlayerHookPacketHandler.handle(payload, context));
        });

        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(JamiesModWoodType.ANCIENT, TexturedRenderLayers.getSignTextureId(JamiesModWoodType.ANCIENT));
        BlockEntityRendererFactories.register(JamiesModBlockEntities.MOD_SIGN_BLOCK_ENTITY, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(JamiesModBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY, HangingSignBlockEntityRenderer::new);
    }
    public static void registerModelPredicateProviders() {
        ModelPredicateProviderRegistry.register(JamiesModItems.HOOK, JamiesMod.getModId("deployed"), (itemStack, clientWorld, livingEntity, seed) -> {
            if (livingEntity instanceof PlayerEntity) {
                for (Hand value : Hand.values())
                {
                    ItemStack heldStack = livingEntity.getStackInHand(value);

                    if (heldStack == itemStack && (((PlayerWithHook)livingEntity).jamiesmod$getHook()  != null && !((PlayerWithHook)livingEntity).jamiesmod$getHook().isRemoved()))
                    {
                        return 1;
                    }
                }
            }
            if (livingEntity == null)
            {
                return 0.0F;
            }
            return 0;
        });
    }


}
