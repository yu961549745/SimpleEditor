package ui.abs;

import doc_visitors.SpellChecker;
import ui.IUtils;

public abstract class AbsUtils extends AbsDocAttrCtrl implements IUtils {
	private SpellChecker spellChecker = new SpellChecker();

	@Override
	public void spellCheck() {
		getDocCtrl().acept(spellChecker);
	}
}
