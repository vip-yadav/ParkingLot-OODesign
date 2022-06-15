package com.example.commands;

import java.util.HashMap;
import java.util.Map;

import com.example.exceptions.InvalidCommandException;
import com.example.helper.OutPrinter;
import com.example.models.commands.Command;
import com.example.services.ParkingLotService;

/*
 * Command routing class, routing to appropriate commandType to execute
 */
public class CommandExecutorFactory {
	private Map<String, CommandExecutor> commandRouter = new HashMap<>();

	public CommandExecutorFactory(final ParkingLotService parkingLotService, final OutPrinter outputPrinter) {
		commandRouter.put(CreateParkingCommandExecutor.COMMAND_NAME,
				new CreateParkingCommandExecutor(parkingLotService, outputPrinter));
		commandRouter.put(ParkCommandExecutor.COMMAND_NAME, new ParkCommandExecutor(parkingLotService, outputPrinter));
		commandRouter.put(UnparkCommandExecutor.COMMAND_NAME,
				new UnparkCommandExecutor(parkingLotService, outputPrinter));
		commandRouter.put(ExitCommandExecutor.COMMAND_NAME, new ExitCommandExecutor(parkingLotService, outputPrinter));
		commandRouter.put(StatusCommandExecutor.COMMAND_NAME,
				new StatusCommandExecutor(parkingLotService, outputPrinter));
	}

	public CommandExecutor getCommandExecutor(Command command) throws InvalidCommandException {
		CommandExecutor commandExecutor = commandRouter.get(command.getCommandName());
		if (commandExecutor == null) {
			throw new InvalidCommandException("command name mismatch. Please verify again !!!");
		}

		return commandExecutor;
	}

}
