<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<%@ page import="java.text.*" %>
<head>

<% response.setContentType("application/vnd.ms-excel");
   response.setHeader("Content-Disposition", "inline;filename=popListOfApplicationReportExc.xls");
%>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<g:javascript library="prototype" />
<g:javascript library='scriptaculous'/>

<script language="javascript" type="text/javascript">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.style3 {color: #186DB5}
.style5 {color: #0099FF}
.style6 {color: #33FF66; }
a:link {
	text-decoration: none;
	color: #1E6BBD;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}

.qwe123{
background-image: url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}');
padding-left:23px;
padding-right:20px;
padding-top:5px;
padding-bottom:5px;

}

.qwe123:hover{
background-image: url('${createLinkTo(dir:'images2/gif',file:'gray_bg.gif')}');
}

.blue{
background-image: url('${createLinkTo(dir:'images2/gif',file:'button_gray.gif')}');
padding-left:30px;
padding-right:27px;
padding-top:5px;
padding-bottom:7px;
}
.blue:hover{
background-image: url('${createLinkTo(dir:'images2/gif',file:'button_blue.gif')}');
}
-->
</style>

<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

<% String cont=request.getContextPath();

%>
<!--
<g:javascript library='scriptaculous'/>
<g:javascript>
		window.onload = function()   
           	  {              
			   	  new Ajax.Autocompleter("autocomplete1","autocomplete_choices","<%=cont%>/groupMaster/ajaxAutoComplete",{} );             
			 }
</g:javascript>
-->

<script language="javascript" type="text/javascript">
	function popitup(url)
	 {
			newwindow=window.open(url,'name','height=200px,width=500px');
			if (window.focus)
			 {
				newwindow.focus()
		   	}
		return false;
	}
</script>


<% 
	String cont2=request.getContextPath();
	if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
			response.sendRedirect(cont2+"/index.gsp")	;	
	 } %>



</head>
<body >
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >

<tr>
 
 <%
 String dd1;
 String dd2;
 String dd3;
 if(sqlDate)
 {
 java.util.Date utilDate1 = new java.util.Date(sqlDate.getTime());
 java.util.Date utilDate2 = new java.util.Date(sqlDate2.getTime());
java.util.Date utilDate3 = new java.util.Date(sqlDate3.getTime());

 SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");

 dd1=dmyFormat.format(utilDate1);
 dd2=dmyFormat.format(utilDate2);
 dd3=dmyFormat.format(utilDate3);
 }
 %>
 
 <td colspan="9" align="center" >
 <span class="headngblue">
       <span style="color:red;font-size:13px;">Consent application wise status: Office wise</span> 
       <% if(dd1 && dd1.length()>3) {%>From <font color="red"> <%=dd1%></font> To <font color="red"><%=dd3%></font><%}%>
 </span>
 </td>
 </tr> 
<tr><td></td></tr>               
</table>


        
	
<table width=140% align="center" border="2" style="border:3px solid green;" cellpadding="0" cellspacing="0"  class="tab-txt">

                  
<tr width="200%" bgcolor="#A8DAF3"  >

   <th align="center"  rowspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >District Office</th>
   <th align="center" colspan="5" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Applied</th>
   <th align="center" colspan="5" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Consent Issued</th> 
   <th align="center" colspan="5" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Rejected</th> 
   <th align="center" colspan="5" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Balance to be issued</th> 
     
</tr>


<tr width="200%" bgcolor="#A8DAF3"  >
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >RED</th> 
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >ORANGE</th>
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >GREEN</th> 
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >WHITE</th>
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >TOTAL</th>

<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >RED</th> 
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >ORANGE</th>
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >GREEN</th> 
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >WHITE</th>
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >TOTAL</th>


<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >RED</th> 
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >ORANGE</th>
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >GREEN</th> 
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >WHITE</th>
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >TOTAL</th>

<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >RED</th> 
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >ORANGE</th>
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >GREEN</th> 
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >WHITE</th>
<th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >TOTAL</th>

</tr>
                  
<% 	
def grandTotTC = 0 
def grandTotPTC = 0
def grandTotGTC = 0
def grandTotRTC = 0




def appliedR = 0 
def appliedO = 0 
def appliedG = 0 
def appliedW = 0 
def appliedT = 0 

def issuedR = 0 
def issuedO = 0 
def issuedG = 0 
def issuedW = 0 
def issuedT = 0 

def rejectedR = 0 
def rejectedO = 0 
def rejectedG = 0 
def rejectedW = 0 
def rejectedT = 0 

def pendingR = 0 
def pendingO = 0 
def pendingG = 0 
def pendingW = 0 
def pendingT = 0 






%>
                  
                  
    <g:each in="${groupList}" status="i" var="GroupMasterInstance">
           
           <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">   

                
                    
           <%
          	def roleArray = new ArrayList()
		    def groupId = (GroupMasterInstance.id).toString()
			def allSummaryReportReceivedList = new ArrayList()
			def allSummaryReportGrantedList = new ArrayList()
			def allSummaryReportRejectedList = new ArrayList()
			def allSummaryReportPendingList = new ArrayList();
      
      
      
      def allSummaryReportReceivedListR = new ArrayList();
      def allSummaryReportReceivedListO = new ArrayList();
      def allSummaryReportReceivedListG = new ArrayList();
      def allSummaryReportReceivedListW = new ArrayList();
      
      def allSummaryReportPendingListR = new ArrayList();
      def allSummaryReportPendingListO = new ArrayList();
      def allSummaryReportPendingListG = new ArrayList();
      def allSummaryReportPendingListW = new ArrayList();
      
      def allSummaryReportGrantedListR = new ArrayList();
      def allSummaryReportGrantedListO = new ArrayList();
      def allSummaryReportGrantedListG = new ArrayList();
      def allSummaryReportGrantedListW = new ArrayList();
      
      
      def allSummaryReportRejectedListR = new ArrayList();
      def allSummaryReportRejectedListO = new ArrayList();
      def allSummaryReportRejectedListG = new ArrayList();
      def allSummaryReportRejectedListW = new ArrayList();
      
      
      def indList = new ArrayList()
			def appPendGrantedList 
			def appProcessingGrantedList
			def appPendRejectedList 
			def appProcessingRejectedList
			def appPendList 
			def appReceivedList
			def newVar
			
			allSummaryReportReceivedList = AllSummaryReport.findAll("from AllSummaryReport as abc where abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? order by abc.id desc ",[groupId,sqlDate,sqlDate2])        			
			allSummaryReportReceivedListR = AllSummaryReport.findAll("from AllSummaryReport as abc where abc.indCategoryName='RED' and abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? order by abc.id desc ",[groupId,sqlDate,sqlDate2])
			allSummaryReportReceivedListO = AllSummaryReport.findAll("from AllSummaryReport as abc where abc.indCategoryName='ORANGE' and abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? order by abc.id desc ",[groupId,sqlDate,sqlDate2])
			allSummaryReportReceivedListG= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.indCategoryName='GREEN'  and abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? order by abc.id desc ",[groupId,sqlDate,sqlDate2])
			allSummaryReportReceivedListW= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.indCategoryName='WHITE'  and abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? order by abc.id desc ",[groupId,sqlDate,sqlDate2])
			
			allSummaryReportPendingList = AllSummaryReport.findAll("from AllSummaryReport as abc where abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? and abc.applicationStatus ='pending' order by abc.id desc ",[groupId,sqlDate,sqlDate2])     			
			allSummaryReportPendingListR= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.indCategoryName='RED' and abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? and abc.applicationStatus ='pending' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
			allSummaryReportPendingListO= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.indCategoryName='ORANGE' and abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? and abc.applicationStatus ='pending' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
			allSummaryReportPendingListG= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.indCategoryName='GREEN' and abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? and abc.applicationStatus ='pending' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
			allSummaryReportPendingListW= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.indCategoryName='WHITE' and abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? and abc.applicationStatus ='pending' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
			
			allSummaryReportGrantedList = AllSummaryReport.findAll("from AllSummaryReport as abc where abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? and abc.applicationStatus ='approved' order by abc.id desc ",[groupId,sqlDate,sqlDate2])			
			allSummaryReportGrantedListR= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.indCategoryName='RED' and abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? and abc.applicationStatus ='approved' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
			allSummaryReportGrantedListO= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.indCategoryName='ORANGE' and abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? and abc.applicationStatus ='approved' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
			allSummaryReportGrantedListG= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.indCategoryName='GREEN' and abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? and abc.applicationStatus ='approved' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
			allSummaryReportGrantedListW= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.indCategoryName='WHITE' and abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? and abc.applicationStatus ='approved' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
			
			allSummaryReportRejectedList = AllSummaryReport.findAll("from AllSummaryReport as abc where abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? and abc.applicationStatus ='rejected' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
			allSummaryReportRejectedListR= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.indCategoryName='RED' and abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? and abc.applicationStatus ='rejected' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
			allSummaryReportRejectedListO= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.indCategoryName='ORANGE' and abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? and abc.applicationStatus ='rejected' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
			allSummaryReportRejectedListG= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.indCategoryName='GREEN' and abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? and abc.applicationStatus ='rejected' order by abc.id desc ",[groupId,sqlDate,sqlDate2])
			allSummaryReportRejectedListW= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.indCategoryName='WHITE' and abc.groupId=? and applicationRecieptDate>= ? and  applicationRecieptDate<= ? and abc.applicationStatus ='rejected' order by abc.id desc ",[groupId,sqlDate,sqlDate2])

			
	        	
			System.out.println("a---"+allSummaryReportRejectedList.size());
      	System.out.println("b---"+allSummaryReportRejectedListR.size());
      	System.out.println("c---"+allSummaryReportRejectedListO.size());
      	System.out.println("d---"+allSummaryReportRejectedListG.size());
      	System.out.println("e---"+allSummaryReportRejectedListW.size());
			
			
			
			
			
			
			
     %>
                   	       
                   	       
                   	       <td align="center" >
                   	      
                   	       <%=GroupMasterInstance%>
                   	    
                   	       </td>
                 
 
                   	       
                   	    <td>  
                	      <table cellspacing="1" >
                 	       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
                    	      <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=received&category=red', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                         <%=allSummaryReportReceivedListR.size()%>
                      	    </a>
                      	      </td></tr> 
                      	      </table>
           	     </td>
        	       
                     <td>
                  <table cellspacing="1"  >
                  <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
           <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=received&category=orange', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                   <%=allSummaryReportReceivedListO.size()%>
                </a>
                   </td></tr>
                   </table>
                  </td>
                 
                    <td>
                    <table cellspacing="1"  >
                  <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=received&category=green', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                 <%=allSummaryReportReceivedListG.size()%></a>
                   </td></tr> 
                   </table>
                  </td>
                   	     
                   
                    <td>
                   <table cellspacing="1"  >
                  <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
               <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=received&category=white', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                 <%=allSummaryReportReceivedListW.size()%>
                </a>
                   </td></tr> 
                 </table>
                  </td>
                  
                  
                  <td>
                  <table cellspacing="1"  >
                 <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
              <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=received&category=all', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                <%=allSummaryReportReceivedList.size()%>
               </a>
                  </td></tr> 
                </table>
                 </td>
                 
                 
                 
                 
                 
                 
                 
                 
              <td>  
       	      <table cellspacing="1" >
        	       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
           	      <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=red', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                <%=allSummaryReportGrantedListR.size()%>
             	    </a>
             	      </td></tr> 
             	      </table>
  	     </td>
  	       
            <td>
         <table cellspacing="1"  >
         <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=orange', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
          <%=allSummaryReportGrantedListO.size()%>
       </a>
          </td></tr>
          </table>
         </td>
        
           <td>
           <table cellspacing="1"  >
         <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
      <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=green', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
        <%=allSummaryReportGrantedListG.size()%></a>
          </td></tr> 
          </table>
         </td>
          	     
          
           <td>
          <table cellspacing="1"  >
         <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
      <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=white', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
        <%=allSummaryReportGrantedListW.size()%>
       </a>
          </td></tr> 
        </table>
         </td>
         
         
         <td>
         <table cellspacing="1"  >
        <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
     <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&category=all', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
       <%=allSummaryReportGrantedList.size()%>
      </a>
         </td></tr> 
       </table>
        </td>
        
        
        
        
        
       
        <td>  
  	      <table cellspacing="1" >
  	       <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
    	      <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=rejected&category=red', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
         <%=allSummaryReportRejectedListR.size()%>
      	    </a>
      	      </td></tr> 
      	      </table>
    </td>
   
     <td>
  <table cellspacing="1"  >
  <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=rejected&category=orange', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
   <%=allSummaryReportRejectedListO.size()%>
  </a>
   </td></tr>
   </table>
  </td>

    <td>
    <table cellspacing="1"  >
  <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=rejected&category=green', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
  <%=allSummaryReportRejectedListG.size()%></a>
   </td></tr> 
   </table>
  </td>
   	     
   
    <td>
   <table cellspacing="1"  >
  <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=rejected&category=white', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
  <%=allSummaryReportRejectedListW.size()%>
  </a>
   </td></tr> 
  </table>
  </td>


  <td>
  <table cellspacing="1"  >
  <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=rejected&category=all', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
  <%=allSummaryReportRejectedList.size()%>
  </a>
  </td></tr> 
  </table>
  </td>
                 
           










  <td>  
  <table cellspacing="1" >
   <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
    <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=pending&category=red', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
  <%=allSummaryReportPendingListR.size()%>
    </a>
      </td></tr> 
      </table>
  </td>

  <td>
  <table cellspacing="1"  >
  <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=pending&category=orange', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
  <%=allSummaryReportPendingListO.size()%>
  </a>
  </td></tr>
  </table>
  </td>

  <td>
  <table cellspacing="1"  >
  <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=pending&category=green', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
  <%=allSummaryReportPendingListG.size()%></a>
  </td></tr> 
  </table>
  </td>


  <td>
  <table cellspacing="1"  >
  <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=pending&category=white', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
  <%=allSummaryReportPendingListW.size()%>
  </a>
  </td></tr> 
  </table>
  </td>


  <td>
  <table cellspacing="1"  >
  <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotApp?date=${sqlDate}&groupId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=pending&category=all', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
  <%=allSummaryReportPendingList.size()%>
  </a>
  </td></tr> 
  </table>
  </td>
               
  <%

	
		
  		appliedR=appliedR+allSummaryReportReceivedListR.size();
		appliedO=appliedO+allSummaryReportReceivedListO.size(); 
		appliedG=appliedG+allSummaryReportReceivedListG.size(); 
		appliedW=appliedW+allSummaryReportReceivedListW.size(); 
		appliedT=appliedT+allSummaryReportReceivedList.size();
		
		
		issuedR=issuedR+allSummaryReportGrantedListR.size();
		issuedO=issuedO+allSummaryReportGrantedListO.size(); 
		issuedG=issuedG+allSummaryReportGrantedListG.size(); 
		issuedW=issuedW+allSummaryReportGrantedListW.size(); 
		issuedT=issuedT+allSummaryReportGrantedList.size() 
		
		
		rejectedR=rejectedR+allSummaryReportRejectedListR.size();
		rejectedO=rejectedO+allSummaryReportRejectedListO.size(); 
		rejectedG=rejectedG+allSummaryReportRejectedListG.size(); 
		rejectedW=rejectedW+allSummaryReportRejectedListW.size(); 
		rejectedT=rejectedT+allSummaryReportRejectedList.size() 
		
		
		pendingR=pendingR+allSummaryReportPendingListR.size();
		pendingO=pendingO+allSummaryReportPendingListO.size(); 
		pendingG=pendingG+allSummaryReportPendingListG.size(); 
		pendingW=pendingW+allSummaryReportPendingListW.size(); 
		pendingT=pendingT+allSummaryReportPendingList.size(); 
		
		
		
		
%>
               
                </g:each>	 
                <tr>
                <td>Grand Total</td>
               
                <td><%=appliedR%></td>
                <td><%=appliedO%></td>
                <td><%=appliedG%></td>
                <td><%=appliedW%></td>
                <td><%=appliedT%></td>
                
                <td><%=issuedR%></td>
                <td><%=issuedO%></td>
                <td><%=issuedG%></td>
                <td><%=issuedW%></td>
                <td><%=issuedT%></td>
                
                <td><%=rejectedR%></td>
                <td><%=rejectedO%></td>
                <td><%=rejectedG%></td>
                <td><%=rejectedW%></td>
                <td><%=rejectedT%></td>
                
                
                <td><%=pendingR%></td>
                <td><%=pendingO%></td>
                <td><%=pendingG%></td>
                <td><%=pendingW%></td>
                <td><%=pendingT%></td>
                
                </tr>
              </tr>
             
                
                </table>
		
</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>

</html>