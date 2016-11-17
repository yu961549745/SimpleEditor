package doc;

public class IFont {
	public static final int PLAIN = 0x0;
	public static final int BOLD = 0x100;
	public static final int ITALIC = 0x010;
	public static final int UNDER = 0x001;

	private String name = "Times New Roman";
	private int size = 20;
	private int color = 0xff000000;// argb 模型
	private int style = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getStyle() {
		return style;
	}

	public void setStyle(int style) {
		this.style = style;
	}

	public boolean isBold() {
		return (style & BOLD) > 0;
	}

	public boolean isItalic() {
		return (style & ITALIC) > 0;
	}

	public boolean isUnder() {
		return (style & UNDER) > 0;
	}

	@Override
	public String toString() {
		return String.format("%s %d %08x %03x", name, size, color, style);
	}

}
