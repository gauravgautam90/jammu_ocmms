

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>DocumentChecklistMaster List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New DocumentChecklistMaster</g:link></span>
        </div>
        <div class="body">
            <h1>DocumentChecklistMaster List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Industry Type Master</th>
                   	    
                   	        <th>Application Type Master</th>
                   	    
                   	        <g:sortableColumn property="consentFor" title="Consent For" />
                        
                   	        <g:sortableColumn property="applicationFor" title="Application For" />
                        
                   	        <g:sortableColumn property="document" title="Document" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${documentChecklistMasterInstanceList}" status="i" var="documentChecklistMasterInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${documentChecklistMasterInstance.id}">${fieldValue(bean:documentChecklistMasterInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:documentChecklistMasterInstance, field:'industryTypeMaster')}</td>
                        
                            <td>${fieldValue(bean:documentChecklistMasterInstance, field:'applicationTypeMaster')}</td>
                        
                            <td>${fieldValue(bean:documentChecklistMasterInstance, field:'consentFor')}</td>
                        
                            <td>${fieldValue(bean:documentChecklistMasterInstance, field:'applicationFor')}</td>
                        
                            <td>${fieldValue(bean:documentChecklistMasterInstance, field:'document')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${documentChecklistMasterInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
