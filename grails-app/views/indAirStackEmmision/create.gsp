

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create IndAirStackEmmision</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">IndAirStackEmmision List</g:link></span>
        </div>
        <div class="body">
            <h1>Create IndAirStackEmmision</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${indAirStackEmmisionInstance}">
            <div class="errors">
                <g:renderErrors bean="${indAirStackEmmisionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="applicationId">Application Id:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indAirStackEmmisionInstance,field:'applicationId','errors')}">
                                    <input type="text" id="applicationId" name="applicationId" value="${fieldValue(bean:indAirStackEmmisionInstance,field:'applicationId')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fuelCapacity">Fuel Capacity:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indAirStackEmmisionInstance,field:'fuelCapacity','errors')}">
                                    <input type="text" id="fuelCapacity" name="fuelCapacity" value="${fieldValue(bean:indAirStackEmmisionInstance,field:'fuelCapacity')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fuelCapacityUnit">Fuel Capacity Unit:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indAirStackEmmisionInstance,field:'fuelCapacityUnit','errors')}">
                                    <input type="text" id="fuelCapacityUnit" name="fuelCapacityUnit" value="${fieldValue(bean:indAirStackEmmisionInstance,field:'fuelCapacityUnit')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fuelName">Fuel Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indAirStackEmmisionInstance,field:'fuelName','errors')}">
                                    <input type="text" id="fuelName" name="fuelName" value="${fieldValue(bean:indAirStackEmmisionInstance,field:'fuelName')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fuelQty">Fuel Qty:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indAirStackEmmisionInstance,field:'fuelQty','errors')}">
                                    <input type="text" id="fuelQty" name="fuelQty" value="${fieldValue(bean:indAirStackEmmisionInstance,field:'fuelQty')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fuelType">Fuel Type:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indAirStackEmmisionInstance,field:'fuelType','errors')}">
                                    <input type="text" id="fuelType" name="fuelType" value="${fieldValue(bean:indAirStackEmmisionInstance,field:'fuelType')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="height">Height:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indAirStackEmmisionInstance,field:'height','errors')}">
                                    <input type="text" id="height" name="height" value="${fieldValue(bean:indAirStackEmmisionInstance,field:'height')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="qtyUnit">Qty Unit:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indAirStackEmmisionInstance,field:'qtyUnit','errors')}">
                                    <input type="text" id="qtyUnit" name="qtyUnit" value="${fieldValue(bean:indAirStackEmmisionInstance,field:'qtyUnit')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="sourceCapacity">Source Capacity:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indAirStackEmmisionInstance,field:'sourceCapacity','errors')}">
                                    <input type="text" id="sourceCapacity" name="sourceCapacity" value="${fieldValue(bean:indAirStackEmmisionInstance,field:'sourceCapacity')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="srcCapacityUnit">Src Capacity Unit:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indAirStackEmmisionInstance,field:'srcCapacityUnit','errors')}">
                                    <input type="text" id="srcCapacityUnit" name="srcCapacityUnit" value="${fieldValue(bean:indAirStackEmmisionInstance,field:'srcCapacityUnit')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="stackAttachedToPlant">Stack Attached To Plant:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indAirStackEmmisionInstance,field:'stackAttachedToPlant','errors')}">
                                    <input type="text" id="stackAttachedToPlant" name="stackAttachedToPlant" value="${fieldValue(bean:indAirStackEmmisionInstance,field:'stackAttachedToPlant')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="stackMoniter">Stack Moniter:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indAirStackEmmisionInstance,field:'stackMoniter','errors')}">
                                    <input type="text" id="stackMoniter" name="stackMoniter" value="${fieldValue(bean:indAirStackEmmisionInstance,field:'stackMoniter')}"/>
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
