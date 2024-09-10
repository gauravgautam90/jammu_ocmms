<%@ page import="java.text.SimpleDateFormat" %>
<head>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'main.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'anylinkmenu.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'tabcontent.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'stylesheet.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'style.css')}"/>
</head>

<body>
<g:form action="submittedClarification" enctype="multipart/form-data" name="myform" method="post">
    <% int versionVal1 = 0;
    def var = 0;
    int varCheckInsClarification = 0;
    int varCheckInsClarifications = 0;
    int varCheck = 0;
    int varCheckIns = 0;
    int varCheckCla = 0;
    int varCheckFile = 0;
    int varCheckCl = 0;
    int varCheckCl1 = 0;
    int fileVersion = 0;
    int fileVersionReply = 0;

    def versionValue1 = 1
    def applicationFileInstanceNotZero = ApplicationFileRecord.findAll("from ApplicationFileRecord afr where afr.indApplication=?  and afr.version!=0 and afr.name='ScnCertiFicate.pdf' order by afr.id desc", [app])
    if (applicationFileInstanceNotZero) {
    } else {
        versionValue1 = 0
    }

    %>
    <g:each in="${applicationProcessingDetailsInstanceList}" status="i" var="appClarification">

        <%


            if (appClarification) { %>
        <table width="60%" align="center">
            <%
                    SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss a");
                    String strDate = sdfDestination.format(appClarification.dateCreated);
                    if (appClarification.clarification == true) { %>

            <tr>
                <td width="150px" align="center" valign="middle" colspan=2 class="headngblue" bgcolor="#A8DAF3"><div
                        align="center" class="style3">Clarification Raised Details :</div></td>
            </tr>
            <tr>
                <td width="150px" bgcolor="#A8DAF3" class="headngblue"><div align="right"
                                                                            class="style3">Date Time:</div></td>
                <td align="left" bgcolor="#E8F6F9" class="txt4">
                    <%=strDate%></td>
            </tr>

            <tr>
                <td width="150px" align="right" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="right"
                                                                                                          class="style3">Raised By:</div>
                </td>
                <td bgcolor="#E8F6F9" class="txt4"><div align="left">${appClarification.role}(${
                        appClarification.officer})</div></td>
            </tr>
            <tr>
                <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right"
                                                                            class="style3">Notice Type:</div></td>
                <td align="left" bgcolor="#E8F6F9" class="txt4">${appClarification.noticeType}</td>
            </tr>

            <tr>
                <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right"
                                                                            class="style3">Description:</div></td>
                <td align="left" bgcolor="#E8F6F9" class="txt4">${appClarification.clarificationNote}</td>
            </tr>

            <!-- satish code start -->
            <%if(appClarification.clarificationAttachedFile == true){%>
            <tr >
                <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">SCN Certificate:</div></td>
                <td align="left" bgcolor="#E8F6F9" class="txt4">
                    <g:link action="downLoadingCertificateForScnEwaste"  id="${appClarification.applicationId}" params="[fileVer: fileVersion, applicationId: appClarification.applicationId]"><span class="innerlink">&nbsp; <u>View SCN(E-Waste) For Refusal</u>&nbsp;</span></g:link>
                    <% System.out.println("fileVer: " + fileVersion) %>
                </td>
            </tr>
            <%
                        fileVersion = fileVersion + 1;
                    }
            %>
            <!-- satish code ends -->

            <%
                } else if ((appClarification.clarificationNote) || (appClarification.clarificationReplyAttachedFile)) { %>



            <tr>
                <td width="150px" colspan=2 align="centre" class="headngblue" bgcolor="#A8DAF3"><div align="center"
                                                                                                     class="style3">Clarification Reply Details :</div>
                </td>
            </tr>
            <tr>
                <td width="150px" bgcolor="#A8DAF3" class="headngblue"><div align="right"
                                                                            class="style3">Date Time:</div></td>
                <td align="left" bgcolor="#E8F6F9" class="txt4">
                    <%=strDate%></td>
            </tr>
            <tr>
                <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right"
                                                                            class="style3">Description:</div></td>
                <td align="left" bgcolor="#E8F6F9" class="txt4">${appClarification.clarificationNote}</td>
            </tr>


            %{--SATISH code starts--}%
            <%
                    def appId = appClarification.applicationId
            %>
            <tr >
                <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Uploaded Document:</div></td>
                <td align="left" bgcolor="#E8F6F9" class="txt4">
                    <g:link action="viewClarificationReplyAttachment"  id="${appId}" params="[fileVerReply: fileVersionReply, applicationId: appClarification.applicationId]"><span class="innerlink">&nbsp; <u>View Clarification Reply Attachment</u>&nbsp;</span></g:link>
                </td> </tr>
            <%
                    fileVersionReply += 1
            %>
            %{-- SATISH code ends--}%


            <tr>

                <td width="150px" colspan=2 class="headngblue" bgcolor="grey"><div align="right" class="style3"></div>
                </td>
            </tr>

            <% } %>

        </table>

        <% } %>
    </g:each>
</g:form>
<script language="JavaScript" type="text/javascript">

    var frmvalidator = new Validator("general");
    frmvalidator.EnableFocusOnError(false);
    // frmvalidator.EnableMsgsTogether();

    function Checkfiles() {
        var frm = document.forms["myform"];
        var fupp = document.getElementsByName('indClarificationFile');
        var fup = fupp[0];
        var fileName = fup.value;
        var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();

        if (ext == "pdf" || fileName == "")
            return true;
        else {
            sfm_show_error_msg('Please upload non editable files as Gif,pdf or Jpg files', fupp);

            return false;
        }
    }
    frmvalidator.setAddnlValidationFunction("Checkfiles");
</script>
</body>
 
  
                