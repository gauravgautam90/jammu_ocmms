<head>
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


<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
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
<g:form id="general" name="general" method="post" action="saveconditions">
<table  width="65%" cellpadding="1" cellspacing="1" align = "center">
	<tr bgcolor="#A8DAF3">

		<td  align="center" class="headngblue">Consent For</td>
		<td  align="center" class="headngblue">Condition</td>
		<td  align="center" class="headngblue">Select Values to save</td>

	</tr>
	  <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
<%def instanceScn = ConditionsMaster.findAll("from ConditionsMaster where  consentType='E-Waste'")// satish code; E-Waste spelling change

	
	
	for(int j=0;j<instanceScn.size();j++){%>
	

	
	<tr bgcolor="#E8F6F9">
		<td align="right" class="headngblue"><%=(instanceScn.get(j)).consentType%></td>
		<td align="right" class="headngblue"><%=(instanceScn.get(j)).conditions%></td>
		<td bgcolor="#E8F6F9"><span class="txt style6"><input type="checkbox" name="conditionType" value="<%=(instanceScn.get(j)).conditions%>" />
		</td>

	</tr>
	
	
	
	<%}%>
	
	
	<input type="hidden" name="check" value="<%=check%>"/>
	
	<tr bgcolor="#E8F6F9">
		<td align="center" colspan="3" class="headngblue"><input type="hidden" name="appId" value="<%=appId%>"/><input type="submit" name="Save" value="Save" class="actionbutton"></td>
	</tr>
<tr bgcolor="#417FB2">
	<td align="center"  colspan="3" class="headngblue">
	<span style="color: white"> Saved Documents </span>
	
	</tr>
	
	
	
	
	
	
	<tr bgcolor="#417FB2">
 					<td  align="center"  class="txt" ><span style="color: white">Consent Type</span></td>
                        <td align="center" colspan="2" class="txt" ><span style="color: white">Conditions</span></td>
						
							  
                      </tr>
	
	
	
	<g:each in="${saveconditionsInstance}" status="i" var="saveconditionsInstance">
  <tr align="center" >
 
 <% 
 
 if(check){
 
 checkAir = check
 }
 

 
 def condition = ConditionsMaster.find("from ConditionsMaster where conditions = ? and consentType =?",[(saveconditionsInstance.conditions),checkAir])
 System.out.println("condition...: "+ condition)
 
 if(condition)
 {
 
 if(checkAir == condition.consentType ){
 
  %>
 
 
  <td bgcolor="#E8F6F9"><span class="txt style6">${condition.consentType}
                        </span></td> 
  					<td bgcolor="#E8F6F9" colspan="2" ><span class="txt style6">${condition.conditions}
                        </span></td>
                       
                      
                              
        </tr>		
        
      
        <%}}%>
      </g:each>		



</table>
<div align="center" class="txt" style="color: navy">
	  <br>
	   <hr><b>*Instructions:</b> Please follow below steps to save the conditions<br><br>
	  	a) Select the certificate conditions to save
		 <hr>
</div>
</g:form>
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("general");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("stack","req","Please enter Stack attached to plant");
   frmvalidator.addValidation("pollCntrlMeasure","req","Please enter Pollutin control Equipment");
  frmvalidator.addValidation("heightGrdLevel","req","Please enter Stack Height above Factory Room");
  frmvalidator.addValidation("heightGrdLevel","decimal","Stack height should be numeric or decimal");
  frmvalidator.addValidation("heightGrdLevel","maxlength=10","Stack height should be upto 10 digits");
  frmvalidator.addValidation("heightFacLevel","req","Please enter Stack Height above Ground Level");
  frmvalidator.addValidation("heightFacLevel","decimal","Stack height should be numeric or decimal");
    frmvalidator.addValidation("diameterTopLevel","decimal","Diameter at Top Level should be numeric or decimal");
    frmvalidator.addValidation("pollutantName","decimal","Diameter at Bottom Level should be numeric or decimal");
  
  frmvalidator.addValidation("heightFacLevel","maxlength=10","Stack height should be upto 10 digits");
  frmvalidator.addValidation("capacity","req","Please enter Capacity");
  frmvalidator.addValidation("capacity","decimal","Capacity should be numeric or decimal");
  frmvalidator.addValidation("capacity","maxlength=10","Capacity should be upto 10 digits");
  frmvalidator.addValidation("matOfCon","req","Please enter Material of Construction");
 </script>  
						
						

</body>