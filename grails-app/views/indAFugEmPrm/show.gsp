

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show IndAFugEmPrm</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">IndAFugEmPrm List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New IndAFugEmPrm</g:link></span>
        </div>
        <div class="body">
            <h1>Show IndAFugEmPrm</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indAFugEmPrmInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Ind Air Stk Id:</td>
                            
                            <td valign="top" class="value"><g:link controller="indAirStackEmmision" action="show" id="${indAFugEmPrmInstance?.indAirStkId?.id}">${indAFugEmPrmInstance?.indAirStkId?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Parameter:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indAFugEmPrmInstance, field:'parameter')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Standard:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:indAFugEmPrmInstance, field:'standard')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${indAFugEmPrmInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
