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
<g:form name="waterSourceModeUses" method="post" action="saveWaterSourceModeUse" >
<div align="center">
<table width="95%" cellpadding="1" cellspacing="1"  style="border-collapse:collapse;" class="tblbdr">
		<tr>
			<td colspan="4" class="headngblue" align="center" bgcolor="#B8DAF3">Water Source Details</td></tr>
		<tr>
			<td  class="headngblue" bgcolor="#E8F6F9" align="center">Source Type</td>
			<td bgcolor="#E8F6F9" colspan="2" class="txt"><%=waterSourceInstance.source%><input type="hidden" value="<%=waterSourceInstance.id%>" name="source" /> <input type="hidden" value="<%=app%>" name="app" /></td>
			<td  class="headngblue" bgcolor="#E8F6F9" align="center">Quantity</td>
			<td  colspan="2" bgcolor="#E8F6F9" class="txt"><%=waterSourceInstance.quantity%></td>
		</tr>
		<tr>
           		<td   bgcolor="#A8DAF3" class="headngblue" >Mode Of Use</td>
                <td   colspan="4" bgcolor="#E8F6F9" class="txt4">
                                   <g:select class="txt4" optionKey="id"  from="${WaterModeUseMaster.list()}" name="waterModeUse"></g:select>
                                   <span class="sidetxt">(select mode)</span>
                                </td>
        		</tr>
        		<tr>
                <td   class="headngblue" bgcolor="#A8DAF3">Quantity (Kl/D)</td>
                <td colspan="4" bgcolor="#E8F6F9" class="txt4"><input name="modeUseQuantity" type="text" size="12"class="txt4" />
                <span class="sidetxt">(enter qty)</span></td>
                </tr>
                <tr>
                <td   class="headngblue" bgcolor="#A8DAF3">Waste Water Generation (Kl/D)</td>
                <td colspan="3" bgcolor="#E8F6F9" class="txt4"><input name="modeUseWasteGeneration" type="text" size="12"class="txt4" />
                <span class="sidetxt">(enter qty)</span></td>
                
       			<td>
       			<a href="javascript:createRow()"><img  src="${createLinkTo(dir:'images',file:'addOffice.png')}" border="0" align="center" alt="ADD ROW" ></a></td>
        </tr>
        <tr><td colspan="7">
        <div id="AjaxPanel"></div>
        </td></tr>
					
		<tr>
		<td colspan="7" align="center"><input type="submit" name="Add" value="Next" class="actionbutton"></td>
		</tr> 
                      
</g:form>     
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceModeUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("modeUseQuantity","req","Please enter Quantity");
  frmvalidator.addValidation("modeUseQuantity","decimal","Quantity should be decimal or numeric");
  frmvalidator.addValidation("modeUseWasteGeneration","decimal","Waste Water Generated should be decimal or numeric");
 </script>           
</table>
</div>
</body>