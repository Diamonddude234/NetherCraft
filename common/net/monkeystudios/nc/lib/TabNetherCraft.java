package net.monkeystudios.nc.lib;

import net.minecraft.creativetab.CreativeTabs;
import net.monkeystudios.nc.blocks.Blocks;

/**
 * NetherCraft
 *
 * TabNetherCraft
 *
 * @author ryalein
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
public class TabNetherCraft extends CreativeTabs{

	public TabNetherCraft(int id, String name) {
		super(id, name);
	}

	@Override
	public int getTabIconItemIndex() {
		return Blocks.netherPowerCore.blockID;
	}
}
