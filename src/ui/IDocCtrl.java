package ui;

import doc.IAlign;
import doc.IFont;
import doc.Img;
import doc.TextRange;

public interface IDocCtrl extends IComp {
	// 组件关联设置
	public IFontCtrl getFontCtrl();

	public void setFontCtrl(IFontCtrl fontCtrl);

	public IImgCtrl getImgCtrl();

	public void setImgCtrl(IImgCtrl imgCtrl);

	public IAlignCtrl getAlignCtrl();

	public void setAlignCtrl(IAlignCtrl alignCtrl);

	// 属性设置
	public IFont getFont();

	public void setFont(IFont font);

	public IAlign getAlign();

	public void setAlign(IAlign align);
	
	public TextRange getSelected();
	
	public void setSelected(TextRange range);

	// 内容修改
	public void insertImg(Img img);

	public void removeImg(Img img);

	public void redo();

	public void undo();

	void updateStyle();
}
