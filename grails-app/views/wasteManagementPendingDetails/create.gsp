

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create WasteManagementPendingDetails</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">WasteManagementPendingDetails List</g:link></span>
        </div>
        <div class="body">
            <h1>Create WasteManagementPendingDetails</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${wasteManagementPendingDetailsInstance}">
            <div class="errors">
                <g:renderErrors bean="${wasteManagementPendingDetailsInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="applicationFor">Application For:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementPendingDetailsInstance,field:'applicationFor','errors')}">
                                    <input type="text" id="applicationFor" name="applicationFor" value="${fieldValue(bean:wasteManagementPendingDetailsInstance,field:'applicationFor')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="applicationId">Application Id:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementPendingDetailsInstance,field:'applicationId','errors')}">
                                    <input type="text" id="applicationId" name="applicationId" value="${fieldValue(bean:wasteManagementPendingDetailsInstance,field:'applicationId')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="applicationStatus">Application Status:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementPendingDetailsInstance,field:'applicationStatus','errors')}">
                                    <input type="text" id="applicationStatus" name="applicationStatus" value="${fieldValue(bean:wasteManagementPendingDetailsInstance,field:'applicationStatus')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated">Date Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementPendingDetailsInstance,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${wasteManagementPendingDetailsInstance?.dateCreated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated">Last Updated:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementPendingDetailsInstance,field:'lastUpdated','errors')}">
                                    <g:datePicker name="lastUpdated" value="${wasteManagementPendingDetailsInstance?.lastUpdated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="pendingWith">Pending With:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementPendingDetailsInstance,field:'pendingWith','errors')}">
                                    <g:select optionKey="id" from="${UserMaster.list()}" name="pendingWith.id" value="${wasteManagementPendingDetailsInstance?.pendingWith?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="role">Role:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementPendingDetailsInstance,field:'role','errors')}">
                                    <g:select optionKey="id" from="${RoleMaster.list()}" name="role.id" value="${wasteManagementPendingDetailsInstance?.role?.id}" ></g:select>
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
