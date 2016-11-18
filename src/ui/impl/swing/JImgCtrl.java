package ui.impl.swing;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import ui.abs.AbsImgCtrl;

public class JImgCtrl extends AbsImgCtrl {

	private JButton button = new JButton("插入图片");
	private JFileChooser chooser = new JFileChooser();

	public JImgCtrl() {

		chooser.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return "图片";
			}

			@Override
			public boolean accept(File f) {
				return f.isDirectory()
						|| f.getAbsolutePath().matches(
								"(?i).*?\\.(jpg|bmp|gif|png|wbmp|jpeg)");
			}
		});

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				active();
			}
		});
	}

	public Component getComponent() {
		return button;
	}

	@Override
	protected File getSelectedFile() {
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			chooser.getSelectedFile();
		}
		return null;
	}

	@Override
	public Object getImpl() {
		return button;
	}

}
