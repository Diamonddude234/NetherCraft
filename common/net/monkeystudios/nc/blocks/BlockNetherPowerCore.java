package net.monkeystudios.nc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.monkeystudios.nc.lib.ModInfo;
import net.monkeystudios.nc.lib.config.Strings;
import net.monkeystudios.nc.tileentities.TileEntityNetherPowerCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * NetherCraft
 *
 * BlockNetherPowerCore
 *
 * @author ryalein
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
public class BlockNetherPowerCore extends BlockContainer{

	public BlockNetherPowerCore(int id) {
		super(id, Material.iron);
		this.setUnlocalizedName(Strings.NETHERPOWERCORE_UNLOCALIZED_NAME);
		this.setHardness(2F);
		this.setStepSound(Block.soundMetalFootstep);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon){
		blockIcon = icon.registerIcon(ModInfo.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(5));
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityNetherPowerCore();
	}	
}
