package ui.abs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.Ostermiller.util.Base64;

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
			img.setBase64(encodeImg(file));
			return img;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private String encodeImg(File in) {
		try {
			File out = new File(System.getProperty("java.io.tmpdir"), ""
					+ Math.random() + ".base64");
			Base64.encode(in, out, false);

			BufferedReader reader = new BufferedReader(new FileReader(out));
			StringBuffer buffer = new StringBuffer();
			while (reader.ready()) {
				buffer.append(reader.readLine());
			}
			reader.close();
			out.delete();
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	protected abstract File getSelectedFile();
}
