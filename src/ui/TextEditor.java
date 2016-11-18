package ui;

public class TextEditor {
	private IFrame frame;
	private IDocCtrl docCtrl;
	private IFontCtrl fontCtrl;
	private IAlignCtrl alignCtrl;
	private IImgCtrl imgCtrl;
	private IUtils utils;

	public TextEditor() {
		this.frame = UIFactory.getFrame();
		init();
	}

	private void init() {
		docCtrl = frame.getDocCtrl();
		fontCtrl = frame.getFontCtrl();
		alignCtrl = frame.getAlignCtrl();
		imgCtrl = frame.getImgCtrl();
		utils = frame.getIUtils();

		docCtrl.setFontCtrl(fontCtrl);
		docCtrl.setAlignCtrl(alignCtrl);
		docCtrl.setImgCtrl(imgCtrl);

		fontCtrl.setDocCtrl(docCtrl);
		alignCtrl.setDocCtrl(docCtrl);
		imgCtrl.setDocCtrl(docCtrl);
		utils.setDocCtrl(docCtrl);
	}

}
