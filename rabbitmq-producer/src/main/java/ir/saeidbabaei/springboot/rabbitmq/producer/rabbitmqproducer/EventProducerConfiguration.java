package ir.saeidbabaei.springboot.rabbitmq.producer.rabbitmqproducer;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class EventProducerConfiguration {

 @Bean
 public Exchange eventExchange() {
   return new TopicExchange("eventExchange");
 }

 @Bean
 public CustomerService customerService(RabbitTemplate rabbitTemplate, Exchange eventExchange) {
   return new CustomerService(rabbitTemplate, eventExchange);
 }

}