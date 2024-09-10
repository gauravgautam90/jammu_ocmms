

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show WasteManagementProcessingDetails</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">WasteManagementProcessingDetails List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New WasteManagementProcessingDetails</g:link></span>
        </div>
        <div class="body">
            <h1>Show WasteManagementProcessingDetails</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Application For:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'applicationFor')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Application Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'applicationId')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Approve:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'approve')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Approve Note:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'approveNote')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Clarification:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'clarification')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Clarification Note:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'clarificationNote')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Date Created:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'dateCreated')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">File Note:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'fileNote')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Inspection:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'inspection')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Inspection Close:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'inspectionClose')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Inspection Close Note:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'inspectionCloseNote')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Inspection Note:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'inspectionNote')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Last Updated:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'lastUpdated')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Officer:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'officer')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Officer Fwd:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'officerFwd')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Reject:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'reject')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Reject Note:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'rejectNote')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Role:</td>
                            
                            <td valign="top" class="value"><g:link controller="roleMaster" action="show" id="${wasteManagementProcessingDetailsInstance?.role?.id}">${wasteManagementProcessingDetailsInstance?.role?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Role Fwd:</td>
                            
                            <td valign="top" class="value"><g:link controller="roleMaster" action="show" id="${wasteManagementProcessingDetailsInstance?.roleFwd?.id}">${wasteManagementProcessingDetailsInstance?.roleFwd?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${wasteManagementProcessingDetailsInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
