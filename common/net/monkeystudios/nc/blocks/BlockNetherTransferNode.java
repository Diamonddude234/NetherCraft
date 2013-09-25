package net.monkeystudios.nc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.monkeystudios.nc.NetherCraft;
import net.monkeystudios.nc.lib.ModInfo;
import net.monkeystudios.nc.lib.config.Strings;
import net.monkeystudios.nc.tileentities.TileEntityNetherTransferNode;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * NetherCraft
 *
 * BlockNetherTransferNode
 *
 * @author ryalein
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
public class BlockNetherTransferNode extends BlockContainer{
	private Icon activeIcon;

	public BlockNetherTransferNode(int id) {
		super(id, Material.iron);
		this.setUnlocalizedName(Strings.NETHERTRANSFERNODE_KEY);
		this.setHardness(2F);
		this.setStepSound(Block.soundMetalFootstep);
		this.setCreativeTab(NetherCraft.ncTab);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon){
		blockIcon = icon.registerIcon(ModInfo.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(5)+"_inactive");
		activeIcon = icon.registerIcon(ModInfo.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(5)+"_active");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		return meta == 0 ? blockIcon : activeIcon;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityNetherTransferNode();
	}
}
