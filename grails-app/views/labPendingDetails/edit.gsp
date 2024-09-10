

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit LabPendingDetails</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">LabPendingDetails List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New LabPendingDetails</g:link></span>
        </div>
        <div class="body">
            <h1>Edit LabPendingDetails</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${labPendingDetailsInstance}">
            <div class="errors">
                <g:renderErrors bean="${labPendingDetailsInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${labPendingDetailsInstance?.id}" />
                <input type="hidden" name="version" value="${labPendingDetailsInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="applicationStatus">Application Status:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labPendingDetailsInstance,field:'applicationStatus','errors')}">
                                    <input type="text" id="applicationStatus" name="applicationStatus" value="${fieldValue(bean:labPendingDetailsInstance,field:'applicationStatus')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated">Date Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labPendingDetailsInstance,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${labPendingDetailsInstance?.dateCreated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated">Last Updated:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labPendingDetailsInstance,field:'lastUpdated','errors')}">
                                    <g:datePicker name="lastUpdated" value="${labPendingDetailsInstance?.lastUpdated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="pendingWith">Pending With:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labPendingDetailsInstance,field:'pendingWith','errors')}">
                                    <g:select optionKey="id" from="${UserMaster.list()}" name="pendingWith.id" value="${labPendingDetailsInstance?.pendingWith?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="role">Role:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labPendingDetailsInstance,field:'role','errors')}">
                                    <g:select optionKey="id" from="${RoleMaster.list()}" name="role.id" value="${labPendingDetailsInstance?.role?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="sample">Sample:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labPendingDetailsInstance,field:'sample','errors')}">
                                    <g:select optionKey="id" from="${LabEntryForm.list()}" name="sample.id" value="${labPendingDetailsInstance?.sample?.id}" ></g:select>
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
