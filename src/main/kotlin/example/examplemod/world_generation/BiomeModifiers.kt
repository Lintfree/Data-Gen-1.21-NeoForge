package example.examplemod.world_generation

import example.examplemod.ExampleMod
import net.minecraft.core.HolderSet
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BiomeTags
import net.minecraft.world.level.levelgen.GenerationStep
import net.neoforged.neoforge.common.world.BiomeModifier
import net.neoforged.neoforge.common.world.BiomeModifiers
import net.neoforged.neoforge.registries.NeoForgeRegistries

object BiomeModifiers {
	private val ADD_EXAMPLE_ORE: ResourceKey<BiomeModifier> = registerKey("add_example_ore")
//	val ADD_NETHER_ARSENIC_ORE: ResourceKey<BiomeModifier> = registerKey("add_nether_arsenic_ore")
//	val ADD_END_ARSENIC_ORE: ResourceKey<BiomeModifier> = registerKey("add_end_arsenic_ore")
//
//	val ADD_SNAPDRAGON: ResourceKey<BiomeModifier> = registerKey("add_snapdragon")
//	val ADD_TREE_WALNUT: ResourceKey<BiomeModifier> = registerKey("add_tree_walnut")
//	val SPAWN_RHINO: ResourceKey<BiomeModifier> = registerKey("spawn_rhino")
//
//	val ADD_ARSENIC_GEODE: ResourceKey<BiomeModifier> = registerKey("add_arsenic_geode")

	fun bootstrap(context: BootstrapContext<BiomeModifier>) {
		val placedFeatures = context.lookup(Registries.PLACED_FEATURE)
		val biomes = context.lookup(Registries.BIOME)

		context.register(
			ADD_EXAMPLE_ORE, BiomeModifiers.AddFeaturesBiomeModifier(
				biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
				HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.EXAMPLE_ORE_PLACED_KEY)),
				GenerationStep.Decoration.UNDERGROUND_ORES
			)
		)

		//context.register(
		//ADD_NETHER_ARSENIC_ORE, BiomeModifiers.AddFeaturesBiomeModifier(
		//biomes.getOrThrow(BiomeTags.IS_NETHER),
		//HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.NETHER_ARSENIC_ORE_PLACED_KEY)),
		//GenerationStep.Decoration.UNDERGROUND_ORES
		//)
		//)
		/*
				context.register(
					ADD_TREE_WALNUT, BiomeModifiers.AddFeaturesBiomeModifier(
						biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
						HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.WALNUT_PLACED_KEY)),
						GenerationStep.Decoration.VEGETAL_DECORATION
					)
				)

				context.register(
					ADD_END_ARSENIC_ORE, BiomeModifiers.AddFeaturesBiomeModifier(
						biomes.getOrThrow(BiomeTags.IS_END),
						HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.END_ARSENIC_ORE_PLACED_KEY)),
						GenerationStep.Decoration.UNDERGROUND_ORES
					)
				)

				context.register(
					ADD_SNAPDRAGON, BiomeModifiers.AddFeaturesBiomeModifier(
						biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
						HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.SNAPDRAGON_PLACED_KEY)),
						GenerationStep.Decoration.VEGETAL_DECORATION
					)
				)

				context.register(
					SPAWN_RHINO, BiomeModifiers.AddSpawnsBiomeModifier(
						biomes.getOrThrow(Tags.Biomes.IS_DRY_OVERWORLD),
						List.of(SpawnerData(Entities.RHINO.get(), 20, 1, 3))
					)
				)

				context.register(
					ADD_ARSENIC_GEODE, BiomeModifiers.AddFeaturesBiomeModifier(
						biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
						HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.ARSENIC_GEODE_PLACED_KEY)),
						GenerationStep.Decoration.LOCAL_MODIFICATIONS
					)
				)

		 */
	}


	private fun registerKey(name: String): ResourceKey<BiomeModifier> {
		return ResourceKey.create(
			NeoForgeRegistries.Keys.BIOME_MODIFIERS,
			ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, name)
		)
	}
}