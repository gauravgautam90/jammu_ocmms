

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show RoleProfileAssignment</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">RoleProfileAssignment List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New RoleProfileAssignment</g:link></span>
        </div>
        <div class="body">
            <h1>Show RoleProfileAssignment</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:roleProfileAssignmentInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Link Employee:</td>
                            
                            <td valign="top" class="value"><g:link controller="userProfile" action="show" id="${roleProfileAssignmentInstance?.linkEmployee?.id}">${roleProfileAssignmentInstance?.linkEmployee?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Primary Employee:</td>
                            
                            <td valign="top" class="value"><g:link controller="userProfile" action="show" id="${roleProfileAssignmentInstance?.primaryEmployee?.id}">${roleProfileAssignmentInstance?.primaryEmployee?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Role:</td>
                            
                            <td valign="top" class="value"><g:link controller="roleMaster" action="show" id="${roleProfileAssignmentInstance?.role?.id}">${roleProfileAssignmentInstance?.role?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${roleProfileAssignmentInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
