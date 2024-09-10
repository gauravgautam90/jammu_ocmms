

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>CessReturnDetails List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New CessReturnDetails</g:link></span>
        </div>
        <div class="body">
            <h1>CessReturnDetails List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Cess Return</th>
                   	    
                   	        <g:sortableColumn property="createdBy" title="Created By" />
                        
                   	        <g:sortableColumn property="dateCreated" title="Date Created" />
                        
                   	        <g:sortableColumn property="endReading" title="End Reading" />
                        
                   	        <g:sortableColumn property="lastUpdated" title="Last Updated" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${cessReturnDetailsInstanceList}" status="i" var="cessReturnDetailsInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${cessReturnDetailsInstance.id}">${fieldValue(bean:cessReturnDetailsInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:cessReturnDetailsInstance, field:'cessReturn')}</td>
                        
                            <td>${fieldValue(bean:cessReturnDetailsInstance, field:'createdBy')}</td>
                        
                            <td>${fieldValue(bean:cessReturnDetailsInstance, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:cessReturnDetailsInstance, field:'endReading')}</td>
                        
                            <td>${fieldValue(bean:cessReturnDetailsInstance, field:'lastUpdated')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${cessReturnDetailsInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
