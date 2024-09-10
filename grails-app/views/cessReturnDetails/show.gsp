

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show CessReturnDetails</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">CessReturnDetails List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New CessReturnDetails</g:link></span>
        </div>
        <div class="body">
            <h1>Show CessReturnDetails</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnDetailsInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Cess Return:</td>
                            
                            <td valign="top" class="value"><g:link controller="cessReturn" action="show" id="${cessReturnDetailsInstance?.cessReturn?.id}">${cessReturnDetailsInstance?.cessReturn?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Created By:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnDetailsInstance, field:'createdBy')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Date Created:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnDetailsInstance, field:'dateCreated')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">End Reading:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnDetailsInstance, field:'endReading')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Last Updated:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnDetailsInstance, field:'lastUpdated')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Meter Working:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnDetailsInstance, field:'meterWorking')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Qty For Water Rebate:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnDetailsInstance, field:'qtyForWaterRebate')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Quantity:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnDetailsInstance, field:'quantity')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Remarks:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnDetailsInstance, field:'remarks')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Start Reading:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnDetailsInstance, field:'startReading')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Three Month Water Qty Avg:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnDetailsInstance, field:'threeMonthWaterQtyAvg')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Updated By:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnDetailsInstance, field:'updatedBy')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Water Consumption Purpose Master:</td>
                            
                            <td valign="top" class="value"><g:link controller="cessWaterConsumptionPurposeMaster" action="show" id="${cessReturnDetailsInstance?.waterConsumptionPurposeMaster?.id}">${cessReturnDetailsInstance?.waterConsumptionPurposeMaster?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Water Source Consumption Master:</td>
                            
                            <td valign="top" class="value"><g:link controller="cessSourceConsumptionMaster" action="show" id="${cessReturnDetailsInstance?.waterSourceConsumptionMaster?.id}">${cessReturnDetailsInstance?.waterSourceConsumptionMaster?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${cessReturnDetailsInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
