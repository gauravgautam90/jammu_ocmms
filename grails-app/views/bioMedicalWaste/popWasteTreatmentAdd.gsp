<html>
<head>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'bootstrap.css')}" />
    <style>
    div.form{
        padding-left: 10%;
        padding-right: 10%;
        padding-top: 2%;
    }
    center{
        text-align: center;
        margin: auto;
    }
    input#addButton{
        margin-top: 4%;
        margin-left:50%;

    }
    .secondRow{
        background-color: #A8DAF3;
    }
    </style>

    <script>
        function validate(){
            var validateTypeOfWaste = true;
            var validateQuantityGenerated = true;
            var validateWhereDisposal = true;


            var validationMessage = "";

            if(document.wasteTreatment.typeOfWaste.value == "" ||
                document.wasteTreatment.typeOfWaste.value == "Select"){
                validateTypeOfWaste = false;
            }
            if(document.wasteTreatment.quantityGenerated.value == "" ||
                document.wasteTreatment.quantityGenerated.value.indexOf('e') > -1){
                validateQuantityGenerated = false;
            }
            if(document.wasteTreatment.whereDisposal.value == "" ){
                validateWhereDisposal = false;
            }


            if(!validateTypeOfWaste){
                validationMessage += "* Please select type of waste\n";
            }
            if(!validateQuantityGenerated){
                validationMessage += "* Please enter valid quantity generated\n";
            }
            if(!validateWhereDisposal){
                validationMessage += "* Please enter where disposal\n";
            }


            if((!validateTypeOfWaste) || (!validateQuantityGenerated) || (!validateWhereDisposal)){
                alert(validationMessage);
                return false;
            }
            return true;

        }
    </script>
</head>
<body>
<g:form name="wasteTreatment" method="post" action="saveWasteTreatment" onSubmit = "return(validate())">
    <div class="form">
        <table width="80%" class="table">
            <tr style="display: none">
                <td>
                    <input type="hidden" name="bmwRenewId" value="<%=bmwRenewId%>" />
                </td>
            </tr>
            <tr bgcolor="#D1D1D1">
                <td colspan="3" style="text-align: center">
                    <span>Add details of incineration, ash and
                    ETP sludge generated and
                    disposal</span>
                </td>
            </tr>
            <tr class="headngblue secondRow">
                <td>
                    Type Of Waste
                </td>
                <td>
                    Quantity Generated
                </td>
                <td>
                    Where Disposal
                </td>

            </tr>
            <tr class="headngblue" bgcolor="#E8F6F9">
                <td>
                    <select name="typeOfWaste">
                        <option value="Select" selected disabled hidden>Select</option>
                        <option value="Incineration">Incineration</option>
                        <option value="Ash">Ash</option>
                        <option value="ETP Sludge">ETP Sludge</option>
                    </select>
                </td>
                <td>
                    <input type="number" min="0" name="quantityGenerated" step="any">
                <td>
                    <input type="text" name="whereDisposal">
                </td>


            </tr>
            <tr class="headngblue">
                <td colspan="4" style="margin: auto">
                    <input id="addButton" type="submit" name="saveWasteTreatment" value="Add" class="actionbutton">
                </td>
            </tr>

        </table>
    </div>
</g:form>
<div class="form">
    <table class="table table-striped" width="80%">
        <tr class="headngblue secondRow" style="background-color:#A8DAF3">
            <td>
                Type Of Waste
            </td>
            <td>
                Quantity Generated
            </td>
            <td>
                Where Disposal
            </td>

        </tr>
        <g:each in="${wasteTreatmentList}"  status="i" var="wt">
            <tr class="small">
                <td bgcolor="#E8F6F9">
                    ${wt.typeOfWaste}
                </td>
                <td bgcolor="#E8F6F9">
                    ${wt.quantityGenerated}
                </td>
                <td bgcolor="#E8F6F9">
                    ${wt.whereDisposal}
                </td>


            </tr>
        </g:each>

    </table>
</div>
</body>
</html>