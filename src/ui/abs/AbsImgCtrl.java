package ui.abs;

import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import ui.IImgCtrl;
import ui.impl.swing.JImg;
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
		ImgCmd cmd = new ImgCmd(img, getDocCtrl());
		CmdCtrl.getInstance().exec(cmd);
	}

	@Override
	public Img getImg() {
		File file = getSelectedFile();
		if (file == null) {
			return null;
		}
		try {
			ImageIcon icon = new ImageIcon(ImageIO.read(file));
			JImg img = new JImg();
			img.setIcon(icon);
			return img;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	protected abstract File getSelectedFile();
}
