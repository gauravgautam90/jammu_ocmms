<head>




<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<g:javascript library="prototype" />

<g:javascript>
function callParentWindowFunction()
    {	
    	alert('hello')
        window.opener.hello();
    }

</g:javascript>

<g:javascript>
function createMyRow(){
  try{
      var oAjax=new Ajax.Updater({success: 'myPanel'},'tempWaterTreatmentAdd.gsp', { insertion: Insertion.Bottom });
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


 <g:javascript>
    
function check1()
    {
   
   			var selectmenu1=document.getElementById('fuel').value;

  		
		if(selectmenu1 == "Others")
		{
			document.getElementById('selectTemp').style.display = 'block';
		}
		else{
				document.getElementById('selectTemp').style.display = 'none';
				
		}

       
    }
    
 </g:javascript>











<script type="text/javascript">



</script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
</head>
<body>
<g:form name="waterSourceUses" method="post" action="deleteOfficer" >
<div align="center">
		
			  	</table>
						
				</td></tr>
				<tr>
				<td align="center"><span class="txt" style="color: navy"><b>Visiting Officer.</b></span>
				<div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 					
 					<tr><td><table class="tblbdr">
 					
 					<tr bgcolor="#A8DAF3">
 					     <td width="20%" align="center" valign="middle"  class="headngblue">Sr</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Officer</td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Designation<span style="color:red">*</span></td>
						<td width="20%" align="center" valign="middle"  class="headngblue">Delete</td>
					</tr>
 <g:each in="${listof}" status="i" var="listof">
  <tr align="center" >
  					    
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${++i}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${listof.officerName}</span></td>
                        <td bgcolor="#E8F6F9"><span class="txt style6">
                        ${listof.designation}</span></td>
                        <td  bgcolor="#E8F6F9"><span class="txt style6"><input type="checkbox" name="delete" value="<%=listof.id%>"/>
                        </span></td>
                        </tr>		
    </g:each>
 					
 					
 					
 					
 					
 					</table></td></tr>
						
					
 					<tr>

 				   <td align="center"><input type="hidden" name="appId" value="<%=appDetId%>"/><input type="submit" name="Delete" value="Delete" class="actionbutton"></td>

 				  </tr>
  </table>
	  
  		</div>
				</td>
				</tr>
				</table>
				</div>
				</g:form>
<script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("waterSourceUses");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("consumption","req","please enter Consumption ");
 // frmvalidator.addValidation("use","req","please enter Use");
  frmvalidator.addValidation("quantity","dec","Quantity should be numeric or decimal");
 frmvalidator.addValidation("mscb","req","please enter Minimum sizes of carry bags");
  frmvalidator.addValidation("mscb","dec","Minimum sizes of carry bags  should be numeric or decimal");
  frmvalidator.addValidation("rules","req","please enter Status of compliance ");
  //frmvalidator.addValidation("effDischarge","dec","Effluent Discharged should be numeric");
  
 </script>   
 
			
</body>