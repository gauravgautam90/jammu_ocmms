

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create RoleActivityMaster</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">RoleActivityMaster List</g:link></span>
        </div>
        <div class="body">
            <h1>Create RoleActivityMaster</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${roleActivityMasterInstance}">
            <div class="errors">
                <g:renderErrors bean="${roleActivityMasterInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="activityCode">Activity Code:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:roleActivityMasterInstance,field:'activityCode','errors')}">
                                    <input type="text" id="activityCode" name="activityCode" value="${fieldValue(bean:roleActivityMasterInstance,field:'activityCode')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="activityName">Activity Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:roleActivityMasterInstance,field:'activityName','errors')}">
                                    <input type="text" id="activityName" name="activityName" value="${fieldValue(bean:roleActivityMasterInstance,field:'activityName')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Description:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:roleActivityMasterInstance,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:roleActivityMasterInstance,field:'description')}"/>
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
