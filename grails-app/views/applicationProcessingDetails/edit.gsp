

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit ApplicationProcessingDetails</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">ApplicationProcessingDetails List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New ApplicationProcessingDetails</g:link></span>
        </div>
        <div class="body">
            <h1>Edit ApplicationProcessingDetails</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${applicationProcessingDetailsInstance}">
            <div class="errors">
                <g:renderErrors bean="${applicationProcessingDetailsInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${applicationProcessingDetailsInstance?.id}" />
                <input type="hidden" name="version" value="${applicationProcessingDetailsInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="approve">Approve:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationProcessingDetailsInstance,field:'approve','errors')}">
                                    <g:checkBox name="approve" value="${applicationProcessingDetailsInstance?.approve}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="approveNote">Approve Note:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationProcessingDetailsInstance,field:'approveNote','errors')}">
                                    <input type="text" id="approveNote" name="approveNote" value="${fieldValue(bean:applicationProcessingDetailsInstance,field:'approveNote')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="clarification">Clarification:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationProcessingDetailsInstance,field:'clarification','errors')}">
                                    <g:checkBox name="clarification" value="${applicationProcessingDetailsInstance?.clarification}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="clarificationNote">Clarification Note:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationProcessingDetailsInstance,field:'clarificationNote','errors')}">
                                    <input type="text" id="clarificationNote" name="clarificationNote" value="${fieldValue(bean:applicationProcessingDetailsInstance,field:'clarificationNote')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated">Date Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationProcessingDetailsInstance,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${applicationProcessingDetailsInstance?.dateCreated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fileNote">File Note:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationProcessingDetailsInstance,field:'fileNote','errors')}">
                                    <input type="text" id="fileNote" name="fileNote" value="${fieldValue(bean:applicationProcessingDetailsInstance,field:'fileNote')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="inspection">Inspection:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationProcessingDetailsInstance,field:'inspection','errors')}">
                                    <g:checkBox name="inspection" value="${applicationProcessingDetailsInstance?.inspection}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="inspectionNote">Inspection Note:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationProcessingDetailsInstance,field:'inspectionNote','errors')}">
                                    <input type="text" id="inspectionNote" name="inspectionNote" value="${fieldValue(bean:applicationProcessingDetailsInstance,field:'inspectionNote')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="officer">Officer:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationProcessingDetailsInstance,field:'officer','errors')}">
                                    <input type="text" id="officer" name="officer" value="${fieldValue(bean:applicationProcessingDetailsInstance,field:'officer')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="reject">Reject:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationProcessingDetailsInstance,field:'reject','errors')}">
                                    <g:checkBox name="reject" value="${applicationProcessingDetailsInstance?.reject}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="rejectNote">Reject Note:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationProcessingDetailsInstance,field:'rejectNote','errors')}">
                                    <input type="text" id="rejectNote" name="rejectNote" value="${fieldValue(bean:applicationProcessingDetailsInstance,field:'rejectNote')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="role">Role:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationProcessingDetailsInstance,field:'role','errors')}">
                                    <g:select optionKey="id" from="${RoleMaster.list()}" name="role.id" value="${applicationProcessingDetailsInstance?.role?.id}" ></g:select>
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
