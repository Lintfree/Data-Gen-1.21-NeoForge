package example.examplemod.world_generation

import example.examplemod.ExampleMod
import example.examplemod.block.ModBlocks
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.TargetBlockState
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest

// TODO: clean up to make it more readable
object ConfiguredFeatures {
	val OVERWORLD_EXAMPLE_ORE_KEY: ResourceKey<ConfiguredFeature<*, *>> = registerKey("example_ore")
	//val NETHER_ARSENIC_ORE_KEY: ResourceKey<ConfiguredFeature<*, *>> = registerKey("nether_arsenic_ore")
	//val END_ARSENIC_ORE_KEY: ResourceKey<ConfiguredFeature<*, *>> = registerKey("end_arsenic_ore")
	//val SNAPDRAGON_KEY: ResourceKey<ConfiguredFeature<*, *>> = registerKey("snapdragon")
	//val ARSENIC_GEODE_KEY: ResourceKey<ConfiguredFeature<*, *>> = registerKey("arsenic_geode")
	//val WALNUT_KEY: ResourceKey<ConfiguredFeature<*, *>> = registerKey("walnut")

	fun bootstrap(context: BootstrapContext<ConfiguredFeature<*, *>>) {
		val stoneReplaceabeles: RuleTest = TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES)
		val deepslateReplaceabeles: RuleTest = TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
		//val netherrackReplaceabeles: RuleTest = BlockMatchTest(Blocks.NETHERRACK)
		//val endReplaceabeles: RuleTest = BlockMatchTest(Blocks.END_STONE)

		val overworldExampleOres = listOf(
			OreConfiguration.target(
				stoneReplaceabeles,
				ModBlocks.EXAMPLE_ORE.get().defaultBlockState()
			),
			OreConfiguration.target(
				deepslateReplaceabeles,
				ModBlocks.EXAMPLE_ORE.get().defaultBlockState()
			)
		)

		register<OreConfiguration, Feature<OreConfiguration>>(
			context,
			OVERWORLD_EXAMPLE_ORE_KEY,
			Feature.ORE,
			OreConfiguration(overworldExampleOres, 9)
		)
//		net.kaupenjoe.mccourse.worldgen.ModConfiguredFeatures.register(
//			context,
//			net.kaupenjoe.mccourse.worldgen.ModConfiguredFeatures.NETHER_ALEXANDRITE_ORE_KEY,
//			Feature.ORE,
//			new OreConfiguration netherrackReplaceabeles,



		//register<OreConfiguration, Feature<OreConfiguration>>(
		//context, NETHER_ARSENIC_ORE_KEY, Feature.ORE, OreConfiguration(
		//	netherrackReplaceabeles,
		//	ArsenicBlocks.NETHER_ARSENIC_ORE.get().defaultBlockState(), 9
		//)

		/*
				register<OreConfiguration, Feature<OreConfiguration>>(
					context, END_ARSENIC_ORE_KEY, Feature.ORE, OreConfiguration(
						endReplaceabeles,
						ArsenicBlocks.END_STONE_ARSENIC_ORE.get().defaultBlockState(), 9
					)
				)

				register<TreeConfiguration, Feature<TreeConfiguration>>(
					context, WALNUT_KEY, Feature.TREE, TreeConfigurationBuilder(
						BlockStateProvider.simple(ArsenicBlocks.WALNUT_LOG.get()),
						WalnutTrunkPlacer(5, 4, 3),
						BlockStateProvider.simple(ArsenicBlocks.WALNUT_LEAVES.get()),
						WalnutFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
						TwoLayersFeatureSize(1, 0, 2)
					).dirt(
						BlockStateProvider.simple(
							Blocks.END_STONE
						)
					).build()
				)

				register<RandomPatchConfiguration, Feature<RandomPatchConfiguration>>(
					context, SNAPDRAGON_KEY, Feature.FLOWER,
					RandomPatchConfiguration(
						32, 6, 2, PlacementUtils.onlyWhenEmpty<SimpleBlockConfiguration, Feature<SimpleBlockConfiguration>>(
							Feature.SIMPLE_BLOCK,
							SimpleBlockConfiguration(BlockStateProvider.simple(ArsenicBlocks.SNAPDRAGON.get()))
						)
					)
				)

				register<GeodeConfiguration, Feature<GeodeConfiguration>>(
					context, ARSENIC_GEODE_KEY, Feature.GEODE,
					GeodeConfiguration(
						GeodeBlockSettings(
							BlockStateProvider.simple(
								Blocks.AIR
							),
							BlockStateProvider.simple(Blocks.DEEPSLATE),
							BlockStateProvider.simple(ArsenicBlocks.ARSENIC_ORE.get()),
							BlockStateProvider.simple(Blocks.DIRT),
							BlockStateProvider.simple(Blocks.EMERALD_BLOCK),
							List.of(ArsenicBlocks.ARSENIC_BLOCK.get().defaultBlockState()),
							BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS
						),
						GeodeLayerSettings(1.7, 1.2, 2.5, 3.5),
						GeodeCrackSettings(0.25, 1.5, 1), 0.5, 0.1,
						true, UniformInt.of(3, 8),
						UniformInt.of(2, 6), UniformInt.of(1, 2),
						- 18, 18, 0.075, 1
					)
				)
		 */
	}


	private fun registerKey(name: String?): ResourceKey<ConfiguredFeature<*, *>> {
		return ResourceKey.create(
			Registries.CONFIGURED_FEATURE,
			ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, name)
		)
	}
	private fun <FC : FeatureConfiguration?, F : Feature<FC>?> register(
		context: BootstrapContext<ConfiguredFeature<*, *>>,
		key: ResourceKey<ConfiguredFeature<*, *>>, feature: F & Any, configuration: FC & Any
	): TargetBlockState? {
		context.register(key, ConfiguredFeature(feature, configuration))
		return null}
}