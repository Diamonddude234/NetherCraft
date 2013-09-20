package net.monkeystudios.nc.items;

import net.minecraft.item.Item;
import net.monkeystudios.nc.lib.config.Ids;
import net.monkeystudios.nc.lib.config.Strings;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * NetherCraft
 *
 * Items
 *
 * @author ryalein
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
public class Items {
	
	public static Item netherMachineCore;
	
	public static void init(){
		netherMachineCore = new ItemNetherMachineCore(Ids.NETHERMACHINECORE_ACTUAL);
	}
	
	public static void addNames(){
		LanguageRegistry.addName(netherMachineCore, Strings.NETHERMACHINECORE_NAME);
	}

}
