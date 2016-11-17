package ui.impl.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import doc.IFont;
import env.FontProviderFactory;

public class JFontCtrl {
	private JDocCtrl docCtrl;

	private JPanel panel = new JPanel();

	private JLabel fontLabel = new JLabel("字体");
	private JComboBox<String> fonts = new JAutoCompleteComboBox<String>();

	private JLabel sizeLabel = new JLabel("大小");
	private JTextField size = new JTextField(3);

	private JPanel color = new JPanel();

	private ImgButton bBtn = new ImgButton("B.gif");
	private ImgButton iBtn = new ImgButton("I.gif");
	private ImgButton uBtn = new ImgButton("U.gif");

	private Map<ImgButton, Integer> btnMap = new HashMap<ImgButton, Integer>();
	private StyleListener styleListener = new StyleListener();

	private IFont font = new IFont();

	public JFontCtrl(JDocCtrl docCtrl) {
		this.docCtrl = docCtrl;

		String[] fontNames = FontProviderFactory.getFontNameProvider()
				.getAllFonts();
		for (String s : fontNames) {
			fonts.addItem(s);
		}
		panel.add(fontLabel);
		panel.add(fonts);
		fonts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				font.setName((String) fonts.getSelectedItem());

				update();
			}
		});

		panel.add(sizeLabel);
		panel.add(size);
		size.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				font.setSize(Integer.valueOf(size.getText()));
				update();
			}
		});

		panel.add(color);
		color.setPreferredSize(bBtn.getPreferredSize());
		color.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setColor(JColorChooser.showDialog(panel, "选择颜色",
						new Color(font.getColor())).getRGB());

				update();
			}
		});

		panel.add(bBtn);
		panel.add(iBtn);
		panel.add(uBtn);

		btnMap.put(bBtn, IFont.BOLD);
		btnMap.put(iBtn, IFont.ITALIC);
		btnMap.put(uBtn, IFont.UNDER);

		for (ImgButton b : btnMap.keySet()) {
			b.addActionListener(styleListener);
		}

		setFont(font);
	}

	public void setFont(IFont f) {
		fonts.setSelectedItem(f.getName());
		size.setText(String.valueOf(f.getSize()));
		color.setBackground(new Color(f.getColor()));
		for (ImgButton b : btnMap.keySet()) {
			b.setSelected((f.getStyle() & btnMap.get(b)) > 0);
		}
		font = f;
	}

	private class StyleListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ImgButton btn = (ImgButton) e.getSource();
			btn.changeState();
			updateFontStyle();

			update();
		}

	}

	private void setColor(int c) {
		font.setColor(c);
		color.setBackground(new Color(c));
	}

	private void updateFontStyle() {
		int s = 0;
		for (ImgButton b : btnMap.keySet()) {
			if (b.isSelected()) {
				s |= btnMap.get(b);
			}
		}
		font.setStyle(s);
	}

	public Component getComponent() {
		return panel;
	}

	public IFont getFont() {
		return font;
	}

	public void update() {
		System.out.println(font);
		docCtrl.setFont(font);
	}

}
