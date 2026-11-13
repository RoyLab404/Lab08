package designbook.solutions6.ex18;

import designbook.solutions6.ex15.UndoableCommand;

public interface CommandProcessor {
	void consume(UndoableCommand pCommand);

	void undoLast();

	void redoLast();
}
