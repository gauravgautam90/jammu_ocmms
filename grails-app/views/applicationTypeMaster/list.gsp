

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>ApplicationTypeMaster List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New ApplicationTypeMaster</g:link></span>
        </div>
        <div class="body">
            <h1>ApplicationTypeMaster List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="consentType" title="Consent Type" />
                        
                   	        <g:sortableColumn property="description" title="Description" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${applicationTypeMasterInstanceList}" status="i" var="applicationTypeMasterInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${applicationTypeMasterInstance.id}">${fieldValue(bean:applicationTypeMasterInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:applicationTypeMasterInstance, field:'consentType')}</td>
                        
                            <td>${fieldValue(bean:applicationTypeMasterInstance, field:'description')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${applicationTypeMasterInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
