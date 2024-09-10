

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show LabProcessingDetails</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">LabProcessingDetails List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New LabProcessingDetails</g:link></span>
        </div>
        <div class="body">
            <h1>Show LabProcessingDetails</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:labProcessingDetailsInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Application:</td>
                            
                            <td valign="top" class="value"><g:link controller="labEntryForm" action="show" id="${labProcessingDetailsInstance?.application?.id}">${labProcessingDetailsInstance?.application?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Date Created:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:labProcessingDetailsInstance, field:'dateCreated')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">File Note:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:labProcessingDetailsInstance, field:'fileNote')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Finish:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:labProcessingDetailsInstance, field:'finish')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Finish Note:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:labProcessingDetailsInstance, field:'finishNote')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Generate Report:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:labProcessingDetailsInstance, field:'generateReport')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Generate Report Note:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:labProcessingDetailsInstance, field:'generateReportNote')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Last Updated:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:labProcessingDetailsInstance, field:'lastUpdated')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Officer:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:labProcessingDetailsInstance, field:'officer')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Officer Fwd:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:labProcessingDetailsInstance, field:'officerFwd')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Role:</td>
                            
                            <td valign="top" class="value"><g:link controller="roleMaster" action="show" id="${labProcessingDetailsInstance?.role?.id}">${labProcessingDetailsInstance?.role?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Role Fwd:</td>
                            
                            <td valign="top" class="value"><g:link controller="roleMaster" action="show" id="${labProcessingDetailsInstance?.roleFwd?.id}">${labProcessingDetailsInstance?.roleFwd?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${labProcessingDetailsInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
