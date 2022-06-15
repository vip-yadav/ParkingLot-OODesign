package com.example.commands;

import java.util.List;

import com.example.exceptions.NoSlotException;
import com.example.exceptions.VehicleAlreadyParkedException;
import com.example.helper.OutPrinter;
import com.example.models.commands.Command;
import com.example.models.slots.SlotCategory;
import com.example.models.slots.Vehicle;
import com.example.models.slots.VehicleCategory;
import com.example.services.ParkingLotService;

public class ParkCommandExecutor extends CommandExecutor {

	public static final String COMMAND_NAME = "park";

	public ParkCommandExecutor(ParkingLotService parkingLotService, OutPrinter outputPrinter) {
		super(parkingLotService, outputPrinter);
	}

	@Override
	public void runCommand(Command command) throws VehicleAlreadyParkedException, NoSlotException {
		List<String> params = command.getParams();
		String registratorNumber = params.get(0);
		String color = params.get(1);
		String categoryType = params.get(2);
		
		Vehicle vehicle = new Vehicle(registratorNumber, color, VehicleCategory.valueOf(categoryType));
		Integer slotId = this.parkingLotService.park(vehicle);
		outputPrinter.parkedSuccess(registratorNumber, slotId);
	}

	@Override
	public boolean valid(Command command) {
		List<String> params = command.getParams();
		if (params.size() == 3) {
			String categoryType = params.get(2);
			boolean flag = false;
			for(SlotCategory slot : SlotCategory.values()) {
				if(slot.getCategoryType().equals(categoryType)) {
					flag = true;
				}
			}
			return flag;
		}
		return false;
	}

}
