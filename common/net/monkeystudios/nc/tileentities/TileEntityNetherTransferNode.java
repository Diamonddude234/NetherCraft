package net.monkeystudios.nc.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * NetherCraft
 *
 * TileEntityNetherTransferNode
 *
 * @author ryalein
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
public class TileEntityNetherTransferNode extends TileEntity{
	
	private boolean isDummy;
	
	public TileEntityNetherTransferNode(){
		isDummy = false;
	}

	public void convertNormalToDummy(){
		isDummy = true;
	}
	
	public void convertDummyToNormal(){
		isDummy = false;
	}
	
	@Override
	public void updateEntity(){
		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		
		compound.setBoolean("isDummy", isDummy);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		
		isDummy = compound.getBoolean("isDummy");
	}
}
