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

import ui.ImgImpl;

public class JImgCtrl implements ActionListener {
	private JDocCtrl docCtrl;
	private JButton button = new JButton("插入图片");
	private JFileChooser chooser = new JFileChooser();

	public JImgCtrl(JDocCtrl docCtrl) {
		this.docCtrl = docCtrl;
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

	public ImgImpl getImage() {
		int returnVal = chooser.showOpenDialog(docCtrl.getComponent());
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				ImageIcon icon = new ImageIcon(ImageIO.read(chooser
						.getSelectedFile()));
				return new JImgImpl(icon);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "无法读取 "
						+ chooser.getSelectedFile().getName());
			}
		}
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		docCtrl.insert(getImage());
	}

	public Component getComponent() {
		return button;
	}

}
