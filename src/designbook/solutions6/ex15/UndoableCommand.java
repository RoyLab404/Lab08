/*******************************************************************************
 * Based on the Exercise 15 solution for "Introduction to Software Design with Java"
 * by Martin P. Robillard. Kept in a separate public type for reuse by later exercises.
 *
 * Copyright (C) 2026 by Martin P. Robillard
 * Licensed under CC BY-NC-ND 4.0: http://creativecommons.org/licenses/by-nc-nd/4.0/
 ******************************************************************************/
package designbook.solutions6.ex15;

import designbook.solutions6.Command;

public interface UndoableCommand extends Command {
	void undo();
}
