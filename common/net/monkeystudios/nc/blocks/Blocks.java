package net.monkeystudios.nc.blocks;

import net.minecraft.block.Block;
import net.monkeystudios.nc.lib.config.Ids;
import net.monkeystudios.nc.lib.config.Strings;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * NetherCraft
 *
 * Blocks
 *
 * @author ryalein
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
public class Blocks {
	
	public static Block netherPowerCore;
	
	public static void init(){
		netherPowerCore = new BlockNetherPowerCore(Ids.NETHERPOWERCORE_ACTUAL);		
		GameRegistry.registerBlock(netherPowerCore, Strings.NETHERPOWERCORE_UNLOCALIZED_NAME);
	}
	
	public static void addNames(){
		LanguageRegistry.addName(netherPowerCore, Strings.NETHERPOWERCORE_NAME);
	}

}
