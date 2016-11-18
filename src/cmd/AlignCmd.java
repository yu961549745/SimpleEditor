package cmd;

import doc.IAlign;

public class AlignCmd extends AbsCmd {
	private IAlign src;
	private IAlign dst;

	public AlignCmd(IAlign src, IAlign dst) {
		this.src = src;
		this.dst = dst;
	}

	@Override
	public void exec() {
		getDocCtrl().setAlign(dst);
	}

	@Override
	public void undo() {
		getDocCtrl().setAlign(src);
	}

}
