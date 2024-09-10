<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>

<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>


<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
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
<script src="https:////ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">


<script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script></head>

<script language="javascript" type="text/javascript">

function popitup(url) {
	newwindow=window.open(url,'name','height=200px,width=500px');
	if (window.focus) {newwindow.focus()
	}
	return false;
}

</script>

<g:javascript>
function Check()
{
${remoteFunction(controller:'userMaster', action:'ajaxGrpSrch',params:'\'id=\' + escape(this.value)')}
}
</g:javascript>


<g:javascript>
function changeValue()
{
//alert("hhhhhhhhhhhh  ");
	var indtype = document.getElementById("applicationTypeid").value
	if(indtype=="CTO")
	{
		//alert("hhhhhhhhhhhh  "+applicationTypeid);
		document.getElementById("div2").style.display="block";
		document.getElementById("div1").style.display="none";
	document.getElementById("div3").style.display="none";
	
	}
	
	else 
	{
		//alert("hhhhhhhhhhhh  "+industryTypeid);
	document.getElementById("div1").style.display="none";
	document.getElementById("div2").style.display="none"
	document.getElementById("div3").style.display="block"
	
	}
	
}
</g:javascript>


<body  >
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
		<!-- code for menuAdminHorizontal-->
		<g:include controller="userMaster" action="showMenu"/>
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuAdmin-->
			
							<g:include controller="userMaster" action="showIndexMenu"/>            

                            
			</td>
            <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td><img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" /></td>
              </tr>  
              
              <tr>
                <td height="24" bgcolor="#EEEEF3">
					<table width="100%"> <tr bgcolor="#4C8BC0">
				<td  class="top-lnks" width="100%">
					<table width="100%" border="0" >
						 <tr height="10px" width="100%">
						 	<td></td>
						 	<td class="top-lnks" align="right">  </td>
						 </tr>
					 </table>
					 </td></tr><tr>
							
							
							<!--<td width="20%" align="left"><g:link controller="officeMaster" action="updateoffice" ><span class="innerlink">&nbsp;Update&nbsp;|</span></g:link></td> -->
							<td width="80%">&nbsp;</td>
					   </tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">
				                     <g:if test="${flash.message}">
									<div class="message">${flash.message}</div>
									</g:if>
									

                      </span></div></td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
       
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		
		
		
 <g:form action="authorizationreportsearch" name="myform" method="post" >
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                               <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Search Waste Authorization</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432" align="right"></td>
							</tr>
	    </table>
		<table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
		<!----------------START BY VINEET------------------------>
            <tr>
			<td colspan="4" bgcolor="#A8DAF3" align="left"><input type=radio id="searchOp" checked name=searchOp value="ApplId" <%if(paramList != null && (paramList.searchOp).equals("ApplId")){%>checked="checked"<%}%> ><span class="headngblue">By Application Id</span></td>
			
			</tr>
			
          <tr  >
            <td width="20%" class="headngblue"  bgcolor="#E8F6F9"   align="left" >Application Id:</td>
            <td align="left" colspan="3" bgcolor="#E8F6F9">
          
            <input type="text" class="txt4" id="autocomplete" size="30" name="autocomplete_parameter"/>
           
            <span class="txt4">(Enter application ID)</span></td>
			
          </tr>
          <tr>
			<td colspan="4" bgcolor="#A8DAF3" align="left"><input type=radio name=searchOp  id="searchOp" value="Date" <%if(paramList != null && (paramList.searchOp).equals("ApplId")){%>checked="checked"<%}%> ><span class="headngblue">By Date</span></td>
			
			</tr>
            <tr bgcolor="#E8F6F9">
                <td width="15%" align="left"  class="headngblue" >Start Date :<span style="color:red">*</span></td>
                <td width="33%" align="left" >
				<calendar:datePicker name="start_date" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                </td>
                <td  width="15%" align="left"  class="headngblue">End Date :<span style="color:red">*</span></td>
                <td align="left" width="37%"  >
				<calendar:datePicker name="end_date"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
			    </td>
			</tr>
			<tr bgcolor="#E8F6F9">
            
			 <td width="15%" align="left"  class="headngblue" >Application For :</td>
            <td width="33%" align="left" colspan="0">
            <g:select  class="txt4" from="${['HWM','BMW','PWM']}" name="appFor" noSelection="${['101':'All']}" ></g:select>
            </td>
            
            
		     <%
          	 def  districtOfficeMasterList = DistrictMaster.findAll(" from DistrictMaster"); 
            %>         
            <td width="15%" align="left"  class="headngblue" >District :</td>
            <td width="33%" align="left" >
            <g:select from="${districtOfficeMasterList}" name="districtId" id="districtId" noSelection="${['NotSelected':'All']}" class="txt4"></g:select>
           </td>
   	       </tr>
   	       <tr bgcolor="#E8F6F9">
  	       <td width="15%" align="left"  class="headngblue" >Status :</td>
		   <td align="left">
                <select class="txt4" name="status" id="status" >
                    <option value="All">All</option>
                    <option value="approved">Granted</option>
                    <option value="rejected">Refused</option>
                    <option value="returned">Returned</option>
                    <option value="pending">Under Process</option>
               </select>
		  </td>
		 
	      </tr>
                 
	    <!----------------START BY VINEET------------------------>     

        </table>
                
		
		<table width="100%"  border="0" align="center" class="tblbdr">
		               
		 <tr>
                <td  align="right"><input type="submit" name="Search" onclick="myFunction()" value="Search" class="actionbutton"></td>
                <td align="left"><g:link controller="userMaster" action="newRegIndustryMenu">
    			<input type="button" class="actionbutton" value="Back">
    			</g:link>
    			</td>
    			</tr>
		 </table>

  	</g:form>
  	<br/>
	        <g:if test="${flash.message}"><div class="error">${flash.message}</div></g:if>
  			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="white" class="tab-txt" style="border-collapse:collapse;">
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
  		         
  		        
  		        </tr> 
  		        <tr>
  		           <td colspan="9" align="center" ><span class="headngblue"> 
  		           <% if(dd1 && dd1.length()>3) {%>From <font color="red"> <%=dd1%></font> To <font color="red"><%=dd3%></font><%}%>
  		           </span>
  		           </td>
  		       </tr>
  		       <tr>
		        <td colspan="9" align="center" ><span class="headngblue"> 
		        <% if(appFor){%>Application For :
		        	<% if(appFor=='101'){ %>
		        	<font color="red">All</font>
		        	<% }else{ %>
		        	<font color="red"> <%=appFor%></font> <%}}%>
		        </span>
		        </td>
		        </tr>
		        
		        <tr>
		        <td colspan="9" align="center" ><span class="headngblue"> 
		        <% if(districtId){%>District : 
		        	<% if(districtId=='NotSelected'){ %>
		        	<font color="red">All</font>
		        	<% }else{ %>
		        	<font color="red"> <%=districtId%></font> <%}}%>
		        </span>
		        </td>
		        </tr>
		        
		        <tr>
		           <td colspan="9" align="center" ><span class="headngblue"> 
		           <% if(status) {%>Status :<font color="red"> <%=status%></font> <%}%>
		           </span>
		           </td>
		       </tr>
		       
		       <tr>
		        <td colspan="9" align="center" ><span class="headngblue"> 
		        <% if(category){%>Category :
		        	<% if(category=='101'){ %>
		        	<font color="red">All</font>
		        	<% }else{ %>
		        	<font color="red"> <%=category%></font> <%}}%>
		        </span>
		        </td>
		        </tr>
		       
		        
  		        <tr><td></td></tr>
				
			
			</table>
			<div style="overflow: auto;height:auto;width: auto">	    
  	        <table width="100%" align="center" border="2" style="border:3px solid green;" cellpadding="0" cellspacing="0"  class="tab-txt">
            
           <tr width="200%" bgcolor="#A8DAF3"  >
  			           
					   <th align="center" style="width:8%;border-bottom:3px solid green;" class="headngblue">S.No</th>
					   <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue">Industry Name</th>
					   <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue">Address</th>
					   <th align="center" style="width:10%;border-bottom:3px solid green;" class="headngblue">Application No</th>
					   <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue">Application for</th>
					   <th align="center" style="width:10%;border-bottom:3px solid green;" class="headngblue">District</th> 
					   <th align="center" style="width:10%;border-bottom:3px solid green;" class="headngblue">Group</th> 
					   <th align="center" style="width:10%;border-bottom:3px solid green;" class="headngblue">Category</th> 
					   <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue">Application Date</th> 
					   <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue">Status</th>
					   <th align="center" style="width:20%;border-bottom:3px solid green;" class="headngblue">Pending With</th> 
					   <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue">Approval/Refusal Date</th> 
					   <th align="center" style="width:15%;border-bottom:3px solid green;" class="headngblue">Consent Order</th> 
					   
  	     </tr>
  	     <% if(allSummaryReportWMSList){ %>
  	     <g:each in="${allSummaryReportWMSList}" status="i" var="allSummaryReportInstance">
  	     
  	   <%
       
       def uploaded = WasteManagementCertificates.find("from WasteManagementCertificates afr where afr.applicationId=? and afr.applicationFor=? and afr.typeOfFile='uploaded' order by afr.id desc",[allSummaryReportInstance.applicationId.toLong(),allSummaryReportInstance.applicationFor])
       
         
         %>
  	     
  	     <tr width="100%" bgcolor="#A8DAF3" style="height:25px;pading-bottom:10px;margin-bottom:10px;">
  	                  <td align="center" > <%=i+1%> </td>
  	                  <td align="center" > <%=allSummaryReportInstance.applicationName%> </td>
  	                  <td align="center" > <%=allSummaryReportInstance.industryAddress%> </td>
					  <td align="center" > <%=allSummaryReportInstance.applicationId%> </td>
					  <td align="center" > <%=allSummaryReportInstance.applicationFor%> </td>
					  <td align="center" > <%=allSummaryReportInstance.districtName%> </td>
					  <td align="center" > <%=allSummaryReportInstance.groupName%> </td>
					  <td align="center" > <%=allSummaryReportInstance.categoryName%> </td>
					  <td align="center" > <g:formatDate format="dd-MM-yyyy" date="${allSummaryReportInstance.authDate}"/></td>
  	        <%
               if(allSummaryReportInstance.applicationStatus=='approved'){%>
                <td align="center" >Granted </td>
                <td align="center" ></td>
                <td align="center" ><g:formatDate format="dd-MM-yyyy" date="${allSummaryReportInstance.pendingSince}"/></td>
                <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>">
               	<%if(uploaded){  
                 %>	
                <g:link controller="userMaster" action="viewCertificateWaste"  id="${uploaded.id}" ><span class="innerlink">&nbsp;View Certificate&nbsp;</span></g:link>
                <%}%>          
               	</font></b>
               	</td>

            <% } 
               else if(allSummaryReportInstance.applicationStatus=='rejected'){%>
               <td align="center" >Rejected </td>
               <td align="center" ></td>
               <td align="center" ><g:formatDate format="dd-MM-yyyy" date="${allSummaryReportInstance.pendingSince}"/></td>
               <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>">
              	<%                          
              	
               if(uploaded){  
                %>	
                <g:link controller="userMaster" action="viewCertificateWaste"  id="${uploaded.id}" ><span class="innerlink">&nbsp;View Certificate&nbsp;</span></g:link>
               <%}%>          
              	</font></b>
              	</td>

           <% }else if(allSummaryReportInstance.applicationStatus=='returned'){%>
              
               <td align="center" >Return </td>
               <td align="center" >Industry</td>
               <td align="center" ></td>
               <%} else {%>
             
             <td align="center" >Pending</td>
             <td align="center" > <%=allSummaryReportInstance.roleName%></td>
             <td align="center" ></td>
             <%} %>
              <%
                if(allSummaryReportInstance.clarification && allSummaryReportInstance.applicationStatus=='pending') {
                 %>
                 <td align="center" >
                 <img src="${createLinkTo(dir:'images',file:'Clarification.gif')}" border="0" align="center" alt="ADD OFFICE" ></img>
               </td>
                 <%}%>
       </tr>
      </g:each>
      <%} 
       else if(applicationw){ 
       System.out.println("--application--"+applicationw)
      def appSumm=AllSummaryReportWMS.find("from AllSummaryReportWMS a where a.applicationId=?",[applicationw.id.toString()])
      def appPending=WasteManagementPendingDetails.find("from WasteManagementPendingDetails w where w.applicationId=?",[applicationw.id.toString()]) 
      def approvalDate=""
      def refusalDate=""
      System.out.println("--appPending--"+appPending.applicationStatus)
      if(appSumm){
      
      if(appSumm.applicationStatus=='approved'){
      approvalDate=appSumm.pendingSince
      }else if(appSumm.applicationStatus=='rejected'){
      approvalDate=appSumm.pendingSince
      }
      }
      %>
      
      					<td align="center" >1 </td>
  	                  <td align="center" >${applicationw.industryRegMasterObj.indName}</td>
					  <td align="center" >${applicationw.industryRegMasterObj.indAddress} </td>
					  <td align="center" > ${applicationw.id} </td>
					  <td align="center" >${applicationFor}  </td>
					  <td align="center" >${applicationw.industryRegMasterObj.district.districtName}  </td>
					  <td align="center" >${appSumm.groupName}  </td>
      					<td align="center" >${applicationw.industryRegMasterObj.category.name}  </td>
  	                  <td align="center" > ${applicationw.dateCreated} </td>
					  <td align="center" >${appPending.applicationStatus}  </td>
					  <td align="center" > ${appPending.role.roleName} ${appPending.role.group.groupName} </td>
					  <td align="center" >  ${approvalDate}  </td>
					  <td align="center" > 
					  
					  <% if(appPending.applicationStatus.equals("approved")) {  
						  def uploaded = WasteManagementCertificates.find("from WasteManagementCertificates afr where afr.applicationId=? and afr.applicationFor=? and afr.typeOfFile='uploaded' order by afr.id desc",[appPending.applicationId.toLong(),appPending.applicationFor])
					       
                if(uploaded){  
                 %>	
                <g:link controller="userMaster" action="viewCertificateWaste"  id="${uploaded.id}" ><span class="innerlink">&nbsp;View Certificate&nbsp;</span></g:link>
                <%}}%>     </td>
      <%} %>
  	</div>
			 </td>
           </tr>
           </table>
		   </td>
          </tr>
         </table>
		</td>
      </tr>
     </table>
	</td>
  </tr>
     
    </table></td>
  </tr>
   
</table>
<!-- code for spcb Footer -->
	  <g:include controller="userMaster" action="showSpcbFooter"/>
</body>
<HEAD> <g:javascript library='scriptaculous'/>
<g:javascript>

		window.onload = function()   
           	  {       
           	        
			   	  new Ajax.Autocompleter("autocomplete1","autocomplete_choices","<%=cont%>/groupMaster/ajaxAutoCompleteTest",{} );             
			 }
</g:javascript>
<script>
function myFunction(){

var searchOp=document.getElementById('searchOp').value

if(searchOp==null && searchOp==""){
alert("Please Select Search Type")
}
}
</script>

<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script></head>
</html>