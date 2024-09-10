/**
 *
 */

/**
 * @author Mittali
 *
 */
import java.util.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.LinkedHashMap;

import reconglobalsoap.ReconGlobal;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import com.tp.pg.util.TransactionRequestBean;
import com.tp.pg.util.TransactionResponseBean;

public class CheckTrans {


    public void webServiceUpdate(Date date1, Date date2) {


        System.out.println("abc--here-in net banking-")
        def date = new Date();
        System.out.println("abc--here-in net banking---------date-------" + date)
        def start = date1;
        def end = date2;
        System.out.println("--------start-------" + start)
        System.out.println("--------end-------" + end)
        def transData = BankTransactionDetails.findAll("from BankTransactionDetails where transaction_status = 'F' and payment_type != 'e-Wallet' and dateCreated <= ? and dateCreated >= ?", [end, start]);
        System.out.println("transData-" + transData)
         System.out.println("indApplication-" + transData.indApplication)


        def id = transData.id
        def amount = transData.amount
        def txndate = transData.dateCreated
        def appId = transData.indApplication

        System.out.println("txndate--txndate--" + txndate)

      System.out.println("appId--appId--" + appId)

        String strKey = "1365775075TETTPF";
        String strIV = "5124632302OFYFAB";
        ArrayList abc = new ArrayList();
        for (int i = 0; i < transData.size(); i++) {
            System.out.println("amount----" + amount.get(i))
            System.out.println("id----" + id.get(i))
            def sdfh = new SimpleDateFormat("dd-MM-yyyy");
            TransactionRequestBean objbean = new TransactionRequestBean();
            objbean.setStrRequestType("O");
            objbean.setStrMerchantCode("L235106");
            objbean.setMerchantTxnRefNumber(id.get(i));
            objbean.setStrITC("NA");
            objbean.setStrAmount(amount.get(i));
            objbean.setStrCurrencyCode("NA");
            objbean.setStrUniqueCustomerId("NA");
            objbean.setStrReturnURL("NA");
            objbean.setStrS2SReturnURL("NA");
            objbean.setStrTPSLTxnID("NA");
            objbean.setStrShoppingCartDetails("NA");
            objbean.setTxnDate(sdfh.format(txndate.get(i)));// txn date
            objbean.setStrEmail("NA");
            objbean.setStrMobileNumber("NA");
            objbean.setStrBankCode("NA");
            objbean.setStrCustomerName("NA");
            objbean.setWebServiceLocator("https://www.tpsl-india.in/PaymentGateway/services/TransactionDetailsNew");
            objbean.setKey(strKey.getBytes());
            objbean.setIv(strIV.getBytes());
            // objbean.setLogPath("G://log.txt");

            abc.add(objbean.getTransactionToken());
            System.out.println("abc----" + abc.get(i))
            StringTokenizer token = new StringTokenizer(abc.get(i), "|");

            String strAuthStatus = "";
            String strAuthTxnMsg = "";
            String strErrorDescription = "";
            String strCustomerID = "";
            String strCSTBANKID = "";
            String[] result
            String[] resultMsg
            String[] cstBankId
           
            //  Local test 
            
  /*      String[] result =["Volvo", "0300", "Ford", "Mazda"];
            String[] resultMsg =["Volvo", "SUCCESS", "Ford", "Mazda"];
            String[] cstBankId =["111", "1133", "Ford", "Mazda"];
            
             */
            println("...token.countTokens()...22..." + token.countTokens())
            if (token.countTokens() > 5) {
                strAuthStatus = token.nextToken();
                strAuthTxnMsg = token.nextToken();
                strErrorDescription = token.nextToken();
                strCustomerID = token.nextToken();
                strCSTBANKID = token.nextToken();
                result = strAuthStatus.split("=");
                resultMsg = strAuthTxnMsg.split("=");
                cstBankId = strCSTBANKID.split("=");
            }

            def bankTransactionInst
            if (result && resultMsg && cstBankId) {
                System.out.println("===============" + result[1] + "........." + resultMsg[1])
                if (resultMsg[1].equals("SUCCESS") && result[1].equals("0300")) {

                    println("--------------------successful transacti-----")
                    bankTransactionInst = BankTransactionDetails.get(id.get(i))
                    println("-----------------------" + bankTransactionInst)
                    bankTransactionInst.transactionStatus = "S"
                    bankTransactionInst.bankId = cstBankId[1]
                    def bankId = BankMaster.find("from BankMaster abc where abc.bankCode=?", [cstBankId[1]])
                    //  println(bankId)
                    if (bankId) {
                        bankTransactionInst.bankName = bankId.bankName
                    } else {
                        bankTransactionInst.bankName = "NA"

                    }
                    if (cstBankId[1].equals("1060") || cstBankId[1].equals("820")) {

                        bankTransactionInst.paymentType = "Credit"

                    }

                    if (cstBankId[1].equals("1170") || cstBankId[1].equals("1180")) {


                        bankTransactionInst.paymentType = "Debit"


                    }
                    if (cstBankId[1].equals("50") || cstBankId[1].equals("340") || cstBankId[1].equals("310") || cstBankId[1].equals("240") ||
                            cstBankId[1].equals("750") || cstBankId[1].equals("930") || cstBankId[1].equals("740") || cstBankId[1].equals("440") || cstBankId[1].equals("120")
                            || cstBankId[1].equals("1130") || cstBankId[1].equals("330") || cstBankId[1].equals("540") || cstBankId[1].equals("370") || cstBankId[1].equals("270")
                            || cstBankId[1].equals("300") || cstBankId[1].equals("10") || cstBankId[1].equals("520") || cstBankId[1].equals("490")
                            || cstBankId[1].equals("420") || cstBankId[1].equals("860") || cstBankId[1].equals("830") || cstBankId[1].equals("350")
                            || cstBankId[1].equals("140") || cstBankId[1].equals("760") || cstBankId[1].equals("910") || cstBankId[1].equals("160")
                            || cstBankId[1].equals("180") || cstBankId[1].equals("450") || cstBankId[1].equals("950") || cstBankId[1].equals("560")
                            || cstBankId[1].equals("530") || cstBankId[1].equals("550") || cstBankId[1].equals("880") || cstBankId[1].equals("680")
                            || cstBankId[1].equals("620") || cstBankId[1].equals("190") || cstBankId[1].equals("570") || cstBankId[1].equals("200")
                            || cstBankId[1].equals("130") || cstBankId[1].equals("1220")) {


                        bankTransactionInst.paymentType = "Net Banking"


                    }
                    if (!bankTransactionInst.hasErrors() && bankTransactionInst.save(flush: true)) {
                        println("in bankTransactionInst save function ")
                        println("In save of binary")
                    } else {
                        bankTransactionInst.errors.each {
                            println it
                        }
                        println("In Else")
                    }

                    def indApplicationDetailsInstance = IndApplicationDetails.get(appId.get(i).id)
                    indApplicationDetailsInstance.completionStatus = "completed"
                    indApplicationDetailsInstance.applicationDate = new Date() //Added by deepak
                    if (!indApplicationDetailsInstance.hasErrors() && indApplicationDetailsInstance.save(flush: true)) {
                        println("in indApplicationDetailsInstance save function ")
                        println("In save of binary")
                    } else {
                        indApplicationDetailsInstance.errors.each {
                            println it
                        }
                        println("In Else")
                    }
                    println("appId.get(i) ======"+appId.get(i))
                    println("appId.get(i) ======"+appId.get(i).getClass().getName())
                    def appPendingInst = ApplicationPendingDetails.find("from ApplicationPendingDetails where application=?", [appId.get(i)])

                    println("appPendingInst--" + appPendingInst)
                    if (!appPendingInst) {
                        println("hollaa!!!!")
                        def a = new GetData((appId.get(i).id).toLong())
                        System.out.println("-------------in get data------>")
                        a.routeApp()

                    }else{
                                 //                    	Added by Deepak  for Scrutiny
                    	 println("appPendingInst 111111      "+appPendingInst)
							
							    appPendingInst.scrutinyStatus="Complete"
								appPendingInst.completionStatus="Complete" 								
									if(appPendingInst.save()){
										println("inside if for appPendingInst ==="+appPendingInst)										
										//def indApplicationDetailsInstance = IndApplicationDetails.get((indAppId.id).toLong());
										//indApplicationDetailsInstance.completionStatus = "completed"
								    //	indApplicationDetailsInstance.applicationDate = new Date()
								    //	indApplicationDetailsInstance.save()
										def applcationProcessingDetails=ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application = ? order by id desc",[(appId.get(i))])
										println("applcationProcessingDetails 222222"+applcationProcessingDetails)
										if(applcationProcessingDetails)
										{
											println("inside if for save wasteApplicationProcessingDetails")
											applcationProcessingDetails.scrutinyStatus="Complete"
											if(applcationProcessingDetails.save()){
												
											}
											else{
						    					println("data not saved in wasteApplicationProcessingDetails")
						            		applcationProcessingDetails.errors.each {
									    	println it
									  }
						            		
								  }
											println("delete wasteApplicationProcessingDetails")
										}
										
										
										
										
						              }
						            	else{
						    					println("data not saved in wasteApplicationPendingDetails")
						            		applcationPendingDetails.errors.each {
									    	println it
									  }
						            		
								  }
                    	
                    }

                }
            }
        }


    }


}
	

