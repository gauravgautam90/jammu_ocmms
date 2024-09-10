<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html >

<head>
    <%

        response.setHeader("Cache-Control", "no-cache");

        response.setHeader("Pragma", "no-cache");

        response.setDateHeader("Expires", -1);

    %>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>

    <title>Inspection Note History</title>

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'main.css')}"/>

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'anylinkmenu.css')}"/>

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'tabcontent.css')}"/>

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'stylesheet.css')}"/>

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'style.css')}"/>


    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'menucontents.js')}"></script>

    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'anylinkmenu.js')}"></script>

    <g:javascript library="prototype"/>





    <script type="text/javascript">

    </script>
    <script type="text/javascript" language="javascript">window.history.forward(1);</script>

</head>

<body>

<table align="center" width="85%">

    <tr align="center">

        <td width="100%" align="center">

            <div>

                <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs">
                    <!-- bhanu code start; date: 23-06-2017 -->
                    <tr>

                        <td colspan="4" align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">
                            <g:if test="${flash.message}">
                                <div class="message">${flash.message}</div>
                            </g:if>
                        </span></div></td>

                    </tr>
                    <!-- bhanu code ends -->
                    <tr>
                        <td width="11"><img src="${createLinkTo(dir: 'images2/gif', file: 'industry_details_left.gif')}"
                                            width="11" height="27"/></td>
                        <td width="147" align="center"
                            background="${createLinkTo(dir: 'images2/gif', file: 'industry_details_middle.gif')}"
                            class="top-lnks"><a href="#" rel="country1">Inspection Details</a></td>
                        <td width="11" valign="bottom"><img
                                src="${createLinkTo(dir: 'images2/gif', file: 'industry_details_right.gif')}" width="11"
                                height="27"/></td>
                        <td width="432"><a href="javascript:window.print()">print</a></td>
                    </tr>
                </table>

                <div style="border" :1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
                <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr">
                    <!-- bhanu code start; date: 20-06-2017 -->
                    <%
                        def versionForPreviousInspectionFile = 0
                        %>
                    <!-- bhanu code ends -->

                    <g:each in="${inspectionNoteList}" status="i" var="inspectionNoteInstance">
                        <tr><td><table>
                            <% SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
                            String strDate = sdfDestination.format(inspectionNoteInstance.dateCreated);
                            System.out.println("inspectionNoteInstance..."+inspectionNoteInstance)
                            %>

                            <!-- bhanu code start; date: 20-04-2017 -->
                            <%if(inspectionNoteInstance.previousReportAttachedFile){ %>
                            <tr bgcolor="#F4F7FB">
                                <td width="150px" class="headngblue"><div align="left" class="style3">
                                    Added on: </div>
                                </td>
                                <td align="left" width="80%"><span class="txt style6">
                                    <table width="100%">
                                        <tr>
                                            <td align="left">
                                                <%=sdfDestination.format(inspectionNoteInstance.lastUpdated)%>
                                            </td>
                                            <td align="right">
                                                <%if((UserMaster)session.getAttribute("userMaster")){
                                                    UserMaster userMaster = (UserMaster)session.getAttribute("userMaster");
                                                    String userMasterAccessLevel = userMaster.accessLevel
                                                    if(userMasterAccessLevel.equals("admin")) {
                                                %>
                                                <g:link action="deleteAddedPreviousInspection" params="[applicationId: inspectionNoteInstance.applicationId, inspectionNoteHistoryId: inspectionNoteInstance.id,
                                                                               fileVersion: versionForPreviousInspectionFile]">
                                                    delete
                                                </g:link>
                                                <%}}%>
                                            </td>
                                        </tr>
                                    </table>

                                </span></td>
                            </tr>

                            <%}%>
                            <!-- bhanu code ends -->

                            <tr bgcolor="#F4F7FB">
                                <td width="150px" class="headngblue"><div align="left" class="style3">
                                    <!-- bhanu code start; date: 20-04-2017 -->
                                    <%if(inspectionNoteInstance.previousReportAttachedFile){ %>Inspection <%}%>
                                    <!-- bhanu code ends -->
                                    Date Time:</div>
                                </td>
                                <td align="left" width="80%"><span class="txt style6">
                                    <%=strDate%>
                                </span></td>
                            </tr>


                            <tr align="center">
                                <td width="150px" align="right" valign="middle" class="headngblue"><div align="left"
                                                                                                        class="style3">Note By:</div>
                                </td>
                                <td><div align="left"><span
                                        class="txt style6">${inspectionNoteInstance.role}(${inspectionNoteInstance.officer})</span>
                                </div></td>
                            </tr>

                            <tr>
                                <td width="150px" align="right" valign="middle" class="headngblue"><div align="left"
                                                                                                        class="style3">Forwarded To:</div>
                                </td>
                                <td><div align="left"><span
                                        class="txt style6">${inspectionNoteInstance.roleFwd}(${inspectionNoteInstance.officerFwd})</span>
                                </div></td>
                            </tr>


                            <!-- bhanu code commented start; date: 20-06-2017-->
                            %{--<tr bgcolor="#F4F7FB">
                                <td width="150px" class="headngblue"><div align="left"
                                                                          class="style3">Description :</div></td>
                                <td><div align="left"><span
                                        class="txt style6">${inspectionNoteInstance.inspectionDescriptionNote}</span>
                                </div></td>
                            </tr>--}%
                            <%if(!inspectionNoteInstance.previousReportAttachedFile){%>
                            <tr bgcolor="#F4F7FB">
                                <td width="150px" class="headngblue"><div align="left"
                                                                          class="style3">Description :</div></td>
                                <td><div align="left"><span
                                        class="txt style6">${inspectionNoteInstance.inspectionDescriptionNote}</span>
                                </div></td>
                            </tr>
                            <%}%>
                            <!-- bhanu code commented ends -->

                            <!-- bhanu code start; date: 20-06-2017 -->
                            <%if(inspectionNoteInstance.previousReportAttachedFile){ %>

                            <tr bgcolor="#F4F7FB">
                                <td width="150px" class="headngblue"><div align="left"
                                                                          class="style3">Previous inspection number :</div></td>
                                <td><div align="left"><span
                                        class="txt style6">${inspectionNoteInstance.inspectionDescriptionNote}</span>
                                </div></td>
                            </tr>
                            <tr bgcolor="#F4F7FB">
                                <td width="150px" class="headngblue"><div align="left"
                                                                          class="style3">Description :</div></td>
                                <td><div align="left"><span
                                        class="txt style6">${inspectionNoteInstance.inspectionNote}</span>
                                </div></td>
                            </tr>
                            <tr bgcolor="#F4F7FB">
                                <td width="150px" class="headngblue"><div align="left"
                                                                          class="style3">Approve/Reject Note :</div></td>
                                <td><div align="left"><span
                                        class="txt style6">
                                    ${inspectionNoteInstance.approveNote}
                                    ${inspectionNoteInstance.rejectNote}</span>
                                </div></td>
                            </tr>
                            <tr bgcolor="#F4F7FB">
                                <td width="150px" class="headngblue"><div align="left"
                                                                          class="style3">Attached file :</div></td>
                                <td><div align="left"><span
                                        class="txt style6"><a href="<%=
                                            request.getContextPath()%>/inspectionManagement/downloadPreviousReport/<%=
                                            inspectionNoteInstance.application%>?version=<%= versionForPreviousInspectionFile %>" target="_blank"><span
                                            class="headngblue">View Uploaded Docs</span></a></span>
                                </div></td>
                            </tr>
                            <%versionForPreviousInspectionFile++%>
                            <%}%>
                            <!-- bhanu code ends;  -->
                            <tr bgcolor="#F4F7FB">
                                <td width="150px" class="headngblue"><div align="left" class="style3">Activity:</div>
                                </td>
                                <% System.out.println("inspectionNoteInstance.111111111.."+inspectionNoteInstance)
                                if (inspectionNoteInstance.noticeType.equals("Clarification")) { 
                                	System.out.println("AAAAAAAAAAAAAA")
                                	%>
                                <td><div align="left"><span class="txt style6">${
                                        inspectionNoteInstance.noticeType}</span></div>
                                        <g:if test="${inspectionNoteInstance.clarificationAttachedFile==true}">
                   				 <g:link action="viewFile14" controller="inspectionManagement" params="[appliLoc:inspectionNoteInstance.application,docName:'Attach_Regular_Clarification_Report',docType:'doc']">View Report</g:link>
                              </g:if>
                                    <% } else if (inspectionNoteInstance.revoke) { 
                                    	System.out.println("BBBBBBBBBBBBB")%>
                                <td><div align="left"><span class="txt style6">Revokation</span></div>

                                    <% } else if (inspectionNoteInstance.approve) { 
                                    	System.out.println("CCCCCCCCCCCC")%>
                                <td><div align="left"><span class="txt style6">Approved</span></div>

                                    <% } else if (inspectionNoteInstance.reject) { 
                                    	System.out.println("DDDDDDDDDDDD")%>
                                <td><div align="left"><span class="txt style6">Rejected</span></div>

                                    <% } else if (inspectionNoteInstance.closeInd) { 
                                    	System.out.println("EEEEEEEEEEE")%>
                                <td><div align="left"><span class="txt style6">Closing Industry</span></div>

                                    <% } else if (inspectionNoteInstance.revokeCloseInd) { 
                                    	System.out.println("FFFFFFFFFFFFF")%>
                                <td><div align="left"><span class="txt style6">Revoke and Close Industry</span></div>

                                    <% } else if (inspectionNoteInstance.noticeType=="Clarification Reply") { 
                                    	System.out.println("GGGGGGGGGGGGGGG")%>
                                <td><div align="left"><span class="txt style6">Clarification Reply</span></div>
                                <g:if test="${inspectionNoteInstance.clarificationReplyAttachedFile==true}">
                            <g:link action="viewSubmittedRegularClarification" controller="inspectionManagement" params="[appliLoc:inspectionNoteInstance.application,docName:'Attached_Clarification_Report',docType:'doc']">View Clarification Reply Attachment</g:link> 
                            </g:if>
                                 <% } else { 
                                    	System.out.println("HHHHHHHHHHHHHHHH")%>
                                <td><div align="left"><span class="txt style6">${
                                        inspectionNoteInstance.inspectionNote}</span></div>

                                    <% } %>

                                    <% System.out.println("inspectionNoteInstance.id...."+inspectionNoteInstance.id)
                                        def appFileInst = ApplicationFileRecord.findAll("from ApplicationFileRecord where typeOfFile='regularInspectionReportOtherDocs' and indApplication.id=?  and appProcessId=?", [params.id.toLong(),(inspectionNoteInstance.id).toString()])

                                        if (appFileInst) { %>
                                            <div align="left"  bgcolor="#E8F6F9" class="headngblue">Letter Attached</div>
                                       
                                   
                                                <%
                                                for(int p=0;p<appFileInst.size();p++){ %>
                                                <g:def var="fId" value="${appFileInst.get(p).id}"/>
                                                    <g:link action="dwonloadOtherDocumentByInd" controller="applicationProcessingDetails" params="[fileId:fId]">View Attachment:<%=p+1%> </g:link>&nbsp;
                                                   
                                                    
                                                <%
                                                }
                                                %>
                                                
                                                
                                                
                                    <% 
                                    } %>
                                 
                                </td>
                            </tr>

                            <tr bgcolor="#F4F7FB">
                                <td width="150px" class="headngblue"><div align="left"
                                                                          class="style3">Status Of Inspection :</div>
                                </td>
                                <td><div align="left"><span class="txt style6">
                                    <g:if test="${inspectionNoteInstance.applicationClosed == false}">
                                        Inspection Is In Progress
                                    </g:if>
                                    <g:if test="${inspectionNoteInstance.applicationClosed == true}">
                                        Inspection Closed
                                    </g:if>
                                </span></div></td>
                            </tr>


                            <tr>
                                <td height="0" bgcolor="black" colspan="2"></td>
                            </tr>
                        </table></td></tr>

                    </g:each>

                </table>

    <tr>

        <td height="1" colspan="2" bgcolor="#d0d1d0"></td>

    </tr>

</table>

</body>
</html>
 