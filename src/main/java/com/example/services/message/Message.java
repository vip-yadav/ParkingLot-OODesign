package com.example.services.message;

import java.util.Date;

public class Message {
	private String registrationNumber;
	private String color;
	private String category;
	private String parkedAt;
	private Integer slotId;
	private Date since;

	public Message(String registrationNumber, String color, String category, String parkedAt, Integer slotId,
			Date since) {
		super();
		this.registrationNumber = registrationNumber;
		this.color = color;
		this.category = category;
		this.parkedAt = parkedAt;
		this.slotId = slotId;
		this.since = since;
	}

	@Override
	public String toString() {
		return "Message [registrationNumber=" + registrationNumber + ", color=" + color + ", category=" + category
				+ ", parkedAt=" + parkedAt + ", slotId=" + slotId + ", since=" + since + "]";
	}

}
