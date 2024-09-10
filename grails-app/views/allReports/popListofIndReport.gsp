<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%@ page import="java.text.*" %>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>


<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
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
 
 <td colspan="9" align="center" ><span class="headngblue"><span style="color:red;font-size:13px;">Consent wise status of applied Industries: Office wise<br></span> 
 </span>
 </td>
 </tr> 
<tr>
<td colspan="9" align="center" ><span class="headngblue"> 
<% if(dd1 && dd1.length()>3) {%>From <font color="red"> <%=dd1%></font> To <font color="red"><%=dd3%></font><%}%>
<% if(appFor && appFor!="NotSelected") {%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Application Type <font color="red"> <%=applicationType%></font> Certificate For <font color="red"><%=certificateFor%></font><%}%>
</span>
</td>
</tr>
<tr><td></td></tr>
</table>

	
<table width=140% align="center" border="2" style="border:3px solid green;" cellpadding="0" cellspacing="0"  class="tab-txt">

                  
		<tr width="200%" bgcolor="#A8DAF3"  >
                   
                   	       <th align="center" style="width:40%;border-bottom:3px solid green;" class="headngblue" >District Office</th>
                   	     
                   	        <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Applied</th>
                   	         <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Consent Issued</th> 
                   	     <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Rejected</th> 
                   	      <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue" >Balance to be issued</th> 
                   	      
                   	      
                   	      
                   	     
                  </tr>
             
                  
                  
                  	<% 	
                  	    def grandTotTC = 0 
                  		def grandTotPTC = 0
                  		def grandTotGTC = 0
                  		def grandTotRTC = 0
                  		Set<String> uniqueIndustry=new HashSet<String>();
                  	    
                  	%>
    <g:each in="${groupList}" status="i" var="groupMasterInstance">
           
           
              <tr width="100%" bgcolor="#A8DAF3">

                
                    
                   	       <%
                   	     	
                    def groupId = groupMasterInstance.id
				    
        			def indListFinal = new ArrayList()
        			def indListFinalGranted = new ArrayList()
        			def indListFinalRejected = new ArrayList()
        			def indListFinalPending = new ArrayList()
        			
        			def  disList = GroupDistrictMaster.findAll("from GroupDistrictMaster  as abc where abc.group.id=? ORDER BY version Asc",[groupId])
        			def newVar="Air & Water"
        			def  disList1 = disList.district
        			
        			for(int iei=0;iei<disList1.size();iei++){
        			  
        			def allSummaryReportList = new ArrayList()
        			if(appFor && appFor=="NotSelected"){
        			    allSummaryReportList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.districtId=? and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ? and 1=2",[(disList1.get(iei).id).toString(),sqlDate,sqlDate2])
        			}else{
						allSummaryReportList = AllSummaryReport.findAll("from AllSummaryReport  as abc where abc.districtId=? and abc.applicationType=? and abc.certificateFor=? and abc.applicationRecieptDate >= ? and abc.applicationRecieptDate <= ? ",[(disList1.get(iei).id).toString(),applicationType,certificateFor,sqlDate,sqlDate2])
        			}
        			        			
        			for(int ii=0;ii<allSummaryReportList.size();ii++)
        			{
        			
        				
        			if(uniqueIndustry.add(allSummaryReportList.get(ii).indRegMasterId))
        			{
        				indListFinal.add(allSummaryReportList.get(ii).indRegMasterId)
        				
        				if(allSummaryReportList.get(ii).applicationStatus.equals("approved")){        				
        					indListFinalGranted.add(allSummaryReportList.get(ii).indRegMasterId)		
        		        }
        			
        				if(allSummaryReportList.get(ii).applicationStatus.equals("rejected")){
            				indListFinalRejected.add(allSummaryReportList.get(ii).indRegMasterId)	
                		}
            			
            			if(allSummaryReportList.get(ii).applicationStatus.equals("pending")){
            				indListFinalPending.add(allSummaryReportList.get(ii).indRegMasterId)	
                		}
        			} 			
        		}
             	
        		}
                
                   	    grandTotTC = grandTotTC + indListFinal.size() 
             		    grandTotPTC = grandTotPTC + indListFinalPending.size()
             		    grandTotGTC = grandTotGTC + indListFinalGranted.size()
             		    grandTotRTC = grandTotRTC + indListFinalRejected.size()
        		
                  	       %>
                   	       
                   	       <td align="center" >
                   	      
                   	       <%=groupMasterInstance%>
                   	    
                   	       </td>
                
                 <td   >
                   	     
                   	    
                   	      <table cellspacing="1" >
                   	      
                   	      <tr  ><td>
                   	      
                   	      <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotInd?date=${sqlDate}&groupId=${groupMasterInstance.id}&applicationType=${applicationType}&certificateFor=${certificateFor}&date1=${sqlDate2}&type=all', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                   	      
                   <%=indListFinal.size()%>
                   	    
                   	    </a>
                   	      </td></tr> 
                   	      
                   	      </table>
                   	        
                   	  
                   	     </td>
                   	     
                 
                
               
                  
                  
                   
                   <td>
                  
                 
                  
                  
                  
                <table cellspacing="1"  >
                
                 
                
                <tr ><td>
                
   <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotInd?date=${sqlDate}&groupId=${groupMasterInstance.id}&applicationType=${applicationType}&certificateFor=${certificateFor}&appFor=${newVar}&date1=${sqlDate2}&type=approved', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">

                 <%=indListFinalGranted.size()%>
               
              </a>





                 </td></tr> 
                 
                
                 </table>
               
               
               
                </td>
               
                  <td>
                  
                  <table cellspacing="1"  >
                  
                  
                  
               <tr ><td>
             
             <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotInd?date=${sqlDate}&groupId=${groupMasterInstance.id}&applicationType=${applicationType}&certificateFor=${certificateFor}&appFor=${newVar}&date1=${sqlDate2}&type=rejected', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
             
               <%=indListFinalRejected.size()%>
               
                 </td></tr> 
                 </table>
                </td>
                 	     
                 
                  <td>
                  
                 <table cellspacing="1"  >
                  
                   
                <tr ><td>
             
             <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotInd?date=${sqlDate}&groupId=${groupMasterInstance.id}&applicationType=${applicationType}&certificateFor=${certificateFor}&appFor=${newVar}&date1=${sqlDate2}&type=pending', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
             
               <%=indListFinalPending.size()%>
              </a>
                 </td></tr> 
               
               </table>
               
                </td>
                </tr>
                               
                </g:each>	  
              <tr>
                 <td>Grand Total</td>
                 <td><%=grandTotTC%></td>
                 <td><%=grandTotGTC%></td>
                 <td><%=grandTotRTC%></td>
                 <td><%=grandTotPTC%></td>
              </tr>
                
                </table>
		
</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>

</html>


