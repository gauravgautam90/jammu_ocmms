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
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'tempWaterUseAdd.gsp', { insertion: Insertion.Bottom });
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
<g:form name="waterSourceUses" method="post" action="saveWaterSourceUses" >
<div align="center">
<table width="90%" cellpadding="1" cellspacing="1" class="tblbdr">
<tr><td colspan="4" class="headngblue" align="center" bgcolor="#B8DAF3">Water Source Details</td></tr>
		<tr>
		<td width="25%" class="headngblue" bgcolor="#A8DAF3">Source Type</td>
		<td  width="25%" bgcolor="#E8F6F9" class="headngblue"><%=waterSourceInstance.source%>
		  <input type="hidden" value="<%=waterSourceInstance.id%>" name="source" /> <input type="hidden" value="<%=app%>" name="app" /></td>
		<td  width="20%" bgcolor="#A8DAF3" class="headngblue">Quantity (Kl/D)</td>
		<td   width="25%" bgcolor="#E8F6F9" class="headngblue"><%=waterSourceInstance.quantity%></td>
		<input type="hidden" value="<%=waterSourceInstance.sourceName%>" name="sourceName" />
		
		<td>&nbsp;</td>
		</tr>
		<tr>
           		<td   width="25%"  bgcolor="#A8DAF3" class="headngblue" >Usage</td>
                <td   width="25%"  bgcolor="#E8F6F9" class="txt4">
                   <g:select optionKey="id"  class="txt4" from="${WaterUsesMaster.list()}" name="waterSourceUses"></g:select>
          			<span class="sidetxt">(select)</span>
          		</td>
        
                <td  width="20%"  class="headngblue" bgcolor="#A8DAF3">Quantity (Kl/D)</td>
                <td width="25%" bgcolor="#E8F6F9" class="txt4"><input name="sourceUseQuantity" type="text" size="6"class="txt4" /><span class="sidetxt">(enter qty)</span></td>
       			<td ><a href="javascript:createRow()"><img  src="${createLinkTo(dir:'images',file:'addOffice.png')}" border="0" align="center" alt="ADD ROW" ></a></td>
        </tr>
        <tr><td colspan="5">
        <div id="AjaxPanel"></div>
        </td></tr>
					
		<tr><span class="txt" style="color: navy"><b>click Plus button to add & save multiple details and next to enter further details</b></span>
		
		<td colspan="4" align="center"><input type="submit" name="add" value="Next" class="actionbutton"></td>
		</tr> 
                      
</g:form>  
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("sourceUseQuantity","req","Please enter Quantity");
  frmvalidator.addValidation("sourceUseQuantity","decimal","Quantity should be decimal or numeric");
 </script>                
</table>
</div>
</body>