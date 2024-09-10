

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Lab_AmbientAirMonitoring List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Lab_AmbientAirMonitoring</g:link></span>
        </div>
        <div class="body">
            <h1>Lab_AmbientAirMonitoring List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="ambientTemperatureEighthHour" title="Ambient Temperature Eighth Hour" />
                        
                   	        <g:sortableColumn property="ambientTemperatureFifthHour" title="Ambient Temperature Fifth Hour" />
                        
                   	        <g:sortableColumn property="ambientTemperatureFirstHour" title="Ambient Temperature First Hour" />
                        
                   	        <g:sortableColumn property="ambientTemperatureFourthHour" title="Ambient Temperature Fourth Hour" />
                        
                   	        <g:sortableColumn property="ambientTemperatureSecondHour" title="Ambient Temperature Second Hour" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${lab_AmbientAirMonitoringInstanceList}" status="i" var="lab_AmbientAirMonitoringInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${lab_AmbientAirMonitoringInstance.id}">${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'ambientTemperatureEighthHour')}</td>
                        
                            <td>${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'ambientTemperatureFifthHour')}</td>
                        
                            <td>${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'ambientTemperatureFirstHour')}</td>
                        
                            <td>${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'ambientTemperatureFourthHour')}</td>
                        
                            <td>${fieldValue(bean:lab_AmbientAirMonitoringInstance, field:'ambientTemperatureSecondHour')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${lab_AmbientAirMonitoringInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
