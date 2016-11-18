package align_strategy;

import java.util.HashMap;
import java.util.Map;

import doc.IAlign;

public class AlignStrategyFactory {
	private static Map<IAlign, AlignStrategy> map = new HashMap<IAlign, AlignStrategy>();
	static {
		map.put(IAlign.LEFT, new LeftAlignStrategy());
		map.put(IAlign.CENTER, new CenterAlignStrategy());
		map.put(IAlign.RIGHT, new RightAlignStrategy());
	}

	public static AlignStrategy getAlignStrategy(IAlign align) {
		return map.get(align);
	}
}
