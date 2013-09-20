package net.monkeystudios.nc.lib;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

/**
 * NetherCraft
 *
 * LogHelper
 *
 * @author ryalein
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
public class LogHelper {
	
	private static Logger logger = Logger.getLogger(ModInfo.MOD_ID);

	public static void init(){
		logger.setParent(FMLLog.getLogger());
	}
	
	public static void log(Level logLevel, String message){
		logger.log(logLevel, message);
	}
}
