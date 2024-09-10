

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show IndAirStackEmmision</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">IndAirStackEmmision List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New IndAirStackEmmision</g:link></span>
        </div>
        <div class="body">
            <h1>Show IndAirStackEmmision</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indAirStackEmmisionInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Application Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indAirStackEmmisionInstance, field:'applicationId')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Fuel Capacity:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indAirStackEmmisionInstance, field:'fuelCapacity')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Fuel Capacity Unit:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indAirStackEmmisionInstance, field:'fuelCapacityUnit')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Fuel Name:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indAirStackEmmisionInstance, field:'fuelName')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Fuel Qty:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indAirStackEmmisionInstance, field:'fuelQty')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Fuel Type:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indAirStackEmmisionInstance, field:'fuelType')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Height:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indAirStackEmmisionInstance, field:'height')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Qty Unit:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indAirStackEmmisionInstance, field:'qtyUnit')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Source Capacity:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indAirStackEmmisionInstance, field:'sourceCapacity')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Src Capacity Unit:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indAirStackEmmisionInstance, field:'srcCapacityUnit')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Stack Attached To Plant:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indAirStackEmmisionInstance, field:'stackAttachedToPlant')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Stack Moniter:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indAirStackEmmisionInstance, field:'stackMoniter')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${indAirStackEmmisionInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
