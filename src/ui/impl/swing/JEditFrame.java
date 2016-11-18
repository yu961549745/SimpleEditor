package ui.impl.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.IAlignCtrl;
import ui.IDocCtrl;
import ui.IFontCtrl;
import ui.IFrame;
import ui.IImgCtrl;
import ui.IUtils;

public class JEditFrame implements IFrame {
	private IFontCtrl fontCtrl = new JFontCtrl();
	private IAlignCtrl alignCtrl = new JAlignCtrl();
	private IImgCtrl imgCtrl = new JImgCtrl();
	private IDocCtrl docCtrl = new JDocCtrl();
	private IUtils utils = new JUtils();

	@Override
	public IFontCtrl getFontCtrl() {
		return fontCtrl;
	}

	@Override
	public IAlignCtrl getAlignCtrl() {
		return alignCtrl;
	}

	@Override
	public IImgCtrl getImgCtrl() {
		return imgCtrl;
	}

	@Override
	public IDocCtrl getDocCtrl() {
		return docCtrl;
	}

	private JFrame frame = new JFrame("简单文本编辑器");
	private JPanel toolbar = new JPanel();

	public JEditFrame() {
		initUI();
	}

	private void initUI() {
		frame.setLayout(new BorderLayout());

		toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolbar.add((Component) getFontCtrl().getImpl());
		toolbar.add((Component) getAlignCtrl().getImpl());
		toolbar.add((Component) getImgCtrl().getImpl());
		toolbar.add((Component) getIUtils().getImpl());

		frame.add(toolbar, BorderLayout.NORTH);
		frame.add((Component) getDocCtrl().getImpl(), BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500, 500));
	}

	@Override
	public Object getImpl() {
		return frame;
	}

	@Override
	public IUtils getIUtils() {
		return utils;
	}

}
