
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%@page import="java.util.ArrayList"%><html >

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

    <title>Untitled Document</title>

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />

    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />





    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>

    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>

    <g:javascript library="prototype" />


</head>
<body>


<table align="center" width="100%">

    <tr align="center">

        <td width="100%" align="center">

            <div>
                <div >
                    <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >
                        <tr bgcolor="#D1D1D1">
                            <td align="center" valign="middle"  class="headngblue">Disposal Quantity Details </td>
                        </tr>
                        <tr><td><table width="100%">

                            <tr bgcolor="#A8DAF3" >
                                <td width="15%" align="center" class="headngblue">Name</td>
                                <td width="15%" align="center" class="headngblue">Quantity</td>
                                <td width="15%" align="center" class="headngblue">Units</td>


                            </tr>
                            <g:each in="${disposalQuantityDetailsList}" status="i" var="disposalQuantityDetailsListInst">
                                <tr align="center" >
                                    <td bgcolor="#E8F6F9"><span class="txt style6">${disposalQuantityDetailsListInst.eWasteName} </span></td>
                                    <td bgcolor="#E8F6F9"><span class="txt style6">${disposalQuantityDetailsListInst.quantity} </span></td>
                                    <td bgcolor="#E8F6F9"><span class="txt style6">${disposalQuantityDetailsListInst.unit.unitName} </span></td>


                                </tr>
                            </g:each>


                        </table>
                        </td></tr>

                    </table>

                </div>
            </div>
        </td>
    </tr>
    <%if(session.getAttribute("userMaster")){

        UserMaster aa = (UserMaster)session.getAttribute("userMaster");

        String userType = aa.accessLevel
        if(userType.equals("admin") || userType.equals("employee")) { %>


    <!--<tr>

    <td align="center" height="1" colspan="2"  bgcolor="#d0d1d0"><input type="button" class="actionbutton" name="back" value="Back" onclick="window.open('<%=request.getContextPath()%>/eEWaste/spcbShowForm?appliId=<%=appDetId%>#country2', 'ApplicationHistory', 'WIDTH=800,HEIGHT=450,scrollbars=1,resizable=yes');"> </td>

  </tr>-->
    <%}}%>


</table>

</body>

</html>