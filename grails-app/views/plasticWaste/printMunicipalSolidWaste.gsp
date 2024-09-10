<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>




<script type="text/javascript">


</script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'print.css' )}" media="print" />

<title></title>
<calendar:resources lang="en" theme="aqua"/>

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
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />


<script type="text/javascript" src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>


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
</head>

<body >
<table><tr><td width="350" align="right"><a href="#" onclick="window.print();return false;" ><img  src="${createLinkTo(dir:'images',file:'print.png')}" border="0" align="center" alt="Print this Form" >Print</a></td></tr></table>            
<table align="center" class="print" >
	<tr>
 		<td>

			<table align="center">
			 	<tr>
			 		<td align="center">
			             <h2>FORM I </h2>
			             <h3>[see rules 4(2) & 6(2)] </h3>
			             <h2>Application for obtaining authorization  </h2>
					</td>	
			    </tr> 
			 </table>  

         
		  <table class="tblbdr" width="75%" align="center">
                        <tbody>
                        	<tr>
						 		<td colspan="2">
						 			To <br/> Member Secretary, <br/> Chhattisgarh Environment Conservation Board.
						 			
								</td>	
						    </tr>
						    
						    <tr><td colspan="2"><hr/></td></tr>
						    
						    <tr>
								<td   align="left" valign="middle" >1.Name of the municipal authority/Name of the agency appointed by the municipal authority</td>
								<td   align="left" >
								  :${industryRegId?.indName }
								</td>
								
							</tr> 
						    
						    <tr><td><hr/></td><td><hr/></td></tr>
						    
					    	<tr>
									<td   align="left" valign="middle" >2.Corrospondence Address </td>
									<td   align="left" >
									  :${industryRegId?.indAddress }
									</td>
							</tr> 
						    
						    <tr>
									<td   align="left" valign="middle" >&nbsp;&nbsp;&nbsp; Telephone Number</td>
									<td   align="left" >
									  :${industryRegId?.indPhoneNo }
									</td>
							</tr> 
						   
						   	<tr>
									<td   align="left" valign="middle" >&nbsp;&nbsp;&nbsp; Fax Number</td>
									<td   align="left" >
									 :${industryRegId?.indFaxNo }
									</td>
							</tr> 
						    
						    <tr><td><hr/></td><td><hr/></td></tr>
						    
                       	   <tr class="prop">
                                <td>
                                    <label for="nameNodal">3.Nodal Officer & designation</label>
                                </td>
                                <td>
                                   :${fieldValue(bean:municipalSolidWasteInstance,field:'nameNodal')}
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td   align="left" valign="middle">
                                    <label for="desigNodal">(Officer authorised by the municipal authority or agency responsible for operation of processing or disposal facility)</label>
                                </td>
                                <td valign="top" >
                                   :${fieldValue(bean:municipalSolidWasteInstance,field:'desigNodal')}
                                </td>
                            </tr> 
                            
                            <tr><td><hr/></td><td><hr/></td></tr>
                            
                            <tr class="prop">
                                <td valign="top"  >
                                    <label for="authApp">4.Authorization applied for (Please tick mark)</label>
                                </td>
                                <td valign="top" >
                                    :${fieldValue(bean:municipalSolidWasteInstance,field:'authApp')}
                                </td>
                            </tr> 
                            <tr><td><hr/></td><td><hr/></td></tr>
                            <tr class="prop">
                                <td>
                                    <label for="authorizationType">5.Authorization Type :</label>
                                </td>
                                <td>
                                   :${fieldValue(bean:municipalSolidWasteInstance,field:'authorizationType')}
                                </td>
                            </tr> 
                            <%
                              int temp1=0;
                            %>
                            <tr><td><hr/></td><td><hr/></td></tr>
							
							<tr>
									<td  align="left" valign="middle" >6.Detailed proposal of waste processing/disposal facility (to be attached ) to include</td>
							</tr> 
							
							<tr><td><hr/></td><td><hr/></td></tr>
								<tr>
										<td  align="left" valign="middle" ><h4>6.1&nbsp;&nbsp;&nbsp;&nbsp;Processing of Waste</h4> </td>
								</tr>
								
							<tr class="prop">
                                <td   align="left" valign="middle" >
                                    <label for="locationSite">i.Location of Site:</label>
                                </td>
                                <td valign="top" >
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'locationSite')}
                                </td>
                            </tr> 
                            
                            <tr class="prop">
                                <td   align="left" valign="middle" >
                                    <label for="nameWasteProcessingTech">ii.Name of Waste Processing Technology: </label>
                                </td>
                                <td valign="top" >
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'nameWasteProcessingTech')}
                                </td>
                            </tr> 
                            
                           	<g:each in="${wastefileattachList}" status="i" var="wasteManagementFileInstance">
                           	<g:if test="${wasteManagementFileInstance?.description =='Details of Processing Technology'}">
                           
								<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
									<td align="left" valign="middle" >iii.${fieldValue(bean:wasteManagementFileInstance, field:'description')}</td>
									<g:if test="${wasteManagementFileInstance?.size !='null'}">
										<td valign="top" >Attached</td>
										<%temp1=1;%>
									</g:if>	
								</tr>
							</g:if>
							</g:each>
							
							<g:if test="${temp1==0}">
							<tr>
								<td align="left" valign="middle" >iii.Details of Processing Technology</td>
								<td valign="top" >Not Attached</td>
							</tr>
							</g:if>
                            
                            <%
                              temp1=0;
                            %>
                            
                             <tr class="prop">
                                <td   align="left" valign="middle" >
                                    <label for="qtyProcessed">iv.Quantity of waste to be processed per day: :</label>
                                </td>
                                <td valign="top" >
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'qtyProcessed')} 
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'unitMasterobjqtyPro')} 
                                </td>
                            </tr> 
                            
                       		<g:each in="${wastefileattachList}" status="i" var="wasteManagementFileInstance">
                           	<g:if test="${wasteManagementFileInstance?.description =='Site clearence (from Local Authority)'}">
                           
								<tr >
									<td align="left" valign="middle" >v.${fieldValue(bean:wasteManagementFileInstance, field:'description')}</td>
									<g:if test="${wasteManagementFileInstance?.size !='null'}">
										<td valign="top" >Attached</td>
										<%temp1=1;%>
									</g:if>	
								</tr>
							</g:if>
							</g:each>
							
							<g:if test="${temp1==0}">
							<tr>
								<td align="left" valign="middle" >v.Site clearence (from Local Authority)</td>
								<td valign="top" >Not Attached</td>
							</tr>
							</g:if>
                            
                            <%
                              temp1=0;
                            %>
							 
                           	<g:each in="${wastefileattachList}" status="i" var="wasteManagementFileInstance">
                           	<g:if test="${wasteManagementFileInstance?.description =='Details of agreement between municipal authority and operating agency'}">
								<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
									<td align="left" valign="middle" >v.${fieldValue(bean:wasteManagementFileInstance, field:'description')}</td>
									<g:if test="${wasteManagementFileInstance?.size !='null'}">
										<td valign="top" >Attached</td>
										<%temp1=1;%>
									</g:if>	
								</tr>
							</g:if>
							</g:each>
							
							<g:if test="${temp1==0}">
							<tr>
								<td align="left" valign="middle" >vi.Details of agreement between municipal authority and operating agency</td>
								<td valign="top" >Not Attached</td>
							</tr>
							</g:if>
							
							
							<%
                              temp1=0;
                            %>
							
							
					     	<g:each in="${wastefileattachList}" status="i" var="wasteManagementFileInstance">
                           	<g:if test="${wasteManagementFileInstance?.description =='Utilization programme for waste processed (Product utilization)'}">
								<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
									<td align="left" valign="middle" >v.${fieldValue(bean:wasteManagementFileInstance, field:'description')}</td>
									<g:if test="${wasteManagementFileInstance?.size !='null'}">
										<td valign="top" >Attached</td>
										<%temp1=1;%>
									</g:if>	
								</tr>
							</g:if>
							</g:each>
							
							<g:if test="${temp1==0}">
							<tr>
								<td align="left" valign="middle" >vii.Utilization programme for waste processed (Product utilization)</td>
								<td valign="top" >Not Attached</td>
							</tr>
							</g:if>
							
							
							<%
                              temp1=0;
                            %>
							
							
					     	<g:each in="${wastefileattachList}" status="i" var="wasteManagementFileInstance">
                           	<g:if test="${wasteManagementFileInstance?.description =='Methodology for disposal of waste processing rejects (quantity and quality)'}">
								<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
									<td align="left" valign="middle" >v.${fieldValue(bean:wasteManagementFileInstance, field:'description')}</td>
									<g:if test="${wasteManagementFileInstance?.size !='null'}">
										<td valign="top" >Attached</td>
										<%temp1=1;%>
									</g:if>	
								</tr>
							</g:if>
							</g:each>
							
							<g:if test="${temp1==0}">
							<tr>
								<td align="left" valign="middle" >viii.Methodology for disposal of waste processing rejects (quantity and quality)</td>
								<td valign="top" >Not Attached</td>
							</tr>
							</g:if>
							
							
							<%
                              temp1=0;
                            %>
							
							
							
                            <tr class="prop">
                                <td   align="left" valign="middle" >
                                    <label >ix.Measures to be taken for prevention and control of environmental pollution:</label>
                                </td>
                                <td valign="top" >
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'measuresPrevention')} 
                                </td>
                            </tr> 
                            
                            
                            <tr class="prop">
                                <td   align="left" valign="middle">
                                    <label for="invenstment">x.Investment on Project and expected returns  </label>
                                </td>
                                <td valign="top" >
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'invenstment')} and ${fieldValue(bean:municipalSolidWasteInstance,field:'expectedReturn')} 
                                </td>
                            </tr> 
                            
                            
                             <tr class="prop">
                                <td   align="left" valign="middle" >
                                    <label >xi.Measures to be taken for safety of workers working in the plant:</label>
                                </td>
                                <td valign="top" >
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'measuresSafety')} 
                                </td>
                            </tr> 
                            
							<tr><td><hr/></td><td><hr/></td></tr>
							
							
							<tr>
										<td  align="left" valign="middle" ><h4>6.2&nbsp;&nbsp;&nbsp;&nbsp;Disposal of Waste</h4> </td>
							</tr> 
							
							<tr class="prop">
                                <td   align="left" valign="middle">
                                    <label for="numSites">i.Number of sites indentified:</label>
                                </td>
                                <td valign="top" >
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'numSites')} 
                                </td>
                            </tr> 
							
							<g:each in="${wastefileattachList}" status="i" var="wasteManagementFileInstance">
                           	<g:if test="${wasteManagementFileInstance?.description =='Layout maps of site'}">
								<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
									<td align="left" valign="middle" >ii.${fieldValue(bean:wasteManagementFileInstance, field:'description')}</td>
									<g:if test="${wasteManagementFileInstance?.size !='null'}">
										<td valign="top" >Attached</td>
										<%temp1=1;%>
									</g:if>	
								</tr>
							</g:if>
							</g:each>
							
							<g:if test="${temp1==0}">
							<tr>
								<td align="left" valign="middle" >ii.Layout maps of site</td>
								<td valign="top" >Not Attached</td>
							</tr>
							</g:if>
							
							<%
                              temp1=0;
                            %>
							
							
							<tr class="prop">
                                <td   align="left" valign="middle" >
                                    <label for="qtyDisposed">iii.Quantity of waste to be disposed per day:</label>
                                </td>
                                <td valign="top" >
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'qtyDisposed')}
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'unitMasterobjqtyDis')}
                                </td>
                            </tr> 
							
						  	<tr class="prop">
                                <td   align="left" valign="middle" >
                                    <label for="natureWaste">iv.Nature and composition of waste </label>
                                </td>
                                <td valign="top" >
                                   ${fieldValue(bean:municipalSolidWasteInstance,field:'natureWaste')} and ${fieldValue(bean:municipalSolidWasteInstance,field:'compWaste')}
                                </td>
                            </tr> 
                        
                       		<g:each in="${wastefileattachList}" status="i" var="wasteManagementFileInstance">
                           	<g:if test="${wasteManagementFileInstance?.description =='Details of methodology or criteria followed for site selection'}">
								<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
									<td align="left" valign="middle" >v.${fieldValue(bean:wasteManagementFileInstance, field:'description')}</td>
									<g:if test="${wasteManagementFileInstance?.size !='null'}">
										<td valign="top" >Attached</td>
										<%temp1=1;%>
									</g:if>	
								</tr>
							</g:if>
							</g:each>
							
							<g:if test="${temp1==0}">
							<tr>
								<td align="left" valign="middle" >v.Details of methodology or criteria followed for site selection</td>
								<td valign="top" >Not Attached</td>
							</tr>
							</g:if>
							
							<%
                              temp1=0;
                            %>
							
							
							<g:each in="${wastefileattachList}" status="i" var="wasteManagementFileInstance">
                           	<g:if test="${wasteManagementFileInstance?.description =='Details of Existing Site under construction'}">
								<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
									<td align="left" valign="middle" >vi.${fieldValue(bean:wasteManagementFileInstance, field:'description')}</td>
									<g:if test="${wasteManagementFileInstance?.size !='null'}">
										<td valign="top" >Attached</td>
										<%temp1=1;%>
									</g:if>	
								</tr>
							</g:if>
							</g:each>
							
							<g:if test="${temp1==0}">
							<tr>
								<td align="left" valign="middle" >vi.Details of Existing Site under Operation</td>
								<td valign="top" >Not Attached</td>
							</tr>
							</g:if>
							
							<%
                              temp1=0;
                            %>
							
							<g:each in="${wastefileattachList}" status="i" var="wasteManagementFileInstance">
                           	<g:if test="${wasteManagementFileInstance?.description =='Methodology and operational details of landfilling'}">
								<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
									<td align="left" valign="middle" >vii.${fieldValue(bean:wasteManagementFileInstance, field:'description')}</td>
									<g:if test="${wasteManagementFileInstance?.size !='null'}">
										<td valign="top" >Attached</td>
										<%temp1=1;%>
									</g:if>	
								</tr>
							</g:if>
							</g:each>
							
							<g:if test="${temp1==0}">
							<tr>
								<td align="left" valign="middle" >vii.Methodology and operational details of landfilling</td>
								<td valign="top" >Not Attached</td>
							</tr>
							</g:if>
							
							<%
                              temp1=0;
                            %>
							
							<tr class="prop">
                                <td   align="left" valign="middle" >
                                    <label >viii.Measures taken to check enviornmental pollution</label>
                                </td>
                                <td valign="top" >
                                    ${fieldValue(bean:municipalSolidWasteInstance,field:'measuresPollution')}
                                </td>
                            </tr> 
							
							
							<tr><td><hr/></td><td><hr/></td></tr>
							
							<tr class="prop">
                                <td   width="50%" align="left" valign="middle" >
                                    <label >Date :</label>
                                </td>
                                <td width="50%" valign="top" >
                                    Signature of Nodal Officer:..........
                                </td>
                            </tr> 
					
					
						
                        </tbody>
                    </table>
                    
                    
                </td>
            </tr>
        </table>
</body>
</html>


