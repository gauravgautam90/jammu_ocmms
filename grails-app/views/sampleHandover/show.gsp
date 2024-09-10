

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show SampleHandover</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">SampleHandover List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New SampleHandover</g:link></span>
        </div>
        <div class="body">
            <h1>Show SampleHandover</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:sampleHandoverInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Description:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:sampleHandoverInstance, field:'description')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Group Master Instance:</td>
                            
                            <td valign="top" class="value"><g:link controller="groupMaster" action="show" id="${sampleHandoverInstance?.groupMasterInstance?.id}">${sampleHandoverInstance?.groupMasterInstance?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Handover Date:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:sampleHandoverInstance, field:'handoverDate')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Ind User:</td>
                            
                            <td valign="top" class="value"><g:link controller="industryRegMaster" action="show" id="${sampleHandoverInstance?.indUser?.id}">${sampleHandoverInstance?.indUser?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Sample Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:sampleHandoverInstance, field:'sampleId')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Sample Type:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:sampleHandoverInstance, field:'sampleType')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Source Of Sample:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:sampleHandoverInstance, field:'sourceOfSample')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${sampleHandoverInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
