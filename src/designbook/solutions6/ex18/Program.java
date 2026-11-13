package designbook.solutions6.ex18;

import java.util.EnumMap;

import designbook.solutions6.Show;
import designbook.solutions6.ex15.UndoableCommand;

public class Program {
	public enum Day {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}

	private static final Show NULL_SHOW = createNullShow();
	private final EnumMap<Day, Show> aShows = new EnumMap<>(Day.class);
	private final CommandProcessor aProcessor;

	public Program(CommandProcessor pProcessor) {
		if (pProcessor == null) {
			throw new IllegalArgumentException("CommandProcessor cannot be null");
		}
		aProcessor = pProcessor;
		clearWithoutCommand();
	}

	public void add(Show pShow, Day pDay) {
		if (pShow == null || pDay == null) {
			throw new IllegalArgumentException("Show and day cannot be null");
		}
		aProcessor.consume(createAddCommand(pShow, pDay));
	}

	public void remove(Day pDay) {
		if (pDay == null) {
			throw new IllegalArgumentException("Day cannot be null");
		}
		aProcessor.consume(createRemoveCommand(pDay));
	}

	public void clear() {
		aProcessor.consume(createClearCommand());
	}

	public void undoLast() {
		aProcessor.undoLast();
	}

	public void redoLast() {
		aProcessor.redoLast();
	}

	public Show get(Day pDay) {
		if (pDay == null) {
			throw new IllegalArgumentException("Day cannot be null");
		}
		return aShows.get(pDay).copy();
	}

	private UndoableCommand createAddCommand(Show pShow, Day pDay) {
		return new UndoableCommand() {
			private Show previousShow;

			@Override
			public void execute() {
				previousShow = aShows.get(pDay);
				aShows.put(pDay, pShow);
			}

			@Override
			public void undo() {
				aShows.put(pDay, previousShow);
			}
		};
	}

	private UndoableCommand createRemoveCommand(Day pDay) {
		return new UndoableCommand() {
			private Show previousShow;

			@Override
			public void execute() {
				previousShow = aShows.get(pDay);
				aShows.put(pDay, NULL_SHOW);
			}

			@Override
			public void undo() {
				aShows.put(pDay, previousShow);
			}
		};
	}

	private UndoableCommand createClearCommand() {
		return new UndoableCommand() {
			private EnumMap<Day, Show> previousShows;

			@Override
			public void execute() {
				previousShows = new EnumMap<>(aShows);
				clearWithoutCommand();
			}

			@Override
			public void undo() {
				aShows.clear();
				aShows.putAll(previousShows);
			}
		};
	}

	private void clearWithoutCommand() {
		for (Day day : Day.values()) {
			aShows.put(day, NULL_SHOW);
		}
	}

	private static Show createNullShow() {
		return new Show() {
			@Override
			public String description() { return ""; }
			@Override
			public int runningTime() { return 0; }
			@Override
			public Show copy() { return createNullShow(); }
			@Override
		public int hashCode() { return 0; }
			@Override
		public boolean equals(Object pObject) {
				return pObject != null && pObject.getClass() == getClass();
			}
		};
	}
}
