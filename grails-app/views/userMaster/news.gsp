<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="https://www.w3.org/1999/xhtml">

<head>

<%

response.setHeader("Cache-Control","no-cache"); 

response.setHeader("Pragma","no-cache"); 

response.setDateHeader ("Expires", -1);

%>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>SPCB Admin Home</title>

 

 

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>

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

<script type="text/javascript">
		   
	        var is_show=1; 
	        var all =1;
	        function show_all()
	        {
	        document.getElementById("spnCollapse").style.display="none";
	        if(all==1)
	        {
	        document.getElementById("div_hide_ans1").style.display="block";
	        document.getElementById("div_hide_ans2").style.display="block";
	        document.getElementById("div_hide_ans3").style.display="block";
	         document.getElementById("spnExpand").style.display="none";
	        document.getElementById("spnCollapse").style.display="block";
	        
	    all=0;
	         }
	         else
	         {
	         document.getElementById("div_hide_ans1").style.display="none";
	         document.getElementById("div_hide_ans2").style.display="none";
	         document.getElementById("div_hide_ans3").style.display="none";
	          document.getElementById("spnExpand").style.display="block";
	        document.getElementById("spnCollapse").style.display="none";
	      all=1;
	         }
	         }
	         
	         
	 function Show_More(id)
		{
            document.getElementById(id).style.display = "none";
	        if(id == "div_hide_ans1")
            {
				Hide(id)
            }
            if(id=="div_hide_ans2")
            {
            	Hide(id)
            	
            }
             if(id=="div_hide_ans3")
            {
            	Hide(id)
            	
            }
           
             
            
		}
		function Hide(id)
		{
            document.getElementById(id).style.display = "none";
		if(is_show == 1)
                {
                    document.getElementById(id).style.display = "block";
                    is_show = 0;
                }
                else
                {
                    document.getElementById(id).style.display = "none";
                    is_show = 1;
                }
		}
		    </script>
		              

 

<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>
 

 
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
		<g:include controller="userMaster" action="showMenu"/>
		</td>
      </tr>
      <tr>
        <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="224" align="left" valign="top" bgcolor="#DEEED0">
			<!-- code for menuAdmin-->
			<%
				if(  (IndUser)session.getAttribute("indUser")  ){ %>
					 <g:include controller="userMaster" action="showSpcbIndustryMenu"/>                                         

                           <%} %>
				 <% 

                 if((UserMaster)session.getAttribute("userMaster")){
				UserMaster aa = (UserMaster)session.getAttribute("userMaster");
                String userType = aa.accessLevel
					 if(userType.equals("admin")) { %>   

                 <g:include controller="userMaster" action="showAdminMenu"/>                                          

                 <% }else{ %>
					 <g:include controller="userMaster" action="showSpcbUserMenu"/> 
							 <%}} %>
						<% if( (!(IndUser)session.getAttribute("indUser") ) && 
							(! (UserMaster)session.getAttribute("userMaster") )  )   {%>
							<g:include controller="userMaster" action="showIndexMenu"/>            

                                 <% } %>
			</td>
            <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
            <td width="778" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td><img src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778" height="134" /></td>
              </tr>  
              
              <tr>
                <td height="24" bgcolor="#EEEEF3">
					<table width="100%"> <tr >
				<td  class="top-lnks" width="100%">
					
					 </td></tr><tr>
							
							
							<!--<td width="20%" align="left"><g:link controller="officeMaster" action="updateoffice" ><span class="innerlink">&nbsp;Update&nbsp;|</span></g:link></td> -->
							<td width="80%">&nbsp;</td>
					   </tr></table>
				</td>
              </tr>
              <tr>
                <td height="0" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    
                    
                    <tr><!-- Div area for errors-->
                    
                    
                      <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">
				                     <g:if test="${flash.message}">
									<div class="message">${flash.message}</div>
									</g:if>
									<g:hasErrors bean="${officeMasterInstance}">
									<div class="errors">
										<g:renderErrors bean="${officeMasterInstance}" as="list" />
									</div>
									</g:hasErrors>

                      </span></div></td>
                    </tr>
                  
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
       
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
		
		
		
		
		<g:form action="save" name="myform" method="post" >
		
		
  
          <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
     <tr>
     <td><img src="${createLinkTo(dir:'images',file:'arr.jpg')}" />&nbsp;&nbsp;</td>
          <td width="95%" align="left" class="headngbig" bgcolor="">Latest News</td>
     </tr>
	    </table>
          

 

            <!--    content change...START  --> 
      

            
<table>  
                <tr>
            
                <table border="0" cellpadding="0" cellspacing="0" width="100%">
                    <tr>
                        <td style="height: 15px;" align="center" valign="top">
                           <span style="font: normal 9px arial; color: #0000DD;">
                              </span>
                        </td>
                   <div id="divExpand"style="font: bold 9px arial; color: #0000DD; width="100%" align="right"><span ID="spnExpand" onclick="javascript:show_all();">[+]Expand all</span><span ID="spnCollapse" style="display:none;" onclick="javascript:show_all();">[-]Collapse all</span></div>
                   
                    </tr>
                 
                </table>
    
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td style="height: 5px;">
                        </td>
                    </tr>
                    <tr>
                        <td align="left" style="height: 15px;" style="width: 100%">
                            <span id="span10" style="font: normal 11px verdana; color: #AA0000;align="left" 
                                onclick="javascript:Show_More('div_hide_ans1');">SPCB, hotelliers discuss industry issues

                                 </span>
                        </td>
                    </tr>
                </table>

     <div id="div_hide_ans1" style="display: none;">
                    <table border="0" cellpadding="5" cellspacing="0">
                        <tr>
                            <td  vAlign="top" width="757" height="14" bordercolor="#000000" colspan="3" background="images/back2.jpg">
          <p   style="margin-left: 10; margin-right: 10; margin-top: 10" align="justify" class="txt4">Member Secretary J&K State Pollution Control Board, Arun Kumar Tickoo (IFS), along with Director Tourism, Farooq Ahmad Shah, held a meeting with the entrepreneurs of hotel industry at the SPCB Regional Directorate Rajbagh.</p>
          <p   style="margin-left: 10; margin-right: 10" align="justify" class="txt4">
          Regional Director SPCB, Kashmir, SFA Gillani, apprised the meeting about the steps taken for issuing consent to the hotels under Environment Protection Act, Air and Water Acts and in the light of directions of High Court besides the consent status of various hotels.</p>
          <p   style="margin-left: 10; margin-right: 10" align="justify" class="txt4">Various issues relating to the industry were discussed in the meeting and threadbare deliberations were held on the problems faced by the industry. After listening to the hotel owners, Member Secretary J&K SPCB assured them that speedy disposal of their cases would be ensured and their genuine demands would be taken care of.</p>
          <p   style="margin-left: 10; margin-right: 10" align="justify" class="txt4">Besides, he said, the consent mechanism for the hotel industry would be made simplistic for speedy registration of hotels with the Tourism Department.&nbsp;</p>
          <p   style="margin-left: 10; margin-right: 10" align="justify" class="txt4">He said matter will be taken up with various agencies like UEED, SMC and local bodies for construction of STPs at various places at the earliest.<a name="use"></a></td>
   		<p   style="margin-left: 10; margin-right: 10" align="justify" class="txt4">Deputy Director Tourism, Registration, and District Officers of the Board were also present in the meeting.</p>
   		<p   style="margin-left: 10; margin-right: 10" align="justify" class="txt4">The hotel owners were represented by Mushtaq Ahmad Burza, Sirajuddin, Javed Ahmad Burza and others.</p>
   		<p   style="margin-left: 10; margin-right: 10" align="justify" class="txt4">Earlier during the day, Arun Kumar held a detailed review meeting of the Board in which various issues were discussed.</p>
     
                        </tr>
                    </table>
                </div>
    
    <!-- end of 1st -->
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td style="height: 7px;">
                        </td>
                    </tr>
                    <tr>
                        <td align="left" style="height: 15px;" style="width: 100%">
                            <span id="span10" style="font: normal 11px verdana; color: #AA0000; cursor: pointer;"
                                onclick="javascript:Show_More('div_hide_ans2');">Program on polythene carry bags on National Pollution Prevention Day
Below 8-12 inch in size and 20 micron thick

                                 </span>
                        </td>
                    </tr>
                </table>
    
    
     <div id="div_hide_ans2" style="display: none;">
                    <table border="0" cellpadding="5" cellspacing="0">
                        <tr>
                            <td class="FAQ_hidden_menu" align="justify" valign="top">
                                <p class="txt4">
                                 The National Pollution Prevention Day is observed as the anniversary of Bhopal Gas Tragedy of 1982 when Methyl Isocyanate leaked from Union Carbide factory killing hundreds of people and rendering thousands disabled.
Jammu and Kashmir State Pollution Control Board (J&K SPCB), Regional Directorate Kashmir, observed the day on 2nd December 2010 by organizing an awareness program on polythene carry bags, in association with Indian Youth Climate Network, involving the students of Eco-Clubs from different schools of Srinagar district.<br><br>
 
At first the students were briefed about the program and the ban on the polythene carry bags. The students and their teacher Incharge were then distributed in four groups under various officials of the Board.
During the program organized simultaneously at Lal Chowk, Dalgate, Amira Kadal and Karan Nagar, the students took polythene carry bags from shoppers, vendors, shopkeepers, etc. and instead handed them eco-friendly paper carry bags got made specially for the occasion by J&K SPCB, Kashmir Division. The students also made the people aware about the hazards of polythene and the benefits of using eco-friendly alternatives.<br><br>
Besides being non-biodegradable and hence dangerous for the environment, carrying of foodstuff in polythene carry bags is also hazardous to health, the students informed the people.
Polythene carry bags have been banned in Jammu & Kashmir vide SRO 182 in the light of Non-biodegradable Material (Management, Handling and Disposal) Rules, 2009. 
The drive found a positive response from the general public and the media who appreciated the efforts of the Board.<br><br>
Speaking on the occasion, Regional Director, J&K SPCB Kashmir, Mr. SFA Gillani said the Board wants to implement the ban on polythene carry bags with the cooperation of general public. We have been taking up such campaigns in the past and such programs will be conducted on valley-vide scale in the future. We will also take legal action against the defaulters who still trade in the banned material, the Regional Director said.     
                        </td>
                    </tr>
                </table>
                </div>
            
                
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td style="height: 7px;">
                        </td>
                    </tr>
                    <tr>
                        <td align="left" style="height: 15px;" style="width: 100%">
                            <span id="span10" style="font: normal 11px verdana; color: #AA0000; cursor: pointer;"
                                onclick="javascript:Show_More('div_hide_ans3');">Appointment of Public Information Officer under Right to Information Act

                                 </span>
                        </td>
                    </tr>
                </table>
                
                
                 <div id="div_hide_ans3" style="display: none;">
                    <table border="0" cellpadding="5" cellspacing="0">
                        <tr>
                            <td class="FAQ_hidden_menu" align="left" valign="top">
                                <p class="txt4">
                                 
Name of Officer: Dr Mohit Gera IFS</br>

9419144363, 22311165 (Sgr),</br>

2476925 (Jmu)</br>

Designation: Member Secretary, J&K SPCB</br>

Official address:</br>

1. (may to oct) Behind govt silk factory, Rajbagh Srinagar</br>

2. (nov to april) Parivesh Bhavan, transport nagar, Narwal Jammu.</br></br>


The following officers are designated as assistant public information officers under section 2 of the RTI Act:</br></br>

 

1. Administrative officer PCB: move office jammu\sgr</br>

2. Regional Director Jammu: Parivesh bhavan, transport nagar, Narwal Jammu (0191 2476926)</br>

3. Regional Director  Kashmir: Behind govt silk factory, Rajbagh Srinagar(0194 2311842)</br>

4. Nodal officer SPCB leh (ex officio DFO): o/o DFO Leh, Leh Forest Division, Ladakh</br>

5. Nodal Officer SPCB Kargil (ex officio DFO): o/o DFO Kargil, Kargil Forest Division, Kargil Ladakh</p></br>
    </p>
                            </td>
                        </tr>
                    </table>
                </div>
               
                
                
                
     
         
                  
                           

                        <!-- content change  END      -->   

		</table>
		        <div align="left" class="txt" style="color: navy">
			  <br>
			
		</div>
		
  			</g:form>
            <br />
            <br />

          </div>
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
          </div>
	  
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
      </div></td>
                            <td width="132" align="left" valign="top">&nbsp;</td>
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
