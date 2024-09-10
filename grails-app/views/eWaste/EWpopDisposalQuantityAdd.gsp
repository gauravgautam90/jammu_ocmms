<head>
    <g:javascript library="prototype" />
    <g:javascript>
        function callParentWindowFunction()
        {
            alert('hello')
            window.opener.hello();
        }

        function createRow(){
            try{
                var oAjax=new Ajax.Updater({success: 'AjaxPanel'},'tempWaterModeUseAdd.gsp', { insertion: Insertion.Bottom });
            }catch(e){
                alert('Failed to call Ajax');
            }
        }



    </g:javascript>
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
    <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
    <script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
</head>
<body>
<g:form name="waterSourceModeUses" method="post" action="saveEWasteDisposalQuantityDetails" >
    <%System.out.println("EWpop add."+params)%>
    <table width="100%">
        <tr>
            <td>

                <table width="100%"  border="01" bordercolor="black" align="left" cellpadding="2" cellspacing="0" class="">



                    <tr bgcolor="#D1D1D1">

                        <td colspan="7" align="center" valign="middle"  class="headngblue">Disposal Quantity Details</td>
                    </tr>


                    <input type="hidden" name="appId" value="<%=appDetId%>">

                    <tr bgcolor="#A8DAF3">

                        <td width="10%" align="center" class="headngblue">Name</td>
                        <td width="10%" align="center" class="headngblue">Quantity</td>
                        <td width="10%" align="center" class="headngblue">Units</td>

                    </tr>

                    <tr>

                        <td align="center" class="headngblue">
                            <input name="eWasteName" type="text"  size="20"class="txt4" />              %{--Name--}%
                            <span class="sidetxt"></span></td>

                        <td  align="center" class="headngblue">
                            <input name="quantity" type="text" size="12"class="txt4" />                 %{--Quantity--}%
                            <span class="sidetxt"></span></td>

                        <td align="center" class="headngblue"><span class="style30">
                            <g:select optionKey="id"  class="txt4" from="${UnitMaster.list()}" name="unit"></g:select>          %{--Units--}%
                        </span></td>

                    </tr>

                </td>
                </tr>

                </table>

            </td>
        </tr>
        <tr><td align="center"><input type="submit" name="Add" value="Add" class="actionbutton"></td></tr>
        <tr><td>&nbsp;</td></tr>
        <tr>

            <!-- Div area for errors-->

            <td align="center" valign="top"><div style="width:500px;  vertical-align:middle">
                <span class="error">
                    <g:if test="${flash.message}">
                        <div class="message">${flash.message}</div>
                    </g:if>


                </span></div></td>
        </tr>

        <tr><td>


            <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
            <table width="100%"  border="0" bordercolor="black" align="center" cellpadding="0" cellspacing="0"  >

                <tr>
                    <td><span class="txt" style="color: navy"><b>List of Disposal Quantity added.</b></span>
                        <table width="100%"  border="1" align="center" cellpadding="0" cellspacing="0" class="tblbdr" >

                            <tr bgcolor="#A8DAF3" >

                                <td width="10%" align="center" class="headngblue">Name</td>
                                <td width="10%" align="center" class="headngblue">Quantity</td>
                                <td width="10%" class="headngblue" align="center"><div  class="style3">Unit</div></td>

                            </tr>



                            <g:each in="${disposalQuantityDetailsList}" status="i" var="disposalQuantityDetailsListInst">
                                <tr align="center" >
                                    <td><span class="txt style6">${disposalQuantityDetailsListInst.eWasteName} </span></td>
                                    <td><span class="txt style6">${disposalQuantityDetailsListInst.quantity} </span></td>
                                    <td ><span class="txt style6">${disposalQuantityDetailsListInst.unit.unitName} </span></td>

                                </tr>
                            </g:each>



                        </table></td></tr>



            </table>
        </td>
        </tr>


    </table>


</g:form>
<script language="JavaScript" type="text/javascript">
    var frmvalidator  = new Validator("waterSourceModeUses");
    frmvalidator.EnableFocusOnError(false);
    frmvalidator.EnableMsgsTogether();
    //frmvalidator.addValidation("conventionNo","num","Please enter Basel Convention No. in numeric");
    frmvalidator.addValidation("eWasteName","nature","Please enter EWaste Name");
    frmvalidator.addValidation("quantity","dec","Please enter decimal or numeric value in EWaste Quantity");




</script>



</body>