
/*
 * Purpose			-	Class for Reading the XML.
 */
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class GenXmlParser {

	public String getValue(String parentTag, String tagNameToSearch,
			String correspondingTagName, String correspondingTagvalue,
			String xml, boolean xmlIsString) {

		List ca_locationList = new ArrayList();
		List codeList = new ArrayList();
		Document doc;
		
		String error = "error";
		/*
		 * try { ca_code = br.readLine(); } catch (IOException ioe) {
		 
		 */

		try {
			if (!xmlIsString) {
				File file = new File(xml);
				DocumentBuilderFactory dbf = DocumentBuilderFactory
				.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				doc = db.parse(file);
			} else {
				DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();
				DocumentBuilder db = factory.newDocumentBuilder();
				InputSource inStream = new InputSource();
				inStream.setCharacterStream(new StringReader(xml));
				doc = db.parse(inStream);
			}
			doc.getDocumentElement().normalize();
			
			NodeList nodeLst = doc.getElementsByTagName(parentTag);

			// nodeLst.toString();
		
			for (int s = 0; s < nodeLst.getLength(); s++) {

				Node fstNode = nodeLst.item(s);
				// fstNode.getNamespaceURI();

				if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
					

					Element fstElmnt = (Element) fstNode;
					fstElmnt.getNodeName();

					
					/*
					 * NodeList fstNmElmntLst =
					 * fstElmnt.getElementsByTagName("Name"); Element fstNmElmnt =
					 * (Element)fstNmElmntLst.item(0); NodeList fstNm =
					 * fstNmElmnt.getChildNodes();
					 * nameList.add(((Node)fstNm.item(0)).getNodeValue());
					
					 * fstNm.item(0)).getNodeValue());
					 */

					NodeList lstNmElmntLst = fstElmnt
					.getElementsByTagName(tagNameToSearch);
					Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
					NodeList lstNm = lstNmElmnt.getChildNodes();
					if (lstNm.getLength() > 0) {
						ca_locationList.add(((Node) lstNm.item(0))
								.getNodeValue());
						
						// lstNm.item(0)).getNodeValue());
					} else {
						ca_locationList
						.add("the value for this attribute is null");
						
					}
					// ca_locationList.add(((Node)lstNm.item(0)).getNodeValue());
					
					// lstNm.item(0)).getNodeValue());

					NodeList fstNmElmntLst1 = fstElmnt
					.getElementsByTagName(correspondingTagName);// code
					Element fstNmElmnt1 = (Element) fstNmElmntLst1.item(0);
					NodeList fstNm1 = fstNmElmnt1.getChildNodes();
					if (fstNm1.getLength() > 0) {
						codeList.add(((Node) fstNm1.item(0)).getNodeValue());
						
						// lstNm.item(0)).getNodeValue());
					} else {
						codeList.add("the value for this attribute is null");
						
					}
					// codeList.add(((Node)fstNm1.item(0)).getNodeValue());
					
					// fstNm1.item(0)).getNodeValue());

					/*
					 * NodeList fstNmElmntLst2 =
					 * fstElmnt.getElementsByTagName("Create"); Element
					 * fstNmElmnt2 = (Element)fstNmElmntLst2.item(0); NodeList
					 * fstNm2 = fstNmElmnt2.getChildNodes();
					 * createList.add(((Node)fstNm2.item(0)).getNodeValue());
					 
					 * fstNm2.item(0)).getNodeValue());
					 */

				}

			}
			for (int i = 0; i < ca_locationList.size(); i++) {
				if (((String) codeList.get(i)).equals(correspondingTagvalue
						.trim())) {
					return (String) ca_locationList.get(i);
					
					// (String)codeList.get(i) + " is " +
					// (String)ca_locationList.get(i));
				}
			}
			for (int i = 0; i < ca_locationList.size(); i++) {
				
			}
			return error;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getValue(String tagName, String xmlName) {
		{
			String val = "error";
			try {
				File file = new File(xmlName);
				DocumentBuilderFactory dbf = DocumentBuilderFactory
				.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(file);
				doc.getDocumentElement().normalize();
				NodeList nodeLst = doc.getElementsByTagName(tagName);
				// for(int i=0;i<nodeLst.getLength();i++){
				Node fstNode = nodeLst.item(0);
				if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
					Element fstElmnt = (Element) fstNode;
					fstElmnt.getNodeName();
					Element fstNmElmnt = (Element) fstNode;
					NodeList fstNm = fstNmElmnt.getChildNodes();
					if (fstNm.getLength() > 0) {
						val = ((Node) fstNm.item(0)).getNodeValue();
					}
				}
				// }

				return val;
			} catch (Exception e) {
				e.printStackTrace();
				return val;

			}
		}

	}

	public List readCodes(String tagNameToSearch, String xml, String parentTag) {
		List ca_locationList = new ArrayList();
		List codeList = new ArrayList();
		
		Document doc;
		
		String error = "error";
		/*
		 * try { ca_code = br.readLine(); } catch (IOException ioe) {
		 
		 */

		try {
			File file = new File(xml);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(file);

			doc.getDocumentElement().normalize();
			
			NodeList nodeLst = doc.getElementsByTagName(parentTag);

			// nodeLst.toString();
			
			for (int s = 0; s < nodeLst.getLength(); s++) {

				Node fstNode = nodeLst.item(s);
				// fstNode.getNamespaceURI();

				if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
					
					Element fstElmnt = (Element) fstNode;
					fstElmnt.getNodeName();

					
					/*
					 * NodeList fstNmElmntLst =
					 * fstElmnt.getElementsByTagName("Name"); Element fstNmElmnt =
					 * (Element)fstNmElmntLst.item(0); NodeList fstNm =
					 * fstNmElmnt.getChildNodes();
					 * nameList.add(((Node)fstNm.item(0)).getNodeValue());
					
					 * fstNm.item(0)).getNodeValue());
					 */

					NodeList lstNmElmntLst = fstElmnt
					.getElementsByTagName(tagNameToSearch);
					Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
					NodeList lstNm = lstNmElmnt.getChildNodes();
					if (lstNm.getLength() > 0) {
						ca_locationList.add(((Node) lstNm.item(0))
								.getNodeValue());
						
						// lstNm.item(0)).getNodeValue());
					} else {
						ca_locationList
						.add("the value for this attribute is null");
						

					}
				}
			}
			return ca_locationList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getCode(String tagNameToSearch, String xml, String parentTag) {
		List ca_locationList = new ArrayList();
		List codeList = new ArrayList();
		String codeValue = null;
		Document doc;
		
		String error = "error";
		/*
		 * try { ca_code = br.readLine(); } catch (IOException ioe) {
		
		 * System.exit(1); }
		 */

		try {
			File file = new File(xml);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(file);

			doc.getDocumentElement().normalize();
			
			NodeList nodeLst = doc.getElementsByTagName(parentTag);

			// nodeLst.toString();
			
			for (int s = 0; s < nodeLst.getLength(); s++) {

				Node fstNode = nodeLst.item(s);
				// fstNode.getNamespaceURI();

				if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
					
					Element fstElmnt = (Element) fstNode;
					fstElmnt.getNodeName();

					
					/*
					 * NodeList fstNmElmntLst =
					 * fstElmnt.getElementsByTagName("Name"); Element fstNmElmnt =
					 * (Element)fstNmElmntLst.item(0); NodeList fstNm =
					 * fstNmElmnt.getChildNodes();
					 * nameList.add(((Node)fstNm.item(0)).getNodeValue());
					
					 * fstNm.item(0)).getNodeValue());
					 */

					NodeList lstNmElmntLst = fstElmnt
					.getElementsByTagName(tagNameToSearch);
					Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
					NodeList lstNm = lstNmElmnt.getChildNodes();
					if (lstNm.getLength() > 0) {
						codeValue = ((Node) lstNm.item(0))
								.getNodeValue();
						
						// lstNm.item(0)).getNodeValue());
					} 
				}
			}
			
			return codeValue;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}