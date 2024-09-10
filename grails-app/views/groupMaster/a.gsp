<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>
<link rel="stylesheet" type="text/css" href="/OCMMS/css/main.css" />
<link rel="stylesheet" type="text/css" href="/OCMMS/css/anylinkmenu.css" />
<link rel="stylesheet" type="text/css" href="/OCMMS/css/tabcontent.css" />
<link rel="stylesheet" type="text/css" href="/OCMMS/css/stylesheet.css" />
<link rel="stylesheet" type="text/css" href="/OCMMS/css/style.css" />
<script type="text/javascript" src="/OCMMS/js/menucontents.js" ></script>
<script type="text/javascript" src="/OCMMS/js/anylinkmenu.js" ></script>
<script type="text/javascript" src="/OCMMS/js/tabcontent.js" ></script>
<script type="text/javascript" src="/OCMMS/js/gen_validatorv31.js"></script>

<link rel="stylesheet" type="text/css" href="/OCMMS/css/design.css" />
<script type="text/javascript" src="/OCMMS/js/tabs.js"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow-x:hidden; 
	overflow-y:auto;
}
.style3 {color: #186DB5}
.style5 {color: #0099FF}
.style6 {color: #33FF66; }
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

.qwe123{
background-image: url('/OCMMS/images2/gif/blue_bg.gif');
padding-left:23px;
padding-right:20px;
padding-top:5px;
padding-bottom:5px;

}

.qwe123:hover{
background-image: url('/OCMMS/images2/gif/gray_bg.gif');
}

.blue{
background-image: url('/OCMMS/images2/gif/button_gray.gif');
padding-left:30px;
padding-right:27px;
padding-top:5px;
padding-bottom:7px;
}
.blue:hover{
background-image: url('/OCMMS/images2/gif/button_blue.gif');
}
span.smallfont {color:#ffffff;font-weight:bold;font-size:11px;}


-->
</style>


<script type="text/javascript" src="/OCMMS/js/prototype/prototype.js"></script>

<script type="text/javascript">

function createRow(){
  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'tempDoEdit.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}

</script>

<script type="text/javascript">

function createRowFee(){
  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanelFee'},'tempDoEditFee.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}

</script>

<script type="text/javascript">

function createRowWaterCon(){
  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanelWaterCon'},'tempDoEditWaterCon.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}

</script>

<script type="text/javascript">

function createRowWaterDis(){
  try{
      var oAjax=new Ajax.Updater({success: 'AjaxPanelWaterDis'},'tempDoEditWaterDis.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}

</script>

<script type="text/javascript">

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
          "/OCMMS/indApplicationDetails/updateWaterSource",
          {method:'get', parameters: {selectedValue : '1'} }
         );
 }

</script>

<script type="text/javascript">


function Calculate()
{	
	alert('HIiiii')
	

	
	var contype;
	var conFor;
	var consent;
	
	if(document.getElementById('consentTypeY').checked==true)
	{
	contype=document.getElementById('consentTypeY').value;
	}
	else
	{
	contype=document.getElementById('consentTypeN').value;
	}

	
	if(document.getElementById('consentForY').checked==true)
	{
	conFor=document.getElementById('consentForY').value;
	}
	else
	{
	if(document.getElementById('consentForB').checked==true)
	{
	conFor=document.getElementById('consentForB').value;
	}
	else
	{
	conFor=document.getElementById('consentForN').value;
	}
	}
	
	
	if(document.getElementById('consentY').checked==true)
	{
	consent=document.getElementById('consentY').value;
	}
	else
	{
	consent=document.getElementById('consentN').value;
	}
	
	
	
	var capitalInvestMent; 
	capitalInvestMent=document.getElementById('capital').value;
	
	var result;
	
	var ValidationRequired;
	ValidationRequired="/^.*(?=.*[0-9]).*$/";
	if(capitalInvestMent=="")
	{
		alert("Please give the Amount.");
		return false;
	}
	else
	{
		
	if(contype=="CTE")
	{	
	
	if(consent=="NEW")
    			{
    			
    			if(conFor=="AIR")	
    				{
    				
    					if(capitalInvestMent>10000000000)
    							{
    							
    								result=1000000*2;
    							}
    						if(capitalInvestMent>5000000000 && capitalInvestMent <= 10000000000)
    							{
    							
    								result=500000*2;
    							}
    						if(capitalInvestMent>2000000000 && capitalInvestMent <= 5000000000)
    							{
    							
    								result=250000*2;
    							}
    						if(capitalInvestMent>1000000000 && capitalInvestMent <= 2000000000)
    							{
    							
    								result=150000*2;
    							}
        		
    						if(capitalInvestMent>500000000 && capitalInvestMent <= 1000000000)
    							{
    							
    								result=100000*2;
    							}
    						if(capitalInvestMent>100000000 && capitalInvestMent <= 500000000)
    							{
    							
    								result=80000*2;
    							}
    						if(capitalInvestMent>30000000 && capitalInvestMent <= 100000000)
    							{
    							
    								result=60000*2;
    							}
    						if(capitalInvestMent>20000000 && capitalInvestMent <= 30000000)
    							{
    							
    								result=3000*2;
    							}
    						if(capitalInvestMent>10000000 && capitalInvestMent <= 20000000)
    							{
    							
    								result=2000*2;
    							}
    						if(capitalInvestMent<=10000000)
    							{
    							
    								result=1000*2;
    							}
    			
    					}
    				if(conFor=="WATER")
    					{
    					
    						if(capitalInvestMent>10000000000)
    							{
    							
    								result=1000000;
    							}
    						if(capitalInvestMent>5000000000 && capitalInvestMent <= 10000000000)
    							{
    							
    								result=500000;
    							}
    						if(capitalInvestMent>2000000000 && capitalInvestMent <= 5000000000)
    							{
    							
    								result=250000;
    							}
    						if(capitalInvestMent>1000000000 && capitalInvestMent <= 2000000000)
    							{
    							
    								result=150000;
    							}
    		
    						if(capitalInvestMent>500000000 && capitalInvestMent <= 1000000000)
    							{
    						
    								result=100000;
    							}
    						if(capitalInvestMent>100000000 && capitalInvestMent <= 500000000)
    							{
    							
    								result=80000;
    							}
    						if(capitalInvestMent>30000000 && capitalInvestMent <= 100000000)
    							{
    							
    								result=60000;
    							}
    						if(capitalInvestMent>20000000 && capitalInvestMent <= 30000000)
    							{
    							
    								result=3000;
    							}
    						if(capitalInvestMent>10000000 && capitalInvestMent <= 20000000)
    							{
    							
    								result=2000;
    							}
    						if(capitalInvestMent<=10000000)
    							{
    							
    								result=1000;
    							}
    		
    					}
    					if(conFor=="BOTH")	
    					{
    				
    					if(capitalInvestMent>10000000000)
    							{
    							
    								result=1000000*2+1000000;
    							}
    						if(capitalInvestMent>5000000000 && capitalInvestMent <= 10000000000)
    							{
    							
    								result=500000*2+500000;
    							}
    						if(capitalInvestMent>2000000000 && capitalInvestMent <= 5000000000)
    							{
    							
    								result=250000*2+250000;
    							}
    						if(capitalInvestMent>1000000000 && capitalInvestMent <= 2000000000)
    							{
    							
    								result=150000*2+150000;
    							}
        		
    						if(capitalInvestMent>500000000 && capitalInvestMent <= 1000000000)
    							{
    							
    								result=100000*2+100000;
    							}
    						if(capitalInvestMent>100000000 && capitalInvestMent <= 500000000)
    							{
    							
    								result=80000*2+80000;
    							}
    						if(capitalInvestMent>30000000 && capitalInvestMent <= 100000000)
    							{
    							
    								result=60000*2+60000;
    							}
    						if(capitalInvestMent>20000000 && capitalInvestMent <= 30000000)
    							{
    							
    								result=3000*2+3000;
    							}
    						if(capitalInvestMent>10000000 && capitalInvestMent <= 20000000)
    							{
    							
    								result=2000*2+2000;
    							}
    						if(capitalInvestMent<=10000000)
    							{
    							
    								result=1000*2+1000;
    							}
    			
    					}
    				}else
    						{
			    				alert("CTE is Applicable For New");
			    				document.getElementById('feeApplicable').value="";
			    				return false;
	    					}
    		}
    			
    		
    		else
    			{
    			if(consent=="NEW")
    			{
    			result=0;
    			}else
    			{
    			if(conFor=="AIR")
    			{
    				if(capitalInvestMent>10000000000)
					{
						result=250000*2;
					}
				if(capitalInvestMent>5000000000 && capitalInvestMent <= 10000000000)
					{
						result=150000*2;
					}
				if(capitalInvestMent>2000000000 && capitalInvestMent <= 5000000000)
					{
						result=100000*2;
					}
				if(capitalInvestMent>1000000000 && capitalInvestMent <= 2000000000)
					{
						result=75000*2;
					}
    		
				if(capitalInvestMent>500000000 && capitalInvestMent <= 1000000000)
					{
						result=50000*2;
					}
				if(capitalInvestMent>100000000 && capitalInvestMent <= 500000000)
					{
						result=35000*2;
					}
				if(capitalInvestMent>30000000 && capitalInvestMent <= 100000000)
					{
						result=25000*2;
					}
				if(capitalInvestMent>20000000 && capitalInvestMent <= 30000000)
					{
						result=2000*2;
					}
				if(capitalInvestMent>10000000 && capitalInvestMent <= 20000000)
					{
						result=1000*2;
					}
				if(capitalInvestMent<=10000000)
					{
						result=500*2;
					}
    		
    			}
    			
    			if(conFor=="WATER")
    			{
    			
    				if(capitalInvestMent>10000000000)
    					{
    						result=250000;
    					}
    				if(capitalInvestMent>5000000000 && capitalInvestMent  <= 10000000000)
    					{
    						result=150000;
    					}
    				if(capitalInvestMent>2000000000 && capitalInvestMent  <= 5000000000)
    					{
    						result=100000;
    					}
    				if(capitalInvestMent>1000000000 && capitalInvestMent  <= 2000000000)
    					{
    						result=75000;
    					}
        		
    				if(capitalInvestMent>500000000 && capitalInvestMent  <= 1000000000)
    					{
    						result=50000;
    					}
    				if(capitalInvestMent>100000000 && capitalInvestMent  <= 500000000)
    					{
    						result=35000;
    					}
    				if(capitalInvestMent>30000000 && capitalInvestMent  <= 100000000)
    					{
    						result=25000;
    					}
    				if(capitalInvestMent>20000000 && capitalInvestMent  <= 30000000)
    					{
    						result=2000;
    					}
    				if(capitalInvestMent>10000000 && capitalInvestMent <= 20000000)
    					{
    						result=1000;
    					}
    				if(capitalInvestMent<=10000000)
    					{
    						result=500;
    					}
        		
    			
    			}
    			if(conFor=="BOTH")
    			{
    				if(capitalInvestMent>10000000000)
					{
						result=250000*2+250000;
					}
				if(capitalInvestMent>5000000000 && capitalInvestMent <= 10000000000)
					{
						result=150000*2+150000;
					}
				if(capitalInvestMent>2000000000 && capitalInvestMent <= 5000000000)
					{
						result=100000*2+100000;
					}
				if(capitalInvestMent>1000000000 && capitalInvestMent <= 2000000000)
					{
						result=75000*2+75000;
					}
    		
				if(capitalInvestMent>500000000 && capitalInvestMent <= 1000000000)
					{
						result=50000*2+50000;
					}
				if(capitalInvestMent>100000000 && capitalInvestMent <= 500000000)
					{
						result=35000*2+35000;
					}
				if(capitalInvestMent>30000000 && capitalInvestMent <= 100000000)
					{
						result=25000*2+25000;
					}
				if(capitalInvestMent>20000000 && capitalInvestMent <= 30000000)
					{
						result=2000*2+2000;
					}
				if(capitalInvestMent>10000000 && capitalInvestMent <= 20000000)
					{
						result=1000*2+1000;
					}
				if(capitalInvestMent<=10000000)
					{
						result=500*2+500;
					}
    		
    			}
    			}
    		}

	document.getElementById('feeApplicable').value=result
	return true;

}}

</script>
<script language=javascript type='text/javascript'> 
function popitup(url) {
	newwindow=window.open(url,'name','height=200px,width=500px');
	if (window.focus) {newwindow.focus()
	}
	return false;
}


function hidediv() { 
if (document.getElementById) { // DOM3 = IE5, NS6 
document.getElementById('hideShow').style.visibility = 'hidden'; 
} 
else { 
if (document.layers) { // Netscape 4 
document.hideShow.visibility = 'hidden'; 
} 
else { // IE 4 
document.all.hideShow.style.visibility = 'hidden'; 
} 
} 
} 

function showdiv() { 
if (document.getElementById) { // DOM3 = IE5, NS6 
document.getElementById('hideShow').style.visibility = 'visible'; 
} 
else { 
if (document.layers) { // Netscape 4 
document.hideShow.visibility = 'visible'; 
} 
else { // IE 4 
document.all.hideShow.style.visibility = 'visible'; 
} 
} 
} 
</script> 





<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>
</head>

<body >
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="91" align="left" valign="top" class="bgtop">
		<!-- code for spcbHeader  -->
		<table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="707" align="left" valign="top"><img src="/OCMMS/images2/gif/logo.gif" alt="Online Consent Management System" width="707" height="91" /></td>
            <td width="296" align="left" valign="top"><table width="296" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="61" height="91" valign="top">&nbsp;</td>
                <td width="229" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td align="left" valign="top"><table width="229" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="9" valign="top"><img src="/OCMMS/images2/gif/left_corner.gif" width="9" height="24" /></td>
                        <td width="211" valign="top" bgcolor="#50A4C8"><table width="211" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="31"><img src="/OCMMS/images2/gif/gtalk.gif" width="24" height="16" /></td>
                            <td width="44"><a href="#" class="gtalk"><span class="top-lnks">eTalk</span></a></td>
                            <td width="17">&nbsp;</td>
                            <td width="16"><img src="/OCMMS/images2/gif/contact.gif" width="14" height="14" /></td>
                            <td width="49"><a href="#" class="gtalk"><span class="top-lnks">Contact</span></a></td>
                            <td width="12">&nbsp;</td>
                            <td width="22"><img src="/OCMMS/images2/gif/email.gif" width="16" height="16" /></td>
                            <td width="20"><a href="#" class="gtalk"><span class="top-lnks">Email</span></a></td>
                          </tr>
                        </table></td>
                        <td width="9" valign="top"><img src="/OCMMS/images2/gif/right_corner.gif" width="9" height="24" /></td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="5" align="left" valign="top"></td>
                  </tr>
                  <tr>
                    <td align="right" valign="top"><img src="/OCMMS/images2/gif/tree.gif" width="60" height="62" /></td>
                  </tr>
                </table></td>
                <td width="6" valign="top">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
        </table>
		</td>
      </tr>
      <tr>
        <td height="32" align="left" valign="top" background="/OCMMS/images2/gif/button_BG.gif" >
		<!-- code for menuIndustryHorizontal-->
		<table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
        <td height="32" align="center" valign="middle" ><a href="/OCMMS/indUser/openIndustryHome"><span class="top-lnks">Home</span></a></td>
            
		<td width="2" align="left" valign="top" background="/OCMMS/images2/gif/button_spacer.gif"></td>
        <td align="center" valign="middle"><a href="#" ><span class="top-lnks">Consent Management</span></a></td>
            
		<td width="1" align="left" valign="top" background="/OCMMS/images2/gif/button_spacer.gif"></td>
		<td align="center" valign="middle" ><span class="top-lnks">Laboratory Management</span></td>
           
	   <td width="1" align="center" valign="top" background="/OCMMS/images2/gif/button_spacer.gif"></td>
		<td align="center" valign="middle" ><a href="#" ><span class="top-lnks">Hazardous Waste</span></a></td>
           
	   <td width="1" align="center" valign="top" background="/OCMMS/images2/gif/button_spacer.gif"></td>
		<td align="center" valign="middle" ><a href="#" ><span class="top-lnks">CESS Management</span></a></td>
           
	   <td width="2" align="center" valign="top" background="/OCMMS/images2/gif/button_spacer.gif"></td>
		<td align="center" valign="middle" ><a href="#" ><span class="top-lnks">Knowledge Base</span></a></td>
           
	   <!--<td width="2" align="center" valign="top" background="/OCMMS/images2/gif/button_spacer.gif"></td>
		<td align="center" valign="middle" ><a href="#" class="menuanchorclass" rel="anylinkmenu10"><span class="top-lnks"><span class="top-lnks">Change Password</span></a></td>
        
	   <td width="2" align="center" valign="middle" background="/OCMMS/images2/gif/button_spacer.gif"></td>
		<td align="center" valign="middle" ><a href="#"><span class="top-lnks">Feedback/Query</span></a></td>
        
	<td width="2" align="center" valign="middle" background="/OCMMS/images2/gif/button_spacer.gif"></td>
            <td align="center" valign="middle" ><a href="#"><span class="top-lnks">Public Grievance</span></a></td>-->
        
		<td width="2" align="center" valign="middle" background="/OCMMS/images2/gif/button_spacer.gif"></td>
        <td align="center" valign="middle" ><a href="/OCMMS/userMaster/logout"><span class="top-lnks">Logout</span></a></td>
		<td width="2" align="center" valign="middle" background="/OCMMS/images2/gif/button_spacer.gif"></td>
        
		  </tr>
        </table>

		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuSpcbUser-->
			<head>

<script type="text/javascript">

var consentManagement={divclass:'anylinkmenu', inlinestyle:'', linktarget:''} 
consentManagement.items=[
	["Apply For Concent", "#"]
]

var labManagement={divclass:'anylinkmenu', inlinestyle:'', linktarget:''} 
labManagement.items=[
	["Test Report", "#"]
]

var user_management_link={divclass:'anylinkmenu', inlinestyle:'', linktarget:''} 
user_management_link.items=[
	["User Profile Manage", "/OCMMS/userProfile/create"],
	["Role Management", "/OCMMS/roleMaster/create"],
	["Search SPCB User", "#"]
]

var master_data_link={divclass:'anylinkmenu', inlinestyle:'', linktarget:''} 
master_data_link.items=[
	["Office Administration", "/OCMMS/officeMaster/create"],                    
	["District Administration", "/OCMMS/districtMaster/create"],
	["Tehsil Administration", "/OCMMS/tehsilMaster/create"],
	["Group Administration", "/OCMMS/groupMaster/create"],
	["Attach/Remove District from Group", "/OCMMS/groupDistrictMaster/testOm"]
]

var manage_industry_link={divclass:'anylinkmenu', inlinestyle:'', linktarget:''} 
manage_industry_link.items=[
	["Industry Registration", "/OCMMS/industryRegMaster/create"],                    
	["Industry Profile", "/OCMMS/industryRegMaster/list"]	 
] 

var change_password_link={divclass:'anylinkmenu', inlinestyle:'', linktarget:''} 
change_password_link.items=[
	["SPCB User", "/OCMMS/userMaster/changePassword"],                    
	["Industry User", "/OCMMS/industryRegMaster/changePassword"]	 
]
</script>
</head>



<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="31" valign="top"><table width="224" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="6" align="left" valign="top"><img src="/OCMMS/images2/gif/left_nav.gif" width="6" height="31" /></td>
                    <td width="218" height="31" align="left" valign="middle" background="/OCMMS/images2/gif/left_midlle.gif"><table width="218" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="11" align="left" valign="middle"><img src="/OCMMS/images2/gif/bullet.gif" width="11" height="10" /></td>
                        <td><!--<a href="#" ><span class="leftlink">Apply For Concent</span></a>-->			
                        <!--<a href="/OCMMS/indApplicationDetails/doEdit"><span class="leftlink">Apply For Consent</span></a>-->
                             <a href="/OCMMS/indApplicationDetails/applyConsent"><span class="leftlink">Apply For Consent</span></a>
						</td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
             
			 
			 
	
	
	
		  
			  
			  
			  
			  
			   <tr>
                <td height="3" valign="top"></td>
              </tr>
			  
			  
              <tr>
                <td valign="top"><table width="224" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="6" align="left" valign="top"><img src="/OCMMS/images2/gif/left_nav.gif" width="6" height="31" /></td>
                    <td width="218" height="31" align="left" valign="middle" background="/OCMMS/images2/gif/left_midlle.gif" ><table width="218" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="11" align="left" valign="middle"><img src="/OCMMS/images2/gif/bullet.gif" width="11" height="10" /></td>
                        <td>
						<!--<a href="#" ><span class="leftlink">Industry Profile</span></a>-->
						<a href="/OCMMS/industryRegMaster/showForIndustry"><span class="leftlink">Industry Profile</span></a>
						
						</td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  <tr>
                <td height="3" valign="top"></td>
              </tr>
			  
			  
              <tr>
                <td valign="top"><table width="224" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="6" align="left" valign="top"><img src="/OCMMS/images2/gif/left_nav.gif" width="6" height="31" /></td>
                    <td width="218" height="31" align="left" valign="middle" background="/OCMMS/images2/gif/left_midlle.gif" ><table width="218" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="11" align="left" valign="middle"><img src="/OCMMS/images2/gif/bullet.gif" width="11" height="10" /></td>
                        <td><!--<a href="#" ><span class="leftlink">Change Password</span></a>-->
                        <a href="/OCMMS/industryRegMaster/changePassword"><span class="leftlink">Change Password</span></a>
						</td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
			  
			  
			  
			  
			  
			  
			  
			
			  
			  
			  
              <tr>
                <td height="3" valign="top"></td>
              </tr>
			  
			  
			  
              <tr>
                <td valign="top"><table width="224" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="6" align="left" valign="top"><img src="/OCMMS/images2/gif/left_nav.gif" width="6" height="31" /></td>
                    <td width="218" height="31" align="left" valign="middle" background="/OCMMS/images2/gif/left_midlle.gif" ><table width="218" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="11" align="left" valign="middle"><img src="/OCMMS/images2/gif/bullet.gif" width="11" height="10" /></td>
                        <td><!--<a href="#" class="leftlink">Fee Calculator</a>-->
                        	<a href="/OCMMS/roleProfileAssignment/feeCalculator"><span class="leftlink">Fee Calculator</span></a>
                        </td>
                      </tr>
					  
					  <tr>
               			 <td height="3" valign="top"></td>
             		 </tr>
                    </table></td>
                  </tr>
				  
                </table></td>
              </tr>

			  <!--<tr>
                <td height="150" align="left" valign="middle" bgcolor="#E8F1F3" class="pollution">The Pollution Control Board has<br />
                  been established as a regulatory
                  authority for implementing variious pollution
                  control laws. <span class="pollution2">The board is committed to provide polloution free environment to the people of state. The Board has undertaken various studies of underground water, solil and air to take remedial steps to control pollution.</span></td>
              </tr>-->

              <tr>
                <td valign="top"><img src="/OCMMS/images2/gif/feedback.gif" width="224" height="64" /></td>
              </tr>
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td valign="top"><img src="/OCMMS/images2/gif/query.gif" width="224" height="64" /></td>
              </tr>
              <tr>
                <td valign="top"><img src="/OCMMS/images2/gif/grad.gif" width="224" height="296" /></td>
              </tr>
            </table>

</body>
			</td>
            <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td><img src="/OCMMS/images2/img.jpg" width="778" height="134" /></td>
              </tr>
              <tr>
                <td height="24" bgcolor="#EEEEF3">&nbsp;</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">&nbsp;</span></div></td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="30" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		 
		 
		<form action="/OCMMS/indApplicationDetails/saveNew" enctype="multipart/form-data" method="post" name="general" id="general" >
                <input type="hidden" id='regMasId' name="regMasId" value="1177" />
				<input type="hidden" id='indAppDetId' name="indAppDetId" value="3420" /> 
				
				
				
		<table width="720"  border="0" align="center" cellpadding="0" cellspacing="0"  >
				<tr valign="middle" width="100%">
                  <td  width="100%" align="left" >
				  	
					<ol id="toc">
						<li><a href="#country1"><span>Industry</span></a></li>
						<li><a href="#country8"><span>Occupier</span></a></li>
						<li><a href="#country2"><span>Product</span></a></li>
						<li><a href="#country3"><span>Fee</span></a></li>
						<li><a href="#country4" title="Water Emission/Discharge"><span>W Emiss./Disch.</span></a></li>
						<!-- <li><a href="#country5"><span>Effluent Stand.</span></a></li> -->
						<li><a href="#country6"><span>Air Emission</span></a></li>
						<li><a href="#country7"><span>Documents</span></a></li>
						
					</ol>
				  

				  </td>
				</tr>		
	    </table>
		
		
		
		
				
				
          <div class="content" id="country1" >
		  
		  
		  
		  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			
			
			
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
				<!-- <tr bgcolor="#D1D1D1">
					<td colspan="2"  align="center" valign="middle"  class="headngblue">General Details </td>
				</tr> 
				 
				<tr>
					<td width="35%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Consent Type*:</td>
					<td width="65%" align="left" bgcolor="#E8F6F9"  class="headngblue">
							<input  name="radiobutton1" type="radio" value="CTE" checked="checked" >
                                <span class="style3">CTE</span> 
                                <input  name="radiobutton1" type="radio" value="CTO"  >
                                <span class="style3">CTO</span>
					</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Consent For*:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
							<input type="radio" name="consent" id="consent" value="air" checked="checked"> 
                                <span class="style3">Air</span>
                                <input type="radio" name="consent" id="consent" value="water" > 
								<span class="style3">Water</span>
								<input type="radio" name="consent" id="consent" value="both" > 
								<span class="style3">Both</span>
					</td>
				</tr>  
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Consent Type*:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
						<input type="radio" name="appFor" id="consent" value="new" >
                                <span class="style3">New</span>                              
                                 <input type="radio" name="appFor" id="consent" value="reNew" >
                                <span class="style3">Renew</span> </span>
					</td>
				</tr> 
				-->
				<tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
						<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Industry Details </span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"><a href="popupex.html" onclick="return popitup('instruction.gsp')"><img  src="/OCMMS/images/Help.gif" border="0" align="center" alt="help" ></a></td>
						</tr>
					</table>
					</td>
				</tr>  
				
				<tr>
					<td  width="35%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Name*:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt">
					  <input name="indName" type="text" value="XYZ industries" size="30" class="txt4"/> &nbsp;<span class="sidetxt">(industry name max 100 char)</span>
					</span></td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Category:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><div align="left" class="style6"><span class="txt style6">
                      <select name="category.id" class="txt4" id="category.id" >
<option value="1" selected="selected" >RED</option>
<option value="2" >GREEN</option>
<option value="3" >ORANGE</option>
</select>
                    &nbsp;<span class="sidetxt">(category e.g. red/orange/green)</span></span></div></td>
				</tr>        
					  
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Status:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="style6"><span class="txt style6">
					  <input type="text" class="txt4" id="indStatus" name="indStatus" value="operational"/>
                    &nbsp;<span class="sidetxt">(e.g. operational/proposed/closed)</span></span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Commisioning Year:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" name="dateOfComm" value="1999" />
					&nbsp;<span class="sidetxt">(e.g. 2002)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Registeration/License No.:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indRegNum" name="indRegNum" value="123DER33"/>
					&nbsp;<span class="sidetxt">(reg/license no of industry)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capital Investment*: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indCapInvt" name="indCapInvt" value="1234567" />
					&nbsp;<span class="sidetxt">(capital investment of industry)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address*: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					   <input type="text"  class="txt4" id="indAddress" name="indAddress" value="y-rrnmd"/>
					&nbsp;<span class="sidetxt">(address where industry is established)</span></span></td>
				</tr>        
				 
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">City: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="indCity" name="indCity" value="noidaa"/>
					&nbsp;<span class="sidetxt">(city industry address)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Pin: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indPin" name="indPin" value="12345"/>
					&nbsp;<span class="sidetxt">(pin of address locality)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">S.T.D. Code(Phone) :*</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indPhoneCode" name="indPhoneCode" value="342424"/>
					&nbsp;<span class="sidetxt">(std code of phone no)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone No :* </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indPhoneNo" name="indPhoneNo" value="3423424"/>
					&nbsp;<span class="sidetxt">(phone no upto 8 characters)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Code :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indFaxCode" name="indFaxCode" value="234342"/>
					&nbsp;<span class="sidetxt">(std code of fax no)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax No. : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text" class="txt4" id="indFaxNo" name="indFaxNo" value="23424"/>
					&nbsp;<span class="sidetxt">(fax no upto 8 characters)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">E-Mail Address: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					   <input type="text"  class="txt4" id="indEmail" name="indEmail" value="anamika@gmail.com"/>
					&nbsp;<span class="sidetxt">(e.g. info@abc.com)</span></span></td>
				</tr>
				
				
				</table>	  
		
					  
			</td></tr>
			</table>		  
					                  
                     

				
          
          </div>
				
		<div class="content" id="country8" >
		
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			
			
			
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
				<tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
						<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Occupiers Details</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"><a href="popupex.html" onclick="return popitup('instruction.gsp')"><img  src="/OCMMS/images/Help.gif" border="0" align="center" alt="help" ></a></td>
						</tr>
					</table>
					</td>
				</tr>  
				
				<tr>
				<td width="35%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Name:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					<input type="text"  class="txt4" id="occName" name="occName" value="anamika"/>&nbsp;<span class="sidetxt">(name of occupant)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Designation: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					<input type="text"  class="txt4" id="occDesignation" name="occDesignation" value="aa"/>&nbsp;<span class="sidetxt">(designation of occupant)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					<input type="text"  class="txt4" id="occAddress" name="occAddress" value="aaa"/>&nbsp;<span class="sidetxt">(address of occupant)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">City: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="occCity" name="occCity" value="noida"/>
					&nbsp;<span class="sidetxt">(city where occupant live)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Pin: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="occPin" name="occPin" value="345345"/>&nbsp;<span class="sidetxt">(pin of address locality)</span>
					</span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">S.T.D. Code(Phone) :* </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="occPhoneCode" name="occPhoneCode" value="234243"/>
					&nbsp;<span class="sidetxt">(std code of phone no)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Phone No. :*</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					   <input type="text"  class="txt4" id="occPhoneNo" name="occPhoneNo" value="234242"/>
					&nbsp;<span class="sidetxt">(phone no upto 8 characters)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax Code :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="occFaxCode" name="occFaxCode" value="2423423"/>
					&nbsp;<span class="sidetxt">(std code of fax no)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fax No. :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="occFaxNo" name="occFaxNo" value="4242344"/>
					&nbsp;<span class="sidetxt">(fax no upto 8 characters)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Mobile No:</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					   <input type="text"  class="txt4" id="occMobile" name="occMobile" value="99999999999"/>
					&nbsp;<span class="sidetxt">(mobile no upto 12 characters with country code)</span></span></td>
				</tr>        
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Email Address: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					  <input type="text"  class="txt4" id="occEmail" name="occEmail" value="anamika.shrivastava@infogain.com"/>
					&nbsp;<span class="sidetxt">(e.g. info@abc.com)</span></span></td>
				</tr>        
				         
					
				<!--<tr>
					<td colspan="2" bgcolor="#E8F6F9">	
							<table width="100%">
						  		<tr ><td colspan="2">&nbsp;</td></tr>
							  	<tr >
								<td align="center"><input type="submit" name="Next" value="Next" class="actionbutton"></td>
								<td align="center"><input type="submit" name="cancel" value="Cancel" class="actionbutton"></td>
							  </tr>
							</table>
					</td>  
				</tr>	-->  
				</table>	  
		
					  
			</td></tr>
			</table>				
           <br/>
          </div>

          <div class="content" id="country2">
		  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			
			
			
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
				<tr bgcolor="#417FB2">
					<td width="70%" align="center" valign="middle"  class="headngblue"><span style="color: white">Product Details </span></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popProductDetailsAdd/3420', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1');" > <span style="color: white">Add</span> </a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popProductDetailsView/3420', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1');" > <span style="color: white">View</span> </a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popProductDetailsEdit/3420', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1');" > <span style="color: white">Delete</span> </a></td>
				</tr> 
		  </table>
			</td></tr>
			</table>		
		  
		   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b>
			  &nbsp;<ul> 
				<li>click "Add" link to add the product details</li>
				<li>click "View" link to view the product details</li>
				<li>click "Delete" link to delete the product details</li>
				<li>To update the product delete, first delete the product details you want to edit and then add new one.</li>
			  </ul>
		</div>
		<hr>
           <br/>
          </div>
		  <div class="content" id="country3">
		  
		   <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
				<tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
						<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Fee Details</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"><a href="popupex.html" onclick="return popitup('instruction.gsp')"><img  src="/OCMMS/images/Help.gif" border="0" align="center" alt="help" ></a></td>
						</tr>
					</table>
					</td>
				</tr> 
							
				<tr>
					<td width="60%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Category:</td>
					<td width="40%" align="left" bgcolor="#E8F6F9"  class="headngblue">RED</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Capital Investment (In Lakhs):</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">1234567</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Number of Years*: </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6"><input name="yearsApplied" type="text" class="txt4" maxlength="4" size="10" value=""/>
					&nbsp;<span class="sidetxt">(Enter no of yrs)</span></span></td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Fee Applicable (In Rupees): </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					<input id="feeApplicable" name="feeApplicable" readonly  type="text" class="txt4" size="10" /><a href="javascript:{}" onclick="return Calculate();"  class="bulletinside"><b>Calculate</b></a>
					&nbsp;<span class="sidetxt">(auto calculated)</span></span></td>
				</tr> 
				
				<!-- <tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Notifications/Rules Applied </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"></td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Hazardous Waste Rule 1989</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">200.00</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Environment Clearence Rule </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">500.00</td>
				</tr> --> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Outstanding dues from Industry (In Rupees):</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">0.00</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Outstanding amount with Board (In Rupees): </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">0.00</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Total Fee Applied (In Rupees)</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue"><span class="txt style6">
					<input name="totalApplied" type="text" readonly class="txt4" value="16450" size="8" />
					&nbsp;<span class="sidetxt">(DD/Cheque of this amount)</span></span></td>
				</tr> 
				
				<tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
						<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Bank Details</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"><a href="popupex.html" onclick="return popitup('instruction.gsp')"><img  src="/OCMMS/images/Help.gif" border="0" align="center" alt="help" ></a></td>
						</tr>
					</table>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
					<table width="100%" border="0" >
					<tr>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popFeeDetailsAdd/3420', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1');" > Add </a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popFeeDetailsView/3420', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1');" > View </a></td>
					<td width="10%" class="headngblue" align="center"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popFeeDetailsEdit/3420', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1');" > Delete </a></td>					
					</tr>
					</table>
					</td>
				</tr> 
				
				
				
				
		 	 </table>	  
					  
			  
			</td></tr>
			</table>	
      		   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b> <br>
			  Please enter number of year you are applying consent for. To enter the DD/Cheque details, use the link as follows:
			   <br> click "Add" add details, "View" to view details and "Delete" link to delete details. <br>
				To update the details, first delete you want to edit and then add new one.
		</div>
		<hr>    
          </div>
		  

		  
		  
		  <div class="content" id="country4">
		  
		  
           <div class="headngblue" align="center">Not Applicable</div>
           
           
  		   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b> <br>
			  There are three sections under W Emiss./Disch. Please fill all the details pertaining to W Emiss./Disch. To enter the details, use the links as follows:<>
			  &nbsp; 
				<li>click "Add" link to add details</li>
				<li>click "View" link to view details</li>
				<li>click "Delete" link to delete details</li>
				<li>To update the delete, first delete the details you want to edit and then add new one.</li>
			  </ul>
		</div>
		<hr>           
          </div>
		  
		  
		<!--  <div class="content" id="country5">
		  
          	<div class="headngblue" align="center">Not Applicable</div>
          
           <br/>
          </div>   -->
		  
		  
		  <div class="content" id="country6">
		  
             <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr ><td bgcolor="#FFFFFF">
			
			
			<table id="22"  width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
		    <tr bgcolor="#417FB2">
					<td width="70%"   align="center" valign="middle"  class="headngblue"><span style="color: white">Air Emission</span></td>
					<td width="30%" align="center" valign="middle"  class="headngblue"><span style="color: white">Action</span></td> 
			</tr>
			
			<tr >
					<td   align="center" valign="middle"  class="headngblue">Stack Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popAirStackAdd/3420', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popAirStackView/3420', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1');" > View </a></td>
								<td align="center"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popAirStackEdit/3420', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			<!-- 
			<tr >
					<td   align="center" valign="middle"  class="headngblue">Pollutant Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popAirPollutantAdd/3420', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');"> Add </a></td>
								<td align="center"><a href="#"> View </a></td>
								<td align="center"><a href="#"> Edit </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			 -->
			<tr bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Flue Gas Emission Details</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popAirFlueEmmision/3420', 'ApplicationHistory', 'WIDTH=600,HEIGHT=500,scrollbars=1');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popAirFlueEmmisionView/3420', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popAirFlueEmmisionEdit/3420', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			<tr >
					<td   align="center" valign="middle"  class="headngblue">Fugitive Emission</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popAirFugitiveEmmision/3420', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1');"> Add </a></td>
								<td align="center"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popAirFugitiveEmmisionView/3420', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popAirFugitiveEmmisionEdit/3420', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			<tr bgcolor="#A8DAF3">
					<td   align="center" valign="middle"  class="headngblue">Ambient Air Quality Standards</td>
					<td   align="center" valign="middle"  class="headngblue">
							<table width="100%">
							  <tr>
								<td align="center"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popAmbientAirStandardAdd/3420', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1');" > Add </a></td>
								<td align="center"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popAmbientAirStandardView/3420', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1');"> View </a></td>
								<td align="center"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popAmbientAirStandardDelete/3420', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1');" > Delete </a></td>
							  </tr>
							</table>
					</td>
			</tr>
			
			
			  
			</table>
			
	</td></tr>
</table>	
		   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b> <br>
			  There are four sections under Air Emission. Please fill all the details pertaining to Air Emission. To enter the details, use the links as follows:
			  &nbsp;<ul> 
				<li>click "Add" link to add details</li>
				<li>click "View" link to view details</li>
				<li>click "Delete" link to delete details</li>
				<li>To update the delete, first delete the details you want to edit and then add new one.</li>
			  </ul>
		</div>
		<hr>
		  
           <br/>
          
          </div>
		  
		  
		  
		  
		  
		  
		  <div class="content" id="country7">
            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
				
				<tr bgcolor="#417FB2">
					<td colspan="2">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
						<td width="95%" align="center" valign="middle"  class="headngblue"><span style="color: white">Documents Details</span><a href="popupex.html" onclick="return popitup('instruction.gsp')"></td>
						<td  align="right" valign="middle"  class="headngblue"><a href="popupex.html" onclick="return popitup('instruction.gsp')"><img  src="/OCMMS/images/Help.gif" border="0" align="center" alt="help" ></a></td>
						</tr>
					</table>
					</td>
				</tr>
				<tr>
					<!-- <td colspan="4"  align="center" valign="middle"  class="headngblue">Do You Want To Submit Documents Manually ? &nbsp; &nbsp; &nbsp; <input type="radio" name="doc" id="consent" onclick="new Ajax.Updater('docPanel','/OCMMS/indApplicationDetails/docSel',{asynchronous:true,evalScripts:true,parameters:'cont=' + this.value});" value="yes"  checked="checked" />Yes &nbsp;&nbsp;<input type="radio" name="doc" id="consent" onclick="new Ajax.Updater('docPanel','/OCMMS/indApplicationDetails/docSel',{asynchronous:true,evalScripts:true,parameters:'cont=' + this.value});" value="no" />No</td>-->
				<td colspan="4"  align="center" valign="middle"  class="headngblue">Do You Want To Submit Documents Manually ? &nbsp; &nbsp; &nbsp; <input onclick="javascript:hidediv();" type="radio" name="doc" id="consent"  value="yes"   />Yes &nbsp;&nbsp;<input type="radio" name="doc" id="consent"  value="no" onclick="javascript:showdiv();" checked="checked" />No</td>
				</tr> 
				<tr>
				<td colspan="4"><div id="hideShow">
					<table width="100%" cellpadding="0" cellspacing="0">
				<tr bgcolor="#A8DAF3">
					<td width="35%" align="center" class="headngblue" valign="top">Upload Required Documents</td>
					<td width="35%" align="center" class="headngblue" valign="top"><a href="#" onclick="window.open('/OCMMS/indApplicationDetails/popUploadDoc/3420', 'ApplicationHistory', 'WIDTH=400,HEIGHT=300,scrollbars=1');" > Upload </a></td>
				</tr> 
				</table>
				</div></td>
				</tr>
		 	 </table>	  
					  
			  
			</td></tr>
			</table>	
		  	   <div align="left" class="txt" style="color: navy">
			  <br>
			  &nbsp;<b>* Instructions:</b> <br>
			  Please select "Yes" if you want to send the documents By Post/ By Hand and "No" to upload the required document online.<br>For Online Document Upload:
			  &nbsp;<ul> 
				<li>Click link "Upload" to upload the document</li>
				<li>Click "Browse" to select the document</li>
				<li>You can select multiple documents at the same time</li>
				<li>Select all the documents by clicking "Browse" button</li>
				<li>Select all the documents by clicking "Browse" button</li>
				<li>Click "Save" button to upload the document</li>
				<li>Message "Document successfully uploaded" will be displayed</li>
			  </ul>
		</div>
		<hr>
           <br/>
          </div>
		  
		  
		  
		  
		  
		  <!--
		  <div id="country8">
		  
		   <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
			
				<tr bgcolor="#D1D1D1">
					<td colspan="2"  align="center" valign="middle"  class="headngblue">General Details </td>
				</tr> 
				
				<tr>
					<td width="35%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Consent Type*:</td>
					<td width="65%" align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Consent Type*:</td>
					<td align="left" bgcolor="#E8F6F9"  class="headngblue">Value Here</td>
				</tr> 
		 	 </table>	  
					  
			  
			</td></tr>
			</table>	
		  

           <br/>
          </div>  -->
		  
		  
		  
		  <table width="100%" align="center">
				<tr>
				<td align="center" class="txt4">Do You Want To Save The Application as <input name="appStatus" type="radio" value="completed" />  <span class="style3">Completed</span> &nbsp;<input name="appStatus" type="radio" value="inProgress" checked="checked"/>  <span class="style3">In Progress</span>
                                
				
				
				</td>
				
				
				</tr>
				<tr>
				<td colspan="2">&nbsp;</td>
				</tr>
				<tr >
					<td colspan="2" align="center">
						<input type="submit" name="Save" value="Save" class="actionbutton">
						
					</td>
					
			  	</tr>
				<tr>
					<td colspan="2" >&nbsp;</td>
				</tr>
		  </table>
		  
		  
		  </form>
		  
          </div>
	  <div class="box2" id="calculator">
										<!-- <div class="maintext"> -->
											<form action="/OCMMS/indApplicationDetails/index" method="post" name="myform" id="myform" >
												<table width="275" border="0" cellpadding="2" cellspacing="1" bordercolor="#FFFFFF">
													<tr>
														<td width="40%" >
															<div align="left"><span class="style3 style5">Consent Type:</span></div>
														</td>
														<td width="60%" ><span class="style6">
															 <input id="consentTypeY" name="consentType" type="radio" value="CTE" checked="checked" />CTE
															<input  id="consentTypeN" name="consentType" type="radio" value="CTO"  />CTO</span>
														</td>
													</tr>
													<tr>
														<td width="40%" >
															<div align="left"><span class="style3 style5">Consent For:</span></div>
														</td>
														<td width="60%">
															<span class="style6">
																<input id="consentForN" name="consentFor" type="radio" value="AIR" checked="checked"/>Air
																<input id="consentForY" name="consentFor" type="radio" value="WATER"  />Water
																<input id="consentForB" name="consentFor" type="radio" value="BOTH"  />Both
															</span>
														</td>
													</tr>
					
													<tr>
														<td width="40%" ><div align="left"><span class="style3 style5">Consent:</span></div></td>
														<td width="60%" >
															<span class="style6">
																	<input id="consentY" name="consent" type="radio" value="NEW"  />New
																	<input  id="consentN" name="consent" type="radio" value="RENEW"  />Renew
															</span>
														</td>
													</tr>
					
													<tr>
														<td  class="style3" width="40%"><div align="left" class="style5">Capital Investment<span class="txt">(in Lakhs)</span>: </div></td>
														<td width="60%" >
															<input id="capital" name="capital" type="text" class="txt4" size="10" value="1234567">  
														</td>
													</tr>
													<tr>
														<td  width="40%"class="style3"><div align="left" class="style7">Consent Fee: </div></td>
														<td width="60%"class="style3 style7 style5"><input id="result1" size="10" class="txt4" name="result1" type="text" readonly="readonly"></td>
													</tr>
													<tr>
														<td colspan="2" align="right" class="style3 style8">
															 <a href="javascript:{}" onclick="return Calculate();"  class="bulletinside"><b>Calculate</b></a>
														</td>
													</tr>
												</table>
											</form>
										<!-- </div> -->
									</div>
		  

      </div></td>
                            <td width="25" align="left" valign="top">&nbsp;</td>
                          </tr>
                      </table></td>
                    </tr>
                    
                </table></td>
              </tr>
              
            </table></td>
          </tr>
        </table></td>
      </tr>
      <!-- code for spcb Footer -->
	  <tr>
        <td height="1" align="right" valign="middle" bgcolor="#ADBFCB"></td>
      </tr>
      <tr>
        <td height="31" align="right" valign="middle" bgcolor="#E1E3E2"><span class="foot-text">Pollution Control  Board, Copyright &copy; 2009All Rights Reserved NIC India</span></td>
      </tr>
      <tr>
        <td align="right" valign="middle">&nbsp;</td>
</tr>
    </table></td>
  </tr>
</table>

<script language="JavaScript" type="text/javascript">



 var frmvalidator  = new Validator("general");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
 
 frmvalidator.addValidation("indName","req","Please enter Industry Name");
 
 frmvalidator.addValidation("dateOfComm","numeric","year of comissioning must be numeric");

 frmvalidator.addValidation("indEmail","email","Enter valid email");
 
 frmvalidator.addValidation("dateOfComm","maxlen=4","year of comissioning must be 4 digits");
 
 frmvalidator.addValidation("indRegNum","alnum_s","Industry Registration no. must be alphanumeric");
 
 frmvalidator.addValidation("indCapInvt","numeric","Capital investment must be numeric");
 
 frmvalidator.addValidation("indCity","alpha","check city name");
 
 frmvalidator.addValidation("indPin","numeric","Pin number  must be numeric");
 
 frmvalidator.addValidation("indPhoneNo","numeric","Phone number  must be numeric");
 
 frmvalidator.addValidation("indFaxNo","numeric","Fax number  must be numeric");
 
 frmvalidator.addValidation("occName","req","Enter your Name");
 
 frmvalidator.addValidation("occDesignation","req","please enter designation");

 frmvalidator.addValidation("occAddress","req","please enter occupier Address");
 
 frmvalidator.addValidation("occCity","req","please enter City");
 
 frmvalidator.addValidation("occPin","req","please enter PIN");
 frmvalidator.addValidation("occPin","numeric","Pin number  must be numeric");
 
 frmvalidator.addValidation("occPhoneNo","req","please enter Phone number");
 frmvalidator.addValidation("occPhoneNo","numeric","Phone number  must be numeric");
 
 frmvalidator.addValidation("occFaxNo","req","please enter Fax number");
 frmvalidator.addValidation("occFaxNo","numeric","Fax number  must be numeric");
 
 frmvalidator.addValidation("occMobile","req","please enter mobile number");
 frmvalidator.addValidation("occMobile","numeric","Mobile number  must be numeric");
 frmvalidator.addValidation("occMobile","minlen=10","mobile number is not valid");
 frmvalidator.addValidation("occMobile","maxlen=11","mobile number is not valid");
 
 frmvalidator.addValidation("occEmail","email","Enter valid email");
 frmvalidator.addValidation("occEmail","req","please enter email-id");
 
 frmvalidator.addValidation("hintAnswer","req","please enter hint Answer");
 frmvalidator.addValidation("password","req","please press generate button for password");
 
 frmvalidator.addValidation("quantity","req","please enter Quantity");
 frmvalidator.addValidation("quantity","numeric","Quantity must be numeric");
 
  frmvalidator.addValidation("yearsApplied","req","please years Apllied");
</script> 

  <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("general");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
  frmvalidator.addValidation("yearsApplied","req","Please enter years Applied of Consent in Fee tab");
  frmvalidator.addValidation("yearsApplied","numeric","Applied Years of Consent in Fee tab must be numeric");
  frmvalidator.addValidation("feeApplicable","req","please enter fees in Fee Tab");
  frmvalidator.addValidation("feeApplicable","numeric","Fees must be numeric");
  frmvalidator.addValidation("totalApplied","req","please enter total applicable Fee in Fee Tab");
  frmvalidator.addValidation("totalApplied","numeric"," total applicable fees must be numeric");
  </script>
   <!--  
   <script language="JavaScript" type="text/javascript">
	var frmvalidator  = new Validator("general");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("quantity","req","please enter Quantity");
 	frmvalidator.addValidation("quantity","numeric","Quantity must be numeric");
 </script>
 <script language="JavaScript" type="text/javascript">
  var frmvalidator  = new Validator("general");
  frmvalidator.EnableFocusOnError(false); 
  frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("ddNo","req","please enter DD number");
  frmvalidator.addValidation("ddNo","numeric","DD number must be numeric");
  frmvalidator.addValidation("date","req","please enter date");
 
frmvalidator.addValidation("bankName","req","please enter bank name");
  frmvalidator.addValidation("bankName","alnum_s","Enter valid bank name");
  
  frmvalidator.addValidation("branchName","req","please enter branch Name");
  frmvalidator.addValidation("branchName","alnum_s","Enter valid branch name");
  
  frmvalidator.addValidation("ddAmount","req","please enter Amount");
  frmvalidator.addValidation("ddAmount","numeric","DD Amount must be numeric");
 </script>   
 
  <script language="JavaScript" type="text/javascript">
    var frmvalidator  = new Validator("general");
     frmvalidator.EnableFocusOnError(false); 
     frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("conQuantity","req","please enter quantity");
    frmvalidator.addValidation("conQuantity","numeric","quantity must be numeric");
    frmvalidator.addValidation("maxEffGen","req","please enter max effluent generation");
   frmvalidator.addValidation("effRecycle","req","please enter Effluent to be recycled");
    frmvalidator.addValidation("effDisposed","req","please enter effluent to be disposed");
  
 </script> 

  <script language="JavaScript" type="text/javascript">
    var frmvalidator  = new Validator("general");
     frmvalidator.EnableFocusOnError(false); 
     frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("parameterStandard","req","please enter parameter Standard");
    
  
 </script>  

  <script language="JavaScript" type="text/javascript">
    var frmvalidator  = new Validator("general");
     frmvalidator.EnableFocusOnError(false); 
     frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("stackPlant","req","please enter quantity");
  
    frmvalidator.addValidation("sourceCapacity","req","please enter sorce capacity");
   frmvalidator.addValidation("presStand","req","please enterpescribed standards");
   
   
    frmvalidator.addValidation("fuelQuantity","req","please enter fuel quantity");
   frmvalidator.addValidation("fuelCapacity","req","please enter fuel capacity");
   
    frmvalidator.addValidation("sourceFugitiveEmmision","req","please enter Source of fugitive emission");
   frmvalidator.addValidation("fugPresStand","req","please enter pescribed Stds");
 </script>
 
  <script language="JavaScript" type="text/javascript">
    var frmvalidator  = new Validator("general");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
    frmvalidator.addValidation("upfile","req","please upload document");
    frmvalidator.addValidation("ProjectReport","req","please upload Project Report");
  
 </script>
 -->
</body>
</html>
