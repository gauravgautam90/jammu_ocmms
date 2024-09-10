

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>AirEmmisionType List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New AirEmmisionType</g:link></span>
        </div>
        <div class="body">
            <h1>AirEmmisionType List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="typeName" title="Type Name" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${airEmmisionTypeInstanceList}" status="i" var="airEmmisionTypeInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${airEmmisionTypeInstance.id}">${fieldValue(bean:airEmmisionTypeInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:airEmmisionTypeInstance, field:'typeName')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${airEmmisionTypeInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
