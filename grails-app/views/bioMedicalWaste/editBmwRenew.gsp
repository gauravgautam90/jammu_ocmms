<% System.out.println("111111111111111111111"); %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
    <title>SPCB Industry Home</title>
    <calendar:resources lang="en" theme="aqua"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'bootstrap.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'main.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'anylinkmenu.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'tabcontent.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'stylesheet.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'style.css')}"/>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'menucontents.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'anylinkmenu.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'tabcontent.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'md5.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'gen_validatorv31.js')}"></script>

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'design.css')}"/>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'tabs.js')}"></script>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'calendar.css')}"/>


    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'calendar_us.js')}"></script>


    <style type="text/css">
    <!--
    body {
        margin-left: 0px;
        margin-top: 0px;
        margin-right: 0px;
        margin-bottom: 0px;
    }

    .style3 {
        color: #186DB5
    }

    .style5 {
        color: #0099FF
    }

    .style6 {
        color: #33FF66;
    }

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

    a.addViewDelete:hover {
        text-decoration: underline;
    }

    .qwe123 {
        background-image: url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}');
        padding-left: 23px;
        padding-right: 20px;
        padding-top: 5px;
        padding-bottom: 5px;

    }

    .qwe123:hover {
        background-image: url('${createLinkTo(dir:'images2/gif',file:'gray_bg.gif')}');
    }

    .blue {
        background-image: url('${createLinkTo(dir:'images2/gif',file:'button_gray.gif')}');
        padding-left: 30px;
        padding-right: 27px;
        padding-top: 5px;
        padding-bottom: 7px;
    }

    .blue:hover {
        background-image: url('${createLinkTo(dir:'images2/gif',file:'button_blue.gif')}');
    }

    -->
    </style>


    <script type="text/javascript">
        anylinkmenu.init("menuanchorclass")

        function selectHcfType() {
            document.getElementById('hcfType1').style.backgroundColor = "";
            var choosenOption = document.getElementById('hcfType1');
            if (choosenOption.value == "HCF") {
                if (document.getElementById('noOfBeds_id'))
                    document.getElementById('noOfBeds_id').style.display = 'block';
                if (document.getElementById('noOfBeds_id1'))
                    document.getElementById('noOfBeds_id1').style.display = 'block';
                if (document.getElementById('non_bedded_id'))
                    document.getElementById('non_bedded_id').style.display = 'block';
                if (document.getElementById('non_bedded_id1'))
                    document.getElementById('non_bedded_id1').style.display = 'block';
                if (document.getElementById('licenceNo_id'))
                    document.getElementById('licenceNo_id').style.display = 'block';
                if (document.getElementById('licenceNo_id1'))
                    document.getElementById('licenceNo_id1').style.display = 'block';
                if (document.getElementById('licenceDateOfExpiry_id'))
                    document.getElementById('licenceDateOfExpiry_id').style.display = 'block';
                if (document.getElementById('licenceDateOfExpiry_id1'))
                    document.getElementById('licenceDateOfExpiry_id1').style.display = 'block';
                if (document.getElementById('licenceDateOfExpiry_id11'))
                    document.getElementById('licenceDateOfExpiry_id11').style.display = 'block';
                if (document.getElementById('noHealthcareCBMWTF_id'))
                    document.getElementById('noHealthcareCBMWTF_id').style.display = 'none';
                if (document.getElementById('noHealthcareCBMWTF_id1'))
                    document.getElementById('noHealthcareCBMWTF_id1').style.display = 'none';
                if (document.getElementById('noBedsCBMWTF_id'))
                    document.getElementById('noBedsCBMWTF_id').style.display = 'none';
                if (document.getElementById('noBedsCBMWTF_id1'))
                    document.getElementById('noBedsCBMWTF_id1').style.display = 'none';
                if (document.getElementById('installedTreatmentCBMWTF_id'))
                    document.getElementById('installedTreatmentCBMWTF_id').style.display = 'none';
                if (document.getElementById('installedTreatmentCBMWTF_id1'))
                    document.getElementById('installedTreatmentCBMWTF_id1').style.display = 'none';
                if (document.getElementById('quantityBiomedicalCBMWTF'))
                    document.getElementById('quantityBiomedicalCBMWTF').style.display = 'none';
                if (document.getElementById('quantityBiomedicalCBMWTF1'))
                    document.getElementById('quantityBiomedicalCBMWTF1').style.display = 'none';

            }
            else if (choosenOption.value == "CBMWTF") {

                if (document.getElementById('noOfBeds_id'))
                    document.getElementById('noOfBeds_id').style.display = 'none';
                if (document.getElementById('noOfBeds_id1'))
                    document.getElementById('noOfBeds_id1').style.display = 'none';
                if (document.getElementById('non_bedded_id'))
                    document.getElementById('non_bedded_id').style.display = 'none';
                if (document.getElementById('non_bedded_id1'))
                    document.getElementById('non_bedded_id1').style.display = 'none';
                if (document.getElementById('licenceNo_id'))
                    document.getElementById('licenceNo_id').style.display = 'none';
                if (document.getElementById('licenceNo_id1'))
                    document.getElementById('licenceNo_id1').style.display = 'none';
                if (document.getElementById('licenceDateOfExpiry_id'))
                    document.getElementById('licenceDateOfExpiry_id').style.display = 'none';
                if (document.getElementById('licenceDateOfExpiry_id1'))
                    document.getElementById('licenceDateOfExpiry_id1').style.display = 'none';
                if (document.getElementById('licenceDateOfExpiry_id11'))
                    document.getElementById('licenceDateOfExpiry_id11').style.display = 'none';
                if (document.getElementById('noHealthcareCBMWTF_id'))
                    document.getElementById('noHealthcareCBMWTF_id').style.display = 'block';
                if (document.getElementById('noHealthcareCBMWTF_id1'))
                    document.getElementById('noHealthcareCBMWTF_id1').style.display = 'block';
                if (document.getElementById('noBedsCBMWTF_id'))
                    document.getElementById('noBedsCBMWTF_id').style.display = 'block';
                if (document.getElementById('noBedsCBMWTF_id1'))
                    document.getElementById('noBedsCBMWTF_id1').style.display = 'block';
                if (document.getElementById('installedTreatmentCBMWTF_id'))
                    document.getElementById('installedTreatmentCBMWTF_id').style.display = 'block';
                if (document.getElementById('installedTreatmentCBMWTF_id1'))
                    document.getElementById('installedTreatmentCBMWTF_id1').style.display = 'block';
                if (document.getElementById('quantityBiomedicalCBMWTF'))
                    document.getElementById('quantityBiomedicalCBMWTF').style.display = 'block';
                if (document.getElementById('quantityBiomedicalCBMWTF1'))
                    document.getElementById('quantityBiomedicalCBMWTF1').style.display = 'block';
            }else{
                if (document.getElementById('noOfBeds_id'))
                    document.getElementById('noOfBeds_id').style.display = 'none';
                if (document.getElementById('noOfBeds_id1'))
                    document.getElementById('noOfBeds_id1').style.display = 'none';
                if (document.getElementById('non_bedded_id'))
                    document.getElementById('non_bedded_id').style.display = 'none';
                if (document.getElementById('non_bedded_id1'))
                    document.getElementById('non_bedded_id1').style.display = 'none';
                if (document.getElementById('licenceNo_id'))
                    document.getElementById('licenceNo_id').style.display = 'none';
                if (document.getElementById('licenceNo_id1'))
                    document.getElementById('licenceNo_id1').style.display = 'none';
                if (document.getElementById('licenceDateOfExpiry_id'))
                    document.getElementById('licenceDateOfExpiry_id').style.display = 'none';
                if (document.getElementById('licenceDateOfExpiry_id1'))
                    document.getElementById('licenceDateOfExpiry_id1').style.display = 'none';
                if (document.getElementById('licenceDateOfExpiry_id11'))
                    document.getElementById('licenceDateOfExpiry_id11').style.display = 'none';
                if (document.getElementById('noHealthcareCBMWTF_id'))
                    document.getElementById('noHealthcareCBMWTF_id').style.display = 'none';
                if (document.getElementById('noHealthcareCBMWTF_id1'))
                    document.getElementById('noHealthcareCBMWTF_id1').style.display = 'none';
                if (document.getElementById('noBedsCBMWTF_id'))
                    document.getElementById('noBedsCBMWTF_id').style.display = 'none';
                if (document.getElementById('noBedsCBMWTF_id1'))
                    document.getElementById('noBedsCBMWTF_id1').style.display = 'none';
                if (document.getElementById('installedTreatmentCBMWTF_id'))
                    document.getElementById('installedTreatmentCBMWTF_id').style.display = 'none';
                if (document.getElementById('installedTreatmentCBMWTF_id1'))
                    document.getElementById('installedTreatmentCBMWTF_id1').style.display = 'none';
                if (document.getElementById('quantityBiomedicalCBMWTF'))
                    document.getElementById('quantityBiomedicalCBMWTF').style.display = 'none';
                if (document.getElementById('quantityBiomedicalCBMWTF1'))
                    document.getElementById('quantityBiomedicalCBMWTF1').style.display = 'none';
            }

        }


        function bmwManagementCommitteeRadio1() {

            if (document.getElementById('bmwManagementCommitteeNo1').checked) {
                document.getElementById('bmwManagementCommitteeDetail').style.display = 'none';
            }
            if (document.getElementById('bmwManagementCommitteeYes1').checked) {
                document.getElementById('bmwManagementCommitteeDetail').style.display = 'block';
            }
        }

        function bmwManagementCommitteeRadio2() {

            if (document.getElementById('bmwManagementCommitteeNo2').checked) {
                document.getElementById('bmwManagementCommitteeDetail').style.display = 'none';

            }
            if (document.getElementById('bmwManagementCommitteeYes2').checked) {
                document.getElementById('bmwManagementCommitteeDetail').style.display = 'block';

            }
        }

        function SelectOwnershipOfHCFClicked() {
            document.getElementById('SelectOwnershipOfHCF').style.backgroundColor = "";
        }

        function noOfBedsClicked() {
            document.getElementById('noOfBeds').style.backgroundColor = "";
        }
        function licenceNoClicked() {
            document.getElementById('licenceNo').style.backgroundColor = "";
        }

        function noHealthcareCBMWTFClicked() {
            document.getElementById('noHealthcareCBMWTF').style.backgroundColor = "";
        }

        function noBedsCBMWTFClicked() {
            document.getElementById('noBedsCBMWTF').style.backgroundColor = "";
        }

        function installedTreatmentCBMWTFClicked() {
            document.getElementById('installedTreatmentCBMWTF').style.backgroundColor = "";
        }

        function quantityBiomedicalCBMWTFIdClicked() {
            document.getElementById('quantityBiomedicalCBMWTFId').style.backgroundColor = "";
        }

        function yellowCategoryClicked() {
            document.getElementById('yellowCategory').style.backgroundColor = "";
        }

        function redCategoryClicked() {
            document.getElementById('redCategory').style.backgroundColor = "";
        }

        function whiteCategoryClicked() {
            document.getElementById('whiteCategory').style.backgroundColor = "";
        }

        function blueCategoryClicked() {
            document.getElementById('blueCategory').style.backgroundColor = "";
        }

        function generalSolidWasteClicked() {
            document.getElementById('generalSolidWaste').style.backgroundColor = "";
        }

        function onSideStorageSizeClicked() {
            document.getElementById('onSideStorageSize').style.backgroundColor = "";
        }

        function onSideStorageCapacityClicked() {
            document.getElementById('onSideStorageCapacity').style.backgroundColor = "";
        }

        function qtyRecyclableWasteSoldClicked() {
            document.getElementById('qtyRecyclableWasteSold').style.backgroundColor = "";
        }

        function vehicleUsedForBmwClicked() {
            document.getElementById('vehicleUsedForBmw').style.backgroundColor = "";
        }

        function bmwManagementCommitteeDetailIdClicked() {
            document.getElementById('bmwManagementCommitteeDetailId').style.backgroundColor = "";
        }

        function numOfTrainingConductedBmwClicked() {
            document.getElementById('numOfTrainingConductedBmw').style.backgroundColor = "";
        }

        function numOfPersonnelTrainedClicked() {
            document.getElementById('numOfPersonnelTrained').style.backgroundColor = "";
        }

        function numOfPersonnelTrainedInductionClicked() {
            document.getElementById('numOfPersonnelTrainedInduction').style.backgroundColor = "";
        }

        function numOfPersonnelNotUndergoneTrainingClicked() {
            document.getElementById('numOfPersonnelNotUndergoneTraining').style.backgroundColor = "";
        }

        function numOfAccidentOccurredClicked() {
            document.getElementById('numOfAccidentOccurred').style.backgroundColor = "";
        }

        function numOfPersonsAffectedClicked() {
            document.getElementById('numOfPersonsAffected').style.backgroundColor = "";
        }

        function accidentRemedialActionClicked() {
            document.getElementById('accidentRemedialAction').style.backgroundColor = "";
        }

        function meetingAirPollutionStandardClicked() {
            document.getElementById('meetingAirPollutionStandard').style.backgroundColor = "";
        }

        function continuousOnlineEmissionDetailClicked() {
            document.getElementById('continuousOnlineEmissionDetail').style.backgroundColor = "";
        }

        function meetingWaterPollutionStandardClicked() {
            document.getElementById('meetingWaterPollutionStandard').style.backgroundColor = "";
        }

        function meetingDisinfectionStandardClicked() {
            document.getElementById('meetingDisinfectionStandard').style.backgroundColor = "";
        }

        function airPollutionDeviceOtherInfoClicked() {
            document.getElementById('airPollutionDeviceOtherInfo').style.backgroundColor = "";
        }

        function validate(){

            var validationMessage = "";
            if (document.myform.appStatus.value == "Completed") {
                if(document.myform.ownershipOfHCF.value == "" ||
                    document.myform.ownershipOfHCF.value == "Select"){
                	alert("Please select ownership Of HCF");
                	return false;
                }
                if(document.myform.hcfType.value == "select"){
                	alert("Please select hcf Type");
                	return false;
                }else if(document.myform.hcfType.value == "HCF"){
                    if(document.myform.noOfBeds.value == "" ||
                        document.myform.noOfBeds.value.indexOf('e') > -1){
                    	alert("Please enter numeric no Of Beds HCF");
                    	return false;
                    }
                    if(document.myform.licenceNo.value == "" ||
                        document.myform.licenceNo.value.indexOf('e') > -1){
                    	alert("Please enter numeric licence No HCF");
                    	return false;
                    }
                }else if(document.myform.hcfType.value == "CBMWTF"){
                    if(document.myform.noHealthcareCBMWTF.value == "" ||
                        document.myform.noHealthcareCBMWTF.value.indexOf('e') > -1){
                    	alert("Please enter numeric no Healthcare CBMWTF");
                    	return false;
                    }
                    if(document.myform.noBedsCBMWTF.value == "" ||
                        document.myform.noBedsCBMWTF.value.indexOf('e') > -1){
                    	alert("Please enter numeric no Beds CBMWTF");
                    	return false;
                    }
                    if(document.myform.installedTreatmentCBMWTF.value == "" ||
                        document.myform.installedTreatmentCBMWTF.value.indexOf('e') > -1){
                    	alert("Please enter numeric installed Treatment CBMWTF");
                    	return false;
                    }
                    if(document.myform.quantityBiomedicalCBMWTF.value == "" ||
                        document.myform.quantityBiomedicalCBMWTF.value.indexOf('e') > -1){
                    	alert("Please enter numeric quantity Biomedical CBMWTF");
                    	return false;
                    }
                }

                if(document.myform.yellowCategory.value == "" ||
                    document.myform.yellowCategory.value.indexOf('e') > -1){
                	alert("Please enter numeric yellow Category");
                	return false;
                }
                if(document.myform.redCategory.value == "" ||
                    document.myform.redCategory.value.indexOf('e') > -1){
                	alert("Please enter numeric red Category");
                	return false;
                }
                if(document.myform.whiteCategory.value == "" ||
                    document.myform.whiteCategory.value.indexOf('e') > -1){
                	alert("Please enter numeric white Category");
                	return false;
                }
                if(document.myform.blueCategory.value == "" ||
                    document.myform.blueCategory.value.indexOf('e') > -1){
                	alert("Please enter numeric blue Category");
                	return false;
                }
                if(document.myform.generalSolidWaste.value == "" ||
                    document.myform.generalSolidWaste.value.indexOf('e') > -1){
                	alert("Please enter numeric general Solid Waste");
                	return false;
                }
                if(document.myform.onSideStorageSize.value == "" ||
                        document.myform.onSideStorageSize.value.indexOf('e') > -1){
                		alert("Please enter On-Site Storage Size");
                	return false;
                }
                 if(document.myform.onSideStorageCapacity.value == "" ||
                             document.myform.onSideStorageCapacity.value.indexOf('e') > -1){
                	alert("Please enter numeric On-Site Storage Capacity");
                	return false;
                }
                if(document.myform.qtyRecyclableWasteSold.value == "" ||
                    document.myform.qtyRecyclableWasteSold.value.indexOf('e') > -1){
                	alert("Please enter numeric qty Recyclable Waste Sold");
                	return false;
                }
                if(document.myform.vehicleUsedForBmw.value == "" ||
                    document.myform.vehicleUsedForBmw.value.indexOf('e') > -1){
                	alert("Please enter numeric vehicle Used For Bmw");
                	return false;
                }
                if(document.myform.bmwManagementCommittee.value == "yes"){
                    if(document.myform.bmwManagementCommitteeDetail.value == ""){
                    	alert("Please enter bmw Management Committee Detail");
                    	return false;
                    }
                }
                if(document.myform.numOfTrainingConductedBmw.value == "" ||
                    document.myform.numOfTrainingConductedBmw.value.indexOf('e') > -1){
                	alert("Please enter numeric num Of Training Conducted Bmw");
                	return false;
                }
                if(document.myform.numOfPersonnelTrained.value == "" ||
                    document.myform.numOfPersonnelTrained.value.indexOf('e') > -1){
                	alert("Please enter numeric num Of Personnel Trained");
                	return false;
                }
                if(document.myform.numOfPersonnelTrainedInduction.value == "" ||
                    document.myform.numOfPersonnelTrainedInduction.value.indexOf('e') > -1){
                	alert("Please enter numeric num Of Personnel Trained Induction");
                	return false;
                }
                if(document.myform.numOfPersonnelNotUndergoneTraining.value == "" ||
                    document.myform.numOfPersonnelNotUndergoneTraining.value.indexOf('e') > -1){
                	alert("Please enter numeric num Of Personnel Not Undergone Training");
                	return false;
                }
                if(document.myform.numOfAccidentOccurred.value == "" ||
                    document.myform.numOfAccidentOccurred.value.indexOf('e') > -1){
                	alert("Please enter numeric num Of Accident Occurred");
                	return false;
                }
                if(document.myform.numOfPersonsAffected.value != ""){
                    if(document.myform.numOfPersonsAffected.value.indexOf('e') > -1){
                    	alert("Please enter numeric num Of Persons Affected");
                    	return false;
                    }
                }
                if(document.myform.accidentRemedialAction.value == ""){
                	alert("Please enter accident Remedial Action");
                	return false;
                }
                if(document.myform.meetingAirPollutionStandard.value == ""){
                	alert("Please enter meeting Air Pollution Standard");
                	return false;
                }
                if(document.myform.continuousOnlineEmissionDetail.value == ""){
                	alert("Please enter continuous Online Emission Detail");
                	return false;
                }
                if(document.myform.meetingWaterPollutionStandard.value == ""){
                	alert("Please enter meeting Water Pollution Standard");
                	return false;
                }
                if(document.myform.meetingDisinfectionStandard.value == ""){
                	alert("Please enter meeting Disinfection Standard");
                	return false;
                }
                if(document.myform.airPollutionDeviceOtherInfo.value == ""){
                	alert("Please enter air Pollution Device Other Info");
                	return false;
                }
            } else if (document.myform.appStatus.value == "Inprogress"){
                if(document.myform.hcfType.value == "select"){
                	alert("Please HCF/CBMWTF type");
                	return false;
                }
                if(document.myform.hcfType.value == "HCF"){

                    if (document.myform.noOfBeds.value != "") {
                        if(document.myform.noOfBeds.value.indexOf('e') > -1){
                        	alert("Please enter numeric No of beds");
                        	return false;
                        }
                    }
                    if (document.myform.licenceNo.value != "") {
                        if(document.myform.licenceNo.value.indexOf('e') > -1){
                        	alert("Please enter numeric licence No");
                        	return false;
                        }
                    }
                }else if(document.myform.hcfType.value == "CBMWTF"){
                    if (document.myform.noHealthcareCBMWTF.value != "") {
                        if(document.myform.noHealthcareCBMWTF.value.indexOf('e') > -1){
                        	alert("Please enter numeric no of Healthcare CBMWTF");
                        	return false;
                        }
                    }
                    if (document.myform.noBedsCBMWTF.value != "") {
                        if(document.myform.noBedsCBMWTF.value.indexOf('e') > -1){
                        	alert("Please enter numeric no of beds CBMWTF");
                        	return false;
                        }
                    }

                    if (document.myform.installedTreatmentCBMWTF.value != "") {
                        if(document.myform.installedTreatmentCBMWTF.value.indexOf('e') > -1){
                        	alert("Please enter numeric installed Treatment CBMWTF");
                        	return false;
                        }
                    }
                    if (document.myform.quantityBiomedicalCBMWTF.value != "") {
                        if(document.myform.quantityBiomedicalCBMWTF.value.indexOf('e') > -1){
                        	alert("Please enter numeric quantity of Biomedical CBMWTF");
                        	return false;
                        }
                    }
                }
                if (document.myform.yellowCategory.value != "") {
                    if(document.myform.yellowCategory.value.indexOf('e') > -1){
                    	alert("Please enter numeric quantity of Biomedical CBMWTF");
                    	return false;
                    }
                }
                if (document.myform.redCategory.value != "") {
                    if(document.myform.redCategory.value.indexOf('e') > -1){
                    	alert("Please enter numeric red Category");
                    	return false;
                    }
                }
                if (document.myform.whiteCategory.value != "") {
                    if(document.myform.whiteCategory.value.indexOf('e') > -1){
                    	alert("Please enter numeric white Category");
                    	return false;
                    }
                }
                if (document.myform.blueCategory.value != "") {
                    if(document.myform.blueCategory.value.indexOf('e') > -1){
                    	alert("Please enter numeric blue Category");
                    	return false;
                    }
                }
                if (document.myform.generalSolidWaste.value != "") {
                    if(document.myform.generalSolidWaste.value.indexOf('e') > -1){
                    	alert("Please enter numeric general Solid Waste");
                    	return false;
                    }
                }
                if (document.myform.qtyRecyclableWasteSold.value != "") {
                    if(document.myform.qtyRecyclableWasteSold.value.indexOf('e') > -1){
                    	alert("Please enter numeric qty Recyclable Waste Sold");
                    	return false;
                    }
                }
                if (document.myform.vehicleUsedForBmw.value != "") {
                    if(document.myform.vehicleUsedForBmw.value.indexOf('e') > -1){
                    	alert("Please enter numeric vehicle Used For Bmw");
                    	return false;
                    }
                }
                if (document.myform.numOfTrainingConductedBmw.value != "") {
                    if(document.myform.numOfTrainingConductedBmw.value.indexOf('e') > -1){
                    	alert("Please enter numeric num Of Training Conducted Bmw");
                    	return false;
                    }
                }
                if (document.myform.numOfPersonnelTrained.value != "") {
                    if(document.myform.numOfPersonnelTrained.value.indexOf('e') > -1){
                    	alert("Please enter numeric num Of Personnel Trained");
                    	return false;
                    }
                }
                if (document.myform.numOfPersonnelTrainedInduction.value != "") {
                    if(document.myform.numOfPersonnelTrainedInduction.value.indexOf('e') > -1){
                    	alert("Please enter numeric num Of Personnel Trained");
                    	return false;
                    }
                }
                if (document.myform.numOfPersonnelNotUndergoneTraining.value != "") {
                    if(document.myform.numOfPersonnelNotUndergoneTraining.value.indexOf('e') > -1){
                    	alert("Please enter numeric num Of Personnel Not Undergone Training");
                    	return false;
                    }
                }
                if (document.myform.numOfAccidentOccurred.value != "") {
                    if(document.myform.numOfAccidentOccurred.value.indexOf('e') > -1){
                    	alert("Please enter numeric num Of Accident Occurred");
                    	return false;
                    }
                }
                if(document.myform.numOfPersonsAffected.value != ""){
                    if(document.myform.numOfPersonsAffected.value.indexOf('e') > -1){
                    	alert("Please enter numeric num Of Persons Affected");
                    	return false;
                    }
                }

            }
            return true;

        }

    </script>

    <style>
    .input-xs {
        height: 25px;
        width: 200px;
        padding: 2px 5px;
        font-size: 12px;
        line-height: 1.5; /* If Placeholder of the input is moved up, rem/modify this. */
        border-radius: 3px;
    }
    </style>




</head>

<body>
<%
    IndustryRegMaster industryRegMaster = IndustryRegMaster.get(industryRegMasterId)
    BmwRenew bmwRenew = BmwRenew.get(bmwRenewId)
%>
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
                <td height="32" align="left" valign="top"
                    background="${createLinkTo(dir: 'images2/gif', file: 'button_BG.gif')}">
                    <!-- code for menuIndustryHorizontal-->
                    <g:include controller="userMaster" action="showIndustryMenuHorizontal"/>
                </td>
            </tr>
            <tr>
                <td align="left" valign="top"><table width="1003" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="224" align="left" valign="top" bgcolor="#DEEED0">
                            <!-- code for menuSpcbUser-->
                            <%
                                if ((IndUser) session.getAttribute("indUser")) { %>
                            <g:include controller="userMaster" action="wasteManagementIndustryVertical"/><% } %>
                            <% if ((UserMaster) session.getAttribute("userMaster")) {
                                UserMaster aa = (UserMaster) session.getAttribute("userMaster");
                                String userType = aa.accessLevel;
                                if (userType.equals("admin")) { %>
                            <g:include controller="userMaster" action="wasteManagementAdminVertical"/>
                            <% } else { %>
                            <g:include controller="userMaster" action="wasteManagementEmpVertical"/>
                            <% }
                            } %>
                            <% if ((!(IndUser) session.getAttribute("indUser")) && (!(UserMaster) session.getAttribute("userMaster"))) { %>
                            <g:include controller="userMaster" action="showIndexMenu"/>
                            <% } %>
                        </td>
                        <td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
                        <td width="778" align="left"
                            valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                                <td height="1" valign="top"></td>
                            </tr>
                            <tr>
                                <td><img src="${createLinkTo(dir: 'images2', file: 'img.jpg')}" width="778"
                                         height="134"/></td>
                            </tr>
                            <%
                                IndustryRegMaster ind = (IndustryRegMaster) session.getAttribute("indregName")
                                String indname = ind.indName;

                                java.util.Date dateSCR = new java.util.Date();
                                int year = dateSCR.getYear();
                                if (year < 1000)
                                    year += 1900;
                                int date = dateSCR.getDate();
                                int month = (dateSCR.getMonth()) + 1;


                            %>

                            <tr>
                                <td height="24" bgcolor="#EEEEF3">

                                    <table width="100%" bgcolor="#4C8BC0">
                                        <tr bgcolor="#4C8BC0">
                                            <td class="top-lnks">Welcome <%=indname%></td>
                                            <td class="top-lnks"
                                                align="right">Date :&nbsp;<%=date%>-<%=month%>-<%=year%></td>
                                        </tr>
                                    </table>

                                </td>
                            </tr>
                            <tr>
                                <td height="0" align="left"
                                    valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr><!-- Div area for errors-->  <td align="center" valign="top">
                                        <div
                                                style="width:400px;  vertical-align:middle">
                                            <span class="error">
                                                <g:if test="${flash.message}">
                                                    <div class="message">${flash.message}</div>
                                                </g:if>
                                                <g:hasErrors bean="${bioMedicalWasteInstance}">
                                                    <div class="errors">
                                                        <g:renderErrors bean="${bioMedicalWasteInstance}" as="list"/>
                                                    </div>
                                                </g:hasErrors>
                                            </span>
                                    </td>
                                    </tr>
                                    <!--<tr>
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                                <tr>
                                <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="33" align="left" valign="top">&nbsp;</td>
                                <td width="100%" align="left" valign="top"><div style="padding:0px 0px 0px 0px;">

                                    <br/>
                                    <g:form name="myform" action="saveBmwRenew" method="post"
                                            onSubmit = "return(validate())"
                                            enctype="multipart/form-data">

                                        <input type="hidden" name="industryRegMasterInstance"
                                               value="${industryRegMasterInstance}"/>
                                        <input type="hidden" name="bmwRenewId" value="${bmwRenewId}"/>
                                        <input type="hidden" name="industryRegMasterId" value="${industryRegMasterId}"/>
                                        <table width="100%" border="0" align="left" cellpadding="2" cellspacing="0">
                                            <tr valign="middle">
                                                <td width="100%" align="center">
                                                <ol id="toc">
												<li><a href="#country1"><span>General Details</span></a></li>
											    <li><a href="#country2"><span>Health Care Facilities Details</span></a></li>
												<li><a href="#country3"><span>Quantity of Waste Generated</span></a></li>
												<li><a href="#country4"><span>Storage,Treatment,Transportation,Processing and Disposal Facility Details</span></a></li>
												<li><a href="#country5"><span>BMW Management Committee</span></a></li>
												<li><a href="#country6"><span>Training Conducted</span></a></li>
												<li><a href="#country7"><span>Accident Occurred & Other Detail</span></a></li>
												</ol>
                                                </td>
                                                <td align="right" valign="middle" class="headngblue"></td>
                                            </tr>
                                        </table>
                                        </div>


                                        <div id="country1" class="content">
										<div class="dialog">
											 <table>
													<tbody>
														   <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
														   <tr>
                                                                        <td colspan="2" width="40%" bgcolor="#004386"
                                                                            align="center"
                                                                            style="color: white"
                                                                            class="headngblue">Particulars of the Occupier</td>
                                                                    </tr>

                                                                    <tr>
                                                                        <td width="40%" bgcolor="#A8DAF3" align="left"
                                                                            class="headngblue">Name of the authorized person
                                                                        (occupier or operator of facility)
                                                                        </td>
                                                                        <td width="60%" bgcolor="#E8F6F9" align="left"
                                                                            class="headngblue">
                                                                            <input type="text" name="occName"
                                                                                   class="input-xs form-control"
                                                                                   value="<%=industryRegMaster.occName%>" readonly>
                                                                        </td>
                                                                    </tr>

                                                                    <tr>
                                                                        <td width="40%" bgcolor="#A8DAF3" align="left"
                                                                            class="headngblue">Name of HCF or CBMWTF
                                                                        </td>
                                                                        <td width="60%" bgcolor="#E8F6F9" align="left"
                                                                            class="headngblue">
                                                                            <input type="text" name="industryName"
                                                                                   class="input-xs form-control"
                                                                                   value="<%=industryRegMaster.indName%>" readonly>
                                                                        </td>
                                                                    </tr>

                                                                    <tr>
                                                                        <td width="40%" bgcolor="#A8DAF3" align="left"
                                                                            class="headngblue">Address for Correspondence
                                                                        </td>
                                                                        <td width="60%" bgcolor="#E8F6F9" align="left"
                                                                            class="headngblue">
                                                                            <input type="text" name="occAddress"
                                                                                   class="input-xs form-control"
                                                                                   value="<%=industryRegMaster.occAddress%>" readonly>
                                                                        </td>
                                                                    </tr>

                                                                    <tr>
                                                                        <td width="40%" bgcolor="#A8DAF3" align="left"
                                                                            class="headngblue">Address of Facility
                                                                        </td>
                                                                        <td width="60%" bgcolor="#E8F6F9" align="left"
                                                                            class="headngblue">
                                                                            <input type="text" name="indAddress"
                                                                                   class="input-xs form-control"
                                                                                   value="<%=industryRegMaster.indAddress%>" readonly>
                                                                        </td>
                                                                    </tr>

                                                                    <tr>
                                                                        <td width="40%" bgcolor="#A8DAF3" align="left"
                                                                            class="headngblue">Tel. No.
                                                                        </td>
                                                                        <td width="60%" bgcolor="#E8F6F9" align="left"
                                                                            class="headngblue">
                                                                            <input type="text" name="occMobile"
                                                                                   class="input-xs form-control"
                                                                                   value="<%=industryRegMaster.occMobile%>" readonly>
                                                                        </td>
                                                                    </tr>

                                                                    <tr>
                                                                        <td width="40%" bgcolor="#A8DAF3" align="left"
                                                                            class="headngblue">Fax. No.
                                                                        </td>
                                                                        <td width="60%" bgcolor="#E8F6F9" align="left"
                                                                            class="headngblue">
                                                                            <table>
                                                                                <tr>
                                                                                    <td>
                                                                                        <input type="text"
                                                                                               name="occFaxCode"
                                                                                               class="input-xs form-control"
                                                                                               value="<%=industryRegMaster.occFaxCode%>"
                                                                                               readonly>
                                                                                    </td>
                                                                                    <td>
                                                                                        <input type="text"
                                                                                               name="occFaxNo"
                                                                                               class="input-xs form-control"
                                                                                               value="<%=industryRegMaster.occFaxNo%>"
                                                                                               readonly>
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                        </td>
                                                                    </tr>

                                                                    <tr>
                                                                        <td width="40%" bgcolor="#A8DAF3" align="left"
                                                                            class="headngblue">E-mail ID
                                                                        </td>
                                                                        <td width="60%" bgcolor="#E8F6F9" align="left"
                                                                            class="headngblue">
                                                                            <input type="text" name="occEmailId"
                                                                                   class="input-xs form-control"
                                                                                   value="<%=industryRegMaster.occEmail%>" readonly>
                                                                        </td>
                                                                    </tr>

                                                                    <tr>
                                                                        <td width="40%" bgcolor="#A8DAF3" align="left"
                                                                            class="headngblue">URL of Website
                                                                        </td>
                                                                        <td width="60%" bgcolor="#E8F6F9" align="left"
                                                                            class="headngblue">
                                                                            <input type="text" name="websiteURL"
                                                                                   class="input-xs form-control"
                                                                            value="<%=bmwRenew.occUrlWebsite%>">
                                                                        </td>
                                                                    </tr>

                                                                    <tr>
                                                                        <td width="40%" bgcolor="#A8DAF3" align="left"
                                                                            class="headngblue">GPS coordinates of HCF of
                                                                        CBMWTF
                                                                        </td>
                                                                        <td width="60%" bgcolor="#E8F6F9" align="left"
                                                                            class="headngblue">
                                                                            <input type="text" name="gpsCoordinate"
                                                                                   class="input-xs form-control"
                                                                            value="<%=bmwRenew.occGpsCoordinate%>">
                                                                        </td>
                                                                    </tr>

                                                                    <tr>
                                                                        <td width="40%" bgcolor="#A8DAF3" align="left"
                                                                            class="headngblue">Ownership of HCF of CBMWTF
                                                                        </td>
                                                                        <!-- have to implement select dropdown -->
                                                                        <td width="60%" bgcolor="#E8F6F9" align="left"
                                                                            class="headngblue">

                                                                            <select id = "SelectOwnershipOfHCF" onclick="SelectOwnershipOfHCFClicked()" class="input-xs form-control" name="ownershipOfHCF">
                                                                                <option value="Select">Select</option>
                                                                                <%if(bmwRenew.occOwnershipHcf=="State Goverment"){%>
                                                                                <option value="State Goverment" selected="selected">State Goverment</option>
                                                                                <option value="Private">Private</option>
                                                                                <option value="Any Other">Any Other</option>
                                                                                <%} else if(bmwRenew.occOwnershipHcf == "Private"){%>
                                                                                <option value="State Goverment">State Goverment</option>
                                                                                <option value="Private" selected="selected">Private</option>
                                                                                <option value="Any Other">Any Other</option>
                                                                                <%} else if(bmwRenew.occOwnershipHcf == "Any Othert"){%>
                                                                                <option value="State Goverment">State Goverment</option>
                                                                                <option value="Private">Private</option>
                                                                                <option value="Any Other" selected="selected">Any Other</option>
                                                                                <%}else{%>
                                                                                <option value="State Goverment">State Goverment</option>
                                                                                <option value="Private">Private</option>
                                                                                <option value="Any Other">Any Other</option>
                                                                                <%}%>
                                                                            </select>
                                                                        </td>
                                                                    </tr>

                                                                    <tr>
                                                                        <td rowspan="2" width="40%" bgcolor="#A8DAF3"
                                                                            align="left"
                                                                            class="headngblue">Status of Authorization under the
                                                                        Bio-Medical Waste (Managementand Handing) Rules
                                                                        </td>

                                                                        <td width="60%" bgcolor="#E8F6F9" align="left"
                                                                            class="headngblue">
                                                                            <table>
                                                                                <tr>
                                                                                    <td>
                                                                                        Authorization No. &nbsp;
                                                                                    </td>
                                                                                    <td>
                                                                                        <input type="text"
                                                                                               name="authorizationNo"
                                                                                               class="input-xs form-control"
                                                                                               value="<%=bmwRenew.occAuthorizationNoBmw%>">
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                        </td>
                                                                    </tr>

                                                                    <tr>

                                                                        <td width="60%" bgcolor="#E8F6F9" align="left"
                                                                            class="headngblue">
                                                                            <table>
                                                                                <tr>
                                                                                    <td>
                                                                                        Valid Upto &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                                    </td>
                                                                                    <%if(bmwRenew.occValidUptoBmw){
                                                                                        def df1 = new SimpleDateFormat('yyyy-MM-dd')
                                                                                        def validUptoBmw = df1.format(bmwRenew.occValidUptoBmw)
                                                                                    %>
                                                                                    <td>
                                                                                        <input type="date"
                                                                                               value="<%=validUptoBmw%>"
                                                                                               name="authorizationValidUpto"
                                                                                               class="input-xs form-control"
                                                                                               min='1980-01-01' max='2080-01-01'>
                                                                                    </td>
                                                                                    <%}else{%>
                                                                                    <td>
                                                                                        <input type="date"
                                                                                               name="authorizationValidUpto"
                                                                                               class="input-xs form-control"
                                                                                               min='1980-01-01' max='2080-01-01'>
                                                                                    </td>
                                                                                    <%}%>
                                                                                    <td>
                                                                                        (dd/mm/yyyy)
                                                                                    </td>
                                                                                </tr>
                                                                            </table>
                                                                        </td>
                                                                    </tr>

                                                                    <tr>
                                                                        <td width="40%" bgcolor="#A8DAF3" align="left"
                                                                            class="headngblue">Status of Consents under Water
                                                                        Act and Air Act.
                                                                        </td>
                                                                        <td width="60%" bgcolor="#E8F6F9" align="left"
                                                                            class="headngblue">
                                                                            <table>
                                                                                <tr>
                                                                                    <td>
                                                                                        Valid Upto &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                                    </td>
                                                                                    <td>
                                                                                        <%if(bmwRenew.occValidUptoConsent){
                                                                                        def df2 = new SimpleDateFormat('yyyy-MM-dd')
                                                                                        def validUptoConsent = df2.format(bmwRenew.occValidUptoBmw)
                                                                                        %>
                                                                                        <input type="date"
                                                                                               name="consentValidUpto"
                                                                                               class="input-xs form-control"
                                                                                                value="<%=validUptoConsent%>">
                                                                                        <%}else{%>
                                                                                        <input type="date"
                                                                                               class="input-xs form-control"
                                                                                               name="consentValidUpto">
                                                                                        <%}%>
                                                                                    </td>
                                                                                    <td>
                                                                                        (dd/mm/yyyy)
                                                                                                                                                                                	   </td>
                                                          									 </table>
                                                          									 </div>
                                                          							    </td>
                                                          							</tr>
                                                          					    </table>
                                                          			        </tbody>
                                                          	             </table>
                                                                       </div>
                                                                   </div>


                                                            <!-- ************Country 1 Ends Here*******-->
                                                            <!-- ************Country 2 Starts from Here*******-->
                                                            <div id="country2" class="content">
                                                            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
                                                 	            <tr>
                                                 	                <td bgcolor="#FFFFFF">
                                                 	                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                                      			                   <tr>
                                                                                <td width="68%" align="left"
                                                                                    bgcolor="#A8DAF3"
                                                                                    class="headngblue">HCF/CBMWTF Type <scope
                                                                                        style="color:red">*</scope></td>
                                                                                <td width="32%" align="left"
                                                                                    bgcolor="#E8F6F9">
                                                                                    <g:select name="hcfType"
                                                                                              class="input-xs form-control"
                                                                                              id="hcfType1"
                                                                                              from="${['select', 'HCF', 'CBMWTF']}"
                                                                                              onchange="selectHcfType()"
                                                                                              value="${fieldValue(bean: bmwRenew, field: 'hcfHcfCbmwtfType')}"/>

                                                                                </td>
                                                                            </tr>

                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    align="left"
                                                                                    class="headngblue"><div id="noOfBeds_id" <%if(bmwRenew.hcfHcfCbmwtfType.equals("HCF")){%>
                                                                                    style="display: block"
                                                                                        <%}else{%>
                                                                                        style="display: none"
                                                                                        <%}%>>
                                                                                No. of Beds(for Bedded Hospital) </div>
                                                                                </td>

                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    align="left"
                                                                                    class="headngblue"><div id="noOfBeds_id1" <%if(bmwRenew.hcfHcfCbmwtfType.equals("HCF")){%>
                                                                                    style="display: block"
                                                                                        <%}else{%>
                                                                                        style="display: none"
                                                                                        <%}%>>
                                                                                    <input type="number"
                                                                                           id="noOfBeds"
                                                                                        onclick="noOfBedsClicked()"
                                                                                           class="input-xs form-control"
                                                                                           min="0"
                                                                                           name="noOfBeds"
                                                                                    value="<%=bmwRenew.hcfNoOfBeds%>">
                                                                                </td>
                                                                            </tr>

                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    align="left"
                                                                                    class="headngblue"><div id="non_bedded_id" <%if(bmwRenew.hcfHcfCbmwtfType.equals("HCF")){%>
                                                                                    style="display: block"
                                                                                        <%}else{%>
                                                                                        style="display: none"
                                                                                        <%}%>>
                                                                                Non-Bedded Hospital<br/>(Clinic or Blood Bank or Clinical
                                                                                Laboratory or Research Institute or
                                                                                Veterinary Hospital or any other) </div>
                                                                                </td> 
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    align="left"
                                                                                    class="headngblue"><div id="non_bedded_id1" <%if(bmwRenew.hcfHcfCbmwtfType.equals("HCF")){%>
                                                                                    style="display: block"
                                                                                        <%}else{%>
                                                                                        style="display: none"
                                                                                        <%}%>>
                                                                                    <input type="text" name="nonBedded"
                                                                                           class="input-xs form-control"
                                                                                           value="<%=bmwRenew.hcfNonBedded%>"> </div>
                                                                                </td>
                                                                            </tr>

                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    align="left"
                                                                                    class="headngblue"><div id="licenceNo_id"  <%if(bmwRenew.hcfHcfCbmwtfType.equals("HCF")){%>
                                                                                    style="display: block"
                                                                                        <%}else{%>
                                                                                        style="display: none"
                                                                                        <%}%>>
                                                                                License Number </div> </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    align="left"
                                                                                    class="headngblue"><div id="licenceNo_id1"  <%if(bmwRenew.hcfHcfCbmwtfType.equals("HCF")){%>
                                                                                    style="display: block"
                                                                                        <%}else{%>
                                                                                        style="display: none"
                                                                                        <%}%>>
                                                                                    <input type="number"
                                                                                           id="licenceNo"
                                                                                        onclick="licenceNoClicked()"
                                                                                           class="input-xs form-control"
                                                                                           min="0"
                                                                                           name="licenceNo"
                                                                                           value="<%=bmwRenew.hcfLicenceNo%>"> </div>
                                                                                </td>
                                                                            </tr>

                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    align="left"
                                                                                    class="headngblue"><div id="licenceDateOfExpiry_id" <%if(bmwRenew.hcfHcfCbmwtfType.equals("HCF")){%>
                                                                                    style="display: block"
                                                                                        <%}else{%>
                                                                                        style="display: none"
                                                                                        <%}%>>
                                                                                License Date of Expiry </div> </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    align="left"
                                                                                    class="headngblue">
                                                                                    <div id="licenceDateOfExpiry_id1" <%if(bmwRenew.hcfHcfCbmwtfType.equals("HCF")){%>
                                                                                    style="display: block"
                                                                                        <%}else{%>
                                                                                        style="display: none"
                                                                                        <%}%>  >
                                                                                    <input type="date"
                                                                                           name="licenceDateOfExpiry"
                                                                                           class="input-xs form-control"
                                                                                            value="<%=dateOfExpiry%>">
                                                                                    </div>
                                                                                    <table>
                                                                                    
                                                                                    </table>
                                                                                </td>
                                                                            </tr>

                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    align="left"
                                                                                    class="headngblue"><div id="noHealthcareCBMWTF_id"  <%if(bmwRenew.hcfHcfCbmwtfType.equals("CBMWTF")){%>
                                                                                    style ="display:block"
                                                                                        <%}else{%>
                                                                                        style ="display:none"
                                                                                        <%}%>>
                                                                                    Number healthcare facilities
                                                                                covered by CBMWTF </div>
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    align="left"
                                                                                    class="headngblue"><div id="noHealthcareCBMWTF_id1"  <%if(bmwRenew.hcfHcfCbmwtfType.equals("CBMWTF")){%>
                                                                                    style ="display:block"
                                                                                        <%}else{%>
                                                                                        style ="display:none"
                                                                                        <%}%>>
                                                                                    <input type="number"
                                                                                           id="noHealthcareCBMWTF"
                                                                                           onclick="noHealthcareCBMWTFClicked()"
                                                                                           class="input-xs form-control"
                                                                                           min="0"
                                                                                           name="noHealthcareCBMWTF"
                                                                                           value="<%=bmwRenew.hcfCbmwtfHealthcareFacilitiesNo%>"> </div>
                                                                                </td>
                                                                            </tr>

                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    align="left"
                                                                                    class="headngblue"><div id="noBedsCBMWTF_id" <%if(bmwRenew.hcfHcfCbmwtfType.equals("CBMWTF")){%>
                                                                                    style ="display:block"
                                                                                        <%}else{%>
                                                                                        style ="display:none"
                                                                                        <%}%>>
                                                                                No. of beds covered by CBMWTF </div> </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    align="left"
                                                                                    class="headngblue"><div id="noBedsCBMWTF_id1" <%if(bmwRenew.hcfHcfCbmwtfType.equals("CBMWTF")){%>
                                                                                    style ="display:block"
                                                                                        <%}else{%>
                                                                                        style ="display:none"
                                                                                        <%}%>>
                                                                                    <input type="number"
                                                                                           id="noBedsCBMWTF"
                                                                                           onclick="noBedsCBMWTFClicked()"
                                                                                           class="input-xs form-control"
                                                                                           min="0"
                                                                                           name="noBedsCBMWTF"
                                                                                           value="<%=bmwRenew.hcfCbmwtfbedsNo%>"> </div>
                                                                                </td>
                                                                            </tr>

                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    align="left"
                                                                                    class="headngblue"><div id="installedTreatmentCBMWTF_id" <%if(bmwRenew.hcfHcfCbmwtfType.equals("CBMWTF")){%>
                                                                                    style ="display:block"
                                                                                        <%}else{%>
                                                                                        style ="display:none"
                                                                                        <%}%>>
                                                                                Installed treatment and disposal
                                                                                capacity of CBMWTF </div>
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    align="left"
                                                                                    class="headngblue"><div id="installedTreatmentCBMWTF_id1" <%if(bmwRenew.hcfHcfCbmwtfType.equals("CBMWTF")){%>
                                                                                    style ="display:block"
                                                                                        <%}else{%>
                                                                                        style ="display:none"
                                                                                        <%}%>>
                                                                                    <input type="number"
                                                                                           id="installedTreatmentCBMWTF"
                                                                                           onclick="installedTreatmentCBMWTFClicked()"
                                                                                           class="input-xs form-control"
                                                                                           min="0"
                                                                                           name="installedTreatmentCBMWTF"
                                                                                           value="<%=bmwRenew.hcfCbmwtfInstalledTreatment%>"> </div>
                                                                                </td>
                                                                            </tr>

                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    align="left"
                                                                                    class="headngblue"><div id="quantityBiomedicalCBMWTF"  <%if(bmwRenew.hcfHcfCbmwtfType.equals("CBMWTF")){%>
                                                                                    style ="display:block"
                                                                                        <%}else{%>
                                                                                        style ="display:none"
                                                                                        <%}%>>
                                                                                Quantity of biomedical waste
                                                                                treated or disposal by CBMWTF </div>
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    align="left"
                                                                                    class="headngblue"><div id="quantityBiomedicalCBMWTF1"  <%if(bmwRenew.hcfHcfCbmwtfType.equals("CBMWTF")){%>
                                                                                    style ="display:block"
                                                                                        <%}else{%>
                                                                                        style ="display:none"
                                                                                        <%}%>>
                                                                                    <input type="number"
                                                                                           id="quantityBiomedicalCBMWTFId"
                                                                                           onclick="quantityBiomedicalCBMWTFIdClicked()"
                                                                                           class="input-xs form-control"
                                                                                           min="0"
                                                                                           name="quantityBiomedicalCBMWTF"
                                                                                           value="<%=bmwRenew.hcfCbmwtfQuantityBmw%>"> </div>
                                                                                           </td>
                                                       									 </table>
                                                       									 </div>
                                                       							    </td>
                                                       							</tr>
                                                       					    </table>
                                                       			        </tbody>
                                                       	             </table>
                                                                    </div>
                                                                </div>

                                                                <div id="country3" class="content">
                                                                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
                                                     	            <tr>
                                                     	                <td bgcolor="#FFFFFF">
                                                     	                <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                                          			                   <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Quantity of waste generated or

                                                                                    disposed in Kg per annum (on

                                                                                    monthly average basis)
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9">
                                                                                    <table>
                                                                                        <tr>
                                                                                            <td class="headngblue">
                                                                                                Yellow Category
                                                                                            </td>
                                                                                            <td>
                                                                                                <input type="number"
                                                                                                       id="yellowCategory"
                                                                                                       onclick="yellowCategoryClicked()"
                                                                                                       class="input-xs form-control"
                                                                                                       min="0"
                                                                                                       name="yellowCategory"
                                                                                                       value="<%=bmwRenew.qwgYellowCategory%>">
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td class="headngblue">
                                                                                                Red Category
                                                                                            </td>
                                                                                            <td>
                                                                                                <input type="number"
                                                                                                       id="redCategory"
                                                                                                       onclick="redCategoryClicked()"
                                                                                                       class="input-xs form-control"
                                                                                                       min="0"
                                                                                                       name="redCategory"
                                                                                                       value="<%=bmwRenew.qwgRedCategory%>">
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td class="headngblue">
                                                                                                White
                                                                                            </td>
                                                                                            <td>
                                                                                                <input type="number"
                                                                                                       id="whiteCategory"
                                                                                                       onclick="whiteCategoryClicked()"
                                                                                                       class="input-xs form-control"
                                                                                                       min="0"
                                                                                                       name="whiteCategory"
                                                                                                       value="<%=bmwRenew.qwgWhiteCategory%>">
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td class="headngblue">
                                                                                                Blue Category
                                                                                            </td>
                                                                                            <td>
                                                                                                <input type="number"
                                                                                                       id="blueCategory"
                                                                                                       onclick="blueCategoryClicked()"
                                                                                                       class="input-xs form-control"
                                                                                                       min="0"
                                                                                                       name="blueCategory"
                                                                                                       value="<%=bmwRenew.qwgBlueCategory%>">
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td class="headngblue">
                                                                                                General Solid Waste
                                                                                            </td>
                                                                                            <td>
                                                                                                <input type="number"
                                                                                                       id="generalSolidWaste"
                                                                                                       onclick="generalSolidWasteClicked()"
                                                                                                       class="input-xs form-control"
                                                                                                       min="0"
                                                                                                       name="generalSolidWaste"
                                                                                                       value="<%=bmwRenew.qwgGeneralSolidWaste%>">
                                                                                                       </td>
                                                                  									 </table>
                                                                  									 </div>
                                                                  							    </td>
                                                                  							</tr>
                                                                  					    </table>
                                                                  			        </tbody>
                                                                  	             </table>
                                                                               </div>
                                                                           </div>

                                                                           <div id="country4" class="content">
                                                                           <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
                                                                	            <tr>
                                                                	                <td bgcolor="#FFFFFF">
                                                                		               <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                                                                			                   <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Details of the on-site storage
                                                                                    facility
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">

                                                                                    <table>
                                                                                        <tr>
                                                                                            <td>
                                                                                                Size
                                                                                            </td>
                                                                                            <td>
                                                                                                <input type="number"
                                                                                                       id="onSideStorageSize"
                                                                                                       onclick="onSideStorageSizeClicked()"
                                                                                                       class="input-xs form-control"
                                                                                                       name="onSideStorageSize"
                                                                                                       value="<%=bmwRenew.sttpdOnSiteSize%>">
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td>
                                                                                                Capacity
                                                                                            </td>
                                                                                            <td>
                                                                                                <input type="number"
                                                                                                       id="onSideStorageCapacity"
                                                                                                       onclick="onSideStorageCapacityClicked()"
                                                                                                       class="input-xs form-control"
                                                                                                       name="onSideStorageCapacity"
                                                                                                       value="<%=bmwRenew.sttpdOnSiteCapacity%>">
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td colspan="2">
                                                                                                <table>
                                                                                                    <tr>
                                                                                                        <td>
                                                                                                            Provision of on-site storage
                                                                                                        </td>
                                                                                                        <td>
                                                                                                            <input type="text"
                                                                                                                   class="input-xs form-control"
                                                                                                                   name="onSideProvision"
                                                                                                                   value="<%=bmwRenew.sttpdOnSiteProvision%>">
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td>
                                                                                                            (cold storage or
                                                                                                            any other provision)
                                                                                                        </td>

                                                                                                    </tr>

                                                                                                </table>
                                                                                            </td>
                                                                                        </tr>
                                                                                    </table>

                                                                                </td>
                                                                            </tr>

                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Disposal Facilities
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <table width="100%">
                                                                                        <tr>
                                                                                            <td>
                                                                                                <a class="addViewDelete"
                                                                                                   href="#"
                                                                                                   onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popDisposalFacilitiesAdd/<%=bmwRenewId%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
                                                                                                    Add
                                                                                                </a>
                                                                                            </td>
                                                                                            <td>
                                                                                                <a href="#"
                                                                                                   class="addViewDelete"
                                                                                                   onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popDisposalFacilitiesView/<%=bmwRenewId%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
                                                                                                    View
                                                                                                </a>
                                                                                            </td>
                                                                                            <td>
                                                                                                <a href="#"
                                                                                                   class="addViewDelete"
                                                                                                   onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popDisposalFacilitiesDelete/<%=bmwRenewId%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
                                                                                                    Delete
                                                                                                </a>
                                                                                            </td>
                                                                                        </tr>
                                                                                    </table>
                                                                                </td>
                                                                            </tr>

                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Quantity of recyclable wastes sold
                                                                                    to authorized recyclers after
                                                                                    treatment in kg per annum.
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <table>
                                                                                        <tr>
                                                                                            <input type="number"
                                                                                                   id="qtyRecyclableWasteSold"
                                                                                                   onclick="qtyRecyclableWasteSoldClicked()"
                                                                                                   class="input-xs form-control"
                                                                                                   min="0"
                                                                                                   name="qtyRecyclableWasteSold"
                                                                                                   value="<%=bmwRenew.sttpdQuantityRecyclableWaste%>">
                                                                                        </tr>
                                                                                        <tr>
                                                                                            Red Category (like plastic, glass etc.)
                                                                                        </tr>
                                                                                    </table>
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    No of vehicles used for collection
                                                                                    and transportation of biomedical
                                                                                    waste.
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <input type="number"
                                                                                           id="vehicleUsedForBmw"
                                                                                           onclick="vehicleUsedForBmwClicked()"
                                                                                           class="input-xs form-control"
                                                                                           min="0"
                                                                                           name="vehicleUsedForBmw"
                                                                                           value="<%=bmwRenew.sttpdVehiclesUsed%>">
                                                                                </td>

                                                                            </tr>
                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Details of incineration ash and
                                                                                    ETP sludge generated and
                                                                                    disposal during the treatment of
                                                                                    wastes in Kg per annum)
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <table width="100%">
                                                                                        <tr>
                                                                                            <td>
                                                                                                <a href="#"
                                                                                                   class="addViewDelete"
                                                                                                   onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popWasteTreatmentAdd/<%=bmwRenewId%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">

                                                                                                    Add
                                                                                                </a>
                                                                                            </td>
                                                                                            <td>
                                                                                                <a href="#"
                                                                                                   class="addViewDelete"
                                                                                                   onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popWasteTreatmentView/<%=bmwRenewId%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
                                                                                                    View
                                                                                                </a>
                                                                                            </td>
                                                                                            <td>
                                                                                                <a href="#"
                                                                                                   class="addViewDelete"
                                                                                                   onclick="window.open('<%=request.getContextPath()%>/bioMedicalWaste/popWasteTreatmentDelete/<%=bmwRenewId%>', 'ApplicationHistory', 'WIDTH=630,HEIGHT=400,scrollbars=1,resizable=yes');">
                                                                                                    Delete
                                                                                                </a>
                                                                                            </td>
                                                                                        </tr>
                                                                                    </table>
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Name of the Common Bio-
                                                                                    Medical Waste Treatment
                                                                                    Facility Operator through which
                                                                                    wastes are disposed of
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <input type="text"
                                                                                           name="bmwWasteOperator"
                                                                                           class="input-xs form-control"
                                                                                           value="<%=bmwRenew.sttpdCommonBmwOperator%>">
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    List of member HCF not handed
                                                                                    over bio-medical waste.
                                                                                </td>
                                                                                <%
                                                                                    BmwRenewDocs bmwRenewDocsPrev = BmwRenewDocs.findWhere(bmwRenew: bmwRenew, typeOfFile: "List of member HCF not handed over bio-medical waste")
                                                                                    System.out.println("bmwRenewDocsPrev.."+bmwRenewDocsPrev)
                                                                                    if(bmwRenewDocsPrev){
                                                                                %>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <g:link controller="bioMedicalWaste"
                                                                                        action="downloadUploadedDoc"
                                                                                    params="[bmwRenewId: bmwRenewId]">
                                                                                        View
                                                                                    </g:link>
                                                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                                    <g:link controller="bioMedicalWaste"
                                                                                    action="deleteUploadedDoc"
                                                                                    params="[bmwRenewId: bmwRenewId]">
                                                                                        Delete
                                                                                    </g:link>
                                                                                </td>
                                                                                <%}else{%>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <input type="file"
                                                                                           name="fileBmwHcfNotHanded">
                                                                                </td>
                                                                                <%}%>
                                                                             </table>
                                           									 </div>
                                           							    </td>
                                           							</tr>
                                           					    </table>
                                           			        </tbody>
                                           	             </table>
                                                        </div>
                                                    </div>

                                                       <div id="country5" class="content">
                                                       <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
                                            	            <tr>
                                            	                <td bgcolor="#FFFFFF">
                                            		               <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                                            			                   <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Do you have bio-medical waste
                                                                                    management committee? If yes,
                                                                                    attach minutes of the meetings held
                                                                                    during the reporting period.
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <table>
                                                                                        <tr>
                                                                                            <%if(bmwRenew.bmwtcIsHaveCommittee.equals("no")){%>
                                                                                            <td>
                                                                                                <input id="bmwManagementCommitteeNo1"
                                                                                                       type="radio"
                                                                                                       name="bmwManagementCommittee"
                                                                                                       value="no"
                                                                                                       checked="checked"
                                                                                                       onclick="bmwManagementCommitteeRadio1()"/>
                                                                                                <label for="bmwManagementCommitteeNo1">
                                                                                                    No
                                                                                                </label>

                                                                                            </td>
                                                                                            <td>
                                                                                                &nbsp;
                                                                                                &nbsp;
                                                                                                &nbsp;
                                                                                                &nbsp;
                                                                                            </td>
                                                                                            <td>
                                                                                                <input id="bmwManagementCommitteeYes1"
                                                                                                       type="radio"
                                                                                                       name="bmwManagementCommittee"
                                                                                                       value="yes"
                                                                                                       onclick="bmwManagementCommitteeRadio1()"/>
                                                                                                <label for="bmwManagementCommitteeYes1">
                                                                                                    Yes
                                                                                                </label>
                                                                                            </td>
                                                                                            <%}else{%>
                                                                                            <td>
                                                                                                <input id="bmwManagementCommitteeNo2"
                                                                                                       type="radio"
                                                                                                       name="bmwManagementCommittee"
                                                                                                       value="no"
                                                                                                       onclick="bmwManagementCommitteeRadio2()"/>
                                                                                                <label for="bmwManagementCommitteeNo2">
                                                                                                    No
                                                                                                </label>

                                                                                            </td>
                                                                                            <td>
                                                                                                &nbsp;
                                                                                                &nbsp;
                                                                                                &nbsp;
                                                                                                &nbsp;
                                                                                            </td>
                                                                                            <td>
                                                                                                <input id="bmwManagementCommitteeYes2"
                                                                                                       type="radio"
                                                                                                       name="bmwManagementCommittee"
                                                                                                       value="yes"
                                                                                                       checked="checked"
                                                                                                       onclick="bmwManagementCommitteeRadio2()"/>
                                                                                                <label for="bmwManagementCommitteeYes2">
                                                                                                    Yes
                                                                                                </label>
                                                                                            </td>
                                                                                            <%}%>
                                                                                        </tr>

                                                                                        <tr id="bmwManagementCommitteeDetail"
                                                                                            <%if (bmwRenew.bmwtcIsHaveCommittee.equals("yes")) { %>
                                                                                                   style="display: block;"
                                                                                            <%}else if (bmwRenew.bmwtcIsHaveCommittee.equals("no")){%>
                                                                                                    style="display: none;"
                                                                                            <%}%>
                                                                                        >


                                                                                            <td>
                                                                                                <input type="text"
                                                                                                       id="bmwManagementCommitteeDetailId"
                                                                                                       onclick="bmwManagementCommitteeDetailIdClicked()"
                                                                                                       class="input-xs form-control"
                                                                                                       name="bmwManagementCommitteeDetail"
                                                                                                       value="<%=bmwRenew.bmwtcCommitteeDetails%>">
                                                                                            </td>

                                                                                            <td>
                                                                                                <%
                                                                                                     def bmwRenewDocsPrev2 = BmwRenewDocs.findWhere(bmwRenew: bmwRenew, typeOfFile: "bmw management committee")
                                                                                                    if(bmwRenewDocsPrev2){
                                                                                                %>
                                                                                                <span bgcolor="#E8F6F9"
                                                                                                      class="headngblue">
                                                                                                <g:link controller="bmwRenew"
                                                                                                        action="downloadUploadedDocManagementCommittee"
                                                                                                        params="[bmwRenewId: bmwRenewId]">
                                                                                                    View
                                                                                                </g:link>
                                                                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                                                <g:link controller="bmwRenew"
                                                                                                        action="deleteUploadedDocManagementCommittee"
                                                                                                        params="[bmwRenewId: bmwRenewId]">
                                                                                                    Delete
                                                                                                </g:link>
                                                                                                </span>
                                                                                                <%}else{%>
                                                                                                <input type="file"
                                                                                                       name="fileBmwManagementCommittee">
                                                                                                <%}%>
                                                                                                </td>
                                                           									 </table>
                                                           									 </div>
                                                           							    </td>
                                                           							</tr>
                                                           					    </table>
                                                           			        </tbody>
                                                           	             </table>
                                                                        </div>
                                                                    </div>

                                                                  <div id="country6" class="content">
                                                                  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
                                                       	            <tr>
                                                       	                <td bgcolor="#FFFFFF">
                                                       		               <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                                                       			                   <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Number of training conducted
                                                                                    on BMW Management.
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <input type="number"
                                                                                           id="numOfTrainingConductedBmw"
                                                                                           onclick="numOfTrainingConductedBmwClicked()"
                                                                                           class="input-xs form-control"
                                                                                           min="0"
                                                                                           name="numOfTrainingConductedBmw"
                                                                                           value="<%=bmwRenew.tcNoOfTrainingConducted%>">
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Number of personnel trained
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <input type="number"
                                                                                           id="numOfPersonnelTrained"
                                                                                           onclick="numOfPersonnelTrainedClicked()"
                                                                                           class="input-xs form-control"
                                                                                           min="0"
                                                                                           name="numOfPersonnelTrained"
                                                                                           value="<%=bmwRenew.tcNoOfPersonnelTrained%>">
                                                                                </td>

                                                                            </tr>
                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Number of personnel trained at
                                                                                    the time of induction
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <input type="number"
                                                                                           id="numOfPersonnelTrainedInduction"
                                                                                           onclick="numOfPersonnelTrainedInductionClicked()"
                                                                                           class="input-xs form-control"
                                                                                           min="0"
                                                                                           name="numOfPersonnelTrainedInduction"
                                                                                           value="<%=bmwRenew.tcNoOfPersonnelTrainedInduction%>">
                                                                                </td>

                                                                            </tr>
                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Number of personnel not
                                                                                    undergone any training so far.
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <input type="number"
                                                                                           id="numOfPersonnelNotUndergoneTraining"
                                                                                           onclick="numOfPersonnelNotUndergoneTrainingClicked()"
                                                                                           class="input-xs form-control"
                                                                                           min="0"
                                                                                           name="numOfPersonnelNotUndergoneTraining"
                                                                                           value="<%=bmwRenew.tcPersonnelNotUndergoneTraining%>">
                                                                                </td>

                                                                            </tr>
                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Whether standard manual for
                                                                                    training is available ?
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <table>
                                                                                        <tr>
                                                                                            <%if(bmwRenew.tcIsStandardManualAvailable.equals("no")){%>
                                                                                                <td>
                                                                                                    <input id="trainingRadioBmwNo1"
                                                                                                           type="radio"
                                                                                                           name="trainingRadioBmw"
                                                                                                           value="no"
                                                                                                           checked="checked"/>
                                                                                                    <label for="trainingRadioBmwNo1">No</label>
                                                                                                </td>
                                                                                                <td>
                                                                                                    <input id="trainingRadioBmwYes1"
                                                                                                           type="radio"
                                                                                                           name="trainingRadioBmw"
                                                                                                           value="yes"/>
                                                                                                    <label for="trainingRadioBmwYes1">Yes</label>
                                                                                                </td>
                                                                                            <%}else{%>
                                                                                            <td>
                                                                                                <input id="trainingRadioBmwNo2"
                                                                                                       type="radio"
                                                                                                       name="trainingRadioBmw"
                                                                                                       value="no"
                                                                                                       />
                                                                                                <label for="trainingRadioBmwNo2">No</label>
                                                                                            </td>
                                                                                            <td>
                                                                                                <input id="trainingRadioBmwYes2"
                                                                                                       type="radio"
                                                                                                       name="trainingRadioBmw"
                                                                                                       value="yes"
                                                                                                       checked="checked"/>
                                                                                                <label for="trainingRadioBmwYes2">Yes</label>
                                                                                            </td>
                                                                                            <%}%>
                                                                                        </tr>
                                                                                    </table>
                                                                                </td>

                                                                            </tr>
                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Any other information
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <input type="text"
                                                                                           class="input-xs form-control"
                                                                                           name="trainingBmwAnyOtherInfo"
                                                                                    value="<%=bmwRenew.tcAnyOtherInfo%>">
                                                                                    </td>
                                               									 </table>
                                               									 </div>
                                               							    </td>
                                               							</tr>
                                               					    </table>
                                               			        
                                                        </div>

                                                      <div id="country7" class="content">
                                                      <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#A5CAF4" class="tab-txt" style="border-collapse:collapse;">
                                           	            <tr>
                                           	                <td bgcolor="#FFFFFF">
                                           		               <table width="100%"  border="0" align="left" cellpadding="2" cellspacing="1" class="tblbdr">
                                           			                   <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Number of Accidents occurred
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <input type="number"
                                                                                           id="numOfAccidentOccurred"
                                                                                           onclick="numOfAccidentOccurredClicked()"
                                                                                           class="input-xs form-control"
                                                                                           min="0"
                                                                                           name="numOfAccidentOccurred"
                                                                                           value="<%=bmwRenew.aodNoOfAccidentOccured%>">
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Number of the persons affected
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <input type="number"
                                                                                           id="numOfPersonsAffected"
                                                                                           onclick="numOfPersonsAffectedClicked()"
                                                                                           class="input-xs form-control"
                                                                                           min="0"
                                                                                           name="numOfPersonsAffected"
                                                                                           value="<%=bmwRenew.aodNoOfPersonAffected%>">
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Remedial Action taken (Please
                                                                                    attach details if any)
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <input type="text"
                                                                                           id="accidentRemedialAction"
                                                                                           onclick="accidentRemedialActionClicked()"
                                                                                           class="input-xs form-control"
                                                                                           name="accidentRemedialAction"
                                                                                           value="<%=bmwRenew.aodRemedialActionTaken%>">
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Any Fatality occurred, details.
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <input type="text"
                                                                                           name="accidentFatality"
                                                                                           class="input-xs form-control"
                                                                                           value="<%=bmwRenew.aodAnyFatalities%>">
                                                                             
                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Are you meeting the standards of air
                                                                                    Pollution from the incinerator?. How
                                                                                    many times in last year could not met
                                                                                    the standards?
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <input type="text"
                                                                                           id="meetingAirPollutionStandard"
                                                                                           onclick="meetingAirPollutionStandardClicked()"
                                                                                           class="input-xs form-control"
                                                                                           name="meetingAirPollutionStandard"
                                                                                           value="<%=bmwRenew.odMeetingAirStandard%>">
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Details of Continuous online emission
                                                                                    monitoring systems installed
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <input type="text"
                                                                                           id="continuousOnlineEmissionDetail"
                                                                                           onclick="continuousOnlineEmissionDetailClicked()"
                                                                                           class="input-xs form-control"
                                                                                           name="continuousOnlineEmissionDetail"
                                                                                           value="<%=bmwRenew.odContinuousOnlineEmission%>">
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Liquid waste generated and treatment
                                                                                    methods in place. How many times
                                                                                    you have not met the standards in a
                                                                                    year.
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <input type="text"
                                                                                           id="meetingWaterPollutionStandard"
                                                                                           onclick="meetingWaterPollutionStandardClicked()"
                                                                                           class="input-xs form-control"
                                                                                           name="meetingWaterPollutionStandard"
                                                                                           value="<%=bmwRenew.odLiquidWasteGenerated%>">
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    It the disinfection method or
                                                                                    sterilization meeting the log 4
                                                                                    standards? How many times you have
                                                                                    not met the standards in a year?
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <input type="text"
                                                                                           id="meetingDisinfectionStandard"
                                                                                           onclick="meetingDisinfectionStandardClicked()"
                                                                                           class="input-xs form-control"
                                                                                           name="meetingDisinfectionStandard"
                                                                                           value="<%=bmwRenew.odLiquidWasteGenerated%>">
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td width="40%" bgcolor="#A8DAF3"
                                                                                    class="headngblue">
                                                                                    Any other relevant information
                                                                                </td>
                                                                                <td width="60%" bgcolor="#E8F6F9"
                                                                                    class="headngblue">
                                                                                    <table>
                                                                                        <tr>
                                                                                            <td width="60%"
                                                                                                bgcolor="#E8F6F9"
                                                                                                class="headngblue">
                                                                                                <input type="text"
                                                                                                       name="airPollutionDeviceOtherInfo"
                                                                                                       id="airPollutionDeviceOtherInfo"
                                                                                                       onclick="airPollutionDeviceOtherInfoClicked()"
                                                                                                       class="input-xs form-control"
                                                                                                       value="<%=bmwRenew.odAnyOtherReleventInfo%>">
                                                                                                       </td>
                                                                                                       </tr>
                                                                                                       <tr>
                                                                                                           <td>
                                                                                                               (Air Pollution Control Device attached with the
                                                                                                               incinerator)
                                                                                                           </td>
                                                                                                       </tr>
                                                                                                   </table>
                                                                                               </td>
                                                                                           </tr>

                                                                                       </table>
                                                                                   </div>
                                         <!-- ############################ ENDS ########################## -->








                                        <td width="35" align="left" valign="top">&nbsp;</td>
                                        </tr>
                              </table></td>
                            </tr>

                       <table>

                                                            </div>
                              </table>






                                                                            <table width="95%">
                                                                                <tr>
                                                                                    <td align="center" class="txtR">Fields marked * are mandatory</td>
                                                                                </tr>
                                                                                <tr>
                                                                                  <td align="center" class="headngblue">Do you want to save the application as
                                                                                 <input name="appStatus" id="radioCompleted" type="radio" value="Completed" />
                                                                                    Completed
                                                                                 <input name="appStatus" id="radioInprogress" type="radio" value="Inprogress" checked="checked" />
                                                                                    Inprogress



                                                                                    </td>
                                                                            </tr>
                                                                            <tr>
                                                                                    <td width="15%">&nbsp;</td>
                                                                            </tr>
                                                                            </table>
                                                                            <table width="95%">

                                                                                <tr>
                                                                                    <td  align="center">
                                                                                    <input type="submit"
                                                                                        name="saveBmwRenew"
                                                                                        value="Save"
                                                                                        class="actionbutton" />
                                                                                    </td>

                                                                                </tr>
                                                                            </table>
                                                                        </td>
                                                                    </tr>
                                                                </table>

                                    </g:form>

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
</html>


