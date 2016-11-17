package env;

import impl.swing.JFontProvider;

public class FontProviderFactory {
	private static final FontNameProvider provider = new JFontProvider();

	public static FontNameProvider getFontNameProvider() {
		return provider;
	}
}
