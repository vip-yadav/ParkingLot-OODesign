package com.example.main;

import com.example.commands.CommandExecutorFactory;
import com.example.helper.OutPrinter;
import com.example.mode.Mode;
import com.example.mode.ModeFactory;
import com.example.services.ParkingLotService;

/*
 * Main Driver class
 */
public class Main {

	public static void main(String[] args) {
		final OutPrinter outputPrinter = new OutPrinter();
		final CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(new ParkingLotService(),
				outputPrinter);

		ModeFactory modeFactory = new ModeFactory();
		Mode mode = modeFactory.getMode(commandExecutorFactory, outputPrinter, args);
		mode.process();
	}

}
