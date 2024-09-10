

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>RoleProfileAssignment List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New RoleProfileAssignment</g:link></span>
        </div>
        <div class="body">
            <h1>RoleProfileAssignment List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Link Employee</th>
                   	    
                   	        <th>Primary Employee</th>
                   	    
                   	        <th>Role</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${roleProfileAssignmentInstanceList}" status="i" var="roleProfileAssignmentInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${roleProfileAssignmentInstance.id}">${fieldValue(bean:roleProfileAssignmentInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:roleProfileAssignmentInstance, field:'linkEmployee')}</td>
                        
                            <td>${fieldValue(bean:roleProfileAssignmentInstance, field:'primaryEmployee')}</td>
                        
                            <td>${fieldValue(bean:roleProfileAssignmentInstance, field:'role')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${roleProfileAssignmentInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
