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
            var validateTreatmentEquipment = true;
            var validateNoOfUnits = true;
            var validateCapacity = true;
            var validateQuantity = true;

            var validationMessage = "";

            if(document.disposalFacilities.treatmentEquipment.value == "" ||
                document.disposalFacilities.treatmentEquipment.value == "Select"){
                validateTreatmentEquipment = false;
            }
            if(document.disposalFacilities.noOfUnits.value == "" ||
                document.disposalFacilities.noOfUnits.value.indexOf('e') > -1){
                validateNoOfUnits = false;
            }
            if(document.disposalFacilities.capacity.value == "" ||
                document.disposalFacilities.capacity.value.indexOf('e') > -1){
                validateCapacity = false;
            }
            if(document.disposalFacilities.quantity.value == "" ||
                document.disposalFacilities.quantity.value.indexOf('e') > -1){
                validateQuantity = false;
            }

            if(!validateTreatmentEquipment){
                validationMessage += "* Please select type of treatment equipment\n";
            }if(!validateNoOfUnits){
                validationMessage += "* Please enter valid number of units\n";
            }
            if(!validateCapacity){
                validationMessage += "* Please enter valid capacity\n";
            }
            if(!validateQuantity){
                validationMessage += "* Please enter valid quantity treated or disposed\n";
            }

            if((!validateTreatmentEquipment) || (!validateNoOfUnits) || (!validateCapacity) ||
                (!validateQuantity)){
                alert(validationMessage);
                return false;
            }
            return true;

        }
    </script>
</head>
<body>
<g:form name="disposalFacilities" method="post" action="saveDisposalFacilities" onSubmit = "return(validate())">
<div class="form">
<table width="80%" class="table">
    <tr style="display: none">
        <td>
            <input type="hidden" name="bmwRenewId" value="<%=bmwRenewId%>" />
        </td>
    </tr>
    <tr bgcolor="#D1D1D1">
        <td colspan="4" style="text-align: center">
            <span>Add Disposal Facilities</span>
        </td>
    </tr>
    <tr class="headngblue secondRow" bgcolor="#A8DAF3">
        <td>
            Type of treatment Equipment
        </td>
        <td>
            Number of Units
        </td>
        <td>
            Capacity(Kg/Day)
        </td>
        <td>
            Quantity treated or disposed(Kg/Annum)
        </td>
    </tr>
    <tr class="headngblue" bgcolor="#E8F6F9">
        <td>
            <select name="treatmentEquipment">
                <option value="Select" selected disabled hidden>Select</option>
                <option value="Incinerators">Incinerators</option>
                <option value="Plasma Paralysis">Plasma Paralysis</option>
                <option value="Autoclaves">Autoclaves</option>
                <option value="Microwave">Microwave</option>
                <option value="Hydroclave">Hydroclave</option>
                <option value="Shredder">Shredder</option>
                <option value="Needle tip cutter or destroyer">Needle tip cutter or destroyer</option>
                <option value="Sharps encapsulation or concrete pit">Sharps encapsulation or concrete pit</option>
                <option value="Shredder">Shredder</option>
            </select>
        </td>
        <td>
            <input type="number" min="0" name="noOfUnits" step="any">
        <td>
            <input type="number" min="0" name="capacity" step="any">
        </td>
        <td>
            <input type="number" min="0" name="quantity" step="any">
        </td>

    </tr>
    <tr class="headngblue">
        <td colspan="4" style="margin: auto">
            <input id="addButton" type="submit" name="saveDisposalFacilities" value="Add" class="actionbutton">
        </td>
    </tr>

</table>
</div>
</g:form>

<div class="form">
<table class="table table-striped" width="80%">
    <tr  class="headngblue secondRow" style="background-color: #A8DAF3">
        <td>
            Type of treatment Equipment
        </td>
        <td>
            Number of Units
        </td>
        <td>
            Capacity(Kg/Day)
        </td>
        <td>
            Quantity treated or disposed(Kg/Annum)
        </td>
    </tr>
    <g:each in="${disposalFacilitiesList}"  status="i" var="df">
        <tr class="small" align="center">
            <td bgcolor="#E8F6F9">
                ${df.typeOfTreatment}
            </td>
            <td bgcolor="#E8F6F9">
                ${df.numberOfUnits}
            </td>
            <td bgcolor="#E8F6F9">
                ${df.capacity}
            </td>
            <td bgcolor="#E8F6F9">
                ${df.quantity}
            </td>

        </tr>
    </g:each>

</table>
</div>
</body>
</html>