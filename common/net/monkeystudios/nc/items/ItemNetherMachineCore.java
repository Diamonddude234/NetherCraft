package net.monkeystudios.nc.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.monkeystudios.nc.NetherCraft;
import net.monkeystudios.nc.lib.ModInfo;
import net.monkeystudios.nc.lib.config.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * NetherCraft
 *
 * ItemNethermachineCore
 *
 * @author ryalein
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
public class ItemNetherMachineCore extends Item{
	public ItemNetherMachineCore(int id){
		super(id);
		this.setCreativeTab(NetherCraft.ncTab);
		this.setUnlocalizedName(Strings.NETHERMACHINECORE_KEY);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon){
		itemIcon = icon.registerIcon(ModInfo.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(5));
	}
}
