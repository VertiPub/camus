# Introduction

This is a sample set of files illustrating an end to end use case for camus. This uses the Avro schema as given in camus/camus-example/src/main/avro/ExampleData.avsc. The manifst of this directory is as follows:

* ExampleData.java - Avro generated class from ExampleData.avsc
* WriteExampleDataToKafka.java, ExampleDataSerializer.java - not required by Camus but packaged here for convenience. Writes ExampleData events to a Kafka broker.
* ReadExampleDataFromKafka.java - again, not required by Camus but included as an example Kafka-only Consumer that reads ExampleData events from a Kafka broker.
* ExampleDataSchemaRegistry.java - registers the ExampleData schema with Camus for the "EXAMPLE_LOG" topic.
* ExampleDataMessageDecoder.java - used by Camus to decode the messages pulled from Kafka

# Writing Events To Kafka

As a prerequisite, we assume Kafka and ZooKeeper are running and accessible.

First, build camus. "mvn install" in the root camus directory will create a jar, camus/camus-example/target/camus-example-0.1.0-SNAPSHOT-shaded.jar, that contains all the camus classes and dependencies.

Next, write dummy events into Kafka under the "EXAMPLE_LOG" topic. Invoke:
```
java -cp ~/camus/camus-example/target/camus-example-0.1.0-SNAPSHOT-shaded.jar com.linkedin.camus.example.sample.WriteExampleDataToKafka <ZooKeeperHost>:<ZooKeeper Port eg. 2181> EXAMPLE_LOG
```

# Reading Events From Kafka

You can test whether events were written to the target Kafka broker by running the included Kafka Consumer:

```
java -cp ~/camus/camus-example/target/camus-example-0.1.0-SNAPSHOT-shaded.jar com.linkedin.camus.example.sample.ReadExampleDataFromKafka <KafkaHost>:<Kafka Port eg. 9092> EXAMPLE_LOG
```

# Invoking Camus To Read Events From Kafka Broker

Prior to invoking camus, make sure camus.properties has the following changes:

```
zookeeper.hosts=<your ZooKeeper host>
camus.message.decoder.class=com.linkedin.camus.example.sample.ExampleDataMessageDecoder
kafka.message.coder.schema.registry.class=com.linkedin.camus.example.sample.ExampleDataSchemaRegistry
```

\# Optional is to include EXAMPLE_LOG in the topic whitelist:

```
kafka.whitelist.topics=EXAMPLE_LOG
```

Invoke Camus as follows:

```
hadoop jar ~/camus/camus-example/target/camus-example-0.1.0-SNAPSHOT-shaded.jar  com.linkedin.camus.etl.kafka.CamusJob -P ~/camus.properties
```

Once it completes, you should see data in HDFS:
```
<camus output directory as per camus.properties>/EXAMPLE_LOG/<etc> 
```
For example, hdfs:///tmp/camus/EXAMPLE_LOG/






