

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create CessPendingDetails</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">CessPendingDetails List</g:link></span>
        </div>
        <div class="body">
            <h1>Create CessPendingDetails</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${cessPendingDetailsInstance}">
            <div class="errors">
                <g:renderErrors bean="${cessPendingDetailsInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="applicationStatus">Application Status:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessPendingDetailsInstance,field:'applicationStatus','errors')}">
                                    <input type="text" id="applicationStatus" name="applicationStatus" value="${fieldValue(bean:cessPendingDetailsInstance,field:'applicationStatus')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="cessReturn">Cess Return:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessPendingDetailsInstance,field:'cessReturn','errors')}">
                                    <g:select optionKey="id" from="${CessReturn.list()}" name="cessReturn.id" value="${cessPendingDetailsInstance?.cessReturn?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated">Date Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessPendingDetailsInstance,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${cessPendingDetailsInstance?.dateCreated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="indRegInstance">Ind Reg Instance:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessPendingDetailsInstance,field:'indRegInstance','errors')}">
                                    <g:select optionKey="id" from="${IndustryRegMaster.list()}" name="indRegInstance.id" value="${cessPendingDetailsInstance?.indRegInstance?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated">Last Updated:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessPendingDetailsInstance,field:'lastUpdated','errors')}">
                                    <g:datePicker name="lastUpdated" value="${cessPendingDetailsInstance?.lastUpdated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="month">Month:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessPendingDetailsInstance,field:'month','errors')}">
                                    <input type="text" id="month" name="month" value="${fieldValue(bean:cessPendingDetailsInstance,field:'month')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="pendingWith">Pending With:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessPendingDetailsInstance,field:'pendingWith','errors')}">
                                    <g:select optionKey="id" from="${UserMaster.list()}" name="pendingWith.id" value="${cessPendingDetailsInstance?.pendingWith?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="role">Role:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessPendingDetailsInstance,field:'role','errors')}">
                                    <g:select optionKey="id" from="${RoleMaster.list()}" name="role.id" value="${cessPendingDetailsInstance?.role?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="year">Year:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:cessPendingDetailsInstance,field:'year','errors')}">
                                    <input type="text" id="year" name="year" value="${fieldValue(bean:cessPendingDetailsInstance,field:'year')}"/>
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
