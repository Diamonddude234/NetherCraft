package net.monkeystudios.nc.lib.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

/**
 * NetherCraft
 *
 * ConfigHandler
 *
 * @author ryalein
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
public class ConfigHandler {
	
	public static void init(File configFile){
		Configuration config = new Configuration(configFile);
		
		config.load();
		
		// Block IDs Configuration
		Ids.NETHERPOWERCORE_ACTUAL = config.getBlock(Configuration.CATEGORY_BLOCK, Strings.NETHERMACHINECORE_UNLOCALIZED_NAME, Ids.NETHERPOWERCORE_DEFAULT).getInt();
		
		
		// Item IDs Configuration
		Ids.NETHERMACHINECORE_ACTUAL = config.getItem(Configuration.CATEGORY_ITEM, Strings.NETHERMACHINECORE_UNLOCALIZED_NAME, Ids.NETHERMACHINECORE_DEFAULT).getInt() - 256;

		config.save();
	}

}