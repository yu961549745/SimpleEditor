package cmd;

import ui.IDocCtrl;
import doc.IFont;

public class FontCmd extends AbsCmd {
	private IFont src;
	private IFont dst;

	public FontCmd(IFont src, IFont dst, IDocCtrl docCtrl) {
		this.src = src;
		this.dst = dst;
		setDocCtrl(docCtrl);
	}

	@Override
	public void exec() {
		getDocCtrl().setFont(dst);
	}

	@Override
	public void undo() {
		getDocCtrl().setFont(src);
	}

}
