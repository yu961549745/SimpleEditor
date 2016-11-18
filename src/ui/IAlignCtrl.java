package ui;

import doc.IAlign;

public interface IAlignCtrl extends IDocAttrCtrl, IComp {
	public IAlign getAlign();

	public void setAlign(IAlign align);
	
	public void active();
}
