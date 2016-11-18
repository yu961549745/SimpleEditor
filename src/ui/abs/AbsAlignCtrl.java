package ui.abs;

import cmd.AlignCmd;
import cmd.CmdCtrl;
import ui.IAlignCtrl;

public abstract class AbsAlignCtrl extends AbsDocAttrCtrl implements IAlignCtrl {
	public void active() {
		if (getDocCtrl() == null) {
			return;
		}
		AlignCmd cmd = new AlignCmd(getDocCtrl().getAlign(), getAlign(),
				getDocCtrl().getSelected(), getDocCtrl());
		CmdCtrl.getInstance().exec(cmd);
	}

}
