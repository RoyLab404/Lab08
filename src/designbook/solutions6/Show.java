/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java"
 * by Martin P. Robillard.
 *
 * Copyright (C) 2026 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 *
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 ******************************************************************************/
package designbook.solutions6;

/** Represents a performance that can take place in a theater. */
public interface Show {
	String description();

	int runningTime();

	Show copy();
}
