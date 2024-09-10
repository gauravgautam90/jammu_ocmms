

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit WasteManagementProcessingDetails</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">WasteManagementProcessingDetails List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New WasteManagementProcessingDetails</g:link></span>
        </div>
        <div class="body">
            <h1>Edit WasteManagementProcessingDetails</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${wasteManagementProcessingDetailsInstance}">
            <div class="errors">
                <g:renderErrors bean="${wasteManagementProcessingDetailsInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${wasteManagementProcessingDetailsInstance?.id}" />
                <input type="hidden" name="version" value="${wasteManagementProcessingDetailsInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="applicationFor">Application For:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementProcessingDetailsInstance,field:'applicationFor','errors')}">
                                    <input type="text" id="applicationFor" name="applicationFor" value="${fieldValue(bean:wasteManagementProcessingDetailsInstance,field:'applicationFor')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="applicationId">Application Id:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementProcessingDetailsInstance,field:'applicationId','errors')}">
                                    <input type="text" id="applicationId" name="applicationId" value="${fieldValue(bean:wasteManagementProcessingDetailsInstance,field:'applicationId')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="approve">Approve:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementProcessingDetailsInstance,field:'approve','errors')}">
                                    <g:checkBox name="approve" value="${wasteManagementProcessingDetailsInstance?.approve}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="approveNote">Approve Note:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementProcessingDetailsInstance,field:'approveNote','errors')}">
                                    <input type="text" id="approveNote" name="approveNote" value="${fieldValue(bean:wasteManagementProcessingDetailsInstance,field:'approveNote')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="clarification">Clarification:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementProcessingDetailsInstance,field:'clarification','errors')}">
                                    <g:checkBox name="clarification" value="${wasteManagementProcessingDetailsInstance?.clarification}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="clarificationNote">Clarification Note:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementProcessingDetailsInstance,field:'clarificationNote','errors')}">
                                    <input type="text" id="clarificationNote" name="clarificationNote" value="${fieldValue(bean:wasteManagementProcessingDetailsInstance,field:'clarificationNote')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated">Date Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementProcessingDetailsInstance,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${wasteManagementProcessingDetailsInstance?.dateCreated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fileNote">File Note:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementProcessingDetailsInstance,field:'fileNote','errors')}">
                                    <input type="text" id="fileNote" name="fileNote" value="${fieldValue(bean:wasteManagementProcessingDetailsInstance,field:'fileNote')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="inspection">Inspection:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementProcessingDetailsInstance,field:'inspection','errors')}">
                                    <g:checkBox name="inspection" value="${wasteManagementProcessingDetailsInstance?.inspection}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="inspectionClose">Inspection Close:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementProcessingDetailsInstance,field:'inspectionClose','errors')}">
                                    <g:checkBox name="inspectionClose" value="${wasteManagementProcessingDetailsInstance?.inspectionClose}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="inspectionCloseNote">Inspection Close Note:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementProcessingDetailsInstance,field:'inspectionCloseNote','errors')}">
                                    <input type="text" id="inspectionCloseNote" name="inspectionCloseNote" value="${fieldValue(bean:wasteManagementProcessingDetailsInstance,field:'inspectionCloseNote')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="inspectionNote">Inspection Note:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementProcessingDetailsInstance,field:'inspectionNote','errors')}">
                                    <input type="text" id="inspectionNote" name="inspectionNote" value="${fieldValue(bean:wasteManagementProcessingDetailsInstance,field:'inspectionNote')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated">Last Updated:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementProcessingDetailsInstance,field:'lastUpdated','errors')}">
                                    <g:datePicker name="lastUpdated" value="${wasteManagementProcessingDetailsInstance?.lastUpdated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="officer">Officer:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementProcessingDetailsInstance,field:'officer','errors')}">
                                    <input type="text" id="officer" name="officer" value="${fieldValue(bean:wasteManagementProcessingDetailsInstance,field:'officer')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="officerFwd">Officer Fwd:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementProcessingDetailsInstance,field:'officerFwd','errors')}">
                                    <input type="text" id="officerFwd" name="officerFwd" value="${fieldValue(bean:wasteManagementProcessingDetailsInstance,field:'officerFwd')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="reject">Reject:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementProcessingDetailsInstance,field:'reject','errors')}">
                                    <g:checkBox name="reject" value="${wasteManagementProcessingDetailsInstance?.reject}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="rejectNote">Reject Note:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementProcessingDetailsInstance,field:'rejectNote','errors')}">
                                    <input type="text" id="rejectNote" name="rejectNote" value="${fieldValue(bean:wasteManagementProcessingDetailsInstance,field:'rejectNote')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="role">Role:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementProcessingDetailsInstance,field:'role','errors')}">
                                    <g:select optionKey="id" from="${RoleMaster.list()}" name="role.id" value="${wasteManagementProcessingDetailsInstance?.role?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="roleFwd">Role Fwd:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:wasteManagementProcessingDetailsInstance,field:'roleFwd','errors')}">
                                    <g:select optionKey="id" from="${RoleMaster.list()}" name="roleFwd.id" value="${wasteManagementProcessingDetailsInstance?.roleFwd?.id}" ></g:select>
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
