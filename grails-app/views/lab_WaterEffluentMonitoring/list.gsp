

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Lab_WaterEffluentMonitoring List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Lab_WaterEffluentMonitoring</g:link></span>
        </div>
        <div class="body">
            <h1>Lab_WaterEffluentMonitoring List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="CL" title="CL" />
                        
                   	        <g:sortableColumn property="TC" title="TC" />
                        
                   	        <g:sortableColumn property="additionalPreservativeUsed" title="Additional Preservative Used" />
                        
                   	        <g:sortableColumn property="comment" title="Comment" />
                        
                   	        <g:sortableColumn property="conductivity" title="Conductivity" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${lab_WaterEffluentMonitoringInstanceList}" status="i" var="lab_WaterEffluentMonitoringInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${lab_WaterEffluentMonitoringInstance.id}">${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'CL')}</td>
                        
                            <td>${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'TC')}</td>
                        
                            <td>${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'additionalPreservativeUsed')}</td>
                        
                            <td>${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'comment')}</td>
                        
                            <td>${fieldValue(bean:lab_WaterEffluentMonitoringInstance, field:'conductivity')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${lab_WaterEffluentMonitoringInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
