

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>ApplicationProcessingDetails List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New ApplicationProcessingDetails</g:link></span>
        </div>
        <div class="body">
            <h1>ApplicationProcessingDetails List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="approve" title="Approve" />
                        
                   	        <g:sortableColumn property="approveNote" title="Approve Note" />
                        
                   	        <g:sortableColumn property="clarification" title="Clarification" />
                        
                   	        <g:sortableColumn property="clarificationNote" title="Clarification Note" />
                        
                   	        <g:sortableColumn property="dateCreated" title="Date Created" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${applicationProcessingDetailsInstanceList}" status="i" var="applicationProcessingDetailsInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${applicationProcessingDetailsInstance.id}">${fieldValue(bean:applicationProcessingDetailsInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:applicationProcessingDetailsInstance, field:'approve')}</td>
                        
                            <td>${fieldValue(bean:applicationProcessingDetailsInstance, field:'approveNote')}</td>
                        
                            <td>${fieldValue(bean:applicationProcessingDetailsInstance, field:'clarification')}</td>
                        
                            <td>${fieldValue(bean:applicationProcessingDetailsInstance, field:'clarificationNote')}</td>
                        
                            <td>${fieldValue(bean:applicationProcessingDetailsInstance, field:'dateCreated')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${applicationProcessingDetailsInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
