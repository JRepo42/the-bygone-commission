package com.jamiedev.mod.init;
import com.jamiedev.mod.JamiesMod;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class JamiesModPortals {

    public static void init() {
        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.CALCITE)
                .customPortalBlock(JamiesModBlocks.BYGONE_PORTAL)
                .destDimID(JamiesMod.getModId("bygone"))
                .tintColor(86, 18, 1)
                .setPortalSearchYRange(0, 120)

                .lightWithItem(JamiesModItems.HOOK)
                .registerIgniteEvent((player, world, portalPos, framePos, portalIgnitionSource) -> {
                    if (portalIgnitionSource.sourceType == PortalIgnitionSource.SourceType.USEITEM && player != null) {
                        if (player.isCreative())
                            return;
                        ItemStack heldItem = player.getMainHandStack().getItem() == JamiesModItems.HOOK ?
                                player.getMainHandStack() : player.getOffHandStack();

                        heldItem.damage(1 , player, player.getPreferredEquipmentSlot(player.getActiveItem()));
                    }
                })
                .registerPortal();
    }
}
