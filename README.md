# Description

Exchanges are like post offices or mailboxes and clients publish a message to an AMQP exchange. 
There are four built-in exchange types

```
1. Direct Exchange – Routes messages to a queue by matching a complete routing key
2. Fanout Exchange – Routes messages to all the queues bound to it
3. Topic Exchange – Routes messages to multiple queues by matching a routing key to a pattern
4. Headers Exchange – Routes messages based on message headers
```
Queues are bound to an exchange using a routing key
Messages are sent to an exchange with a routing key. The exchange then distributes copies of messages to queues


# Queues , 
 This application define 3 queues
	
```
1. emailQueue : It bind to direct exchange (directEX) with Routing key EMAIL, and to topic exchahge (topicEx) with *.emailQueue.*
2. pagerQueue : It bind to direct exchange (directEX) with Routing key PAGER, and to topic exchahge (topicEx) with *.pagerQueue.*
3. smsQueue : It bind to direct exchange (directEX) with Routing key SMS, and to topic exchahge (topicEx) with *.smsQueue.*
```


# Request json: 
```
{ "msgLabel": "Message Message Message", "msgBody":  "This is your message", "routingKey": "ABC" }
```
This application expose 3 endpoints.  send/fanout , send/topic, send/direct, messages are routed based of passed routingKey in request body. 




  
