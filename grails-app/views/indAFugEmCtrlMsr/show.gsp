

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show IndAFugEmCtrlMsr</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">IndAFugEmCtrlMsr List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New IndAFugEmCtrlMsr</g:link></span>
        </div>
        <div class="body">
            <h1>Show IndAFugEmCtrlMsr</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indAFugEmCtrlMsrInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">AS tack Ctrl Msr:</td>
                            
                            <td valign="top" class="value"><g:link controller="airStackCtrlMsr" action="show" id="${indAFugEmCtrlMsrInstance?.aStackCtrlMsr?.id}">${indAFugEmCtrlMsrInstance?.aStackCtrlMsr?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Ind Air Stk Id:</td>
                            
                            <td valign="top" class="value"><g:link controller="indAirStackEmmision" action="show" id="${indAFugEmCtrlMsrInstance?.indAirStkId?.id}">${indAFugEmCtrlMsrInstance?.indAirStkId?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${indAFugEmCtrlMsrInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
