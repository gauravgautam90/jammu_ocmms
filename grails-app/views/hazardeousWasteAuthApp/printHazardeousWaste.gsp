<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'print.css' )}" media="print" />
<title></title>
</head>
<body >
 <table><tr><td width="299" align="right"><a href="#" onclick="window.print();return false;" ><img  src="${createLinkTo(dir:'images',file:'print.png')}" border="0" align="center" alt="Print this Form" >Print</a></td></tr></table>
<table class="print">
<tr>
<td>
<table width="100%"  border="0" align="center" >
			<h3 align="center" ><strong>Form 1</strong></h3>
			<h5 align="center" >[see rules 5(3) and (7)] </h5>
			<h4 align="center" ><strong>APPLICATION FOR OBTAINING AUTHORIZATION </strong></h4>
			<h4 align="center" ><strong>FOR COLLECTION/RECEPTION/TREATMENT/TRANSPORT/STORAGE</strong></h4>
			<h4 align="center" ><strong>/DISPOSAL OF HAZARDOUS WASTE</strong></h4>
			<tr>
				<td align="left">From: ${fieldValue(bean:indRegInstance,field:'indName')}</td>
			</tr>
			<tr>
				<td align="left">&nbsp &nbsp &nbsp &nbsp ${fieldValue(bean:indRegInstance,field:'indAddress')}</td>
			</tr>
			<tr>
				<td align="left">&nbsp &nbsp &nbsp &nbsp ${fieldValue(bean:indRegInstance,field:'indCity')}</td>
			</tr>
			<tr>
				<td align="left">&nbsp &nbsp &nbsp &nbsp District: ${district}</td>
			</tr>
			<tr>
				<td align="left">&nbsp &nbsp &nbsp &nbsp Tehsil: ${tehsil}</td>
			</tr>
			<tr>
				<td align="left">&nbsp &nbsp &nbsp &nbsp Pin: ${fieldValue(bean:indRegInstance,field:'indPin')}</td>
			</tr>
			<tr>
				<td>To</td>
			</tr>
			<tr>
				<td>&nbsp &nbsp &nbsp &nbsp The Member Secretry,</td>
			</tr>
			<tr>
				<td>&nbsp &nbsp &nbsp &nbsp Chhattisgarh Pollution Control Board/Chhattisgarh Pollution Control Committee,</td>
			</tr>
			<tr>
				<td>&nbsp &nbsp &nbsp &nbsp Raipur</td>
			</tr>
			<tr>
				<td>Sir,</td>
			</tr>
			<tr>
				<g:if test="${hazardeousWasteAuthAppInstance?.is_Renew== 'Yes'}">
				<td>&nbsp &nbsp &nbsp &nbsp I/We hereby apply for Renewal of authorization under sub-rule(3) of Rule 5 of the Hazardous Waste(Management, Handling and Transboundry Movement) Rules,2008 for ${(fieldValue(bean:hazardeousWasteAuthAppInstance,field:'authorization_Required_For'))} of hazardous wastes
				</td>
				</g:if>
				<g:else>
				<td>&nbsp &nbsp &nbsp &nbsp I/We hereby apply for authorization under sub-rule(3) of Rule 5 of the Hazardous Waste(Management, Handling and Transboundry Movement) Rules,2008 for ${fieldValue(bean:hazardeousWasteAuthAppInstance, field:'authorization_Required_For')} of hazardous wastes
				</td>
				</g:else>
			</tr>
</table>
<table width="100%" border="1" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
	<tr><td align="center"><b>For Office Use Only</b></td></tr>	
</table>
<table width="100%"  border="0" align="center" >
	<tr><td>1.   Code No.</td></tr>
	<tr><td>2.   Whether the unit is situated in a critically polluted area as identified by Ministry of Environment and Forests;</td></tr>
</table>
<table width="100%" border="1" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
	<tr><td align="center"><b>Filled In By Applicant</b></td></tr>	
</table>
<table width="100%"  border="0" align="center" >
	<tr>
		<td align="center"><b>Part A: General</b></td>
	</tr>
	<tr>
		<td>3.   (a)    Name and address of the unit and location of activity :</td>
	</tr>
	<tr>
		<td align="left">&nbsp &nbsp &nbsp &nbsp &nbsp ${fieldValue(bean:indRegInstance,field:'indName')}</td>
	</tr>
	<tr>
		<td align="left">&nbsp &nbsp &nbsp &nbsp &nbsp ${fieldValue(bean:indRegInstance,field:'indAddress')}</td>
	</tr>
	<tr>
		<td align="left">&nbsp &nbsp &nbsp &nbsp &nbsp ${fieldValue(bean:indRegInstance,field:'indCity')}</td>
	</tr>
	<tr>
		<td align="left">&nbsp &nbsp &nbsp &nbsp &nbsp District: ${district}</td>
	</tr>
	<tr>
		<td align="left">&nbsp &nbsp &nbsp &nbsp &nbsp Tehsil: ${tehsil}</td>
	</tr>
	<tr>
		<td align="left">&nbsp &nbsp &nbsp &nbsp &nbsp Pin: ${fieldValue(bean:indRegInstance,field:'indPin')}</td>
	</tr>
	<tr>
		<td align="left">&nbsp &nbsp &nbsp &nbsp &nbsp Location Of Activity: ${fieldValue(bean:hazardeousWasteAuthAppInstance,field:'location_Of_Activity')}</td>
	</tr>
	<tr>
		<td>&nbsp &nbsp (b) Authorization required for:</td>
	</tr>
	<g:each in="${tmp1}" status="i" var="authFor">
	<tr>
		<td>&nbsp &nbsp &nbsp &nbsp ${i+1} . &nbsp ${authFor}</td>
	</tr>
	</g:each>
	<tr>
		<td>&nbsp &nbsp (c) In case of renewal of authorization previous authorization number and date :</td>
	</tr>
	<g:if test="${hazardeousWasteAuthAppInstance?.is_Renew== 'Yes'}">
	<g:if test="${hazardeousWasteAuthAppInstance?.auth_Renew_Date!= null}">
	<% 
    SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy ");
   
    String strDate = sdfDestination.format(hazardeousWasteAuthAppInstance.auth_Renew_Date);
    %>
    
	<tr>
		<td>&nbsp &nbsp &nbsp &nbsp Previous Authorization Number: ${fieldValue(bean:hazardeousWasteAuthAppInstance,field:'auth_Renew_No')}</td>
	</tr>
	<tr>
		<td>&nbsp &nbsp &nbsp &nbsp Previous Authorization Date: ${strDate}</td>
	</tr>
	</g:if>
	</g:if>
	<tr>
		<td>4.   (a)    Whether the unit is generating hazardous waste as defined in these Rules : ${fieldValue(bean:hazardeousWasteAuthAppInstance,field:'hw_Defined')}</td>
	</tr>
	<tr>
		<td>&nbsp &nbsp (b)    If so the type and quantity of wastes (in Tonnes/Kl):</td>
	</tr>
	<tr>
		<td > 
			<table border="0" align="left" >
			<g:if test="${hazardeousWasteDetailsList.size() > 0}">
				<tr>
					<td >
						<table width="293" border="1">
						      <tr >
						        <td >Type</td>
						        <td >Quantity(Tonnes/KL)</td>
						      </tr>
						      <g:each in="${hazardeousWasteDetailsList}" status="i" var="indHazardeousWasteDetailsInstance">
						      <tr>
						        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'hw_Type')}</td>
						        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'hw_Qty')}</td>
						      </tr>
						      </g:each>
						</table>
					</td>
				</tr>
			</g:if>
			</table>
		</td>
	</tr>
	<tr>
		<td>5.   (a)    Total capital invested on the project : ${fieldValue(bean:indRegInstance,field:'indCapInvt')}</td>
	</tr>
	<tr>
		<td>&nbsp &nbsp   (b)    Year of commencement of production : ${fieldValue(bean:indRegInstance,field:'dateOfComm')}</td>
	</tr>
	<tr>
		<td>&nbsp &nbsp   (c)    Whether the industry works general/2 shifts/round the clock : ${fieldValue(bean:indRegInstance,field:'shiftsIndustry')}</td>
	</tr>
	<tr>
		<td>6.   (a)    List and quantum of products and by-products(in Tonnes/KL)</td>
	</tr>
	
	<tr>
		<td >
			<table  border="1">
				<tr >
					<td>Product</td>
					<td>Quantity(Tonnes/KL)</td>
					<td>By Products </td>
					<td>By Products Quantity(Tonnes/KL)</td>
				</tr>
				<g:each in="${hwProductDetailsList}" status="i" var="indHWProductDetailsInstance">
				<tr >
					<td>
						${fieldValue(bean:indHWProductDetailsInstance,field:'product_Name')}
					</td>
					<td>
						${fieldValue(bean:indHWProductDetailsInstance,field:'product_Qty')}
					</td>
					<td>
						${fieldValue(bean:indHWProductDetailsInstance,field:'by_Product_Name')}
					</td>
			        <td>
			        	${fieldValue(bean:indHWProductDetailsInstance,field:'by_Product_Qty')}
			        </td>
				</tr>
				</g:each>
			</table>
		</td>
	</tr>
	<tr>
		<td>&nbsp &nbsp   (b)    List and quantum of raw material used(in Tonnes/KL)</td>
	</tr>
	<tr>
		<td >
			<table  border="1">
		      <tr>
		        <td >Raw Material</td>
		        <td >Quantity(Tonnes/KL)</td>
		      </tr>
		      <g:each in="${hwProductDetailsList}" status="i" var="indHWProductDetailsInstance">
		      <tr >
		        <td>
		        	${fieldValue(bean:indHWProductDetailsInstance,field:'raw_Material_Name')}
		        </td>
		        <td>
		        	${fieldValue(bean:indHWProductDetailsInstance,field:'raw_Material_Qty')}
			    </td>
		      </tr>
		      </g:each>
			</table>
		</td>
	</tr>
	<tr>
		<td>7.          Furnish a flow diagram of manufacturing process showing input and output in terms of products,waste generated including for captive generation and demineralised water.</td>
	</tr>
	<tr>
		<g:if test="${flowDiagList.size() > 0}">
		<g:each in="${flowDiagList}" status="i" var="flowDiagInstance">
		<td>&nbsp &nbsp Attached<td>
		</g:each>
		</g:if>
		<g:else>
		<td>&nbsp &nbsp Not Attached<td>
		</g:else>
	</tr>
	<tr>
		<td align="center"><b>Part B: Hazardous Waste</b></td>
	</tr>
	<tr>
		<td>8.   (a)    Type of hazardous wastes generated as defined under these Rules</td>
	</tr>
	<tr>
		<td>&nbsp &nbsp   (b)    Quantum of hazardous waste generated</td>
	</tr>
	<tr>
		<td>&nbsp &nbsp   (c)    Sources and waste characteristics</td>
	</tr>
	<tr>
		<td>&nbsp &nbsp   (d)    Mode of storage within the plant, method of disposal and capacity</td>
	</tr>
	<tr>
		<td>
			<table width="293" border="1">
			      <tr>
			        <td >Type</td>
			        <td >Quantity(Tonnes/KL)</td>
			        <td >Source</td>
			        <td >Mode of Storage </td>
			        <td >Method of Disposal </td>
			        <td >Capacity(Tonnes/KL)</td>
			      </tr>
			      <g:each in="${hazardeousWasteDetailsList}" status="i" var="indHazardeousWasteDetailsInstance">
			      <tr>
			        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'hw_Type')}</td>
			        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'hw_Qty')}</td>
			        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'hw_Source')}</td>
			        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'mode_Of_Storage')}</td>
			        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'method_Of_Disposal')}</td>
			        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'capacity_Of_Disposal')}</td>
			      </tr>
			      </g:each>
			</table>
		</td>
	</tr>
	<tr>
		<td>9.          Hazardous Wastes generated as per these Rules from storage of hazardous chemicals as defined under the Manufacture,Storage and Import of Hazardous Chemicals Rules 1989</td>
	</tr>
<!--	<tr>
		<td>
			<table width="293" border="1">
			      <tr>
			        <td >Type</td>
			        <td >Quantity(Tonnes/KL)</td>
			        <td >Source</td>
			        <td >Mode of Storage </td>
			        <td >Method of Disposal </td>
			        <td >Capacity(Tonnes/KL)</td>
			      </tr>
			      <g:each in="${hazardeousWasteDetailsList}" status="i" var="indHazardeousWasteDetailsInstance">
			      <tr>
			        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'hw_Type')}</td>
			        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'hw_Qty')}</td>
			        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'hw_Source')}</td>
			        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'mode_Of_Storage')}</td>
			        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'method_Of_Disposal')}</td>
			        <td>${fieldValue(bean:indHazardeousWasteDetailsInstance,field:'capacity_Of_Disposal')}</td>
			      </tr>
			      </g:each>
			</table>
		</td>
	</tr> -->
	<tr>
		<td align="center"><b>Part C: Treatment, Storage and Disposal Facility</b></td>
	</tr>
	<tr>
		<td>10.         Detailed proposal of the facility(to be attaced) to include</td>
	</tr>
	<tr>
		<td>&nbsp &nbsp         (a)Location of sit(provide map):</td>
	</tr>
	<tr>
		<g:if test="${siteMapList.size() > 0}">
		<g:each in="${siteMapList}" status="i" var="siteMapListInstance">
		<td>&nbsp &nbsp Attached<td>
		</g:each>
		</g:if>
		<g:else>
		<td>&nbsp &nbsp Not Attached<td>
		</g:else>
	</tr>
	<tr>
		<td>&nbsp &nbsp         (b)Name and Details of waste processing technology:</td>
	</tr>
	<tr>
		<g:if test="${prossTechDetailsList.size() > 0}">
		<g:each in="${prossTechDetailsList}" status="i" var="prossTechDetailsListInstance">
		<td>&nbsp &nbsp Attached <td>
		</g:each>
		</g:if>
		<g:else>
		<td>&nbsp &nbsp Not Attached<td>
		</g:else>
	</tr>
	<tr>
		<td>&nbsp &nbsp         (c)Site Clearance(from local authority,if any):</td>
	</tr>
	<tr>
		<g:if test="${siteClearenceList.size() > 0}">
		<g:each in="${siteClearenceList}" status="i" var="siteClearenceListInstance">
		<td>&nbsp &nbsp Attached <td>
		</g:each>
		</g:if>
		<g:else>
		<td>&nbsp &nbsp Not Attached<td>
		</g:else>
	</tr>
	<tr>
		<td>&nbsp &nbsp         (d)Utilization Programme for waste processed(Product Utilization):</td>
	</tr>
	<tr>
		<g:if test="${utilProgList.size() > 0}">
		<g:each in="${utilProgList}" status="i" var="utilProgListInstance">
		<td>&nbsp &nbsp Attached <td>
		</g:each>
		</g:if>
		<g:else>
		<td>&nbsp &nbsp Not Attached<td>
		</g:else>
	</tr>
	<tr>
		<td>&nbsp &nbsp         (e)Method Of disposal(details in brief be given):</td>
	</tr>
	<tr>
		<g:if test="${disposalMethodList.size() > 0}">
		<g:each in="${disposalMethodList}" status="i" var="disposalMethodListInstance">
		<td>&nbsp &nbsp Attached <td>
		</g:each>
		</g:if>
		<g:else>
		<td>&nbsp &nbsp Not Attached<td>
		</g:else>
	</tr>
	<tr>
		<td>&nbsp &nbsp         (f)Nature and composition of waste:</td>
	</tr>
	<tr>
		<g:if test="${wasteNatureAndCompList.size() > 0}">
		<g:each in="${wasteNatureAndCompList}" status="i" var="wasteNatureAndCompListInstance">
		<td>&nbsp &nbsp Attached<td>
		</g:each>
		</g:if>
		<g:else>
		<td>&nbsp &nbsp Not Attached<td>
		</g:else>
	</tr>
	<tr>
		<td>&nbsp &nbsp         (g)Methodology and operational details of landfilling/incineration:</td>
	</tr>
	<tr>
		<g:if test="${landfillingIncinerationList.size() > 0}">
		<g:each in="${landfillingIncinerationList}" status="i" var="landfillingIncinerationListInstance">
		<td>&nbsp &nbsp Attached<td>
		</g:each>
		</g:if>
		<g:else>
		<td>&nbsp &nbsp Not Attached<td>
		</g:else>
	</tr>
	<tr>
		<td>&nbsp &nbsp         (h)Measures to be taken for prevention and control of environmental pollution including treatment of leachate:</td>
	</tr>
	<tr>
		<g:if test="${prevAndControlList.size() > 0}">
		<g:each in="${prevAndControlList}" status="i" var="prevAndControlListInstance">
		<td>&nbsp &nbsp Attached<td>
		</g:each>
		</g:if>
		<g:else>
		<td>&nbsp &nbsp Not Attached<td>
		</g:else>
	</tr>
	<tr>
		<td>&nbsp &nbsp         (i)Measures to be taken for safety of workers working in the plant:</td>
	</tr>
	<tr>
		<g:if test="${saftyMeasureList.size() > 0}">
		<g:each in="${saftyMeasureList}" status="i" var="saftyMeasureListInstance">
		<td>&nbsp &nbsp Attached<td>
		</g:each>
		</g:if>
		<g:else>
		<td>&nbsp &nbsp Not Attached<td>
		</g:else>
	</tr>
	<tr><td>&nbsp</td></tr>
	<tr>
		<td align="left"><b>Place:</b></td>
		<td align="right"><b>Signature : ...........</b></td>
	</tr>
	<tr>
		<td align="left"><b>Date:</b></td>
		<td align="right"><b>Designation:...........</b></td>
	</tr>
</table>
</td>
</tr>
</table>
</body>
</html>