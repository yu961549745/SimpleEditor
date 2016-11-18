package ui.abs;

import cmd.CmdCtrl;
import doc_visitors.DocVisitor;
import ui.IAlignCtrl;
import ui.IDocCtrl;
import ui.IFontCtrl;
import ui.IImgCtrl;

public abstract class AbsDocCtrl implements IDocCtrl {
	protected IFontCtrl fontCtrl;
	protected IAlignCtrl alignCtrl;
	protected IImgCtrl imgCtrl;

	@Override
	public IFontCtrl getFontCtrl() {
		return fontCtrl;
	}

	@Override
	public void setFontCtrl(IFontCtrl fontCtrl) {
		this.fontCtrl = fontCtrl;
		setFont(fontCtrl.getFont());
	}

	@Override
	public IAlignCtrl getAlignCtrl() {
		return alignCtrl;
	}

	@Override
	public void setAlignCtrl(IAlignCtrl alignCtrl) {
		this.alignCtrl = alignCtrl;
		setAlign(alignCtrl.getAlign());
	}

	@Override
	public IImgCtrl getImgCtrl() {
		return imgCtrl;
	}

	@Override
	public void setImgCtrl(IImgCtrl imgCtrl) {
		this.imgCtrl = imgCtrl;
	}

	@Override
	public void redo() {
		CmdCtrl.getInstance().redo();
	}

	@Override
	public void undo() {
		CmdCtrl.getInstance().undo();
	}

	@Override
	public void updateStyle() {
		if (fontCtrl != null && alignCtrl != null) {
			fontCtrl.setFont(getFont());
			alignCtrl.setAlign(getAlign());
		}
	}

	@Override
	public void acept(DocVisitor visitor) {
		visitor.visit(this);
	}

}
