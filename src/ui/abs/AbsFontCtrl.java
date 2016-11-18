package ui.abs;

import cmd.CmdCtrl;
import cmd.FontCmd;
import doc.IFont;
import ui.IFontCtrl;

public abstract class AbsFontCtrl extends AbsDocAttrCtrl implements IFontCtrl {
	public void active() {
		if(getDocCtrl()==null){
			return;
		}
		IFont src = getDocCtrl().getFont();
		IFont dst = getFont();
		FontCmd cmd = new FontCmd(src, dst, getDocCtrl());
		CmdCtrl.getInstance().exec(cmd);
	}
}