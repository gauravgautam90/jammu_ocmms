<head>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'menucontents.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}" ></script>
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabcontent.js')}" ></script>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'print.css' )}" media="print" />

<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript" src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>
</head>
<body>
		
		<g:form name="myform" action="saveCreateSingle" id="1">
		 <input type="hidden" name="indRegId" value="${indRegInstance?.id}" />
               
	<!-- <form action="save" method="post" name="myform" > -->	
		<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0" id="countrytabs" >
                            <tr>
                              <td width="9"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_left.gif')}" width="11" height="27" /></td>
                              <td width="110" align="center" background="${createLinkTo(dir:'images2/gif',file:'industry_details_middle.gif')}" class="top-lnks"><a href="#" rel="country1">Cess Return</a></td>
                              <td width="11" valign="bottom"><img src="${createLinkTo(dir:'images2/gif',file:'industry_details_right.gif')}" width="11" height="27" /></td>
							  <td width="490" align="right"> <a href="<%=request.getContextPath()%>/cessReturn/viewCessReturnPdf?appliLoc=<%=cessReturnInstance?.id%>"><span class="innerlink">&nbsp;Print&nbsp;</span></a></td>
							</tr>
	    </table>
		
		
		
       <div id="country1" >
		<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr print">
			
			 <% 
               def yr=((cessReturnInstance.cessAppliedFromDate).getYear()+1900).toString()
				def mon=((cessReturnInstance.cessAppliedFromDate).getMonth()+1).toString()
						
			if (mon=="1"){
				mon = "January"
			}else if(mon=="2"){
				mon = "February"
			}else if(mon=="3"){
				mon = "March"
			}else if(mon=="4"){
				mon = "April"
			}else if(mon=="5"){
				mon = "May"
			}else if(mon=="6"){
				mon = "June"
			}else if(mon=="7"){
				mon = "July"
			}else if(mon=="8"){
				mon = "August"
			}else if(mon=="9"){
				mon = "September"
			}else if(mon=="10"){
				mon = "October"
			}else if(mon=="11"){
				mon = "November"
			}else if(mon=="12"){
				mon = "December"
			}
			
			def fromDate=mon+"/"+yr
               
                       
   			def yr1=((cessReturnInstance.cessAppliedToDate).getYear()+1900).toString()
			def mon1=((cessReturnInstance.cessAppliedToDate).getMonth()+1).toString()
							
			if (mon1=="1"){
				mon1 = "January"
			}else if(mon1=="2"){
				mon1 = "February"
			}else if(mon1=="3"){
				mon1 = "March"
			}else if(mon1=="4"){
				mon1 = "April"
			}else if(mon1=="5"){
				mon1 = "May"
			}else if(mon1=="6"){
				mon1 = "June"
			}else if(mon1=="7"){
				mon1 = "July"
			}else if(mon1=="8"){
				mon1 = "August"
			}else if(mon1=="9"){
				mon1 = "September"
			}else if(mon1=="10"){
				mon1 = "October"
			}else if(mon1=="11"){
				mon1 = "November"
			}else if(mon1=="12"){
				mon1 = "December"
			}
			def toDate=mon1+"/"+yr1
                       
                        %>
				<tr>
                  <td width="25%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Cess Applied From :</td>
				  <td width="25%" align="left" bgcolor="#E8F6F9"  class="headngblue"><%= fromDate%></td>
				    <td  width="25%" align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Cess Applied To :</td>
					<td width="25%"  align="left" bgcolor="#E8F6F9"  class="headngblue">
					<%= toDate%>
					</td>
				 
			  </tr> 
				   
				
				<tr>
					<td   align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Industry Name :</td>
					<td   align="left" bgcolor="#E8F6F9"  class="headngblue">${fieldValue(bean:industryRegId, field:'indName')}
					 
					</td>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Address :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue txt4">${fieldValue(bean:industryRegId, field:'indAddress')}</td>
				</tr> 
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Plot No./Khata * : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">${fieldValue(bean:industryRegId, field:'plotNo')}
					 
                    </td>
                    <td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">City :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${fieldValue(bean:industryRegId, field:'indCity')} 
					  
					</td>
				</tr>        
				    
				
				<tr>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">District :</td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">
					  ${fieldValue(bean:industryRegId, field:'district')}
					</td>
					<td  align="left" valign="middle" bgcolor="#A8DAF3" class="headngblue">Pin : </td>
					<td  align="left" bgcolor="#E8F6F9"  class="headngblue">${fieldValue(bean:industryRegId, field:'indPin')}
					
					</td>
				</tr>        
			
	</table>
	<g:if test="${cessDetailList}"> 
	
	<g:each in="${cessDetailList}" status="i" var="cessDetailInstance">
	<table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr print">
	<tr>
		<td  align="left" valign="middle" bgcolor="#A8DAF3" colspan="2" class="headngblue">Purpose of which Water Consumed   :</td>
					<td  align="left" bgcolor="#E8F6F9" colspan="5" class="headngblue">
					  ${cessDetailInstance?.waterConsumptionPurposeMaster?.purpose }
					</td>
	</tr>
	<tr bgcolor="#A8DAF3" class="headngblue"><td >Source Of Consumption</td><td>Meter Reading</td><td>Start Reading</td><td>End Reading</td><td>Quantity (Kl)</td><td>Water Quantity(3 Month Avg.)</td><td>Quantity of water for rebate</td></tr>
	<tr class="headngblue" bgcolor="#E8F6F9"><td>${cessDetailInstance?.waterSourceConsumptionMaster?.source }</td><td>${fieldValue(bean:cessDetailInstance, field:'meterWorking')}</td><td>${fieldValue(bean:cessDetailInstance, field:'startReading')}</td><td>${fieldValue(bean:cessDetailInstance, field:'endReading')}</td><td>${fieldValue(bean:cessDetailInstance, field:'quantity')}</td><td>${fieldValue(bean:cessDetailInstance, field:'threeMonthWaterQtyAvg')}</td><td>${fieldValue(bean:cessDetailInstance, field:'qtyForWaterRebate')}</td></tr>
	<tr><td colspan="2" class="headngblue">Remarks: </td><td bgcolor="#E8F6F9" colspan="5" class="headngblue">${fieldValue(bean:cessDetailInstance, field:'remarks')}</td></tr>
	</table>
	</g:each>
 </g:if>
  
  
  
  <table width="95%"  border="0" align="center" cellpadding="2" cellspacing="1" class="tblbdr print"  >	
  
  <tr bgcolor="#D1D1D1">
	<td   align="left"  colspan="9" valign="middle" height="10"  class="headngblue tblbdr">&nbsp;</td>
	</tr>            
      <tr>
      <td align="center" class="headngblue" width="25%" height="20"  bgcolor="#A8DAF3" >Unit of water consumption:</td>
      <td align="center" bgcolor="#E8F6F9" class="headngblue" width="25%" height="20" >${fieldValue(bean:cessReturnInstance, field:'totunitOfWaterConsumption')}</td>
      <td align="center" class="headngblue" width="25%" height="20"  bgcolor="#A8DAF3" >Quantity of Water Consumed:</td>
      <td align="center" bgcolor="#E8F6F9" class="headngblue" width="25%" height="20" >${fieldValue(bean:cessReturnInstance, field:'totQuantityOfWaterConsumed')}</td>
      </tr>
      
      <tr>
      <td align="center" class="headngblue" width="25%" height="20"  bgcolor="#A8DAF3" >3 Months Avg. Water Consumption, if meter not working: </td>
      <td align="center" bgcolor="#E8F6F9" class="headngblue" width="25%" height="20" >${fieldValue(bean:cessReturnInstance, field:'threeMonthsAvgWaterConsumption')}</td>
      <td align="center" class="headngblue" width="25%" height="20"  bgcolor="#A8DAF3" >Quantity of Water qualifying for rebate according to the Assesee :</td>
      <td align="center" bgcolor="#E8F6F9" class="headngblue" width="25%" height="20" >${fieldValue(bean:cessReturnInstance, field:'totQuantityOfWaterRebate')}</td>
      </tr>
    </table> 		
						
	   <table width="95%" align="center">
	   		<tr>
	   		<td colspan="3">&nbsp;</td>
	   		</tr>
		 
		</table>
		
	</table>	
  			
            <br />
            <br />
          
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
          
	  
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
 </g:form>


</body>

</html>


