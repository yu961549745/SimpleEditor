package ui.abs;

import cmd.CmdCtrl;
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
	}

	@Override
	public IAlignCtrl getAlignCtrl() {
		return alignCtrl;
	}

	@Override
	public void setAlignCtrl(IAlignCtrl alignCtrl) {
		this.alignCtrl = alignCtrl;
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

}
