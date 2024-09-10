<head>
<% String cont=request.getContextPath();%>
<script type="text/javascript">
jQuery.noConflict();
function changeColor12(id){
    jQuery.ajax({
        url: '<g:createLink controller="userMaster" action="ajaxVerticalMenu" />' + '?id=' + id,
        success: function( resp ) {
            // only purpose of this method is to set the session and this can be used when setColor function is called at
            // bottom of this page
        },
        error: function( req, status, err ) {
            console.log( 'something went wrong', status, err );
            // alert("error: " + err);
        }
    });

}
</script>
<script type="text/javascript">


</script>
</head>



<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
            
			 
			  
              <tr>
                <td valign="top"><table width="224" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="6" align="left" valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'left_nav.gif')}" width="6" height="31" /></td>
                    <td width="218" height="31" align="left" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'left_midlle.gif')}" ><table width="218" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="11" align="left" valign="middle"><img src="${createLinkTo(dir:'images2/gif',file:'bullet.gif')}" width="11" height="10" /></td>
                        <td>&nbsp;&nbsp;&nbsp;<g:link controller="eWaste" action="pendingList"><span id="eWasteAppId" onclick="changeColor12(this.id)">E-Waste Applications</span></g:link></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
              
              <tr>
                <td valign="top"><table width="224" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="6" align="left" valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'left_nav.gif')}" width="6" height="31" /></td>
                    <td width="218" height="31" align="left" valign="middle" background="${createLinkTo(dir:'images2/gif',file:'left_midlle.gif')}" ><table width="218" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="11" align="left" valign="middle"><img src="${createLinkTo(dir:'images2/gif',file:'bullet.gif')}" width="11" height="10" /></td>
                        <td>&nbsp;&nbsp;&nbsp;<g:link controller="eWaste" action="searchApp"><span id="eWasteAppSearchId" onclick="changeColor12(this.id)">E-Waste Application Search</span></g:link></td>
                      </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
              
              
		
            <!-- bhanu commented code start; date: 03-07-2017 -->
              %{--<tr>
                <td valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'feedback.gif')}" width="224" height="64" /></td>
              </tr>
              <tr>
                <td height="1" valign="top"></td>
              </tr>
              <tr>
                <td valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'query.gif')}" width="224" height="64" /></td>
              </tr>
              <tr>
                <td valign="top"><img src="${createLinkTo(dir:'images2/gif',file:'grad.gif')}" width="224" height="70" /></td>
              </tr>--}%
            <!-- bhanu commeneted code ends -->
            </table>
</body>
<script>
function setColor12() {
    var obj12 = ${session.verticalMenuId}
        obj12.style.color = "#32CD32";
}
setColor12();
</script>