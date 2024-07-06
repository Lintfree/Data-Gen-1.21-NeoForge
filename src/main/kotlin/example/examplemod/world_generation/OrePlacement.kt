package example.examplemod.world_generation

import net.minecraft.world.level.levelgen.placement.BiomeFilter
import net.minecraft.world.level.levelgen.placement.CountPlacement
import net.minecraft.world.level.levelgen.placement.InSquarePlacement
import net.minecraft.world.level.levelgen.placement.PlacementModifier

object OrePlacement {
	private fun orePlacement(p_195347_: PlacementModifier, p_195348_: PlacementModifier): List<PlacementModifier> {
		return listOf(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome())
	}

	fun commonOrePlacement(pCount: Int, pHeightRange: PlacementModifier): List<PlacementModifier> {
		return orePlacement(CountPlacement.of(pCount), pHeightRange)
	}

//	fun rareOrePlacement(pChance: Int, pHeightRange: PlacementModifier): List<PlacementModifier> {
//		return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange)
//	}
}