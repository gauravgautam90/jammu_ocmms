

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>IndAirStackEmmision List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New IndAirStackEmmision</g:link></span>
        </div>
        <div class="body">
            <h1>IndAirStackEmmision List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="applicationId" title="Application Id" />
                        
                   	        <g:sortableColumn property="fuelCapacity" title="Fuel Capacity" />
                        
                   	        <g:sortableColumn property="fuelCapacityUnit" title="Fuel Capacity Unit" />
                        
                   	        <g:sortableColumn property="fuelName" title="Fuel Name" />
                        
                   	        <g:sortableColumn property="fuelQty" title="Fuel Qty" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${indAirStackEmmisionInstanceList}" status="i" var="indAirStackEmmisionInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${indAirStackEmmisionInstance.id}">${fieldValue(bean:indAirStackEmmisionInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:indAirStackEmmisionInstance, field:'applicationId')}</td>
                        
                            <td>${fieldValue(bean:indAirStackEmmisionInstance, field:'fuelCapacity')}</td>
                        
                            <td>${fieldValue(bean:indAirStackEmmisionInstance, field:'fuelCapacityUnit')}</td>
                        
                            <td>${fieldValue(bean:indAirStackEmmisionInstance, field:'fuelName')}</td>
                        
                            <td>${fieldValue(bean:indAirStackEmmisionInstance, field:'fuelQty')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${indAirStackEmmisionInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
