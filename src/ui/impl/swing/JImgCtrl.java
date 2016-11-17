package ui.impl.swing;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class ImgInsertController implements ActionListener {
	private Frame parent;
	private JButton button = new JButton("插入图片");
	private JFileChooser chooser = new JFileChooser();

	public ImgInsertController(Frame parentFrame) {
		parent = parentFrame;
		button.addActionListener(this);
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
	}

	public ImageIcon getImage() {
		int returnVal = chooser.showOpenDialog(parent);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				return new ImageIcon(ImageIO.read(chooser.getSelectedFile()));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "无法读取 "
						+ chooser.getSelectedFile().getName());
			}
		}
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getImage();
	}

	public Component getComponent() {
		return button;
	}

}
