

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit GroupDistrictMaster</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">GroupDistrictMaster List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New GroupDistrictMaster</g:link></span>
        </div>
        <div class="body">
            <h1>Edit GroupDistrictMaster</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${groupDistrictMasterInstance}">
            <div class="errors">
                <g:renderErrors bean="${groupDistrictMasterInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${groupDistrictMasterInstance?.id}" />
                <input type="hidden" name="version" value="${groupDistrictMasterInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="district">District:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:groupDistrictMasterInstance,field:'district','errors')}">
                                    <g:select optionKey="id" from="${DistrictMaster.list()}" name="district.id" value="${groupDistrictMasterInstance?.district?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="group">Group:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:groupDistrictMasterInstance,field:'group','errors')}">
                                    <g:select optionKey="id" from="${GroupMaster.list()}" name="group.id" value="${groupDistrictMasterInstance?.group?.id}" ></g:select>
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
