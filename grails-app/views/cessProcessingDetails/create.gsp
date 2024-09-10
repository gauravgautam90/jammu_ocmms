

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create CessProcessingDetails</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">CessProcessingDetails List</g:link></span>
        </div>
        <div class="body">
            <h1>Create CessProcessingDetails</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${cessProcessingDetailsInstance}">
            <div class="errors">
                <g:renderErrors bean="${cessProcessingDetailsInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated">Date Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessProcessingDetailsInstance,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${cessProcessingDetailsInstance?.dateCreated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fileNote">File Note:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessProcessingDetailsInstance,field:'fileNote','errors')}">
                                    <input type="text" id="fileNote" name="fileNote" value="${fieldValue(bean:cessProcessingDetailsInstance,field:'fileNote')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated">Last Updated:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessProcessingDetailsInstance,field:'lastUpdated','errors')}">
                                    <g:datePicker name="lastUpdated" value="${cessProcessingDetailsInstance?.lastUpdated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="officer">Officer:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessProcessingDetailsInstance,field:'officer','errors')}">
                                    <input type="text" id="officer" name="officer" value="${fieldValue(bean:cessProcessingDetailsInstance,field:'officer')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="officerFwd">Officer Fwd:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessProcessingDetailsInstance,field:'officerFwd','errors')}">
                                    <input type="text" id="officerFwd" name="officerFwd" value="${fieldValue(bean:cessProcessingDetailsInstance,field:'officerFwd')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="role">Role:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessProcessingDetailsInstance,field:'role','errors')}">
                                    <g:select optionKey="id" from="${RoleMaster.list()}" name="role.id" value="${cessProcessingDetailsInstance?.role?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="roleFwd">Role Fwd:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessProcessingDetailsInstance,field:'roleFwd','errors')}">
                                    <g:select optionKey="id" from="${RoleMaster.list()}" name="roleFwd.id" value="${cessProcessingDetailsInstance?.roleFwd?.id}" ></g:select>
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
