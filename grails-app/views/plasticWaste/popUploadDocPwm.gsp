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
<g:form id="general" name="general" method="post" enctype="multipart/form-data" action="saveDocs" >
<div align="center" class="headngblue">${flash.message}</div>
<br>
<table align="center" width="90%" cellpadding="1" cellspacing="1" class="tblbdr">
<tr bgcolor="#A8DAF3">

		<td width="5%"  align="center" class="headngblue">S.NO</td>
		<td width="75%"  align="center" class="headngblue">Document Name</td>
		<td width="20%" align="center" class="headngblue">Document Path</td>


	</tr>
	
	<%int a=1;%>
	<%for(int i=0;i<docList.size();i++) {%>
	<tr bgcolor="#E8F6F9">
		<td align="center" class="headngblue"><%=a%></td>
		<% if(false){ %>
		<td align="center" class="headngblue"><%=(docList.get(i)).document%><span style="color:red">*</span></td>
		<% } else { %>
		<td align="center" class="headngblue"><%=(docList.get(i)).document%></td>
		<% } %>
		<td align="center" class="headngblue"><span class="style30">
		<input type="file" name="<%=(docList.get(i)).document%>" onChange="getStats(this)"/><input type="hidden" name="<%=(docList.get(i)).document+"extn"%>"/></td>
	</tr>
	
	<%a++;}%>
	
	<tr bgcolor="#E8F6F9">
		<td align="center" colspan="3" class="headngblue"><input type="hidden" name="indAppId" value="<%=appDetId%>"/><input type="submit" name="Save" value="Save" class="actionbutton"></td>
	</tr>
		
		<tr bgcolor="#D1D1D1">
		<td colspan="3" align="center" valign="middle" class="headngblue">Uploaded Documents Details</td>
		</tr>
		<% System.out.println("Inside Upload Documents List is>>>>>>>>>>"+uploadedDocList)%>															
		<g:each var="doc" in="${uploadedDocList}">
		<tr>
		    <% System.out.println("Upload Documents List is>>>>>>>>>>"+uploadedDocList)%>
			<td colspan="2" width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">${doc.description}</td>
			<td width="40%" align="left" bgcolor="#E8F6F9" class="headngblue">
			<g:def var="fooVar" value="${app.id}"/>
	      <g:def var="docN" value="${doc.description}"/>
			<g:link action="viewFile1" params="[appliLoc:fooVar,docName:docN,docType:'pdf']" >Download</g:link></td>
		</tr>
		</g:each>
</g:form>
  
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("general");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("sourceUseQuantity","req","Please enter Quantity");
  frmvalidator.addValidation("sourceUseQuantity","decimal","Quantity should be numeric or decimal");
 </script>                
</table>
</div>
</body>