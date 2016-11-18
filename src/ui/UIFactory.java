package ui;

import ui.impl.swing.JEditFrame;

public class UIFactory {
	public static IFrame getFrame() {
		return new JEditFrame();
	}
}
