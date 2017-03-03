package com.vivek.ycompany.search.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.vivek.ycompany.search.entity.Appointment;

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
	public void processMessage(Appointment appointment) {
		logger.info("updating appointments=" + appointment);
		searchComponent.updateAppointment(appointment);

	}
}