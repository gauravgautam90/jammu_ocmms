<%@ page import="java.text.SimpleDateFormat"%>
<%System.out.println("Session=====4444444444444======"+session);%>
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
						 	<td class="top-lnks"> <%=firstname %><%=lastName %>(<%=access %>)<br/>
						 	Date :&nbsp;<%=date %>-<%=month %>-<%=year %> 
						 	</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
						 </tr>
					 </table>
					 

<% } 

	if(  (IndUser)session.getAttribute("indUser")  )
		
		{ %>
			
					<table width="100%" >
						 <tr height="10px" bgcolor="#4C8BC0">
						 	<td class="top-lnks"> 
						 	&nbsp;Date :&nbsp;<%=date %>-<%=month %>-<%=year %> 
						 	</td>
						 	<td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %>&nbsp;&nbsp; </td>
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
										<td align="left" valign="top">
										
										
									
										</td>
										
									</tr>
							<tr>
										
										<td align="left" valign="top">		
						<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1">			
						<tr>
										
										<td align="center" valign="top">		
								
										<font color="red" size="5"> Payment Challan </font>
										</td>
										<td align="center" valign="top">		
								
										<font color="red" size="5"> Payment Challan </font>
										</td>
												
										</tr>
										</table>
											</td>
										
									</tr>
											
									
                    <tr>
                      <td height="0" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="30" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    
         <div style="border":1px solid ; width:720px; margin-bottom: 1em; padding: 10px" >
		 
		 
		
		 
		 
		 
	
            		
		<% System.out.println("here in challan form------")
		
		 %>
		
	
			<br>
	
		
				
				
				
				
				
				
				
				
				
		
		
				
		<% System.out.println("hellooo-------"); 
				
				
				%>
			<tr>
				<td width="50%"  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Challan Details </td>
					<td width="50%"  align="center" valign="middle" bgcolor="#A8DAF3" class="headngblue">Challan Details </td>
					
				</tr> 
				
			
			<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
				
				
				<tr ><td> &nbsp; </td></tr>
			<tr>
				<td width="50%"  align="center" valign="middle"  ><font size="4" ><u>Bank Copy</u></font> </td>
					<td width="50%"  align="center" valign="middle" ><font size="4" ><u>Customer Copy </u></font></td>
					
				</tr> 
				<tr ><td> &nbsp; </td></tr>
				<tr valign="middle" width="100%">
                  <td  width="50%" align="left" >
				  	
					<table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
				<tr valign="middle" width="100%">
                  <td  width="100%" align="left" colspan="2">
				  	
					<b><font size="3" color="#417FB2">
										Payment to be made as per details given below if paying through NEFT/RTGS
										</font></b>

				  </td>
				</tr>	
				<tr valign="middle" width="100%" bgcolor="#E8F6F9">
                  <td  width="50%" align="left" >
                  Beneficiary Name :
                  </td>
					 <td  width="50%" align="left" >
					Jharkhand State Pollution Control Board</td>
				</tr> 
				<tr valign="middle" width="100%" >
                  <td  width="50%" align="left" >
                 Pay To Account Number :
                  </td>
 <td  width="50%" align="left" >
 					${accountNo}
 					</td>
				</tr>
				<tr valign="middle" width="100%" bgcolor="#E8F6F9">
                  <td  width="50%" align="left" >
				  	
					Bank Name :

				  </td>
				   <td  width="50%" align="left" >
				  	
				 ICICI Bank
					
				  </td>
				</tr>	
				
					<tr valign="middle" width="100%" >
                  <td  width="50%" align="left" >
				  	
					IFSC Code :

				  </td>
				   <td  width="50%" align="left" >
				  	
				 ICIC0000104
					
				  </td>
				</tr>	
				
				
				<tr valign="middle" width="100%" bgcolor="#E8F6F9">
                   <td  width="50%" align="left" >
				  	
					Payable Amount(in Rs.) :

				  </td>
				   <td  width="50%" align="left" >
				  	
					
				  </td>
				</tr>	
				<tr ><td> &nbsp; </td></tr>
				<tr valign="middle" width="100%">
                  <td  width="100%" align="left" colspan="2">
				  	
					<b><font size="2" color="#417FB2">
					
					1. Please fill the Amount.<br>
					2. Kindly visit your bank branch and initiate NEFT/RTGS against this challan<br>
					3. NEFT / RTGS payment challan will be valid only after 2 working days from registration date .
										</font></b>

				  </td>
				</tr>	
				
					
	    </table>

				  </td>
			 <td  width="50%" align="left" >
			 <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
				<tr valign="middle" width="100%">
                  <td  width="100%" align="left" colspan="2">
				  	
					<b><font size="3" color="#417FB2">
										Payment to be made as per details given below if paying through NEFT/RTGS
										</font></b>

				  </td>
				</tr>	
				<tr valign="middle" width="100%" bgcolor="#E8F6F9">
                  <td  width="50%" align="left" >
                  Beneficiary Name :
                  </td>
					 <td  width="50%" align="left" >
					Jharkhand State Pollution Control Board</td>
				</tr> 
				<tr valign="middle" width="100%" >
                  <td  width="50%" align="left" >
                 Pay To Account Number :
                  </td>
 <td  width="50%" align="left" >
 					${accountNo}
 					</td>
				</tr>
				<tr valign="middle" width="100%" bgcolor="#E8F6F9">
                  <td  width="50%" align="left" >
				  	
					Bank Name :

				  </td>
				   <td  width="50%" align="left" >
				  	
				 ICICI Bank
					
				  </td>
				</tr>	
				
					<tr valign="middle" width="100%" >
                  <td  width="50%" align="left" >
				  	
					IFSC Code :

				  </td>
				   <td  width="50%" align="left" >
				  	
				 ICIC0000104
					
				  </td>
				</tr>	
				
				
				<tr valign="middle" width="100%" bgcolor="#E8F6F9">
                   <td  width="50%" align="left" >
				  	
					Payable Amount(in Rs.) :

				  </td>
				   <td  width="50%" align="left" >
				  	
					
				  </td>
				</tr>	
				<tr ><td> &nbsp; </td></tr>
				<tr valign="middle" width="100%">
                  <td  width="100%" align="left" colspan="2">
				  	
					<b><font size="2" color="#417FB2">
					
					1. Please fill the Amount.<br>
					2. Kindly visit your bank branch and initiate NEFT/RTGS against this challan<br>
					3. NEFT / RTGS payment challan will be valid only after 2 working days from registration date .
										</font></b>

				  </td>
				</tr>	
					
	    </table>
			 
			 </td>
				    </tr>
				    
				    </table>
				    
				    
				   
				
					
				
				
				
				    <tr bgcolor="#FFFFFF">
					<td colspan="2" align="center">&nbsp;</td>
					
			  	</tr>
			  	
				
				<tr bgcolor="#FFFFFF">
					<td colspan="2" align="center">
					
							
		
			<input type="button" name="Print" value="Print" onclick="window.print()" class="actionbutton">
			 <a href="<%=request.getContextPath()%>/hazardeousWasteAuthApp/list"><input type="button" class="actionbutton" name="Exit" value="Exit" ></a> 
				
					</td>
					</td>
					
			  	</tr> 
				
				
				</table>
				
				</div>
		</td>
		</tr>
		
		</table>
		
											
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
	  
    </table></td>
  </tr>
</table>

 
</body>
</html>
