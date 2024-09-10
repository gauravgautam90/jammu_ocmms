<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<%@ page import="java.text.*" %>
<head>

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
 
 <td colspan="9" align="center" >
 <span class="headngblue">
       <span style="color:red;font-size:13px;">Status of Consent Issued</span> 
       <% if(dd1 && dd1.length()>3) {%>From <font color="red"> <%=dd1%></font> To <font color="red"><%=dd3%></font><%}%>
 </span>
 </td>
 </tr> 
<tr><td></td></tr>               
</table>



<table width=90% align="center" border="2" style="border:3px solid green;" cellpadding="0" cellspacing="0"  class="tab-txt">

                  
		<tr width="90%" bgcolor="#A8DAF3"  >
                   
                   	    <th align="center" rowspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >District</th>
                   	    <th align="center" colspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >RED</th> 
                   	  <th align="center" colspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >RED</th>
                   	<th align="center" colspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >ORANGE</th>
                   	<th align="center" colspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >ORANGE</th>
                   	<th align="center" colspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >GREEN</th>
                   	<th align="center" colspan="2" style="width:15%;border-bottom:3px solid green;" class="headngblue" >GREEN</th>
                   	<th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >White</th>
                   	<th align="center" rowspan="2" style="width:5%;border-bottom:3px solid green;" class="headngblue" >TOTAL</th>
                   	      
                  </tr>
                  
                  <tr width="200%" bgcolor="#A8DAF3"  >
                  <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >CTE(F)</th> 
             	  <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >CTE(R)</th>
             	 <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >CTO(F)</th> 
            	  <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >CTO(R)</th>
             	 <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >CTE(F)</th> 
            	  <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >CTE(R)</th>
            	  <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >CTO(F)</th> 
            	  <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >CTO(R)</th>
            	  <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >CTE(F)</th> 
             	  <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >CTE(R)</th>
             	 <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >CTO(F)</th> 
           	  <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >CTO(R)</th>
           	 <th align="center" style="width:5%;border-bottom:3px solid green;" class="headngblue" >Exemption</th>
             	      
            </tr>
                
            <% 	
     	   def grandTot1 = 0
     	  def grandTot2 = 0
     	 def grandTot3 = 0
     	def grandTot4 = 0
     	
     	def grandTot5 = 0
     	def grandTot6 = 0
     	def grandTot7 = 0
     	def grandTot8 = 0
     	
     	def grandTot9 = 0
     	def grandTot10 = 0
     	def grandTot11= 0
     	def grandTot12 = 0
     	def grandTot13=0
     	
     	def totalperRow=0
     	def completeTotal=0
     	%>
           
           
<g:each in="${groupList}" status="i" var="GroupMasterInstance">
    
    <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">   

         
             
        <%
            	def roleArray = new ArrayList()
 		    def districtId = (GroupMasterInstance.id).toString()
 			def allSummaryReportGrantedList = new ArrayList()
 			def indList = new ArrayList()
 			def appPendGrantedList 
 			def appProcessingGrantedList
 			def appPendRejectedList 
 			def appProcessingRejectedList
 			def appPendList 
 			def appReceivedList
 			def newVar
 			allSummaryReportGrantedList = AllSummaryReport.findAll("from AllSummaryReport as abc where abc.districtId=? and pendingSince>= ? and  pendingSince<= ? and abc.applicationStatus ='approved' order by abc.id desc ",[districtId,sqlDate,sqlDate2])			
			def CTERedFreshList= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.districtId=? and abc.pendingSince>= ? and  abc.pendingSince<= ? and abc.applicationStatus ='approved' and abc.applicationType='CTE' and abc.certificateFor='new' and abc.indCategoryName='RED' order by abc.id desc ",[districtId,sqlDate,sqlDate2])	
			def CTERedRenewList= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.districtId=? and abc.pendingSince>= ? and  abc.pendingSince<= ? and abc.applicationStatus ='approved' and abc.applicationType='CTE' and abc.certificateFor='reNew' and abc.indCategoryName='RED' order by abc.id desc ",[districtId,sqlDate,sqlDate2])
			def CTORedFreshList= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.districtId=? and abc.pendingSince>= ? and  abc.pendingSince<= ? and abc.applicationStatus ='approved' and abc.applicationType='CTO' and abc.certificateFor='new' and abc.indCategoryName='RED' order by abc.id desc ",[districtId,sqlDate,sqlDate2])
			def CTORedRenewList= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.districtId=? and abc.pendingSince>= ? and  abc.pendingSince<= ? and abc.applicationStatus ='approved' and abc.applicationType='CTO' and abc.certificateFor='reNew' and abc.indCategoryName='RED' order by abc.id desc ",[districtId,sqlDate,sqlDate2])
			
			def CTEOrangeFreshList= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.districtId=? and abc.pendingSince>= ? and  abc.pendingSince<= ? and abc.applicationStatus ='approved' and abc.applicationType='CTE' and abc.certificateFor='new' and abc.indCategoryName='ORANGE' order by abc.id desc ",[districtId,sqlDate,sqlDate2])
			def CTEOrangeRenewList= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.districtId=? and abc.pendingSince>= ? and  abc.pendingSince<= ? and abc.applicationStatus ='approved' and abc.applicationType='CTE' and abc.certificateFor='reNew' and abc.indCategoryName='ORANGE' order by abc.id desc ",[districtId,sqlDate,sqlDate2])
			def CTOOrangeFreshList= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.districtId=? and abc.pendingSince>= ? and  abc.pendingSince<= ? and abc.applicationStatus ='approved' and abc.applicationType='CTO' and abc.certificateFor='new' and abc.indCategoryName='ORANGE' order by abc.id desc ",[districtId,sqlDate,sqlDate2])
			def CTOOrangeRenewList= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.districtId=? and abc.pendingSince>= ? and  abc.pendingSince<= ? and abc.applicationStatus ='approved' and abc.applicationType='CTO' and abc.certificateFor='reNew' and abc.indCategoryName='ORANGE' order by abc.id desc ",[districtId,sqlDate,sqlDate2])
			
			def CTEGreenFreshList= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.districtId=? and abc.pendingSince>= ? and  abc.pendingSince<= ? and abc.applicationStatus ='approved' and abc.applicationType='CTE' and abc.certificateFor='new' and abc.indCategoryName='GREEN' order by abc.id desc ",[districtId,sqlDate,sqlDate2])
			def CTEGreenRenewList= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.districtId=? and abc.pendingSince>= ? and  abc.pendingSince<= ? and abc.applicationStatus ='approved' and abc.applicationType='CTE' and abc.certificateFor='reNew' and abc.indCategoryName='GREEN' order by abc.id desc ",[districtId,sqlDate,sqlDate2])
			def CTOGreenFreshList= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.districtId=? and abc.pendingSince>= ? and  abc.pendingSince<= ? and abc.applicationStatus ='approved' and abc.applicationType='CTO' and abc.certificateFor='new' and abc.indCategoryName='GREEN' order by abc.id desc ",[districtId,sqlDate,sqlDate2])
			def CTOGreenRenewList= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.districtId=? and abc.pendingSince>= ? and  abc.pendingSince<= ? and abc.applicationStatus ='approved' and abc.applicationType='CTO' and abc.certificateFor='reNew' and abc.indCategoryName='GREEN' order by abc.id desc ",[districtId,sqlDate,sqlDate2])
			
			def CTOWhiteList= AllSummaryReport.findAll("from AllSummaryReport as abc where abc.districtId=? and abc.pendingSince>= ? and  abc.pendingSince<= ? and abc.applicationStatus ='approved' and abc.indCategoryName='WHITE' order by abc.id desc ",[districtId,sqlDate,sqlDate2])
			
			 totalperRow= CTERedFreshList+CTERedRenewList+CTORedFreshList+CTORedRenewList+
								CTEOrangeFreshList+CTEOrangeRenewList+CTOOrangeFreshList+CTOOrangeRenewList+
								CTEGreenFreshList+CTEGreenRenewList+CTOGreenFreshList+CTOGreenRenewList+
								CTOWhiteList
			%>
            	       
            <td align="center" >
            	    <%=GroupMasterInstance%>
              </td>
          
           <td>
         <table cellspacing="1"  >
         <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotAppCategoryWise?date=${sqlDate}&districtId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&appType=CTE&certFor=new&cat=RED', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
          <%=CTERedFreshList.size()%>
       </a>
          </td></tr>
          </table>
         </td>
         
         <td>
         <table cellspacing="1"  >
         <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotAppCategoryWise?date=${sqlDate}&districtId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&appType=CTE&certFor=reNew&cat=RED', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
          <%=CTERedRenewList.size()%>
       </a>
          </td></tr>
          </table>
         </td>
        
         <td>
         <table cellspacing="1"  >
         <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotAppCategoryWise?date=${sqlDate}&districtId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&appType=CTO&certFor=new&cat=RED', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
          <%=CTORedFreshList.size()%>
       </a>
          </td></tr>
          </table>
         </td>
        
         <td>
         <table cellspacing="1"  >
         <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotAppCategoryWise?date=${sqlDate}&districtId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&appType=CTO&certFor=reNew&cat=RED', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
          <%=CTORedRenewList.size()%>
       </a>
          </td></tr>
          </table>
         </td>
         
       
         <td>
         <table cellspacing="1"  >
         <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotAppCategoryWise?date=${sqlDate}&districtId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&appType=CTE&certFor=new&cat=ORANGE', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
          <%=CTEOrangeFreshList.size()%>
       </a>
          </td></tr>
          </table>
         </td>
         
         <td>
         <table cellspacing="1"  >
         <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotAppCategoryWise?date=${sqlDate}&districtId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&appType=CTE&certFor=reNew&cat=ORANGE', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
          <%=CTEOrangeRenewList.size()%>
       </a>
          </td></tr>
          </table>
         </td>
        
         <td>
         <table cellspacing="1"  >
         <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotAppCategoryWise?date=${sqlDate}&districtId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&appType=CTO&certFor=new&cat=ORANGE', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
          <%=CTOOrangeFreshList.size()%>
       </a>
          </td></tr>
          </table>
         </td>
        
         <td>
         <table cellspacing="1"  >
         <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotAppCategoryWise?date=${sqlDate}&districtId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&appType=CTO&certFor=reNew&cat=ORANGE', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
          <%=CTOOrangeRenewList.size()%>
       </a>
          </td></tr>
          </table>
         </td>
         
         
         <td>
         <table cellspacing="1"  >
         <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotAppCategoryWise?date=${sqlDate}&districtId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&appType=CTE&certFor=new&cat=GREEN', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
          <%=CTEGreenFreshList.size()%>
       </a>
          </td></tr>
          </table>
         </td>
         
         <td>
         <table cellspacing="1"  >
         <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotAppCategoryWise?date=${sqlDate}&districtId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&appType=CTE&certFor=reNew&cat=GREEN', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
          <%=CTEGreenRenewList.size()%>
       </a>
          </td></tr>
          </table>
         </td>
        
         <td>
         <table cellspacing="1"  >
         <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotAppCategoryWise?date=${sqlDate}&districtId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&appType=CTO&certFor=new&cat=GREEN', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
          <%=CTOGreenFreshList.size()%>
       </a>
          </td></tr>
          </table>
         </td>
        
         <td>
         <table cellspacing="1"  >
         <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotAppCategoryWise?date=${sqlDate}&districtId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&appType=CTO&certFor=reNew&cat=GREEN', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
          <%=CTOGreenRenewList.size()%>
       </a>
          </td></tr>
          </table>
         </td>
         
         <td>
         <table cellspacing="1"  >
         <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotAppCategoryWise?date=${sqlDate}&districtId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved&cat=WHITE', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
          <%=CTOWhiteList.size()%>
       </a>
          </td></tr>
          </table>
         </td>
       
         <td>
         <table cellspacing="1"  >
         <tr width="100%" bgcolor="${(i % 2) == 0 ? '#A8DAF3' : '#DCF0FA'}">  
  <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/getTotAppCategoryWiseOnlyDistrict?date=${sqlDate}&districtId=${GroupMasterInstance.id}&date1=${sqlDate2}&status=approved', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
          <%=totalperRow.size()%>
       </a>
          </td></tr>
          </table>
         </td>
      
        
        <%
        grandTot1 = grandTot1 + CTERedFreshList.size() 
			grandTot2 = grandTot2 + CTERedRenewList.size()
			grandTot3= grandTot3 + CTORedFreshList.size()
			grandTot4 = grandTot4 + CTORedRenewList.size()
			
			grandTot5 = grandTot5 + CTEOrangeFreshList.size() 
			grandTot6 = grandTot6 + CTEOrangeRenewList.size()
			grandTot7= grandTot7 + CTOOrangeFreshList.size()
			grandTot8 = grandTot8 + CTOOrangeRenewList.size()
			
			grandTot9 = grandTot9 + CTEGreenFreshList.size() 
			grandTot10 = grandTot10 + CTEGreenRenewList.size()
			grandTot11= grandTot11 + CTOGreenFreshList.size()
			grandTot12 = grandTot12 + CTOGreenRenewList.size()
			grandTot13 = grandTot13 + CTOWhiteList.size()
			completeTotal=grandTot1+grandTot2+grandTot3+grandTot4+grandTot5+grandTot6+grandTot7+grandTot8+grandTot9+grandTot10+grandTot11+grandTot12+grandTot13
   %>
        
         </g:each>	 
         <tr>
         <td>Grand Total</td>
         <td><%=grandTot1%></td>
         <td><%=grandTot2%></td>
         <td><%=grandTot3%></td>
         <td><%=grandTot4%></td>
         
         <td><%=grandTot5%></td>
         <td><%=grandTot6%></td>
         <td><%=grandTot7%></td>
         <td><%=grandTot8%></td>
         
         <td><%=grandTot9%></td>
         <td><%=grandTot10%></td>
         <td><%=grandTot11%></td>
         <td><%=grandTot12%></td>
         <td><%=grandTot13%></td>
         <td><%=completeTotal%></td>
         
         </tr>
       </tr> </table>
	
     <br />
     <br />
   
	  </form>
	  
<% session.endDate1=null
	  session.startDate1=null
%>
	  
   </div>


</div></td>
                     <td width="82" align="left" valign="top">&nbsp;</td>
                   </tr>
               </table></td>
             </tr>
             
         </table></td>
       </tr>
       
     </table></td>
   </tr>
 </table></td>
</tr>
<!-- code for spcb Footer -->
<g:include controller="userMaster" action="showSpcbFooter"/>
</table></td>
</tr>
</table>
</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>


