

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit LabEntryForm</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">LabEntryForm List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New LabEntryForm</g:link></span>
        </div>
        <div class="body">
            <h1>Edit LabEntryForm</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${labEntryFormInstance}">
            <div class="errors">
                <g:renderErrors bean="${labEntryFormInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${labEntryFormInstance?.id}" />
                <input type="hidden" name="version" value="${labEntryFormInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdBy">Created By:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labEntryFormInstance,field:'createdBy','errors')}">
                                    <input type="text" id="createdBy" name="createdBy" value="${fieldValue(bean:labEntryFormInstance,field:'createdBy')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated">Date Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labEntryFormInstance,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${labEntryFormInstance?.dateCreated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fullDetails">Full Details:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labEntryFormInstance,field:'fullDetails','errors')}">
                                    <input type="text" id="fullDetails" name="fullDetails" value="${fieldValue(bean:labEntryFormInstance,field:'fullDetails')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="groupMasterInstance">Group Master Instance:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labEntryFormInstance,field:'groupMasterInstance','errors')}">
                                    <g:select optionKey="id" from="${GroupMaster.list()}" name="groupMasterInstance.id" value="${labEntryFormInstance?.groupMasterInstance?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated">Last Updated:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labEntryFormInstance,field:'lastUpdated','errors')}">
                                    <g:datePicker name="lastUpdated" value="${labEntryFormInstance?.lastUpdated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="otherFieldPeople">Other Field People:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labEntryFormInstance,field:'otherFieldPeople','errors')}">
                                    <input type="text" id="otherFieldPeople" name="otherFieldPeople" value="${fieldValue(bean:labEntryFormInstance,field:'otherFieldPeople')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="sampleLocation">Sample Location:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labEntryFormInstance,field:'sampleLocation','errors')}">
                                    <input type="text" id="sampleLocation" name="sampleLocation" value="${fieldValue(bean:labEntryFormInstance,field:'sampleLocation')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="sampleType">Sample Type:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labEntryFormInstance,field:'sampleType','errors')}">
                                    <input type="text" id="sampleType" name="sampleType" value="${fieldValue(bean:labEntryFormInstance,field:'sampleType')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="samplerName">Sampler Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labEntryFormInstance,field:'samplerName','errors')}">
                                    <input type="text" id="samplerName" name="samplerName" value="${fieldValue(bean:labEntryFormInstance,field:'samplerName')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="updatedBy">Updated By:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:labEntryFormInstance,field:'updatedBy','errors')}">
                                    <input type="text" id="updatedBy" name="updatedBy" value="${fieldValue(bean:labEntryFormInstance,field:'updatedBy')}"/>
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
