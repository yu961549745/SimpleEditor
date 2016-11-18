package ui.impl.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.abs.AbsFontCtrl;
import ui.impl.swing.comp.ImgButton;
import ui.impl.swing.comp.JAutoCompleteComboBox;
import doc.IFont;

public class JFontCtrl extends AbsFontCtrl {

	private JPanel panel = new JPanel();

	private JLabel fontLabel = new JLabel("字体");
	private JComboBox<String> fonts = new JAutoCompleteComboBox<String>();

	private JLabel sizeLabel = new JLabel("大小");
	private JComboBox<String> size = new JAutoCompleteComboBox<String>();

	private JPanel color = new JPanel();

	private ImgButton bBtn = new ImgButton("B.gif");
	private ImgButton iBtn = new ImgButton("I.gif");
	private ImgButton uBtn = new ImgButton("U.gif");

	private StyleListener styleListener = new StyleListener();

	public JFontCtrl() {

		String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getAvailableFontFamilyNames();
		for (String s : fontNames) {
			fonts.addItem(s);
		}
		panel.add(fontLabel);
		panel.add(fonts);
		fonts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				font.setName((String) fonts.getSelectedItem());
				active();
			}
		});

		panel.add(sizeLabel);
		panel.add(size);
		for (int k = 10; k <= 100; k++) {
			size.addItem(String.valueOf(k));
		}
		size.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				font.setSize(Integer.valueOf((String) size.getSelectedItem()));
				active();
			}
		});

		panel.add(color);
		color.setPreferredSize(bBtn.getPreferredSize());
		color.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setColor(JColorChooser.showDialog(panel, "选择颜色",
						new Color(font.getColor())).getRGB());
				active();
			}
		});

		panel.add(bBtn);
		panel.add(iBtn);
		panel.add(uBtn);

		bBtn.addActionListener(styleListener);
		iBtn.addActionListener(styleListener);
		uBtn.addActionListener(styleListener);

		setFont(font);
	}

	@Override
	public void setFont(IFont f) {
		fonts.setSelectedItem(f.getName());
		size.setSelectedItem(String.valueOf(f.getSize()));
		color.setBackground(new Color(f.getColor()));
		bBtn.setSelected(f.isBold());
		iBtn.setSelected(f.isItalic());
		uBtn.setSelected(f.isUnderline());
		super.setFont(f);
	}

	private class StyleListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ImgButton btn = (ImgButton) e.getSource();
			btn.changeState();
			updateFontStyle();
			active();
		}

	}

	private void setColor(int c) {
		font.setColor(c);
		color.setBackground(new Color(c));
	}

	private void updateFontStyle() {
		font.setBold(uBtn.isSelected());
		font.setItalic(iBtn.isSelected());
		font.setUnderline(uBtn.isSelected());
	}

	public Component getComponent() {
		return panel;
	}

	@Override
	public Object getImpl() {
		return panel;
	}

}
