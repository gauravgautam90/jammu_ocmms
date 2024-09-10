

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit UserMaster</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">UserMaster List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New UserMaster</g:link></span>
        </div>
        <div class="body">
            <h1>Edit UserMaster</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${userMasterInstance}">
            <div class="errors">
                <g:renderErrors bean="${userMasterInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${userMasterInstance?.id}" />
                <input type="hidden" name="version" value="${userMasterInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="password">Password:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userMasterInstance,field:'password','errors')}">
                                    <input type="password" maxlength="25" id="password" name="password" value="${fieldValue(bean:userMasterInstance,field:'password')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="hintQuestion">Hint Question:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userMasterInstance,field:'hintQuestion','errors')}">
                                    <input type="text" id="hintQuestion" name="hintQuestion" value="${fieldValue(bean:userMasterInstance,field:'hintQuestion')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="hintAnswer">Hint Answer:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userMasterInstance,field:'hintAnswer','errors')}">
                                    <input type="text" id="hintAnswer" name="hintAnswer" value="${fieldValue(bean:userMasterInstance,field:'hintAnswer')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="status">Status:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userMasterInstance,field:'status','errors')}">
                                    <input type="text" id="status" name="status" value="${fieldValue(bean:userMasterInstance,field:'status')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="userprofileId">Userprofile Id:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userMasterInstance,field:'userprofileId','errors')}">
                                    <g:select optionKey="id" from="${UserProfile.list()}" name="userprofileId.id" value="${userMasterInstance?.userprofileId?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdBy">Created By:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userMasterInstance,field:'createdBy','errors')}">
                                    <input type="text" id="createdBy" name="createdBy" value="${fieldValue(bean:userMasterInstance,field:'createdBy')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdOn">Created On:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userMasterInstance,field:'createdOn','errors')}">
                                    <input type="text" id="createdOn" name="createdOn" value="${fieldValue(bean:userMasterInstance,field:'createdOn')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated">Date Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userMasterInstance,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${userMasterInstance?.dateCreated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated">Last Updated:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userMasterInstance,field:'lastUpdated','errors')}">
                                    <g:datePicker name="lastUpdated" value="${userMasterInstance?.lastUpdated}" ></g:datePicker>
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
