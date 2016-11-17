package test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.text.Caret;

import ui.impl.swing.AlignController;
import ui.impl.swing.FontController;
import ui.impl.swing.ImgInsertController;

public class UITest {
	private JFrame frame = new JFrame("简单编辑器");
	private JPanel toolbar = new JPanel();

	private FontController font = new FontController();
	private AlignController align = new AlignController();
	private ImgInsertController img = new ImgInsertController(frame);

	private JTextPane textPane = new JTextPane();
	private JScrollPane scrollPane = new JScrollPane(textPane);

	public UITest() {
		frame.setLayout(new BorderLayout());

		toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolbar.add(font.getComponent());
		toolbar.add(align.getComponent());
		toolbar.add(img.getComponent());

		JButton btn = new JButton("测试");
		toolbar.add(btn);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Caret c = textPane.getCaret();
				System.out.println(c.getDot() + " " + c.getMark());
			}
		});

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
