package example.examplemod.world_generation

import example.examplemod.ExampleMod
import net.minecraft.core.Holder
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.levelgen.VerticalAnchor
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.minecraft.world.level.levelgen.placement.PlacementModifier

object PlacedFeatures {

	val EXAMPLE_ORE_PLACED_KEY: ResourceKey<PlacedFeature> = registerKey("example_ore_placed")

//	val NETHER_ARSENIC_ORE_PLACED_KEY: ResourceKey<PlacedFeature> = registerKey("nether_arsenic_ore_placed")
//	val WALNUT_PLACED_KEY: ResourceKey<PlacedFeature> = registerKey("walnut_placed")
//	val END_ARSENIC_ORE_PLACED_KEY: ResourceKey<PlacedFeature> = registerKey("end_ARSENIC_ore_placed")
//	val SNAPDRAGON_PLACED_KEY: ResourceKey<PlacedFeature> = registerKey("snapdragon_placed")
//	val ARSENIC_GEODE_PLACED_KEY: ResourceKey<PlacedFeature> = registerKey("ARSENIC_geode_placed")

	fun bootstrap(context: BootstrapContext<PlacedFeature>) {
		val configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE)

		register(
			context,
			EXAMPLE_ORE_PLACED_KEY,
			configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_EXAMPLE_ORE_KEY),
			OrePlacement.commonOrePlacement(
				12,
				HeightRangePlacement.uniform(VerticalAnchor.absolute(- 64), VerticalAnchor.absolute(80))
			)
		)
/*		register(
			context,
			NETHER_ARSENIC_ORE_PLACED_KEY,
			configuredFeatures.getOrThrow(ConfiguredFeatures.NETHER_ARSENIC_ORE_KEY),
			OrePlacement.commonOrePlacement(
			9,
			HeightRangePlacement.uniform(VerticalAnchor.absolute(- 64), VerticalAnchor.absolute(80))
			)
		)
	}
			register(
				context, WALNUT_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.WALNUT_KEY),
				VegetationPlacements.treePlacement(
					PlacementUtils.countExtra(3, 0.1f, 2),
					Blocks.WALNUT_SAPLING.get()
				)
			)
			register(
				context,
				END_ARSENIC_ORE_PLACED_KEY,
				configuredFeatures.getOrThrow(ModConfiguredFeatures.END_ARSENIC_ORE_KEY),
				ModOrePlacement.commonOrePlacement(
					7,
					HeightRangePlacement.uniform(VerticalAnchor.absolute(- 64), VerticalAnchor.absolute(80))
				)
			)

			register(
				context, SNAPDRAGON_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SNAPDRAGON_KEY),
				java.util.List.of<PlacementModifier>(
					RarityFilter.onAverageOnceEvery(16),
					InSquarePlacement.spread(),
					PlacementUtils.HEIGHTMAP,
					BiomeFilter.biome()
				)
			)


			register(
				context,
				ARSENIC_GEODE_PLACED_KEY,
				configuredFeatures.getOrThrow(ModConfiguredFeatures.ARSENIC_GEODE_KEY),
				java.util.List.of<PlacementModifier>(
					RarityFilter.onAverageOnceEvery(50), InSquarePlacement.spread(),
					HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(50)),
					BiomeFilter.biome()
				)
			)

		 */
		}


	private fun registerKey(name: String): ResourceKey<PlacedFeature> {
		return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, name))
	}

	private fun register(
		context: BootstrapContext<PlacedFeature>,
		key: ResourceKey<PlacedFeature>,
		configuration: Holder<ConfiguredFeature<*, *>>,
		modifiers: List<PlacementModifier>
	) {
		context.register(key, PlacedFeature(configuration, java.util.List.copyOf(modifiers)))
	}
}
