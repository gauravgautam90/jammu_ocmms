
<%@ page import="java.util.Calendar;"%>
<%@ page import="java.util.Date;"%>
<%@ page import="java.text.SimpleDateFormat;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Industry Home</title>


<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>

<style type="text/css">
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

</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>
</head>

<body >
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="91" align="left" valign="top" class="bgtop">
		<!-- code for spcbHeader  -->
		<g:include controller="userMaster" action="showSpcbHeader"/>
		</td>
      </tr>
      <tr>
        <td height="32" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}" >
		<!-- code for menuIndustryHorizontal-->
		<g:include controller="userMaster" action="showIndustryMenuHorizontal"/>
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuSpcbUser-->
			<g:include controller="userMaster" action="showSpcbIndustryMenu"/>
			</td>
            <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td><img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" /></td>
              </tr>
<%
  IndustryRegMaster ind=(IndustryRegMaster)session.getAttribute("indregName");
            	String indname=ind.indName;
             
              java.util.Date dateSCR = new java.util.Date();
             	int  year=dateSCR.getYear();
             	 if (year < 1000)
                     year+=1900;
               	int date=dateSCR.getDate();
                int month=(dateSCR.getMonth()) + 1;
               

              %>
              <tr>
                <td height="24" bgcolor="#EEEEF3">
					
					<table width="100%" bgcolor="#4C8BC0">
						 <tr >
						 	<td class="top-lnks">Welcome <%=indname %></td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle">&nbsp;</div></td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="33" align="left" valign="top">&nbsp;</td>
                            <td width="710" align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
   
         <div align="center" style="border":1px solid gray; width:750px; margin-bottom: 1em; padding: 10px" >
         
        <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0"  >
				<tr valign="middle">
                  <td  width="100%" align="center" >
				  	
					<ol id="toc">
						<li><a href="#country1"><span>Verification Details</span></a></li>
						
					</ol>
				  </td>
				  <td  align="right" valign="middle"  class="headngblue"></td>
				</tr>		
	    </table>
         
          <div class="content" id="country1">
            <table width="103%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
   
		  <tr>
		    <td bgcolor="#FFFFFF">
			
             <table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
        			<thead>
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	        
							
							<th align="center" class="headngblue" >Application No</th>
							<th align="center" class="headngblue" >Bank Name</th>
							<th align="center" class="headngblue" >PRN No.</th>
					
							<th align="center" class="headngblue" >Transaction Date</th>
							<th align="center" class="headngblue" >Amount</th>
							<th align="center" class="headngblue" >Transaction Status</th>
						
						
                        </tr>
                        
                        
                        
                        
                    </thead>
                   
                   
                       
                      
                   
                   
                    <tbody>
                    <%
                     
			
	             
                    if((messageList.id).size()==0){ %><tr><td colspan="10" height="25" align="center" class="txt4">List Is Empty</td></tr><%} %>
                    <g:each in="${messageList}" status="i" var="messDetailsInstance">
                       <%
                       def stausForTransaction = ""
                       if(messDetailsInstance.transactionStatus=="F"){
                       stausForTransaction= 'Falied'
                       }else{
                       
                       stausForTransaction= 'Completed Successfully'
                       }
                       
                       
                       
                       %>
                        
                        
                        
                        
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td height="25" align="center" class="txt4" >${messDetailsInstance.indApplication}</td>
                             <td align="center" height="25" class="txt4" >${fieldValue(bean:messDetailsInstance, field:'bankName')}</td>
                        	 <td align="center" height="25" class="txt4" >${fieldValue(bean:messDetailsInstance, field:'id')}</td>
                        	<%	String dateWithoutTime = new SimpleDateFormat("dd-MM-yyyy hh:mm").format(messDetailsInstance.dateCreated);
			System.out.println("sdf.format(d)---------> " + dateWithoutTime);		
 	             
       %>
                        	
                        	 <td align="center" height="25" class="txt4" >${dateWithoutTime}</td>
                        	
                        	 <td align="center" height="25" class="txt4" >${fieldValue(bean:messDetailsInstance, field:'amount')}</td>
                        	 <td align="center" height="25" class="txt4" >${stausForTransaction}</td>
                        	 <td align="center" height="25" class="txt4" ><font face="Verdana" color="green">
                        	 
                        	 <%
                        	  if(messDetailsInstance.transactionStatus=="F"){
             
                       %>
                       <!-- 	 <g:link controller="indApplicationDetails" action="verificationPage" id="${messDetailsInstance.id}">Verify</a></g:link>
                        	 -->
                        	 <%}%>
                        	 </td>
                         	
                        
                        </tr>
                    </g:each>
                    </tbody> 
      </table></td>
		  </tr></table>
		
		  
            <br />
            <br />
           
          </div>
          </div>
		  

      </div></td>
                            <td width="35" align="left" valign="top">&nbsp;</td>
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
</html>


