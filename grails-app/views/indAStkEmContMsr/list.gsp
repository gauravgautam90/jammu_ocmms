

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>IndAStkEmContMsr List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New IndAStkEmContMsr</g:link></span>
        </div>
        <div class="body">
            <h1>IndAStkEmContMsr List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>AS tack Ctrl Msr</th>
                   	    
                   	        <th>Ind Air Stk Em</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${indAStkEmContMsrInstanceList}" status="i" var="indAStkEmContMsrInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${indAStkEmContMsrInstance.id}">${fieldValue(bean:indAStkEmContMsrInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:indAStkEmContMsrInstance, field:'aStackCtrlMsr')}</td>
                        
                            <td>${fieldValue(bean:indAStkEmContMsrInstance, field:'indAirStkEm')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${indAStkEmContMsrInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
