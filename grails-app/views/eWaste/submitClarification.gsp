<%@ page import="java.text.SimpleDateFormat" %>
<head>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'main.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'anylinkmenu.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'tabcontent.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'stylesheet.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'style.css')}"/>
    <script type="text/javascript"
            src="${createLinkTo(dir: 'js', file: 'gen_validatorv31.js')}"></script>
    <!-- satish code start; date: 05-04-2017-->
    <script>
        window.onunload = refreshParent;
        function refreshParent() {
            window.opener.location.reload();
        }
    </script>
    <!-- satish code ends -->
</head>

<body>

<g:form action="submittedClarification" enctype="multipart/form-data" name="myform" method="post">

    <% if (appClarification) { %>
    <table>
        <%
                SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-MM-yyyy hh:mm");
                String strDate = sdfDestination.format(appClarification.dateCreated);
        %>

        <tr>
            <td width="150px" bgcolor="#A8DAF3" class="headngblue"><div align="right" class="style3">Date Time:</div>
            </td>
            <td align="left" bgcolor="#E8F6F9" class="txt4">
                <%=strDate%></td>
        </tr>
        <!--
  					<tr>				
                              <td width="150px" align="right" valign="middle" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Raised By:</div></td>
                        <td bgcolor="#E8F6F9" class="txt4"><div align="left">${appClarification.role}(${
                appClarification.officer})</div></td>
        			</tr>			
					  -->
        <tr>
            <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right"
                                                                        class="style3">Clarification Description:</div>
            </td>
            <td align="left" bgcolor="#E8F6F9" class="txt4">${appClarification.clarificationNote}</td>
        </tr>


        %{--SATISH code starts--}%
        <%
                if (appClarification.noticeType == "Clarification") {
        %>
        <tr>
            <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right"
                                                                        class="style3">Clarification Days:</div></td>
            <td align="left" bgcolor="#E8F6F9" class="txt4">${appClarification.clarificationDays}</td>
        </tr>
        <%
                }
        %>
        %{--SATISH code ends--}%

                <%
                System.out.println("appClarification..: "+appClarification)
                 System.out.println("app.id..: "+app.id)
                
                %>

        <tr>
            <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right" class="style3">Notes:</div></td>
            <td align="left" bgcolor="#E8F6F9" class="txt4"><textarea name="indClarificationNote" cols="35"
                                                                      class="txt4"></textarea></td>
        </tr>
        <g:if test="${appClarification.clarificationAttachedFile == true}">
            <tr bgcolor="#F4F7FB">
                <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right"
                                                                            class="style3">Clarification Report:</div>
                </td>
                <td bgcolor="#E8F6F9" class="headngblue"><g:link action="viewClarificationReportIndustry"
                                                                 controller="eWaste" 
              params="[appliLoc:app.id, docName:'attachedClarificationReport', docType:'doc']">View Report</g:link></td>
            </tr>
        </g:if>
        <tr>
            <td width="150px" class="headngblue" bgcolor="#A8DAF3"><div align="right"
                                                                        class="style3">Upload Document</div></td>
            <td align="left" bgcolor="#E8F6F9" class="txt4"><input type="file" name="indClarificationIssueFile"
                                                                   id="indClarificationIssueFile"/><br>*Upload only non-editable files as Gif,pdf or Jpg files
            </td>
        </tr>
        <tr>

            <td><input type="hidden" name="appId" value="<%=app.id%>"></input></td>
            <td width="150px" colspan="2" class="headngblue" bgcolor="#E8F6F9" align="center"><input type="submit"
                                                                                                     name="Save"
                                                                                                     value="Save"
                                                                                                     class="actionbutton">
            </td>
        </tr>

    </table>
    <% } %>
</g:form>
<script language="JavaScript" type="text/javascript">

    var frmvalidator = new Validator("myform");
    frmvalidator.EnableFocusOnError(false);
    frmvalidator.EnableMsgsTogether();

    function Checkfiles() {

        var frm = document.forms["myform"];
        var fup = document.getElementById('indClarificationIssueFile');


        var fileName = fup.value;
        var ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();

        if (ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "bmp" || ext == "JPG" || ext == "pdf" || fileName == "") {

            return true;
        }
        else {

            sfm_show_error_msg('Please upload Gif,pdf,bmp or Jpg files only', fup);
            return false;
        }
    }


    frmvalidator.setAddnlValidationFunction("Checkfiles");



</script>
</body>
 