<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
<% 
response.setContentType("application/vnd.ms-excel");
response.setHeader("Content-Disposition", "inline;filename=popDistrictTehsilExc.xls");
%>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>
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
	     </table>
		

	    
	    
	    
<div>
		

<table width=100% align="center" border="2" style="border:3px solid green; " cellpadding="0" cellspacing="0"  class="tab-txt">

 
		<tr width="100%" bgcolor="#CCFFCC"  >
							<th align="center" width="7%"  class="headngblue" rowspan="2" >S. No.</th>
							<th align="center" width="16%" class="headngblue" rowspan="2" >Taluk</th>
							<th align="center" colspan="4" class="headngblue" >Large</th>
							<th align="center" colspan="4" class="headngblue" >Medium1</th>
							<th align="center" colspan="4" class="headngblue" >Small</th>
							<th align="center" colspan="4" class="headngblue" >Micro</th>
                   	        <th align="center" width="6%" class="headngblue" rowspan="2">Total</th>  
        </tr>
        
       <tr width="100%" bgcolor="#CCFFCC"  >
        	 				<th align="center" width="5%" class="headngblue" >Red A</th>
        	 				<th align="center" width="5%" class="headngblue" >Orange</th>
        	 				<th align="center" width="5%" class="headngblue" >Green</th>
        	 				<th align="center" width="5%" class="headngblue" >Red B</th>
        	 				<th align="center" width="5%" class="headngblue" >Red A</th>
        	 				<th align="center" width="5%" class="headngblue" >Orange</th>
        	 				<th align="center" width="5%" class="headngblue" >Green</th>
        	 				<th align="center" width="5%" class="headngblue" >Red B</th>
        	 				<th align="center" width="5%" class="headngblue" >Red A</th>
        	 				<th align="center" width="5%" class="headngblue" >Orange</th>
        	 				<th align="center" width="5%" class="headngblue" >Green</th>
        	 				<th align="center" width="5%" class="headngblue" >Red B</th>
        	 				<th align="center" width="5%" class="headngblue" >Red A</th>
        	 				<th align="center" width="5%" class="headngblue" >Orange</th>
        	 				<th align="center" width="5%" class="headngblue" >Green</th>
        	 				<th align="center" width="5%" class="headngblue" >Red B</th>
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
                    
                    def grandTotalRedAMicro = 0	
                    def grandTotalRedASmall = 0 
            		def grandTotalRedAMedium = 0
            		def grandTotalRedALarge = 0
            		def grandTotalOrangeMicro = 0
            		def grandTotalOrangeSmall = 0 
             		def grandTotalOrangeMedium = 0
             		def grandTotalOrangeLarge = 0
             		def grandTotalGreenMicro = 0
             		def grandTotalGreenSmall = 0 
             		def grandTotalGreenMedium = 0
             		def grandTotalGreenLarge = 0
             		def grandTotalRedBMicro = 0	
                    def grandTotalRedBSmall = 0 
            		def grandTotalRedBMedium = 0
            		def grandTotalRedBLarge = 0
             		
             	
                  
                  	%>        
 <g:each in="${tehsilMasterList}" status="i" var="tehsilMasterListInstance">
    
             <tr width="100%" bgcolor="${(i % 2) == 0 ? '#CCFFCC' : '#A3CCA3'}"> 
                   	       
                   	       <td align="center" >
                   	       <%=(i+1)%>
                   	       </td>
                          
                           <td  width="15%" style="text-align:left;white-space:nowrap;">
                           <%=tehsilMasterListInstance%>
                   	       
                           </td>
                           
                           
                <td>
                       	      <%  def redALargeTotalIndex =new ArrayList()
                       	      def varLRA
                       	      def redALarge
                       	      redALarge = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Large'  and apd.application.indUser.category.name = 'RED A' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	      varLRA=  redALarge.size()
                       	      %>
                       	      <% if(varLRA!=0){ %>   
                       	          <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/getAppValueForDistrictTehsil?district=${districtMasterInstance.id}&tehsil=${tehsilMasterListInstance.id}&category=redAL', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                       	        
                          <font size="2%"> <%=redLarge.size()%></font> <font color="brown"> </font>
                       	</a>
                       	<% } else {%>
                       	<a href="#" style="cursor:default">
     		            <font size="2%"> <%=varLRA%></font>
         	            </a>
                       	<%}%>
                       	   <%
                       	    redALargeTotalIndex.add(varLRA)
                       	    grandTotalRedALarge=grandTotalRedALarge+varLRA;
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
                   	      greenLarge = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Large'  and apd.application.indUser.category.name = 'GREEN' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	   varLG=greenLarge.size()
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
                   	  
                   	                 
                <td>
                       	      <%  def redBLargeTotalIndex =new ArrayList()
                       	      def varLRB
                       	      def redBLarge
                       	      redBLarge = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Large'  and apd.application.indUser.category.name = 'RED B' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	      
                       	      varLRB= redBLarge.size()
                       	      %>
                       	      <% if(varLRB!=0){ %>   
                       	          <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/getAppValueForDistrictTehsil?district=${districtMasterInstance.id}&tehsil=${tehsilMasterListInstance.id}&category=redBL', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                       	        
                         <font size="2%"> <%=redBLarge.size()%></font> <font color="brown"> </font>
                       	</a>
                       	<% } else {%>
                       	<a href="#" style="cursor:default">
     		            <font size="2%"> <%=varLRB%></font>
         	            </a>
                       	<%}%>
                       	   <%
                       	    redBLargeTotalIndex.add(varLRB)
                       	    grandTotalRedBLarge=grandTotalRedBLarge+varLRB;
                       	   %> 
                       	     </td>
                       	     
                  <td >
             	           <%  def redAMediumTotalIndex =new ArrayList()
                   	      def varMRA
                   	      def redAMedium
                   	      redAMedium = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Medium'  and apd.application.indUser.category.name = 'RED A' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	  varMRA=  redAMedium.size()
                   	      
                   	      %>
                   	      <% if(varMRA!=0){ %>   
                   	      <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/getAppValueForDistrictTehsil?district=${districtMasterInstance.id}&tehsil=${tehsilMasterListInstance.id}&category=redAM', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                   	        
                      <font size="2%"> <%=redAMedium.size()%></font> <font color="brown"> </font>
                   	</a>     
                   	<% } else {%>
                   	<a href="#" style="cursor:default">
 		            <font size="2%"> <%=varMRA%></font>
     	            </a>
                   	<%}%>
                   	   <%
                   	   	redAMediumTotalIndex.add(varMRA)
                   	    grandTotalRedAMedium=grandTotalRedAMedium+varMRA;
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
             	           <%  def redBMediumTotalIndex =new ArrayList()
                   	      def varMRB
                   	      def redBMedium
                   	      redBMedium = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Medium'  and apd.application.indUser.category.name = 'RED B' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	  varMRB=  redBMedium.size()
                   	      
                   	      %>
                   	      <% if(varMRB!=0){ %>   
                   	      <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/getAppValueForDistrictTehsil?district=${districtMasterInstance.id}&tehsil=${tehsilMasterListInstance.id}&category=redBM', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                   	        
                      <font size="2%"> <%=redBMedium.size()%></font> <font color="brown"> </font>
                   	</a>     
                   	<% } else {%>
                   	<a href="#" style="cursor:default">
 		            <font size="2%"> <%=varMRB%></font>
     	            </a>
                   	<%}%>
                   	   <%
                   	   	redAMediumTotalIndex.add(varMRB)
                   	    grandTotalRedBMedium=grandTotalRedBMedium+varMRB;
                   	   %> 
                   	  </td>
                   	  
                   	     
               <td >
                   	   <%     ArrayList redASmallTotalIndex = new ArrayList()
                   	     def redASmall
                   	       def varSRA
                   	       redASmall = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Small'  and apd.application.indUser.category.name = 'RED A' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	   varSRA=  redASmall.size()
                   	      
                   	      %>
                   	         <% if(varSRA!=0){ %>   
                    	     <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/getAppValueForDistrictTehsil?district=${districtMasterInstance.id}&tehsil=${tehsilMasterListInstance.id}&category=redAS', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                   	         
                      <font size="2%"> <%=redASmall.size()%></font> <font color="brown"> </font>
                   	   </a>
                   	<% } else {%>
                   	<a href="#" style="cursor:default">
 		            <font size="2%"> <%=varSRA%></font>
     	            </a>
                   	<%}%>
                   	                	    
                   	   <%
                   	     redASmallTotalIndex.add(varSRA)
                   	     grandTotalRedASmall=grandTotalRedASmall+varSRA;
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
         <td >
                   	   <%     ArrayList redBSmallTotalIndex = new ArrayList()
                   	     def redBSmall
                   	       def varSRB
                   	       redBSmall = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Small'  and apd.application.indUser.category.name = 'RED B' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	   varSRB=  redBSmall.size()
                   	      
                   	      %>
                   	         <% if(varSRB!=0){ %>   
                    	     <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/getAppValueForDistrictTehsil?district=${districtMasterInstance.id}&tehsil=${tehsilMasterListInstance.id}&category=redBS', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                   	         
                      <font size="2%"> <%=redBSmall.size()%></font> <font color="brown"> </font>
                   	   </a>
                   	<% } else {%>
                   	<a href="#" style="cursor:default">
 		            <font size="2%"> <%=varSRB%></font>
     	            </a>
                   	<%}%>
                   	                	    
                   	   <%
                   	     redBSmallTotalIndex.add(varSRB)
                   	     grandTotalRedBSmall=grandTotalRedBSmall+varSRB;
                   	    %> 
                   	   </td>
              
              
               <td >
                   	   <%     ArrayList redAMicroTotalIndex = new ArrayList()
                   	     def redAMicro
                   	       def varmRA
                   	       redAMicro = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Micro'  and apd.application.indUser.category.name = 'RED A' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	   varmRA=  redAMicro.size()
                   	      
                   	      %>
                   	         <% if(varmRA!=0){ %>   
                    	     <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/getAppValueForDistrictTehsil?district=${districtMasterInstance.id}&tehsil=${tehsilMasterListInstance.id}&category=redAS', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                   	         
                      <font size="2%"> <%=redAMicro.size()%></font> <font color="brown"> </font>
                   	   </a>
                   	<% } else {%>
                   	<a href="#" style="cursor:default">
 		            <font size="2%"> <%=varmRA%></font>
     	            </a>
                   	<%}%>
                   	                	    
                   	   <%
                   	     redAMicroTotalIndex.add(varmRA)
                   	     grandTotalRedAMicro=grandTotalRedAMicro+varmRA;
                   	    %> 
                   	   </td>   
                   	   
                   	    <td >
                   	   <%     ArrayList orangeMicroTotalIndex = new ArrayList()
                   	     def orangeMicro
                   	       def varmO
                   	       orangeMicro = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Micro'  and apd.application.indUser.category.name = 'ORANGE' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	   varmO=  orangeMicro.size()
                   	      
                   	      %>
                   	         <% if(varmRA!=0){ %>   
                    	     <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/getAppValueForDistrictTehsil?district=${districtMasterInstance.id}&tehsil=${tehsilMasterListInstance.id}&category=redAS', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                   	         
                      <font size="2%"> <%=orangeMicro.size()%></font> <font color="brown"> </font>
                   	   </a>
                   	<% } else {%>
                   	<a href="#" style="cursor:default">
 		            <font size="2%"> <%=varmO%></font>
     	            </a>
                   	<%}%>
                   	                	    
                   	   <%
                   	     orangeMicroTotalIndex.add(varmO)
                   	     grandTotalOrangeMicro=grandTotalOrangeMicro+varmO;
                   	    %> 
                   	   </td>    
                   	   
                   	    <td >
                   	   <%     ArrayList greenMicroTotalIndex = new ArrayList()
                   	     def greenMicro
                   	       def varmG
                   	       greenMicro = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Micro'  and apd.application.indUser.category.name = 'GREEN' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	   varmG=  greenMicro.size()
                   	      
                   	      %>
                   	         <% if(varmRA!=0){ %>   
                    	     <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/getAppValueForDistrictTehsil?district=${districtMasterInstance.id}&tehsil=${tehsilMasterListInstance.id}&category=redAS', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                   	         
                      <font size="2%"> <%=greenMicro.size()%></font> <font color="brown"> </font>
                   	   </a>
                   	<% } else {%>
                   	<a href="#" style="cursor:default">
 		            <font size="2%"> <%=varmG%></font>
     	            </a>
                   	<%}%>
                   	                	    
                   	   <%
                   	     greenMicroTotalIndex.add(varmG)
                   	     grandTotalGreenMicro=grandTotalGreenMicro+varmG;
                   	    %> 
                   	   </td>    
                   	   
                   	     <td >
                   	   <%     ArrayList redBMicroTotalIndex = new ArrayList()
                   	     def redBMicro
                   	       def varmRB
                   	       redBMicro = ApplicationPendingDetails.executeQuery("select distinct(apd.application.indUser.id) from ApplicationPendingDetails apd where apd.application.indUser.district.districtName = ? and apd.application.indUser.tehsil.tehsilName = ? and apd.application.indUser.industryScale = 'Micro'  and apd.application.indUser.category.name = 'RED B' ",[(districtMasterInstance.districtName),(tehsilMasterListInstance).toString()])
                       	   varmRB=  redBMicro.size()
                   	      
                   	      %>
                   	         <% if(varmRB!=0){ %>   
                    	     <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/getAppValueForDistrictTehsil?district=${districtMasterInstance.id}&tehsil=${tehsilMasterListInstance.id}&category=redAS', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
                   	         
                      <font size="2%"> <%=redBMicro.size()%></font> <font color="brown"> </font>
                   	   </a>
                   	<% } else {%>
                   	<a href="#" style="cursor:default">
 		            <font size="2%"> <%=varmRB%></font>
     	            </a>
                   	<%}%>
                   	                	    
                   	   <%
                   	     redAMicroTotalIndex.add(varmRB)
                   	     grandTotalRedBMicro=grandTotalRedBMicro+varmRB;
                   	    %> 
  <td>
                   	        <font size="2%">
                   	        <%=varmRA+varmO+varmG+varmRB+varSG+varSO+varSRA+varSRB+varMG+varMO+varMRA+varMRB+varLG+varLO+varLRA+varLRB%>
                   	        </font>        	     
                       	     </tr>
                   	      
               </g:each>
               
                <tr style="padding:5px;">
                    <td colspan="2" style="text-align:right;padding:5px;">Grand Total</td>
                    <td ><%=grandTotalRedALarge%></td>
                    <td ><%=grandTotalOrangeLarge%></td>
                    <td ><%=grandTotalGreenLarge%></td>
                    <td ><%=grandTotalRedBLarge%></td>
                    <td ><%=grandTotalRedAMedium%></td>
                    <td ><%=grandTotalOrangeMedium%></td>
                    <td ><%=grandTotalGreenMedium%></td>
                    <td ><%=grandTotalRedBMedium%></td>
                    <td ><%=grandTotalRedASmall%></td>
                    <td ><%=grandTotalOrangeSmall%></td>
                    <td ><%=grandTotalGreenSmall%></td>
                    <td ><%=grandTotalRedBSmall%></td>
                    <td ><%=grandTotalRedAMicro%></td>
                    <td ><%=grandTotalOrangeMicro%></td>
                    <td ><%=grandTotalGreenMicro%></td>
                    <td ><%=grandTotalRedBMicro%></td>
                    <td ><%=(grandTotalRedALarge+grandTotalOrangeLarge+grandTotalGreenLarge+grandTotalRedBLarge+
                    grandTotalRedAMedium+grandTotalOrangeMedium+grandTotalGreenMedium+grandTotalRedBMedium+
                    grandTotalRedASmall+grandTotalOrangeSmall+grandTotalGreenSmall+grandTotalRedBSmall+grandTotalRedAMicro+
                    grandTotalOrangeMicro+grandTotalGreenMicro+grandTotalRedBMicro)%></td>
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
</div>
</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>