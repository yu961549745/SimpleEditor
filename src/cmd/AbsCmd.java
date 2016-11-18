package cmd;

import ui.IDocCtrl;

public abstract class AbsCmd {
	private IDocCtrl docCtrl;

	public void setDocCtrl(IDocCtrl docCtrl) {
		this.docCtrl = docCtrl;
	}

	public IDocCtrl getDocCtrl() {
		return docCtrl;
	}

	public abstract void exec();

	public abstract void undo();
}
