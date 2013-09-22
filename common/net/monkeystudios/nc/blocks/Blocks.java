package net.monkeystudios.nc.blocks;

import net.minecraft.block.Block;
import net.monkeystudios.nc.lib.config.Ids;
import net.monkeystudios.nc.lib.config.Strings;
import net.monkeystudios.nc.tileentities.TileEntityNetherPowerCore;
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
	public static Block soulGlass;
	
	public static void init(){
		netherPowerCore = new BlockNetherPowerCore(Ids.NETHERPOWERCORE_ACTUAL);		
		GameRegistry.registerBlock(netherPowerCore, Strings.NETHERPOWERCORE_KEY);
		
		soulGlass = new BlockSoulGlass(Ids.SOULGLASS_ACTUAL);
		GameRegistry.registerBlock(soulGlass, Strings.SOULGLASS_NAME);
	}
	
	public static void addNames(){
		LanguageRegistry.addName(netherPowerCore, Strings.NETHERPOWERCORE_NAME);
		LanguageRegistry.addName(soulGlass, Strings.SOULGLASS_NAME);
	}
	
	public static void registerTileEntities(){
		GameRegistry.registerTileEntity(TileEntityNetherPowerCore.class, Strings.NETHERPOWERCORE_TE_KEY);
	}

}
