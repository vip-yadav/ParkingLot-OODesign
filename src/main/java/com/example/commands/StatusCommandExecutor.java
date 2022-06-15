package com.example.commands;

import java.util.List;

import com.example.helper.OutPrinter;
import com.example.models.commands.Command;
import com.example.services.ParkingLotService;

public class StatusCommandExecutor extends CommandExecutor {

	public static final String COMMAND_NAME = "status";

	public StatusCommandExecutor(ParkingLotService parkingLotService, OutPrinter outputPrinter) {
		super(parkingLotService, outputPrinter);
	}

	@Override
	public void runCommand(Command command) {
		outputPrinter.statusHeader();
		this.parkingLotService.status();

	}

	@Override
	public boolean valid(Command command) {
		List<String> params = command.getParams();
		if (params == null || params.size() == 0) {
			return true;
		}
		return false;
	}

}
