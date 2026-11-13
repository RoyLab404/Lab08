package designbook.solutions6.ex16;

import designbook.solutions6.Movie;
import designbook.solutions6.ex15.Program3;

public class Exercise16 {
	public static void main(String[] args) {
		Program3 program = new Program3();
		CommandProcessor processor = new CommandProcessor();
		processor.consume(program.createAddCommand(new Movie("Movie 1", 2000, 120), Program3.Day.MONDAY));
		processor.consume(program.createAddCommand(new Movie("Movie 2", 2010, 90), Program3.Day.WEDNESDAY));
		String afterCommands = program.toString();
		processor.undoLast();
		if (!program.toString().contains("Movie 1 (2000)") || program.toString().contains("Movie 2 (2010)")) {
			throw new IllegalStateException("undoLast did not undo the most recent command");
		}
		processor.undoLast();
		if (!program.toString().equals(new Program3().toString()) || afterCommands.equals(program.toString())) {
			throw new IllegalStateException("undoLast did not restore the initial state");
		}
		System.out.println("Exercise 6.16: CommandProcessor executed and undid commands.");
	}
}
