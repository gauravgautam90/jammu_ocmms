<!DOCTYPE html>


<%
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", -1);
%>

<html class="no-js" lang="en">
<head>
    <link href="css/stylessheet.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'main.css')}"/>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'md5.js')}"></script>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'main.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'anylinkmenu.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'tabcontent.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'stylesheet.css')}"/>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'style.css')}"/>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'menucontents.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'anylinkmenu.js')}"></script>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'tabcontent.js')}"></script>

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir: 'css', file: 'design.css')}"/>
    <script type="text/javascript" src="${createLinkTo(dir: 'js', file: 'tabs.js')}"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style>
    .kc_fab_main_btn{
        /*background-color:#F44336;*/
        background-color:#286090;
        width:30px;
        height:30px;
        border-radius:100%;
        /*background:#F44336;*/
        background:#286090;
        border:none;
        outline:none;
        color:#FFF;
        font-size:12px;
        box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
        transition:.3s;
        -webkit-tap-highlight-color: rgba(0,0,0,0);
        position: fixed;
        bottom: 30px;
        right: 30px;
    }
    .kc_fab_main_btn:focus {
        transform:scale(1.1);
        /*transform:rotate(45deg);
        -ms-transform: rotate(45deg);
        -webkit-transform: rotate(45deg);*/

    }
    </style>
</head>

<body>
<table>
    <tr>
        <td style="text-align: center">
            <g:if test="${flash.message}">
                <div class="message">${flash.message}</div>
            </g:if>
        </td>
    </tr>
</table>

<table class="table table-striped table-bordered table-sm txt4">
    <tr style="background-color: #E8F6F9">
        <td>
            S. No.
        </td>
        %{--<td>
            Industry Id
        </td>--}%
        <td>
            Application Number
        </td>
        <td>
            Industry Name%{--/ Address--}%
        </td>
        <td>
        Regional Office
        </td> 
       <td>
            District
        </td>

        <td>
            Name of Owner
        </td>

        <td>
            Type of Application
        </td>

        <td>
            Date of Receiving Application
        </td>
        <td>
            Date of Grant/Reject
        </td>
        <td>
            Status
        </td>
        <td>
            Category
        </td>
        <td>
            Pending With
        </td>
        

    </tr>

    <% for (int i = 0; i < outer.size(); i++) {

    %>
    <tr>


        <td><%= i+1 %></td>
        <td><%=outer[i][0]%></td> <!-- application id -->
        <td><%=outer[i][1]%></td> <!-- industry name -->
        <td><%=outer[i][10]%></td> <!---Dealing Group--->
        <td><%=outer[i][2]%></td> <!-- district -->
        <td><%=outer[i][3]%></td> <!-- Name of Owner -->
        <td><%=outer[i][4]%></td> <!-- Type of application -->
        <td><%=outer[i][5]%></td> <!-- Date of receiving application -->
        <td><%=outer[i][6]%></td> <!-- Date of grant/reject -->
        <td><%=outer[i][7]%>
        <td><%=outer[i][8]%></td> <!-- Status -->
        <td><%=outer[i][9]%></td>
        



    </tr>
    <% } %>

</table>
%{--<button class="kc_fab_main_btn"><span class="glyphicon glyphicon-print"></span></button>--}%
<%
System.out.println("on popApplicationCountAllModuleCto")
System.out.println("fromDate: " + fromDate)
System.out.println("toDate: " + toDate)
%>
<!--<g:link action="popApplicationCountAllModuleCto" params="[fromDateStr: fromDate, toDateStr: toDate, isPrint: true, type:type,cat:cat,number:number,groupId:groupId]">
    <button class="kc_fab_main_btn"><span class="glyphicon glyphicon-print"></span></button>
</g:link > -->

</body>

</html>