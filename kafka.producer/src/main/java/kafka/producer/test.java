package kafka.producer;

import java.io.IOException;
import java.time.LocalDate;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//LocalDate td=LocalDate.now();
		//System.out.println(td.minusDays(-7));
		GenerateXMLData d=new GenerateXMLData();
		try {
			String data=d.generateXML("123");
			System.out.println(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
				
				
	}

}
