

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit IndAFugEmCtrlMsr</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">IndAFugEmCtrlMsr List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New IndAFugEmCtrlMsr</g:link></span>
        </div>
        <div class="body">
            <h1>Edit IndAFugEmCtrlMsr</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${indAFugEmCtrlMsrInstance}">
            <div class="errors">
                <g:renderErrors bean="${indAFugEmCtrlMsrInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${indAFugEmCtrlMsrInstance?.id}" />
                <input type="hidden" name="version" value="${indAFugEmCtrlMsrInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="aStackCtrlMsr">AS tack Ctrl Msr:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indAFugEmCtrlMsrInstance,field:'aStackCtrlMsr','errors')}">
                                    <g:select optionKey="id" from="${AirStackCtrlMsr.list()}" name="aStackCtrlMsr.id" value="${indAFugEmCtrlMsrInstance?.aStackCtrlMsr?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="indAirStkId">Ind Air Stk Id:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indAFugEmCtrlMsrInstance,field:'indAirStkId','errors')}">
                                    <g:select optionKey="id" from="${IndAirStackEmmision.list()}" name="indAirStkId.id" value="${indAFugEmCtrlMsrInstance?.indAirStkId?.id}" ></g:select>
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
