<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<%@ page import="java.text.*" %>
<%
java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>


<calendar:resources lang="en" theme="aqua"/>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>



<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

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

<style type="text/css">
		.tooltip {
			color: #000000; outline: none;
			cursor: default; text-decoration: none;
			position: relative;
		}
		.tooltip span {
			margin-left: -999em;
			position: absolute;
		}
		.tooltip:hover span {
			border-radius: 5px 5px; -moz-border-radius: 5px; -webkit-border-radius: 5px; 
			box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.1); -webkit-box-shadow: 5px 5px rgba(0, 0, 0, 0.1); -moz-box-shadow: 5px 5px rgba(0, 0, 0, 0.1);
			font-family: Calibri, Tahoma, Geneva, sans-serif;
			position: absolute; left: 1em; top: 2em; z-index: 99;
			margin-left: 0; width: 250px;
		}
		.tooltip:hover img {
			border: 0; margin: -10px 0 0 -55px;
			float: left; position: absolute;
		}
		.tooltip:hover em {
			font-family: Candara, Tahoma, Geneva, sans-serif; font-size: 1.2em; font-weight: bold;
			display: block; padding: 0.2em 0 0.6em 0;
		}
		.classic { padding: 0.8em 1em; }
		.classic {background: #FFFFAA; border: 1px solid #FFAD33; }
</style>

<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

<% String cont=request.getContextPath();

%>

<g:javascript library='scriptaculous'/>

<% 
	String cont1=request.getContextPath();
	if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
			response.sendRedirect(cont1+"/index.gsp")	;	
	 } %>

</head>

<body >
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
        <td height="32" align="left" valign="top" background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}" >
		<!-- code for menuAdminHorizontal-->
		<g:include controller="userMaster" action="showAdminMenuHorizontal"/>
		</td>
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
    	  		 UserProfile aab=(UserProfile)session.getAttribute("userprof");
             		  firstname=aab.employeeFirstName;
           		  lastName=aab.employeeLastName;
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
                <td height="24" bgcolor="#EEEEF3">
					<table width="100%">
	




         
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
       
			<FORM id="myForm" name="myForm" action="searchProdcutDetails" method="post">  
	   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
         
	
	
	
	
	
	
	<table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
    
	<tr bgcolor="#E8F6F9">
    <td width="15%" align="left"  class="headngblue" >Start Date :<span style="color:red">*</span></td>
    <td width="33%" align="left" >
	<calendar:datePicker name="start_date" dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
    </td>
    <td  width="15%" align="left"  class="headngblue">End Date :<span style="color:red">*</span></td>
    <td align="left" width="37%"  >
	<calendar:datePicker name="end_date"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
    </td>
</tr>
<div id="autocomplete_choices" class="autocomplete1" ></div>
<tr bgcolor="#E8F6F9">
<td width="15%" align="left"  class="headngblue" >Application Type :</td>
<td align="left">
     <select class="txt4" name="appType" id="appType" >
         <option value="All">All</option>
         <option value="CTE">CTE</option>
         <option value="CTO">CTO</option>
        
    </select>
</td>
<%
def indList= IndustryTypeMaster.findAll("from IndustryTypeMaster where dashboard!=0 order by industryType asc")
%>
<td width="15%" align="left"  class="headngblue" >Industry Type :</td>
<td width="20%" align="left" colspan="0">
<g:select optionKey="id" from="${indList}" name="autocomplete_parameter1" id="autocomplete1" noSelection="${[All:'All']}" style="width:500px;" class="txt4"></g:select>
<span class="txt4">(Select Industry Type)</span>
</td>

  </tr>
  <tr bgcolor="#E8F6F9">
  <td width="15%" align="left"  class="headngblue" >Status :</td>
  <td align="left">
       <select class="txt4" name="status" id="status" >
           <option value="All">All</option>
           <option value="pending">Pending</option>
           <option value="approved">Approved</option>
           <option value="rejected">Rejected</option>
          
      </select>
  </td>
  </tr>
 </table>

 <table width="100%" align="center">
	
 <tr>
 <td align="center"><input type="submit" name="save" value="Search" class="actionbutton" ></td>

</tr>

</table>


<g:if test="${flash.message}"><div class="error">${flash.message}</div></g:if>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="white" class="tab-txt" style="border-collapse:collapse;">
<tr>
	
       <%
       String dd1;
       String dd2;
       String dd3;
       if(sqlDate)
       {
       java.util.Date utilDate1 = new java.util.Date(sqlDate.getTime());
       java.util.Date utilDate2 = new java.util.Date(sqlDate2.getTime());
       java.util.Date utilDate3 = new java.util.Date(sqlDate3.getTime());

       SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");

       dd1=dmyFormat.format(utilDate1);
       dd2=dmyFormat.format(utilDate2);
       dd3=dmyFormat.format(utilDate3);
       }
       %>
       
      
      </tr> 
      <tr>
         <td colspan="9" align="center" ><span class="headngblue"> 
         <% if(dd1 && dd1.length()>3) {%>From <font color="red"> <%=dd1%></font> To <font color="red"><%=dd3%></font><%}%>
         </span>
         </td>
     </tr>
     
     
     <tr>
    <td colspan="9" align="center" ><span class="headngblue"> 
    <% if(group){%>Regional Office :
    	<% if(group=='NotSelected'){ %>
    	<font color="red">All</font>
    	<% }else{ %>
    	<font color="red"> <%=group%></font> <%}}%>
    </span>
    </td>
    </tr>
    
    
   <tr>
       <td colspan="9" align="center" ><span class="headngblue"> 
       <% if(status) {%>Status :<font color="red"> <%=status%></font> <%}%>
       </span>
       </td>
   </tr>
   
   <tr>
   <td colspan="9" align="center" ><span class="headngblue"> 
   <% if(indName){%>Industry Type :
   	<% if(indName==""){ %>
   	<font color="red">All</font>
   	<% }else{ %>
   	<font color="red"> <%=indName%></font> <%}}else{%>Industry Type :
	<font color="red">All</font>
	<% }%>
   	</span>
   </td>
   </tr>
   
   
   
   
   
   
   
   <tr>
    <td colspan="9" align="center" ><span class="headngblue"> 
    <% if(category){%>Category :
    	<% if(category=='101'){ %>
    	<font color="red">All</font>
    	<% }else{ %>
    	<font color="red"> <%=category%></font> <%}}%>
    </span>
    </td>
    </tr>
   
    
      <tr><td></td></tr>
	

</table>






	
	<br>
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >             
	  <tr>
	  <td colspan="9" align="right" ><a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popSearchByIndustryTypeExcWithProdNew', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
	  <span class="headngblue">Print in Excel Format</span></a>
	  </td>
</tr> 
	  
	    </table>
		
		
		
         
	
<!--  tables for records start-->		

<div style="overflow: auto;height: 300px; width: 1000px;">

	<table width=100% align="center" cellpadding="0" cellspacing="0"  class="tab-txt" border="1">
<tr width="100%" bgcolor="#A8DAF3"  >
           
           	       <th align="center" rowspan="2" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >S.No.</th>
           	       <th align="center" rowspan="2" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue">Name Of the Unit</th>
           	       <th align="center" rowspan="2" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue">Application No</th>
           	       <th align="center" rowspan="2" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >Application Type</th>
           	       <th align="center" rowspan="2" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >Industry Type</th>
           	       <th align="center" rowspan="2" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >Application Date</th>
           	       <th align="center" rowspan="2" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >District</th>
           	       <th align="center" rowspan="2" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >Category</th>
    	           <th align="center" rowspan="2" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue">Status</th>
    	           <th align="center" colspan="2" width="100%" style="white-space:nowrap;border-bottom:3px solid green;" class="headngblue" >Product Details</th>

    	    </tr>
    	    <tr>
            <th align="center"  class="headngblue">Product Name</th>
            <th align="center"  class="headngblue">Quantity</th>
            </tr>
            <%if(!industryTypeList || industryTypeList.size()==0){%>
            <td align="left" colspan="5">No Record Founds..</td>
            <%}%>
           	<g:each in="${industryTypeList}" status="i" var="industryRegMasterListInstance">
           	<tr>
           	<% 
           	System.out.println("----industryRegMasterListInstance.applicationId-"+industryRegMasterListInstance.applicationId)
           	def app=IndApplicationDetails.get(industryRegMasterListInstance.applicationId.toLong())
           	System.out.println("----app-"+app)
           	def listProduct=new ArrayList();
           	def productDetails=IndProductDetails.findAllByApplication(app)
           	System.out.println("----productDetails-34-"+productDetails.toString())
           	if(productDetails){
           	for(int ii=0;ii<productDetails.size();ii++){
           	def mapdata= new HashMap<String ,String>();
           	mapdata.put("ProductName",productDetails.get(ii).product)
           	mapdata.put("Quantity",productDetails.get(ii).quantity+" "+productDetails.get(ii).unitbyProduct.unitName)
           	listProduct.add(mapdata)
           	}
           	}
           //	System.out.println("----listProduct-34-"+listProduct.toString())
           	%>
           	
           	          <td align="center"><%=(i+1)%></td>
           	          <td align="center"><%=industryRegMasterListInstance.applicationName%></td>
           	          <td align="center"><%=industryRegMasterListInstance.applicationId%></td>
           	          <td align="center"><%=industryRegMasterListInstance.applicationType%></td>
           	          <td align="center"><%=industryRegMasterListInstance.indTypeName%></td>
           	          <td align="center"><g:formatDate format="dd-MM-yyyy" date="${industryRegMasterListInstance.applicationRecieptDate}"/></td>
           	          <td align="center"><%=industryRegMasterListInstance.districtName%></td>
           	       
           	       <td align="center"><%=industryRegMasterListInstance.indCategoryName%></td>
           	          <td align="center"><%=industryRegMasterListInstance.applicationStatus%></td>
           	       <td align="center" colspan="2"><%if(productDetails){%><Table width="100%" cellpadding="0"   class="tab-txt" border="1" ><g:each in="${listProduct}" status="i3" var="listProduct3"><tr><td align="left" width="60%"><%=listProduct3.ProductName%> </td><td></td><td align="right" width="40%"><%=listProduct3.Quantity%> </td>  </tr></g:each></table>  <% }else{%> <% }%></td>
            	</tr>
           	</g:each>
           	       
           	       
        
</table>

</div>
		
            <br />
            <br />
          
		  </form>
          </div>
      </div></td>
                            <td width="82" align="left" valign="top">&nbsp;</td>
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
<g:javascript>
		window.onload = function()   
           	  {              
			   	  new Ajax.Autocompleter("autocomplete1","autocomplete_choices","<%=cont%>/groupMaster/ajaxAutoCompleteType",{} );         
			 }
</g:javascript>
</html>