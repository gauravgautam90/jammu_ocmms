

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create LabProcessingDetails</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">LabProcessingDetails List</g:link></span>
        </div>
        <div class="body">
            <h1>Create LabProcessingDetails</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${labProcessingDetailsInstance}">
            <div class="errors">
                <g:renderErrors bean="${labProcessingDetailsInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="application">Application:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labProcessingDetailsInstance,field:'application','errors')}">
                                    <g:select optionKey="id" from="${LabEntryForm.list()}" name="application.id" value="${labProcessingDetailsInstance?.application?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated">Date Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labProcessingDetailsInstance,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${labProcessingDetailsInstance?.dateCreated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fileNote">File Note:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labProcessingDetailsInstance,field:'fileNote','errors')}">
                                    <input type="text" id="fileNote" name="fileNote" value="${fieldValue(bean:labProcessingDetailsInstance,field:'fileNote')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="finish">Finish:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labProcessingDetailsInstance,field:'finish','errors')}">
                                    <g:checkBox name="finish" value="${labProcessingDetailsInstance?.finish}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="finishNote">Finish Note:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labProcessingDetailsInstance,field:'finishNote','errors')}">
                                    <input type="text" id="finishNote" name="finishNote" value="${fieldValue(bean:labProcessingDetailsInstance,field:'finishNote')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="generateReport">Generate Report:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labProcessingDetailsInstance,field:'generateReport','errors')}">
                                    <g:checkBox name="generateReport" value="${labProcessingDetailsInstance?.generateReport}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="generateReportNote">Generate Report Note:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labProcessingDetailsInstance,field:'generateReportNote','errors')}">
                                    <input type="text" id="generateReportNote" name="generateReportNote" value="${fieldValue(bean:labProcessingDetailsInstance,field:'generateReportNote')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated">Last Updated:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labProcessingDetailsInstance,field:'lastUpdated','errors')}">
                                    <g:datePicker name="lastUpdated" value="${labProcessingDetailsInstance?.lastUpdated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="officer">Officer:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labProcessingDetailsInstance,field:'officer','errors')}">
                                    <input type="text" id="officer" name="officer" value="${fieldValue(bean:labProcessingDetailsInstance,field:'officer')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="officerFwd">Officer Fwd:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labProcessingDetailsInstance,field:'officerFwd','errors')}">
                                    <input type="text" id="officerFwd" name="officerFwd" value="${fieldValue(bean:labProcessingDetailsInstance,field:'officerFwd')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="role">Role:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labProcessingDetailsInstance,field:'role','errors')}">
                                    <g:select optionKey="id" from="${RoleMaster.list()}" name="role.id" value="${labProcessingDetailsInstance?.role?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="roleFwd">Role Fwd:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labProcessingDetailsInstance,field:'roleFwd','errors')}">
                                    <g:select optionKey="id" from="${RoleMaster.list()}" name="roleFwd.id" value="${labProcessingDetailsInstance?.roleFwd?.id}" ></g:select>
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
