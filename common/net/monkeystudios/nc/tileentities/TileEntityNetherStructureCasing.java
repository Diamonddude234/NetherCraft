package net.monkeystudios.nc.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * NetherCraft
 *
 * TileEntityNetherStructureCasing
 *
 * @author ryalein
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
public class TileEntityNetherStructureCasing extends TileEntity{
	
private boolean isDummy;

private int coreX, coreY, coreZ;
private TileEntityNetherPowerCore tileEntityCore;
	
	public TileEntityNetherStructureCasing(){
		isDummy = false;
		
		tileEntityCore = null;
	}

	public void convertNormalToDummy(){
		isDummy = true;
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1, 3);
	}
	
	public void convertDummyToNormal(){
		isDummy = false;
		tileEntityCore = null;
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 3);
	}
	
	public void setCore(TileEntityNetherPowerCore core)
	{
		coreX = core.xCoord;
		coreY = core.yCoord;
		coreZ = core.zCoord;
		tileEntityCore = core;
	}
	
	public TileEntityNetherPowerCore getCore()
	{
		if(tileEntityCore == null)
			tileEntityCore = (TileEntityNetherPowerCore)worldObj.getBlockTileEntity(coreX, coreY, coreZ);
		
		return tileEntityCore;
	}
	
	@Override
	public void updateEntity(){
		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		
		compound.setBoolean("isDummy", isDummy);
		
		compound.setInteger("CoreX", coreX);
		compound.setInteger("CoreY", coreY);
		compound.setInteger("CoreZ", coreZ);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		
		isDummy = compound.getBoolean("isDummy");
		
		coreX = compound.getInteger("CoreX");
		coreY = compound.getInteger("CoreY");
		coreZ = compound.getInteger("CoreZ");
	}

}
