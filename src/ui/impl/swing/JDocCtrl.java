package ui.impl.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import doc.IAlign;
import doc.IFont;
import doc.Img;
import doc.TextRange;
import ui.abs.AbsDocCtrl;

public class JDocCtrl extends AbsDocCtrl {
	private JTextPane textPane = new JTextPane();
	private JScrollPane scrollPane = new JScrollPane(textPane);

	public JDocCtrl() {
		textPane.setPreferredSize(new Dimension(500, 500));

		textPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
					undo();
				} else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Y) {
					redo();
				}
			}
		});

		textPane.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				updateStyle();
			}
		});
	}

	public void setFont(IFont font) {
		SimpleAttributeSet attr = new SimpleAttributeSet();
		StyleConstants.setFontFamily(attr, font.getName());
		StyleConstants.setFontSize(attr, font.getSize());
		StyleConstants.setForeground(attr, new Color(font.getColor()));
		StyleConstants.setBold(attr, font.isBold());
		StyleConstants.setItalic(attr, font.isItalic());
		StyleConstants.setUnderline(attr, font.isUnderline());
		textPane.setCharacterAttributes(attr, true);
		textPane.requestFocus();
	}

	public void setAlign(IAlign align) {
		SimpleAttributeSet attr = new SimpleAttributeSet();
		int key = StyleConstants.ALIGN_JUSTIFIED;
		if (align == IAlign.LEFT) {
			key = StyleConstants.ALIGN_LEFT;
		} else if (align == IAlign.CENTER) {
			key = StyleConstants.ALIGN_CENTER;
		} else if (align == IAlign.RIGHT) {
			key = StyleConstants.ALIGN_RIGHT;
		}
		StyleConstants.setAlignment(attr, key);
		textPane.setParagraphAttributes(attr, true);
		textPane.requestFocus();
	}

	public IAlign getAlign() {
		Object obj = textPane.getParagraphAttributes().getAttribute(
				StyleConstants.Alignment);
		if (obj == null) {
			return IAlign.LEFT;
		}
		int key = (Integer) obj;
		switch (key) {
		case StyleConstants.ALIGN_LEFT:
			return IAlign.LEFT;
		case StyleConstants.ALIGN_CENTER:
			return IAlign.CENTER;
		case StyleConstants.ALIGN_RIGHT:
			return IAlign.RIGHT;
		default:
			return null;
		}
	}

	public IFont getFont() {
		IFont f = new IFont();
		Object obj;
		obj = textPane.getCharacterAttributes().getAttribute(
				StyleConstants.FontFamily);
		if (obj != null) {
			f.setName((String) obj);
		}
		obj = textPane.getCharacterAttributes().getAttribute(
				StyleConstants.FontSize);
		if (obj != null) {
			f.setSize((Integer) obj);
		}
		obj = textPane.getCharacterAttributes().getAttribute(
				StyleConstants.Foreground);
		if (obj != null) {
			f.setColor(((Color) obj).getRGB());
		}
		f.setBold(getBooleanAttributes(StyleConstants.Bold));
		f.setItalic(getBooleanAttributes(StyleConstants.Italic));
		f.setUnderline(getBooleanAttributes(StyleConstants.Underline));
		return f;
	}

	private boolean getBooleanAttributes(Object key) {
		Object obj = textPane.getCharacterAttributes().getAttribute(key);
		if (obj == null) {
			return false;
		}
		return (Boolean) obj;
	}

	@Override
	public void insertImg(Img img) {
		JImg image = (JImg) img;
		textPane.insertIcon(image.getIcon());
		image.setPos(textPane.getCaretPosition() - 1);
	}

	@Override
	public void removeImg(Img img) {
		JImg image = (JImg) img;
		try {
			textPane.getDocument().remove(image.getPos(), 1);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object getImpl() {
		return scrollPane;
	}

	@Override
	public TextRange getSelected() {
		Caret c = textPane.getCaret();
		int mark = c.getMark();
		int dot = c.getDot();
		return new TextRange(mark, dot);
	}

	@Override
	public void setSelected(TextRange range) {
		textPane.getCaret().setDot(range.getStart());
		textPane.getCaret().moveDot(range.getEnd());
	}

	@Override
	public String getTextString() {
		return textPane.getText();
	}

}
