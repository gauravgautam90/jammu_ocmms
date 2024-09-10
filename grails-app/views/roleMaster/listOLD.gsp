

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>RoleMaster List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New RoleMaster</g:link></span>
        </div>
        <div class="body">
            <h1>RoleMaster List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="createdBy" title="Created By" />
                        
                   	        <g:sortableColumn property="dateCreated" title="Date Created" />
                        
                   	        <th>Group</th>
                   	    
                   	        <g:sortableColumn property="lastUpdated" title="Last Updated" />
                        
                   	        <g:sortableColumn property="roleDesc" title="Role Desc" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${roleMasterInstanceList}" status="i" var="roleMasterInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${roleMasterInstance.id}">${fieldValue(bean:roleMasterInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:roleMasterInstance, field:'createdBy')}</td>
                        
                            <td>${fieldValue(bean:roleMasterInstance, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:roleMasterInstance, field:'group')}</td>
                        
                            <td>${fieldValue(bean:roleMasterInstance, field:'lastUpdated')}</td>
                        
                            <td>${fieldValue(bean:roleMasterInstance, field:'roleDesc')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${roleMasterInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
