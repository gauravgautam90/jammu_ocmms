

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit IndTypeMaster</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">IndTypeMaster List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New IndTypeMaster</g:link></span>
        </div>
        <div class="body">
            <h1>Edit IndTypeMaster</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${indTypeMasterInstance}">
            <div class="errors">
                <g:renderErrors bean="${indTypeMasterInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${indTypeMasterInstance?.id}" />
                <input type="hidden" name="version" value="${indTypeMasterInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Description:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indTypeMasterInstance,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:indTypeMasterInstance,field:'description')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="max">Max:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indTypeMasterInstance,field:'max','errors')}">
                                    <input type="text" id="max" name="max" value="${fieldValue(bean:indTypeMasterInstance,field:'max')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="min">Min:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indTypeMasterInstance,field:'min','errors')}">
                                    <input type="text" id="min" name="min" value="${fieldValue(bean:indTypeMasterInstance,field:'min')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name">Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indTypeMasterInstance,field:'name','errors')}">
                                    <input type="text" id="name" name="name" value="${fieldValue(bean:indTypeMasterInstance,field:'name')}"/>
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
