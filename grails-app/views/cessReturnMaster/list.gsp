

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>CessReturnMaster List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New CessReturnMaster</g:link></span>
        </div>
        <div class="body">
            <h1>CessReturnMaster List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Application</th>
                   	    
                   	        <g:sortableColumn property="averageWaterConsumption" title="Average Water Consumption" />
                        
                   	        <g:sortableColumn property="createdOn" title="Created On" />
                        
                   	        <g:sortableColumn property="firstReading" title="First Reading" />
                        
                   	        <g:sortableColumn property="lastReading" title="Last Reading" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${cessReturnMasterInstanceList}" status="i" var="cessReturnMasterInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${cessReturnMasterInstance.id}">${fieldValue(bean:cessReturnMasterInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:cessReturnMasterInstance, field:'application')}</td>
                        
                            <td>${fieldValue(bean:cessReturnMasterInstance, field:'averageWaterConsumption')}</td>
                        
                            <td>${fieldValue(bean:cessReturnMasterInstance, field:'createdOn')}</td>
                        
                            <td>${fieldValue(bean:cessReturnMasterInstance, field:'firstReading')}</td>
                        
                            <td>${fieldValue(bean:cessReturnMasterInstance, field:'lastReading')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${cessReturnMasterInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
