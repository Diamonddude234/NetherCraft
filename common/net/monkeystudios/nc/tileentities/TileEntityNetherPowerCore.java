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
	private boolean isValidMultiblock;
	
	private int coreX, coreY, coreZ;
	private TileEntityNetherPowerCore tileEntityCore;
	
	public TileEntityNetherPowerCore(){
		timer = 100;
		isDummy = false;
		isValidMultiblock = false;	
		tileEntityCore = null;
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
	
	public void convertNormalToDummy(){
		isDummy = true;
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1, 3);
	}
	
	public void convertDummyToNormal(){
		isDummy = false;
		tileEntityCore = null;
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 3);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		
		compound.setBoolean("isDummy", isDummy);
		compound.setBoolean("isValidMultiblock", isValidMultiblock);
		
		compound.setInteger("CoreX", coreX);
		compound.setInteger("CoreY", coreY);
		compound.setInteger("CoreZ", coreZ);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		
		isDummy = compound.getBoolean("isDummy");
		isValidMultiblock = compound.getBoolean("isValidMultiblock");
		
		coreX = compound.getInteger("CoreX");
		coreY = compound.getInteger("CoreY");
		coreZ = compound.getInteger("CoreZ");
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
	
	public void finalizeMultiblock(){
		for(int y = 0; y <= 2; y++){
			for(int x = -1; x <= 1; x++){
				for(int z = -1; z <= 1; z++){
					
					int blockId = worldObj.getBlockId(xCoord + x, yCoord + y, zCoord + z);
					if(y==0){
						if(x==0 && z==0) continue; //That's me!
						
						if(x!=0 && z !=0 && blockId == Blocks.netherStructureCasing.blockID){
							TileEntityNetherStructureCasing dummyTE = (TileEntityNetherStructureCasing)worldObj.getBlockTileEntity(xCoord + x, yCoord + y, zCoord + z);
							dummyTE.convertNormalToDummy();
							dummyTE.setCore(this);
							continue;
						}
						
						if(((x == 0 && z != 0) || (x != 0 && z == 0)) && blockId == Blocks.netherTransferNode.blockID){
							TileEntityNetherTransferNode dummyTE = (TileEntityNetherTransferNode)worldObj.getBlockTileEntity(xCoord + x, yCoord + y, zCoord + z);
							dummyTE.convertNormalToDummy();
							dummyTE.setCore(this);
							continue;
						}
			
						//return false;
					} else if(y==1){
						if(x==0 && z==0 && blockId==0) continue;
						
						if(x!=0 && z !=0 && blockId == Blocks.netherStructureCasing.blockID){
							TileEntityNetherStructureCasing dummyTE = (TileEntityNetherStructureCasing)worldObj.getBlockTileEntity(xCoord + x, yCoord + y, zCoord + z);
							dummyTE.convertNormalToDummy();
							dummyTE.setCore(this);
							continue;
						}
						
						if(((x == 0 && z != 0) || (x != 0 && z == 0)) && blockId == Blocks.soulGlass.blockID){
							TileEntitySoulGlass dummyTE = (TileEntitySoulGlass)worldObj.getBlockTileEntity(xCoord + x, yCoord + y, zCoord + z);
							dummyTE.convertNormalToDummy();
							dummyTE.setCore(this);
							continue;
						}
						
					} else if(y==2){
						if(x==0 && z==0 && blockId==Blocks.netherPowerCore.blockID){
							TileEntityNetherPowerCore dummyTE = (TileEntityNetherPowerCore)worldObj.getBlockTileEntity(xCoord + x, yCoord + y, zCoord + z);
							dummyTE.convertNormalToDummy();
							dummyTE.setCore(this);
							continue;
						}
						
						if(blockId == Blocks.netherStructureCasing.blockID) {
							TileEntityNetherStructureCasing dummyTE = (TileEntityNetherStructureCasing)worldObj.getBlockTileEntity(xCoord + x, yCoord + y, zCoord + z);
							dummyTE.convertNormalToDummy();
							dummyTE.setCore(this);
							continue;
						}
						
					}
				}
				
			}
		}
	}
	
	public void invalidateMultiblock(){
		
		isValidMultiblock = false;
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 3);
		
		for(int y = 0; y <= 2; y++){
			for(int x = -1; x <= 1; x++){
				for(int z = -1; z <= 1; z++){
					
					int blockId = worldObj.getBlockId(xCoord + x, yCoord + y, zCoord + z);
					if(y==0){
						if(x==0 && z==0) continue; //That's me!
						
						if(x!=0 && z !=0 && blockId == Blocks.netherStructureCasing.blockID){
							TileEntityNetherStructureCasing dummyTE = (TileEntityNetherStructureCasing)worldObj.getBlockTileEntity(xCoord + x, yCoord + y, zCoord + z);
							dummyTE.convertDummyToNormal();
							continue;
						}
						
						if(((x == 0 && z != 0) || (x != 0 && z == 0)) && blockId == Blocks.netherTransferNode.blockID){
							TileEntityNetherTransferNode dummyTE = (TileEntityNetherTransferNode)worldObj.getBlockTileEntity(xCoord + x, yCoord + y, zCoord + z);
							dummyTE.convertDummyToNormal();
							continue;
						}
			
						//return false;
					} else if(y==1){
						if(x==0 && z==0 && blockId==0) continue;
						
						if(x!=0 && z !=0 && blockId == Blocks.netherStructureCasing.blockID){
							TileEntityNetherStructureCasing dummyTE = (TileEntityNetherStructureCasing)worldObj.getBlockTileEntity(xCoord + x, yCoord + y, zCoord + z);
							dummyTE.convertDummyToNormal();
							continue;
						}
						
						if(((x == 0 && z != 0) || (x != 0 && z == 0)) && blockId == Blocks.soulGlass.blockID){
							TileEntitySoulGlass dummyTE = (TileEntitySoulGlass)worldObj.getBlockTileEntity(xCoord + x, yCoord + y, zCoord + z);
							dummyTE.convertDummyToNormal();
							continue;
						}
						
					} else if(y==2){
						if(x==0 && z==0 && blockId==Blocks.netherPowerCore.blockID){
							TileEntityNetherPowerCore dummyTE = (TileEntityNetherPowerCore)worldObj.getBlockTileEntity(xCoord + x, yCoord + y, zCoord + z);
							dummyTE.convertDummyToNormal();
							continue;
						}
						
						if(blockId == Blocks.netherStructureCasing.blockID) {
							TileEntityNetherStructureCasing dummyTE = (TileEntityNetherStructureCasing)worldObj.getBlockTileEntity(xCoord + x, yCoord + y, zCoord + z);
							dummyTE.convertDummyToNormal();
							continue;
						}
						
					}
				}
				
			}
		}
	}
	
	@Override
	public void updateEntity(){
		if(isDummy) return; //I'm a dummy, nothing to do here
		
		if(!this.worldObj.isRemote && !isValidMultiblock){
			timer--;
			
			if(timer <= 0){
				timer = 100;
				if(checkIfProperlyFormed()){
					isValidMultiblock = true;
					finalizeMultiblock();
					worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1, 3);
				}
			}
		}
	}
}
