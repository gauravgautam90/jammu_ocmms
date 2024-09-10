

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>IndAirStkEmPrm List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New IndAirStkEmPrm</g:link></span>
        </div>
        <div class="body">
            <h1>IndAirStkEmPrm List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Ind Air Stk Id</th>
                   	    
                   	        <g:sortableColumn property="parameter" title="Parameter" />
                        
                   	        <g:sortableColumn property="standard" title="Standard" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${indAirStkEmPrmInstanceList}" status="i" var="indAirStkEmPrmInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${indAirStkEmPrmInstance.id}">${fieldValue(bean:indAirStkEmPrmInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:indAirStkEmPrmInstance, field:'indAirStkId')}</td>
                        
                            <td>${fieldValue(bean:indAirStkEmPrmInstance, field:'parameter')}</td>
                        
                            <td>${fieldValue(bean:indAirStkEmPrmInstance, field:'standard')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${indAirStkEmPrmInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
