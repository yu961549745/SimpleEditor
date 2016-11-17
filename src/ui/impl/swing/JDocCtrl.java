package ui.impl.swing;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextPane;
import javax.swing.text.Caret;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import doc.IAlign;
import doc.IFont;
import doc.Img;
import doc.TextRange;
import ui.IDocCtrl;
import ui.ImgImpl;

public class JDocCtrl implements IDocCtrl {
	private JTextPane textPane = new JTextPane();

	public Img insert(ImgImpl img) {
		JImgImpl jimg = (JImgImpl) img;
		textPane.insertIcon(jimg.getImg());
		Img docImg = new Img();
		docImg.setImg(img);
		docImg.setPos(textPane.getCaretPosition());

		textPane.getCaret().setVisible(true);
		textPane.getCaret().setSelectionVisible(true);
		return docImg;
	}

	public TextRange getSelected() {
		Caret c = textPane.getCaret();
		return new TextRange(c.getMark(), c.getDot());
	}

	public void setFont(IFont font) {
		SimpleAttributeSet attr = new SimpleAttributeSet();
		StyleConstants.setFontFamily(attr, font.getName());
		StyleConstants.setFontSize(attr, font.getSize());
		StyleConstants.setForeground(attr, new Color(font.getColor()));
		StyleConstants.setBold(attr, font.isBold());
		StyleConstants.setItalic(attr, font.isItalic());
		StyleConstants.setUnderline(attr, font.isUnder());
		textPane.setCharacterAttributes(attr, false);
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
		textPane.setParagraphAttributes(attr, false);
	}

	public Component getComponent() {
		return textPane;
	}

}
