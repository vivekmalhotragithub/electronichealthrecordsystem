package com.vivek.ycompany.search.component;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	private static final Logger logger = LoggerFactory
			.getLogger(Receiver.class);

	SearchComponent searchComponent;

	@Autowired
	public Receiver(SearchComponent searchComponent) {
		this.searchComponent = searchComponent;
	}

	@Bean
	Queue queue() {
		return new Queue("SearchQ", false);
	}

	@RabbitListener(queues = "SearchQ")
	public void processMessage(Map<String, Object> data) {
		logger.info("updating appointments=" + data);
		searchComponent.updateAppointment((Long) data.get("APPOINTMENT_ID"),
				(Long) data.get("DOCTOR_ID"), (Long) data.get("PATIENT_ID"),
				(String) data.get("PATIENT_NAME"),
				(String) data.get("PATIENT_EMAIL"),
				(Date) data.get("APPOINTMENT_DATE"));

	}
}