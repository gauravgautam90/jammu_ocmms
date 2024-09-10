

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit CessReturnDetails</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">CessReturnDetails List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New CessReturnDetails</g:link></span>
        </div>
        <div class="body">
            <h1>Edit CessReturnDetails</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${cessReturnDetailsInstance}">
            <div class="errors">
                <g:renderErrors bean="${cessReturnDetailsInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${cessReturnDetailsInstance?.id}" />
                <input type="hidden" name="version" value="${cessReturnDetailsInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="cessReturn">Cess Return:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnDetailsInstance,field:'cessReturn','errors')}">
                                    <g:select optionKey="id" from="${CessReturn.list()}" name="cessReturn.id" value="${cessReturnDetailsInstance?.cessReturn?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdBy">Created By:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnDetailsInstance,field:'createdBy','errors')}">
                                    <input type="text" id="createdBy" name="createdBy" value="${fieldValue(bean:cessReturnDetailsInstance,field:'createdBy')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated">Date Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnDetailsInstance,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${cessReturnDetailsInstance?.dateCreated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="endReading">End Reading:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnDetailsInstance,field:'endReading','errors')}">
                                    <input type="text" id="endReading" name="endReading" value="${fieldValue(bean:cessReturnDetailsInstance,field:'endReading')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated">Last Updated:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnDetailsInstance,field:'lastUpdated','errors')}">
                                    <g:datePicker name="lastUpdated" value="${cessReturnDetailsInstance?.lastUpdated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="meterWorking">Meter Working:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnDetailsInstance,field:'meterWorking','errors')}">
                                    <input type="text" id="meterWorking" name="meterWorking" value="${fieldValue(bean:cessReturnDetailsInstance,field:'meterWorking')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="qtyForWaterRebate">Qty For Water Rebate:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnDetailsInstance,field:'qtyForWaterRebate','errors')}">
                                    <input type="text" id="qtyForWaterRebate" name="qtyForWaterRebate" value="${fieldValue(bean:cessReturnDetailsInstance,field:'qtyForWaterRebate')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="quantity">Quantity:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnDetailsInstance,field:'quantity','errors')}">
                                    <input type="text" id="quantity" name="quantity" value="${fieldValue(bean:cessReturnDetailsInstance,field:'quantity')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="remarks">Remarks:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnDetailsInstance,field:'remarks','errors')}">
                                    <input type="text" id="remarks" name="remarks" value="${fieldValue(bean:cessReturnDetailsInstance,field:'remarks')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="startReading">Start Reading:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnDetailsInstance,field:'startReading','errors')}">
                                    <input type="text" id="startReading" name="startReading" value="${fieldValue(bean:cessReturnDetailsInstance,field:'startReading')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="threeMonthWaterQtyAvg">Three Month Water Qty Avg:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnDetailsInstance,field:'threeMonthWaterQtyAvg','errors')}">
                                    <input type="text" id="threeMonthWaterQtyAvg" name="threeMonthWaterQtyAvg" value="${fieldValue(bean:cessReturnDetailsInstance,field:'threeMonthWaterQtyAvg')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="updatedBy">Updated By:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnDetailsInstance,field:'updatedBy','errors')}">
                                    <input type="text" id="updatedBy" name="updatedBy" value="${fieldValue(bean:cessReturnDetailsInstance,field:'updatedBy')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="waterConsumptionPurposeMaster">Water Consumption Purpose Master:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnDetailsInstance,field:'waterConsumptionPurposeMaster','errors')}">
                                    <g:select optionKey="id" from="${CessWaterConsumptionPurposeMaster.list()}" name="waterConsumptionPurposeMaster.id" value="${cessReturnDetailsInstance?.waterConsumptionPurposeMaster?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="waterSourceConsumptionMaster">Water Source Consumption Master:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnDetailsInstance,field:'waterSourceConsumptionMaster','errors')}">
                                    <g:select optionKey="id" from="${CessSourceConsumptionMaster.list()}" name="waterSourceConsumptionMaster.id" value="${cessReturnDetailsInstance?.waterSourceConsumptionMaster?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
