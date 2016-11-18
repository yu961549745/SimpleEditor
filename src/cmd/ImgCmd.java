package cmd;

import ui.IDocCtrl;
import doc.Img;

public class ImgCmd extends AbsCmd {
	private Img img;

	public ImgCmd(Img img, IDocCtrl docCtrl) {
		this.img = img;
		setDocCtrl(docCtrl);
	}

	@Override
	public void exec() {
		getDocCtrl().insertImg(img);
	}

	@Override
	public void undo() {
		getDocCtrl().removeImg(img);
	}

}
