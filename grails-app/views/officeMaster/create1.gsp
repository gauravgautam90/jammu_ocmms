<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html >

<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>Untitled Document</title>

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />

 

 <script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>

<g:javascript library="prototype" />


<g:form action="popsave" name="myform" method ="post">
  <table align="center">
<tr align="center"  align="center">
<td width="100%" align="center">
    <div>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" bordercolor="#990000">
        <tr>
          <td colspan="2"><img  src="${createLinkTo(dir:'images',file:'spacer.gif')}" width="1" height="15" /></td>
        </tr>
        <tr align="center">
          <td colspan="2" ><table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="11"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="147" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Add Office</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="432">&nbsp;</td>
							</tr>
	    </table>
		
		
		
          <div id="country1" >
	
		
			
			
			<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">

						
                       
                      
                      <tr align="center" >
                              <td bgcolor="#A8DAF3" width="150px" align="middle"  class="headngblue">Office Name :</td>
                        <td bgcolor="#E8F6F9" align="left" class="value ${hasErrors(bean:officeMasterInstance,field:'officeName','errors')} txt4">
                                    <input type="text" id="officeName" name="officeName" value="${fieldValue(bean:officeMasterInstance,field:'officeName')}"/>
                                </td>                       
                      </tr>
                            <tr align="center" >
                              <td bgcolor="#A8DAF3" width="150px" align="right" valign="middle" class="headngblue"><div align="right" class="style3">Priority :</div></td>
                        <td bgcolor="#E8F6F9" align="left" class="value ${hasErrors(bean:officeMasterInstance,field:'priority','errors')}">
                       <g:select   from="${priorityList}" name="priority"  ></g:select>
                                </td>
                        </div></td>
                      </tr>

	  </table>
						
						
						
	   <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		  <tr>
			<td align="right"><input type="submit" name="Save" value="Save" class="actionbutton" ></td>
			<td align="left"><input type="reset" name="reset" value="Reset" class="actionbutton"></td>			
		  </tr>
		</table>
		
		
  			</g:form>
            <br />
            <br />

          </div>
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
          </div>
	  
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>
      </div></td>
                            <td width="132" align="left" valign="top">&nbsp;</td>
                          </tr>
                      </table></td>
                    </tr>
                    
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
<script language="JavaScript" type="text/javascript">

 var frmvalidator  = new Validator("myform");
    frmvalidator.EnableFocusOnError(false); 
    frmvalidator.EnableMsgsTogether();  
 
 frmvalidator.addValidation("officeName","req","Please enter office name");
 frmvalidator.addValidation("officeName","alnum_s","Please enter valid office name");
 
 
</script>
</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
