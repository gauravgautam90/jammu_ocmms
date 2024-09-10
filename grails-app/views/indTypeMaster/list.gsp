

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>IndTypeMaster List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New IndTypeMaster</g:link></span>
        </div>
        <div class="body">
            <h1>IndTypeMaster List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="description" title="Description" />
                        
                   	        <g:sortableColumn property="max" title="Max" />
                        
                   	        <g:sortableColumn property="min" title="Min" />
                        
                   	        <g:sortableColumn property="name" title="Name" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${indTypeMasterInstanceList}" status="i" var="indTypeMasterInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${indTypeMasterInstance.id}">${fieldValue(bean:indTypeMasterInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:indTypeMasterInstance, field:'description')}</td>
                        
                            <td>${fieldValue(bean:indTypeMasterInstance, field:'max')}</td>
                        
                            <td>${fieldValue(bean:indTypeMasterInstance, field:'min')}</td>
                        
                            <td>${fieldValue(bean:indTypeMasterInstance, field:'name')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${indTypeMasterInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
