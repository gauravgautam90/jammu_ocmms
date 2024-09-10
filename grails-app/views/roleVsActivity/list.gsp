

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>RoleVsActivity List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New RoleVsActivity</g:link></span>
        </div>
        <div class="body">
            <h1>RoleVsActivity List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Activity</th>
                   	    
                   	        <th>Role</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${roleVsActivityInstanceList}" status="i" var="roleVsActivityInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${roleVsActivityInstance.id}">${fieldValue(bean:roleVsActivityInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:roleVsActivityInstance, field:'activity')}</td>
                        
                            <td>${fieldValue(bean:roleVsActivityInstance, field:'role')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${roleVsActivityInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
