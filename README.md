## 

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
