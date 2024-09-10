

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>LabProcessingDetails List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New LabProcessingDetails</g:link></span>
        </div>
        <div class="body">
            <h1>LabProcessingDetails List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Application</th>
                   	    
                   	        <g:sortableColumn property="dateCreated" title="Date Created" />
                        
                   	        <g:sortableColumn property="fileNote" title="File Note" />
                        
                   	        <g:sortableColumn property="finish" title="Finish" />
                        
                   	        <g:sortableColumn property="finishNote" title="Finish Note" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${labProcessingDetailsInstanceList}" status="i" var="labProcessingDetailsInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${labProcessingDetailsInstance.id}">${fieldValue(bean:labProcessingDetailsInstance, field:'id')}</g:link></td>
                        
                           
<td>${fieldValue(bean:labProcessingDetailsInstance, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:labProcessingDetailsInstance, field:'fileNote')}</td>
                        
                            <td>${fieldValue(bean:labProcessingDetailsInstance, field:'finish')}</td>
                        
                            <td>${fieldValue(bean:labProcessingDetailsInstance, field:'finishNote')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${labProcessingDetailsInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
