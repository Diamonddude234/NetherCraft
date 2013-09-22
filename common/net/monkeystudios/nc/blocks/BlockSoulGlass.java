package net.monkeystudios.nc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.monkeystudios.nc.lib.ModInfo;
import net.monkeystudios.nc.lib.config.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * NetherCraft
 *
 * BlockSoulGlass
 *
 * @author ryalein
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
public class BlockSoulGlass extends BlockBreakable{
	
	private Icon[] icons = new Icon[16];

	protected BlockSoulGlass(int id) {
		super(id, "glass", Material.glass, false);
		this.setUnlocalizedName(Strings.SOULGLASS_KEY);
		this.setHardness(1F);
		this.setStepSound(Block.soundGlassFootstep);
	}

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }
	
	/**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
	@SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, 1 - par5);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon){
		for(int i = 0; i < 16; i++){
			icons[i] = icon.registerIcon(ModInfo.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(5) + i);
		}
		blockIcon = icon.registerIcon(ModInfo.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(5) + "0");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side){
		if(side > 1 && world.getBlockId(x,y+1,z) == this.blockID){
			return icons[2];
		}else if(side > 1 && world.getBlockId(x,y-1,z) == this.blockID){
			return icons[1];
		}
		
		return icons[0];
	}

}
