

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>IndUnitNatureTransaction List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New IndUnitNatureTransaction</g:link></span>
        </div>
        <div class="body">
            <h1>IndUnitNatureTransaction List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Ind Reg</th>
                   	    
                   	        <th>Unit Nature</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${indUnitNatureTransactionInstanceList}" status="i" var="indUnitNatureTransactionInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${indUnitNatureTransactionInstance.id}">${fieldValue(bean:indUnitNatureTransactionInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:indUnitNatureTransactionInstance, field:'indReg')}</td>
                        
                            <td>${fieldValue(bean:indUnitNatureTransactionInstance, field:'unitNature')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${indUnitNatureTransactionInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
