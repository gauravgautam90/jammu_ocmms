<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>
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
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>

<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow-x: hidden;
	overflow-y: auto;
}

.style3 {
	color: #186DB5
}

.style5 {
	color: #0099FF
}

.style6 {
	color: #33FF66;
}

a:link {
	text-decoration: none;
	color: #1E6BBD;
}

a:visited {
	text-decoration: none;
}

a:hover {
	text-decoration: none;
}

a:active {
	text-decoration: none;
}

.qwe123 {
	background-image: url('${createLinkTo(dir:' images2/ gif ',file:' blue_bg.gif ')}')
		;
	padding-left: 23px;
	padding-right: 20px;
	padding-top: 5px;
	padding-bottom: 5px;
}

.qwe123:hover {
	background-image: url('${createLinkTo(dir:' images2/ gif ',file:' gray_bg.gif ')}')
		;
}

.blue {
	background-image: url('${createLinkTo(dir:' images2/ gif ',file:' button_gray.gif ')}')
		;
	padding-left: 30px;
	padding-right: 27px;
	padding-top: 5px;
	padding-bottom: 7px;
}

.blue:hover {
	background-image: url('${createLinkTo(dir:' images2/ gif ',file:' button_blue.gif ')}')
		;
}

span.smallfont {
	color: #ffffff;
	font-weight: bold;
	font-size: 11px;
}
-->
</style>


<g:javascript library="prototype" />
<g:javascript>
function createRow(){
  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'tempDoEdit.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>
<g:javascript>
function createRowFee(){
  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanelFee'},'tempDoEditFee.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>
<g:javascript>
function createRowWaterCon(){
  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanelWaterCon'},'tempDoEditWaterCon.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>
<g:javascript>
function createRowWaterDis(){
  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanelWaterDis'},'tempDoEditWaterDis.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
</g:javascript>
<g:javascript>
function createEffStand(){
  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanelEffluent'},'tempDoEditEffluent.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
function createAirEmmFugitive(){
	try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanelFugitive'},'tempDoEditFugitive.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}

function createAirEmmStack(){
	try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanelStack'},'tempDoEditStack.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}
function createAirEmmFuel(){
	try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanelFuel'},'tempDoEditFuel.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}

function waterSource()
 {
       new Ajax.Updater("updateWaterSource",
          "<%=request.getContextPath()%>/indApplicationDetails/updateWaterSource",
          {method:'get', parameters: {selectedValue : '1'} }
         );
 }
</g:javascript>






<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>
<Script Language=JavaScript>
	function getStats(control){
		var fName = control.value;
		// alert(control.name);
		var hContName = control.name+"extn";
		// alert(hContName);
		var hCont = document.getElementsByName(hContName);
		// alert('size '+hCont)
		fullName = fName;
		shortName = fullName.match(/[^\/\\.]+$/);
		//document.forms.Form1.dispName.value = shortName
		// alert(shortName);
		var a = hCont[0];
		a.value = shortName;
		//alert(a.value);
	}
</Script>
</head>
<body>
<g:form id="general" name="general" method="post" enctype="multipart/form-data" action="saveDocs" onsubmit="return sfuSubmitForm(this);">
<table  width="95%" cellpadding="1" cellspacing="1">
	<tr bgcolor="#A8DAF3">

		<td  align="center" class="headngblue">Enclosure Applicable For</td>
		<td  align="center" class="headngblue">Enclosure Name</td>
		<td  align="center" class="headngblue">Enclosure Path</td>

	</tr>
	<%  System.out.println("docList page.11...--"+docList)%>
	<%for(int i=0;i<docList.size();i++) {%>
	
	
	<%  System.out.println("docList page....--"+docList.applicationFor)%>
	<tr bgcolor="#E8F6F9">
		<td align="right" class="headngblue"><%=(docList.get(i)).applicationFor%></td>
		<td align="right" class="headngblue"><%=(docList.get(i)).documentType%></td>
		<td align="center" class="headngblue"><span class="style30">
		<input type="file" name="<%=(docList.get(i)).document%>" onChange="getStats(this)"/><input type="hidden" name="<%=(docList.get(i)).document+"extn"%>"/></td>

	</tr>
	
	<%}%>
	
	<tr bgcolor="#E8F6F9">
		<td align="center" colspan="3" class="headngblue"><input type="hidden" name="indAppId" value="<%=appDetId%>"/><input type="submit" name="Save" value="Save" class="actionbutton"></td>
	</tr> 
     
	</table>
	</g:form>
	
	<table  width="95%" cellpadding="1" cellspacing="1">
	  <tr><td>
      <FONT SIZE="3" FACE="courier" COLOR=red><MARQUEE WIDTH=100% BEHAVIOR=left onmouseover="this.stop();" onmouseout="this.start();" >It is mandatory to upload all the required documents if user fails to upload required documents then the application might be rejected. </MARQUEE></FONT> 
 
      </td></tr>
	</table>
	
	<g:form name="myForm" method="post" enctype="multipart/form-data" action="deleteDocs">
	<table  width="95%" cellpadding="1" cellspacing="1">
	 <tr bgcolor="#D1D1D1">
		<td colspan="3" align="center" valign="middle" class="headngblue">Uploaded Documents Details</td>
		</tr>															
		<g:each var="doc" in="${uploadedDocList}">
		<tr>
			<td  width="40%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">${doc.level}</td>
			<td width="30%" align="center" bgcolor="#E8F6F9" class="headngblue">
			<g:def var="fooVar" value="${appDetId}"/>
			<g:def var="docN" value="${doc.level}"/>
			<g:link action="viewFile1" params="[appliLoc:fooVar,docName:docN,docType:'pdf']" >Download</g:link></td>
			<td width="30%" align="center" bgcolor="#E8F6F9" class="headngblue">
			<input type="checkbox" name="delete" value="<%=doc.id%>" /><br>
			</tr>
		</g:each>
		
<tr bgcolor="#E8F6F9">
<td align="center" colspan="3" class="headngblue"><input type="hidden" name="indAppId" value="<%=appDetId%>"/><input type="submit" name="Delete" value="Delete" class="actionbutton"></td>
	</tr>		
</table>
<div align="left" class="txt" style="color: navy">
	  <br>
	   <hr><b>*Instructions:</b> Please follow below steps to Upload the enclosures<br><br>
	  	a) Attachment with file type <b>pdf,jpeg, jpg, gif and bmp</b> are allowed.<br>
		b) Size of each file should not be more than 5MB. <hr>
</div>
</g:form>
<script language="JavaScript" type="text/javascript">

 var frmvalidator  = new Validator("general");
 frmvalidator.EnableFocusOnError(false); 
 frmvalidator.EnableMsgsTogether();
 
 
 function Checkfiles()
 {	
    var frm = document.forms["general"];
    <%for(int x=0;x<docList.size();x++){%>
    var fupp = document.getElementsByName('<%=(docList.get(x)).document%>');
    var fup = fupp[0];
    var fileName = fup.value;
    var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
   
    if(ext != "pdf" && ext != "jpg" && ext != "bmp" &&  fileName !="" ){
        alert("Please upload non-editable files only (.jpg,.pdf,.bmp)");
  	 	return false;
  	}
    <%}%>
    return true;
	
  }

frmvalidator.setAddnlValidationFunction("Checkfiles");
</script>
</body>
