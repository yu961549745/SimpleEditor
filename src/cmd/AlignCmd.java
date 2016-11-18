package cmd;

import align_strategy.AlignStrategyFactory;
import ui.IDocCtrl;
import doc.IAlign;
import doc.TextRange;

public class AlignCmd extends AbsCmd {
	private IAlign src;
	private IAlign dst;
	private TextRange range;

	public AlignCmd(IAlign src, IAlign dst, TextRange range, IDocCtrl docCtrl) {
		this.src = src;
		this.dst = dst;
		this.range = range;
		setDocCtrl(docCtrl);
	}

	@Override
	public void exec() {
		getDocCtrl().setSelected(range);
		AlignStrategyFactory.getAlignStrategy(dst).setAlign(getDocCtrl());
	}

	@Override
	public void undo() {
		getDocCtrl().setSelected(range);
		AlignStrategyFactory.getAlignStrategy(src).setAlign(getDocCtrl());
	}

}
