package net.monkeystudios.nc;

import java.util.logging.Level;

import net.minecraft.creativetab.CreativeTabs;
import net.monkeystudios.nc.blocks.Blocks;
import net.monkeystudios.nc.items.Items;
import net.monkeystudios.nc.lib.LogHelper;
import net.monkeystudios.nc.lib.ModInfo;
import net.monkeystudios.nc.lib.Recipes;
import net.monkeystudios.nc.lib.TabNetherCraft;
import net.monkeystudios.nc.lib.config.ConfigHandler;
import net.monkeystudios.nc.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * NetherCraft
 *
 * NetherCraft
 *
 * @author ryalein
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */

@Mod(modid = ModInfo.MOD_ID, name=ModInfo.MOD_NAME, version=ModInfo.VERSION_NUMBER)
@NetworkMod(channels={ModInfo.CHANNEL_NAME}, clientSideRequired=true, serverSideRequired=true)
public class NetherCraft {
	
	public static CreativeTabs ncTab = new TabNetherCraft(CreativeTabs.getNextID(), ModInfo.MOD_NAME);

	@EventHandler
	public static void preInit( FMLPreInitializationEvent event ) {
		LogHelper.init();
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		proxy.initRenderers();
		proxy.initSounds();
	}

	@EventHandler
	public static void init( FMLInitializationEvent event ) {
		LogHelper.log(Level.INFO, "Preparing items");
		Items.init();
		Items.addNames();
		LogHelper.log(Level.INFO, "Items loaded");
		
		LogHelper.log(Level.INFO, "Preparing blocks");
		Blocks.init();
		Blocks.addNames();
		Blocks.registerTileEntities();
		LogHelper.log(Level.INFO, "Blocks loaded");
		
		LogHelper.log(Level.INFO, "Preparing recipes");
		Recipes.init();
		LogHelper.log(Level.INFO, "Recipes loaded");
		
		LanguageRegistry.instance().addStringLocalization("itemGroup." + ModInfo.MOD_NAME, "en_US", ModInfo.MOD_NAME);
	}

	@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) {

	}
	
	@SidedProxy( clientSide = ModInfo.CLIENT_PROXY_CLASS, serverSide = ModInfo.SERVER_PROXY_CLASS )
	public static CommonProxy proxy;
}
