package doc;


public class Text extends AbsNode{
	private IFont font;
	private String string;

	public IFont getFont() {
		return font;
	}

	public void setFont(IFont font) {
		this.font = font;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
	
	@Override
	public void addChild(DocNode node) {
		throw new UnsupportedOperationException();
	}

}
