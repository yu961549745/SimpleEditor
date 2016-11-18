package align_strategy;

import doc.IAlign;
import ui.IDocCtrl;

public class RightAlignStrategy implements AlignStrategy {

	@Override
	public void setAlign(IDocCtrl docCtrl) {
		docCtrl.setAlign(IAlign.RIGHT);
	}

}
