<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB Admin Home</title>


<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<g:javascript library="prototype" />
<g:javascript library='scriptaculous'/>

<script language="javascript" type="text/javascript">

function popitup(url) {
	newwindow=window.open(url,'name','height=200px,width=500px');
	if (window.focus) {newwindow.focus()
	}
	return false;
}

</script>

<script language="javascript" type="text/javascript">
function check_start_end()
{
	

 	var checkOne=true;
	 <g:if test="${sourceMaster}"> 
	 	<g:each in="${sourceMaster}" status="i" var="sourceMaster">
	 	
	 	var checkN= document.getElementById("<%=sourceMaster.source %>");

		if(checkN.checked){
			
			if(!document.getElementById("startReading_<%=sourceMaster.source %>").disabled) {
					var star=document.getElementById("startReading_<%=sourceMaster.source %>").value * 100;	
					var endd=document.getElementById("endReading_<%=sourceMaster.source %>").value * 100;		
					
			     	if(star > endd ){
  			      		alert("Start Reading should be less than end reading in <%=sourceMaster.source %> .");
  			      		checkOne=false;
  			      		
  			      	}
				}	
			 
		}else{

			
		}
		
	 	 </g:each>
			  </g:if>
			  if(checkOne == true){
				 
			return true;
			  }
			  else
			  {
				 
				  return false;
			  }
}
</script>

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

<g:javascript library="prototype" />
<g:javascript>
function createRow(){


  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'templateCess.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>





<script type="text/javascript">
function enablingDisabling(id)
{
	<% List sourceMaster11=CessSourceConsumptionMaster.list(); %>
	<g:if test="${sourceMaster}"> 
    
		<g:each in="${sourceMaster}" status="i" var="sourceMaster">


		var a= document.getElementById(id);

if(a.checked){


	(document.getElementById("meterWorking_"+id)).disabled = false;
	(document.getElementById("startReading_"+id)).disabled = false;
	(document.getElementById("endReading_"+id)).disabled = false;
	(document.getElementById("quantity_"+id)).disabled = false;
	(document.getElementById("threeMonthQuantity_"+id)).disabled = true;
	(document.getElementById("rebateQuantity_"+id)).disabled = false;


}else{
	(document.getElementById("meterWorking_"+id)).disabled = true;
	(document.getElementById("startReading_"+id)).disabled = true;
	(document.getElementById("endReading_"+id)).disabled = true;
	(document.getElementById("quantity_"+id)).disabled = true;
	(document.getElementById("threeMonthQuantity_"+id)).disabled = true;
	(document.getElementById("rebateQuantity_"+id)).disabled = true;

}

</g:each></g:if>
}

</script>


<script type="text/javascript">

function block_disable(id1)
{
	
		var str=id1;
		var abcd=str.replace("meterWorking_","");
		
		var check= document.getElementById(id1);
		
	if(check.value=="yes"){
	
		
		document.getElementById("threeMonthQuantity_"+abcd).value=0;
		
		(document.getElementById("startReading_"+abcd)).disabled = false;
		(document.getElementById("endReading_"+abcd)).disabled = false;
		document.getElementById("startReading_"+abcd).readOnly=false;
		document.getElementById("endReading_"+abcd).readOnly=false;
		document.getElementById("threeMonthQuantity_"+abcd).readOnly=true;
		//(document.getElementById("threeMonthQuantity_"+abcd)).disabled = true;
	}else{
		
		document.getElementById("startReading_"+abcd).value=0;
		document.getElementById("endReading_"+abcd).value=0;
		document.getElementById("startReading_"+abcd).readOnly=true;
		document.getElementById("endReading_"+abcd).readOnly=true;
		//(document.getElementById("startReading_"+abcd)).disabled = true;
		//(document.getElementById("endReading_"+abcd)).disabled = true;
		(document.getElementById("threeMonthQuantity_"+abcd)).disabled = false;
	}
}
		

</script>


<%
String cont=request.getContextPath();
 if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
response.sendRedirect(cont+"/index.gsp")  ;     
} %>

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
		<!-- code for menuAdminHorizontal-->
		<% 
		if(  (IndUser)session.getAttribute("indUser")  ){ %>
	    <g:include controller="userMaster" action="showIndustryMenuHorizontal"/>                                         
		<%} %>
        <% 
 		if((UserMaster)session.getAttribute("userMaster")){
 		UserMaster aa = (UserMaster)session.getAttribute("userMaster");
		String userType = aa.accessLevel
		if(userType.equals("admin")) { %>   

	    <g:include controller="userMaster" action="showAdminMenuHorizontal"/>                                      

        <% }else{ %>
		<g:include controller="userMaster" action="showSpcbUserMenuHorizontal"/> 
		<%}} %>
		<% if( (!(IndUser)session.getAttribute("indUser") ) && 
		(! (UserMaster)session.getAttribute("userMaster") )  )   {%>
		<g:include controller="userMaster" action="showIndexMenuHorizontal"/>        
		<% } %>
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuAdmin-->
				 
					<%
			if(  (IndUser)session.getAttribute("indUser")  )
			{ %>
				<g:include controller="userMaster" action="cessIndustryMenuVertical"/>                                         
          <%} %>
          <%if((UserMaster)session.getAttribute("userMaster")){
				UserMaster aa = (UserMaster)session.getAttribute("userMaster");
				String userType = aa.accessLevel
					if(userType.equals("admin")) { %>   
					<g:include controller="userMaster" action="cessAdminMenuVertical"/>                                          
				<% 	}else{ %>
					<g:include controller="userMaster" action="cessEmpMenuVertical"/> 
				<%	}
			} %>
         <% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster")))  {%>
               <g:include controller="userMaster" action="showIndexMenu"/>            
         <% } %>
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
					<table width="100%"> <tr>
							
					<td  align="left">
					<!-- <g:link controller="userProfile" action="list1" ><span class="innerlink">&nbsp;Update&nbsp;|</span></g:link>  -->		
					</td>
							
							
					   </tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
					
					<!-- Div area for errors-->
                      
					  <td align="center" valign="top"><div style="width:400px;  vertical-align:middle">
					  <span class="error">
						<g:if test="${flash.message}">
						<div class="message">${flash.message}</div>
						</g:if>
						<g:hasErrors bean="${userProfileInstance}">
						<div class="errors">
						<g:renderErrors bean="${userProfileInstance}" as="list" />
						</div>
						<div class="errors">
						<g:renderErrors bean="${userMasterInstance}" as="list" />
						</div>
						</g:hasErrors>

                      </span></div></td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top" class="middlespacer"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
			<br/>
       
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		
		
		<g:form name="myform"  controller="cessReturn">
		<input type="hidden" name="indRegId" value="${indRegInstance?.id}" />		
		<input type="hidden" name="cessInstanceId" value="${cessInstance?.id}" />
	<!-- <form action="save" method="post" name="myform" > -->	
		
		
		
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="10"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="110" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Cess Return</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="489" align="right"></td>
							</tr>
	    </table>
		<table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr"  >	
	  	<tr bgcolor="#A8DAF3" >
					<td  align="left" colspan="2" valign="middle"  class="headngblue">Purpose of which Water Consumed  </td>
					<td  align="left" colspan="5" valign="middle"  class="txt"><g:select name="purpose" optionValue="purpose" from="${CessWaterConsumptionPurposeMaster.list()}" class="txt4" /></td>
			</tr>
		 <tr width="100%" >
	<td width="25%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Source of Consumption </td>
	<td width="8%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" >Meter Reading </td>
	<td width="11%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" >Start Reading </td>
	<td width="14%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" >End Reading</td>
	<td width="14%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" >Quantity (KL) </td>
	<td width="14%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" > Water Qty (3 Month Avg.)</td>
	<td width="14%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue" >Quantity of water qualifying for rebate </td>
			</tr>
	<tr>
 	 <g:if test="${sourceMaster}"> 
    <tbody>
		<g:each in="${sourceMaster}" status="i" var="sourceMaster">
		
		<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
		<tr>
			<td class="txt"><input type="checkbox" name="<%=sourceMaster.source %>" id="<%=sourceMaster.source %>" onclick="enablingDisabling(this.id);"/>${fieldValue(bean:sourceMaster,field:'source')}</td>
			<td  align="left" valign="middle"  class="headngblue"><div >
			<select name="meterWorking_<%=sourceMaster.source %>" id="meterWorking_<%=sourceMaster.source %>" onchange="block_disable(this.id);" disabled>
					
  						<option value="yes">Yes</option>
  						<option value="no">No</option>
  						
					</select>
                    </div></td>
			<td  align="center" valign="middle"  class="txt4"><div><input name="startReading_<%=sourceMaster.source %>" id="startReading_<%=sourceMaster.source %>" type="text" class="txt4" size="8" maxlength="10" disabled/> </div></td>
            <td  align="center" valign="middle"  class="txt4"><div ><input name="endReading_<%=sourceMaster.source %>" id="endReading_<%=sourceMaster.source %>" type="text" class="txt4"  size="8" maxlength="10" disabled/> </div></td>
            <td  align="center" valign="middle"  class=" txt4"><div ><input name="quantity_<%=sourceMaster.source %>" id="quantity_<%=sourceMaster.source %>" type="text" class="txt4" size="8" maxlength="10" disabled/></div></td>
            <td  align="center" valign="middle"  class=" txt4"><div ><input name="threeMonthQuantity_<%=sourceMaster.source %>" id="threeMonthQuantity_<%=sourceMaster.source %>" type="text" class="txt4" size="8" maxlength="10" disabled/></div></td>
            <td  align="center" valign="middle"  class=" txt4"><div ><input name="rebateQuantity_<%=sourceMaster.source %>"  id="rebateQuantity_<%=sourceMaster.source %>" type="text" class="txt4"  size="8" maxlength="10" disabled/></div></td>
		</tr>
						</g:each>
						</tbody>
					
				</g:if>
  </tr>
 
   
      <tr>
                    <td height="20"align="center" valign="middle"   class="headngblue">
                    	<div align="left">Remarks, if any:</div>
                    	<div align="left"><span class="headngblue txt"></span></div></td>
                    <td height="20" colspan="6"align="center" valign="middle"   class="headngblue">
                    	<div align="left">
                        <textarea name="remarks" class="txt4" cols="60" ></textarea>
                    	</div></td>
     </tr>
     
     
     
  </table>
		 <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr"  >	
               
               <tr>
				<td align="center" class="txt4">Do You Want To Save The Application as <input name="appStatus" type="radio" value="completed" />  <span class="style3">Completed</span> &nbsp;<input name="appStatus" type="radio" value="Pending" checked="checked"/>  <span class="style3">In Progress</span>
                </td>
				</tr>
			<tr>
				<td>&nbsp;</td></tr>
               <tr>
               
			<td align="center" colspan="7">
			<g:actionSubmit class="actionbutton" value="Save" action="singleSavePurpose" onclick="return check_validation_page(), check_start_end();" /> 

			<g:actionSubmit class="actionbutton" value="Add More" action="savePurpose"  onclick="return check_validation_page(), check_start_end();" /> 
			
			</td>			
		  </tr>
  </table>
		
	</table>	
  			
            <br />
            <br />
          
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
          
	  

      </div></td>
                            <td width="132" align="left" valign="top">&nbsp;</td>
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
    </table>
    </g:form>
<script language="JavaScript" type="text/javascript">

function check_validation_page()
{
  var frmvalidator  = new Validator("myform");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.clearAllValidations();
  

  <g:if test="${sourceMaster}"> 
 	<g:each in="${sourceMaster}" status="i" var="sourceMaster">
 	
 	var checkN= document.getElementById("<%=sourceMaster.source %>");

	

	if(checkN.checked){

		if(!document.getElementById("startReading_<%=sourceMaster.source %>").disabled) 
		{
			frmvalidator.addValidation("startReading_<%=sourceMaster.source %>","req","Please enter Start Reading for <%=sourceMaster.source %>");
		  frmvalidator.addValidation("startReading_<%=sourceMaster.source %>","numeric","Start Reading for <%=sourceMaster.source %> should be numeric");
		}	
		if(!document.getElementById("endReading_<%=sourceMaster.source %>").disabled) 
		{
		  frmvalidator.addValidation("endReading_<%=sourceMaster.source %>","req","Please enter End Reading for <%=sourceMaster.source %>");
		  frmvalidator.addValidation("endReading_<%=sourceMaster.source %>","numeric","End Reading for <%=sourceMaster.source %> should be numeric");
		}
		
		  frmvalidator.addValidation("quantity_<%=sourceMaster.source %>","req","Please enter Quantity <%=sourceMaster.source %>");
		  frmvalidator.addValidation("quantity_<%=sourceMaster.source %>","numeric","Quantity <%=sourceMaster.source %> should be numeric");

		  if(!document.getElementById("threeMonthQuantity_<%=sourceMaster.source %>").disabled) 
			{
		  frmvalidator.addValidation("threeMonthQuantity_<%=sourceMaster.source %>","req","Please enter Water Qty (3 Month Avg.) for <%=sourceMaster.source %>");
		  frmvalidator.addValidation("threeMonthQuantity_<%=sourceMaster.source %>","numeric","Water Qty (3 Month Avg.) for <%=sourceMaster.source %> should be numeric");
			}
		  frmvalidator.addValidation("rebateQuantity_<%=sourceMaster.source %>","req","Please enter Quantity of water for rebate for <%=sourceMaster.source %>");
		  frmvalidator.addValidation("rebateQuantity_<%=sourceMaster.source %>","numeric","Quantity of water for rebate for <%=sourceMaster.source %> should be numeric");
		  
	}else{

		
	}
	
 	 </g:each>
		  </g:if>
		  return true;
}
  </script> 
  </body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD> 
  </html>		