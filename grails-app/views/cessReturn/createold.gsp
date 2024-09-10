

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create CessReturn</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">CessReturn List</g:link></span>
        </div>
        <div class="body">
            <h1>Create CessReturn</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${cessReturnInstance}">
            <div class="errors">
                <g:renderErrors bean="${cessReturnInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdBy">Created By:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnInstance,field:'createdBy','errors')}">
                                    <input type="text" id="createdBy" name="createdBy" value="${fieldValue(bean:cessReturnInstance,field:'createdBy')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated">Date Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnInstance,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${cessReturnInstance?.dateCreated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="firstDayReading">First Day Reading:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnInstance,field:'firstDayReading','errors')}">
                                    <input type="text" id="firstDayReading" name="firstDayReading" value="${fieldValue(bean:cessReturnInstance,field:'firstDayReading')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="industryReg">Industry Reg:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnInstance,field:'industryReg','errors')}">
                                    <g:select optionKey="id" from="${IndustryRegMaster.list()}" name="industryReg.id" value="${cessReturnInstance?.industryReg?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastDayReading">Last Day Reading:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnInstance,field:'lastDayReading','errors')}">
                                    <input type="text" id="lastDayReading" name="lastDayReading" value="${fieldValue(bean:cessReturnInstance,field:'lastDayReading')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated">Last Updated:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnInstance,field:'lastUpdated','errors')}">
                                    <g:datePicker name="lastUpdated" value="${cessReturnInstance?.lastUpdated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="month">Month:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnInstance,field:'month','errors')}">
                                    <input type="text" id="month" name="month" value="${fieldValue(bean:cessReturnInstance,field:'month')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="threeMonthsAvgWaterConsumption">Three Months Avg Water Consumption:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnInstance,field:'threeMonthsAvgWaterConsumption','errors')}">
                                    <input type="text" id="threeMonthsAvgWaterConsumption" name="threeMonthsAvgWaterConsumption" value="${fieldValue(bean:cessReturnInstance,field:'threeMonthsAvgWaterConsumption')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="totQuantityOfWaterConsumed">Tot Quantity Of Water Consumed:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnInstance,field:'totQuantityOfWaterConsumed','errors')}">
                                    <input type="text" id="totQuantityOfWaterConsumed" name="totQuantityOfWaterConsumed" value="${fieldValue(bean:cessReturnInstance,field:'totQuantityOfWaterConsumed')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="totQuantityOfWaterRebate">Tot Quantity Of Water Rebate:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnInstance,field:'totQuantityOfWaterRebate','errors')}">
                                    <input type="text" id="totQuantityOfWaterRebate" name="totQuantityOfWaterRebate" value="${fieldValue(bean:cessReturnInstance,field:'totQuantityOfWaterRebate')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="totunitOfWaterConsumption">Totunit Of Water Consumption:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnInstance,field:'totunitOfWaterConsumption','errors')}">
                                    <input type="text" id="totunitOfWaterConsumption" name="totunitOfWaterConsumption" value="${fieldValue(bean:cessReturnInstance,field:'totunitOfWaterConsumption')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="updatedBy">Updated By:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnInstance,field:'updatedBy','errors')}">
                                    <input type="text" id="updatedBy" name="updatedBy" value="${fieldValue(bean:cessReturnInstance,field:'updatedBy')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="year">Year:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnInstance,field:'year','errors')}">
                                    <input type="text" id="year" name="year" value="${fieldValue(bean:cessReturnInstance,field:'year')}"/>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
