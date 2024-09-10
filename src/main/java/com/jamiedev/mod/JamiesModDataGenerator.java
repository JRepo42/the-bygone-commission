package com.jamiedev.mod;

import com.jamiedev.mod.init.JamiesModBiomes;
import com.jamiedev.mod.init.JamiesModConfiguredFeatures;
import com.jamiedev.mod.init.JamiesModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import com.jamiedev.mod.datagen.*;


public class JamiesModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(JamiesModBlockTagProvider::new);
		pack.addProvider(JamiesModItemTagProvider::new);
		pack.addProvider(JamiesModLootTableProvider::new);
		pack.addProvider(JamiesModModelProvider::new);
		pack.addProvider(JamiesModRecipeProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, JamiesModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, JamiesModPlacedFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.BIOME, JamiesModBiomes::bootstrap);

		/**registryBuilder.addRegistry(RegistryKeys.PROCESSOR_LIST, JamiesModProcessorLists::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.STRUCTURE_SET, JamiesModStructureSets::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.STRUCTURE, JamiesModStructures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.TEMPLATE_POOL, JamiesModStructurePools::bootstrap);**/
	}
}
