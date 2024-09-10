
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@page import="java.util.ArrayList"%><html >

<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>Untitled Document</title>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />

 

 

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>

<g:javascript library="prototype" />


 </head>
  <body>

  <g:form name="editWaterSolidDispos" method="post" action="editHotelOtherDetail" >
 <table align="center">

<tr align="center">

<td width="100%" align="center">

    <div >
 

 


<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="420" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Hotel/Restaurant General Detail</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
      </table>
 <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
 <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
 
 					
 					<tr><td><table class="tblbdr"> 
 					
 					<tr bgcolor="#A8DAF3">
                        
                       
                                    <td width="150px" class="headngblue" ><div  class="style3">Style of Hotel/Lodge/Guest House</div></td>
                                   <td width="150px" class="headngblue" ><div  class="style3">Room Capacity of Hotel/Lodge/Guest House</div></td>
                                   <td width="150px" class="headngblue" ><div  class="style3">Restaurants Independent of Hotel</div></td>
                                    <td width="150px" class="headngblue" ><div  class="style3">Name & Style of Restaurant</div></td>
                                    <td width="150px" class="headngblue" ><div  class="style3">Seating Capacity</div></td>
                                     <td width="150px" class="headngblue" ><div  class="style3">Year of Establishment</div></td>
                                       <td width="150px" class="headngblue" ><div  class="style3">Total Project Cost(Rs.)</div></td>
                                     <td width="150px" class="headngblue" ><div  class="style3">Location</div></td>
                                     <td width="150px" class="headngblue" ><div  class="style3">Distance from Major Water Bodies (In Meters)</div></td>
                                     <td width="150px" class="headngblue" ><div  class="style3">Is DG sets used</div></td>
                                      <td width="150px" class="headngblue" ><div  class="style3">Make</div></td>
                                       <td width="150px" class="headngblue" ><div  class="style3">Capacity(in KVA)</div></td>
                                     <td width="150px" class="headngblue" ><div  class="style3">Other Pollution Prevention Detail</div></td>  
                                     <td width="150px" class="headngblue" ><div  class="style3">Other Relevent Information</div></td>
                                    <td width="150px" class="headngblue" ><div  class="style3">Delete</div></td>
                             </tr>
 <g:each in="${hotelOtherDetailList}" status="i" var="hotelOtherDetailInst">
  <tr align="center" >
  					
                         <td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.hotelName}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.roomCapacity}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.indpendentRestaurant}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.restaurantN}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.capacity}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.year}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.investment}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.location}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.distance}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.dgSet}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.make}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.dgcapacity}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.prevention}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.relInfo}</span></td>

  					 <td bgcolor="#E8F6F9"><span class="txt style6"><input type="checkbox" name="delete" value="<%=hotelOtherDetailInst.id%>"/>
                        </span></td>
  				
                        
                              
        </tr>		
      </g:each>		
      
      
      
       <tr bgcolor="#A8DAF3">
                   <td width="150px" class="headngblue" ><div  class="style3">Whether N.O.C from Fire Department obtained?</div></td>
                                     <td width="150px" class="headngblue" ><div  class="style3">Other Relevent Information</div></td> 
                          <td width="150px" class="headngblue" ><div  class="style3">Septic Tank Provided</div></td> 
 					       <td width="150px" class="headngblue" ><div  class="style3">Soakage Pit</div></td>  
 					        <td width="150px" class="headngblue" ><div  class="style3">Sewage Treatment Plant</div></td>
 					        <td width="150px" class="headngblue" ><div  class="style3">Chimeny With Hoods</div></td>  
 					        <td width="150px" class="headngblue" ><div  class="style3">Exhaust Fans</div></td> 
 					         <td width="150px" class="headngblue" ><div  class="style3">Solid Waste Management</div></td> 
 					         <td width="150px" class="headngblue" ><div class="style3">Greenery/Plantation</div></td>        
                         </tr>
                         
                          <g:each in="${hotelOtherDetailList}" status="i" var="hotelOtherDetailInst">
                          <tr align="center" >
                          <td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.nocObtained}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.relInfo}</span></td>
                  <td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.septicTank}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.soakagePit}</span></td> 
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.sewagePlant}</span></td>  
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.hotelchimeny}</span></td>
  					<td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.exhaustFans}</span></td>
                    <td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.solidWaste}</span></td> 
                    <td bgcolor="#E8F6F9"><span class="txt style6">${hotelOtherDetailInst.greenery}</span></td>   
                    
        </tr>	
             
      </g:each>		
 					<tr bgcolor="#F4F7FB">
 					<td>&nbsp;</td>
 					</tr>
 					
 					
 					
 					
 					</table></td></tr>
						
					
					  
  </table>
	  
  		</div></div></td></tr>	

  <tr>

     <td align="center"><input type="hidden" name="appId" value="<%=appDetId%>"/><input type="submit" name="Delete" value="Delete" class="actionbutton"></td>

  </tr>



</table>
</g:form>

<script language="JavaScript" type="text/javascript">
  
  
 </script>   
 

</body>
</html>