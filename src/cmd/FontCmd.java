package cmd;

import ui.IDocCtrl;
import doc.IFont;
import doc.TextRange;

public class FontCmd extends AbsCmd {
	private IFont src;
	private IFont dst;
	private TextRange range;

	public FontCmd(IFont src, IFont dst, TextRange range, IDocCtrl docCtrl) {
		this.src = src;
		this.dst = dst;
		this.range = range;
		setDocCtrl(docCtrl);
	}

	@Override
	public void exec() {
		getDocCtrl().setSelected(range);
		getDocCtrl().setFont(dst);
	}

	@Override
	public void undo() {
		getDocCtrl().setSelected(range);
		getDocCtrl().setFont(src);
	}

}
