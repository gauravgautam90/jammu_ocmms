

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit IndUnitNatureTransaction</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">IndUnitNatureTransaction List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New IndUnitNatureTransaction</g:link></span>
        </div>
        <div class="body">
            <h1>Edit IndUnitNatureTransaction</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${indUnitNatureTransactionInstance}">
            <div class="errors">
                <g:renderErrors bean="${indUnitNatureTransactionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${indUnitNatureTransactionInstance?.id}" />
                <input type="hidden" name="version" value="${indUnitNatureTransactionInstance?.version}" />
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
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
