
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.rpc.ServiceException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.tempuri.EFMS_VendorRegistration;
import org.tempuri.EFMS_VendorRegistrationLocator;
import org.tempuri.EFMS_VendorRegistrationSoap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 74150
 */
public class VenderRegistration {

    public String UserRegistrationservice(HashMap UserDetails) throws RemoteException, ServiceException{
		String Response="";
                 String Resp="";
		String RequestXML="";
		EFMS_VendorRegistration request1=new EFMS_VendorRegistrationLocator();
		try {
			RequestXML=generateXML(UserDetails);
			EFMS_VendorRegistrationSoap user=request1.getEFMS_VendorRegistrationSoap();
			Response=user.vendorRegistration(RequestXML);
                         Resp=readXML(Response);
                       
		} catch (ServiceException e) {

			e.printStackTrace();
		}

		return Resp;
	}
    public String generateXML(HashMap map){
		String ResponseXML="";
		int no=0;

		 DocumentBuilderFactory documentBuilderFactory = null;
	        DocumentBuilder documentBuilder =null;
	        Document document =null;
	        try{
	        	HashMap vendormap=new HashMap();
	            documentBuilderFactory = DocumentBuilderFactory.newInstance();
	            documentBuilder = documentBuilderFactory.newDocumentBuilder();
	            document = documentBuilder.newDocument();
	            Element rootElement = document.createElement((String) map.get("rootElement"));//root name
	            document.appendChild(rootElement);
	            Element newChild1 = document.createElement("RequestID");
	            newChild1.appendChild(document.createTextNode((String) map.get("RequestID")));
	            rootElement.appendChild(newChild1);
	            Element newChild2 = document.createElement("merchantCode");
	            newChild2.appendChild(document.createTextNode((String) map.get("merchantCode")));
	            rootElement.appendChild(newChild2);
	            Element newChild3 = document.createElement("clientCode");
	            newChild3.appendChild(document.createTextNode((String) map.get("clientCode")));
	            rootElement.appendChild(newChild3);
	            Element newChild4 = document.createElement("departmentCode");
	            newChild4.appendChild(document.createTextNode((String) map.get("departmentCode")));
	            rootElement.appendChild(newChild4);
	            	 Element newChild5 = document.createElement("vendor");
	            	Element subnewChild5_1 = document.createElement("vendorCode");
	            	subnewChild5_1.appendChild(document.createTextNode((String) map.get("vendorCode")));
		            newChild5.appendChild(subnewChild5_1);
		            Element subnewChild5_2 = document.createElement("vendorName");
		            subnewChild5_2.appendChild(document.createTextNode((String) map.get("vendorName")));
		            newChild5.appendChild(subnewChild5_2);
		            Element subnewChild5_3 = document.createElement("isActive");
		            subnewChild5_3.appendChild(document.createTextNode("A"));
		            newChild5.appendChild(subnewChild5_3);
		            rootElement.appendChild(newChild5);
	            Transformer transformer = TransformerFactory.newInstance().newTransformer();
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	            DOMSource source = new DOMSource(document);
	            StreamResult result =  new StreamResult(new StringWriter());
	            transformer.transform(source, result);
	            ResponseXML = result.getWriter().toString();
	        }catch(Exception e){
	            e.printStackTrace();
	            ResponseXML = "Error while Generating XML data "+e.getMessage();
	            return ResponseXML;
	        }
	       return ResponseXML;
	}
    public String readXML(String strXML){
        String ResponseMsg="";
        ArrayList listNode=new ArrayList();
        listNode.add("RequestID");
        listNode.add("departmentCode");
        listNode.add("vendorCode");
        listNode.add("statusDesc");
        listNode.add("balance");
        ArrayList listNodeValue = new ArrayList();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new InputSource(new ByteArrayInputStream(strXML.getBytes("utf-8"))));
            doc.getDocumentElement().normalize();
            Iterator it = listNode.iterator();
            NodeList nodeList = null;
            String nodeValue = "";
            Node node = null;

            while(it.hasNext()){
                nodeValue = (String)it.next();
                nodeList = doc.getElementsByTagName(nodeValue);
                node = nodeList.item(0).getFirstChild();
                if(node == null){
                    listNodeValue.add("");
                }
                else{
                    listNodeValue.add(node.getNodeValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error while reading the XML Data";
        }
        ResponseMsg="Request ID "+listNodeValue.get(0)+" for Department "+listNodeValue.get(1)+" and Vender Code "+
                listNodeValue.get(2)+" "+listNodeValue.get(3)+"With Amount "+listNodeValue.get(4);


        return ResponseMsg;
    }
    public HashMap setUserRegistrationdata(){
		HashMap UserDetailsmap=new HashMap();
		String rootElement="vendorDetails";
		String RequestID="abc123456";
		String merchantCode="ICICI";
		String clientCode="MCGM";
		String departmentCode="MCGM";
		UserDetailsmap.put("rootElement", rootElement);
		UserDetailsmap.put("RequestID", RequestID);
		UserDetailsmap.put("merchantCode", merchantCode);
		UserDetailsmap.put("clientCode", clientCode);
		UserDetailsmap.put("departmentCode", departmentCode);
                UserDetailsmap.put("vendorCode","vendor74150");
		UserDetailsmap.put("vendorName","Algoo Kanojiya");
		return UserDetailsmap;
	}
    public static void main(String[] args) throws RemoteException, ServiceException {
      HashMap mapping=new HashMap();
      VenderRegistration reg=new VenderRegistration();
      mapping=reg.setUserRegistrationdata();
      reg.UserRegistrationservice(mapping);
       
    }
    public String ReplaceSpecialChar(String strMsg){

       
        strMsg=strMsg.replace("&", "And");

        strMsg=strMsg.replace("#", " ");

        strMsg=strMsg.replace("<", " ");

        strMsg=strMsg.replace(">", " ");

        strMsg=strMsg.replace("*", " ");

        strMsg=strMsg.replace("^", " ");

        strMsg=strMsg.replace("%", " ");

        strMsg=strMsg.replace(".", " ");

        strMsg=strMsg.replace("(", " ");
        strMsg=strMsg.replace(")", " ");
        strMsg=strMsg.replace("/", " ");
        strMsg=strMsg.replace("!", " ");
        strMsg=strMsg.replace("`", " ");
        strMsg=strMsg.replace("~", " ");
        strMsg=strMsg.replace("\\", " ");
        
        
        return strMsg;

    }

}
