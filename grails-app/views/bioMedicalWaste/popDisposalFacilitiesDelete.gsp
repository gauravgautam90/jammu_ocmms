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
    tr#secondRow{
        background-color: #A8DAF3;
    }

    </style>
</head>
<body>
<div class="form">
    <g:form name="disposalFacilities" method="post" action="deleteDisposalFacilities">

    <table class="table table-striped" width="80%">
        <tr style="display: none">
            <td>
                <input type="hidden" name="bmwRenewId" value="<%=bmwRenewId%>" />
            </td>
        </tr>
        <tr  id="secondRow" class="headngblue" style="background-color: #A8DAF3">
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
            <td>

            </td>
        </tr>
        <g:each in="${disposalFacilitiesList}"  status="i" var="df">

            <tr class="small">
                <td bgcolor="#E8F6F9">
                    <label for="<%=df.id%>">
                    ${df.typeOfTreatment}
                    </label>
                </td>
                <td bgcolor="#E8F6F9">
                    <label for="<%=df.id%>">
                    ${df.numberOfUnits}
                    </label>
                </td>
                <td bgcolor="#E8F6F9">
                    <label for="<%=df.id%>">
                    ${df.capacity}
                    </label>
                </td>
                <td bgcolor="#E8F6F9">
                    <label for="<%=df.id%>">
                    ${df.quantity}
                    </label>
                </td>
                <td bgcolor="#E8F6F9">
                    <input id="<%=df.id%>" type="checkbox" name="delete"
                           value="<%=df.id%>"/>
                </td>

            </tr>

        </g:each>



    </table>
        <tr class="headngblue">
            <td colspan="4" style="margin: auto">
                <input id="addButton" type="submit" name="deleteDisposalFacilities" value="Delete" class="actionbutton">
            </td>
        </tr>
    </g:form>
</div>
</body>
</html>