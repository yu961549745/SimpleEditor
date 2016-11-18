package doc;

import java.util.List;

public interface DocNode {
	public void addChild(DocNode node);

	public List<DocNode> getChilds();

}
