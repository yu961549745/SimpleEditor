package ui.impl.swing;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

import resource.ImgLoader;

public class ImgButton extends JButton {
	private static final long serialVersionUID = -1719365451841365353L;
	private static Border tBorder = BorderFactory
			.createLineBorder(Color.RED, 1);
	private static Border fBorder = BorderFactory.createEmptyBorder();

	private boolean isSelected = false;

	public ImgButton(String imgName) {
		ImageIcon icon = ImgLoader.getInstance().getImage(imgName);
		this.setIcon(icon);
		this.setPreferredSize(new Dimension(icon.getIconWidth(), icon
				.getIconHeight()));
	}

	public void changeState() {
		isSelected = !isSelected;
		update();
	}

	public void setSelected(boolean b) {
		isSelected = b;
		update();
	}

	public boolean isSelected() {
		return isSelected;
	}

	private void update() {
		if (isSelected) {
			this.setBorder(tBorder);
		} else {
			this.setBorder(fBorder);
		}
	}

}
