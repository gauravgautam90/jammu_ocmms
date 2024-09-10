

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show UserMaster</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">UserMaster List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New UserMaster</g:link></span>
        </div>
        <div class="body">
            <h1>Show UserMaster</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:userMasterInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Password:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:userMasterInstance, field:'password')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Hint Question:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:userMasterInstance, field:'hintQuestion')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Hint Answer:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:userMasterInstance, field:'hintAnswer')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Status:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:userMasterInstance, field:'status')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Userprofile Id:</td>
                            
                            <td valign="top" class="value"><g:link controller="userProfile" action="show" id="${userMasterInstance?.userprofileId?.id}">${userMasterInstance?.userprofileId?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Created By:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:userMasterInstance, field:'createdBy')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Created On:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:userMasterInstance, field:'createdOn')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Date Created:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:userMasterInstance, field:'dateCreated')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Last Updated:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:userMasterInstance, field:'lastUpdated')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${userMasterInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
