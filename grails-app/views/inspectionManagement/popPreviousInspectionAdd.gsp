<html>
<!-- this file is created by bhanu on 12-06-2017 -->
<head>
    <calendar:resources lang="en" theme="aqua"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript">
        $( document ).ready(function() {
            var myRadios = document.getElementsByName('applicationNo');
            var setCheck;
            var x = 0;
            for(x = 0; x < myRadios.length; x++){

                myRadios[x].onclick = function(){
                    if(setCheck != this){
                        setCheck = this;
                    }else{
                        this.checked = false;
                        setCheck = null;
                    }
                };

            }
        });
        function isValidDate(d){
            return !isNaN((new Date(d)).getTime());
        }
        function validate(){
            var validateApplicationNo = false;
            var validateInspectionDate = true;
            var validateInspectionFile = false;
            var validateInspectionSize = true;
            var validationMessage = "";
            var radios = document.getElementsByName('applicationNo');
            for (var i = 0; i < radios.length; i++) {
                if (radios[i].type === 'radio' && radios[i].checked) {
                    validateApplicationNo = true;
                }
            }
            var inspectionDate = document.getElementById('inspectionDate').value;
            if(!isValidDate(inspectionDate)){
                validateInspectionDate =  false;
            }
            if(document.getElementById("previousInspectionReportFile").value != "") {
                validateInspectionFile = true;
                var fileSize = $("#previousInspectionReportFile")[0].files[0].size / 1024;
                // alert("fileSize: " + fileSize);
                if(fileSize > 2048){
                    validateInspectionSize = false;
                }
            }


            if(!validateApplicationNo){
                validationMessage += "* Please select Application number\n";
            }
            if(!validateInspectionDate){
                validationMessage += "* Please select Inspection date\n";
            }
            if(!validateInspectionFile){
                validationMessage += "* Please choose inspection file\n";
            }
            if(!validateInspectionSize){
                validationMessage += "* Inspection file size should not be more that 2 MB\n";
            }

            if((!validateApplicationNo) || (!validateInspectionDate) || (!validateInspectionFile) || (!validateInspectionSize)){
                alert(validationMessage);
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<%

    def industryRegMasterInstance = IndustryRegMaster.get(Long.parseLong(industryRegMasterInstanceId))


%>
<div class="container">
    <table width="100%">
        <tr><!-- Div area for errors-->
            <td align="center" valign="top"><div style="width:400px; height:20px; vertical-align:middle"><span class="error">
                <g:if test="${flash.message}">
                    <div class="message">${flash.message}</div>
                </g:if>
            </span></div></td>
        </tr>
    </table>
    <form action="savePopPreviousInspectionAdd" method="post" enctype="multipart/form-data" onSubmit = "return(validate())">
    <input type="hidden" name="industryRegMasterInstanceId" value="<%=industryRegMasterInstanceId%>" />
    <input type="hidden" name="group" value="<%=group%>" />
    <div class="row" style="background-color: #A8DAF3">
        <div class="col-12 text-center">
            <span class="headngblue" style="height: 25px">Add Previous Inspection</span>
        </div>
    </div>
    <div class="row">
        %{--<div class="col-6">
            Industry id
        </div>
        <div class="col-6">
            <%=indUser%>
        </div>--}%
        <div class="col-12 txt4" >
        <br>
        <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt table-striped" style="border-collapse:collapse;">
            <tr class="txt4" style="font-size: small; background-color: #d4ebf2">
                <td>#</td>
                <td>Application No.</td>
                <td>Application Type</td>
                <td>Application For</td>
                <td>Application Status</td>
                <td>Application Received Date</td>
                <td>Last Activity Date</td>
                <td>Inspection Raised</td>
                <td>Regular Inspection Status</td>
                <td>Note History</td>

            </tr>
            <%for(int i = 0; i < outer.size(); i++){%>
            <tr class="txt4" style="font-size: small;">
                <td><input type="radio" name="applicationNo" value="<%= outer[i][0] %>"></td>
                <td><%= outer[i][0]%></td>
                <td><%= outer[i][1]%></td>
                <td><%= outer[i][2]%></td>
                <td><%= outer[i][3]%></td>
                <td><%= outer[i][4]%></td>
                <td><%= outer[i][5]%></td>
                <td><%= outer[i][6]%></td>
                <td><%= outer[i][7]%></td>
                <td>
                    <a href="<%=request.getContextPath()%>/applicationProcessingDetails/openApplicationDetails/${outer[i][0]}" target="_blank"><span class="innerlink">&nbsp;Application Note History&nbsp;</span></a>
                    <br>
                    <%if(outer[i][6].equals("YES")){%>
                    <a href="<%=request.getContextPath()%>/inspectionManagement/showInspectionNoteHistroy?typeOfInspection=REGULAR_INSPECTION&id=${outer[i][0]}" target="_blank"><span class="innerlink">&nbsp;Regular Inspection Note History&nbsp;</span></a>
                    <!-- code to show previous inspection note history start-->
                    <%
                        def inspectionNoteList = InspectionNoteHistory.findAll("from InspectionNoteHistory where typeOfInspection = 'PREVIOUS_INSPECTION' AND application.id = ? order by id asc ",[(outer[i][0]).toLong()])
                        if(inspectionNoteList){%>
                    <br>
                    <a href="<%=request.getContextPath()%>/inspectionManagement/showInspectionNoteHistroy?typeOfInspection=PREVIOUS_INSPECTION&id=${outer[i][0]}" target="_blank"><span class="innerlink">&nbsp;Previous Inspection Note History&nbsp;</span></a>
                        <%}%>
                    <!-- code to show previous inspection note history ends -->
                    <%}%>
                </td>
            </tr>
            <%}%>
        </table>
        <br>
            <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
                <tr class="txt4" style="font-size: small">
                    <td style="background-color: #e8f4f8">
                        &nbsp;&nbsp;Industry id
                    </td>
                    <td>
                        &nbsp;&nbsp;<%=indUser%>
                    </td>
                </tr>

                <tr class="txt4" style="font-size: small">
                    <td style="background-color: #d4ebf2">
                        &nbsp;&nbsp;Industry Name
                    </td>
                    <td style="background-color: #f1f1f1">
                        &nbsp;&nbsp;<%=industryRegMasterInstance.indName%>
                    </td>
                </tr>

                <tr class="txt4" style="font-size: small">
                    <td style="background-color: #e8f4f8">
                        &nbsp;&nbsp;Inspection date
                    </td>
                    <td>
                        &nbsp;&nbsp;<input type="date" id="inspectionDate" name="inspectionDate"/>&nbsp;<i>(dd-mm-yyyy)</i>
                    </td>
                </tr>

                <tr class="txt4" style="font-size: small">
                    <td style="background-color: #d4ebf2">
                        &nbsp;&nbsp;Category
                    </td>
                    <td style="background-color: #f1f1f1">
                        &nbsp;&nbsp;<%=industryRegMasterInstance.category.name%>
                    </td>
                </tr>

                <tr class="txt4" style="font-size: small">
                    <td style="background-color: #e8f4f8">
                        &nbsp;&nbsp;Upload previous inspection report
                    </td>
                    <td>
                        &nbsp;&nbsp;<span><input type="file" id="previousInspectionReportFile" name="previousInspectionReportFile"></span>
                    </td>
                </tr>

                <tr class="txt4" style="font-size: small">
                    <td style="background-color: #d4ebf2">
                        &nbsp;&nbsp;Inspected by officer
                    </td>
                    <td style="background-color: #f1f1f1">
                        &nbsp;&nbsp;<g:select optionKey="id" class="txt4" from="${myArrayList2}" id="officer" name="officer"  />
                    </td>
                </tr>

                <tr class="txt4" style="font-size: small">
                    <td style="background-color: #e8f4f8">
                        &nbsp;&nbsp;Approve/Refuse
                    </td>
                    <td style="background-color: white">
                        &nbsp;&nbsp;<label><input type="radio" name="approveOrReject" value="Approved" checked="checked"> Approve</label>&nbsp;&nbsp;&nbsp;&nbsp;
                        <label><input type="radio" name="approveOrReject" value="Refused"> Refuse</label>
                    </td>
                </tr>
                <tr class="txt4" style="font-size: small">
                    <td style="background-color: #d4ebf2">
                        &nbsp;&nbsp;Approve/Refuse Note
                    </td>
                    <td style="background-color: #f1f1f1">
                        &nbsp;&nbsp;<textarea name="approveOrRejectNote" maxlength="255" cols="30"></textarea>
                    </td>
                </tr>

            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-12 text-center">
            <br>
            <input type="submit" class="actionbutton" name="savePopPreviousInspectionAdd" value="Add">
        </div>
    </div>
    </form>
</div>
</body>
</html>