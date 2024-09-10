

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit ApplicationPendingDetails</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">ApplicationPendingDetails List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New ApplicationPendingDetails</g:link></span>
        </div>
        <div class="body">
            <h1>Edit ApplicationPendingDetails</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${applicationPendingDetailsInstance}">
            <div class="errors">
                <g:renderErrors bean="${applicationPendingDetailsInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${applicationPendingDetailsInstance?.id}" />
                <input type="hidden" name="version" value="${applicationPendingDetailsInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="application">Application:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationPendingDetailsInstance,field:'application','errors')}">
                                    <g:select optionKey="id" from="${IndApplicationDetails.list()}" name="application.id" value="${applicationPendingDetailsInstance?.application?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="applicationStatus">Application Status:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationPendingDetailsInstance,field:'applicationStatus','errors')}">
                                    <input type="text" id="applicationStatus" name="applicationStatus" value="${fieldValue(bean:applicationPendingDetailsInstance,field:'applicationStatus')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="pendingWith">Pending With:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationPendingDetailsInstance,field:'pendingWith','errors')}">
                                    <g:select optionKey="id" from="${UserMaster.list()}" name="pendingWith.id" value="${applicationPendingDetailsInstance?.pendingWith?.id}" ></g:select>
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
