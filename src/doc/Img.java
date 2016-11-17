package doc;

import ui.ImgImpl;

public class Img extends AbsNode {
	private int pos;
	private ImgImpl img;

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public ImgImpl getImg() {
		return img;
	}

	public void setImg(ImgImpl img) {
		this.img = img;
	}

	@Override
	public void addChild(DocNode node) {
		throw new UnsupportedOperationException();
	}
}
