package com.example.mode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.example.commands.CommandExecutorFactory;
import com.example.helper.OutPrinter;
import com.example.models.commands.Command;

/*
 * FileInputOuputMode
 */
public class FileMode extends Mode {

	private String fileName;

	public FileMode(CommandExecutorFactory commandExecutorFactory, OutPrinter outputPrinter, String fileName) {
		super(commandExecutorFactory, outputPrinter);
		this.fileName = fileName;
	}

	@Override
	public void process() {
		final File file = new File(fileName);
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			outputPrinter.invalidFile();
			return;
		}

		try {
			String input = bufferedReader.readLine();
			while (input != null) {
				Command command = new Command(input);
				processCommand(command);
				input = bufferedReader.readLine();
			}

			bufferedReader.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch(RuntimeException ex) {
			ex.printStackTrace();
		}
	}

}
