package ir.saeidbabaei.springboot.rabbitmq.consumer.rabbitmqconsumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConsumerConfiguration {

  @Value("${consumer.queue}")
  private String queueName;

  @Value("${consumer.routingKey}")
  private String routingKey;
	  
  @Bean
  public Exchange eventExchange() {
    return new TopicExchange("eventExchange");
  }

  @Bean
  public Queue queue() {
    return new Queue(queueName);
  }

  @Bean
  public Binding binding(Queue queue, Exchange eventExchange) {
    return BindingBuilder
            .bind(queue)
            .to(eventExchange)
            .with(routingKey).noargs();
  }

  @Bean
  public EventConsumer eventReceiver() {
    return new EventConsumer();
  }

}