<%@ page import="java.text.SimpleDateFormat"%>
<head>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
</head>
<body>
<g:form action="submittedClarification" enctype="multipart/form-data" name="myform" method="post" >
   <%	int versionVal1=0;
                    def var = 0;  	
 				int varCheckInsClarification = 0;
 				int varCheckInsClarifications = 0;
 				    int varCheck=0; 
 				    int varCheckIns = 0;
 					int varCheckCla=0;
 					int varCheckFile=0;
 					int varCheckCl=0;
 					int varCheckCl1=0;
                     // System.out.println("app....."+app);
                      def versionValue1=1 
    
                      
                      %>
<g:each in="${applicationProcessingDetailsInstanceList}" status="i" var="appClarification">

<%


if(appClarification){ %>
<table width="60%" align= "center">
<% 
SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss a");
String strDate = sdfDestination.format(appClarification.dateCreated );
if(appClarification.closeInd == true){

%>

 <tr  >
                              <td width="150px" align="center" valign="middle" colspan =2 class="headngblue" bgcolor="#A8DAF3"><div align="center" class="style3">Closed Industry Details :</div></td>
        </tr>
        <tr >
                        <td width="150px" bgcolor="#A8DAF3" class="headngblue" ><div align="right" class="style3">Date Time:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4">
                         <%= strDate%>                       </td>
                      </tr>

  <tr  >
                              <td width="150px" align="right" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Closed By:</div></td>
                        <td bgcolor="#E8F6F9" class="txt4"><div align="left">${appClarification.role}(${appClarification.officer})</div></td>
        </tr>			
					 <tr >
						<td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Activity:</div></td>
						<td align="left" bgcolor="#E8F6F9" class="txt4"> Industry closed </td>
						</tr>
					 
                      <tr >
                        <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Description:</div></td>
                        <td align="left" bgcolor="#E8F6F9" class="txt4"> ${appClarification.closeIndNote}  </td>
                      </tr>
        
        <%}%>

		            
		</td>
                    
                      </tr>
    
             
</table>
    
<%}%>
  </g:each>
</g:form>
<script language="JavaScript" type="text/javascript">

 var frmvalidator  = new Validator("general");
 frmvalidator.EnableFocusOnError(false); 
   // frmvalidator.EnableMsgsTogether();  

 function Checkfiles()
 {
    var frm = document.forms["myform"];  
    var fupp = document.getElementsByName('indClarificationFile');
    var fup = fupp[0];
    var fileName = fup.value;
    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
    
    if(ext == "pdf" || fileName =="" )
  	   return true;
    else
	{
    	sfm_show_error_msg('Please upload non editable files as Gif,pdf or Jpg files',fupp);
		 	
	     return false;
	}
  }
	frmvalidator.setAddnlValidationFunction("Checkfiles"); 
</script>
</body>
 