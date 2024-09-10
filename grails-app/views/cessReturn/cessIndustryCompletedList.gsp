<%@ page import="java.text.SimpleDateFormat"%>
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
			<g:include controller="userMaster" action="cessIndustryMenuVertical"/>
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
   <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0"  >
				<tr valign="middle">
                  <td  width="100%" align="center" >
				  	
					<ol id="toc">
						<li><a href="#country1"><span>In-progress Application</span></a></li>
						<li><a href="#country2"><span>Completed Application</span></a></li>
					</ol>
				  </td>
				  <td  align="right" valign="middle"  class="headngblue"></td>
				</tr>		
	    </table>
         
         <div class="content" id="country1" >
         
		  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4">
			<tr>
                        <td valign="top" bgcolor="#FFFFFF"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
			
			<thead >
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	        
                        
                   	        <th align="center" class="headngblue" >Application No</th>
							<th align="center" class="headngblue" >Application Date</th>
							<th align="center" class="headngblue" >Industry Name</th>
							<th align="center" class="headngblue" >Cess Applied From</th> 
                   	        <th align="center" class="headngblue" >Cess Applied To</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <%if(cessList.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">List Is Empty</td></tr><%} %>
                    <g:each in="${cessList}" status="i" var="cessPendingInstance">
                         <% 
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
                         String strDate = sdfDestination.format(cessPendingInstance.dateCreated );                                              
			
			
			def yr=((cessPendingInstance.cessAppliedFromDate).getYear()+1900).toString()
				def mon=((cessPendingInstance.cessAppliedFromDate).getMonth()+1).toString()
						
			if (mon=="1"){
				mon = "January"
			}else if(mon=="2"){
				mon = "February"
			}else if(mon=="3"){
				mon = "March"
			}else if(mon=="4"){
				mon = "April"
			}else if(mon=="5"){
				mon = "May"
			}else if(mon=="6"){
				mon = "June"
			}else if(mon=="7"){
				mon = "July"
			}else if(mon=="8"){
				mon = "August"
			}else if(mon=="9"){
				mon = "September"
			}else if(mon=="10"){
				mon = "October"
			}else if(mon=="11"){
				mon = "November"
			}else if(mon=="12"){
				mon = "December"
			}
			
			def fromDate=mon+"/"+yr
               
                       
   			def yr1=((cessPendingInstance.cessAppliedToDate).getYear()+1900).toString()
			def mon1=((cessPendingInstance.cessAppliedToDate).getMonth()+1).toString()
							
			if (mon1=="1"){
				mon1 = "January"
			}else if(mon1=="2"){
				mon1 = "February"
			}else if(mon1=="3"){
				mon1 = "March"
			}else if(mon1=="4"){
				mon1 = "April"
			}else if(mon1=="5"){
				mon1 = "May"
			}else if(mon1=="6"){
				mon1 = "June"
			}else if(mon1=="7"){
				mon1 = "July"
			}else if(mon1=="8"){
				mon1 = "August"
			}else if(mon1=="9"){
				mon1 = "September"
			}else if(mon1=="10"){
				mon1 = "October"
			}else if(mon1=="11"){
				mon1 = "November"
			}else if(mon1=="12"){
				mon1 = "December"
			}
			def toDate=mon1+"/"+yr1
                       
							
                        %>
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                          
                            <td align="center" height="25" class="txt4"  ><u><g:link action="showCessSpcb" controller="cessReturn" id="${cessPendingInstance.id}" params="[checkEdit:'true']">${fieldValue(bean:cessPendingInstance, field:'id')}</g:link></u></td>
                            <td align="center" height="25"  class="txt4" ><font face="Verdana" color="red"><%=strDate%></font></td>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" color="red">${fieldValue(bean:cessPendingInstance, field:'industryReg')}</font></td>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" color="red"><%=fromDate%></font></td>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" color="red"><%=toDate%></font></td>
                           
                        </tr>
                    </g:each>
                    </tbody>
      </table></td>
                      </tr>	  
	  </table>
		   </div>
		   
		   <div class="content" id="country2" >
         
		  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4">
			<tr>
                        <td valign="top" bgcolor="#FFFFFF"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
			
			<thead >
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	        
                        
                   	        <th align="center" class="headngblue" >Application No</th>
							<th align="center" class="headngblue" >Application Date</th>
							<th align="center" class="headngblue" >Industry Name</th>
							<th align="center" class="headngblue" >Cess Applied From</th> 
                   	        <th align="center" class="headngblue" >Cess Applied To</th>
                   	        <th align="center" class="headngblue" >Status</th>
                   	   
                        </tr>
                    </thead>
                    <tbody>
                    <%if(cessListCompleted.size()==0){ %><tr><td colspan="6" height="25" align="center" class="txt4">List Is Empty</td></tr><%} %>
                    <g:each in="${cessListCompleted}" status="i" var="cessPendingInstance">
                         <% 
                        SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
   						 
                        String strDate = sdfDestination.format(cessPendingInstance.dateCreated );                                              
						
						
			def yr=((cessPendingInstance.cessAppliedFromDate).getYear()+1900).toString()
				def mon=((cessPendingInstance.cessAppliedFromDate).getMonth()+1).toString()
						
			if (mon=="1"){
				mon = "January"
			}else if(mon=="2"){
				mon = "February"
			}else if(mon=="3"){
				mon = "March"
			}else if(mon=="4"){
				mon = "April"
			}else if(mon=="5"){
				mon = "May"
			}else if(mon=="6"){
				mon = "June"
			}else if(mon=="7"){
				mon = "July"
			}else if(mon=="8"){
				mon = "August"
			}else if(mon=="9"){
				mon = "September"
			}else if(mon=="10"){
				mon = "October"
			}else if(mon=="11"){
				mon = "November"
			}else if(mon=="12"){
				mon = "December"
			}
			
			def fromDate=mon+"/"+yr
               
                       
   			def yr1=((cessPendingInstance.cessAppliedToDate).getYear()+1900).toString()
			def mon1=((cessPendingInstance.cessAppliedToDate).getMonth()+1).toString()
							
			if (mon1=="1"){
				mon1 = "January"
			}else if(mon1=="2"){
				mon1 = "February"
			}else if(mon1=="3"){
				mon1 = "March"
			}else if(mon1=="4"){
				mon1 = "April"
			}else if(mon1=="5"){
				mon1 = "May"
			}else if(mon1=="6"){
				mon1 = "June"
			}else if(mon1=="7"){
				mon1 = "July"
			}else if(mon1=="8"){
				mon1 = "August"
			}else if(mon1=="9"){
				mon1 = "September"
			}else if(mon1=="10"){
				mon1 = "October"
			}else if(mon1=="11"){
				mon1 = "November"
			}else if(mon1=="12"){
				mon1 = "December"
			}
			def toDate=mon1+"/"+yr1
                       
							
                      
                        %>
                         <% String colorCode;
                         if(cessPendingInstance.applicationStatus=="Completed" ){ 
                        	 colorCode="green";
                        }else if (cessPendingInstance.assessmentOrder || cessPendingInstance.assessmentIssue || cessPendingInstance.feesNotice){
                        	 colorCode="orange";
                        }else {
                        	colorCode="brown";
                        }
                        	%>
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                          
                            <td align="center" height="25" class="txt4"  ><u><g:link action="showCessSpcb" controller="cessReturn" id="${cessPendingInstance.id}"  params="[fee:'checked'">${fieldValue(bean:cessPendingInstance, field:'id')}</g:link></u></td>
                            <td align="center" height="25"  class="txt4" ><font face="Verdana" color="<%=colorCode%>"><%=strDate%></font></td>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" color="<%=colorCode%>">${fieldValue(bean:cessPendingInstance, field:'industryReg')}</font></td>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" color="<%=colorCode%>"><%=fromDate%></font></td>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" color="<%=colorCode%>"><%=toDate%></font></td>
                            <td align="center" height="25" class="txt4" ><font face="Verdana" color="<%=colorCode%>">${fieldValue(bean:cessPendingInstance, field:'applicationStatus')}</font></td>
                           <%if(cessPendingInstance.assessmentIssue){ %>
                        	<td align="center" height="25" class="txt4" width="10px"><a href="<%=request.getContextPath()%>/cessReturn/viewAssessIssue?appliId=<%=cessPendingInstance.id%>"><span class="innerlink">&nbsp;View Pre Assessment Notice&nbsp;</span></a></td> 
                        	<td align="center" height="25" class="txt4"><a href="#" onclick="window.open('<%=request.getContextPath()%>/cessReturn/submitClarification/${cessPendingInstance.id}', 'clarification', 'WIDTH=400,HEIGHT=250,scrollbars=1');"><img src="${createLinkTo(dir:'images',file:'Clarification.gif')}" border="0" align="center" alt="Reply of Pre Assessment Notice"></img></a></td> 
                        	<%} %>
                           <%if(cessPendingInstance.assessmentOrder){ %>
                        	<td align="center" height="25" class="txt4" width="10px"><a href="<%=request.getContextPath()%>/cessReturn/viewAssessOrder?appliId=<%=cessPendingInstance.id%>"><span class="innerlink">&nbsp;View Assessment Order&nbsp;</span></a></td> 
                        	<%} %>
                        	 <%if(cessPendingInstance.feesNotice){ %>
                        	<td align="center" height="25" class="txt4" width="10px"><a href="<%=request.getContextPath()%>/cessReturn/viewFeesDefauterNotice?appliId=<%=cessPendingInstance.id%>"><span class="innerlink">&nbsp;View Fee Defaulter Notice&nbsp;</span></a></td> 
                        	<%} %>
                        </tr>
                    </g:each>
                    </tbody>
      </table></td>
                      </tr>	  
	  </table> <table width="95%">
		  <tr><td>&nbsp;</td></tr>
		  <tr><td width="8px"  bgcolor="brown"></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Application Sent .</font></td></tr>
		  <tr><td width="8px"  bgcolor="orange"></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Pre Assessment Notice or Assessment Order or Fee Defaulter Notice is raised on these applications.</font></td></tr>
         <!-- <tr height="2px"><td>&nbsp;</td></tr> -->
          <tr><td width="8px"  bgcolor="green"></td><td><font face="Verdana" class="txt4">&nbsp;&nbsp;&nbsp;Application Completed .</font></td></tr>
          
          <table>
		   </div>

      </div></td>
                            <td width="35" align="left" valign="top">&nbsp;</td>
                          </tr>
                      </table></td>
                    </tr>
                    
                </table>
                </td>
              </tr>
              
            </table></td>
          </tr>
        </table></td>
      </tr>
    
    </table></td>
  </tr>
</table>
  <!-- code for spcb Footer -->
	  <g:include controller="userMaster" action="showSpcbFooter"/>
</body>
</html>


