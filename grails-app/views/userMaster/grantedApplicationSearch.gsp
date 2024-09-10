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


<body AUTOCOMPLETE=OFF >
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
		
		
		
		
		<g:form action="grantApplicationSearch" name="myform" method="post" >
<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                               <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Search Granted Application</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432" align="right"></td>
							</tr>
	    </table>
		<table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
		               
		<tr>
		<td colspan="4" bgcolor="#A8DAF3" align="left"><input type=radio name=searchOp value="ApplId" <%if(paramList != null && (paramList.searchOp).equals("ApplId")){%>checked="checked"<%}%> ><span class="headngblue">By Application Id</span></td>
		
		</tr>
		
      <tr  >
        <td width="20%" class="headngblue"  bgcolor="#E8F6F9"   align="left" >Application Id:</td>
        <td align="left" colspan="3" bgcolor="#E8F6F9">
      
        <input type="text" class="txt4" id="autocomplete" size="30" name="autocomplete_parameter"/>
       
        <span class="txt4">(Enter application ID)</span></td>
		
      </tr>
      <tr align="center">
      

		<td colspan="4" bgcolor="#A8DAF3" align="left"><input type=radio  name=searchOp value=Others checked="checked"><span class="headngblue">By Other Criteria</span></td>
		</tr>
                 
                 <tr  bgcolor="#E8F6F9">
                              <td width="15%" align="left"  class="headngblue" >From Date :</td>
                        <td width="33%" align="left" >
					

						<calendar:datePicker name="start_date" dateFormat="%d/%m/%Y" defaultValue="${new Date()}" />
                   </td>
                      
                      
                      
                              <td  width="15%" align="left"  class="headngblue">To Date :</td>
                        <td width="33%" align="left"   >
					
							
							<calendar:datePicker name="end_date"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
							
                   </td>
  				</tr>
		      
		        <td width="30%" align="left"  class="headngblue" >Application Type:</td>
		                <td  align="left" class="headngblue">
                 
                  
            <select  name="applicationType">
				   <option value="None">None</option>
				
				  <option value="CTO">CTO</option>
				  <option value="CTE">CTE</option>
				  
				
		
				  
				 
				  
				
				</select>
            
                </td>    
                
                <td width="30%" align="left"  class="headngblue" >Application For:</td>
		                <td  align="left" class="headngblue">
                 
                  
            	
            	<select name="applicationForInd">
            	<option value="None">None</option>
				  <option value="both">Industry</option>
				  <option value="dgset">D.G.Set</option>
				  <option value="stonecrusher">Stone Crusher</option>
				  <option value="hotmixplants">Hot mix plants</option>
				  <option value="stonecrusher and hotmixplants">Stone Crusher and Hot mix plants</option>
				  <option value="brickkilns">Brick Kilns</option>
				  <option value="hotel">Hotel</option>
				
				</select>
            	<div style="display:none;" id ="div3">
            		
            	<select name="applicationForNone">
            	<option value="None">None</option>
				  
				</select>
            		</div>
            		
                 </td>
                
                </tr>
                
                </tr>
		            <tr  bgcolor="#E8F6F9">
		            <td width="30%" align="left"  class="headngblue" >Dealing Group:</td>
		                <td  align="left" class="headngblue">
                 
                       
           <g:select class="txt4" optionKey="id" from="${grp}"  name="group" noSelection="${['None':'None']}" ></g:select>
                       
            
                </td>
                
                
                 
            
               
                
                </tr>
                 
               
                
                

                </table>
                
		
		<table width="100%"  border="0" align="center" class="tblbdr">
		               
		 <tr>
                <td width="33%" align="center"><input type="submit" name="Search" value="Search" class="actionbutton"></td></tr>
		
		 </table>

  	</g:form>
  	<br />
  			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="white" class="tab-txt" style="border-collapse:collapse;">
 
 <% if(indList){%>
 <tr ><td align="right">
          <a
																href="popupex.html"
																onclick="return popitup('<g:createLink action="printConditionalPage1" params="[indList:indList]" ></g:createLink> ')"><span
																class="headngblue">Print in Excel</span></a> </td>
         </td> </tr>
          <%}%>
		  <tr>
		    <td bgcolor="#FFFFFF"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
        			<thead>
                        <tr height="20" bgcolor="#A8DAF3">
                        
                   	       
							<th class="headngblue" align="center">SI. No.</th>
							<th class="headngblue" align="center">Application No.</th>
							<th class="headngblue" align="center">Application Name</th>
							<th class="headngblue" align="center">Application Type</th>
							<th class="headngblue" align="center">District</th>
							<th class="headngblue" align="center">Application Date</th>
							<th align="center" class="headngblue" >Last Submission Date(Clarification)</th>
							<th class="headngblue" align="center">Granted Date</th>
						
							<th class="headngblue" align="center">Application For</th>
							<th class="headngblue" align="center">Certificate For</th>
						    <th class="headngblue" align="center">Consent Order</th>
							
							
                        </tr>
                    </thead>
                    <tbody>
                  
                   <%if(!indList){ %><tr><td colspan="10" height="25" align="center" class="txt4"></td></tr><%} 
                   else{
                    
                   %>
              
                    
                    <g:each in="${indList}" status="i" var="aa">
                    <% 
                    def indAppInst = IndApplicationDetails.get(aa.applicationId.toLong())
                    def viewHWMUploaded =ApplicationFileRecord.find("from ApplicationFileRecord afd where afd.indApplication=? and afd.typeOfFile='ConsentHWMOrder'",[indAppInst])

                    SimpleDateFormat sdfDestination = new SimpleDateFormat("dd/MM/yyyy");

                     String strDate = sdfDestination.format(aa.applicationRecieptDate);
                     String straDate = sdfDestination.format(aa.pendingSince);
                     String consentFor = aa.certificateFor
                     
                     if(consentFor.equals("new")){
                     consentFor="Fresh"
                     }
                     if(consentFor.equals("Modern")){
                     consentFor = "Modernization "
                     }
                     if(consentFor.equals("expan")){
                     consentFor = "Expansion"
                     }
                     if(consentFor.equals("reNew")){
                      consentFor = "Renew"
                     }
                     String applicationFor = aa.applicationFor
                     if(applicationFor.equals("brickkilns")){
                         applicationFor="Brick Kilns"
                         }
                         if(applicationFor.equals("both")){
                         applicationFor = "Industry "
                         }
                         if(applicationFor.equals("stonecrusher")){
                         applicationFor = "Stone Crusher"
                         }
                         if(applicationFor.equals("hotmixplants")){
                             applicationFor = "Hot mix plants"
                             }
                         if(applicationFor.equals("stonecrusher and hotmixplants")){
                             applicationFor = "Stone Crusher and Hot mix plants"
                             }
                         if(applicationFor.equals("hotel")){
                          applicationFor = "Hotel"
                         }
                          if(applicationFor.equals("dgset")){
                          applicationFor = "DGSet"
                         }
                         
                     
                     String classToPick="#CD5B45";
                    %>

                    
                    
                    <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                    	<td height="25" align="center" class="txt4"><b>${i+1}.</b></td>
                    	
                          <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=aa.applicationId%></a></font></b></td>
                          <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=aa.applicationName%></font></b></td>
                       	  <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=aa.applicationType%></font></b></td>
                     	  <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=aa.districtName%></font></b></td>
                          <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=strDate%></font></b></td>
                       	  <td align="center" height="25" class="txt4"  ><b><font face="Verdana" color="<%=classToPick%>"><%=aa.lastClarificationDate%></font></b></td>
                       	  <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=straDate%></font></b></td>
                       	  <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=applicationFor%></font></b></td>
                       	  <td height="25" align="center" class="txt4"><b><font face="Verdana" color="<%=classToPick%>"><%=consentFor%></font></b></td>
                       	
                
                       	 <td height="25" align="center" class="txt4">
                       	 <b>
                       	 <font face="Verdana" color="<%=classToPick%>" size="2">
                       	 <a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/openCerificate12/${aa.applicationId}', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View Consent Certificate&nbsp;</span></a>
                       	 <%if(indAppInst.hazardeousType=="HWM" && viewHWMUploaded){%>
                       	 |<a href="#" onclick="window.open('<%=request.getContextPath()%>/applicationProcessingDetails/openCerificate13/${aa.applicationId}', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View Authorization Certificate&nbsp;</span></a>
                       	<%}%>

                       	</font>
                       	</b>
                       	</td>
              
                
                   
                    </tr>
                </g:each>
                <%}%>
                    </tbody>
      </table>
  	
  			</div>
	   
            <br />
            <br />

	  
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
      </div></td>
                         
                          </tr>
                      </table></td>
                    </tr>
                    
                </table></td>
              </tr>
              
            </table></td>
          </tr>
        </table></td>
      </tr>
      
	 </table></td>
  </tr>
  <g:include controller="userMaster" action="showSpcbFooter"/>
  <!-- code for spcb Footer -->
</table>

</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script></head>
</html>