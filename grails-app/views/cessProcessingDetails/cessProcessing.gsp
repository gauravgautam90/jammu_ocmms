<%@ page import="java.text.SimpleDateFormat"%>
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
<style type="text/css">
	<!--
	#assessOrderLink{
	    display: none;
	}
	#assessFeeNoticeLink{
	    display: none;
	}
	#assessIssueLink {
	    display: none;
	}
	-->
	</style>

<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>
<% 

      String contex=request.getContextPath();

      if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {

                  response.sendRedirect(contex+"/index.gsp")  ;     

 } %>
<script type="text/javascript">
function enablingDisabling(id){



	
		var a= document.getElementById(id).value;
		if(a=="yes"){
			if(document.getElementById("assessmentOrderRadio")){
			document.getElementById("assessmentOrderRadio").disabled=true;
			document.getElementById("assessmentOrderRadio1").disabled=true;
			document.getElementById("assessmentOrderNote").readOnly=true;
			}
			if(document.getElementById("feeDefaulterNoticeRadio")){
			document.getElementById("feeDefaulterNoticeRadio").disabled=true;
			document.getElementById("feeDefaulterNoticeRadio1").disabled=true;
			document.getElementById("feedefaulterNote").readOnly=true;
			}
			if(document.getElementById("inspection")){
				document.getElementById("inspection").disabled=true;
				document.getElementById("inspection1").disabled=true;
				document.getElementById("inspectionNote").readOnly=true;
				document.getElementById("fileInspection").disabled=true;
				}
			if(document.getElementById("applicationCompleted")){
				document.getElementById("applicationCompleted").disabled=true;
				document.getElementById("applicationCompleted1").disabled=true;
				document.getElementById("applicationCompletedNote").readOnly=true;
				
				}
			if(document.getElementById("inspectionClose")){
				document.getElementById("inspectionClose").disabled=true;
				document.getElementById("inspectionClose1").disabled=true;
				document.getElementById("inspectionCloseNote").readOnly=true;
				document.getElementById("inspectionReport").disabled=true;
				}
			}
		if(a=="no"){
			if(document.getElementById("assessmentOrderRadio")){
			document.getElementById("assessmentOrderRadio").disabled=false;
			document.getElementById("assessmentOrderRadio1").disabled=false;
			document.getElementById("assessmentOrderNote").readOnly=false;
			}
			if(document.getElementById("feeDefaulterNoticeRadio")){
			document.getElementById("feeDefaulterNoticeRadio").disabled=false;
			document.getElementById("feeDefaulterNoticeRadio1").disabled=false;
			document.getElementById("feedefaulterNote").readOnly=false;
			}
			if(document.getElementById("inspection")){
				document.getElementById("inspection").disabled=false;
				document.getElementById("inspection1").disabled=false;
				document.getElementById("inspectionNote").readOnly=false;
				document.getElementById("fileInspection").disabled=false;
				}
			if(document.getElementById("applicationCompleted")){
				document.getElementById("applicationCompleted").disabled=false;
				document.getElementById("applicationCompleted1").disabled=false;
				document.getElementById("applicationCompletedNote").readOnly=false;
				
				}
			if(document.getElementById("inspectionClose")){
				document.getElementById("inspectionClose").disabled=false;
				document.getElementById("inspectionClose1").disabled=false;
				document.getElementById("inspectionCloseNote").readOnly=false;
				document.getElementById("inspectionReport").disabled=false;
				}
			}
		
				
}

function enablingDisablingOrder(id){
	


		
			var a= document.getElementById(id).value;
			if(a=="yes"){
				if(document.getElementById("assessmentIssue")){
				document.getElementById("assessmentIssue").disabled=true;
				document.getElementById("assessmentIssue1").disabled=true;
				document.getElementById("assessmentIssueNote").readOnly=true;
				document.getElementById("assessmentIssueLink").disabled=true;
				}
				if(document.getElementById("feeDefaulterNoticeRadio")){
				document.getElementById("feeDefaulterNoticeRadio").disabled=true;
				document.getElementById("feeDefaulterNoticeRadio1").disabled=true;
				document.getElementById("feedefaulterNote").readOnly=true;
				}
				if(document.getElementById("inspection")){
					document.getElementById("inspection").disabled=true;
					document.getElementById("inspection1").disabled=true;
					document.getElementById("inspectionNote").readOnly=true;
					document.getElementById("fileInspection").disabled=true;
					}
				if(document.getElementById("applicationCompleted")){
					document.getElementById("applicationCompleted").disabled=true;
					document.getElementById("applicationCompleted1").disabled=true;
					document.getElementById("applicationCompletedNote").readOnly=true;
					
					}
				if(document.getElementById("inspectionClose")){
					document.getElementById("inspectionClose").disabled=true;
					document.getElementById("inspectionClose1").disabled=true;
					document.getElementById("inspectionCloseNote").readOnly=true;
					document.getElementById("inspectionReport").disabled=true;
					}
				}
			if(a=="no"){
				if(document.getElementById("assessmentIssue")){
				document.getElementById("assessmentIssue").disabled=false;
				document.getElementById("assessmentIssue1").disabled=false;
				document.getElementById("assessmentIssueNote").readOnly=false;
				}
				if(document.getElementById("feeDefaulterNoticeRadio")){
				document.getElementById("feeDefaulterNoticeRadio").disabled=false;
				document.getElementById("feeDefaulterNoticeRadio1").disabled=false;
				document.getElementById("feedefaulterNote").readOnly=false;
				}
				if(document.getElementById("inspection")){
					document.getElementById("inspection").disabled=false;
					document.getElementById("inspection1").disabled=false;
					document.getElementById("inspectionNote").readOnly=false;
					document.getElementById("fileInspection").disabled=false;
					}
				if(document.getElementById("applicationCompleted")){
					document.getElementById("applicationCompleted").disabled=false;
					document.getElementById("applicationCompleted1").disabled=false;
					document.getElementById("applicationCompletedNote").readOnly=false;
					
					}
				if(document.getElementById("inspectionClose")){
					document.getElementById("inspectionClose").disabled=false;
					document.getElementById("inspectionClose1").disabled=false;
					document.getElementById("inspectionCloseNote").readOnly=false;
					document.getElementById("inspectionReport").disabled=false;
					}
			}
			
					
	}
	function enablingDisablingCompleted(id){
		


			
				var a= document.getElementById(id).value;
				if(a=="yes"){
					if(document.getElementById("assessmentIssue")){
					document.getElementById("assessmentIssue").disabled=true;
					document.getElementById("assessmentIssue1").disabled=true;
					document.getElementById("assessmentIssueNote").readOnly=true;
					}
					if(document.getElementById("assessmentOrderRadio")){
						
					document.getElementById("assessmentOrderRadio").disabled=true;
					document.getElementById("assessmentOrderRadio1").disabled=true;
					document.getElementById("assessmentOrderNote").readOnly=true;
					}
					if(document.getElementById("feeDefaulterNoticeRadio")){
						document.getElementById("feeDefaulterNoticeRadio").disabled=true;
						document.getElementById("feeDefaulterNoticeRadio1").disabled=true;
						document.getElementById("feedefaulterNote").readOnly=true;
						}

					if(document.getElementById("inspection")){
						document.getElementById("inspection").disabled=true;
						document.getElementById("inspection1").disabled=true;
						document.getElementById("inspectionNote").readOnly=true;
						document.getElementById("fileInspection").disabled=true;
						}
					if(document.getElementById("inspectionClose")){
						document.getElementById("inspectionClose").disabled=true;
						document.getElementById("inspectionClose1").disabled=true;
						document.getElementById("inspectionCloseNote").readOnly=true;
						document.getElementById("inspectionReport").disabled=true;
						}
					
				}
				if(a=="no"){
					if(document.getElementById("assessmentIssue")){
					document.getElementById("assessmentIssue").disabled=false;
					document.getElementById("assessmentIssue1").disabled=false;
					document.getElementById("assessmentIssueNote").readOnly=false;
					}
					if(document.getElementById("assessmentOrderRadio")){
					document.getElementById("assessmentOrderRadio").disabled=false;
					document.getElementById("assessmentOrderRadio1").disabled=false;
					document.getElementById("assessmentOrderNote").readOnly=false;
					}
					if(document.getElementById("feeDefaulterNoticeRadio")){
						document.getElementById("feeDefaulterNoticeRadio").disabled=false;
						document.getElementById("feeDefaulterNoticeRadio1").disabled=false;
						document.getElementById("feedefaulterNote").readOnly=false;
						}
					if(document.getElementById("inspection")){
						document.getElementById("inspection").disabled=false;
						document.getElementById("inspection1").disabled=false;
						document.getElementById("inspectionNote").readOnly=false;
						document.getElementById("fileInspection").disabled=false;
						}
					if(document.getElementById("inspectionClose")){
						document.getElementById("inspectionClose").disabled=false;
						document.getElementById("inspectionClose1").disabled=false;
						document.getElementById("inspectionCloseNote").readOnly=false;
						document.getElementById("inspectionReport").disabled=false;
						}
					}
				
						
		}
function enablingDisablingFee(id){
	


		
			var a= document.getElementById(id).value;
			if(a=="yes"){
				if(document.getElementById("assessmentIssue")){
				document.getElementById("assessmentIssue").disabled=true;
				document.getElementById("assessmentIssue1").disabled=true;
				document.getElementById("assessmentIssueNote").readOnly=true;
				}
				if(document.getElementById("assessmentOrderRadio")){
					
				document.getElementById("assessmentOrderRadio").disabled=true;
				document.getElementById("assessmentOrderRadio1").disabled=true;
				document.getElementById("assessmentOrderNote").readOnly=true;
				}
				if(document.getElementById("inspection")){
					document.getElementById("inspection").disabled=true;
					document.getElementById("inspection1").disabled=true;
					document.getElementById("inspectionNote").readOnly=true;
					document.getElementById("fileInspection").disabled=true;
					}

				if(document.getElementById("applicationCompleted")){
					document.getElementById("applicationCompleted").disabled=true;
					document.getElementById("applicationCompleted1").disabled=true;
					document.getElementById("applicationCompletedNote").readOnly=true;
					
					}
				if(document.getElementById("inspectionClose")){
					document.getElementById("inspectionClose").disabled=true;
					document.getElementById("inspectionClose1").disabled=true;
					document.getElementById("inspectionCloseNote").readOnly=true;
					document.getElementById("inspectionReport").disabled=true;
					}
			}
			if(a=="no"){
				if(document.getElementById("assessmentIssue")){
				document.getElementById("assessmentIssue").disabled=false;
				document.getElementById("assessmentIssue1").disabled=false;
				document.getElementById("assessmentIssueNote").readOnly=false;
				}
				if(document.getElementById("assessmentOrderRadio")){
				document.getElementById("assessmentOrderRadio").disabled=false;
				document.getElementById("assessmentOrderRadio1").disabled=false;
				document.getElementById("assessmentOrderNote").readOnly=false;
				}
				if(document.getElementById("inspection")){
					document.getElementById("inspection").disabled=false;
					document.getElementById("inspection1").disabled=false;
					document.getElementById("inspectionNote").readOnly=false;
					document.getElementById("fileInspection").disabled=false;
					}
				if(document.getElementById("applicationCompleted")){
					document.getElementById("applicationCompleted").disabled=false;
					document.getElementById("applicationCompleted1").disabled=false;
					document.getElementById("applicationCompletedNote").readOnly=false;
					
					}
				if(document.getElementById("inspectionClose")){
					document.getElementById("inspectionClose").disabled=false;
					document.getElementById("inspectionClose1").disabled=false;
					document.getElementById("inspectionCloseNote").readOnly=false;
					document.getElementById("inspectionReport").disabled=false;
					}
				}
			
					
	}


function enablingDisablingInspection(id){
	


		
			var a= document.getElementById(id).value;
			if(a=="yes"){
				if(document.getElementById("assessmentIssue")){
				document.getElementById("assessmentIssue").disabled=true;
				document.getElementById("assessmentIssue1").disabled=true;
				document.getElementById("assessmentIssueNote").readOnly=true;
				}
				if(document.getElementById("assessmentOrderRadio")){
					
				document.getElementById("assessmentOrderRadio").disabled=true;
				document.getElementById("assessmentOrderRadio1").disabled=true;
				document.getElementById("assessmentOrderNote").readOnly=true;
				}
				if(document.getElementById("feeDefaulterNoticeRadio")){
					document.getElementById("feeDefaulterNoticeRadio").disabled=true;
					document.getElementById("feeDefaulterNoticeRadio1").disabled=true;
					document.getElementById("feedefaulterNote").readOnly=true;
					}

				if(document.getElementById("applicationCompleted")){
					document.getElementById("applicationCompleted").disabled=true;
					document.getElementById("applicationCompleted1").disabled=true;
					document.getElementById("applicationCompletedNote").readOnly=true;
					}
				if(document.getElementById("inspectionClose")){
					document.getElementById("inspectionClose").disabled=true;
					document.getElementById("inspectionClose1").disabled=true;
					document.getElementById("inspectionCloseNote").readOnly=true;
					document.getElementById("inspectionReport").disabled=true;
					}
				
			}
			if(a=="no"){
				if(document.getElementById("assessmentIssue")){
				document.getElementById("assessmentIssue").disabled=false;
				document.getElementById("assessmentIssue1").disabled=false;
				document.getElementById("assessmentIssueNote").readOnly=false;
				}
				if(document.getElementById("assessmentOrderRadio")){
				document.getElementById("assessmentOrderRadio").disabled=false;
				document.getElementById("assessmentOrderRadio1").disabled=false;
				document.getElementById("assessmentOrderNote").readOnly=false;
				}
				if(document.getElementById("feeDefaulterNoticeRadio")){
					document.getElementById("feeDefaulterNoticeRadio").disabled=false;
					document.getElementById("feeDefaulterNoticeRadio1").disabled=false;
					document.getElementById("feedefaulterNote").readOnly=false;
					}
				if(document.getElementById("applicationCompleted")){
					document.getElementById("applicationCompleted").disabled=false;
					document.getElementById("applicationCompleted1").disabled=false;
					document.getElementById("applicationCompletedNote").readOnly=false;
					
					}
				if(document.getElementById("inspectionClose")){
					document.getElementById("inspectionClose").disabled=false;
					document.getElementById("inspectionClose1").disabled=false;
					document.getElementById("inspectionCloseNote").readOnly=false;
					document.getElementById("inspectionReport").disabled=false;
					}
				
				}
			
					
	}

	function enablingDisablingInspectionClose(id){
		


			
				var a= document.getElementById(id).value;
				if(a=="yes"){
					if(document.getElementById("assessmentIssue")){
					document.getElementById("assessmentIssue").disabled=true;
					document.getElementById("assessmentIssue1").disabled=true;
					document.getElementById("assessmentIssueNote").readOnly=true;
					}
					if(document.getElementById("assessmentOrderRadio")){
						
					document.getElementById("assessmentOrderRadio").disabled=true;
					document.getElementById("assessmentOrderRadio1").disabled=true;
					document.getElementById("assessmentOrderNote").readOnly=true;
					}
					if(document.getElementById("feeDefaulterNoticeRadio")){
						document.getElementById("feeDefaulterNoticeRadio").disabled=true;
						document.getElementById("feeDefaulterNoticeRadio1").disabled=true;
						document.getElementById("feedefaulterNote").readOnly=true;
						}

					if(document.getElementById("applicationCompleted")){
						document.getElementById("applicationCompleted").disabled=true;
						document.getElementById("applicationCompleted1").disabled=true;
						document.getElementById("applicationCompletedNote").readOnly=true;
						
						}
					if(document.getElementById("inspection")){
						document.getElementById("inspection").disabled=true;
						document.getElementById("inspection1").disabled=true;
						document.getElementById("inspectionNote").readOnly=true;
						document.getElementById("fileInspection").disabled=true;
						}
				}
				if(a=="no"){
					if(document.getElementById("assessmentIssue")){
					document.getElementById("assessmentIssue").disabled=false;
					document.getElementById("assessmentIssue1").disabled=false;
					document.getElementById("assessmentIssueNote").readOnly=false;
					}
					if(document.getElementById("assessmentOrderRadio")){
					document.getElementById("assessmentOrderRadio").disabled=false;
					document.getElementById("assessmentOrderRadio1").disabled=false;
					document.getElementById("assessmentOrderNote").readOnly=false;
					}
					if(document.getElementById("feeDefaulterNoticeRadio")){
						document.getElementById("feeDefaulterNoticeRadio").disabled=false;
						document.getElementById("feeDefaulterNoticeRadio1").disabled=false;
						document.getElementById("feedefaulterNote").readOnly=false;
						}
					if(document.getElementById("applicationCompleted")){
						document.getElementById("applicationCompleted").disabled=false;
						document.getElementById("applicationCompleted1").disabled=false;
						document.getElementById("applicationCompletedNote").readOnly=false;
						
						}
					if(document.getElementById("inspection")){
						document.getElementById("inspection").disabled=false;
						document.getElementById("inspection1").disabled=false;
						document.getElementById("inspectionNote").readOnly=false;
						document.getElementById("fileInspection").disabled=false;
						}
					}
				
						
		}
	
</script>
<script language="JavaScript">
	    function disablingLink() {
		    
		    var state = document.getElementById("assessmentIssue").value;
	        
	            if (state == 'yes') {
	                document.getElementById("assessIssueLink").style.display = 'block';
            } else {
	                document.getElementById("assessIssueLink").style.display = 'none';
        }
	    }
	</script>
	<script language="JavaScript">
	    function disablingLink1() {
		    
		    var state = document.getElementById("assessmentIssue1").value;
	        
	            if (state == 'yes') {
	                document.getElementById("assessIssueLink").style.display = 'block';
            } else {
	                document.getElementById("assessIssueLink").style.display = 'none';
        }
	    }
	</script>
	<script language="JavaScript">
	    function disablingLink2() {
		    
		    var state = document.getElementById("assessmentOrderRadio").value;
	        
	            if (state == 'yes') {
	                document.getElementById("assessOrderLink").style.display = 'block';
            } else {
	                document.getElementById("assessOrderLink").style.display = 'none';
        }
	    }
	</script>
	<script language="JavaScript">
	    function disablingLink3() {
		    
		    var state = document.getElementById("assessmentOrderRadio1").value;
	        
	            if (state == 'yes') {
	                document.getElementById("assessOrderLink").style.display = 'block';
            } else {
	                document.getElementById("assessOrderLink").style.display = 'none';
        }
	    }
	</script>
	
	<script language="JavaScript">
	    function disablingLink4() {
		    
		    var state = document.getElementById("feeDefaulterNoticeRadio").value;
	        
	            if (state == 'yes') {
	                document.getElementById("assessFeeNoticeLink").style.display = 'block';
            } else {
	                document.getElementById("assessFeeNoticeLink").style.display = 'none';
        }
	    }
	</script>
	<script language="JavaScript">
	    function disablingLink5() {
		    
		    var state = document.getElementById("feeDefaulterNoticeRadio1").value;
	        
	            if (state == 'yes') {
	                document.getElementById("assessFeeNoticeLink").style.display = 'block';
            } else {
	                document.getElementById("assessFeeNoticeLink").style.display = 'none';
        }
	    }

	    
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
			<table width="100%" > 
			<tr bgcolor="#4C8BC0">
				<td  class="top-lnks" >
					<table width="100%" >
						 <tr height="10px">
						 	<td>Welcome <%=firstname %><%=lastName %>(<%=access %>) &nbsp;&nbsp;&nbsp;&nbsp;Role : ${roleHeader}</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 </td></tr>
					 <tr>
					 <td align="left">
						<a href="#" onclick="window.open('../openApplicationDetails/${cessReturnApp.id}', 'ApplicationHistory', 'WIDTH=450,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;Note History&nbsp;|</span></a>
						<a href="#" onclick="window.open('<%=request.getContextPath()%>/cessProcessingDetails/showCessSpcb/${cessReturnApp.id}', 'ApplicationHistory', 'WIDTH=690,HEIGHT=400,scrollbars=1,resizable=yes');"><span class="innerlink">&nbsp;View Form&nbsp;|</span></a> 
						<%if(cessAssessIssueFinalInstance){%>
							<a href="<%=request.getContextPath()%>/cessProcessingDetails/viewAssessIssue?appliId=<%=cessAssessIssueFinalInstance.id%>"><span class="innerlink">&nbsp;View Pre Assessment Notice&nbsp;|</span></a>
						<%}
						%>
						<%if(cessAssessOrderFinalInstance){%>
							<a href="<%=request.getContextPath()%>/cessProcessingDetails/viewAssessOrder?appliId=<%=cessAssessOrderFinalInstance.id%>"><span class="innerlink">&nbsp;View Assessment Order&nbsp;|</span></a>
						<%}
						%>
						 
						<%if(cessAssessfeeDefaulter){%>
							<a href="<%=request.getContextPath()%>/cessProcessingDetails/viewFeeNotice?appliId=<%=cessAssessfeeDefaulter.id%>"><span class="innerlink">&nbsp;View Fee Defaulter Notice&nbsp;|</span></a>
						<%}
						%>
						
						<g:if test="${cessReturnApp.fees}">
					<a href="<%=request.getContextPath()%>/cessReturn/viewFeePaySlip?appliId=<%=cessReturnApp.id%>"><span class="innerlink">&nbsp;View Water Cess Pay in slip&nbsp;</span></a>
					</g:if>
						</td>	
					   </tr>
					 </table>
				
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" class="middlespacer"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">
                      <g:if test="${flash.message}">
				           				 <div>${flash.message}</div>
				            			</g:if>
				            			<g:hasErrors bean="${groupMasterInstance}">
				            			
				              			  <g:renderErrors bean="${groupMasterInstance}" as="list" />
				            			
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
       
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		
		
		
		<g:form action="processCessApp" enctype="multipart/form-data" method="post" name="myForm" >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="9"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}"  /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">File Noting/Action</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}"  /></td>
							  <td width="432">&nbsp;</td>
							</tr>
	    </table>
		
		
		
          <div id="country1" >
	
		
			
			
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
			
				<tr bgcolor="#A8DAF3">
 					<td colspan="2" class="headngblue" align="center">Last Comments</td>
 					</tr>
 					
				<%if(applicationProcessingDetailsInstance){%>
				<% 
SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");

String strDate = sdfDestination.format(applicationProcessingDetailsInstance.dateCreated );
%>
			<tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Date Time:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4">
                         <%= strDate%>                       </td>
                      </tr>
 
  <tr  >
                              <td width="150px" align="right" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Note By:</div></td>
                        <td bgcolor="#E8F6F9" class="txt4"><div align="left">${applicationProcessingDetailsInstance.role}(${applicationProcessingDetailsInstance.officer})</div></td>
        </tr>			
					 <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
                       <td bgcolor="#E8F6F9" class="headngblue"><div align="left">Forward &nbsp;&nbsp;<g:if test="${applicationProcessingDetailsInstance.role.roleName=='Industry'}"><g:def var="fooVar" value="${applicationProcessingDetailsInstance.cessreturn.id}"/><g:link action="viewClarificationDocument" controller="applicationProcessingDetails" params="[appliLoc:fooVar,docName:'indClarificationFile',docType:'doc']">View Report</g:link></g:if></div></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${applicationProcessingDetailsInstance.fileNote}  </td>
                      </tr>
		<g:if test="${applicationProcessingDetailsInstance.assessmentIssue==true}">
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"><div align="left">Pre Assessment Notice raised &nbsp;&nbsp;</div></td>
                      </tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Description:</div></td>
                         <td align="left" bgcolor="#E8F6F9" class="txt4">${applicationProcessingDetailsInstance.assessmentIssueNote} </td>
                      </tr>
					  </g:if>
					  
					   <g:if test="${applicationProcessingDetailsInstance.assessmentIssueClose==true}">
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
                       <td align="left" bgcolor="#E8F6F9" class="txt4"><div align="left"  bgcolor="#E8F6F9" class="headngblue">Pre-Assessment Notice Reply</div><g:if test="${applicationProcessingDetailsInstance.clarificationReplyAttachedFile==true}"><g:def var="fooVar" value="${applicationProcessingDetailsInstance.cessreturn.id}"/><g:link action="viewCessIssueDocument" controller="cessProcessingDetails" params="[appliLoc:fooVar,docName:'indClarificationIssueFile',docType:'doc']">View Report</g:link></g:if></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${applicationProcessingDetailsInstance.assessmentIssueCloseNote}</td>
                      </tr>
					  </g:if>
					  
					  
					  
				<g:if test="${applicationProcessingDetailsInstance.inspection==true}">
                      <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
                       <td ><div align="left"  bgcolor="#E8F6F9" class="headngblue">Inspection</div><g:if test="${applicationProcessingDetailsInstance.inspectionAttachedFile==true}"><g:def var="fooVar" value="${applicationProcessingDetailsInstance.cessreturn.id}"/><g:link action="viewInspectionDocument1" controller="cessProcessingDetails" params="[appliLoc:fooVar,docName:'attachedInspectionReport',docType:'doc']">View Report</g:link> </g:if></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3" ><div align="right" class="style3">Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${applicationProcessingDetailsInstance.inspectionNote}</td>
                      </tr>
				 </g:if>
				 <g:if test="${applicationProcessingDetailsInstance.inspectionClose==true}">
                      <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
                       <td bgcolor="#E8F6F9"><span align="left"  class="headngblue">Inspection Closed</span> <span  class="txt">&nbsp; <g:if test="${applicationProcessingDetailsInstance.inspectionCloseAttachedFile==true}"><g:def var="fooVar" value="${applicationProcessingDetailsInstance.cessreturn.id}"/><g:link action="viewInspectionCloseDocument1" controller="cessProcessingDetails" params="[appliLoc:fooVar,docName:'InspectionReport',docType:'doc']">View Report</g:link></g:if></td>
                      </tr>
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3" ><div align="right" class="style3">Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${applicationProcessingDetailsInstance.inspectionCloseNote}</td>
                      </tr>
				</g:if>
 					<g:if test="${applicationProcessingDetailsInstance.assessmentOrder==true}">
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"><div align="left">Assessment Order generated &nbsp;&nbsp;</div></td>
                      </tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Description:</div></td>
                         <td align="left" bgcolor="#E8F6F9" class="txt4"> ${applicationProcessingDetailsInstance.assessmentOrderNote} </td>
                      </tr>
					  </g:if>
					  <g:if test="${applicationProcessingDetailsInstance.feeDefaulterNotice==true}">
                       <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"><div align="left">Late Fee Notice generated &nbsp;&nbsp;</div></td>
                      </tr>
                      <tr >
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Description:</div></td>
                         <td align="left" bgcolor="#E8F6F9" class="txt4">${applicationProcessingDetailsInstance.feeDefaulterNoticeNote} </td>
                      </tr>
					  </g:if>
					  
		
					 <tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 					</tr>
					  <tr bgcolor="#F4F7FB">
                        <td  width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Attached Letter:</div></td>
                       <td ><div align="left"  bgcolor="#E8F6F9" class="headngblue">Letter Attached By Officials</div><g:def var="fooVar1" value="${applicationProcessingDetailsInstance.cessreturn.id}"/><g:link action="viewOtherAttachedFile" controller="cessProcessingDetails" params="[appliLoc:fooVar1,docName:'attachLetter',docType:'doc']">View Letter</g:link></td>
                      </tr>
		 
 					<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 					</tr>
					<%}%>
			<tr >
				<td  bgcolor="#A8DAF3" class="headngblue" >Forward To : </td>
			 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
					  <g:select optionKey="id" from="${fwdRoleList}" name="forward" class="txt4" ></g:select>
					 
				</span></span>				</td>
			</tr>	
				
			<tr >
				<td  bgcolor="#A8DAF3" class="headngblue" >File Note : </td>
			 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <textarea name="fileNote" cols="40" class="txt4"></textarea>
					</span></td>
				</tr>
					<tr >
				<td  bgcolor="#A8DAF3" class="headngblue" >Attach letter (If Any): </td>
			 	<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input type="file" name="attachLetter"/>
					</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span></td>
				</tr>	
				<g:if test="${assessmentIssue==true}">
					<tr bgcolor="#A8DAF3">
 						<td colspan="2">&nbsp;</td>
 					</tr>
					<tr >
						<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to raise Pre Assessment Notice ? : </td>
			 			<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
						<input name="assessmentIssue" id="assessmentIssue" type="radio" value="yes" onclick="enablingDisabling(this.id);disablingLink()"/>
                        <span class="style3">Yes</span>                              
                           <input name="assessmentIssue" id="assessmentIssue1" type="radio" value="no" onclick="enablingDisabling(this.id);disablingLink1()" checked="checked"/>
                           <span class="style3">No</span>			
                     	</td>
					</tr>
					<tr >
				
			 			<td  bgcolor="#BFBFBF" class="headngblue" >&nbsp;</td>
			 			<td  align="left" bgcolor="#BFBFBF"  class="headngblue" ><span class="txt style6">
						<div id="assessIssueLink" ><a id="assessmentIssueLink" href="<%=request.getContextPath()%>/cessProcessingDetails/assessmentIssueGenerate?appliId=<%=cessReturnApp.id%>"><span class="innerlink">&nbsp;<u>Prepare Pre Assessment Notice</u></span></a></div>
						</span></td>
					</tr>
				<tr >
					<td  bgcolor="#BFBFBF" class="headngblue" >Pre Assessment Note : </td>
			 		<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <textarea name="assessmentIssueNote"  id="assessmentIssueNote" cols="35" class="txt4"></textarea>
						</span>&nbsp;</td>
				</tr>
				
				</g:if>
				
				<g:if test="${inspection==true}">
				<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 				</tr>
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Do you want to raise Inspection ? : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue">
						<input name="inspection" id="inspection" type="radio" value="yes" onclick="enablingDisablingInspection(this.id);">
                                <span class="style3">Yes</span>                              
                                <input name="inspection" id="inspection1" type="radio" value="no" checked="checked" onclick="enablingDisablingInspection(this.id);">
                                <span class="style3">No</span>					</td>
				</tr>
				
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Note : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
					  <textarea name="inspectionNote" id="inspectionNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;<a href="#">Copy To</a></td>
				</tr>	
					
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Attach letter for inspection Report: </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt">
					  <input type="file" id="fileInspection" name="attachInspectionReport"/>
					</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span>	&nbsp;<a href="#">Copy To</a></td>
				</tr>				
        	 </g:if>
        	 
        	 <g:if test="${inspectionClose==true}">
				<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 				</tr>
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to Close Inspection ? : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
						<input name="inspectionClose" id="inspectionClose" type="radio" value="yes" onclick="enablingDisablingInspectionClose(this.id);">
                                <span class="style3">Yes</span>                              
                                <input name="inspectionClose" id="inspectionClose1" type="radio" value="no" checked="checked" onclick="enablingDisablingInspectionClose(this.id);">
                                <span class="style3">No</span>					</td>
				</tr>
				
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue">Inspection Note : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <textarea name="inspectionCloseNote" id="inspectionCloseNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;<a href="#">Copy To</a></td>
				</tr>
				
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Upload Report : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <input type="file" name="inspectionReport" id="inspectionReport"/>
					</span><span class="sidetxt ">(.doc,.txt  max of 2MB in size)</span>	&nbsp;<a href="#">Copy To</a></td>
				</tr>				
        	 </g:if>
        	 
        	 <div id="order">
        	 
        	 <g:if test="${assessmentOrder==true}">
				<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 				</tr>
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Do you want to raise assessment order ? : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue">
						<input name="assessmentOrderRadio" id="assessmentOrderRadio" type="radio" value="yes" onclick="enablingDisablingOrder(this.id);disablingLink2()"/>
                                <span class="style3">Yes</span>                              
                                <input name="assessmentOrderRadio" id="assessmentOrderRadio1" type="radio" value="no" onclick="enablingDisablingOrder(this.id);disablingLink3()" checked="checked"/>
                                <span class="style3">No</span>				</td>
				</tr>
					<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >&nbsp;</td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue" ><span class="txt style6">
					<div id="assessOrderLink" ><a id="assessmentOrderLink" href="<%=request.getContextPath()%>/cessProcessingDetails/assessmentOrder?appliId=<%=cessReturnApp.id%>"><span class="innerlink">&nbsp;<u>Prepare Assessment Order</u></span></a></div>
					</span></td>
				</tr>
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Assessment Note : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
					  <textarea name="assessmentOrderNote" id="assessmentOrderNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;</td>
				</tr>
			
				
				
				</g:if>
				</div>
				<g:if test="${feeDefaulterNotice==true}">
<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 					</tr>
			<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Do you want to raise Fee Defaulter Notice ? : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue">
						<input name="feeDefaulterNoticeRadio" id="feeDefaulterNoticeRadio" type="radio" onclick="enablingDisablingFee(this.id);disablingLink4()" value="yes" />
                                <span class="style3">Yes</span>                              
                                <input name="feeDefaulterNoticeRadio" id="feeDefaulterNoticeRadio1" type="radio" value="no" onclick="enablingDisablingFee(this.id);disablingLink5()" checked="checked"/>
                                <span class="style3">No</span>				</td>
				</tr>
				
				
				<tr >
				
			 	<td  bgcolor="#BFBFBF" class="headngblue" >&nbsp;</td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue" ><span class="txt style6">
					<div id="assessFeeNoticeLink" ><a id="feeNoticeLink" href="<%=request.getContextPath()%>/cessProcessingDetails/feeNotice?appliId=<%=cessReturnApp.id%>"><span class="innerlink">&nbsp;<u>Prepare Fee Defaulter Notice</u>&nbsp;</span></a></div>
					</span></td>
				</tr>
				<tr >
				<td  bgcolor="#BFBFBF" class="headngblue" >Fee Dafaulter Note : </td>
			 	<td  align="left" bgcolor="#BFBFBF"  class="headngblue"><span class="txt style6">
					  <textarea name="feedefaulterNote" id="feedefaulterNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;</td>
				</tr>
				
				
				
				</g:if>
				
				<g:if test="${appCompleted==true}">
<tr bgcolor="#A8DAF3">
 					<td colspan="2">&nbsp;</td>
 					</tr>
			<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Application Completed ? : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue">
						<input name="applicationCompleted" id="applicationCompleted" type="radio" onclick="enablingDisablingCompleted(this.id);" value="yes" />
                                <span class="style3">Yes</span>                              
                                <input name="applicationCompleted" id="applicationCompleted1" type="radio" value="no" onclick="enablingDisablingCompleted(this.id);" checked="checked"/>
                                <span class="style3">No</span>				</td>
				</tr>
				
				
				
				<tr >
				<td  bgcolor="#98AFC7" class="headngblue" >Note : </td>
			 	<td  align="left" bgcolor="#98AFC7"  class="headngblue"><span class="txt style6">
					  <textarea name="applicationCompletedNote" id="applicationCompletedNote" cols="35" class="txt4"></textarea>
					</span>&nbsp;</td>
				</tr>
				
				
				
				</g:if>
        	
        	 
                        </table>
						
						
						
	   <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
		  <td><input name="appId" type="hidden" value="${app.id}"/></td>
			<td align="right"><input type="submit" name="Save" value="Send Application" class="draftbutton" ></td>
			<td align="left"><input type="reset" name="reset" value="Reset" class="actionbutton"></td>			
		  </tr>
		</table>
		
		
  			</g:form>
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
      </td>
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
</body>
</html>


