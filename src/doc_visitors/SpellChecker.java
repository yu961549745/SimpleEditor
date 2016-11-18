package doc_visitors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import doc.IFont;
import doc.TextRange;
import resource.DicProvider;
import ui.IDocCtrl;

public class SpellChecker implements DocVisitor {
	private Map<String, Boolean> dic = DicProvider.getInstance().getDic();

	public List<TextRange> check(String s) {
		List<TextRange> rs = new ArrayList<TextRange>();
		Pattern p = Pattern.compile("\\w+");
		Matcher m = p.matcher(s);
		while (m.find()) {
			if (dic.get(m.group()) == null) {
				rs.add(new TextRange(m.start(), m.end()));
			}
		}
		return rs;
	}

	@Override
	public void visit(IDocCtrl docCtrl) {
		List<TextRange> ranges = check(docCtrl.getTextString());
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
