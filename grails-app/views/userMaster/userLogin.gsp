<g:hiddenField name="tunt1" value="${tunt1}" />
	 
<table width="100%" border="0" bordercolor="red" cellspacing="0" cellpadding="0">
							<tr>
							
								<!-- <td width="100%" height="218" valign="top" background="images/bg_upcoming-events.gif" style="background-repeat:no-repeat;">
									<div class="evnt-txt">
										<img src="images/dot.gif" /><a href="#">Noise pollution level high inresidential &nbsp;&nbsp;areas</a><br />
										<img src="images/lin.gif" /><br />
										<img src="images/dot.gif" /><a href="#">State Pollution Control Board &nbsp;&nbsp;&nbsp;notices to government agencies </a><br />
										<img src="images/lin.gif" /><br />
										<img src="images/dot.gif" /><a href="#">Monitor operations of CETPs on a daily &nbsp;&nbsp;&nbsp;basis</a> 
									</div>
								</td> -->
							</tr>
							<tr>
								<td valign="top" bgcolor="#EEEEEE" style="padding-top:8px; padding-bottom:8px;">
									<div>       										
									
										<!--<form id="form1" name="form1" method="post" action="userMaster/doLogin" onSubmit="return validateForm();">-->
										<form id="form1" name="form1" method="post" action="userMaster/doLogin">  
											<div id="t" align="center" >
										
					
											<g:if test="${flash.message}">
												<div class="style1"> 
													<span class="error">${flash.message}</span><br/>
												</div>
											</g:if>
					
											</div>
											
											<div class="radio">	<label> <input id="radioButton" name="radioButton"  type="radio" value="SPCB" checked="checked" /></label> </div>
											<div class="login_heading"> SPCB Login</div>
											<div class="radio"> <label>	<input id="radioButton" name="radioButton" type="radio" value="Industry" /></label></div>
											<div class="login_heading"> Industrial Login </div>
											<div class="clear"></div>
											<div class="login">User ID</div>
											<div> <input type="text" id="userId" name='userId' class="form1" AUTOCOMPLETE=OFF /></div>
											<div class="clear"></div>
											<div class="login">Password</div>
											<div> <input type="password" id="password" name='password' class="form1" AUTOCOMPLETE=OFF  /></div>
											<div class="clear"></div>
											<div><input type ="hidden" name = "browserDetails" id="browserDetails" value=""><div>
											
						                    <div class="capcha" align:"center"> ${capCode1} </div> 
											<div class="login">Enter</div>
											<div ><input type="text" id="captchaCode" name='captchaCode' class="form1" AUTOCOMPLETE=OFF >&nbsp;<a href="#" onclick="loginEncryption();"  class="bulletinside"><b>Login</b></a>
										    
											<div class="label">Enter code shown above</div>									    
																				
										    </form>
										
											<div class="maintext1" align="left"> <g:link controller="industryRegMaster" action="create1">New Industry Registration</g:link> &nbsp;&nbsp;		<g:link controller="indCatMaster" action="forgetPassword">Forget Password</g:link>
											</div>
									</div>
								</td>
							</tr>
							<tr>
								<td valign="top"><a href="#" target="_blank"><img src="images/feedack.gif" width="268" height="70" border="0" /></a></td>
							</tr>
							<tr>
								<td valign="top"><a href="#"><img src="images/query.gif" alt="Query" width="268" height="70" border="0" /></a></td>
							</tr>  
							<tr>
								<td valign="top" background="images/bg2.gif" style="background-repeat:no-repeat;">
									<!--<img src="images/fee_calc.gif" alt="Fee Calculator" width="113" height="22" hspace="12" vspace="8" />-->
									<div class="box2">
										<!-- <div class="maintext"> -->
											<g:form name="myform">
												<table width="275" border="0" cellpadding="2" cellspacing="1" bordercolor="#FFFFFF">
													<!--<tr>
														<td width="40%" >
															<div align="left"><span class="style3 style5">Consent Type:</span></div>
														</td>
														<td width="60%" ><span class="style6">
															 <input id="consentTypeY" name="consentType" type="radio" value="CTE" checked="checked" />CTE
															<input  id="consentTypeN" name="consentType" type="radio" value="CTO" />CTO</span>
														</td>
													</tr>-->
													
												<!--	<tr>
													
													
														<td width="10%" >
															<div align="left"><span class="style3 style5">Category:</span></div>
														</td>
														<td width="90%">
															<span class="style6">
																<input id="indTypR" name="indTyp" type="radio" value="RED" checked="checked"/>Red
																<input id="indTypO" name="indTyp" type="radio" value="ORANGE" />Orange
																<input id="indTypG" name="indTyp" type="radio" value="GREEN" />Green
															</span>
														</td>
													</tr>-->
												<!--	
													<tr>
													<td width="40%" >
															<div align="left"><span class="style3 style5">Number of Year:</span></div>
														</td>
														<td width="60%">
															<span class="style6">
															
																	<input id="noOfYearO" name="noOfYear" type="radio" value="1" checked="checked"/>1
																<input id="noOfYearT" name="noOfYear" type="radio" value="2" />2
																<input id="noOfYearTh" name="noOfYear" type="radio" value="3" />3
													      		
															</span>
														</td>
													</tr>
													-->
													
										
													<!--<tr>
														<td  class="style3" width="10%"><div align="left" class="style5">Capital Investment<span class="txt">(in Lakhs)</span>: </div></td>
														<td width="90%" >
															<input id="capital" name="capital" type="text" class="txt4" size="15">  
														</td>
													</tr>
													<tr>
														<td  width="10%"class="style3"><div align="left" class="style7">Consent Fee: </div></td>
														<td width="90%"class="style3 style7 style5"><input id="result1" size="15" class="txt4" name="result1" type="text" readonly="readonly"><a><img src="images/rupeegray.jpg" alt="Query" border="0" width="17px" /></a></td>
													
													</tr>
													<tr>
														<td colspan="2" align="right" class="style3 style8">
															 <a href="javascript:{}" onclick="return Calculate();"  class="bulletinside"><b>Calculate</b></a>
														</td>
													</tr>-->
												</table>
											</g:form>
					
										<!-- </div> -->
									</div>
								</td>
							</tr>
						</table>