package net.monkeystudios.nc.blocks;

import net.minecraft.block.Block;
import net.monkeystudios.nc.lib.config.Ids;
import net.monkeystudios.nc.lib.config.Strings;
import net.monkeystudios.nc.tileentities.TileEntityNetherPowerCore;
import net.monkeystudios.nc.tileentities.TileEntityNetherStructureCasing;
import net.monkeystudios.nc.tileentities.TileEntityNetherTransferNode;
import net.monkeystudios.nc.tileentities.TileEntitySoulGlass;
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
	public static Block netherTransferNode;
	public static Block netherStructureCasing;
	
	public static void init(){
		netherPowerCore = new BlockNetherPowerCore(Ids.NETHERPOWERCORE_ACTUAL);		
		GameRegistry.registerBlock(netherPowerCore, Strings.NETHERPOWERCORE_KEY);
		
		soulGlass = new BlockSoulGlass(Ids.SOULGLASS_ACTUAL);
		GameRegistry.registerBlock(soulGlass, Strings.SOULGLASS_NAME);
		
		netherTransferNode = new BlockNetherTransferNode(Ids.NETHERTRANSFERNODE_ACTUAL);
		GameRegistry.registerBlock(netherTransferNode, Strings.NETHERTRANSFERNODE_KEY);
		
		netherStructureCasing = new BlockNetherStructureCasing(Ids.NETHERSTRUCTURECASING_ACTUAL);
		GameRegistry.registerBlock(netherStructureCasing, Strings.NETHERSTRUCTURECASING_KEY);
	}
	
	public static void addNames(){
		LanguageRegistry.addName(netherPowerCore, Strings.NETHERPOWERCORE_NAME);
		LanguageRegistry.addName(soulGlass, Strings.SOULGLASS_NAME);
		LanguageRegistry.addName(netherTransferNode, Strings.NETHERTRANSFERNODE_NAME);
		LanguageRegistry.addName(netherStructureCasing, Strings.NETHERSTRUCTURECASING_NAME);
	}
	
	public static void registerTileEntities(){
		GameRegistry.registerTileEntity(TileEntityNetherPowerCore.class, Strings.NETHERPOWERCORE_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityNetherTransferNode.class, Strings.NETHERTRANSFERNODE_TE_KEY);
		GameRegistry.registerTileEntity(TileEntitySoulGlass.class, Strings.SOULGLASS_TE_KEY);
		GameRegistry.registerTileEntity(TileEntityNetherStructureCasing.class, Strings.NETHERSTRUCTURECASING_TE_KEY);
	}

}
