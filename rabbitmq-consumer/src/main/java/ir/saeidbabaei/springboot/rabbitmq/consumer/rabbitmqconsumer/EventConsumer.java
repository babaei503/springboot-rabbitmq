package ir.saeidbabaei.springboot.rabbitmq.consumer.rabbitmqconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class EventConsumer {

	  private Logger logger = LoggerFactory.getLogger(EventConsumer.class);
	  	  
	  @RabbitListener(queues="${consumer.queue}")
	  public void receive(String message) {
		  
	    logger.info("Received message '{}'", message);
	    
	  }

}