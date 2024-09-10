<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>
<calendar:resources lang="en" theme="aqua"/>
		<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />
		
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
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
background-image: url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}');
padding-left:23px;
padding-right:20px;
padding-top:5px;
padding-bottom:5px;

}

.qwe123:hover{
background-image: url('${createLinkTo(dir:'images2/gif',file:'gray_bg.gif')}');
}

.blue{
background-image: url('${createLinkTo(dir:'images2/gif',file:'button_gray.gif')}');
padding-left:30px;
padding-right:27px;
padding-top:5px;
padding-bottom:7px;
}
.blue:hover{
background-image: url('${createLinkTo(dir:'images2/gif',file:'button_blue.gif')}');
}
span.smallfont {color:#ffffff;font-weight:bold;font-size:11px;}


-->
</style>





<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>


<script language="javascript">
function whichButton(event)
{
 if (event.button==2)//For right click
 {
  alert("Right Click Not Allowed!");
 }
}

function noCTRL(e)
{
 var code = (document.all) ? event.keyCode:e.which;
 var msg = "Sorry, this functionality is disabled.";
 if (parseInt(code)==17) // This is the Key code for CTRL key
 {
  
  window.event.returnValue = false;
 }
}


</script>
</head>

<body ondragstart="//return false" onselectstart="//return false" onMouseDown="//whichButton(event)" onKeyDown="//return noCTRL(event)">
<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="91" align="left" valign="top" class="bgtop">
		<!-- code for spcbHeader  -->
		<g:include controller="userMaster" action="showSpcbHeader"/>
		</td>
      </tr>
  
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
           
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="1" valign="top"></td>
              </tr>
               <%	
	boolean decVar=true;
	String firstname;
	String lastName;
	String access;
	String indname;
		
	if((UserMaster)session.getAttribute("userMaster"))
		{ 


              		UserMaster um=(UserMaster)session.getAttribute("userMaster");
    	  		 UserProfile aa=(UserProfile)session.getAttribute("userprof");
             		  firstname=aa.employeeFirstName;
           		  lastName=aa.employeeLastName;
           		  access=um.accessLevel;

		}	

		else
			{
				if(  (IndUser)session.getAttribute("indUser")  )

					{
						IndustryRegMaster ind=(IndustryRegMaster)session.getAttribute("indregName");
            					 indname=ind.indName;

					}	
				else
					{
						decVar=false;
						
					}
			}




						
				
              java.util.Date dateSCR = new java.util.Date();
             	int  year=dateSCR.getYear();
             	 if (year < 1000)
                     year+=1900;
               	int date=dateSCR.getDate();
                int month=(dateSCR.getMonth()) + 1;
               

              %>
              
              <tr>
                <td height="24" bgcolor="#4C8BC0">

	<% if((UserMaster)session.getAttribute("userMaster"))
{
%>


					<table width="100%" bgcolor="#4C8BC0">
						 <tr height="10px" bgcolor="#4C8BC0">
						 	<td class="top-lnks">Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 

<% } 

	if(  (IndUser)session.getAttribute("indUser")  )
		
		{ %>
			
					<table width="100%" >
						 <tr height="10px" bgcolor="#4C8BC0">
						 	<td class="top-lnks">Welcome <%=indname %></td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 
		
		<% } %>
</td>
              </tr>
              
              <tr><td>

</td></tr>


              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">&nbsp;</span></div></td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    
                    <tr>
										<!-- Div area for errors-->
										<td align="center" valign="top">
										&nbsp;
										</td>
									</tr>
                    <tr>
                      <td height="0" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="30" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    
         <div style="border":1px solid ; width:720px; margin-bottom: 1em; padding: 10px" >
		 
		 
		<g:form name="general" method="post" enctype="multipart/form-data" action="bankName" >
               
			<table width="764"  border="0" align="left" cellpadding="0" cellspacing="0"  >
				<tr valign="middle" width="100%">
                  <td  width="100%" align="left" >
				  	
					<ol id="toc">
						<li><a href="#country1"><span>List of Banks</span></a></li>
						
					</ol>
				  

				  </td>
				</tr>		
	    </table>	
			
			
			<div style="border":1px solid ; width:720px; margin-bottom: 1em; padding: 10px" >
			 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
		  <tr><td bgcolor="#FFFFFF">
			
			
			
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
				
			<tr >
				<td  colspan=2 align="center" valign="middle" bgcolor="#4C8BC0" >
<font color = white>Click on your Bank to make payment through NEFT/RTGS.</font>
			</td>
			
				</tr>	
				
				<tr >
				<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.allahabadbank.in/" target="_blank">
Allahabaad Bank</a>
			</td>
			<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.onlinesbi.com/" target="_blank">
State Bank of India</a>
			</td>
				</tr>
				<tr >
				<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.onlinesbp.com/" target="_blank">
State Bank of Patiala</a>
			</td>
			<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://andhrabank.in/" target="_blank">
Andhra Bank</a>
			</td>
	
				</tr>
				
				<tr >
				<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.bankofbaroda.co.in/" target="_blank">
Bank of Baroda</a>
			</td>
			<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.bankofindia.co.in/" target="_blank">
Bank of India</a>
			</td>
				</tr>
				<tr >
				<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
				<a href="https://www.canarabank.in/" target="_blank">
Canara Bank</a>
			</td>
			<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.centralbankofindia.co.in/" target="_blank">
Central Bank of India</a>
			</td>
	
				</tr>
				
			<tr >
				<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.corpbank.com/" target="_blank">
Corporation Bank</a>
			</td>
			<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.denabank.co.in/" target="_blank">
Dena Bank</a>
			</td>
				</tr>
				<tr >
				<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.idbi.com/" target="_blank">
IDBI Bank</a>
			</td>
			<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.indianbank.in/" target="_blank">
Indian Bank</a>
			</td>
	
				</tr>	
				
				
				
				
				<tr >
				<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.iob.in/" target="_blank">
Indian Overseas Bank</a>
			</td>
			<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.obcindia.co.in/" target="_blank">
Oriental Bank of Commerce</a>
			</td>
				</tr>
				<tr >
				<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.pnbindia.com/" target="_blank">
Punjab National Bank</a>
			</td>
			<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.psbindia.com/" target="_blank">
Punjab & Sind Bank</a>
			</td>
	
				</tr>	
				
			<tr >
				<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.syndicatebank.in/" target="_blank">
Syndicate Bank</a>
			</td>
			<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.ucobank.com/" target="_blank">
UCO Bank</a>
			</td>
				</tr>
				<tr >
				<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.unionbankofindia.com/" target="_blank">
Union Bank of India</a>
			</td>
			<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.unitedbankofindia.com/" target="_blank">
United Bank of India</a>
			</td>
	
				</tr>		
				
				
			<tr >
				<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.axisbank.com/" target="_blank">
Axis Bank</a>
			</td>
			<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.hdfcbank.com/" target="_blank">
HDFC Bank</a>
			</td>
				</tr>
				<tr >
				<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.icicibank.com/" target="_blank">
ICICI Bank</a>
			</td>
			<td width="50%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
<a href="https://www.indusind.com/" target="_blank">
IndusInd Bank</a>
			</td>
	
				</tr>		
					
				
				
				
				
	    </table></td></tr>
	    
	    <tr bgcolor="#FFFFFF">
	    <td width="25" align="left" valign="top">&nbsp;</td>
	    </tr>
	    </table>
		</div>
		
	<div style="border":1px solid ; width:720px; margin-bottom: 1em; padding: 10px" >
			
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
				
				<tr>
				<td width="100%" align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">
			
			
<span class="leftlink"><b>If you have already make the payment through NEFT/RTGS,<g:link controller="hazardeousWasteAuthApp" action="applicationVerification"><font > click here </font></g:link>to verify the transaction.</span></div>
			
			
			</td>
				</tr>
		</table></div>
				
				
				<tr>
				
 <g:def var="fooVar1" value="${indApplicationDetailsInstance.id}"/>
    <td align="center" height="1" colspan="2" >
    
    <!--
    <a href="<%=request.getContextPath()%>/hazardeousWasteAuthApp/paymentOption/<%=indApplicationDetailsInstance.id%>" ><input type="button" class="actionbutton" name="back" value="Back" ></a> 
	-->	  
		 <br>
		 <g:link action="paymentOption" controller="hazardeousWasteAuthApp" params="[indAppDetId:fooVar1,radio:'online']"><input type="button" class="actionbutton" name="back" value="Back" ></g:link></td>
		  
  </tr>
		
											</g:form>
										<!-- </div> -->
									

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
	  <g:include controller="userMaster" action="showSpcbFooter"/>
    </table></td>
  </tr>
</table>

 
</body>
</html>
