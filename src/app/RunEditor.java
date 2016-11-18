package app;

import javax.swing.UIManager;

import ui.TextEditor;

public class RunEditor {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new TextEditor();
	}
}
