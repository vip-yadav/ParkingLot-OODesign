package com.example.commands;

import java.util.List;

import com.example.exceptions.NoSuchVehicleParkedException;
import com.example.helper.OutPrinter;
import com.example.models.commands.Command;
import com.example.services.ParkingLotService;

public class UnparkCommandExecutor extends CommandExecutor {
	public static final String COMMAND_NAME = "unpark";

	public UnparkCommandExecutor(ParkingLotService parkingLotService, OutPrinter outputPrinter) {
		super(parkingLotService, outputPrinter);
	}

	@Override
	public void runCommand(Command command) throws NoSuchVehicleParkedException {
		String registrationNumber = command.getParams().get(0);
		double cost = this.parkingLotService.unpark(registrationNumber);
		outputPrinter.unParkedSuccess(cost);
	}

	@Override
	public boolean valid(Command command) {
		List<String> params = command.getParams();
		if (params.size() == 1) {
			return true;
		}
		return false;
	}

}
