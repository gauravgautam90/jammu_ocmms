

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit CertificateRecord</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">CertificateRecord List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New CertificateRecord</g:link></span>
        </div>
        <div class="body">
            <h1>Edit CertificateRecord</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${certificateRecordInstance}">
            <div class="errors">
                <g:renderErrors bean="${certificateRecordInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${certificateRecordInstance?.id}" />
                <input type="hidden" name="version" value="${certificateRecordInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="applicationId">Application Id:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:certificateRecordInstance,field:'applicationId','errors')}">
                                    <g:select optionKey="id" from="${IndApplicationDetails.list()}" name="applicationId.id" value="${certificateRecordInstance?.applicationId?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="startDate">Start Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:certificateRecordInstance,field:'startDate','errors')}">
                                    <g:datePicker name="startDate" value="${certificateRecordInstance?.startDate}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="endDate">End Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:certificateRecordInstance,field:'endDate','errors')}">
                                    <g:datePicker name="endDate" value="${certificateRecordInstance?.endDate}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdBy">Created By:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:certificateRecordInstance,field:'createdBy','errors')}">
                                    <input type="text" id="createdBy" name="createdBy" value="${fieldValue(bean:certificateRecordInstance,field:'createdBy')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="updatedBy">Updated By:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:certificateRecordInstance,field:'updatedBy','errors')}">
                                    <input type="text" id="updatedBy" name="updatedBy" value="${fieldValue(bean:certificateRecordInstance,field:'updatedBy')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated">Date Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:certificateRecordInstance,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${certificateRecordInstance?.dateCreated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated">Last Updated:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:certificateRecordInstance,field:'lastUpdated','errors')}">
                                    <g:datePicker name="lastUpdated" value="${certificateRecordInstance?.lastUpdated}" ></g:datePicker>
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
