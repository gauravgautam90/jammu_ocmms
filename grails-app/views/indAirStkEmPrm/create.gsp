

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create IndAirStkEmPrm</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">IndAirStkEmPrm List</g:link></span>
        </div>
        <div class="body">
            <h1>Create IndAirStkEmPrm</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${indAirStkEmPrmInstance}">
            <div class="errors">
                <g:renderErrors bean="${indAirStkEmPrmInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="indAirStkId">Ind Air Stk Id:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indAirStkEmPrmInstance,field:'indAirStkId','errors')}">
                                    <g:select optionKey="id" from="${IndAirStackEmmision.list()}" name="indAirStkId.id" value="${indAirStkEmPrmInstance?.indAirStkId?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="parameter">Parameter:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indAirStkEmPrmInstance,field:'parameter','errors')}">
                                    <input type="text" id="parameter" name="parameter" value="${fieldValue(bean:indAirStkEmPrmInstance,field:'parameter')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="standard">Standard:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indAirStkEmPrmInstance,field:'standard','errors')}">
                                    <input type="text" id="standard" name="standard" value="${fieldValue(bean:indAirStkEmPrmInstance,field:'standard')}"/>
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
