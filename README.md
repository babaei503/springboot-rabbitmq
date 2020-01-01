# Spring Boot Microservices using RabbitMQ

```
1. rabbitmq-producer
2. rabbitmq-consumer
```

## rabbitmq-producer Microservice::

A producer is a piece of software that produces random scheduled events or manual events by calling http://localhost:8080/create-teacher REST endpoint. The producer sends those events to the RabbitMQ server to be stored in a queue. A queue is a first-in-first-out message store. The messages are put into a queue by a producer and read from it by a consumer. The producer put the messages to the queue through an Exchange. An Exchange is a concept that is part of the AMQP protocol. Basically, it acts as an intermediary between the producer and a queue. Instead of sending messages directly to a queue, a producer can send them to an Exchange. The Exchange then sends those messages to one or more queues following a specified set of rules. The event producing services only need to know the central Exchange and send all events to that Exchange.

## rabbitmq-consumer Microservice:

A consumer is a piece of software that receives messages from a queue and processes those messages. A binding connects a queue to an exchange. The exchange forwards all messages it receives to the queues it is bound to. A binding can contain a routing key that specifies which events should be forwarded. For example, a binding might contain the routing key student.* meaning that all events whose type starts with "student." will be routed to the specified queue. The consuming services take care of the binding and routing, we have a real, loosely coupled eventing mechanism. The rabbitmq-consumer runs as "student" profile with default application.properties and you can run the rabbitmq-consumer app as "course" or "teacher" profiles too.



