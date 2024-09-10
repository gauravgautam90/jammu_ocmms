

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>RoleActivityMaster List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New RoleActivityMaster</g:link></span>
        </div>
        <div class="body">
            <h1>RoleActivityMaster List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="activityCode" title="Activity Code" />
                        
                   	        <g:sortableColumn property="activityName" title="Activity Name" />
                        
                   	        <g:sortableColumn property="description" title="Description" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${roleActivityMasterInstanceList}" status="i" var="roleActivityMasterInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${roleActivityMasterInstance.id}">${fieldValue(bean:roleActivityMasterInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:roleActivityMasterInstance, field:'activityCode')}</td>
                        
                            <td>${fieldValue(bean:roleActivityMasterInstance, field:'activityName')}</td>
                        
                            <td>${fieldValue(bean:roleActivityMasterInstance, field:'description')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${roleActivityMasterInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
