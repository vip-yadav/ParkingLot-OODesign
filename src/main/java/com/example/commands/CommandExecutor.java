package com.example.commands;

import com.example.helper.OutPrinter;
import com.example.models.commands.Command;
import com.example.services.ParkingLotService;

public abstract class CommandExecutor {
	protected ParkingLotService parkingLotService;
	protected OutPrinter outputPrinter;

	public CommandExecutor(ParkingLotService parkingLotService, OutPrinter outputPrinter) {
		super();
		this.parkingLotService = parkingLotService;
		this.outputPrinter = outputPrinter;
	}

	public abstract void runCommand(Command command);

	public abstract boolean valid(Command command);

}
