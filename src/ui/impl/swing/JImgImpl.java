package ui.impl.swing;

import javax.swing.ImageIcon;

import ui.ImgImpl;

public class JImgImpl implements ImgImpl {
	private ImageIcon img;

	public JImgImpl(ImageIcon img) {
		this.img = img;
	}

	public ImageIcon getImg() {
		return img;
	}
}
