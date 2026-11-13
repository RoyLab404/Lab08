package designbook.solutions6.ex18;

import java.util.ArrayList;
import java.util.List;

import designbook.solutions6.ex15.UndoableCommand;

public class BasicCommandProcessor implements CommandProcessor {
	private final List<UndoableCommand> aExecutedCommands = new ArrayList<>();
	private final List<UndoableCommand> aUndoneCommands = new ArrayList<>();

	@Override
	public void consume(UndoableCommand pCommand) {
		pCommand.execute();
		aExecutedCommands.add(pCommand);
		aUndoneCommands.clear();
	}

	@Override
	public void undoLast() {
		assert !aExecutedCommands.isEmpty();
		UndoableCommand command = aExecutedCommands.removeLast();
		command.undo();
		aUndoneCommands.add(command);
	}

	@Override
	public void redoLast() {
		assert !aUndoneCommands.isEmpty();
		UndoableCommand command = aUndoneCommands.removeLast();
		consume(command);
	}
}
