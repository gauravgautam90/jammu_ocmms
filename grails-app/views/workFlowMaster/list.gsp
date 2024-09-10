

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>WorkFlowMaster List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New WorkFlowMaster</g:link></span>
        </div>
        <div class="body">
            <h1>WorkFlowMaster List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Can Forward To</th>
                   	    
                   	        <th>Group</th>
                   	    
                   	        <th>Role</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${workFlowMasterInstanceList}" status="i" var="workFlowMasterInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${workFlowMasterInstance.id}">${fieldValue(bean:workFlowMasterInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:workFlowMasterInstance, field:'canForwardTo')}</td>
                        
                            <td>${fieldValue(bean:workFlowMasterInstance, field:'group')}</td>
                        
                            <td>${fieldValue(bean:workFlowMasterInstance, field:'role')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${workFlowMasterInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
