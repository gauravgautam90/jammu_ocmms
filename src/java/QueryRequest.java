/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.HttpURLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.*;
//import com.sun.net.ssl.HttpsURLConnection;
 
/**
*
* @author 74150
*/
public class QueryRequest {
String    MERCHANTID="MCGM";
String    CustomerID="";//?
String    TxnReferenceNo="";//? tpsl Txn Id
String    BankReferenceNo="NA";
String    TxnAmount="";
String    BankID="ICICI";
String    BankMERCHANTID="NA";
String    TxnType="NA";
String    CurrencyName="NA";
String    ItemCode="NA";
String    SecurityType="NA";
String    SecurityID="NA";
String    SecurityPassword="NA";
String    TxnDate="NA";
String    AuthStatus="NA";
String    SettlementType="NA";
String    AdditionalInfo1="MCGM";
String    AdditionalInfo2="";//?
String    AdditionalInfo3;//?
String    AdditionalInfo4;//?
String    AdditionalInfo5;//?
String    AdditionalInfo6;//?
String    AdditionalInfo7;//?
String    ReturnUrl="NA";
    String strPropPath="D:\\TechProcess\\Property\\NIC_e_Tendering.properties";
    public String createRequest(){
        
         DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date newdate=new Date();
            //newdate="14 dec 2015";
            String date=dateFormat.format(newdate);
        String data="";
      //  Deptcode~Biddercode~CreditorAcNo~DebitorACNo~TxnDate~PaymentType~Remark
                
                String strTranID="7000000000004351";
                String strMarketCode="MCGM";
                String strAcctNo="MCGM~0000021613~NA~NA~"+date+"~QUERY"+"~NA";
                String strTxnAmount="34000.00";
                String strBankCode="ICICI";
                String finaldata=getchecksumdata(strTranID,strMarketCode,strAcctNo,strTxnAmount,strBankCode);
                //System.out.println("finaldata "+finaldata);
        return finaldata;
    }
     public String getchecksumdata(String strTranID,String strMarketCode,String strAcctNo,String strTxnAmount,String strBankCode){
        String strMsg="";
         
//    //    com.CheckSumRequestBean objTranDetails = new com.CheckSumRequestBean();
//                objTranDetails.setStrMerchantTranId(strTranID);
//                objTranDetails.setStrMarketCode(strMarketCode);
//                objTranDetails.setStrAccountNo(strAcctNo);
//                objTranDetails.setStrAmt(strTxnAmount);
//                objTranDetails.setStrBankCode(strBankCode);
//                objTranDetails.setStrPropertyPath(strPropPath);
//
//                com.TPSLUtil util = new com.TPSLUtil();
//                strMsg = util.transactionRequestMessage(objTranDetails);
        //return strMsg;
        return "MCGM|7000000000005986|NA|NA|100.00|ICICI|NA|NA|INR|NA|NA|NA|NA|NA|NA|NA|MCGM|MCGM~0000001675~NA~NA~02/01/2016 14:14:14~QUERY~EMDPayment|NA|NA|NA|NA|NA|http://localhost:8080/NIC_E_Teandering/PaymentResponse|757388293333";
    }
    private String callUrlConnectionMethod(String verificationURL,String verificationRequestParam)throws Exception{
                String method="POST";
                int retryS2SCounter=3;
                int timeout=60000;
                                HttpsURLConnection conn = null;
                                OutputStreamWriter wr = null;
                                BufferedReader input = null;
                                URL url =null;
                                String strPutBackTogether ="";
                                boolean noConnectionFlag=false;
                                int i = 0;
                                //System.out.println("INPUT In s2sServiceCall Method --> Retry Counter --> "+retryS2SCounter+" verificationURL "+verificationURL+" S2S Request Data "+verificationRequestParam);
                                for (;i < retryS2SCounter; i++) {
                                                try{
                                                                url = new URL(verificationURL);
                                                                conn = (HttpsURLConnection) url.openConnection();
                                                                conn.setRequestMethod(method);
                                                                conn.setDoOutput(true);
                                                                conn.setDoInput(true);
                                                                conn.setUseCaches(false);
                                                                //conn.setReadTimeout(timeout);
                               
                                                                wr = new OutputStreamWriter(conn.getOutputStream());
                                                                wr.write("msg="+verificationRequestParam);
                                                                wr.flush();
                                                                //S2S call-->Receiving data from bank for verfication
                                                                StringBuffer putBackTogether = new StringBuffer();
                                                                input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                                                                String banktotpsl ="";
                                                                while (null != ((banktotpsl = input.readLine()))){
                                                                                putBackTogether.append(banktotpsl).append("\n");
                                                                }
                                                                strPutBackTogether = putBackTogether.toString().trim();
                                                                if(!strPutBackTogether.equals("")){
                                                                                System.out.println(" Success S2S Response In s2sServiceCall Method --> Retry Counter --> "+i+" verificationURL "+verificationURL+" S2S Request Data "+verificationRequestParam);
                                                                                noConnectionFlag=true;
                                                                                break;
                                                                }else{
                                                                                System.out.println(" Blank S2S Response In s2sServiceCall Method --> Retry Counter --> "+i+" verificationURL "+verificationURL+" S2S Request Data "+verificationRequestParam);
                                                                }
 
                                                }catch(Exception e){
                                                                System.err.println(" Method-->s2sServiceCall--> "+e +" Retry Counter --> "+i);
                                                                System.err.println(" Error S2S Response In s2sServiceCall Method --> Retry Counter --> "+i+" verificationURL "+verificationURL+" S2S Request Data "+verificationRequestParam);
                                                }finally{
                                                                url=null;
                                                                conn=null;
                                                                wr=null;
                                                                input=null;
                                                }
                                }
                                if(!noConnectionFlag){//this mean connection issue, while making url connection on given url
                                                System.out.println(" Pending S2S Response In s2sServiceCall Method --> verificationURL "+verificationURL+" S2S Request Data "+verificationRequestParam);
                                                strPutBackTogether="P";
                                }
                                return strPutBackTogether;
                }
    private static final Pattern TAG_REGEX = Pattern.compile("<form (.+?)</form>");
   
    public String callPostRequest(String URL,String Msg){
    	String sbc="";
          ArrayList sequencedata=new ArrayList();
    try {
      String output=callUrlConnectionMethod(URL,Msg);
        System.out.println("output "+output);
      //String datatopull=Arrays.toString(getTagValues(output).toArray());
      String datatopull=getTagValues(output);
   
        System.out.println("data to pull "+datatopull);
       
        Pattern pattern = Pattern.compile("'(.+?)'");
        Matcher matcher = pattern.matcher(datatopull);
        System.out.println("matcher.find()"+matcher.find());
        while(matcher.find())
        {
           // System.out.println(matcher.group(0));
            sequencedata.add(matcher.group(0));
        }
        if(sequencedata.size()>=5){
                System.out.println("Response Status: "+sequencedata.get(5));
                 sbc=sequencedata.get(5).toString();
                sbc=sbc.replace("'", "");
                System.out.println("Sbc "+sbc);
        }
       
        else
            System.out.println("No data found");
 
    } catch (Exception ex) {
        Logger.getLogger(QueryRequest.class.getName()).log(Level.SEVERE, null, ex);
    }
    return sbc;
    }
 
private static String getTagValues(final String str) {
   
    final List tagValues = new ArrayList();
    final Matcher matcher = TAG_REGEX.matcher(str);
    while (matcher.find()) {
        tagValues.add(matcher.group(1));
    }
    return tagValues.toString();
}
 
    public static void main(String[] args) {
        HashMap vDataMap=new HashMap();
       String strURL="https://www.techprocess.in/e_TFMS/ServiceForms/TechprocessServiceProcess.aspx";
      //  String strURL="https://www.tpsl.co.in/e_TFMS/ServiceForms/TechprocessServiceProcess.aspx";
        QueryRequest obj=new QueryRequest();
       String data=obj.createRequest();
      String data1=obj.callPostRequest(strURL,data); 
        System.out.println("Data 1"+data1);
    }
   
}
 