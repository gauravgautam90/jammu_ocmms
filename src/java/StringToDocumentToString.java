
 
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
 
public class StringToDocumentToString {
 
    public static void main(String[] args) {
      //  final String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"+
      //                          "<Emp id=\"1\"><name>Pankaj</name><age>25</age>\n"+
      //                          "<role>Developer</role><gen>Male</gen></Emp>";
        
        
   //     Document doc = convertStringToDocument(xmlStr);
         
   //     String str = convertDocumentToString(doc);
     //   System.out.println(str);
        
       // String abc = createXML("1234","4321","02/06/16","Y","2.0");
        
    }
 
    private static String convertDocumentToString(Document doc) {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();
            // below code to remove XML declaration
            // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            String output = writer.getBuffer().toString();
            return output;
        } catch (TransformerException e) {
            e.printStackTrace();
        }
         
        return null;
    }
 
    private static Document convertStringToDocument(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder builder;  
        try 
        {  
            builder = factory.newDocumentBuilder();  
            Document doc = builder.parse( new InputSource( new StringReader( xmlStr ) ) ); 
            return doc;
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        return null;
    }
    
    public static String createXML(String recNo, String billId, String TransDate, String status, String amount) 
    {
        String val1 = recNo;
        String val2 = billId;
        String val3 = TransDate;
        String val4 = status;
        String val5 = amount;
        
//        String xmlStr1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"+"\n"+
//        "<Emp id=\"1\">"+"\n"+"<RECEIPTNO>"+val1+"</RECEIPTNO>"+"\n"+"<TRANSACTIONID>"+val1+"</TRANSACTIONID>"+"\n"+
//        "<RECEIPTDATE>"+val3+"</RECEIPTDATE>"+"\n"+"<AMOUNT>"+val5+"</AMOUNT>"+"\n"+
//        "<BDREF>"+val2+"</BDREF>"+"\n"+"<STATUS>"+val4+"</STATUS>"+"</Emp>";
        
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"standalone=\"yes\"?>"
			+ "<Emp id=\"1\">"
			+ "<RECEIPTNO>"
			+ val1
			+ "</RECEIPTNO>"
			+ "\n<TRANSACTIONID>"
			+ val1
			+ "</TRANSACTIONID>"
			+ "\n<RECEIPTDATE>"
			+ val3
			+ "</RECEIPTDATE>"
			+ "\n<AMOUNT>"
			+ val5
			+ "</AMOUNT>"
			+ "\n<BDREF>"
			+ val2
			+ "</BDREF>"
			+ "\n<STATUS>"
			+ val4
			+ "</STATUS>"
			+ "</Emp>";
          
	     return xmlString;
    }
    
 
}