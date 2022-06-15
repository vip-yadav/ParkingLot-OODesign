package com.example.mode;

import com.example.commands.CommandExecutor;
import com.example.commands.CommandExecutorFactory;
import com.example.exceptions.InvalidCommandException;
import com.example.helper.OutPrinter;
import com.example.models.commands.Command;

/*
 * abstract type of mode like fileInputOuputMode, commandLineInteractiveMode
 */
public abstract class Mode {
	private CommandExecutorFactory commandExecutorFactory;
	protected OutPrinter outputPrinter;

	public Mode(CommandExecutorFactory commandExecutorFactory, OutPrinter outputPrinter) {
		super();
		this.commandExecutorFactory = commandExecutorFactory;
		this.outputPrinter = outputPrinter;
	}

	protected void processCommand(Command command) throws InvalidCommandException {
		CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
		if (commandExecutor.valid(command)) {
			commandExecutor.runCommand(command);
		} else {
			throw new InvalidCommandException("command validation failed");
		}

	}

	public abstract void process();
}
