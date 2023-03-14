package api.share.training.model.dto;

import java.time.Instant;
import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeadersExchange {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	private String tenant = "training";

	public void send(String entity, String source, String action, String resource, String payload) {

		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setTimestamp(Date.from(Instant.now()));
		messageProperties.setHeader("tenantId", tenant);
		messageProperties.setHeader("entity",entity);
		messageProperties.setHeader("source",source);
		messageProperties.setHeader("action",action);
		messageProperties.setHeader("resource",resource);
		
		MessageConverter messageConverter = new SimpleMessageConverter();
		Message message = messageConverter.toMessage(payload, messageProperties);
		System.out.println(message.toString());
		amqpTemplate.send("headers-exchange", "", message);

	}
	
	public void send(String entity, String source, String action, String resource, String event, String payload) {

		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setTimestamp(Date.from(Instant.now()));
		messageProperties.setHeader("tenantId", tenant);
		messageProperties.setHeader("entity",entity);
		messageProperties.setHeader("source",source);
		messageProperties.setHeader("action",action);
		messageProperties.setHeader("resource",resource);
		messageProperties.setHeader("event",event);
		
		MessageConverter messageConverter = new SimpleMessageConverter();
		Message message = messageConverter.toMessage(payload, messageProperties);
		System.out.println(message.toString());
		amqpTemplate.send("headers-exchange", "", message);

	}
	
	
}
