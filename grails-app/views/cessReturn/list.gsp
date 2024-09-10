

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>CessReturn List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New CessReturn</g:link></span>
        </div>
        <div class="body">
            <h1>CessReturn List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="createdBy" title="Created By" />
                        
                   	        <g:sortableColumn property="dateCreated" title="Date Created" />
                        
                   	        <g:sortableColumn property="firstDayReading" title="First Day Reading" />
                        
                   	        <th>Industry Reg</th>
                   	    
                   	        <g:sortableColumn property="lastDayReading" title="Last Day Reading" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${cessReturnInstanceList}" status="i" var="cessReturnInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${cessReturnInstance.id}">${fieldValue(bean:cessReturnInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:cessReturnInstance, field:'createdBy')}</td>
                        
                            <td>${fieldValue(bean:cessReturnInstance, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:cessReturnInstance, field:'firstDayReading')}</td>
                        
                            <td>${fieldValue(bean:cessReturnInstance, field:'industryReg')}</td>
                        
                            <td>${fieldValue(bean:cessReturnInstance, field:'lastDayReading')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${cessReturnInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
