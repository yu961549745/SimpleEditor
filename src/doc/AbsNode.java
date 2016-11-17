package doc;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsNode implements DocNode {
	private List<DocNode> childs = new ArrayList<DocNode>();

	@Override
	public void addChild(DocNode node) {
		childs.add(node);
	}

	@Override
	public List<DocNode> getChilds() {
		return childs;
	}

	@Override
	public void acept(DocVisitor visitor) {
		visitor.visit(this);
		for (DocNode node : childs) {
			visitor.visit(node);
		}
	}
}
