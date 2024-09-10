

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Audit_Report</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Audit_Report List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Audit_Report</g:link></span>
        </div>
        <div class="body">
            <h1>Show Audit_Report</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:audit_ReportInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Ip Adress:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:audit_ReportInstance, field:'ipAdress')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">User Name:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:audit_ReportInstance, field:'userName')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Login:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:audit_ReportInstance, field:'login')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Logout:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:audit_ReportInstance, field:'logout')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Sucess Login:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:audit_ReportInstance, field:'sucessLogin')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${audit_ReportInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
