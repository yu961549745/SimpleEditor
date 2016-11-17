package doc;

public class TextRange {
	private int start;
	private int end;

	public TextRange(int s, int e) {
		start = s;
		end = e;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
