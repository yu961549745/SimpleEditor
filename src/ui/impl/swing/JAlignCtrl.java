package ui.impl.swing;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import ui.IAlign;

public class AlignController {
	private JPanel panel = new JPanel();
	private JButton LButton = new ImgButton("L.gif");
	private JButton CButton = new ImgButton("C.gif");
	private JButton RButton = new ImgButton("R.gif");

	private Map<IAlign, JButton> btnMap = new HashMap<IAlign, JButton>();

	private AlignListener listener = new AlignListener();

	public AlignController() {
		btnMap.put(IAlign.LEFT, LButton);
		btnMap.put(IAlign.CENTER, CButton);
		btnMap.put(IAlign.RIGHT, RButton);

		panel.add(LButton);
		panel.add(CButton);
		panel.add(RButton);

		for (IAlign a : btnMap.keySet()) {
			btnMap.get(a).addActionListener(listener);
		}

		setAlign(IAlign.LEFT);

	}

	public Component getComponent() {
		return panel;
	}

	private IAlign align = IAlign.LEFT;

	public IAlign getAlign() {
		return align;
	}

	public void setAlign(IAlign align) {
		this.align = align;
		for (IAlign a : btnMap.keySet()) {
			btnMap.get(a).setSelected(false);
		}
		btnMap.get(align).setSelected(true);
	}

	private class AlignListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if (o.equals(LButton)) {
				setAlign(IAlign.LEFT);
			} else if (o.equals(CButton)) {
				setAlign(IAlign.CENTER);
			} else if (o.equals(RButton)) {
				setAlign(IAlign.RIGHT);
			}
		}
	}
}
