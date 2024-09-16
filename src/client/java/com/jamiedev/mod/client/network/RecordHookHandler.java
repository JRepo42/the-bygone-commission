package com.jamiedev.mod.client.network;


import com.jamiedev.mod.entities.projectile.HookEntity;
import com.jamiedev.mod.init.JamiesModEntityTypes;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.client.MinecraftClient;

import java.util.function.Supplier;
public class RecordHookHandler {

    public static void handle(Supplier<Supplier<MinecraftClient>> minecraft, RecordHookPacket packet) {
        ClientWorld level = minecraft.get().get().world;
        if(level == null) {
            return;
        }
        HookEntity entity = JamiesModEntityTypes.HOOK.create(level);
        if (entity == null) {
            return;
        }
        entity.setVelocity(packet.x(), packet.y(), packet.z());
        entity.setPos(packet.x(), packet.y(), packet.z());
        entity.offsetX(packet.xRot());
        entity.getRotationVec(packet.yRot());
        entity.setId(packet.id());
        entity.setUuid(packet.uuid());
        /** NO IDEA IDK
         * 		entity.syncPacketPositionCodec(packet.x(), packet.y(), packet.z());
         * 		entity.setPosRaw(packet.x(), packet.y(), packet.z());
         * 		entity.setXRot(packet.xRot());
         * 		entity.getViewYRot(packet.yRot());
         * 		entity.setId(packet.id());
         * 		entity.setUUID(packet.uuid());
         */

        if(packet.hasGrapplingPlayer() && level.getEntityById(packet.grapplingPlayerId()) instanceof PlayerEntity player) {
            entity.setOwner(player);
        }
        //level.place(packet.id(), entity);
    }
}
