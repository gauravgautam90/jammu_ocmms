<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>




<script type="text/javascript">



</script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Inspection Forward Criteria Admin Home</title>


<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
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
  <script type="text/javascript" src="${createLinkTo(dir:'js',file:'back.js')}"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
      <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
     
	  <script>
		function hitAjaxCall(e){
		var url = 'ajaxGetOfficerListByGroup?id='+e.value; 
		if(e != null ){
		   $.ajax({
			url : url,
			type : 'GET',
		    dataType : 'json',
		    crossDomain : true,
			//success : function(data, status, xhr){
				success: function(result){
				 if(result != null){
					console.log("data 11 >> "+result );
					updateOfficerList(result);
					
				}else{
					alert("Result not found from server plese refresh your page and then try !! ");
				}
			}
		});
			   }
			}
	  
	  
	  </script>
	  
	  <script>
         function updateOfficerList(result){
         //	console.log("e >> "+result);
         
         if (result != null ) {
         var rselect = document.getElementById('forwardTo')
         
         // Clear all previous options
         var l = rselect.length
         
         while (l > 0) {
         l--
         rselect.remove(l)
         }
         
		 var opt = document.createElement('option');
         opt.text = 'Not Selected'
		opt.value = 'xyz'
		rselect.add(opt)
					
		 
         // Rebuild the select
         for (var i=0; i < result.length; i++) {
         var tehsil = result[i]
         var opt = document.createElement('option');
         opt.text = tehsil
         opt.value = tehsil[0]
         try {
         rselect.add(opt, null) // standards compliant; doesn't work in IE
         }
         catch(ex) {
         rselect.add(opt) // IE only
         }
         }
         }
         
         
         }
      </script>

<script>
    function fetchIndustryTypeList(e){
      var categoryName = $('#categoryType').val();
     console.log("categoryName : "+categoryName + e);
    	var url = 'ajaxGetIndustryTypeList?categoryName='+categoryName; 
		if(e != null ){
		   $.ajax({
			url : url,
			type : 'GET',
		    dataType : 'json',
		    crossDomain : true,
			//success : function(data, status, xhr){
				success: function(result){
				 if(result != null){
					console.log("data 11 >> "+result );
					updateIndustryTypeDiv(result);
					
				}else{
					alert("Result not found from server plese refresh your page and then try !! ");
				}
			}
		});
	  }
   }

  function updateIndustryTypeDiv(result){
         if (result != null ) {
           var html ='';
           for(i=0;i<result.length;i++){
              html += "<input type='checkbox' name='industryType' id='industryType' value='"+result[i].id+"' >"+result[i].industryType +" <br>";
           }
           $('#industryTypeSection').html(html);
         }
  }

</script>


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
	
	
 frmvalidator.addValidation("applicationType","req","Please choose application type");
 frmvalidator.addValidation("categoryType","req","Please choose category");
 frmvalidator.addValidation("moduleType","req","Please choose module type");
 frmvalidator.addValidation("forwardTo","req","Please choose forword to");
	
	function checkForm(){
	    var applicationType = document.getElementById('applicationType').value;
		var categoryType = document.getElementById('categoryType').value;
		var moduleType = document.getElementById('moduleType').value;
		var forwardTo = document.getElementById('forwardTo').value;
	if(applicationType == null || applicationType == 'None' ){
		alert("Please choose application type");
		return false;
	}if(categoryType == null || categoryType == 'None' ){
		alert("Please choose category type");
		return false;
	}if(moduleType == null || moduleType == 'None' ){
		alert("Please choose module type");
		return false;
	}if(forwardTo == null || forwardTo == 'xyz' ){
		alert("Please choose Forward To ");
		return false;
	}
	return true;
	
	}
	
</script>
<% 

      String contex=request.getContextPath()

      if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {

                  response.sendRedirect(contex+"/index.gsp")  ;     

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

                                                      <g:include controller="userMaster" action="showSpcbIndustryMenu"/>                                         

                                                <%} %>

                                                                  

                                                <% 

                                                if((UserMaster)session.getAttribute("userMaster")){

                                                      UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                                      String userType = aa.accessLevel

                                                      if(userType.equals("admin")) { %>   

                                                            <g:include controller="userMaster" action="showAdminMenu"/>                                          

                                                      <% }else{ %>

                                                            <g:include controller="userMaster" action="showSpcbUserMenu"/> 

                                                      <%}} %>

                                                                  

                                                <% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {%>

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
  <%
              UserMaster um=(UserMaster)session.getAttribute("userMaster");
              UserProfile aa=(UserProfile)session.getAttribute("userprof");
              String firstname=aa.employeeFirstName;
              String lastName=aa.employeeLastName;
              String access=um.accessLevel;
              java.util.Date dateSCR = new java.util.Date();
             	int  year=dateSCR.getYear();
             	 if (year < 1000)
                     year+=1900;
               	int date=dateSCR.getDate();
                int month=(dateSCR.getMonth()) + 1;
               

              %>
              <tr>
                <td height="24" bgcolor="#EEEEF3">
					<table width="100%"> 
<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr><tr>
							
				<td width="100%" align="left">
					<g:link controller="inspectionManagement" action="viewInspectionForwardCriteria" ><span class="innerlink">&nbsp;View/Delete&nbsp;|</span></g:link> 
							
							</td>
							
							
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
            <g:hasErrors bean="${roleMasterInstance}">
            <div class="errors">
                <g:renderErrors bean="${inspectionForwardCriteriaInstance}" as="list" />
            </div>
            </g:hasErrors>  
             <g:hasErrors bean="${inspectionForwardCriteriaInstance}">
            <div class="errors">
                <g:renderErrors bean="${inspectionForwardCriteriaInstance}" as="list" />
            </div>
            </g:hasErrors>    

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
         <g:form action="saveInspectionForwardCriteria" name="myform" method="post" >
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Inspection Forward Criteria</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432" align="right"></td>
							</tr>
	    </table>
          <div id="country1" >
  			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
						
						<tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Application Type:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt style6">
                          <select name="applicationType" id="applicationType" >
						  <option value="None">Not Selected</option>
							<option value="CTE">CTE</option>
							<option value="CTO">CTO</option>
						</select>	
                        <span class="txt4">(select application type)</span></span></td>
                      </tr>
						
						
						<tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Category:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt style6">
						 <select name="categoryType" id="categoryType" onchange="fetchIndustryTypeList(this);">
							<option value="None">Not Selected</option>
							<option value="RED">RED </option>
							<option value="GREEN">GREEN</option>
							<option value="ORANGE">ORANGE</option>
						</select>	

						<span class="txt4">(select industry category)</span>
						</span></td>
                      </tr>
                            <tr align="center" >
                              <td width="150px" bgcolor="#A8DAF3" align="right" valign="middle" class="headngblue"><div align="right" class="style3">Module Type:</div></td>
                        <td bgcolor="#E8F6F9" ><div align="left">
                          <select name="moduleType" id="moduleType" >
						  <option value="None">Not Selected</option>
							<option value="CONSENT">CONSENT </option>
						</select>	
                        <span class="txt4">(select module type)</span></div></td>
                      </tr>
                    
                    <tr >
                        <td  width="150px" bgcolor="#A8DAF3" class="headngblue"><div align="right" class="style3">Choose Group :</div></td>
                       <td bgcolor="#E8F6F9" ><div align="left">
                			<g:select class="txt4" optionKey="id" from="${grp}" name="group" noSelection="${['xyz':'Not Selected']}" 
												onchange="hitAjaxCall(this);"   ></g:select>
                          </tr>
                    
                      <tr >
                        <td  width="150px" bgcolor="#A8DAF3" class="headngblue"><div align="right" class="style3">Forward To Officer:</div></td>
                       <td bgcolor="#E8F6F9" ><div align="left">
					       <g:select optionKey="id" optionValue="name" name="forwardTo" noSelection="${['xyz':'Not Selected']}"  id="forwardTo"  value="" > </g:select>
					   
                         <!--<select name="forwardTo" id="forwardTo" >
						 <option value="None">Not Selected</option>
							<option value="MS">MS </option>
							<option value="Other">Other </option>
						</select> -->
                        <span class="txt4"><br>(select officer whome you want to forward this type of application.)</span></div></td>
                      </tr>
                      
                      
                      
                      <tr >
                        <td  width="150px" bgcolor="#A8DAF3" class="headngblue"><div align="right" class="style3">Role Type:</div></td>
                       <td bgcolor="#E8F6F9" ><div align="left">
					       <select name="forwardRoleType" id="forwardRoleType" >
						 	 <option value="MS">MS </option>
							 <option value="Other">Other </option>
						</select>
                        <span class="txt4"><br>(Role Type.)</span></div></td>
                      </tr>
                      
                      <tr>
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue"><div align="right" class="style3">Choose Industry Type:</div></td>
                        <td bgcolor="#E8F6F9" > 
                        	<div id="industryTypeSection" style="height:150px;overflow:auto;" ></div> 
                        </td>
                      
                      </tr>
                      
                      <tr>
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue"><div align="right" class="style3">Capital Investment (In Lakhs Only) :</div></td>
                        <td bgcolor="#E8F6F9" > <input type="text" name="capitalInvestment" id="capitalInvestment" /> 
                        </td>
                      
                      </tr>
                      
                      
                      
<!--					  
                    <tr>
					<td  align="right" valign="middle" bgcolor="#A8DAF3" class="headngblue">No of RO officer:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
						<select name="noOfRoOfficer" id="noOfRoOfficer" >
							<option value="0">0 </option>
							<option value="1">1 </option>
							<option value="2">2 </option>
							<option value="3">3 </option>
							<option value="4">4 </option>
							<option value="5">5 </option>
						</select>
			     	<span class="txt4">(choose no of RO officers)</span></span></td>
				    </tr>
                    
                      <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">No of HO Officer:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt style6">
                          <select name="noOfHoOfficer" id="noOfHoOfficer" >
							<option value="0">0 </option>
							<option value="1">1 </option>
							<option value="2">2 </option>
							<option value="3">3 </option>
							<option value="4">4 </option>
							<option value="5">5 </option>
						</select>
                        
                    <span class="txt4">(choose no of HO officers)</span></span></td>
                      </tr>
					  -->
					  
					  
                     
	  </table>
	   <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="right"><input type="submit" name="save" value="Save"  onclick="return checkForm();"  class="actionbutton" ></td>
			<td align="left">
			<!-- <input type="reset" name="save" value="Reset" class="actionbutton"> --> 
			&nbsp;
			</td>
			
		  </tr>
		</table>
 			
            <br />
            <br />
          </div>
          </div>
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
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
    </table></td>
  </tr>
</table></g:form>

<script language="JavaScript" type="text/javascript">



 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
 
 frmvalidator.addValidation("applicationType","req","Please choose application type");
 frmvalidator.addValidation("categoryType","req","Please choose category");
 frmvalidator.addValidation("moduleType","req","Please choose module type");
 frmvalidator.addValidation("forwardTo","req","Please choose forword to");
 //frmvalidator.addValidation("roleName","alnum_s","Enter valid rolename");
// frmvalidator.addValidation("roleDesc","alnum_s","enter valid description");
 
 

 
 
</script>
</body>
<HEAD> 

<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 

<META HTTP-EQUIV="Expires" CONTENT="-1">

</HEAD>
</html>

