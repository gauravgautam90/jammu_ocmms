

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>GroupDistrictMaster List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New GroupDistrictMaster</g:link></span>
        </div>
        <div class="body">
            <h1>GroupDistrictMaster List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>District</th>
                   	    
                   	        <th>Group</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${groupDistrictMasterInstanceList}" status="i" var="groupDistrictMasterInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${groupDistrictMasterInstance.id}">${fieldValue(bean:groupDistrictMasterInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:groupDistrictMasterInstance, field:'district')}</td>
                        
                            <td>${fieldValue(bean:groupDistrictMasterInstance, field:'group')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${groupDistrictMasterInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
