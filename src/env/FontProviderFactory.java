package env;

import ui.impl.swing.comp.JFontProvider;

public class FontProviderFactory {
	private static final FontNameProvider provider = new JFontProvider();

	public static FontNameProvider getFontNameProvider() {
		return provider;
	}
}
