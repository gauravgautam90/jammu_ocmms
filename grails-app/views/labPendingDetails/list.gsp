

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>LabPendingDetails List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New LabPendingDetails</g:link></span>
        </div>
        <div class="body">
            <h1>LabPendingDetails List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="applicationStatus" title="Application Status" />
                        
                   	        <g:sortableColumn property="dateCreated" title="Date Created" />
                        
                   	        <g:sortableColumn property="lastUpdated" title="Last Updated" />
                        
                   	        <th>Pending With</th>
                   	    
                   	        <th>Role</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${labPendingDetailsInstanceList}" status="i" var="labPendingDetailsInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${labPendingDetailsInstance.id}">${fieldValue(bean:labPendingDetailsInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:labPendingDetailsInstance, field:'applicationStatus')}</td>
                        
                            <td>${fieldValue(bean:labPendingDetailsInstance, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:labPendingDetailsInstance, field:'lastUpdated')}</td>
                        
                            <td>${fieldValue(bean:labPendingDetailsInstance, field:'pendingWith')}</td>
                        
                            <td>${fieldValue(bean:labPendingDetailsInstance, field:'role')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${labPendingDetailsInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
