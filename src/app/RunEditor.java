package app;

import javax.swing.UIManager;

import ui.abs.TextEditor;
import ui.impl.swing.JEditFrame;

public class RunEditor {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new TextEditor(new JEditFrame());
	}
}
