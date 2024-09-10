<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>


<%
java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
java.text.SimpleDateFormat dmyFormat = new java.text.SimpleDateFormat("dd-MM-yyyy");
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />


<script type="text/javascript" src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>


<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'print.css' )}" media="print" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

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

<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

<% String cont=request.getContextPath();

%>

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
<table width="70%" align="center" class="print">
	<tr>
		<td  align="center" ><font size="6"><b>List of Industry Profiles with Consents issued status</b></font>
		</td>
	</tr>
	<tr>	
		<td  align="right" class="txt4">
			<a href="#" onclick="window.print();" ><img  height="25" width="25" src="${createLinkTo(dir:'images',file:'Print3.gif')}" border="0" align="center" alt="Print this Form" >Print</a>
		</td>
	</tr>
	<%if(applicationPendingDetailsList && applicationPendingDetailsList.size()>0){%>
	<tr>
		<td class="headngblue" align="center"><font color="#000080" size="4">Category : <font color="#800000"><i><%=applicationPendingDetailsList[0].application.indUser.category%></i></font>    Type : <font color="#800000"><i><%=applicationPendingDetailsList[0].application.indUser.industryType%></i></font>    Classification : <font color="#800000"><i><%=applicationPendingDetailsList[0].application.indUser.industryScale%></i></font></font>
		</td>
	</tr>
	
	<%}%>
	
		
</table>	
<table width="80%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="print tab-txt" style="border-collapse:collapse;">

             <tr height="20" bgcolor="#A8DAF3">

                     
                   	        
                   	        <th align="center" class="headngblue" >S.No.</th>
                   	        <th align="center" class="headngblue" >Office<br>Revenue District</th>
                   	        <th align="center" class="headngblue" >Category<br>Classification<br>GFA(Lakhs)</th>
                   	        <th align="center" class="headngblue" >Industry Name<br>Address</th>
                   	        <th align="center" class="headngblue" >Latest consent-Issue Date<br>Valid date</th>
                   	        <th align="center" class="headngblue" >Latest Date of Inspection</th>
                   	        <th align="center" class="headngblue" >Action</th>
                   	        
                   	        
 </tr>
                    <g:each in="${applicationPendingDetailsList}" status="i" var="applicationPendingDetailsIntance">
                    	
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                       
                          <%
                              def recordCertificatesInstance=RecordCertificate.findByApplicationId(applicationPendingDetailsIntance.application)
                              def latestDateOfInspection=ApplicationProcessingDetails.find("from ApplicationProcessingDetails where application.id=? and inspectionClose=true order by id desc",[applicationPendingDetailsIntance.application.id]);
                              if(latestDateOfInspection)
                              {
                                  latestDateOfInspection=dmyFormat.format(latestDateOfInspection.dateCreated)
                              }
                              else
                              {
                                  latestDateOfInspection=""
                              }
                          %>
                            <td align="center" height="25" class="txt4">${(i+1)}</td>
                            <td align="center" height="25" class="txt4">${applicationPendingDetailsIntance.application.indUser.district}<br>${applicationPendingDetailsIntance.application.indUser.district}</td>
                            <td align="center" height="25" class="txt4">${applicationPendingDetailsIntance.application.indUser.category}<br>${applicationPendingDetailsIntance.application.indUser.industryScale}<br><%=df.format(applicationPendingDetailsIntance.application.indUser.indCapInvt)%></td>
                            <td align="center" height="25" class="txt4">${applicationPendingDetailsIntance.application.indUser.indName}</font><br>${applicationPendingDetailsIntance.application.indUser.indAddress}</td>
                            <td align="center" height="25" class="txt4">${dmyFormat.format(recordCertificatesInstance.startDate)}<br>${dmyFormat.format(recordCertificatesInstance.endDate)}</td>
                            <td align="center" height="25" class="txt4">${latestDateOfInspection}</td>
                            <td align="center" height="25" class="txt4">
                            <%
           	                  def grantApplicationInstance = ApplicationPendingDetails.findAll("from ApplicationPendingDetails apd where apd.application.indUser.id=? and applicationStatus!='pending' order by id desc",[applicationPendingDetailsIntance.application.indUser.id])
	                          if(grantApplicationInstance){%>
		                      <a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/newPage/${applicationPendingDetailsIntance.application.indUser.id}', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View Previous Application Details</span></a>
	                        <%}%>
           	               </td>
                        </tr>
				 </g:each>
				 <%if(!applicationPendingDetailsList || applicationPendingDetailsList.size()==0){%>
	             <tr>
		          <td align="left" height="25" class="txt4" colspan="8">No Recoeds Found...</td>
	             </tr>
	            <%}%>

                </table>
               
		
            <br />
            <br />
         
	  
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
     
      <!-- code for spcb Footer -->
	  <g:include controller="userMaster" action="showSpcbFooter"/>
   
</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>

</html>


