<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="https://www.w3.org/1999/xhtml">
<%@ page import="java.text.*" %>
<head>

<% response.setContentType("application/vnd.ms-excel");
   response.setHeader("Content-Disposition", "inline;filename=popSectorTypeWiseSummaryExc.xls");
%>

<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>SPCB</title>

<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<g:javascript library="prototype" />
<g:javascript library='scriptaculous'/>

<script language="javascript" type="text/javascript">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.style3 {color: #186DB5}
.style5 {color: #0099FF}
.style6 {color: #33FF66; }
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

.qwe123{
background-image: url('${createLinkTo(dir:'images2/gif',file:'blue_bg.gif')}');
padding-left:23px;
padding-right:20px;
padding-top:5px;
padding-bottom:5px;

}

.qwe123:hover{
background-image: url('${createLinkTo(dir:'images2/gif',file:'gray_bg.gif')}');
}

.blue{
background-image: url('${createLinkTo(dir:'images2/gif',file:'button_gray.gif')}');
padding-left:30px;
padding-right:27px;
padding-top:5px;
padding-bottom:7px;
}
.blue:hover{
background-image: url('${createLinkTo(dir:'images2/gif',file:'button_blue.gif')}');
}
-->
</style>

<script type="text/javascript" src="js/tabcontent.js">
</script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

<% String cont=request.getContextPath();

%>
<!--
<g:javascript library='scriptaculous'/>
<g:javascript>
		window.onload = function()   
           	  {              
			   	  new Ajax.Autocompleter("autocomplete1","autocomplete_choices","<%=cont%>/groupMaster/ajaxAutoComplete",{} );             
			 }
</g:javascript>
-->

<script language="javascript" type="text/javascript">
	function popitup(url)
	 {
			newwindow=window.open(url,'name','height=200px,width=500px');
			if (window.focus)
			 {
				newwindow.focus()
		   	}
		return false;
	}
</script>


<% 
	String cont2=request.getContextPath();
	if( (!(IndUser)session.getAttribute("indUser") ) && (! (UserMaster)session.getAttribute("userMaster") )  )   {
			response.sendRedirect(cont2+"/index.gsp")	;	
	 } %>



</head>
<body >
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px">
		
         <table width="100%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr">
         <tr bgcolor="#E8F6F9">
        	<td width="15%" align="center"  style="color:black;font-size:15px;" class="headngblue">Sector Type-wise List of Industry Profiles <%if(today){%> as on <font color="#800000"><i><%=today%></i></font><%}
        	if(districtOfficeMasterInstance){
        	%><br><font color="#000080">Office : ${districtOfficeMasterInstance}</font>
        	<br><i><font face="Verdana" size="2" color="#800000">(Click on <b>No. of Units</b> to view more details)</font></i>
        	<%
        	}
        	%>
        	</td>
        </tr>
        </table>

<div style="overflow: auto;height: 600px; width: 1000px;">
<table width=100% align="center" border="2" style="border:3px solid green;" cellpadding="0" cellspacing="0" class="mytable">
<tr width="100%" bgcolor="#A8DAF3"  >
           
           	       <th align="center" style="width:5%" class="headngblue" >S.No.</th>
           	       <th align="center" style="width:10%" class="headngblue" >Category</th>
    	           <th align="center" style="width:70%" class="headngblue" >Industry Type</th>
    	           <th align="center" style="width:10%" class="headngblue" >Classification</th>
    	           <th align="center" style="width:5%" class="headngblue" >No. of Units</th>
</tr>
          
           	       <%
           	       def count=0;
           	       def rowCount=0;
           	       def recordCount=0;
           	       
           	       if(districtOfficeMasterInstance)
           	       {
           	           def applicationPendingDetailsRecord=ApplicationPendingDetails.executeQuery("select distinct apd.application.indUser.category.name,apd.application.indUser.industryType.industryType,apd.application.indUser.industryScale,apd.application.indUser.industryType.id from ApplicationPendingDetails apd  where apd.applicationStatus='approved' and  apd.application.indUser.district.id=? order by apd.application.indUser.category.name ,apd.application.indUser.industryScale ,apd.application.indUser.industryType.industryType ",[districtOfficeMasterInstance.id])
                       def industryType=""
                       def industryTypeCaption=""
                       def categoryCaption=""
                       def sNoCaption=""
                       def rowColorString=""
                       for(int kk=0;kk<applicationPendingDetailsRecord.size();kk++)
                       {
                        
	                          def indCount=ApplicationPendingDetails.executeQuery("select count(distinct apd.application.indUser.id ) from ApplicationPendingDetails apd  where apd.applicationStatus='approved' and apd.application.indUser.district.id=? and apd.application.indUser.industryScale=? and apd.application.indUser.category.name=? and apd.application.indUser.industryType.industryType=? ",[districtOfficeMasterInstance.id,applicationPendingDetailsRecord[kk][2],applicationPendingDetailsRecord[kk][0],applicationPendingDetailsRecord[kk][1]])
	                          if(industryType==applicationPendingDetailsRecord[kk][1])
	                          {
	                             industryTypeCaption=""
	                             categoryCaption=""
	                             sNoCaption=""
	                             rowColorString="#DDEEFF"
	                          }
	                          else
	                          {
	                            rowCount++;
	                            industryType=applicationPendingDetailsRecord[kk][1]
	                            industryTypeCaption=applicationPendingDetailsRecord[kk][1]
	                            categoryCaption=applicationPendingDetailsRecord[kk][0]
	                            sNoCaption=""+rowCount
	                            rowColorString="#FFFFFF"
	                          }
	                          
	                       
	                          %>
	                           <tr width="200%" bgcolor="${rowColorString}">
		              	           <td align="center"><%=sNoCaption%></td>
		              	           <td align="left"><%=categoryCaption%></td>
		              	           <td align="left"><%=industryTypeCaption%></td>
		              	           <td align="left"><%=applicationPendingDetailsRecord[kk][2]%></td>
		              	           <td align="center">
		              	                <a href="#" onclick="window.open('<%=request.getContextPath()%>/allReports/industrySectorTypeWise?districtOfficeId=${districtOfficeMasterInstance.id}&category=${applicationPendingDetailsRecord[kk][0]}&industryTypeId=${applicationPendingDetailsRecord[kk][3]}&classification=${applicationPendingDetailsRecord[kk][2]}', 'ApplicationHistory', 'WIDTH=600,HEIGHT=300,scrollbars=1,resizable=yes');">
					                       <font color="blue"><%=indCount[0]%></font>
					                    </a>
		              	           </td>
	              	           </tr>
                              <% 
	                          recordCount+=indCount[0]
                       }
           	       }
           	       if(rowCount==0)
           	       {
            	    	  %> <tr><td colspan="5">No Records...</td></tr> <%   
            	   }
            	   else
            	   {
            	          %> <tr bgcolor="#A8DAF3"><td align="center" colspan="4">Total</td><td align="center"><%=recordCount%></td></tr> <%   
            	   }
           	       %>
           	       
           	       
        
</table>

</div>
		
            <br />
            <br />
          
		  </form>
          </div>
</div>
</body>
<HEAD> 
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>

</html>