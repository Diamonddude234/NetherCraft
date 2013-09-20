package net.monkeystudios.nc.proxies;

import net.minecraftforge.client.MinecraftForgeClient;
import net.monkeystudios.nc.lib.config.Ids;
import net.monkeystudios.nc.renderers.ItemAsBlockRenderer;

/**
 * NetherCraft
 *
 * ClientProxy
 *
 * @author ryalein
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
public class ClientProxy extends CommonProxy {
	
	@Override
	public void initRenderers() {
		MinecraftForgeClient.registerItemRenderer(Ids.NETHERMACHINECORE_ACTUAL+256, new ItemAsBlockRenderer());
	}
	
	@Override
	public void initSounds() {
		
	}

}
