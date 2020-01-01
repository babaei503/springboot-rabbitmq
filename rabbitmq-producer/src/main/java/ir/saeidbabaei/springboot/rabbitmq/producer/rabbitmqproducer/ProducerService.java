package ir.saeidbabaei.springboot.rabbitmq.producer.rabbitmqproducer;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

public class ProducerService {

  private final RabbitTemplate rabbitTemplate;

  private final Exchange exchange;

  private static List<String> ROUTING_KEYS = Arrays.asList(
          "student.created",
          "course.created");

  private Random random = new Random();
  
  private int messageNumber = 0;
  
  public ProducerService(RabbitTemplate rabbitTemplate, Exchange exchange) {
    this.rabbitTemplate = rabbitTemplate;
    this.exchange = exchange;
  }

  @Scheduled(fixedDelay = 1000, initialDelay = 500)
  public void createScheduledProducer() {

	String routingKey =  ROUTING_KEYS.get(random.nextInt(ROUTING_KEYS.size()));
	
    String message = String.format("Event no. %d of type '%s'", ++messageNumber, routingKey);
    
    rabbitTemplate.convertAndSend(exchange.getName(), routingKey, message);
  }
  
  public void createManualProducer() {

	String routingKey = "teacher.created";
	
    String message = String.format("Event no. %d of type '%s'", ++messageNumber, routingKey);
    
    rabbitTemplate.convertAndSend(exchange.getName(), routingKey, message);
  }

}