

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>WasteManagementPendingDetails List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New WasteManagementPendingDetails</g:link></span>
        </div>
        <div class="body">
            <h1>WasteManagementPendingDetails List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="applicationFor" title="Application For" />
                        
                   	        <g:sortableColumn property="applicationId" title="Application Id" />
                        
                   	        <g:sortableColumn property="applicationStatus" title="Application Status" />
                        
                   	        <g:sortableColumn property="dateCreated" title="Date Created" />
                        
                   	        <g:sortableColumn property="lastUpdated" title="Last Updated" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${wasteManagementPendingDetailsInstanceList}" status="i" var="wasteManagementPendingDetailsInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${wasteManagementPendingDetailsInstance.id}">${fieldValue(bean:wasteManagementPendingDetailsInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:wasteManagementPendingDetailsInstance, field:'applicationFor')}</td>
                        
                            <td>${fieldValue(bean:wasteManagementPendingDetailsInstance, field:'applicationId')}</td>
                        
                            <td>${fieldValue(bean:wasteManagementPendingDetailsInstance, field:'applicationStatus')}</td>
                        
                            <td>${fieldValue(bean:wasteManagementPendingDetailsInstance, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:wasteManagementPendingDetailsInstance, field:'lastUpdated')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${wasteManagementPendingDetailsInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
