package ui.impl.swing;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import doc.Img;
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
	public Img getImg() {
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				ImageIcon icon = new ImageIcon(ImageIO.read(chooser
						.getSelectedFile()));
				JImg img = new JImg();
				img.setIcon(icon);
				return img;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "无法读取 "
						+ chooser.getSelectedFile().getName());
			}
		}
		return null;
	}

	@Override
	public Object getImpl() {
		return button;
	}

}
