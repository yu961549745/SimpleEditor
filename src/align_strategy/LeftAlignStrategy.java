package align_strategy;

import doc.IAlign;
import ui.IDocCtrl;

public class LeftAlignStrategy implements AlignStrategy {

	@Override
	public void setAlign(IDocCtrl docCtrl) {
		docCtrl.setAlign(IAlign.LEFT);
	}

}
