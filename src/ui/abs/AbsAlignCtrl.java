package ui.abs;

import cmd.AlignCmd;
import cmd.CmdCtrl;
import doc.IAlign;
import ui.IAlignCtrl;

public abstract class AbsAlignCtrl extends AbsDocAttrCtrl implements IAlignCtrl {
	protected IAlign align = IAlign.LEFT;

	@Override
	public void active() {
		if (getDocCtrl() == null) {
			return;
		}
		AlignCmd cmd = new AlignCmd(getDocCtrl().getAlign(), getAlign(),
				getDocCtrl().getSelected(), getDocCtrl());
		CmdCtrl.getInstance().exec(cmd);
	}

	@Override
	public void setAlign(IAlign align) {
		this.align = align;
	}

	@Override
	public IAlign getAlign() {
		return align;
	}

}
