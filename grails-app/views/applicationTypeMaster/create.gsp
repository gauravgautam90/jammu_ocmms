

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create ApplicationTypeMaster</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">ApplicationTypeMaster List</g:link></span>
        </div>
        <div class="body">
            <h1>Create ApplicationTypeMaster</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${applicationTypeMasterInstance}">
            <div class="errors">
                <g:renderErrors bean="${applicationTypeMasterInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="consentType">Consent Type:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationTypeMasterInstance,field:'consentType','errors')}">
                                    <input type="text" id="consentType" name="consentType" value="${fieldValue(bean:applicationTypeMasterInstance,field:'consentType')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Description:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:applicationTypeMasterInstance,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:applicationTypeMasterInstance,field:'description')}"/>
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
