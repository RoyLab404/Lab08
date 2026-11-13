package designbook.solutions6.ex18;

import designbook.solutions6.Movie;

public class Exercise18 {
	public static void main(String[] args) {
		Program program = new Program(new BasicCommandProcessor());
		program.add(new Movie("Original", 2000, 120), Program.Day.MONDAY);
		program.add(new Movie("Replacement", 2010, 90), Program.Day.MONDAY);
		if (!"Replacement (2010)".equals(program.get(Program.Day.MONDAY).description())) {
			throw new IllegalStateException("add did not replace the existing show");
		}
		program.undoLast();
		if (!"Original (2000)".equals(program.get(Program.Day.MONDAY).description())) {
			throw new IllegalStateException("undoLast did not restore the replaced show");
		}
		program.redoLast();
		if (!"Replacement (2010)".equals(program.get(Program.Day.MONDAY).description())) {
			throw new IllegalStateException("redoLast did not reapply the replacement");
		}
		System.out.println("Exercise 6.18: Program delegates undo/redo to its injected processor.");
	}
}
