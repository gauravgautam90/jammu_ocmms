<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'print.css' )}" media="print" />
<title></title>


<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
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
-->
</style>

</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>
</head>

<body >
<table><tr><td width="299" align="right"><a href="#" onclick="window.print();return false;" ><img  src="${createLinkTo(dir:'images',file:'print.png')}" border="0" align="center" alt="Print this Form" >Print</a></td></tr></table>

<table align="center" class="print" >
	<tr>
 		<td>
			  <table align="center">
			 	<tr>
			 		<td align="center">
			             <h2>FORM I </h2>
			             <h3>(see rule 8)</h3>
			             <h2>APPLICATION FOR AUTHORISATION </h2>
						 <h3>(To be submitted in duplicate.) </h3>
					</td>	
			    </tr> 
			  </table>  
			  
			 <table class="tblbdr" border="0" width="75%" align="center">
			              <tbody>
			              
					             	<tr>
								 		<td colspan="2">
								 			To <br/> Member Secretary, <br/> Jharkhand Environment Conservation Board.
								 			
										</td>	
								    </tr>
								    
								    <tr><td><hr/></td><td><hr/></td></tr>
								    <tr>
								 		<td colspan="2">
								 			1. Particulars of Applicant<br/>
										</td>	
								    </tr>
								    
			        				<tr >
			                           <td valign="top" align="left" >
			                               <label for="nameOfApplicant">&nbsp &nbsp &nbsp &nbsp(i)&nbsp;Name Of Applicant:</label>
			                           </td>
			                           <td valign="top" >
			                               ${fieldValue(bean:bioMedicalWasteInstance,field:'nameOfApplicant')}
			                           </td>
			                       </tr> 
				                   
			                       <tr class="prop">
			                           <td valign="top" align="left">
			                               <label for="nameOfInstitution">&nbsp &nbsp &nbsp &nbsp(ii)&nbsp Name Of Institution:</label>
			                           </td>
			                           <td valign="top" >
			                               ${fieldValue(bean:bioMedicalWasteInstance,field:'nameOfInstitution')}
			                           </td>
			                       </tr> 	
			                       
				                    <tr>
										<td   colspan="2" align="left" valign="middle" >
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Address :
										  ${industryRegId?.indAddress}
										</td>
									</tr> 
									<tr>
										<td  colspan="2" align="left" valign="middle" >
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Telephone Number:
										  ${industryRegId?.indPhoneNo}
										,Fax Number:
										  ${industryRegId?.indFaxNo}
										</td>
									</tr> 
				   
								    <tr><td><hr/></td><td><hr/></td></tr>
								    <tr>
								 		<td colspan="2">
								 			2. Activity For Which Authorization Is Sought:
										</td>	
								    </tr>
			                       <g:each in="${tmp1}" status="i" var="authFor">
							      <tr>
							            <td>&nbsp &nbsp &nbsp &nbsp ${i+1} . &nbsp ${authFor}</td>
							      </tr>
							      </g:each>
			                       
				                     <tr><td><hr/></td><td><hr/></td></tr>
				                     
				                    <tr>
								 		<td >
								 			3. Please state whether applying for resh authorisation or for renewal:
										</td>
										<td valign="top">
				                           	${fieldValue(bean:bioMedicalWasteInstance,field:'authorizationType')}
			                            </td>	
								    </tr>
			
								    <tr>
								 		<td >
								 			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(In case of renewal previous authorisation-number and date)
										</td>
										<td width="60%" align="left" >
										    <table width="293" border="0">
										      <tr >
										        <td>Number : </td>
										        <td>Date(dd/mm/yyyy): </td>
										      </tr>
										      <tr >
										       <g:if test="${bioMedicalWasteInstance?.authorizationType =='RenewalApplication'}">
										        <%
					                            SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy");
						                        String strDate = sdfDestination.format(bioMedicalWasteInstance.previousAuthDate);
						
						                        %>
										        <td>${fieldValue(bean:bioMedicalWasteInstance, field:'previousAuthNo')}</td>
										        <td ><%=strDate%></td>
										      </g:if>
										      <g:else>
										        <td>NA</td>
										        <td>NA</td>
										      </g:else>
										      </tr>
										    </table>      
										</td>
								    </tr>
				  					 
				  					 <tr><td><hr/></td><td><hr/></td></tr>
				  					 
				  					 <tr>
								 		<td colspan="2">
								 			4.
										</td>
								    </tr>
			  						
			  						<tr class="prop">
			                             <td valign="top" align="left">
			                                 <label for="nameAddressInstitution">
			                                 &nbsp;&nbsp;&nbsp;&nbsp;(i)&nbsp; Address of the institution handling bio-medical wastes: </label>
			                             </td>
			                             <td valign="top" >
			                                 ${fieldValue(bean:bioMedicalWasteInstance,field:'nameAddressInstitution')}
			                             </td>
			                         </tr> 
				  				
			  						   <tr class="prop">
				                           <td valign="top"  align="left" >
				                               <label for="addrTreatmentFacility">&nbsp;&nbsp;&nbsp;&nbsp;(ii)&nbsp; Address of the place of the treatment facility: </label>
				                           </td>
				                           <td valign="top"  >
				                               ${fieldValue(bean:bioMedicalWasteInstance,field:'addrTreatmentFacility')}
				                           </td>
				                       </tr> 
				  				
				                       <tr class="prop">
				                           <td valign="top" align="left">
				                               <label for="addrPlaceDisposalOfWaste">&nbsp;&nbsp;&nbsp;&nbsp;(iii)&nbsp; Address of the place of disposal of the waste: </label>
				                           </td>
				                           <td valign="top" >
				                               ${fieldValue(bean:bioMedicalWasteInstance,field:'addrPlaceDisposalOfWaste')}
				                           </td>
				                       </tr> 
				                   	   
				                   	    <tr><td><hr/></td><td><hr/></td></tr>
				                   	   
				                   	   <tr>
									 		<td colspan="2">
									 			5.
											</td>
								 	   </tr>
			
			                	     <tr class="prop">
			                             <td valign="top" align="left">
			                                 <label for="modeTrans">
			                                 &nbsp;&nbsp;&nbsp;&nbsp;(i)&nbsp; Mode of transportation (in any) of bio-medical waste: </label>
			                             </td>
			                             <td valign="top" >
			                                 ${fieldValue(bean:bioMedicalWasteInstance,field:'modeTrans')}
			                             </td>
			                         </tr> 
			                     
			                         <tr class="prop">
			                             <td valign="top" align="left">
			                                 <label for="modeTreat">&nbsp;&nbsp;&nbsp;&nbsp;(ii)&nbsp; Mode(s) of treatment: </label>
			                             </td>
			                             <td valign="top" >
			                                 ${fieldValue(bean:bioMedicalWasteInstance,field:'modeTreat')}
			                             </td>
			                         </tr> 	   
				                     
				                      <tr><td><hr/></td><td><hr/></td></tr>
				                     
				                     <tr>
									 		<td >
									 			6. Brief description of method of treatment and disposal (attach details): 
											</td>
											<td valign="top" >
				                               ${fieldValue(bean:bioMedicalWasteInstance,field:'descrip')}
				                           </td>
							 	     </tr>
				             
				              <tr><td><hr/></td><td><hr/></td></tr>
				             
				             <tr>
						 		<td colspan="2">
						 			7.
								</td>
						 	 </tr> 
						 	 
						 	 <tr>
							   <td width="40%" align="left"> 
							  &nbsp;&nbsp;&nbsp;&nbsp;(i)&nbsp; Category (see Schedule 1) of waste to be handled 
							    </td>
							</tr>
						 	 <br/>
						 	 
							<g:if test="${bioWasteCategQuantList}"> 
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Human Anatomical Waste'}"> 								
							<tr>
							   <td width="40%" align="left"> 
							   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Category no. 1 
							    </td>
							</tr>
							</g:if>
							</g:each>
			                         
			                         <g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Animal Waste'}"> 								
			                          <tr>
							    <td width="40%" align="left"> 
							    
								  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Category no. 2 
							    </td>
							</tr>
							</g:if>
							</g:each>
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Microbiology & Biotechnology Waste'}"> 								
							 <tr>
							    <td width="40%" align="left"> 
								  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Category no. 3 
							    </td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Waste sharps'}"> 								
							 <tr>
							    <td width="40%" align="left"> 
								  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Category no. 4 
							    </td>
							</tr>
							</g:if>
							</g:each>
			
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Discarded Medicines and Cytotoxic drugs'}"> 								
							<tr>
							    <td width="40%" align="left"> 
								  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Category no. 5 
							    </td>
							</tr>
							</g:if>
							</g:each>
			
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Solid Waste'}"> 								
							<tr>
							    <td width="40%" align="left"> 
								  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Category no. 6 
							    </td>
							</tr>
							</g:if>
							</g:each>
			
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Solid Waste disposal generated'}"> 								
							<tr>
							    <td width="40%" align="left"> 
								  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Category no. 7 
							    </td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Liquid Waste'}">
							<tr>
							    <td width="40%" align="left"> 
								  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Category no. 8 
							    </td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Incineration Ash'}">
							<tr>
							    <td width="40%" align="left"> 
								  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Category no. 9 
							    </td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Chemical Waste'}">
							<tr>
							    <td width="40%" align="left"> 
								  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Category no. 10 
							    </td>
							</tr>
							</g:if>
							</g:each>
							
							</g:if>
							
							 <tr>
							   <td width="40%" align="left"> 
							  (ii) Quantity of waste (category-wise) to be handled per month 
							    </td>
							</tr>
							
							<g:if test="${bioWasteCategQuantList}"> 
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Human Anatomical Waste'}"> 								
							<tr>
							    <td width="60%" align="left">
							    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${bioWasteCategQuantinst?.quantity}</td>
							</tr>
							</g:if>
							</g:each>
			                         
			                         <g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Animal Waste'}"> 								
			                          <tr>
							    <td width="60%" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${bioWasteCategQuantinst?.quantity}</td>
							</tr>
							</g:if>
							</g:each>
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Microbiology & Biotechnology Waste'}"> 								
							 <tr>
							    <td width="60%" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${bioWasteCategQuantinst?.quantity}</td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Waste sharps'}"> 								
							 <tr>
							    <td width="60%" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${bioWasteCategQuantinst?.quantity}</td>
							</tr>
							</g:if>
							</g:each>
			
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Discarded Medicines and Cytotoxic drugs'}"> 								
							<tr>
							    <td width="60%" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${bioWasteCategQuantinst?.quantity}</td>
							</tr>
							</g:if>
							</g:each>
			
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Solid Waste'}"> 								
							<tr>
							    <td width="60%" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${bioWasteCategQuantinst?.quantity}</td>
							</tr>
							</g:if>
							</g:each>
			
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Solid Waste disposal generated'}"> 								
							<tr>
							    <td width="60%" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${bioWasteCategQuantinst?.quantity}</td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Liquid Waste'}">
							<tr>
							    <td width="60%" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${bioWasteCategQuantinst?.quantity}</td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Incineration Ash'}">
							<tr>
							    <td width="60%" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${bioWasteCategQuantinst?.quantity}</td>
							</tr>
							</g:if>
							</g:each>
							
							<g:each in="${bioWasteCategQuantList}" status="i" var="bioWasteCategQuantinst">
							<g:if test="${bioWasteCategQuantinst?.category=='Chemical Waste'}">
							<tr>
							    <td width="60%" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${bioWasteCategQuantinst?.quantity}</td>
							</tr>
							</g:if>
							</g:each>
							
							</g:if>		
							 
							  <tr><td><hr/></td><td><hr/></td></tr>
							 
							 <tr>
							   <td colspan="2" > 
							  		8. <h5>Declaration </h5> 
							    </td>
							 </tr>
							 
							 <tr>
							   <td colspan="2" > 
							  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I do hereby declare that the statements made and information given above are true to the best of my knowledge and belief and that I have not concealed any information. 
							    </td>
							 </tr>
							 
							 <tr>
							   <td colspan="2" > 
							  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; I do also hereby undertake to provide any further information sought by the prescribed authority in relation to these rules and to fulfill any conditions stipulated by the prescribed authority. 
							    </td>
							 </tr>
							 
							  <tr>
							    <td> 
							  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Date :
							    </td>
							    <td> 
							  		Signature of the Applicant:..........
							    </td>
							 </tr>
							 <tr><td><br/></td></tr>
						 	  <tr>
							    <td> 
							  		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Place :
							    </td>
							    <td> 
							  		Designation of the Applicant:..........
							    </td>
							 </tr>
							
			        </tbody>
			 </table>
			 
			
		</td>
	</tr>	   
</table>		      
		
</body>
</html>


