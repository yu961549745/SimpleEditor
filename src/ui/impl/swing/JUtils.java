package ui.impl.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ui.abs.AbsUtils;

public class JUtils extends AbsUtils {
	private JButton button = new JButton("拼写检查");

	public JUtils() {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				spellCheck();
			}
		});
	}

	@Override
	public Object getImpl() {
		return button;
	}

}
