package designbook.solutions6.ex16;

import java.util.ArrayList;
import java.util.List;

import designbook.solutions6.ex15.UndoableCommand;

class CommandProcessor {
	private final List<UndoableCommand> aCommands = new ArrayList<>();

	public void consume(UndoableCommand pCommand) {
		pCommand.execute();
		aCommands.add(pCommand);
	}

	public void undoLast() {
		assert !aCommands.isEmpty();
		UndoableCommand command = aCommands.removeLast();
		command.undo();
	}
}
