

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show IndApplicationDetails</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">IndApplicationDetails List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New IndApplicationDetails</g:link></span>
        </div>
        <div class="body">
            <h1>Show IndApplicationDetails</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indApplicationDetailsInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Application Date:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indApplicationDetailsInstance, field:'applicationDate')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Application For:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indApplicationDetailsInstance, field:'applicationFor')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Application Name:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indApplicationDetailsInstance, field:'applicationName')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Application Type:</td>
                            
                            <td valign="top" class="value"><g:link controller="indTypeMaster" action="show" id="${indApplicationDetailsInstance?.applicationType?.id}">${indApplicationDetailsInstance?.applicationType?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Category:</td>
                            
                            <td valign="top" class="value"><g:link controller="indCatMaster" action="show" id="${indApplicationDetailsInstance?.category?.id}">${indApplicationDetailsInstance?.category?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Certificate For:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indApplicationDetailsInstance, field:'certificateFor')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Completion Status:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indApplicationDetailsInstance, field:'completionStatus')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Ind User:</td>
                            
                            <td valign="top" class="value"><g:link controller="industryRegMaster" action="show" id="${indApplicationDetailsInstance?.indUser?.id}">${indApplicationDetailsInstance?.indUser?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${indApplicationDetailsInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
