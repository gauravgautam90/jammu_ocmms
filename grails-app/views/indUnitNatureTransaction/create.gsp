

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create IndUnitNatureTransaction</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">IndUnitNatureTransaction List</g:link></span>
        </div>
        <div class="body">
            <h1>Create IndUnitNatureTransaction</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${indUnitNatureTransactionInstance}">
            <div class="errors">
                <g:renderErrors bean="${indUnitNatureTransactionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="indReg">Ind Reg:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indUnitNatureTransactionInstance,field:'indReg','errors')}">
                                    <g:select optionKey="id" from="${IndustryRegMaster.list()}" name="indReg.id" value="${indUnitNatureTransactionInstance?.indReg?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="unitNature">Unit Nature:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indUnitNatureTransactionInstance,field:'unitNature','errors')}">
                                    <g:select optionKey="id" from="${UnitNatureMaster.list()}" name="unitNature.id" value="${indUnitNatureTransactionInstance?.unitNature?.id}" ></g:select>
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
