package ui.abs;

import ui.IAlignCtrl;
import ui.IDocCtrl;
import ui.IFontCtrl;
import ui.IFrame;
import ui.IImgCtrl;

public class TextEditor {
	private IFrame frame;
	private IDocCtrl docCtrl;
	private IFontCtrl fontCtrl;
	private IAlignCtrl alignCtrl;
	private IImgCtrl imgCtrl;

	public TextEditor(IFrame frame) {
		this.frame = frame;
		init();
	}

	private void init() {
		docCtrl = frame.getDocCtrl();
		fontCtrl = frame.getFontCtrl();
		alignCtrl = frame.getAlignCtrl();
		imgCtrl = frame.getImgCtrl();

		docCtrl.setFontCtrl(fontCtrl);
		docCtrl.setAlignCtrl(alignCtrl);
		docCtrl.setImgCtrl(imgCtrl);

		fontCtrl.setDocCtrl(docCtrl);
		alignCtrl.setDocCtrl(docCtrl);
		imgCtrl.setDocCtrl(docCtrl);
	}

}
