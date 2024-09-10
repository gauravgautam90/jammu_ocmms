<HEAD>
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
</HEAD>
<BODY>


<table width="100%">
	<tr>
		<td width="30%" bgcolor="#A8DAF3" class="headngblue">
		<div align="right" class="style3">Group:</div>
		</td>
		<td align="left" bgcolor="#E8F6F9"><span class="txt style6">


		<g:select optionKey="id" class="txt4" id="groupId" name="groupId"
			from="${roleList1}"
			onclick="${remoteFunction(controller:'groupDistrictMaster', action:'updateSelect',update:'roleSelected', params:'\'cont=\' + this.value' )}"
			value=""></g:select> </span></td>
	</tr>
	<tr>
		<td width="30%" bgcolor="#A8DAF3" class="headngblue">
		<div align="right" class="style3">District:</div>
		</td>
		<td align="left" bgcolor="#E8F6F9"><span class="txt style6">

		<div id="roleSelected"><g:select optionKey="id" class="txt4"
			noSelection="${['':'Select District']}" from="${finalListToRemove}"
			size="5" multiple="multiple" name="districtid"></g:select></div>
		</span></td>
	</tr>
</table>
</BODY>
