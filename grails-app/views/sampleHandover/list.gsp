

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>SampleHandover List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New SampleHandover</g:link></span>
        </div>
        <div class="body">
            <h1>SampleHandover List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="description" title="Description" />
                        
                   	        <th>Group Master Instance</th>
                   	    
                   	        <g:sortableColumn property="handoverDate" title="Handover Date" />
                        
                   	        <th>Ind User</th>
                   	    
                   	        <g:sortableColumn property="sampleId" title="Sample Id" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${sampleHandoverInstanceList}" status="i" var="sampleHandoverInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${sampleHandoverInstance.id}">${fieldValue(bean:sampleHandoverInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:sampleHandoverInstance, field:'description')}</td>
                        
                            <td>${fieldValue(bean:sampleHandoverInstance, field:'groupMasterInstance')}</td>
                        
                            <td>${fieldValue(bean:sampleHandoverInstance, field:'handoverDate')}</td>
                        
                            <td>${fieldValue(bean:sampleHandoverInstance, field:'indUser')}</td>
                        
                            <td>${fieldValue(bean:sampleHandoverInstance, field:'sampleId')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${sampleHandoverInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
