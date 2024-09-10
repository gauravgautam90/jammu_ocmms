<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>

<%
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

td{
	text-align:center;	
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

<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

<% String cont=request.getContextPath();

%>

<g:javascript library='scriptaculous'/>
<g:javascript>
		window.onload = function()   
           	  {              
			   	  new Ajax.Autocompleter("autocomplete1","autocomplete_choices","<%=cont%>/groupMaster/ajaxAutoCompleteTest",{} );             
			 }
</g:javascript>

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
       
			<FORM id="myForm" name="myForm" action="industryDetails" method="post">  
	   
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
         
         <tr>
         <td colspan="9" align="center" >
         <b><p align="center">
	           <font face="Verdana">Applied Industrial Units as on <%=today%><br>
               </font>
               <i><font color="#800000" size="2" face="Verdana">(Revenue District : <%=districtMasterInstance%> &nbsp;)</font></i>
          </p></b>
         </td>
         </tr>                  
	  <tr>
<td colspan="9" align="right" style="text-align:right;" >
<a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popDistrictTehsilExc', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
<span class="headngblue">Print in Excel Format</span></a>
</td>
</tr> 
	  
	    </table>
		

	    
	    
	    
<div style="overflow: auto;height: 600px; width: 1000px;">
		

<table width=100% align="center" border="2" style="border:3px solid green; " cellpadding="0" cellspacing="0"  class="tab-txt">

 
		<tr width="100%" bgcolor="#CCFFCC"  >
							<th align="center" width="7%"  class="headngblue" rowspan="2" >S. No.</th>
							<th align="center" width="16%" class="headngblue" rowspan="2" >Taluk</th>
							<th align="center" colspan="3" class="headngblue" >Large</th>
							<th align="center" colspan="3" class="headngblue" >Medium</th>
							<th align="center" colspan="3" class="headngblue" >Small</th>
                   	        <th align="center" width="7%" class="headngblue" rowspan="2">Total</th>  
        </tr>
        
        <tr width="100%" bgcolor="#CCFFCC"  >
        	 				<th align="center" width="7%" class="headngblue" >Red</th>
        	 				<th align="center" width="7%" class="headngblue" >Orange</th>
        	 				<th align="center" width="7%" class="headngblue" >Green</th>
        	 				<th align="center" width="7%" class="headngblue" >Red</th>
        	 				<th align="center" width="7%" class="headngblue" >Orange</th>
        	 				<th align="center" width="7%" class="headngblue" >Green</th>
        	 				<th align="center" width="7%" class="headngblue" >Red</th>
        	 				<th align="center" width="7%" class="headngblue" >Orange</th>
        	 				<th align="center" width="7%" class="headngblue" >Green</th>
        </tr>
                  
                  	<% 	
                  	long  diff = 0
                  	int diffDays = 0
                  	 def pendDetails
                  	
                
                   def pendingLists = new ArrayList()
                   def  pendingDetails1 
                   def applicationFileRecordInstance
                   def pendingLists1 = new ArrayList()
                  	
                   def districtList  
                    	
                    def grandTotalRedSmall = 0 
            		def grandTotalRedMedium = 0
            		def grandTotalRedLarge = 0
            		def grandTotalOrangeSmall = 0 
             		def grandTotalOrangeMedium = 0
             		def grandTotalOrangeLarge = 0
             		def grandTotalGreenSmall = 0 
             		def grandTotalGreenMedium = 0
             		def grandTotalGreenLarge = 0
             		
             	
                  
                  	%>
    <g:each in="${tehsilMasterList}" status="i" var="tehsilMasterListInstance">
    
             <tr width="100%" bgcolor="${(i % 2) == 0 ? '#CCFFCC' : '#A3CCA3'}"> 
                   	       
                   	       <td align="center" >
                   	       <%=(i+1)%>
                   	       </td>
                          
                           <td  width="15%" style="text-align:left;white-space:nowrap;">
                           <g:link target="_blank" method="post" action="districtTehsilVillage" params="[tehsil:tehsilMasterListInstance.id,district:districtMasterInstance.id]"><font size="2%"><%=tehsilMasterListInstance%></font> <font color="brown"> </font></g:link>
                   	       
                           </td>

                   	     
                      	  <td>
                       	      <%  def redLargeTotalIndex =new ArrayList()
                       	      def varLR
                       	      def redLarge
                       	      redLarge = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Large'  and apd.application.indUser.category.name = 'RED' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	      varLR=  redLarge.size()
                       	      %>
                       	      <% if(varLR!=0){ %>   
                       	          <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/getAppValueForDistrictTehsil?district=${districtMasterInstance.id}&tehsil=${tehsilMasterListInstance.id}&category=redL', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                       	        
                          <font size="2%"> <%=redLarge.size()%></font> <font color="brown"> </font>
                       	</a>
                       	<% } else {%>
                       	<a href="#" style="cursor:default">
     		            <font size="2%"> <%=varLR%></font>
         	            </a>
                       	<%}%>
                       	   <%
                       	    redLargeTotalIndex.add(varLR)
                       	    grandTotalRedLarge=grandTotalRedLarge+varLR;
                       	   %> 
                       	     </td>
                       	     
                       	     
                      <td>
                	  <%  def orangeLargeTotalIndex =new ArrayList()
                   	      def varLO
                   	      def orangeLarge
                   	      orangeLarge = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Large'  and apd.application.indUser.category.name = 'ORANGE' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	  varLO=  orangeLarge.size()
                   	      %>
                   	      <% if(varLO!=0){ %>   
                   	        <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/getAppValueForDistrictTehsil?district=${districtMasterInstance.id}&tehsil=${tehsilMasterListInstance.id}&category=orangeL', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                   	        
                      <font size="2%"> <%=orangeLarge.size()%></font> <font color="brown"> </font>
                   	</a>
                   	<% } else {%>
                   	<a href="#" style="cursor:default">
 		            <font size="2%"> <%=varLO%></font>
     	            </a>
                   	<%}%>
                   	    
                   	   <%
                   	    orangeLargeTotalIndex.add(varLO)
                   	    grandTotalOrangeLarge=grandTotalOrangeLarge+varLO;
                   	   %> 
                   	      </td>
                       	     
                       	     
                      <td  >
                	      <%  def greenLargeTotalIndex =new ArrayList()
                   	      def varLG
                   	      def greenLarge
                   	      greenLarge = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Large' and apd.application.indUser.category.name = 'GREEN' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	   varLG=  greenLarge.size()
                   	      %>
                   	      <% if(varLG!=0){ %>   
                   	       <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/getAppValueForDistrictTehsil?district=${districtMasterInstance.id}&tehsil=${tehsilMasterListInstance.id}&category=greenL', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                   	   <font size="2%"> <%=greenLarge.size()%></font> <font color="brown"> </font>
                   	</a>   
                   	<% } else {%>
                   	<a href="#" style="cursor:default">
 		            <font size="2%"> <%=varLG%></font>
     	            </a>
                   	<%}%>
                   	   <%
                   	   	  greenLargeTotalIndex.add(varLG)
                   	   grandTotalGreenLarge=grandTotalGreenLarge+varLG;
                   	   %> 
                   	  </td>
                   	     
                   	     
                   	     
                   	     
                   	  <td >
             	           <%  def redMediumTotalIndex =new ArrayList()
                   	      def varMR
                   	      def redMedium
                   	      redMedium = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Medium'  and apd.application.indUser.category.name = 'RED' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	  varMR=  redMedium.size()
                   	      
                   	      %>
                   	      <% if(varMR!=0){ %>   
                   	      <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/getAppValueForDistrictTehsil?district=${districtMasterInstance.id}&tehsil=${tehsilMasterListInstance.id}&category=redM', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                   	        
                      <font size="2%"> <%=redMedium.size()%></font> <font color="brown"> </font>
                   	</a>     
                   	<% } else {%>
                   	<a href="#" style="cursor:default">
 		            <font size="2%"> <%=varMR%></font>
     	            </a>
                   	<%}%>
                   	   <%
                   	   	redMediumTotalIndex.add(varMR)
                   	    grandTotalRedMedium=grandTotalRedMedium+varMR;
                   	   %> 
                   	  </td>
             
             
                   	  <td >
                   	      <%  def orangeMediumTotalIndex =new ArrayList()
                   	      def varMO
                   	      def orangeMedium
                   	      orangeMedium = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Medium'  and apd.application.indUser.category.name = 'ORANGE' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	  varMO=  orangeMedium.size()
                   	      
                   	      %>
                   	      <% if(varMO!=0){ %>   
                   	      <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/getAppValueForDistrictTehsil?district=${districtMasterInstance.id}&tehsil=${tehsilMasterListInstance.id}&category=orangeM', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                   	        
                      <font size="2%"> <%=orangeMedium.size()%></font> <font color="brown"> </font>
                   	</a>      
                   	<% } else {%>
                   	<a href="#" style="cursor:default">
 		            <font size="2%"> <%=varMO%></font>
     	            </a>
                   	<%}%>
                   	   <%
                   	   orangeMediumTotalIndex.add(varMO)
                   	   grandTotalOrangeMedium=grandTotalOrangeMedium+varMO;
                   	  %> 
                   	  </td>   
                   	     
          
                   	  <td>
             	        <%  def greenMediumTotalIndex =new ArrayList()
                   	      def varMG
                   	      def greenMedium
                   	      greenMedium = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Medium'  and apd.application.indUser.category.name = 'GREEN' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	  varMG=  greenMedium.size()
                   	      %>
                   	      <% if(varMG!=0){ %>   
                   	      <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/getAppValueForDistrictTehsil?district=${districtMasterInstance.id}&tehsil=${tehsilMasterListInstance.id}&category=greenM', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                   	        
                      <font size="2%"> <%=greenMedium.size()%></font> <font color="brown"> </font>
                   	</a>
                   	<% } else {%>
                   	<a href="#" style="cursor:default">
 		            <font size="2%"> <%=varMG%></font>
     	            </a>
                   	<%}%>
                   	    
                   	   <%
                   	   greenMediumTotalIndex.add(varMG)
                   	   grandTotalGreenMedium=grandTotalGreenMedium+varMG;
                   	   %> 
                   	  </td>
          
          
              
              
               <td >
                   	   <%     ArrayList redSmallTotalIndex = new ArrayList()
                   	     def redSmall
                   	       def varSR
                   	       redSmall = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Small'  and apd.application.indUser.category.name = 'RED' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	   varSR=  redSmall.size()
                   	      
                   	      %>
                   	         <% if(varSR!=0){ %>   
                    	     <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/getAppValueForDistrictTehsil?district=${districtMasterInstance.id}&tehsil=${tehsilMasterListInstance.id}&category=redS', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                   	         
                      <font size="2%"> <%=redSmall.size()%></font> <font color="brown"> </font>
                   	   </a>
                   	<% } else {%>
                   	<a href="#" style="cursor:default">
 		            <font size="2%"> <%=varSR%></font>
     	            </a>
                   	<%}%>
                   	                	    
                   	   <%
                   	     redSmallTotalIndex.add(varSR)
                   	     grandTotalRedSmall=grandTotalRedSmall+varSR;
                   	    %> 
                   	   </td>
          
           
                   	    <td>
                	      <%     ArrayList orangeSmallTotalIndex = new ArrayList()
                   	     def orangeSmall
                   	       def varSO
                   	       orangeSmall = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Small'  and apd.application.indUser.category.name = 'ORANGE' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	   varSO=orangeSmall.size()
                   	      %>
                   	         <% if(varSO!=0){ %>   
                 	         <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/getAppValueForDistrictTehsil?district=${districtMasterInstance.id}&tehsil=${tehsilMasterListInstance.id}&category=orangeS', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                   	         
                      <font size="2%"> <%=orangeSmall.size()%></font> <font color="brown"> </font>
                   	   </a>
                   	<% } else {%>
                   	<a href="#" style="cursor:default">
 		            <font size="2%"> <%=varSO%></font>
     	            </a>
                   	<%}%>
                   	   <%
                   	     orangeSmallTotalIndex.add(varSO)
                   	     grandTotalOrangeSmall=grandTotalOrangeSmall+varSO;
                   	    %> 
                   	     </td>
                     
                   	     
                    	  <td   >
                 	           <%     ArrayList greenSmallTotalIndex = new ArrayList()
                       	     def greenSmall
                       	       def varSG
                       	   	   greenSmall = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Small'  and apd.application.indUser.category.name = 'GREEN' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	          varSG=  greenSmall.size()
                       	      
                       	      %>
                       	         <% if(varSG!=0){ %>   
                  	             <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/getAppValueForDistrictTehsil?district=${districtMasterInstance.id}&tehsil=${tehsilMasterListInstance.id}&category=greenS', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                       	         
                          <font size="2%"> <%=greenSmall.size()%></font> <font color="brown"> </font>
                       	   </a>
                       	<% } else {%>
                       	<a href="#" style="cursor:default">
     		            <font size="2%"> <%=varSG%></font>
         	            </a>
                       	<%}%>
                       	   <%
                       	     greenSmallTotalIndex.add(varSG) 
                       	     grandTotalGreenSmall=grandTotalGreenSmall+varSG;
                       	   %> 
                       	                         	     </td>
                   	     
                   	    <td>
                   	        <font size="2%">
                   	        <%=varSG+varSO+varSR+varMG+varMO+varMR+varLG+varLO+varLR%>
                   	        </font>
                       	     
                       	     
                       	     
                       	     
                       	     
                       	     
                       	     </tr>
                   	      
               </g:each>
               <tr style="padding:5px;">
                    <td colspan="2" style="text-align:right;padding:5px;">Grand Total</td>
                    <td ><%=grandTotalRedLarge%></td>
                    <td ><%=grandTotalOrangeLarge%></td>
                    <td ><%=grandTotalGreenLarge%></td>
                    <td ><%=grandTotalRedMedium%></td>
                    <td ><%=grandTotalOrangeMedium%></td>
                    <td ><%=grandTotalGreenMedium%></td>
                    <td ><%=grandTotalRedSmall%></td>
                    <td ><%=grandTotalOrangeSmall%></td>
                    <td ><%=grandTotalGreenSmall%></td>
                    <td ><%=(grandTotalRedSmall+grandTotalRedMedium+grandTotalRedLarge+grandTotalOrangeSmall+grandTotalOrangeMedium+grandTotalOrangeLarge+grandTotalGreenSmall+grandTotalGreenMedium+grandTotalGreenLarge)%></td>
               </tr>
              </tr>
              <tr bgcolor="#CCFFCC">
             
              
             
                
              </tr>
                
                
                </table>
		

		

		
            <br />
            <br />
          </div> 
		  
		  </form>
		  
	 
          </div>
	  
	  
	  <script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script> 
	
	
	<script language="JavaScript" type="text/javascript">
 

 
 
 var frmvalidator  = new Validator("myForm");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
    
    
     function check()
 {	
 
 
    var frm = document.getElementById('consentType').value;
    
       var frm1 = document.getElementById('status').value;
   
   if(frm1=='NotSelected'){
        alert("Please Select Application Type");
  	 	return false;
  	}
  	
    if(frm=='NotSelected'){
        alert("Please Select Consent Type");
  	 	return false;
  	}
  	 
   
    return true;
	
  }

frmvalidator.setAddnlValidationFunction("check");


</script>
	
	  
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
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
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>


