

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>CessProcessingDetails List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New CessProcessingDetails</g:link></span>
        </div>
        <div class="body">
            <h1>CessProcessingDetails List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="dateCreated" title="Date Created" />
                        
                   	        <g:sortableColumn property="fileNote" title="File Note" />
                        
                   	        <g:sortableColumn property="lastUpdated" title="Last Updated" />
                        
                   	        <g:sortableColumn property="officer" title="Officer" />
                        
                   	        <g:sortableColumn property="officerFwd" title="Officer Fwd" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${cessProcessingDetailsInstanceList}" status="i" var="cessProcessingDetailsInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${cessProcessingDetailsInstance.id}">${fieldValue(bean:cessProcessingDetailsInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:cessProcessingDetailsInstance, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:cessProcessingDetailsInstance, field:'fileNote')}</td>
                        
                            <td>${fieldValue(bean:cessProcessingDetailsInstance, field:'lastUpdated')}</td>
                        
                            <td>${fieldValue(bean:cessProcessingDetailsInstance, field:'officer')}</td>
                        
                            <td>${fieldValue(bean:cessProcessingDetailsInstance, field:'officerFwd')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${cessProcessingDetailsInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
