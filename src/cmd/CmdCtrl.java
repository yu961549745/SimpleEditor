package cmd;

import java.util.Stack;

public class CmdCtrl {
	private static final CmdCtrl INSTANCE = new CmdCtrl();

	public static CmdCtrl getInstance() {
		return INSTANCE;
	}

	private CmdCtrl() {
	}

	private Stack<AbsCmd> todoCmds = new Stack<AbsCmd>();
	private Stack<AbsCmd> redoCmds = new Stack<AbsCmd>();

	public void exec(AbsCmd cmd) {
		todoCmds.push(cmd);
		redoCmds.clear();
		cmd.exec();
	}

	public void undo() {
		if (!todoCmds.isEmpty()) {
			AbsCmd cmd = todoCmds.pop();
			redoCmds.push(cmd);
			cmd.undo();
		}
	}

	public void redo() {
		if (!redoCmds.isEmpty()) {
			AbsCmd cmd = redoCmds.pop();
			todoCmds.push(cmd);
			cmd.exec();
		}
	}
}
