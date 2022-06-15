package com.example.mode;

import com.example.commands.CommandExecutorFactory;
import com.example.helper.OutPrinter;

/*
 * InputMode factory, if there comes any new input mode, then add a class and change here only.
 * 
 * 1.) for interactiveMode
 * 		java main.java
 * 	or
 * 		java main.java command
 * 
 * 2.) for fileMode
 * 		java main.java file <fileName>
 */
public class ModeFactory {
	private static final String FILE = "file";
	private static final String INTERACTIVE = "command";

	public Mode getMode(CommandExecutorFactory commandExecutorFactory, OutPrinter outputPrinter, String[] args) {
		if (args.length == 0) {
			return new InteractiveMode(commandExecutorFactory, outputPrinter);
		} else if (args[0].equals(FILE)) {
			return new FileMode(commandExecutorFactory, outputPrinter, args[1]);
		} else if (args[0].equals(INTERACTIVE)) {
			return new InteractiveMode(commandExecutorFactory, outputPrinter);
		}
		return null;
	}

}
