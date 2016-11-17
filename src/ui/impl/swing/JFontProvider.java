package impl.swing;

import java.awt.GraphicsEnvironment;

import env.FontNameProvider;

public class JFontProvider implements FontNameProvider {
	@Override
	public String[] getAllFonts() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getAvailableFontFamilyNames();
	}
}
