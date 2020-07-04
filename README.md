# spring-boot-kafka
Ejemplo Productor - Consumidor con apache kafka

## Start Zookeeper
- `bin/zookeeper-server-start.sh config/zookeeper.properties`

## Start Kafka Server
- `bin/kafka-server-start.sh config/server.properties`

## Create Kafka Topic
- `bin/kafka-topics.sh --create --bootstrap-server localhost:9092  --repliction-factor 1 --partitions 1 --topic kafka-ejemplo`
- `bin/kafka-topics.sh --create --bootstrap-server localhost:9092  --repliction-factor 1 --partitions 1 --topic kafka-ejemplo-json`

## Publish to the Kafka Topic via Console
- `bin/kafka-console-producer.sh --broker-list localhost:9092 --topic kafka-ejemplo`

## Consume from the Kafka Topic via Console
- `bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic kafka-ejemplo --from-beginning`
