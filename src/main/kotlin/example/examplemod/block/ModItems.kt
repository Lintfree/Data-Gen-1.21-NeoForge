package example.examplemod.block

import example.examplemod.ExampleMod
import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister

object ModItems {
	val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(ExampleMod.MOD_ID)

	/** If you get an "overload resolution ambiguity" error, include the arrow at the start of the closure.
	 *  Register items (not placeable in the world)
	 */
	val EXAMPLE_ITEM: DeferredItem<Item> = ITEMS.register("example_item") { ->
		Item(Item.Properties().stacksTo(64))
	}
}