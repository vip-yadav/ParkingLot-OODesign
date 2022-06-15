package com.example.mode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.example.commands.CommandExecutorFactory;
import com.example.commands.ExitCommandExecutor;
import com.example.helper.OutPrinter;
import com.example.models.commands.Command;

/*
 * CommandLineInteractiveMode
 */
public class InteractiveMode extends Mode {

	public InteractiveMode(CommandExecutorFactory commandExecutorFactory, OutPrinter outputPrinter) {
		super(commandExecutorFactory, outputPrinter);
	}

	@Override
	public void process() {
		outputPrinter.welcome();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String input;
			try {
				input = bufferedReader.readLine();
				Command command = new Command(input);
				processCommand(command);
				if (command.getCommandName().equals(ExitCommandExecutor.COMMAND_NAME)) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}catch (RuntimeException ex) {
				ex.printStackTrace();
			}
		}
	}

}
