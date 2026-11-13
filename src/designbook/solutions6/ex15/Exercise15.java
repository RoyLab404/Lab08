package designbook.solutions6.ex15;

import java.util.ArrayList;
import java.util.List;

import designbook.solutions6.Movie;

public class Exercise15 {
	public static void main(String[] args) {
		Program3 program = new Program3();
		List<UndoableCommand> commands = new ArrayList<>();
		List<String> states = new ArrayList<>();
		states.add(program.toString());

		commands.add(program.createAddCommand(new Movie("Movie 1", 2000, 120), Program3.Day.MONDAY));
		commands.add(program.createAddCommand(new Movie("Movie 2", 2010, 90), Program3.Day.WEDNESDAY));
		commands.add(program.createRemoveCommand(Program3.Day.MONDAY));
		commands.add(program.createClearCommand());

		for (UndoableCommand command : commands) {
			command.execute();
			states.add(program.toString());
		}
		for (int i = commands.size() - 1; i >= 0; i--) {
			commands.get(i).undo();
			check(states.get(i).equals(program.toString()), "undo command " + (i + 1));
		}
		System.out.println("Exercise 6.15: undo restored each previous program state.");
	}

	private static void check(boolean condition, String operation) {
		if (!condition) {
			throw new IllegalStateException("Failed after " + operation);
		}
	}
}
