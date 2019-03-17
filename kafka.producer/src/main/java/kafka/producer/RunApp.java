package kafka.producer;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class RunApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			runProducer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("An Error Occured:"+e.getMessage());
		}
	}
	static void runProducer() throws InterruptedException, IOException, ExecutionException {
		Producer<Long, String> producer = DataProducer.createProducer();
		int id=0;
		GenerateXMLData xmlD=new GenerateXMLData();
		while(true) {
			for (int index = 0; index < 100; index++) {

				String data=xmlD.generateXML(Integer.toString(id++));
				ProducerRecord<Long, String> record = new ProducerRecord<Long, String>("MunicipalXML",data);
				RecordMetadata metadata = producer.send(record).get();
				System.out.println("Record sent with key " + index + " to partition " + metadata.partition()
				+ " with offset " + metadata.offset());
			}
			Thread.sleep(60);
		}
	}

}
