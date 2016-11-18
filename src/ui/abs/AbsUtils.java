package ui.abs;

import java.util.List;

import doc.IFont;
import doc.TextRange;
import analyze.SpellChecker;
import ui.IUtils;

public abstract class AbsUtils extends AbsDocAttrCtrl implements IUtils {
	private SpellChecker spellChecker = new SpellChecker();

	@Override
	public void spellCheck() {
		List<TextRange> ranges = spellChecker.check(getDocCtrl()
				.getTextString());
		TextRange oldRange = docCtrl.getSelected();
		for (TextRange r : ranges) {
			docCtrl.setSelected(r);
			IFont f = docCtrl.getFont();
			f.setColor(0xFFFF0000);
			f.setUnderline(true);
			docCtrl.setFont(f);
		}
		docCtrl.setSelected(oldRange);
	}
}
