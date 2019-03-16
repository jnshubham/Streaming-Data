package kafka.producer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class GenerateXMLData {

	public HashMap<String, HashMap<String, Integer>> genMap(){
		HashMap<String, HashMap<String, Integer>> cost=new HashMap<String, HashMap<String, Integer>>();
		HashMap<String, Integer> in=new HashMap<String, Integer>();
		in.put("MP", 5);
		in.put("UP", 6);
		in.put("HP", 7);
		in.put("AP", 8);
		in.put("TN", 9);
		cost.put("Electricity", in);
		in.replace("MP", 5, 6);
		in.replace("UP", 6, 7);
		in.replace("HP", 7, 8);
		in.replace("AP", 8, 9);
		in.replace("TN", 9, 10);
		cost.put("NaturalGas", in);
		in.replace("MP", 6, 4);
		in.replace("UP", 7, 5);
		in.replace("HP", 8, 6);
		in.replace("AP", 9, 7);
		in.replace("TN", 10, 8);
		cost.put("Water", in);
		return cost;
	}
	
	
	public String generateXML(String id) throws IOException {
		RandomGenerator rg= new RandomGenerator();
		HashMap<String, HashMap<String, Integer>> cost=genMap();
		String[] area= {"MP","UP","AP","HP","TN"};
		Random r=new Random();
		int rn=r.nextInt(area.length);
		Element root=new Element("MunicipalCorporation");
		Element munC1=new Element("Customer").addContent(new Element("Id").addContent(id));
		
		Element munC2=new Element("BillDetails");
		Element Bill1=new Element("Electricity");
		Element Bill2=new Element("NaturalGas");
		Element Bill3=new Element("Water");
		
		Bill1.addContent(new Element("PendingDate").addContent(rg.getRandDate(20).toString()));
		Bill1.addContent(new Element("Reading").addContent(Integer.toString(rg.getRandInt(0, 1000))));
		Bill1.addContent(new Element("Area").addContent(area[rn]));		
		Bill1.addContent(new Element("Cost").addContent(Integer.toString(cost.get("Electricity").get(area[rn]))));

		Bill2.addContent(new Element("PendingDate").addContent(rg.getRandDate(20).toString()));
		Bill2.addContent(new Element("Reading").addContent(Integer.toString(rg.getRandInt(0, 1000))));
		Bill2.addContent(new Element("Area").addContent(area[rn]));		
		Bill2.addContent(new Element("Cost").addContent(Integer.toString(cost.get("NaturalGas").get(area[rn]))));
		
		Bill3.addContent(new Element("PendingDate").addContent(rg.getRandDate(20).toString()));
		Bill3.addContent(new Element("Reading").addContent(Integer.toString(rg.getRandInt(0, 1000))));
		Bill3.addContent(new Element("Area").addContent(area[rn]));		
		Bill3.addContent(new Element("Cost").addContent(Integer.toString(cost.get("Water").get(area[rn]))));
	
		munC2.addContent(Bill1);
		munC2.addContent(Bill2);
		munC2.addContent(Bill3);
		
		root.addContent(munC1);
		root.addContent(munC2);
		Document doc=new Document();
	//	UNIX_TS	WHE	RSE	GRE	MHE	B1E	BME	CWE	DWE	EQE	FRE	HPE	OFE	UTE	WOE	B2E	CDE	DNE	EBE	FGE	HTE	OUE	TVE	UNE
		doc.setRootElement(root);

		XMLOutputter outter=new XMLOutputter();
		outter.setFormat(Format.getPrettyFormat());
		ByteArrayOutputStream bs=new ByteArrayOutputStream();
		outter.output(doc, bs);
		String data=bs.toString();
		return data;
	}
	

}
