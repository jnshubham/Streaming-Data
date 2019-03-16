package kafka.producer;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class RunApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runProducer();
	}
	static void runProducer() {
		Producer<Long, String> producer = DataProducer.createProducer();
		int id=0;
		GenerateXMLData xmlD=new GenerateXMLData();
		for (int index = 0; index < 100; index++) {
			try {
				String data=xmlD.generateXML(Integer.toString(id++));
				ProducerRecord<Long, String> record = new ProducerRecord<Long, String>("MunicipalXML",data);
				RecordMetadata metadata = producer.send(record).get();
				System.out.println("Record sent with key " + index + " to partition " + metadata.partition()
				+ " with offset " + metadata.offset());
			} 
			catch (ExecutionException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			} 
			catch (InterruptedException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
