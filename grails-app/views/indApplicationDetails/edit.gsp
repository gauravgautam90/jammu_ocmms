

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit IndApplicationDetails</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">IndApplicationDetails List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New IndApplicationDetails</g:link></span>
        </div>
        <div class="body">
            <h1>Edit IndApplicationDetails</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${indApplicationDetailsInstance}">
            <div class="errors">
                <g:renderErrors bean="${indApplicationDetailsInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${indApplicationDetailsInstance?.id}" />
                <input type="hidden" name="version" value="${indApplicationDetailsInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="applicationDate">Application Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indApplicationDetailsInstance,field:'applicationDate','errors')}">
                                    <g:datePicker name="applicationDate" value="${indApplicationDetailsInstance?.applicationDate}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="applicationFor">Application For:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indApplicationDetailsInstance,field:'applicationFor','errors')}">
                                    <input type="text" id="applicationFor" name="applicationFor" value="${fieldValue(bean:indApplicationDetailsInstance,field:'applicationFor')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="applicationName">Application Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indApplicationDetailsInstance,field:'applicationName','errors')}">
                                    <input type="text" id="applicationName" name="applicationName" value="${fieldValue(bean:indApplicationDetailsInstance,field:'applicationName')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="applicationType">Application Type:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indApplicationDetailsInstance,field:'applicationType','errors')}">
                                    <g:select optionKey="id" from="${IndTypeMaster.list()}" name="applicationType.id" value="${indApplicationDetailsInstance?.applicationType?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="category">Category:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indApplicationDetailsInstance,field:'category','errors')}">
                                    <g:select optionKey="id" from="${IndCatMaster.list()}" name="category.id" value="${indApplicationDetailsInstance?.category?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="certificateFor">Certificate For:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indApplicationDetailsInstance,field:'certificateFor','errors')}">
                                    <input type="text" id="certificateFor" name="certificateFor" value="${fieldValue(bean:indApplicationDetailsInstance,field:'certificateFor')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="completionStatus">Completion Status:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indApplicationDetailsInstance,field:'completionStatus','errors')}">
                                    <input type="text" id="completionStatus" name="completionStatus" value="${fieldValue(bean:indApplicationDetailsInstance,field:'completionStatus')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="indUser">Ind User:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indApplicationDetailsInstance,field:'indUser','errors')}">
                                    <g:select optionKey="id" from="${IndustryRegMaster.list()}" name="indUser.id" value="${indApplicationDetailsInstance?.indUser?.id}" ></g:select>
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
