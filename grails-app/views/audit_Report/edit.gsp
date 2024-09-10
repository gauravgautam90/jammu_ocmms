

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Audit_Report</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Audit_Report List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Audit_Report</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Audit_Report</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${audit_ReportInstance}">
            <div class="errors">
                <g:renderErrors bean="${audit_ReportInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${audit_ReportInstance?.id}" />
                <input type="hidden" name="version" value="${audit_ReportInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="ipAdress">Ip Adress:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:audit_ReportInstance,field:'ipAdress','errors')}">
                                    <input type="text" id="ipAdress" name="ipAdress" value="${fieldValue(bean:audit_ReportInstance,field:'ipAdress')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="userName">User Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:audit_ReportInstance,field:'userName','errors')}">
                                    <input type="text" id="userName" name="userName" value="${fieldValue(bean:audit_ReportInstance,field:'userName')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="login">Login:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:audit_ReportInstance,field:'login','errors')}">
                                    <g:datePicker name="login" value="${audit_ReportInstance?.login}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="logout">Logout:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:audit_ReportInstance,field:'logout','errors')}">
                                    <g:datePicker name="logout" value="${audit_ReportInstance?.logout}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="sucessLogin">Sucess Login:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:audit_ReportInstance,field:'sucessLogin','errors')}">
                                    <input type="text" id="sucessLogin" name="sucessLogin" value="${fieldValue(bean:audit_ReportInstance,field:'sucessLogin')}"/>
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
