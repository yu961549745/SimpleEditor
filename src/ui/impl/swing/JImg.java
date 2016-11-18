package ui.impl.swing;

import javax.swing.Icon;

import doc.Img;

public class JImg extends Img {
	private Icon icon;
	private int pos;

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

}
