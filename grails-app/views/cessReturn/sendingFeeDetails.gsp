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
<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />


<script type="text/javascript" src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>
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
<script>
    
    function checkField(id)
    {
        if (id.value == "" )
        {
    
            id.value = "0";
        }
                  
        document.getElementById("totalMoney").value = eval(document.getElementById("waterCessAssessmentOrderAmount").value)+ eval(document.getElementById("interestAssessmentOrderAmount").value)+eval(document.getElementById("penaltyAssessmentOrderAmount").value)+ eval(document.getElementById("otherMiscAssessmentOrderAmount").value);
        var x= document.getElementById("totalMoney").value
       document.getElementById("totalMoney").value = Math.round(x);
    }
             
    </script>
<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

<g:javascript library="prototype" />
<g:javascript>
function createRow(){

  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'tempDoEdit.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>

<% 

      String contex=request.getContextPath();

      if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {

                  response.sendRedirect(contex+"/index.gsp")  ;     

 } %>
</head>


<script type="text/javascript">
function test_skill() {

    var junkVal=document.getElementById('totalMoney').value;

    junkVal=Math.floor(junkVal);

    var obStr=new String(junkVal);

    numReversed=obStr.split("");

    actnumber=numReversed.reverse();

 

    if(Number(junkVal) >=0){

        //do nothing

    }

   else{

        alert('wrong Number cannot be converted');

        return false;

    }

    if(Number(junkVal)==0){

        document.getElementById('rupeesInWords').value='Rupees Zero Only';

        return false;

    }

    if(actnumber.length>9){

        alert('Oops!!!! the Number is too big to covertes');

        return false;

    }

 

    var iWords=["Zero", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"];

    var ePlace=['Ten', ' Eleven', ' Twelve', ' Thirteen', ' Fourteen', ' Fifteen', ' Sixteen', ' Seventeen', ' Eighteen', ' Nineteen'];

    var tensPlace=['dummy', ' Ten', ' Twenty', ' Thirty', ' Fourty', ' Fifty', ' Sixty', ' Seventy', ' Eighty', ' Ninety' ];

 

    var iWordsLength=numReversed.length;

    var totalWords="";

    var inWords=new Array();

    var finalWord="";

    j=0;

  for(i=0; i<iWordsLength; i++){

        switch(i)

        {

        case 0:

            if(actnumber[i]==0 || actnumber[i+1]==1 ) {

                inWords[j]='';

            }

            else {

                inWords[j]=iWords[actnumber[i]];

            }

            inWords[j]=inWords[j]+' Only';

            break;

        case 1:

            tens_complication();

            break;

        case 2:

            if(actnumber[i]==0) {

                inWords[j]='';

            }

            else if(actnumber[i-1]!=0 && actnumber[i-2]!=0) {

                inWords[j]=iWords[actnumber[i]]+' Hundred and';

            }

            else {

                inWords[j]=iWords[actnumber[i]]+' Hundred';

            }

            break;

        case 3:

            if(actnumber[i]==0 || actnumber[i+1]==1) {

                inWords[j]='';

            }

            else {

                inWords[j]=iWords[actnumber[i]];

            }

            if(actnumber[i+1] != 0 || actnumber[i] > 0){

                inWords[j]=inWords[j]+" Thousand";

            }

            break;

        case 4:

            tens_complication();

            break;

        case 5:

            if(actnumber[i]==0 || actnumber[i+1]==1 ) {

                inWords[j]='';

            }

            else {

                inWords[j]=iWords[actnumber[i]];

            }

            inWords[j]=inWords[j]+" Lakh";

            break;

        case 6:

            tens_complication();

          break;

        case 7:

            if(actnumber[i]==0 || actnumber[i+1]==1 ){

                inWords[j]='';

            }

            else {

                inWords[j]=iWords[actnumber[i]];

            }

            inWords[j]=inWords[j]+" Crore";

            break;

        case 8:

            tens_complication();

            break;

        default:

            break;

       }

        j++;

    }

 

    function tens_complication() {

        if(actnumber[i]==0) {

            inWords[j]='';

      }

     else if(actnumber[i]==1) {

            inWords[j]=ePlace[actnumber[i-1]];

        }

        else {

            inWords[j]=tensPlace[actnumber[i]];

        }

    }

    inWords.reverse();

    for(i=0; i<inWords.length; i++) {

        finalWord+=inWords[i];

    }

    document.getElementById('rupeesInWords').value=finalWord;

}

</script>




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
		
		<!-- Start of menuAdminHorizontal-->
		<% 
		if(  (IndUser)session.getAttribute("indUser")  ){ %>
            <g:include controller="userMaster" action="showIndustryMenuHorizontal"/>                                         
        <%} %>
     <% if((UserMaster)session.getAttribute("userMaster")){
			UserMaster aa = (UserMaster)session.getAttribute("userMaster");
			String userType = aa.accessLevel
				if(userType.equals("admin")) { %>   
					<g:include controller="userMaster" action="showAdminMenuHorizontal"/>                                      
			<% 	}else{ %>
					<g:include controller="userMaster" action="showSpcbUserMenuHorizontal"/> 
				<%}
		} %>
     <% if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {%>
			<g:include controller="userMaster" action="showIndexMenuHorizontal"/>        
	  <% } %>
	  <!-- END of menuAdminHorizontal-->
	  
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- Start of menuAdmin-->
			
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
			<!-- End of menuAdmin-->
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
					<table width="100%"> 
					<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						  <tr >
						 	<td class="top-lnks">Welcome <%=indname %></td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>
					<tr>
							<td >&nbsp;</td>
							
					</tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" class="middlespacer"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">

				                      <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${certificateRecordInstance}">
            <div class="errors">
                <g:renderErrors bean="${certificateRecordInstance}" as="list" />
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
    <g:form  name="myForm" action="generateFeeDetails" method="post" >
         <!-- <form  name="myForm" action="pdf" method="post" > --> 
        <!--  <form  name="myForm" action="#" method="post" > -->
          <input type="hidden" name="idIndReg" value="${industryReg?.id}" />
           <input type="hidden" name="idCessreturn" value="${cessReturnInstance?.id}" />
          
               
   
   				
         
         
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="left" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Generate Notice</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
	    </table>
          <div id="country1" >
  			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			 					 <% 
               def yr=((cessReturnInstance.cessAppliedFromDate).getYear()+1900).toString()
				def mon=((cessReturnInstance.cessAppliedFromDate).getMonth()+1).toString()
						
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
			
			String fromDate=mon+"/"+yr
               
                       
   			def yr1=((cessReturnInstance.cessAppliedToDate).getYear()+1900).toString()
			def mon1=((cessReturnInstance.cessAppliedToDate).getMonth()+1).toString()
							
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
			String toDate=mon1+"/"+yr1
                       
                        %>
			
			   <input type="hidden" name="fromDate" value="<%=fromDate%>" />
           <input type="hidden" name="toDate" value="<%=toDate%>" />
			  <input type="hidden" name="cessFromDate" value="${cessReturnInstance.cessAppliedFromDate}" />
           <input type="hidden" name="cessToDate" value="${cessReturnInstance.cessAppliedToDate}" />
        
			 
			 <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Industry Details:</div></td>
                        
                      </tr>
						<tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">District:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                         
                         ${fieldValue(bean:industryReg, field:'district')}
                        </span></td>
                      </tr>
                            <tr align="center" >
                              <td width="150px" bgcolor="#A8DAF3" align="right" valign="middle" class="headngblue"><div align="right" class="style3">Tehsil:</div></td>
                        <td bgcolor="#E8F6F9" ><div align="left"><span class="txt4">
    ${fieldValue(bean:industryReg, field:'tehsil')}                    
                       </span> </div></td>
                      </tr>
                      <tr >
                        <td  width="150px" bgcolor="#A8DAF3" class="headngblue"><div align="right" class="style3">Industry Name:</div></td>
                       <td bgcolor="#E8F6F9" ><div align="left"><span class="txt4">
                         ${fieldValue(bean:industryReg, field:'indName')}
                        </span></div></td>
                      </tr>
                      <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Address::</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                        
                        
                   ${fieldValue(bean:industryReg, field:'indAddress')}
                        </span></td>
                      </tr>
					  <tr bgcolor="#E8F6F9"><td colspan="2"><span class="style8"></span>
					  </td>
					  </tr>
					  
					  <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Notice details:</div></td>
                        
                      </tr>
					  
                      <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Letter Sent To:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                          
                          ${fieldValue(bean:industryReg, field:'occName')}
                        </span></td>
                      </tr>
					  <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Designation:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                         
                          ${fieldValue(bean:industryReg, field:'occDesignation')}
                        </span></td>
                      </tr>
					
					  <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Code No:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                         <input type="text" id="codeNumber" name="codeNumber" value="" class="txt4" />
                          
                        </span></td>
                      </tr>
					
					  <tr><td width="150px" bgcolor="#A8DAF3" class="headngblue"  ><div align="right" class="style3">Office District:</div></td> <td align="left" bgcolor="#E8F6F9"><input type="text" id="nameOfDistrict" name="nameOfDistrict"  class="txt4" /></td></tr>
					   <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Office Address:</div></td>
                        
                      </tr>
                     <tr  >
                        <td width="150px" class="headngblue" colspan="2" ><textarea rows="1" cols="70" name="offAddres"></textarea></td>
                     </tr>
                      <tr><td width="150px" bgcolor="#A8DAF3" class="headngblue"  > <div align="right" class="style3">Water Cess Pay in slip Date :</div></td><td align="left" bgcolor="#E8F6F9"><span class="txt style6">
                         <calendar:datePicker name="waterCessDate"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/></td></tr>
                      <tr><td width="150px" bgcolor="#A8DAF3" class="headngblue"  > <div align="right" class="style3">Cess Applied Period :</div></td><td align="left" bgcolor="#E8F6F9"><span class="txt4">
                       <input type="text" id="cessFromDate1" name="cessFromDate1" value="<%=fromDate%>" class="txt4" readonly /> <font size="1.5" color="red"> To  </font><input type="text" id="cessToDate1" name="cessToDate1" value="<%= toDate%>" class="txt4" readonly /></span>
                         </td></tr>
                        
					   
					<tr><td width="150px" bgcolor="#A8DAF3" class="headngblue"  ><div align="right" class="style3">Demand Draft No:</div></td> <td align="left" bgcolor="#E8F6F9"><input type="text" id="demandDraftNo" name="demandDraftNo"  class="txt4" /></td></tr>
        		<tr><td width="150px" bgcolor="#A8DAF3" class="headngblue"  ><div align="right" class="style3">Demand Draft in Rs.:</div></td> <td align="left" bgcolor="#E8F6F9"><input type="text" id="demandDraftRupees" name="demandDraftRupees"  class="txt4" /></td></tr>
        		<tr><td width="150px" bgcolor="#A8DAF3" class="headngblue"  > <div align="right" class="style3">Demand Draft Date :</div></td><td align="left" bgcolor="#E8F6F9"><span class="txt style6">
                         <calendar:datePicker name="draftChequeDate"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/></td></tr>
        </table>
        <div style="overflow:auto; height:285px; width:595px;">
        <table width="100%"  border="1" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
        	 <tr class="headngblue" bgcolor="#A8DAF3" align="center">
        		<td >S.No</td><td>Details</td><td><table><tr><td colspan="1" align="Left"><u>Assessment Order</u></td></tr><tr><td align="Left">No.</td><td align="Left">Date</td></tr></table></td><td><table width="100%" ><tr><td colspan="1"><u>Assesment Period</u></td></tr><tr><td align="Left">From</td><td align="Left">To</td></tr></table></td><td>Amount Rs.</td><td>Remark</td>
        	</tr>
        	<tr class="headngblue"><td>1.</td><td>Water Cess (U/s 6)</td><td><table><tr><td ><input type="text" id="waterCessAssessmentOrderNo" name="waterCessAssessmentOrderNo" style="width:60px;"></td><td> <calendar:datePicker name="waterCessAssessmentOrderDate"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/></td></tr></table></td><td><table><tr><td > <calendar:datePicker name="waterCessAssessmentOrderFrom"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/></td><td> <calendar:datePicker name="waterCessAssessmentOrderTo"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/></td></tr></table></td><td><input type="text" id="waterCessAssessmentOrderAmount" name="waterCessAssessmentOrderAmount" style="width:60px;" value="0" onclick="this.value=''"   onblur="checkField(this);test_skill()"  ></td><td><input type="text" id="waterCessAssessmentOrderRemarks" name="waterCessAssessmentOrderRemarks" style="width:60px;"></td></tr>
        	<tr class="headngblue"><td>2.</td><td>Interest (U/s 10)</td><td><table><tr><td ><input type="text" id="interestAssessmentOrderNo" name="interestAssessmentOrderNo" style="width:60px;"></td><td><calendar:datePicker name="interestAssessmentOrderDate"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/></td></tr></table></td><td><table><tr><td ><calendar:datePicker name="interestAssessmentOrderFrom"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/></td><td><calendar:datePicker name="interestAssessmentOrderTo"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/></td></tr></table></td><td><input type="text" id="interestAssessmentOrderAmount" name="interestAssessmentOrderAmount" style="width:60px;" value="0" onclick="this.value=''"   onblur="checkField(this);test_skill()"  ></td><td><input type="text" id="interestAssessmentOrderRemarks" name="interestAssessmentOrderRemarks" style="width:60px;"></td></tr>
        	<tr class="headngblue"><td>3.</td><td>Penalty (U/s 11)</td><td><table><tr><td ><input type="text" id="penaltyAssessmentOrderNo" name="penaltyAssessmentOrderNo" style="width:60px;"></td><td><calendar:datePicker name="penaltyAssessmentOrderDate"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/></td></tr></table></td><td><table><tr><td ><calendar:datePicker name="PenaltyAssessmentOrderFrom"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/></td><td><calendar:datePicker name="penaltyAssessmentOrderTo"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/></td></tr></table></td><td><input type="text" id="penaltyAssessmentOrderAmount" name="penaltyAssessmentOrderAmount" style="width:60px;" value="0" onclick="this.value=''"   onblur="checkField(this);test_skill()"  ></td><td><input type="text" id="penaltyAssessmentOrderRemarks" name="penaltyAssessmentOrderRemarks" style="width:60px;"></td></tr>
        	<tr class="headngblue"><td>4.</td><td>Other Misc-Payment</td><td><table><tr><td ><input type="text" id="otherMiscAssessmentOrderNo" name="otherMiscAssessmentOrderNo" style="width:60px;"></td><td><calendar:datePicker name="otherMiscAssessmentOrderDate"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/></td></tr></table></td><td><table><tr><td ><calendar:datePicker name="otherMiscAssessmentOrderFrom"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/></td><td><calendar:datePicker name="otherMiscAssessmentOrderTo"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/></td></tr></table></td><td><input type="text" id="otherMiscAssessmentOrderAmount" name="otherMiscAssessmentOrderAmount" style="width:60px;" value="0" onclick="this.value=''"   onblur="checkField(this);test_skill()"  ></td><td><input type="text" id="otherMiscAssessmentOrderRemarks" name="otherMiscAssessmentOrderRemarks" style="width:60px;"></td></tr>
       	</table>
       	</div>
        <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
        	<tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Total Amount:</div></td>
                        <td align="left" bgcolor="#E8F6F9"><span class="txt4">
                         <input type="text" id="totalMoney" name="totalMoney"  onblur="checkField(this)"  readonly value="0" class="txt4" />
                          
                        </span></td>
                      </tr>
                      <tr bgcolor="#D1D1D1" >
                        <td width="150px" class="headngblue" colspan="2" ><div align="left" class="style3">Rupees In Words:</div></td>
                        
                      </tr>
                     <tr>
                        <td width="150px" class="headngblue" colspan="2" ><font color="red"><input type="text" size="92" id="rupeesInWords" name="rupeesInWords" style="background:aliceblue;color:red" readonly></font></td>
                     </tr> 
        </table>
	   <table width="96%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td width="46%" align="right"><input type="submit"  value="Generate" class="actionbutton" ></td>
			
				<!-- onclick="window.open('../openCertificate', 'windowname1', 'width=810, height=650, scrollbars=1'); return false;" name="save" -->
					
		  </tr>
		</table>
  			</g:form>
  			
            <br />
            <br />
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
</table>

<script language="JavaScript" type="text/javascript">



 var frmvalidator  = new Validator("myForm");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  


    
 frmvalidator.addValidation("waterCessAssessmentOrderAmount","req","Please enter valid Water Cess Assessment Order Amount");
 frmvalidator.addValidation("interestAssessmentOrderAmount","req","Please enter valid Interest Amount");
 frmvalidator.addValidation("penaltyAssessmentOrderAmount","req","Please enter valid Penalty Amount");
 frmvalidator.addValidation("otherMiscAssessmentOrderAmount","req","Please enter valid Other Misc Amount");
 frmvalidator.addValidation("waterCessAssessmentOrderAmount","dec","Please enter numeric values in  Water Cess Assessment Order Amount");
 frmvalidator.addValidation("interestAssessmentOrderAmount","dec","Please enter only numeric values in Interest Amount");
 frmvalidator.addValidation("penaltyAssessmentOrderAmount","dec","Please enter only numeric values in Penalty Amount");
 frmvalidator.addValidation("otherMiscAssessmentOrderAmount","dec","Please enter only numeric values in Other Misc Amount");
 
 frmvalidator.addValidation("totalMoney","dec","Please enter only numeric values in Other Misc Amount");
 frmvalidator.addValidation("totalMoney","req","Please enter Total Amount");

 
 
</script>

</body>
<HEAD> 

<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 

<META HTTP-EQUIV="Expires" CONTENT="-1">

</HEAD>
</html>

