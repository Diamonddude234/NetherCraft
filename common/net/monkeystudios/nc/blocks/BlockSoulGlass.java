package net.monkeystudios.nc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.monkeystudios.nc.NetherCraft;
import net.monkeystudios.nc.lib.ModInfo;
import net.monkeystudios.nc.lib.config.Strings;
import net.monkeystudios.nc.tileentities.TileEntitySoulGlass;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * NetherCraft
 * 
 * BlockSoulGlass
 * 
 * @author ryaleind
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class BlockSoulGlass extends BlockContainer {

	private Icon[] icons = new Icon[16];

	private boolean hasUpperNeighbor, hasLowerNeighbor, hasSouthNeighbor,
			hasNorthNeighbor, hasWestNeighbor, hasEastNeighbor;

	protected BlockSoulGlass(int id) {
		super(id, Material.glass);
		this.setUnlocalizedName(Strings.SOULGLASS_KEY);
		this.setHardness(1F);
		this.setStepSound(Block.soundGlassFootstep);
		this.setCreativeTab(NetherCraft.ncTab);
	}

	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1
	 * for alpha
	 */
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6)
	{
	    TileEntitySoulGlass dummy = (TileEntitySoulGlass)world.getBlockTileEntity(x, y, z);
	     
	    if(dummy != null && dummy.getCore() != null)
	        dummy.getCore().invalidateMultiblock();
	     
	    super.breakBlock(world, x, y, z, par5, par6);
	}

	/**
	 * Returns true if the given side of this block type should be rendered, if
	 * the adjacent block is at the given coordinates. Args: blockAccess, x, y,
	 * z, side
	 */
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, 1 - par5);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		for (int i = 0; i < 16; i++) {
			icons[i] = icon.registerIcon(ModInfo.MOD_ID.toLowerCase() + ":"
					+ this.getUnlocalizedName().substring(5) + i);
		}
		blockIcon = icon.registerIcon(ModInfo.MOD_ID.toLowerCase() + ":"
				+ this.getUnlocalizedName().substring(5) + "0");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side) {
		hasUpperNeighbor = (world.getBlockId(x, y + 1, z) == this.blockID);
		hasLowerNeighbor = (world.getBlockId(x, y - 1, z) == this.blockID);
		hasSouthNeighbor = (world.getBlockId(x, y, z + 1) == this.blockID);
		hasNorthNeighbor = (world.getBlockId(x, y, z - 1) == this.blockID);
		hasEastNeighbor = (world.getBlockId(x + 1, y, z) == this.blockID);
		hasWestNeighbor = (world.getBlockId(x - 1, y, z) == this.blockID);

		if ((side < 2 && hasSouthNeighbor && !hasNorthNeighbor && !hasWestNeighbor && !hasEastNeighbor) || 
		   ((side == 2 || side == 3) && hasLowerNeighbor && !hasUpperNeighbor && !hasWestNeighbor && !hasEastNeighbor) || 
		    (side > 3 && hasLowerNeighbor && !hasUpperNeighbor && !hasNorthNeighbor && !hasSouthNeighbor)) {
			return icons[1];
		} else if ((side < 2 && !hasSouthNeighbor && hasNorthNeighbor && !hasWestNeighbor && !hasEastNeighbor) || 
				  ((side == 2 || side == 3) && !hasLowerNeighbor && hasUpperNeighbor && !hasWestNeighbor && !hasEastNeighbor) || 
				   (side > 3 && !hasLowerNeighbor && hasUpperNeighbor && !hasNorthNeighbor && !hasSouthNeighbor)) {
			return icons[2];
		} else if ((side < 2  && !hasSouthNeighbor && !hasNorthNeighbor && hasWestNeighbor && !hasEastNeighbor) ||
				   (side == 2 && !hasLowerNeighbor && !hasUpperNeighbor && !hasWestNeighbor && hasEastNeighbor) ||
				   (side == 3 && !hasLowerNeighbor && !hasUpperNeighbor && hasWestNeighbor && !hasEastNeighbor) ||
				   (side == 4 && !hasLowerNeighbor && !hasUpperNeighbor && hasNorthNeighbor && !hasSouthNeighbor) ||
				   (side == 5 && !hasLowerNeighbor && !hasUpperNeighbor && !hasNorthNeighbor && hasSouthNeighbor)){
			return icons[3];
		} else if ((side < 2  && !hasSouthNeighbor && !hasNorthNeighbor && !hasWestNeighbor && hasEastNeighbor) ||
				   (side == 2 && !hasLowerNeighbor && !hasUpperNeighbor && hasWestNeighbor && !hasEastNeighbor) ||
				   (side == 3 && !hasLowerNeighbor && !hasUpperNeighbor && !hasWestNeighbor && hasEastNeighbor) ||
				   (side == 4 && !hasLowerNeighbor && !hasUpperNeighbor && !hasNorthNeighbor && hasSouthNeighbor) ||
				   (side == 5 && !hasLowerNeighbor && !hasUpperNeighbor && hasNorthNeighbor && !hasSouthNeighbor)){
			return icons[4];
		} else if ((side < 2  && hasSouthNeighbor && !hasNorthNeighbor && hasWestNeighbor && !hasEastNeighbor) ||
				   (side == 2 && hasLowerNeighbor && !hasUpperNeighbor && !hasWestNeighbor && hasEastNeighbor) ||
				   (side == 3 && hasLowerNeighbor && !hasUpperNeighbor && hasWestNeighbor && !hasEastNeighbor) ||
				   (side == 4 && hasLowerNeighbor && !hasUpperNeighbor && hasNorthNeighbor && !hasSouthNeighbor) ||
				   (side == 5 && hasLowerNeighbor && !hasUpperNeighbor && !hasNorthNeighbor && hasSouthNeighbor)){
			return icons[5];
		} else if ((side < 2  && !hasSouthNeighbor && hasNorthNeighbor && hasWestNeighbor && !hasEastNeighbor) ||
				   (side == 2 && !hasLowerNeighbor && hasUpperNeighbor && !hasWestNeighbor && hasEastNeighbor) ||
				   (side == 3 && !hasLowerNeighbor && hasUpperNeighbor && hasWestNeighbor && !hasEastNeighbor) ||
				   (side == 4 && !hasLowerNeighbor && hasUpperNeighbor && hasNorthNeighbor && !hasSouthNeighbor) ||
				   (side == 5 && !hasLowerNeighbor && hasUpperNeighbor && !hasNorthNeighbor && hasSouthNeighbor)){
			return icons[6];
		} else if ((side < 2  && hasSouthNeighbor && !hasNorthNeighbor && !hasWestNeighbor && hasEastNeighbor) ||
				   (side == 2 && hasLowerNeighbor && !hasUpperNeighbor && hasWestNeighbor && !hasEastNeighbor) ||
				   (side == 3 && hasLowerNeighbor && !hasUpperNeighbor && !hasWestNeighbor && hasEastNeighbor) ||
				   (side == 4 && hasLowerNeighbor && !hasUpperNeighbor && !hasNorthNeighbor && hasSouthNeighbor) ||
				   (side == 5 && hasLowerNeighbor && !hasUpperNeighbor && hasNorthNeighbor && !hasSouthNeighbor)){
			return icons[7];
		} else if ((side < 2  && !hasSouthNeighbor && hasNorthNeighbor && !hasWestNeighbor && hasEastNeighbor) ||
				   (side == 2 && !hasLowerNeighbor && hasUpperNeighbor && hasWestNeighbor && !hasEastNeighbor) ||
				   (side == 3 && !hasLowerNeighbor && hasUpperNeighbor && !hasWestNeighbor && hasEastNeighbor) ||
				   (side == 4 && !hasLowerNeighbor && hasUpperNeighbor && !hasNorthNeighbor && hasSouthNeighbor) ||
				   (side == 5 && !hasLowerNeighbor && hasUpperNeighbor && hasNorthNeighbor && !hasSouthNeighbor)){
			return icons[8];
		} else if ((side < 2 && hasSouthNeighbor && hasNorthNeighbor && !hasWestNeighbor && !hasEastNeighbor) || 
				  ((side == 2 || side == 3) && hasLowerNeighbor && hasUpperNeighbor && !hasWestNeighbor && !hasEastNeighbor) || 
				   (side > 3 && hasLowerNeighbor && hasUpperNeighbor && !hasNorthNeighbor && !hasSouthNeighbor)) {
			return icons[9];
		} else if ((side < 2 && !hasSouthNeighbor && !hasNorthNeighbor && hasWestNeighbor && hasEastNeighbor) || 
				  ((side == 2 || side == 3) && !hasLowerNeighbor && !hasUpperNeighbor && hasWestNeighbor && hasEastNeighbor) || 
				   (side > 3 && !hasLowerNeighbor && !hasUpperNeighbor && hasNorthNeighbor && hasSouthNeighbor)) {
			return icons[10];
		} else if ((side < 2 && !hasSouthNeighbor && hasNorthNeighbor && hasWestNeighbor && hasEastNeighbor) || 
				  ((side == 2 || side == 3) && !hasLowerNeighbor && hasUpperNeighbor && hasWestNeighbor && hasEastNeighbor) || 
				   (side > 3 && !hasLowerNeighbor && hasUpperNeighbor && hasNorthNeighbor && hasSouthNeighbor)) {
			return icons[11];
		} else if ((side < 2 && hasSouthNeighbor && !hasNorthNeighbor && hasWestNeighbor && hasEastNeighbor) || 
				  ((side == 2 || side == 3) && hasLowerNeighbor && !hasUpperNeighbor && hasWestNeighbor && hasEastNeighbor) || 
				   (side > 3 && hasLowerNeighbor && !hasUpperNeighbor && hasNorthNeighbor && hasSouthNeighbor)) {
			return icons[12];
		} else if ((side < 2  && hasSouthNeighbor && hasNorthNeighbor && !hasWestNeighbor && hasEastNeighbor) ||
				   (side == 2 && hasLowerNeighbor && hasUpperNeighbor && hasWestNeighbor && !hasEastNeighbor) ||
				   (side == 3 && hasLowerNeighbor && hasUpperNeighbor && !hasWestNeighbor && hasEastNeighbor) ||
				   (side == 4 && hasLowerNeighbor && hasUpperNeighbor && !hasNorthNeighbor && hasSouthNeighbor) ||
				   (side == 5 && hasLowerNeighbor && hasUpperNeighbor && hasNorthNeighbor && !hasSouthNeighbor)){
			return icons[13];
		} else if ((side < 2  && hasSouthNeighbor && hasNorthNeighbor && hasWestNeighbor && !hasEastNeighbor) ||
				   (side == 2 && hasLowerNeighbor && hasUpperNeighbor && !hasWestNeighbor && hasEastNeighbor) ||
				   (side == 3 && hasLowerNeighbor && hasUpperNeighbor && hasWestNeighbor && !hasEastNeighbor) ||
				   (side == 4 && hasLowerNeighbor && hasUpperNeighbor && hasNorthNeighbor && !hasSouthNeighbor) ||
				   (side == 5 && hasLowerNeighbor && hasUpperNeighbor && !hasNorthNeighbor && hasSouthNeighbor)){
			return icons[14];
		} else if ((side < 2 && hasSouthNeighbor && hasNorthNeighbor && hasWestNeighbor && hasEastNeighbor) || 
				  ((side == 2 || side == 3) && hasLowerNeighbor && hasUpperNeighbor && hasWestNeighbor && hasEastNeighbor) || 
				   (side > 3 && hasLowerNeighbor && hasUpperNeighbor && hasNorthNeighbor && hasSouthNeighbor)) {
			return icons[15];
		} else {
			return icons[0];
		}	
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntitySoulGlass();
	}
}
