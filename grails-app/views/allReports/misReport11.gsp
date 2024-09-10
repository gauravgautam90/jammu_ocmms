<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
   <head>
      <%
         response.setHeader("Cache-Control","no-cache"); 
         response.setHeader("Pragma","no-cache"); 
         response.setDateHeader ("Expires", -1);
         %>
      <g:javascript>
         function updateCity1(e) {
         // The response comes back as a bunch-o-JSON
         var cities = eval("(" + e.responseText + ")") // evaluate JSON
         if (cities) {
         var rselect = document.getElementById('industryType.id')
         // Clear all previous options
         var l = rselect.length
         while (l > 0) {
         l--
         rselect.remove(l)
         }
         var opt1 = document.createElement('option');
         opt1.text = 'Not Selected'
         opt1.value = '111'
         try {
         rselect.add(opt1, null) // standards compliant; doesn't work in IE
         }
         catch(ex) {
         rselect.add(opt1) // IE only
         }
         // Rebuild the select
         for (var i=0; i < cities.length; i++) {
         var tehsil = cities[i]
         var opt = document.createElement('option');
         opt.text = tehsil.industryType
         opt.value = tehsil.id
         try {
         rselect.add(opt, null) // standards compliant; doesn't work in IE
         }
         catch(ex) {
         rselect.add(opt) // IE only
         }
         }
         }
         var selectmenu1=document.getElementById("industryType.id").value;
         if(selectmenu1 == "1234" || selectmenu1 == "1235" || selectmenu1 == "1236")
         {
         document.getElementById('selectTemp').style.display = 'block';
         }
         else{
         document.getElementById('selectTemp').style.display = 'none';
         }
         }
         // This is called when the page loads to initialize city
         var zselect = document.getElementById('category.id')
         var zopt = zselect.options[zselect.selectedIndex]
         ${remoteFunction(controller:"industryRegMaster", action:"ajaxGetCities1", params:"'id=' + zopt.value", onComplete:"updateCity1(e)")}
      </g:javascript>
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
      <script type="text/javascript" src="js/tabcontent.js"></script>
	  <script type="text/javascript">
	var popupWindow=null;
	function child_open(url) { 
		popupWindow =window.open(url,"_blank","directories=no, status=no, menubar=no, scrollbars=yes, resizable=no,width=600, height=280,top=200,left=200");
}
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
            <td align="left" valign="top">
               <table width="100%" border="0" cellspacing="0" cellpadding="0">
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
                  <tr>
                     <td align="left" valign="top">
                        <table width="1003" border="0" cellspacing="0" cellpadding="0">
                           <tr>
                              <td width="224" align="left" valign="top" bgcolor="#DEEED0">
                                 <!-- code for menuAdmin-->
                                 <% UserMaster aa = (UserMaster)session.getAttribute("userMaster");
                                    String userType =	 aa.accessLevel;
                                    if(userType.equals("admin")) { %>	
                                 <g:include controller="userMaster" action="reportAdminMenuVertical"/>
                                 <%} else{ %>
                                 <g:include controller="userMaster" action="reportAdminMenuVertical"/>
                                 <% } %>
                              </td>
                              <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
                              <td width="778" align="left" valign="top">
                                 <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                       <td height="1" valign="top"></td>
                                    </tr>
                                    <tr>
                                       <td><img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" /></td>
                                    </tr>
                                    <%	
                                       boolean decVar=true;
                                       String firstname;
                                       String lastName;
                                       String access;
                                       String indname;
									   ArrayList indApplicationListForChallan = new ArrayList()
                                       	
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
                                             <% if((UserMaster)session.getAttribute("userMaster"))
                                                {
                                                %>
                                             <tr bgcolor="#4C8BC0">
                                                <td  class="top-lnks" >
                                                   <table width="100%" >
                                                      <tr height="10px">
                                                         <td>Welcome <%=firstname %><%=lastName %>(<%=access %>)</td>
                                                         <td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
                                                      </tr>
                                                   </table>
                                                </td>
                                             </tr>
                                             <% } 
                                                if(  (IndUser)session.getAttribute("indUser")  )
                                                	
                                                	{ %>
                                             <tr bgcolor="#4C8BC0">
                                                <td  class="top-lnks" >
                                                   <table width="100%" >
                                                      <tr height="10px">
                                                         <td>Welcome <%=indname %></td>
                                                         <td class="top-lnks" align="right"> Date :&nbsp;<%=date %>-<%=month %>-<%=year %> </td>
                                                      </tr>
                                                   </table>
                                                </td>
                                             </tr>
                                             <% } %>
                                          </table>
                                       </td>
                                    </tr>
                                    <tr>
                                       <td height="0" align="left" valign="top" >
                                          <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                             <tr>
                                                <!-- Div area for errors-->
                                                <td align="center" valign="top">
                                                   <div style="width:400px; height:20px; vertical-align:middle">
                                                      <span class="error">
                                                         <g:if test="${flash.message}">
                                                            <div class="message">${flash.message}</div>
                                                         </g:if>
                                                         <g:hasErrors bean="${industry1}">
                                                            <div class="errors">
                                                               <g:renderErrors bean="${industry1}" as="search" />
                                                            </div>
                                                         </g:hasErrors>
                                                      </span>
                                                   </div>
                                                </td>
                                             </tr>
                                             <!--<tr>        
                                                <td align="center" valign="top">Row for Page Heading</td>
                                                </tr>-->
                                             <tr>
                                                <td height="0" align="left" valign="top">
                                                   <table width="778" border="0" cellspacing="0" cellpadding="0">
                                                      <tr>
                                                         <td width="82" align="left" valign="top">&nbsp;</td>
                                                         <td align="left" valign="top">
                                                            <div style="padding:0px 0px 0px 0px;" >
                                                            <br/>
                                                            <FORM id="myForm" name=myForm action="searchMis" method="post">
                                                               
                                                               <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
                                                               <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                                                                  <tr>
                                                                     <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                                                                     <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Search</a></td>
                                                                     <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
                                                                     <td width="1200" align="right"></td>
                                                                  </tr>
                                                               </table>
                                                               <div id="country1" >
                                                                  <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
                                                                     <tr align="center">
                                                                        <td colspan="4" bgcolor="#A8DAF3" align="left"><input type=radio  name=searchOp value=Others checked="checked"><span class="headngblue">By Date</span></td>
                                                                     </tr>
                                                                     <tr  bgcolor="#E8F6F9">
                                                                        <td width="15%" align="left"  class="headngblue" >Start Date:*</td>
                                                                        <td width="33%" align="left" >
                                                                           <calendar:datePicker name="start_date" dateFormat="%d/%m/%Y" defaultValue="${new Date()}" />
                                                                        </td>
                                                                        <td  width="15%" align="left"  class="headngblue">Ending Date:*</td>
                                                                        <td align="left" width="37%"  >
                                                                           <calendar:datePicker name="end_date"  dateFormat="%d/%m/%Y" defaultValue="${new Date()}"/>
                                                                        </td>
                                                                     </tr>
                                                                    
                                                                  </table>
                                                                  <table width="95%" align="center">
                                                                     <tr>
                                                                        <td align="center"><input type="submit" name="save" value="Search" class="actionbutton" ></td>
                                                                        
                                                                       
                                                                     </tr>
                                                                     
                                                                  </table>
                                                                  <div align="left" class="txt" style="color: navy">
                                                   			   <hr><b>* Instructions:</b><br><br>
                                                   			   <ul> 
                                                   			  	<li>Note: Please select Max 2-3 days of duration</li>
                                                   				
                                                   				
                                                   			  </ul>
                                                   			  
                                                   		</div>	

                                                                  	<% if (industry||industryWC||industryBMW) { %>
     
     
     
<table width=100% align="center" cellpadding="0" cellspacing="0"  class="tab-txt">
<tr>

<td colspan="5" align="right" ><a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popPaymentReport', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
<span class="headngblue">Print Preview</span></a>|<a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/popPaymentReportExc', 'ApplicationHistory', 'WIDTH=900,HEIGHT=500,scrollbars=1,resizable=yes');" >
<span class="headngblue">Print in Excel Format</span></a>
</td>

</tr>
                 
     </table>
<g:if test="${session.startDate1!=null}">       
<table width=100% align="center" cellpadding="0" cellspacing="0"  class="tab-txt">
<tr height="20" bgcolor="#2B547E">
<td align="left" >
<b><font color="yellow" size="2">Receipt Details of payments received through Online From </font><font color="skyblue" size="2"><%=session.startDate1%></font><font color="yellow" size="2"> To </font><font color="skyblue" size="2"><%=session.endDate1%></font></b>
</td>
</tr>
</table>
</g:if>
<div style="overflow: auto;height: 300px; width: 750px;">


<%

def totalAmount1 = 0 
 	double totalAmountPaid1 = 0
 		def totalAmount1BMW = 0 
 	double totalAmountPaid1BMW = 0
 	
 	def totalAmount1WC = 0 
 	double totalAmountPaid1WC = 0
%>
<table width="160%" align="center" cellpadding="0" cellspacing="0"  class="tab-txt">
 <tr height="20" bgcolor="#A8DAF3">

                     
                   	        <th align="center" class="headngblue" >Transaction Date</th>
                   	        <th  align="center" class="headngblue" >Transaction Id.</th>
                   	        <th align="center" class="headngblue" >Transaction Type</th>
                   	        <th  align="center" class="headngblue" >Application No.</th>
                   	        <th  align="center" class="headngblue" >Application Type</th>
                   	        <th  align="center" class="headngblue" >Application Date</th>
                   	        <th  align="center" class="headngblue" >Industry Name</th>
                   	        <th  align="center" class="headngblue" >Industry Address</th>
                   	        <th align="center" class="headngblue" >Regional Office</th>
                   	        
                   	        <th align="center" class="headngblue" >NOC Fee</th>
                   	        <th align="center" class="headngblue" >Consent Fee</th>
                   	        <th align="center" class="headngblue" >Water Consent Fee</th>
                   	        <th align="center" class="headngblue" >Air Consent Fee</th>    
                   	<!--        <th align="center" class="headngblue" >BMW Fee</th>    
                   	       <th align="center" class="headngblue" >WATER CESS Fee</th> 
                   	      
                   	      <th align="center" class="headngblue" >Sample Testing Air</th> 
                   	         <th align="center" class="headngblue" >Sample Testing Water</th>  
                   	          <th align="center" class="headngblue" >Sample Testing Both</th>   
                   	           <th align="center" class="headngblue" >Performance Security</th>                 	        
                   	     
                   	        <th align="center" class="headngblue" >Total Amount to be Paid</th>
                   	     -->    <th align="center" class="headngblue" >Amount Received</th>
                   	        
                   	        
 </tr>   
 
 
 
 							<g:each in="${industry}" status="i" var="industry">
           
       
                    	 <%  
                    	 
                    	 System.out.println("industry.indApplication-------------"+industry.indApplication)
                    	  	ArrayList indApp = new ArrayList()
                    	 
                    	 	if(!indApp.contains(industry.indApplication)){ %>
				 
                        	<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                      
                            <td align="center" height="25" class="txt4">
                            ${fieldValue(bean:industry, field:'dateCreated')}
                            </td>
                        
                        
						 	<td align="center" height="25" class="txt4">
						
                        	${fieldValue(bean:industry, field:'id')}
                        	</td>
                         
                      <%if(industry.paymentType!=""){%>
                            <td align="center" height="25" class="txt4"  >${fieldValue(bean:industry, field:'paymentType')}</td>
                        <%}else{%>
                        
                        
                        <td align="center" height="25" class="txt4"  >PNB</td>
                       <%}%>
                        
                       		<td align="center" height="25" class="txt4"  >${fieldValue(bean:industry, field:'indApplication')}</td>
                            
                         	<td align="center" height="25" class="txt4"  >${fieldValue(bean:industry, field:'indApplication.applicationType')}-${fieldValue(bean:industry, field:'indApplication.applicationFor')} </td>
                        
                      	 	<td align="center" height="25" class="txt4" ><g:formatDate format="yyyy-MM-dd" date="${industry.indApplication.actualApplicationDate}"/></td>
                        
                         	<td align="center" height="25" class="txt4" >${fieldValue(bean:industry, field:'indApplication.indUser.indName')}</td>
                          
                         	<td align="center" height="25" class="txt4" >${fieldValue(bean:industry, field:'indApplication.indUser.indAddress')}<br>${fieldValue(bean:industry, field:'indApplication.indUser.tehsil')}, ${fieldValue(bean:industry, field:'indApplication.indUser.district')}</td>
                            
                          
                            <td align="center" height="25" class="txt4" >${groupList.get(i)}</td>
                            
                            <td align="center" height="25" class="txt4" >${cteFee.get(i)}</td>
                             <td align="center" height="25" class="txt4" >${ctofee1.get(i)}</td>
                            
                            <td align="center" height="25" class="txt4" >${ctoFeeWater.get(i)}</td>
                            
                            <td align="center" height="25" class="txt4" >${ctoFeeAir.get(i)}</td>
                             
                              
                    		    
                           
                  <!--       
                            <td align="center" height="25" class="txt4" >0</td>
                             
                    		<td align="center" height="25" class="txt4" >0</td> 
                         -->    

                           <%    
                           
                           double amt = 0.0
                                    def inr = new ArrayList()	     
                           def industryList=BankTransactionDetails.findAll("From BankTransactionDetails idUser where idUser.indApplication=? and idUser.transactionStatus='S' and idUser.dateCreated=?",[industry.indApplication,industry.dateCreated])
                           
                           System.out.println("industryList------"+industryList)
                           
                           for(int iii = 0 ;iii<industryList.size();iii++)
                       
                       {
                        	if(!inr.contains(industryList.get(iii).indApplication))
						{
							inr.add(industryList.get(iii).indApplication)
							amt = amt + industryList.get(iii).amount.toDouble()
						}
                        	
                        	
                        }
                        	 
                        	
                           def total = cteFee.get(i) + ctoFeeWater.get(i) + ctoFeeAir.get(i) + ctofee1.get(i)
                           
                           totalAmount1 = totalAmount1 + total 
                          
                           totalAmountPaid1 =  totalAmountPaid1 + amt
                           
                           
                           %>
                                                        
                <!--     <td align="center" height="25" class="txt4" >${total}</td>
                    -->        
                     <td align="center" height="25" class="txt4" >
                         
                        
                         
                     ${amt}</td>
                        
                     </tr>
                        
                        
				  	<% } 
				   
				   		indApp.add(industry.indApplication) 
				   		
				   	%>
				 
				 		</g:each>
				
				
				
				
				<g:each in="${industryBMW}" status="i" var="industry">
                   
                   <%System.out.println("industryBMW----"+industryBMW)%>
                   
                     <%  
                    	  ArrayList indApp = new ArrayList()
                    	 
                    	 if(!indApp.contains(industry.indApplication)){ %>
				 
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                      
                            <td align="center" height="25" class="txt4"  >${fieldValue(bean:industry, field:'dateCreated')}</td>
                        
                        	
						 <td align="center" height="25" class="txt4"  >${fieldValue(bean:industry, field:'id')}</td>
                         
                        
                            <td align="center" height="25" class="txt4"  >PNB</td>
                        
                        
                            <td align="center" height="25" class="txt4"  >${fieldValue(bean:industry, field:'indApplication')}</td>
                            
                             <td align="center" height="25" class="txt4"  >BMW </td>
                        
                        <td align="center" height="25" class="txt4" ><g:formatDate format="yyyy-MM-dd" date="${industry.indApplication.dateCreated}"/></td>
                        
                          <td align="center" height="25" class="txt4" >${fieldValue(bean:industry, field:'indApplication.industryRegMasterObj.indName')}</td>
                          
                            <td align="center" height="25" class="txt4" >${fieldValue(bean:industry, field:'indApplication.industryRegMasterObj.indAddress')}<br>${fieldValue(bean:industry, field:'indApplication.industryRegMasterObj.tehsil')}, ${fieldValue(bean:industry, field:'indApplication.industryRegMasterObj.district')}</td>
                            
                            <td align="center" height="25" class="txt4" >${groupListBMW.get(i)}</td>
                            
                            <td align="center" height="25" class="txt4" >0</td>
                            
                             <td align="center" height="25" class="txt4" >0</td>
                            
                             <td align="center" height="25" class="txt4" >0</td>
                            
                          
                             
                     <td align="center" height="25" class="txt4" >${bmwFee.get(i)}</td>
                             
                            
                            
                            <%  
                            System.out.println("other--11111111111111---"+bmwFee.size()+"---"+OtherFeeBMW.size())
                           
                              def otherB = new ArrayList()
                             
                             for(int x = 0 ; x < OtherFeeBMW.size() ; x++ ){
                             
                          
                              if(bmwFee.get(i).equals(0))
                              {
                              
                               otherB.add(OtherFeeBMW.get(x))  
                              
                              }
                              else
                              {
                              
                              otherB.add(0)
                              
                              }
                              
                              
                              
                              }
                          
                              %>
                              <td align="center" height="25" class="txt4" >0</td>
                             <td align="center" height="25" class="txt4" >${appFormFeeBMW.get(i)}</td>
                             
                               <td align="center" height="25" class="txt4" >${OtherFeeBMW.get(i)}</td>
                            
                             <%
                        double amt = 0.0
						   def industryList=BankTransactionDetailsBMW.findAll("From BankTransactionDetailsBMW idUser where idUser.indApplication=? and idUser.transactionStatus='S' and idUser.dateCreated=?",[industry.indApplication,industry.dateCreated])
                           
                           System.out.println("industryList------"+industryList)
                           
                           for(int iii = 0 ;iii<industryList.size();iii++)
                       
                       {
                        	  
                        	amt = amt + industryList.get(iii).amount.toDouble()
                        	
                        }
                            
                            
                             def total = bmwFee.get(i) + appFormFeeBMW.get(i) + OtherFeeBMW.get(i)
                             
                             totalAmount1BMW = totalAmount1BMW + total 
                             
                             totalAmountPaid1BMW =  totalAmountPaid1BMW + amt
                            
                            
                              %>
                                                        
                             <td align="center" height="25" class="txt4" >${total}</td>
                            
                         <td align="center" height="25" class="txt4" >
                         
                        
                         
                         ${amt}</td>
                        
                        </tr>
                        
                        
				   <% } 
				   
				   
				   indApp.add(industry.indApplication) %>
				 
				 </g:each>
				
				
				
				
				
				
				
				
				
				
				
				
			
				
				 <g:each in="${industryWC}" status="i" var="industry">
				 
				
                 <%  
                	  ArrayList indApp = new ArrayList()
                	 
                	 if(!indApp.contains(industry.indApplication)){ %>
			 
                    <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                  
                        <td align="center" height="25" class="txt4"  >${fieldValue(bean:industry, field:'dateCreated')}</td>
				 
                        <td align="center" height="25" class="txt4" >${fieldValue(bean:industry, field:'id')}</td>
                        
                        <td align="center" height="25" class="txt4"  >Net banking-PNB</td>
                        
                        <td align="center" height="25" class="txt4"  >${fieldValue(bean:industry, field:'indApplication')}</td>
                        
                        <td align="center" height="25" class="txt4"  >CESS</td>
				 
                        <td align="center" height="25" class="txt4" ><g:formatDate format="yyyy-MM-dd" date="${industry.indApplication.dateCreated}"/></td>
				 
                        <td align="center" height="25" class="txt4" >${fieldValue(bean:industry, field:'indApplication.industryReg.indName')}</td>
                        
                        <td align="center" height="25" class="txt4" >${fieldValue(bean:industry, field:'indApplication.industryReg.indAddress')}<br>${fieldValue(bean:industry, field:'indApplication.industryReg.tehsil')}, ${fieldValue(bean:industry, field:'indApplication.industryReg.district')}</td>
                        
                        
                        <td align="center" height="25" class="txt4" >${groupListCess.get(i)}</td>
				 
				  <%System.out.println("industryWC-----------"+groupListCess.get(i))%>
				
				 
                        <td align="center" height="25" class="txt4" >0</td>
                        
                        <td align="center" height="25" class="txt4" >0</td>
                       
                        <td align="center" height="25" class="txt4" >0</td>
                        
                        <td align="center" height="25" class="txt4" >0</td>
				
                        <td align="center" height="25" class="txt4"  >${fieldValue(bean:industry, field:'amount')}</td>
       				 
                        <td align="center" height="25" class="txt4" >0</td>
                        
                        <td align="center" height="25" class="txt4" >0</td>
                      
                                             
                        <td align="center" height="25" class="txt4" >${fieldValue(bean:industry, field:'amount')}</td>
                       
                    <td align="center" height="25" class="txt4" >${fieldValue(bean:industry, field:'amount')}</td>
                   
                   </tr>
                   
                   
			   <% } 
			   
			   
			   indApp.add(industry.indApplication) %>
			 
			 </g:each>
                     
                     
                
                           
				 <%
				 for(int i=0;i<industryWC.size();i++){
				 
				 
					 totalAmountPaid1WC=(industryWC[i].amount).toFloat()+totalAmountPaid1WC
					 
					 System.out.println("total water cess amount "+totalAmountPaid1WC);
				 
				 }
				 System.out.println("total water cess amount "+totalAmountPaid1WC);
				 
				
				
				
				 def  consentotalCessBMW = totalAmount1 + totalAmountPaid1WC + totalAmount1BMW
				 
				 System.out.println("consentotal==="+consentotalCessBMW)
				 
				 
				 
				 	def  consentPaidTotalCessBMW = totalAmountPaid1+totalAmountPaid1WC + totalAmountPaid1BMW
				 
				  totalAmount =  Long.toString((long) consentotalCessBMW);
							totalAmountPaid =  Long.toString((long) consentPaidTotalCessBMW);
                            
                     
                          
				 %>
				 
	<!--			   
 <tr height="20" bgcolor="#2B547E">
<td align="right" colspan=19>
<font color="yellow" size="2"><b>Total Amount to be Paid(in Rs.) : </b></font>
</td>
<td align="center" >
<font color="yellow" size="2"><b><%=totalAmount%></b></font>
</td>
</tr>
-->
<tr height="20" bgcolor="#2B547E">
<td align="right" colspan=19>
<font color="yellow" size="2"><b>Total Amount Received(in Rs.) : </b></font>
</td>
<td align="center" >
<font color="yellow" size="2"><b><%=totalAmountPaid%></b></font>
</td>

</tr>
     
     
        </table>
      
	

	<%}%>
		
		
            <br />
            <br />
          </div>
																  <%
																  	  session.indApplicationListForChallan = indApplicationListForChallan;
																	%>
                                                            </form>
                                                            <script type="text/javascript">
                                                               var countries=new ddtabcontent("countrytabs")
                                                               countries.setpersist(true)
                                                               countries.setselectedClassTarget("link") //"link" or "linkparent"
                                                               countries.init()
                                                               
                                                            </script>
                                                            </div>
                                                         </td>
                                                         <td width="82" align="left" valign="top">&nbsp;</td>
                                                      </tr>
                                                   </table>
                                                </td>
                                             </tr>
                                          </table>
                                       </td>
                                    </tr>
                                 </table>
                              </td>
                           </tr>
                        </table>
                     </td>
                  </tr>
                  <!-- code for spcb Footer -->
                  <g:include controller="userMaster" action="showSpcbFooter"/>
               </table>
            </td>
         </tr>
      </table>
   </body>
   <HEAD>
      <META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
      <META HTTP-EQUIV="Expires" CONTENT="-1">
   </HEAD>
</html>