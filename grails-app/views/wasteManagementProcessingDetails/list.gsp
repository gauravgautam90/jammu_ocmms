

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>WasteManagementProcessingDetails List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New WasteManagementProcessingDetails</g:link></span>
        </div>
        <div class="body">
            <h1>WasteManagementProcessingDetails List</h1>
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
                        
                   	        <g:sortableColumn property="approve" title="Approve" />
                        
                   	        <g:sortableColumn property="approveNote" title="Approve Note" />
                        
                   	        <g:sortableColumn property="clarification" title="Clarification" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${wasteManagementProcessingDetailsInstanceList}" status="i" var="wasteManagementProcessingDetailsInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${wasteManagementProcessingDetailsInstance.id}">${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'applicationFor')}</td>
                        
                            <td>${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'applicationId')}</td>
                        
                            <td>${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'approve')}</td>
                        
                            <td>${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'approveNote')}</td>
                        
                            <td>${fieldValue(bean:wasteManagementProcessingDetailsInstance, field:'clarification')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${wasteManagementProcessingDetailsInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
