package ui.abs;

import cmd.CmdCtrl;
import cmd.FontCmd;
import doc.IFont;
import ui.IFontCtrl;

public abstract class AbsFontCtrl extends AbsDocAttrCtrl implements IFontCtrl {
	protected IFont font = new IFont();

	@Override
	public void active() {
		if (getDocCtrl() == null) {
			return;
		}
		IFont src = getDocCtrl().getFont();
		IFont dst = getFont();
		FontCmd cmd = new FontCmd(src, dst, getDocCtrl().getSelected(),
				getDocCtrl());
		CmdCtrl.getInstance().exec(cmd);
	}

	@Override
	public IFont getFont() {
		return font;
	}

	@Override
	public void setFont(IFont font) {
		this.font = font;
	}

}
