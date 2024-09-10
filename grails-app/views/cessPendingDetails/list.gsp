

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>CessPendingDetails List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New CessPendingDetails</g:link></span>
        </div>
        <div class="body">
            <h1>CessPendingDetails List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="applicationStatus" title="Application Status" />
                        
                   	        <th>Cess Return</th>
                   	    
                   	        <g:sortableColumn property="dateCreated" title="Date Created" />
                        
                   	        <th>Ind Reg Instance</th>
                   	    
                   	        <g:sortableColumn property="lastUpdated" title="Last Updated" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${cessPendingDetailsInstanceList}" status="i" var="cessPendingDetailsInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${cessPendingDetailsInstance.id}">${fieldValue(bean:cessPendingDetailsInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:cessPendingDetailsInstance, field:'applicationStatus')}</td>
                        
                            <td>${fieldValue(bean:cessPendingDetailsInstance, field:'cessReturn')}</td>
                        
                            <td>${fieldValue(bean:cessPendingDetailsInstance, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:cessPendingDetailsInstance, field:'indRegInstance')}</td>
                        
                            <td>${fieldValue(bean:cessPendingDetailsInstance, field:'lastUpdated')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${cessPendingDetailsInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
