package resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DicProvider {
	private static final DicProvider INSTANCE = new DicProvider();

	public static DicProvider getInstance() {
		return INSTANCE;
	}

	private Map<String, Boolean> dic = new HashMap<String, Boolean>();

	private DicProvider() {
		try {
			loadDic();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadDic() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(this
				.getClass().getResourceAsStream("aedic"), "UTF8"));
		while (reader.ready()) {
			dic.put(reader.readLine(), true);
		}
	}

	public Map<String, Boolean> getDic() {
		return dic;
	}

}
