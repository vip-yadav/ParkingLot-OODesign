package com.example.models.commands;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.exceptions.InvalidCommandException;

/*
 * command pojo class which also separate command name and their params from input string
 */
public class Command {
	private static final String SEPARATER = " ";
	private String commandName;
	private List<String> params;

	public String getCommandName() {
		return commandName;
	}

	public List<String> getParams() {
		return params;
	}

	public Command(final String input) throws InvalidCommandException {
		List<String> tokenList = Arrays.stream(input.trim().split(SEPARATER)).map(String::trim)
				.filter(token -> (token.length() > 0)).collect(Collectors.toList());

		if (tokenList.size() == 0) {
			throw new InvalidCommandException("command invalid !!!");
		}

		this.commandName = tokenList.get(0);
		tokenList.remove(0);
		this.params = tokenList;

	}

}
