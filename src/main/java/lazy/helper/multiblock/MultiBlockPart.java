package lazy.helper.multiblock;

import lazy.helper.tileentity.TileEntityBase;

public abstract class MultiBlockPart extends TileEntityBase {
	
	public MultiBlockPart() {
		super();
		searchForMultiBlock();
	}
	
	public abstract MultiBlockHandler handler ();
	
	public abstract int structureID ();
	public abstract int blockID ();
	
	public abstract boolean isController ();
	
	public abstract void multiblockAssemble ();
	
	public abstract boolean hasHandler ();
	public abstract boolean connectToHandler ();
	
	public abstract void searchForMultiBlock();

}
