package com.jamiedev.mod.items;
import com.jamiedev.mod.JamiesMod;
import com.jamiedev.mod.init.JamiesModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
public class JamiesModItemGroup
{
    public static final RegistryKey<ItemGroup> JAMIES_MOD = RegistryKey.of(RegistryKeys.ITEM_GROUP, JamiesMod.getModId("jamies_mod"));

    public static void registerItemgroups() {
        Registry.register(Registries.ITEM_GROUP, JAMIES_MOD, FabricItemGroup.builder()
                .icon(() -> new ItemStack(JamiesModBlocks.JAMIES_BLOCK))
                .displayName(Text.translatable("itemgroup.jamies_mod"))
                .build());
    }
}
