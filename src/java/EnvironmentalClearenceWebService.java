import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.wsdl.extensions.soap.SOAPBody;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class EnvironmentalClearenceWebService {

	// new code for service change start
	public ArrayList sendEnvironmentClearenceValue(String type, String formType,
			String enterValueForSearch, String state, String category)
			throws Exception {

		ArrayList environmentalClearenceList=new ArrayList();

		try {
			
//			String type = "1";
//			String formType = "EC";
//			String enterValueForSearch = "IA/AN/IND/2370/2007";
//			String state = "-1";
//			String category = "-1";

			// variables defined to hold the value from web service start from
			// here
			String proposalNo;
			String stateName;
			String proposalName;
			String categoryWeb;
			String userAgencyName;
			String proposalRecievedon;
			String fileNo;
			String dateofgrant;
			String letter;
			// variable defined to hold the value from web service ends here

			String urlInString = "http://environmentclearance.nic.in/cteservice.asmx/GetData?type="
					+ type
					+ "&formType="
					+ formType
					+ "&enterValueForSearch="
					+ enterValueForSearch
					+ "&state="
					+ state
					+ "&category="
					+ category;

			URL url = new URL(urlInString);
			URLConnection conn = url.openConnection();
			HttpURLConnection con = (HttpURLConnection) conn;
			con.setRequestMethod("GET"); // This is method type. If you are
			con.setRequestProperty("Content-Type", "text/xml;charset=UTF-8"); // it
			con.setDoOutput(true);
			con.setDoInput(true);
			System.out.println(con.getResponseCode());

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(conn.getInputStream());
			// ////////////

			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getDocumentElement().getChildNodes();

			
			TransformerFactory factory1 = TransformerFactory.newInstance();
			Transformer xform = factory1.newTransformer();
			// that’s the default xform; use a stylesheet to get a real one
			// xform.transform(new DOMSource(doc), new
			// StreamResult(System.out));
			xform.setOutputProperty(OutputKeys.INDENT, "yes");

			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			DOMSource source = new DOMSource(doc);
			xform.transform(source, result);
			String s = writer.toString();
			
			System.out.println("s========="+s);
			

			// ///////////
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = null;
			if(s!=null){
			try {
				db = dbf.newDocumentBuilder();
				InputSource is = new InputSource();
				is.setCharacterStream(new StringReader(s));
				try {
					Document doc4 = db.parse(is);
					String message = doc4.getDocumentElement().getTextContent();
					
					System.out.println("message=========="+message);
					
					if(message!=null && message!=""){
						
					proposalNo = doc4.getElementsByTagName("ProposalNo")
							.item(0).getTextContent();
					stateName = doc4.getElementsByTagName("StateName").item(0)
							.getTextContent();
					proposalName = doc4.getElementsByTagName("ProposalName")
							.item(0).getTextContent();
					categoryWeb = doc4.getElementsByTagName("Category").item(0)
							.getTextContent();
					userAgencyName = doc4
							.getElementsByTagName("UserAgencyName").item(0)
							.getTextContent();
					proposalRecievedon = doc4.getElementsByTagName(
							"ProposalRecievedon").item(0).getTextContent();
					fileNo = doc4.getElementsByTagName("FileNo").item(0)
							.getTextContent();
					dateofgrant = doc4.getElementsByTagName("Dateofgrant")
							.item(0).getTextContent();
					letter = doc4.getElementsByTagName("Letter").item(0)
							.getTextContent();
					
					environmentalClearenceList.add(proposalNo);
					environmentalClearenceList.add(stateName);
					environmentalClearenceList.add(proposalName);
					environmentalClearenceList.add(categoryWeb);
					environmentalClearenceList.add(userAgencyName);
					environmentalClearenceList.add(proposalRecievedon);
					environmentalClearenceList.add(fileNo);
					environmentalClearenceList.add(dateofgrant);
					environmentalClearenceList.add(letter);
					

//					System.out.println("proposalNo : " + proposalNo);
//					System.out.println("stateName : " + stateName);
//					System.out.println("proposalName : " + proposalName);
//					System.out.println("categoryWeb : " + categoryWeb);
//					System.out.println("userAgencyName : " + userAgencyName);
//					System.out.println("proposalRecievedon : "
//							+ proposalRecievedon);
//					System.out.println("fileNo : " + fileNo);
//					System.out.println("dateofgrant : " + dateofgrant);
//					System.out.println("letter : " + letter);
					
					}
					

				} catch (SAXException e) {
					// handle SAXException
				} catch (IOException e) {
					// handle IOException
				}
			} catch (ParserConfigurationException e1) {
				// handle ParserConfigurationException
			}
			
		}

			// ////////


		} catch (Exception e) {
			System.err
					.println("Error occurred while sending SOAP Request to Server");
			e.printStackTrace();

		}
		return environmentalClearenceList;
	}

	// new code for service change end

	// public void sendEnvironmentClearenceValue(String type,String
	// formType,String enterValueForSearch,String state,String category) throws
	// Exception
	// {
	//
	//
	// try {
	// SOAPConnectionFactory soapConnectionFactory =
	// SOAPConnectionFactory.newInstance();
	// SOAPConnection soapConnection = soapConnectionFactory.createConnection();
	//
	// // Send SOAP Message to SOAP Server
	// String url = "http://environmentclearance.nic.in/CTEservice.asmx";
	// SOAPMessage soapResponse =
	// soapConnection.call(createSOAPRequest(type,formType,enterValueForSearch,state,category),
	// url);
	//
	// // Process the SOAP Response
	// printSOAPResponse(soapResponse);
	// System.out.println("after printSOAPResponse==================");
	// soapConnection.close();
	// } catch (Exception e)
	// {
	// System.err.println("Error occurred while sending SOAP Request to Server");
	// e.printStackTrace();
	//				
	// }
	// }

	// public String xmlRequest(int type, String formType, String
	// enterValueForSearch,String state,String category) {
	// return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
	// +
	// "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
	// + "  <soap:Body>\n"
	// + "    <GetUserInfo xmlns=\"http://tempuri.org/\">\n"
	// + "      <type>" + type + "</pin>\n"
	// + "      <formType>" + formType + "</pin>\n"
	// + "      <enterValueForSearch>" + enterValueForSearch + "</pin>\n"
	// + "      <state>" + state + "</pin>\n"
	// + "      <category>" + category + "</pin>\n"
	// + "    </GetUserInfo>\n"
	// + "  </soap:Body>\n"
	// + "</soap:Envelope>";
	// }

	private static SOAPMessage createSOAPRequest(String type, String formType,
			String enterValueForSearch, String state, String category)
			throws Exception {
				MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

		String serverURI = "http://tempuri.org/";

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("GetData", serverURI);
		// SOAP Body
		SOAPBody soapBody = (SOAPBody) envelope.getBody();
		SOAPElement soapBodyElem = ((SOAPElement) soapBody).addChildElement("GetData",
				"GetData");

		SOAPElement soapBodyElem0 = soapBodyElem.addChildElement("type",
				"GetData");
		soapBodyElem0.addTextNode("1");
		SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("formType",
				"GetData");
		soapBodyElem1.addTextNode("EC");
		SOAPElement soapBodyElem2 = soapBodyElem.addChildElement(
				"enterValueForSearch", "GetData");
		soapBodyElem2.addTextNode("IA/AN/IND/2370/2007");
		SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("state",
				"GetData");
		soapBodyElem3.addTextNode("-1");
		SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("category",
				"GetData");
		soapBodyElem4.addTextNode("-1");

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", serverURI + "GetData");

		soapMessage.saveChanges();

		/* Print the request message */
		System.out.print("Request SOAP Message111 = ");
		soapMessage.writeTo(System.out);
		System.out.println();

		return soapMessage;
	}

	private static void printSOAPResponse(SOAPMessage soapResponse)
			throws Exception {
		System.out.println("Inside  printSOAPResponse=========by sharvan"
				+ soapResponse);
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		Source sourceContent = soapResponse.getSOAPPart().getContent();
		System.out.print("\nResponse SOAP Message = ");
		StreamResult result = new StreamResult(System.out);
		System.out.print("\nResponse SOAP Message 22222= ");
		transformer.transform(sourceContent, result);
	}

}
