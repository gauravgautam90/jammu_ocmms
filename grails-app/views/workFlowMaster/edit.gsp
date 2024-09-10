

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit WorkFlowMaster</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">WorkFlowMaster List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New WorkFlowMaster</g:link></span>
        </div>
        <div class="body">
            <h1>Edit WorkFlowMaster</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${workFlowMasterInstance}">
            <div class="errors">
                <g:renderErrors bean="${workFlowMasterInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${workFlowMasterInstance?.id}" />
                <input type="hidden" name="version" value="${workFlowMasterInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="canForwardTo">Can Forward To:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:workFlowMasterInstance,field:'canForwardTo','errors')}">
                                    <g:select optionKey="id" from="${RoleMaster.list()}" name="canForwardTo.id" value="${workFlowMasterInstance?.canForwardTo?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="group">Group:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:workFlowMasterInstance,field:'group','errors')}">
                                    <g:select optionKey="id" from="${GroupMaster.list()}" name="group.id" value="${workFlowMasterInstance?.group?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="role">Role:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:workFlowMasterInstance,field:'role','errors')}">
                                    <g:select optionKey="id" from="${RoleMaster.list()}" name="role.id" value="${workFlowMasterInstance?.role?.id}" ></g:select>
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
