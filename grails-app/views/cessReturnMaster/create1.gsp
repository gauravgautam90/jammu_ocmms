

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create CessReturnMaster</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">CessReturnMaster List</g:link></span>
        </div>
        <div class="body">
            <h1>Create CessReturnMaster</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${cessReturnMasterInstance}">
            <div class="errors">
                <g:renderErrors bean="${cessReturnMasterInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="application">Application:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnMasterInstance,field:'application','errors')}">
                                    <g:select optionKey="id" from="${IndApplicationDetails.list()}" name="application.id" value="${cessReturnMasterInstance?.application?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="averageWaterConsumption">Average Water Consumption:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnMasterInstance,field:'averageWaterConsumption','errors')}">
                                    <input type="text" id="averageWaterConsumption" name="averageWaterConsumption" value="${fieldValue(bean:cessReturnMasterInstance,field:'averageWaterConsumption')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdOn">Created On:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnMasterInstance,field:'createdOn','errors')}">
                                    <g:datePicker name="createdOn" value="${cessReturnMasterInstance?.createdOn}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="firstReading">First Reading:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnMasterInstance,field:'firstReading','errors')}">
                                    <input type="text" id="firstReading" name="firstReading" value="${fieldValue(bean:cessReturnMasterInstance,field:'firstReading')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastReading">Last Reading:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnMasterInstance,field:'lastReading','errors')}">
                                    <input type="text" id="lastReading" name="lastReading" value="${fieldValue(bean:cessReturnMasterInstance,field:'lastReading')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="month">Month:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnMasterInstance,field:'month','errors')}">
                                    <input type="text" id="month" name="month" value="${fieldValue(bean:cessReturnMasterInstance,field:'month')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="quantityOfWaterConsumed">Quantity Of Water Consumed:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnMasterInstance,field:'quantityOfWaterConsumed','errors')}">
                                    <input type="text" id="quantityOfWaterConsumed" name="quantityOfWaterConsumed" value="${fieldValue(bean:cessReturnMasterInstance,field:'quantityOfWaterConsumed')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="quantityWaterRebate">Quantity Water Rebate:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnMasterInstance,field:'quantityWaterRebate','errors')}">
                                    <input type="text" id="quantityWaterRebate" name="quantityWaterRebate" value="${fieldValue(bean:cessReturnMasterInstance,field:'quantityWaterRebate')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="unitsOfWaterConsumed">Units Of Water Consumed:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnMasterInstance,field:'unitsOfWaterConsumed','errors')}">
                                    <input type="text" id="unitsOfWaterConsumed" name="unitsOfWaterConsumed" value="${fieldValue(bean:cessReturnMasterInstance,field:'unitsOfWaterConsumed')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="updatedOn">Updated On:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnMasterInstance,field:'updatedOn','errors')}">
                                    <g:datePicker name="updatedOn" value="${cessReturnMasterInstance?.updatedOn}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="year">Year:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessReturnMasterInstance,field:'year','errors')}">
                                    <input type="text" id="year" name="year" value="${fieldValue(bean:cessReturnMasterInstance,field:'year')}"/>
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
