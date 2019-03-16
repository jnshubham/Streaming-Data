package kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class DataProducer extends Thread {
		public static Producer<Long, String> createProducer(){
			Properties prop=new Properties();
			prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9091,localhost:9093");
			prop.put(ProducerConfig.CLIENT_ID_CONFIG, "Municipal");
	        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
	        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	        KafkaProducer<Long, String> producer = new KafkaProducer<>(prop);
	        return producer;
		}

}
