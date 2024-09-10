

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show CessReturnMaster</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">CessReturnMaster List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New CessReturnMaster</g:link></span>
        </div>
        <div class="body">
            <h1>Show CessReturnMaster</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnMasterInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Application:</td>
                            
                            <td valign="top" class="value"><g:link controller="indApplicationDetails" action="show" id="${cessReturnMasterInstance?.application?.id}">${cessReturnMasterInstance?.application?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Average Water Consumption:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnMasterInstance, field:'averageWaterConsumption')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Created On:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnMasterInstance, field:'createdOn')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">First Reading:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnMasterInstance, field:'firstReading')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Last Reading:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnMasterInstance, field:'lastReading')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Month:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnMasterInstance, field:'month')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Quantity Of Water Consumed:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnMasterInstance, field:'quantityOfWaterConsumed')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Quantity Water Rebate:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnMasterInstance, field:'quantityWaterRebate')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Units Of Water Consumed:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnMasterInstance, field:'unitsOfWaterConsumed')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Updated On:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnMasterInstance, field:'updatedOn')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Year:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessReturnMasterInstance, field:'year')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${cessReturnMasterInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
