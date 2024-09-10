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
<g:form id="general" name="general" method="post" enctype="multipart/form-data" action="deleteDocs" onsubmit="return sfuSubmitForm(this);">
<table  width="100%" cellpadding="1" cellspacing="1">


	
	
	<tr bgcolor="#417FB2">
	<td align="center"  colspan="3" class="headngblue">
	<span style="color: white"> Delete Saved Documents </span>
	
	</tr>
	 <g:each in="${listDoc}" status="i" var="feeDetailsListInst">
  <tr align="left" bgcolor="#A8DAF3" >
  <td colspan="2" bgcolor="#E8F6F9"><span class="txt">${feeDetailsListInst.level}
                        </span></td>
  					
                        <td colspan="2" bgcolor="#E8F6F9"><span class="txt style6">
                        
                        <input type="checkbox" name="delete" value="<%=feeDetailsListInst.id%>"/>
                        </span></td>
                         
                              
        </tr>		
      </g:each>	
	
	
	<tr bgcolor="#E8F6F9">
		<td align="center" colspan="3" class="headngblue">
		
		<input type="hidden" name="indAppId" value="<%=appDetId%>"/>
		
		<input type="submit" name="Delete" value="Delete" class="actionbutton">
		
		
		
		</td>
	</tr>


	
	



</table>
<div align="left" class="txt" style="color: navy">
	  <br>
	   <hr><b>*Instructions:</b> Please follow below steps to Upload the documents<br><br>
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
