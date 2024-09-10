

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>LabEntryForm List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New LabEntryForm</g:link></span>
        </div>
        <div class="body">
            <h1>LabEntryForm List</h1>
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
                        
                   	        <g:sortableColumn property="fullDetails" title="Full Details" />
                        
                   	        <th>Group Master Instance</th>
                   	    
                   	        <g:sortableColumn property="lastUpdated" title="Last Updated" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${labEntryFormInstanceList}" status="i" var="labEntryFormInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${labEntryFormInstance.id}">${fieldValue(bean:labEntryFormInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:labEntryFormInstance, field:'createdBy')}</td>
                        
                            <td>${fieldValue(bean:labEntryFormInstance, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:labEntryFormInstance, field:'fullDetails')}</td>
                        
                            <td>${fieldValue(bean:labEntryFormInstance, field:'groupMasterInstance')}</td>
                        
                            <td>${fieldValue(bean:labEntryFormInstance, field:'lastUpdated')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${labEntryFormInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
