<head>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<g:javascript library="prototype" />
<g:javascript>
function callParentWindowFunction()
    {	
    	alert('hello')
        window.opener.hello();
    }

function createRow(){
	try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'tempWaterModeUseAdd.gsp', { insertion: Insertion.Bottom });
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
</head>
<body>
<g:form name="waterSourceModeUses" method="post" action="saveAirFugitiveEmmision" >
<table>
<tr bgcolor="#D1D1D1"><td align="center" class="headngblue">Fugitive Emission</td></tr>
<tr><td>
				<table width="100%">
					<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="30%" align="center" >Stack</td>
							  <td   bgcolor="#E8F6F9" align="left"class="headngblue"><span class="style30">
							  <input name="appId" class="txt4" type="hidden" value="<%=appDetId%>" /> <g:select class="txt4" optionKey="id" from="${stackList}" name="stack"></g:select>
							</span></td>
							</tr>
							<tr class="headngblue" bgcolor="#A8DAF3">
							  <td width="15%" align="center" >Pollution Control Equipment</td>
							  <td   bgcolor="#E8F6F9" align="left"class="headngblue"><span class="style30">
							  <g:select multiple="multiple" class="txt4" optionKey="id" from="${AirEmiControlMeasureMaster.list()}" name="airFugiCntrlMeasure"></g:select>
							</span></td>
							  
							  <!-- <td width="15%" align="center" class="headngblue">Action </td> -->
							  
						    </tr>
						  <tr><span class="txt" style="color: navy"><b>Click Add button to enter multiple details</b></span>
		<td colspan="3" align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td>
		</tr> 
						</table>
					</td>
				</tr>
				<tr>
				<td><span class="txt" style="color: navy"><b>List of fugitive emission details added.</b></span>
				<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table>
 					
 					<tr bgcolor="#A8DAF3">
                        <td width="150px" align="left" class="headngblue" ><div  class="style3">Stack Attached To Plant</div></td>
                        
                      	<td width="150px" align="left" class="headngblue" ><div  class="style3">Pollution Control Measures</div></td>
                      </tr>
 <g:each in="${airStackInstList}" status="i" var="stackDetInst">
  <tr align="center" >
  					<td bgcolor="#E8F6F9" align="left"><span class="txt style6">${stackDetInst.stack}
                        </span></td>
                         <td  bgcolor="#E8F6F9" align="left">
                         <%
                         ArrayList pollCntrlList = pollCntrlBList.get(i);
                         for(int j=0;j<pollCntrlList.size();j++){ %>
                         <span class="txt style6"><%=(pollCntrlList.get(j)).pollutionCntrlMeasure %></span>,
                         <%}%>
                         </td>
                              
        </tr>		
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
 					
 					
 					
 					</table>
				</td>
				</tr>
				</table>
				</g:form>
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceModeUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
 
  frmvalidator.addValidation("stack","req","Please enter Stack attached to Plant");
  frmvalidator.addValidation("airFugiCntrlMeasure","req","Please enter pollution Control Equipments");
  
  
 </script> 
				</body>
				