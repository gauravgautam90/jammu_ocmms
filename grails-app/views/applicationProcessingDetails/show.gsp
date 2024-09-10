

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show ApplicationProcessingDetails</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">ApplicationProcessingDetails List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New ApplicationProcessingDetails</g:link></span>
        </div>
        <div class="body">
            <h1>Show ApplicationProcessingDetails</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:applicationProcessingDetailsInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Approve:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:applicationProcessingDetailsInstance, field:'approve')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Approve Note:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:applicationProcessingDetailsInstance, field:'approveNote')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Clarification:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:applicationProcessingDetailsInstance, field:'clarification')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Clarification Note:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:applicationProcessingDetailsInstance, field:'clarificationNote')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Date Created:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:applicationProcessingDetailsInstance, field:'dateCreated')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">File Note:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:applicationProcessingDetailsInstance, field:'fileNote')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Inspection:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:applicationProcessingDetailsInstance, field:'inspection')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Inspection Note:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:applicationProcessingDetailsInstance, field:'inspectionNote')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Officer:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:applicationProcessingDetailsInstance, field:'officer')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Reject:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:applicationProcessingDetailsInstance, field:'reject')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Reject Note:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:applicationProcessingDetailsInstance, field:'rejectNote')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Role:</td>
                            
                            <td valign="top" class="value"><g:link controller="roleMaster" action="show" id="${applicationProcessingDetailsInstance?.role?.id}">${applicationProcessingDetailsInstance?.role?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${applicationProcessingDetailsInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
