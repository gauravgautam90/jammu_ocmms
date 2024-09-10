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
				<td class="headngblue" width="13%">Receiving Sample</td>
				<%for(int i=0;i<fwdListRc.size();i=i+2){%>
				<td align="left" class="txt4" width="10%"><input
					type="checkbox" name='rcRole' value="<%=(fwdListRc.get(i)).id%>"
					<%if(fwdListRc.get(i+1)==true){%> checked="checked" <%}%>><span
					class="style1"><%=(fwdListRc.get(i)).roleName%></span></td>
				<%}%>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class="headngblue">Generate Sample Report</td>
				<%for(int i=0;i<fwdListClari.size();i=i+2){%>
				<td class="txt4"><input type="checkbox" name='clariRole'
					value="<%=(fwdListRc.get(i)).id%>"
					<%if(fwdListClari.get(i+1)==true){%> checked="checked" <%}%>><span
					class="style1"><%=(fwdListClari.get(i)).roleName%></span></td>
				<%}%>
				<td>&nbsp;</td>
			</tr>

			<tr>
				<td class="headngblue">Complete Sample Process</td>
				<%for(int i=0;i<fwdListIns.size();i=i+2){%>
				<td class="txt4"><input type="checkbox" name='insRole'
					value="<%=(fwdListRc.get(i)).id%>"
					<%if(fwdListIns.get(i+1)==true){%> checked="checked" <%}%>><span
					class="style1"><%=(fwdListIns.get(i)).roleName%></span></td>
				<%}%>
				<td>&nbsp;</td>
			</tr>
			





			<tr>
				<td colspan="100%" align="center">&nbsp;</td>
			</tr>
			</td>
			</tr>
		</table>
		
</table>


</body>
