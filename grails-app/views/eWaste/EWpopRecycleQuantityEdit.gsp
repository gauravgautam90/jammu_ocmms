
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

<g:form method="post" action="editEWasteRecycleQuantityDetails" >
    <table align="center">

        <tr align="center">

            <td width="100%" align="center">

                <div >





                    <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                        <tr>
                            <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                            <td width="420" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Recycling Quantity Details</a></td>
                            <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
                            <td width="432">&nbsp;</td>
                        </tr>
                    </table>
                    <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
                    <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >


                        <tr><td><table class="tblbdr" width="100%">

                            <tr bgcolor="#A8DAF3" align="center">
                                <td width="20%" class="headngblue" ><div  class="style3">Name</div></td>
                                <td width="20%" class="headngblue" ><div  class="style3">Quantity</div></td>
                                <td width="20%" align="center" class="headngblue">Unit</td>


                                <td width="25%" class="headngblue" ><div  class="style3">Delete</div></td>
                            </tr>
                            <g:each in="${recycleQuantityDetailList}" status="i" var="recycleQuantityDetailListInst">
                                <tr align="center" align="center">

                                    <td bgcolor="#E8F6F9"><span class="txt style6">${recycleQuantityDetailListInst.eWasteName} </span></td>
                                    <td bgcolor="#E8F6F9"><span class="txt style6">${recycleQuantityDetailListInst.quantity} </span></td>
                                    <td bgcolor="#E8F6F9"><span class="txt style6">${recycleQuantityDetailListInst.unit.unitName} </span></td>


                                    <td bgcolor="#E8F6F9"><span class="txt style6"><input type="checkbox" name="delete" value="<%=recycleQuantityDetailListInst.id%>"/>
                                    </span></td>



                                </tr>
                            </g:each>




                        </table></td></tr>



                    </table>

                </div></div></td></tr>

        <tr>

            <td align="center"><input type="hidden" name="appId" value="<%=appDetId%>"/><input type="submit" name="Delete" value="Delete" class="actionbutton"></td>

        </tr>



    </table>
    <div align="left" class="txt" style="color: navy">
      </br></br>
      &nbsp;<b>* Instructions:</b>
      &nbsp;<ul>
      <li>Please select the checkbox to delete the recycling quantity details and click "Delete" button</li>
      <li>Select multiple check box and click "Delete" button to delete multiple records</li>
      <li>To edit the recycling quantity details, delete the recycling quantity details and then add new one</li>
      </ul>


    </div>
            </div>
            </div>
            </td>
        </tr>

        <tr>



        </tr>



    </table>
    <!-- - -->

</g:form>
</body>