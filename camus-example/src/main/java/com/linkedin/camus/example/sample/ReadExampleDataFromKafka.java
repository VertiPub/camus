package com.linkedin.camus.example.sample;


import java.util.Properties;
import java.nio.ByteBuffer;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import kafka.api.FetchRequest;
import kafka.javaapi.MultiFetchResponse;
import kafka.javaapi.consumer.SimpleConsumer;
import kafka.javaapi.message.ByteBufferMessageSet;
import kafka.message.MessageAndOffset;
import kafka.message.Message;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Parser;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.BinaryDecoder;

import com.linkedin.camus.example.sample.ExampleData;


public class ReadExampleDataFromKafka {

    public static void printMessages (ByteBufferMessageSet messageSet) throws IOException {

	DecoderFactory decoderFactory = DecoderFactory.get();
	Schema schema = new ExampleData().getSchema();

	for (MessageAndOffset messageAndOffset : messageSet) {

	    Message message = messageAndOffset.message();
	    
	    ByteBuffer buffer = message.payload();
	    byte [] bytes = new byte[buffer.remaining()];
	    buffer.get(bytes);

	    DatumReader<GenericRecord> datumReader = new GenericDatumReader<GenericRecord>(schema);
	    BinaryDecoder binaryDecoder = decoderFactory.binaryDecoder(bytes, null);

	    GenericRecord gr = datumReader.read(null, binaryDecoder);

	    System.out.println(gr);                                                                                                                                                
	}
    }

    public static void main(String[] args) throws IOException {

	// Get ZooKeeper connection string
	if (args.length != 2) {
	    System.err.println("Usage: ReadExampleDataFromKafka <Kafka Broker eg. localhost:9092> <Kafka Topic eg. EXAMPLE_LOG>");
	    System.exit(1);
	}

	String []kafkaBrokerArr = args[0].split(":");
	String kTopic = args[1];

	String kafkaBroker = kafkaBrokerArr[0];
	int port = Integer.parseInt(kafkaBrokerArr[1]);

	SimpleConsumer simpleConsumer = new SimpleConsumer(kafkaBroker, port, 100000, 64*1024);
	FetchRequest req = new FetchRequest(kTopic, 0, 0L, 1000);

	ByteBufferMessageSet messageSet = simpleConsumer.fetch(req);
	printMessages(messageSet);

    }
}