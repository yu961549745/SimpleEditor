package analyze;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import doc.TextRange;
import resource.DicProvider;

public class SpellChecker {
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

}
