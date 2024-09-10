

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Audit_Report</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Audit_Report List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Audit_Report</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${audit_ReportInstance}">
            <div class="errors">
                <g:renderErrors bean="${audit_ReportInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
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
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
