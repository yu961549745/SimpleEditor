package ui.abs;

import ui.IImgCtrl;
import cmd.CmdCtrl;
import cmd.ImgCmd;
import doc.Img;

public abstract class AbsImgCtrl extends AbsDocAttrCtrl implements IImgCtrl {
	@Override
	public void active() {
		Img img = getImg();
		if (img == null) {
			return;
		}
		ImgCmd cmd = new ImgCmd(img,getDocCtrl());
		CmdCtrl.getInstance().exec(cmd);
	}
}
