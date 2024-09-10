
<html>

<head>
</head>
<body>


<h3 align="center">Application With This Industry </h3>
<g:if test="${appList}">
                                                   <table width="95%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
                                                      <tr height="20" bgcolor="#A8DAF3">
                                                         <th align="center" class="headngblue" >SI. No.</th>
                                                         <th align="center" class="headngblue" >Application No</th>
                                                         <th align="center" class="headngblue" >Type</th>
                                                         <th align="center" class="headngblue" >Certificate</th>
                                                         <th align="center" class="headngblue" >Date</th>

                                                      </tr>
                                                      <g:each in="${appList}" status="i" var="abc">
                                                         <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                                                            <td align="center" height="25" class="txt4"  >${i+1}</td>
                                                            <td align="center" height="25" class="txt4"  >   ${abc.id} </td>
															<td align="center" height="25" class="txt4"  >${abc.applicationType}</td>
															<td align="center" height="25" class="txt4"  >${abc.certificateFor}</td>
															<td align="center" height="25" class="txt4"  >${abc.applicationDate}</td>
															
														</tr>
                                                      </g:each>
                                                      
                                                   </table>
                                                </g:if>
                                                
                                                <g:if test="${appList.size() == 0}">
                                                        <b style="color:red">Note: No application found for this industry </b>
                                                </g:if>

                                                
                             </body>
                             </html>                   