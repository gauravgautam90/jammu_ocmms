

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit RoleVsActivity</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">RoleVsActivity List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New RoleVsActivity</g:link></span>
        </div>
        <div class="body">
            <h1>Edit RoleVsActivity</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${roleVsActivityInstance}">
            <div class="errors">
                <g:renderErrors bean="${roleVsActivityInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${roleVsActivityInstance?.id}" />
                <input type="hidden" name="version" value="${roleVsActivityInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="activity">Activity:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:roleVsActivityInstance,field:'activity','errors')}">
                                    <g:select optionKey="id" from="${RoleActivityMaster.list()}" name="activity.id" value="${roleVsActivityInstance?.activity?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="role">Role:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:roleVsActivityInstance,field:'role','errors')}">
                                    <g:select optionKey="id" from="${RoleMaster.list()}" name="role.id" value="${roleVsActivityInstance?.role?.id}" ></g:select>
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
