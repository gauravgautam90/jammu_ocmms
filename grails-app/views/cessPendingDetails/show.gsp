

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show CessPendingDetails</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">CessPendingDetails List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New CessPendingDetails</g:link></span>
        </div>
        <div class="body">
            <h1>Show CessPendingDetails</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessPendingDetailsInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Application Status:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessPendingDetailsInstance, field:'applicationStatus')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Cess Return:</td>
                            
                            <td valign="top" class="value"><g:link controller="cessReturn" action="show" id="${cessPendingDetailsInstance?.cessReturn?.id}">${cessPendingDetailsInstance?.cessReturn?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Date Created:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessPendingDetailsInstance, field:'dateCreated')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Ind Reg Instance:</td>
                            
                            <td valign="top" class="value"><g:link controller="industryRegMaster" action="show" id="${cessPendingDetailsInstance?.indRegInstance?.id}">${cessPendingDetailsInstance?.indRegInstance?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Last Updated:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessPendingDetailsInstance, field:'lastUpdated')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Month:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessPendingDetailsInstance, field:'month')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Pending With:</td>
                            
                            <td valign="top" class="value"><g:link controller="userMaster" action="show" id="${cessPendingDetailsInstance?.pendingWith?.id}">${cessPendingDetailsInstance?.pendingWith?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Role:</td>
                            
                            <td valign="top" class="value"><g:link controller="roleMaster" action="show" id="${cessPendingDetailsInstance?.role?.id}">${cessPendingDetailsInstance?.role?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Year:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:cessPendingDetailsInstance, field:'year')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${cessPendingDetailsInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
