

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>IndAFugEmCtrlMsr List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New IndAFugEmCtrlMsr</g:link></span>
        </div>
        <div class="body">
            <h1>IndAFugEmCtrlMsr List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>AS tack Ctrl Msr</th>
                   	    
                   	        <th>Ind Air Stk Id</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${indAFugEmCtrlMsrInstanceList}" status="i" var="indAFugEmCtrlMsrInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${indAFugEmCtrlMsrInstance.id}">${fieldValue(bean:indAFugEmCtrlMsrInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:indAFugEmCtrlMsrInstance, field:'aStackCtrlMsr')}</td>
                        
                            <td>${fieldValue(bean:indAFugEmCtrlMsrInstance, field:'indAirStkId')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${indAFugEmCtrlMsrInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
