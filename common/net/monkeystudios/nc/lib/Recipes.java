package net.monkeystudios.nc.lib;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.monkeystudios.nc.items.Items;

/**
 * NetherCraft
 *
 * Reipes
 *
 * @author ryalein
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
public class Recipes {

	public static void init(){
		
		CraftingManager.getInstance().addRecipe(new ItemStack(Items.netherMachineCore, 1),
				"NBN",
				"BMB",
				"NBN",
				'N', Item.netherrackBrick, 'B', Item.blazeRod, 'M', Item.magmaCream);
	}
}
