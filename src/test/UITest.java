package test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import ui.impl.swing.JAlignCtrl;
import ui.impl.swing.JDocCtrl;
import ui.impl.swing.JFontCtrl;
import ui.impl.swing.JImgCtrl;

public class UITest {
	private JFrame frame = new JFrame("简单编辑器");
	private JPanel toolbar = new JPanel();

	private JDocCtrl doc = new JDocCtrl();

	private JFontCtrl font = new JFontCtrl(doc);
	private JAlignCtrl align = new JAlignCtrl(doc);

	private JScrollPane scrollPane = new JScrollPane(doc.getComponent());

	private JImgCtrl img = new JImgCtrl(doc);

	public UITest() {
		frame.setLayout(new BorderLayout());

		toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolbar.add(font.getComponent());
		toolbar.add(align.getComponent());
		toolbar.add(img.getComponent());

		frame.add(toolbar, BorderLayout.NORTH);
		frame.add(scrollPane, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new UITest();
	}
}
