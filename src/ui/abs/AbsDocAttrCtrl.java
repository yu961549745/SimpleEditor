package ui.abs;

import ui.IDocAttrCtrl;
import ui.IDocCtrl;

public abstract class AbsDocAttrCtrl implements IDocAttrCtrl {
	protected IDocCtrl docCtrl;

	@Override
	public IDocCtrl getDocCtrl() {
		return docCtrl;
	}

	@Override
	public void setDocCtrl(IDocCtrl docCtrl) {
		this.docCtrl = docCtrl;
	}

}
