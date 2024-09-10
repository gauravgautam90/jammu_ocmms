

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show GroupDistrictMaster</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">GroupDistrictMaster List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New GroupDistrictMaster</g:link></span>
        </div>
        <div class="body">
            <h1>Show GroupDistrictMaster</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:groupDistrictMasterInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">District:</td>
                            
                            <td valign="top" class="value"><g:link controller="districtMaster" action="show" id="${groupDistrictMasterInstance?.district?.id}">${groupDistrictMasterInstance?.district?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Group:</td>
                            
                            <td valign="top" class="value"><g:link controller="groupMaster" action="show" id="${groupDistrictMasterInstance?.group?.id}">${groupDistrictMasterInstance?.group?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${groupDistrictMasterInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
