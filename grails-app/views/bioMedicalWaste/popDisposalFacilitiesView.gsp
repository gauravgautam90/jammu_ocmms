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
</head>
<body>
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
            <tr align="center" class="small">
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