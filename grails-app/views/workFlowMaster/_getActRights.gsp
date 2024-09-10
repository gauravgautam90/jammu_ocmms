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
				<td class="headngblue" width="13%">Receiving Officer</td>
				<%for(int i=0;i<fwdListRc.size();i=i+2){%>
				<td align="left" class="txt4" width="10%"><input
					type="checkbox" name='rcRole' value="<%=(fwdListRc.get(i)).id%>"
					<%if(fwdListRc.get(i+1)==true){%> checked="checked" <%}%>><span
					class="style1"><%=(fwdListRc.get(i)).roleName%></span></td>
				<%}%>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class="headngblue">Raise Clarification</td>
				<%for(int i=0;i<fwdListClari.size();i=i+2){%>
				<td class="txt4"><input type="checkbox" name='clariRole'
					value="<%=(fwdListRc.get(i)).id%>"
					<%if(fwdListClari.get(i+1)==true){%> checked="checked" <%}%>><span
					class="style1"><%=(fwdListClari.get(i)).roleName%></span></td>
				<%}%>
				<td>&nbsp;</td>
			</tr>

			<tr>
				<td class="headngblue">Raise Inspection</td>
				<%for(int i=0;i<fwdListIns.size();i=i+2){%>
				<td class="txt4"><input type="checkbox" name='insRole'
					value="<%=(fwdListRc.get(i)).id%>"
					<%if(fwdListIns.get(i+1)==true){%> checked="checked" <%}%>><span
					class="style1"><%=(fwdListIns.get(i)).roleName%></span></td>
				<%}%>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class="headngblue">Submit Inspection Report</td>
				<%for(int i=0;i<fwdListInsClose.size();i=i+2){%>
				<td class="txt4"><input type="checkbox" name='insCloseRole'
					value="<%=(fwdListInsClose.get(i)).id%>"
					<%if(fwdListInsClose.get(i+1)==true){%> checked="checked" <%}%>><span
					class="style1"><%=(fwdListInsClose.get(i)).roleName%></span></td>
				<%}%>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class="headngblue">Close after Approval</td>
				<%for(int i=0;i<fwdListApp.size();i=i+2){%>
				<td class="txt4"><input type="checkbox" class="txt4"
					name='appRole' value="<%=(fwdListApp.get(i)).id%>"
					<%if(fwdListApp.get(i+1)==true){%> checked="checked" <%}%>><span
					class="style1"><%=(fwdListApp.get(i)).roleName%></span></td>
				<%}%>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class="headngblue">Close after Rejection</td>
				<%for(int i=0;i<fwdListRej.size();i=i+2){%>
				<td class="txt4"><input type="checkbox" class="txt4"
					name='rejRole' value="<%=(fwdListRej.get(i)).id%>"
					<%if(fwdListRej.get(i+1)==true){%> checked="checked" <%}%>><span
					class="style1"><%=(fwdListRej.get(i)).roleName%></span></td>
				<%}%>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class="headngblue">Prepare Certificate</td>
				<%for(int i=0;i<fwdListCert.size();i=i+2){%>
				<td class="txt4"><input type="checkbox" class="txt4"
					name='certRole' value="<%=(fwdListCert.get(i)).id%>"
					<%if(fwdListCert.get(i+1)==true){%> checked="checked" <%}%>><span
					class="style1"><%=(fwdListCert.get(i)).roleName%></span></td>
				<%}%>
				<td>&nbsp;</td>
			</tr>

			<tr>
				<td colspan="100%" align="center">&nbsp;</td>
			</tr>
			</td>
			</tr>
		</table>
		<!-- 
                        
                  		<tr>
							<td class="headngblue">Receiving Officer</td>
							<td class="txt4"><g:select optionKey="id" noSelection="${['null':'Select One...']}" from="${rolesList}" id="roles" name="roles"></g:select><a href="javascript:createRow()"><img  src="${createLinkTo(dir:'images',file:'addOffice.png')}" border="0" align="center" alt="ADD" ></a></td><td><div id="AjaxPanel"></div></td>
						</tr>
                     -->
</table>


</body>
