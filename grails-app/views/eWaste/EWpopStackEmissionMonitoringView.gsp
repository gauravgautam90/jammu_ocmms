<head>



<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<g:javascript library="prototype" />

<g:javascript>
function callParentWindowFunction()
    {	
    	alert('hello')
        window.opener.hello();
    }

</g:javascript>

<g:javascript>
function createMyRow(){
  try{
      var oAjax=new Ajax.Updater({success: 'myPanel'},'tempWaterTreatmentAdd.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

















<script type="text/javascript">



</script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
</head>
<body>
<table align="center" width="100%">

	<tr align="center">

		<td width="100%" align="center">

		<div>





		
		<div >
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					<tr bgcolor="#D1D1D1">
					<td align="center" valign="middle"  class="headngblue">Stack Emission Monitoring Details </td>
				</tr> 
 					<tr><td><table width="100%">
 					
 					<tr bgcolor="#A8DAF3" >
 						    <td width="20%" align="center" valign="middle"  class="headngblue">Stack Attached to the Plant</td>
						<td colspan="6" width="40%" align="center" class="headngblue" ><div>Emission (mg/Nm3)<br>SPM&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SO2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NOx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Pb&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Others</div></td></div></td>
						
						 </tr>
 <g:each in="${stackemissiondetails}" status="i" var="stackemissiondetails">
  <tr align="center" >
  					    
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${stackemissiondetails.stack}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${stackemissiondetails.spm}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${stackemissiondetails.so2}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${stackemissiondetails.nox}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${stackemissiondetails.pb}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${stackemissiondetails.others}</span></td>
                       
                       </tr>		
    </g:each>		
 				
 					
 					</table>
 				</td></tr>
 				
  </table>
  
		</div>
		</div>
		</td>
	</tr>

				<%if(session.getAttribute("userMaster")){
								
								 UserMaster aa = (UserMaster)session.getAttribute("userMaster");

                                 String userType = aa.accessLevel
								if(userType.equals("admin") || userType.equals("employee")) { %>
								

<!--<tr>

    <td align="center" height="1" colspan="2"  bgcolor="#d0d1d0"><input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath()%>/eEWaste/spcbShowForm?appliId=<%=appDetId%>#country6', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');"> </td>
		  
  </tr>-->
<%}}%>
				</table>
				</div>
  
 
			
</body>