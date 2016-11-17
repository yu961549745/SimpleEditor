package resource;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImgLoader {
	private static final ImgLoader INSTANCE = new ImgLoader();

	public static ImgLoader getInstance() {
		return INSTANCE;
	}

	private Map<String, ImageIcon> imgs = new HashMap<String, ImageIcon>();

	private ImgLoader() {
	}

	public ImageIcon getImage(String name) {
		try {
			ImageIcon icon = imgs.get(name);
			if (icon == null) {
				BufferedImage img = ImageIO.read(this.getClass()
						.getResourceAsStream(name));
				icon = new ImageIcon(img);
				imgs.put(name, icon);
			}
			return icon;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
