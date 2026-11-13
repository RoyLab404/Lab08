package designbook.solutions6.ex17;

import designbook.solutions6.Movie;
import designbook.solutions6.ex15.Program3;

public class Exercise17 {
	public static void main(String[] args) {
		Program3 program = new Program3();
		CommandProcessor2 processor = new CommandProcessor2();
		processor.consume(program.createAddCommand(new Movie("Movie 1", 2000, 120), Program3.Day.MONDAY));
		String afterAdd = program.toString();
		processor.undoLast();
		processor.redoLast();
		if (!afterAdd.equals(program.toString())) {
			throw new IllegalStateException("redoLast did not restore the executed state");
		}
		System.out.println("Exercise 6.17: redoLast re-executed the last undone command.");
	}
}
