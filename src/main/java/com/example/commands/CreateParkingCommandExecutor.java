package com.example.commands;

import java.util.List;

import com.example.helper.IntegerValidator;
import com.example.helper.OutPrinter;
import com.example.models.commands.Command;
import com.example.services.ParkingLot;
import com.example.services.ParkingLotService;
import com.example.strategy.NaturalOrderStrategy;

public class CreateParkingCommandExecutor extends CommandExecutor {
	public static final String COMMAND_NAME = "create_parking_lot";

	public CreateParkingCommandExecutor(ParkingLotService parkingLotService, OutPrinter outputPrinter) {
		super(parkingLotService, outputPrinter);
	}

	@Override
	public void runCommand(Command command) {
		ParkingLot parkingLot = null;
		if (command.getParams().size() == 0) {
			parkingLot = new ParkingLot(new NaturalOrderStrategy());
		} else {
			parkingLot = new ParkingLot(new NaturalOrderStrategy(), Integer.parseInt(command.getParams().get(0)));
		}

		parkingLotService.createParkingLot(parkingLot);
		outputPrinter.createParkingLotSuccess();
	}

	@Override
	public boolean valid(Command command) {
		List<String> params = command.getParams();
		if (params.size() > 1) {
			return false;
		} else if (params.size() == 1) {
			return IntegerValidator.isInteger(params.get(0));
		}

		return true;
	}

}
