<head>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>




<script type="text/javascript">



</script>
<script type="text/javascript" language="javascript">window.history.forward(1);</script>
<% String cont=request.getContextPath()%>

</head>



<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0">

   
    <tr>
                <td height="3" valign="top"></td>
              </tr>
			  
			<!--  
              <tr>
                <td valign="top"><table width="224" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="6" align="left" valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'left_nav.gif')}" width="6" height="31" /></td>
                    <td width="218" height="31" align="left" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'left_midlle.gif')}" ><table width="218" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="11" align="left" valign="middle"><img src="${createLinkTo(dir:'images2/gif',file:'bullet.gif')}" width="11" height="10" /></td>
                        <td><g:link controller="inspectionManagement" action="regularInspection"><span class="leftlink">Regular Inspection</span></g:link></td>
                      </tr>
					  
					  <tr>
               			 <td height="3" valign="top"></td>
             		 </tr>
                    </table></td>
                  </tr>
				  
                </table></td>
              </tr>
			-->


			 <tr>
                <td valign="top"><table width="224" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="6" align="left" valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'left_nav.gif')}" width="6" height="31" /></td>
                    <td width="218" height="31" align="left" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'left_midlle.gif')}" ><table width="218" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="11" align="left" valign="middle"><img src="${createLinkTo(dir:'images2/gif',file:'bullet.gif')}" width="11" height="10" /></td>
                        <td><g:link controller="inspectionManagement" action="regularInspectionCat"><span class="leftlink">

                            <%if((UserMaster)session.getAttribute("userMaster")){
                                UserMaster aa = (UserMaster)session.getAttribute("userMaster");
                                String userType = aa.accessLevel
                                if(userType.equals("admin")) { %>
                            <!-- bhanu code ends -->
                                Regular Inspection
                            <!-- bhanu code start; date: 20-06-2017 -->
                            <% 	}else{ %>
                                Add previous inspection
                            <%	}
                            } %>
                            <!-- bhanu code ends -->


                                                </span></g:link></td>
                      </tr>
					  
					  <tr>
               			 <td height="3" valign="top"></td>
             		 </tr>
                    </table></td>
                  </tr>
				  
                </table></td>
              </tr>
			  <!--<tr>
                <td height="150" align="left" valign="middle" bgcolor="#E8F1F3" class="pollution">The Pollution Control Board has<br />
                  been established as a regulatory
                  authority for implementing variious pollution
                  control laws. <span class="pollution2">The board is committed to provide polloution free environment to the people of state. The Board has undertaken various studies of underground water, solil and air to take remedial steps to control pollution.</span></td>
              </tr>-->

            <!-- bhanu commented code start; date: 03-07-2017 -->
              %{--<tr>
                <td valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'feedback.gif')}" width="224" height="64" /></td>
              </tr>
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'query.gif')}" width="224" height="64" /></td>
              </tr>
              <tr>
                <td valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'grad.gif')}" width="224" height="296" /></td>
              </tr>--}%
              <tr >
                    <td height="300"></td>
                </tr>
            <!-- bhanu commented code ends -->
            </table>
            
 </body>           
