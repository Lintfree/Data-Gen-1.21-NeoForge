package example.examplemod.block

import example.examplemod.ExampleMod
import net.minecraft.util.valueproviders.UniformInt
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.DropExperienceBlock
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister

/**
 * Register blocks (placeable in the world).
 * Take note how the block is also registered as an item
 * If you get an "overload resolution ambiguity" error, include the arrow at the start of the closure.
 * Even though block_item and ore_item are greyed out and say not used, they are still used when game runs.
 * Block properties can be customized or copied from another block
*/

object ModBlocks {
    val REGISTER_BLOCKS: DeferredRegister.Blocks = DeferredRegister.createBlocks(ExampleMod.MOD_ID)
    val REGISTER_BLOCK_ITEMS: DeferredRegister.Items = DeferredRegister.createItems(ExampleMod.MOD_ID)

    val EXAMPLE_BLOCK: DeferredBlock<Block> = REGISTER_BLOCKS.register("example_block") { ->
        Block(BlockBehaviour.Properties.of()
            .lightLevel { 15 }
            .strength(3.0f, 6.0f)
            .requiresCorrectToolForDrops())
    }

    val EXAMPLE_BLOCK_ITEM: DeferredItem<BlockItem> = REGISTER_BLOCK_ITEMS.register("example_block") { ->
        BlockItem(EXAMPLE_BLOCK.get(), Item.Properties().stacksTo(64))
    }

    val EXAMPLE_ORE: DeferredBlock<Block> = REGISTER_BLOCKS.register("example_ore") { ->
        DropExperienceBlock(
            UniformInt.of(8, 15),
            BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_ORE))
    }

    val EXAMPLE_ORE_ITEM: DeferredItem<BlockItem> = REGISTER_BLOCK_ITEMS.register("example_ore") { ->
        BlockItem(EXAMPLE_ORE.get(), Item.Properties().stacksTo(64))
    }
}
