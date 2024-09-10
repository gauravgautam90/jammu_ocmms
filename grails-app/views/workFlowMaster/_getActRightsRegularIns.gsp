<head>
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'menucontents.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'tabcontent.js')}"></script>

<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>


<g:javascript>
function createRow(){
  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'tempAddRoles.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>
</head>
<body>

<table width="100%" cellpadding="0" cellspacing="0" bgcolor="#F4F7FB">

	<tr>
		<td style="width: 670px;">
		 <div
			style="width: 670px; height: 100%; overflow-x: auto; overflow-y: hidden; background-color: #ffffc6">
		     <table style="width: 200%;" border="1" bordercolor="#000000"
			cellpadding="0" cellspacing="0">
			<tr>
				<td>
			<tr>
			 <td class="headngblue">Regular Clarification Raise</td>
				<%
				for(int i=0;i<regularClarificationList.size();i=i+2){%>
				<td class="txt4"><input type="checkbox" class="txt4"
					name='regInspection' value="<%=(regularClarificationList.get(i)).id%>"
					<%if(regularClarificationList.get(i+1)==true){
				
					%> checked="checked" <%}%>><span
					class="style1"><%=(regularClarificationList.get(i)).roleName%></span></td>
				<%}%>
				<td>&nbsp;</td>
			</tr>
          <tr>
				<td class="headngblue">Close Regular Inspection After Approve</td>
				<%
				for(int i=0;i<regularInspectionclosedListApproved.size();i=i+2){%>
				<td class="txt4"><input type="checkbox" class="txt4"
					name='regInspectionClose' value="<%=(regularInspectionclosedListApproved.get(i)).id%>"
					<%if(regularInspectionclosedListApproved.get(i+1)==true){
					%> checked="checked" <%}%>><span
					class="style1"><%=(regularInspectionclosedListApproved.get(i)).roleName%></span></td>
				<%}%>
				<td>&nbsp;</td>
			</tr>

           <td class="headngblue">Close Regular Inspection After Rejection</td>
				<%
				for(int i=0;i<regularInspectionclosedListReject.size();i=i+2){%>
				<td class="txt4"><input type="checkbox" class="txt4"
					name='regInspectionCloseReject' value="<%=(regularInspectionclosedListReject.get(i)).id%>"
					<%if(regularInspectionclosedListReject.get(i+1)==true){
					%> checked="checked" <%}%>><span
					class="style1"><%=(regularInspectionclosedListReject.get(i)).roleName%></span></td>
				<%}%>
				<td>&nbsp;</td>
			</tr>
        	
			<td class="headngblue">Prepare Certificate For Revoke</td>
				<%
				for(int i=0;i<regularInspectionPrepareCertificateRevokeList.size();i=i+2){%>
				<td class="txt4"><input type="checkbox" class="txt4"
					name='prepareRevokeCertificate' value="<%=(regularInspectionPrepareCertificateRevokeList.get(i)).id%>"
					<%if(regularInspectionPrepareCertificateRevokeList.get(i+1)==true){
					%> checked="checked" <%}%>><span
					class="style1"><%=(regularInspectionPrepareCertificateRevokeList.get(i)).roleName%></span></td>
				<%}%>
				<td>&nbsp;</td>
			</tr>
			</td>
			
			<tr>
				<td colspan="100%" align="center">&nbsp;</td>
			</tr>
			</td>
			</tr>
		</table>
		
</table>
</body>
