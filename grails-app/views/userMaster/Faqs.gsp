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



<script type="text/javascript">
     var is_show=1; 
	        var all =1;
	        function show_all()
	        {
	        document.getElementById("spnCollapse").style.display="none";
	        if(all==1)
	        {
	        document.getElementById("div_hide_ans1").style.display="block";
	      
	        document.getElementById("div_hide_ans3").style.display="block";
	        document.getElementById("div_hide_ans4").style.display="block";
	     
	        document.getElementById("div_hide_ans6").style.display="block";
	          document.getElementById("div_hide_ans7").style.display="block";
	        document.getElementById("div_hide_ans8").style.display="block";
	        document.getElementById("div_hide_ans9").style.display="block";
	        document.getElementById("div_hide_ans10").style.display="block";
	        document.getElementById("spnExpand").style.display="none";
	        document.getElementById("spnCollapse").style.display="block";
	        
	    all=0;
	         }
	         else
	         {
	         document.getElementById("div_hide_ans1").style.display="none";
	       
	         document.getElementById("div_hide_ans3").style.display="none";
	         document.getElementById("div_hide_ans4").style.display="none";
	       
	         document.getElementById("div_hide_ans6").style.display="none";
	         document.getElementById("div_hide_ans7").style.display="none";
	           document.getElementById("div_hide_ans8").style.display="none";
	            document.getElementById("div_hide_ans9").style.display="none";
	             document.getElementById("div_hide_ans10").style.display="none";
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
          
             if(id=="div_hide_ans3")
            {
            	Hide(id)
            	
            }
              if(id=="div_hide_ans4")
            {
            	Hide(id)
            	
            }
              
              if(id=="div_hide_ans6")
            {
            	Hide(id)
            	
            }
               if(id=="div_hide_ans7")
            {
            	Hide(id)
            	
            }
              if(id=="div_hide_ans8")
            {
            	Hide(id)
            	
            }
               if(id=="div_hide_ans9")
            {
            	Hide(id)
            	
            }
                 if(id=="div_hide_ans10")
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
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
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
          <td width="95%" align="left" class="headngbig" bgcolor="">Frequently Asked Questions:- </td>
     </tr>
	    </table>
		
	   
	   
	    
		          		                          
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
                                onclick="javascript:Show_More('div_hide_ans1');"> <b>Ques:</b>What are important Environmental Laws in the Country?
                                 </span>
                        </td>
                    </tr>
                </table>
                 <div id="div_hide_ans1" style="display: none;">
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <td class="FAQ_hidden_menu" align="left" valign="top">
                                <p class="txt4">
                                   Ans: The Water (Prevention and
              Control of Pollution) Act, 1974  </p>
  
                                <p class="txt4">
                                   The Air (Prevention and
              Control of Pollution) Act, 1981</p>
               <p class="txt4">
               The Water
              (prevention and Control of Pollution) Cess Act, 1977</p>
                <p class="txt4">
                The Environment (Protection)
              Act, 1986 and Rules there under</p>
               <p class="txt4">
               The Public Liability Insurance Act, 1981 
               </p>
               
                   </td>
                        </tr>
                    </table>
                    </div>
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
              <td style="height: 6px;">
                        </td>
                    </tr>
                  
              </table>
               
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td style="height: 6px;">
                        </td>
                    </tr>
                    
                    <tr>
                        <td align="left" style="height: 15px;" style="width: 100%">
                            <span id="span2" style="font: normal 11px verdana; color: #AA0000; cursor: pointer;"
                                onclick="javascript:Show_More('div_hide_ans3');"><b>Ques:</b> What do you mean by Water and Air Consent?
            Who are required to obtain consent from Board?</span>
                        </td>
                    </tr>
                </table>
                
                 <div id="div_hide_ans3" style="display: none;">
                    <table border="0" cellpadding="5" cellspacing="0">
                        <tr>
                            <td class="FAQ_hidden_menu" align="left" valign="top">
                                <p class="txt4">
                                    <b>Ans:</b>      Consent
          means the sanction of the authority of the Board for the discharge of
          the effluent (sewage or trade effluent into a stream or well or sewer
          or on land ) or emission of air pollutant into the atmosphere. The
          consent issued by Board under section 25/26 of the Water (Prevention
          and Control of Pollution) Act 1974 is known as water consent and under
          section 21 of the Air (Prevention and Control of Pollution) Act, 1981
          is known as air consent</p>
          <p align="justify" style="margin-left: 75; margin-right: 35" class="txt4">As
          per section 25 of the Water (Prevention and Control of Pollution) Act
          1974, no person shall without the previous consent of the State Board,</p>
          <ol class="txt4">
            <li>
              <p align="justify" style="margin-left: 75; margin-right: 35" class="txt4">Establish or take any steps to establish any industry,
              operation or process, or any treatment and disposal system or any
              extension or addition thereto, which is likely to discharge sewage
              or trade effluent into a stream or well or sewer or on land; or</li>
            <li>
              <p align="justify" style="margin-left: 75; margin-right: 35" class="txt4">Bring into use any new or altered outlets for the
              discharge of sewage; or</li>
            <li>
              <p align="justify" style="margin-left: 75; margin-right: 35" class="txt4">Being to make any new discharge of sewage.</li>
          </ol>
          <p align="justify" style="margin-left: 75; margin-right: 35" class="txt4">And,
          as per section 21 of the Air (Prevention and Control of Pollution)
          Act, 1981, no person shall without previous consent of the State
          Board, establish or operate any industrial plant in an air pollution
          control area.</p>
         
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
                            <span id="span1" style="font: normal 11px verdana; color: #AA0000; cursor: pointer;"
                                onclick="javascript:Show_More('div_hide_ans4');"><b>Ques:</b>Is any fee required for obtaining consent? What do you mean by Consent Fee? </span>
                        </td>
                    </tr>
                </table>
                 <div id="div_hide_ans4" style="display: none;">
                    <table border="0" cellpadding="5" cellspacing="0">
                        <tr>
                            <td class="FAQ_hidden_menu" align="left" valign="top">
                                <p class="txt4">
                                    <b>Ans:</b>Yes Sir. The consent fee means the fees charged by the Board for the grant of consent by the Board.
                                      </p>
                            </td>
                        </tr>
                    </table>
                </div>
                
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td style="height: 7px;">
                        </td>
                    </tr>
                   
                                </table>
                                
         
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td align="left" style="height: 15px;" style="width: 100%">
                            <span id="span_hide_main" style="font: normal 11px verdana; color: #AA0000; cursor: pointer;"
                                onclick="javascript:Show_More('div_hide_ans6');"><b>Ques:</b> What do you mean by investment?</span>
                        </td>
                    </tr>
                </table>   
                  <div id="div_hide_ans6" style="display: none;">
                    <table border="0" cellpadding="5" cellspacing="0">
                        <tr>
                            <td class="FAQ_hidden_menu" align="left" valign="top">
                                <p class="txt4">
                                    <b>Ans:</b>  The investment means the amount of capital invested by the industry on capital works including land; machinery; and equipment. This is the gross block (without depreciation) of all fixed assets. 
                                </p>
                                </td>
                                </tr>
                                </table>
                </div>
                
               <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td align="left" style="height: 15px;" style="width: 100%">
                            <span id="span_hide_main" style="font: normal 11px verdana; color: #AA0000; cursor: pointer;"
                                onclick="javascript:Show_More('div_hide_ans7');"><b>Ques:</b> Is there any prescribed form for consent application?</span>
                        </td>
                    </tr>
                </table>   
                <div id="div_hide_ans7" style="display: none;">
                    <table border="0" cellpadding="5" cellspacing="0">
                        <tr>
                            <td class="FAQ_hidden_menu" align="left" valign="top">
                                <p class="txt4">
                                    <b>Ans:</b>  Yes Sir, There are prescribed forms of application for obtaining  consent. 
                                </p>
                                </td>
                                </tr>
                                </table>
                                </div>
                 
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td align="left" style="height: 15px;" style="width: 100%">
                            <span id="span_hide_main" style="font: normal 11px verdana; color: #AA0000; cursor: pointer;"
                                onclick="javascript:Show_More('div_hide_ans8');"><b>Ques:</b> Where the consent application forms are available?</span>
                        </td>
                    </tr>
                </table>  
                <div id="div_hide_ans8" style="display: none;">
                    <table border="0" cellpadding="5" cellspacing="0">
                        <tr>
                            <td class="FAQ_hidden_menu" align="left" valign="top">
                                <p class="txt4">
                                    <b>Ans:</b> 
                                     The consent application forms are available at Offices  of the Jammu & Kashmir State Pollution Control Board. 
                
                				</p>
                		</tr>
              
						       	</table>
						    
                </div> 
 
          		<table width="100%" border="0" cellspacing="0" cellpadding="0">
                    
                    <tr>
                        <td align="left" style="height: 15px;" style="width: 100%">
                            <span id="span11" style="font: normal 11px verdana; color: #AA0000; cursor: pointer;"
                                onclick="javascript:Show_More('div_hide_ans9');"><b>Ques:</b>Whether consent renewal fee has to be paid annually? 
                                </span>
                        </td>
                    </tr>
                </table>
                
                <div id="div_hide_ans9" style="display: none;">
                    <table border="0" cellpadding="5" cellspacing="0">
                        <tr>
                            <td class="FAQ_hidden_menu" align="left" valign="top">
                                <p class="txt4">
                                    <b>Ans:</b> A web-site contains several works such as literary works, artistic works
                                    (photographs etc.), sound recordings, video clips, cinematograph films and broadcastings
                                    and computer software too. Therefore, a separate application has to be filed for
                                    registration of all these works.
                                </p>
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
                            <span id="span11" style="font: normal 11px verdana; color: #AA0000; cursor: pointer;"
                                onclick="javascript:Show_More('div_hide_ans10');"><b>Ques:</b>What do you mean by Environmental Clearance?  Which type of activities/projects required Environmental Clearance? 
                                </span>
                        </td>
                    </tr>
                </table>
                
                
                
                  <div id="div_hide_ans10" style="display: none;">
                    <table border="0" cellpadding="5" cellspacing="0">
                        <tr>
                            <td class="FAQ_hidden_menu" align="left" valign="top">
                                <p class="txt4">
                                    <p  style="text-align: justify; text-indent: -75; margin-left: 75; margin-right: 35"><font face="Verdana" size="2"><b><span style="color: #993366">Ans
          : <span style="mso-spacerun:yes">&nbsp;</span></span></b><span style="mso-spacerun: yes; color: #993366"><b>
          </b></span><span style="mso-bidi-font-size:
  13.0pt;font-family:Verdana" class="txt4">The clearance accorded by Ministry of Environment
          and Forests, Government of India for expansion or modernization of any
          activity (if pollution load is to exceed the existing one) or a new
          project listed in schedule I of the Environment Impact Assessment
          Notification, 1994 is known as Environmental Clearance.</span></font></p>
          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4"><span style="mso-bidi-font-size: 13.0pt">Following
          thirty types of activities/projects are required Environmental
          Clearance:-</span></p>
          <ol class="txt4">
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Nuclear
              power and related project such as Heavy Water Plants, nuclear fuel
              complex, rare earths.</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">River
              Valley projects including hydel power, major irrigation and their
              combination including flood control.</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Ports,
              harbours, Airports (except minor ports and harbours).</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Petroleum
              Refineries including crude and product pipelines.</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Chemical
              Fertilizers (Nitrogenous and phosphatic other than single super
              phosphate).</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Pesticides
              (Technical)</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Petrochemical
              complexes (Both Olefinic and Aromatic) and Petro-Chemical
              intermediates such as DMT, Caprolactam, LAB etc. and production of
              basic plastics such as LDPE, HDPE, PP, PVC.</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Bulk
              drugs and pharmaceuticals.</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Exploration
              for oil and gas and their production, transportation and storage.</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Synthetic
              Rubber.</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Asbestos
              and Asbestos products</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Hydro
              cyanic acid and its derivatives.</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">(a)
              <span style="mso-spacerun:yes">&nbsp;</span>Primary metallurgical
              industries (such as production of Iron and Steel, Aluminium,
              Copper, Zinc, Lead and Ferro Alloys).</p>
            </li>
          </ol>
          <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          (b) <span style="mso-spacerun:yes">&nbsp;&nbsp;</span>Electric arc
          furnaces (Mini Steel plants).<o:p>
          </o:p>
          </p>
          <ol class="txt4">
            <li value="14">
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Chlor-alkali
              industry.</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Integrated
              plant complex including manufacture of resins and basic raw
              material required in the manufacture of paints.</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4" >Viscose
              Staple fibre and filament yarn.</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Storage
              batteries integrated with manufacture of oxides of lead and lead
              antimony alloy.</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">All
              tourism projects between 200m-500 meters of High Tide Line or at
              locations with an elevation of more than 1000 meters with
              investment of more than Rs. 5 Crores.</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Thermal
              Power Plants</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Mining
              Project (major minerals) with leases more than 5 hectares.</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Highway
              Projects except projects relating to improvement work including
              widening and strengthening of roads with marginal land acquisition
              along the existing alignments provided it does not pass through
              ecologically sensitive areas such as National Parks, Sanctuaries,
              Tiger reserves, Reserve forests.</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Tarred
              Roads in Himalayas and/or Forest areas.</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Distilleries</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Raw
              Skins and Hides</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Pulp,
              paper and newsprint</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Dyes</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" CLASS="TXT4">Cement</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Foundries
              (individual)</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Electroplating</p>
            </li>
            <li>
              <p  style="text-align: justify; margin-left: 75; margin-right: 35" class="txt4">Meta
              amino phenol</p>
            </li>
          </ol>
        </td>
      </tr>
                    </table>
            </div>
                
                
                
                
    
   
	    <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr> 
		
		</table>
		        <div align="left" class="txt" style="color: navy">
			  <br>
			
		</div>
		
  			</g:form>
            <br />
            <br />

          </div>
		  
		  
		  </table>
		  
		  
		  
		  
		  
		  
		  
		  
		  
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


	    	   