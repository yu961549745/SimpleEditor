package doc;

public abstract class Img extends AbsNode {
	private String base64;

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	@Override
	public void addChild(DocNode node) {
		throw new UnsupportedOperationException();
	}
}
