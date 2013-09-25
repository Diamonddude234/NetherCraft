package net.monkeystudios.nc.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.monkeystudios.nc.blocks.Blocks;

/**
 * NetherCraft
 *
 * TileEntityNetherPowerCore
 *
 * @author ryalein
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
public class TileEntityNetherPowerCore extends TileEntity{
	
	private int timer;
	private boolean isDummy;
	
	public TileEntityNetherPowerCore(){
		timer = 100;
		isDummy = false;
	}
	
	@Override
	public void updateEntity(){
		if(!worldObj.isRemote) {
			timer--;
			
			if (timer <= 0) {
				timer = 100;
				if(checkIfProperlyFormed()){
					worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1, 3);
				} else {
					worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 3);
				}
			}
		}
	}
	
	public void convertNormalToDummy(){
		isDummy = true;
	}
	
	public void convertDummyToNormal(){
		isDummy = false;
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
	
	private boolean checkIfProperlyFormed(){
		
		for(int y = 0; y <= 2; y++){
			for(int x = -1; x <= 1; x++){
				for(int z = -1; z <= 1; z++){
					
					int blockId = worldObj.getBlockId(xCoord + x, yCoord + y, zCoord + z);
					if(y==0){
						if(x==0 && z==0) continue; //That's me!
						
						if(x!=0 && z !=0 && blockId == Blocks.netherStructureCasing.blockID) continue;
						
						if(((x == 0 && z != 0) || (x != 0 && z == 0)) && blockId == Blocks.netherTransferNode.blockID) continue;
			
						//return false;
					} else if(y==1){
						if(x==0 && z==0 && blockId==0) continue;
						
						if(x!=0 && z !=0 && blockId == Blocks.netherStructureCasing.blockID) continue;
						
						if(((x == 0 && z != 0) || (x != 0 && z == 0)) && blockId == Blocks.soulGlass.blockID) continue;
						
						return false;
					} else if(y==2){
						if(x==0 && z==0 && blockId==Blocks.netherPowerCore.blockID) continue;
						
						if(blockId == Blocks.netherStructureCasing.blockID) continue;
						
						return false;
					}
				}
				
			}
		}
		return true;
	}
}
