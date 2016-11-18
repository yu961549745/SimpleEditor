package ui;

import doc.IFont;

public interface IFontCtrl extends  IDocAttrCtrl,IComp {
	public void setFont(IFont font);

	public IFont getFont();
}
