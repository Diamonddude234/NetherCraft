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
		Ids.NETHERPOWERCORE_ACTUAL = config.getBlock(Configuration.CATEGORY_BLOCK, Strings.NETHERMACHINECORE_KEY, Ids.NETHERPOWERCORE_DEFAULT).getInt();
		Ids.SOULGLASS_ACTUAL = config.getBlock(Configuration.CATEGORY_BLOCK, Strings.SOULGLASS_KEY, Ids.SOULGLASS_DEFAULT).getInt();
		
		// Item IDs Configuration
		Ids.NETHERMACHINECORE_ACTUAL = config.getItem(Configuration.CATEGORY_ITEM, Strings.NETHERMACHINECORE_KEY, Ids.NETHERMACHINECORE_DEFAULT).getInt() - 256;

		config.save();
	}

}
