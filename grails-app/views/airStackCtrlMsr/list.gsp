

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>AirStackCtrlMsr List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New AirStackCtrlMsr</g:link></span>
        </div>
        <div class="body">
            <h1>AirStackCtrlMsr List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="airEmType" title="Air Em Type" />
                        
                   	        <g:sortableColumn property="name" title="Name" />
                        
                   	        <th>Type Id</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${airStackCtrlMsrInstanceList}" status="i" var="airStackCtrlMsrInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${airStackCtrlMsrInstance.id}">${fieldValue(bean:airStackCtrlMsrInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:airStackCtrlMsrInstance, field:'airEmType')}</td>
                        
                            <td>${fieldValue(bean:airStackCtrlMsrInstance, field:'name')}</td>
                        
                            <td>${fieldValue(bean:airStackCtrlMsrInstance, field:'typeId')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${airStackCtrlMsrInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
