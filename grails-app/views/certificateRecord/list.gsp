

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>CertificateRecord List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New CertificateRecord</g:link></span>
        </div>
        <div class="body">
            <h1>CertificateRecord List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Application Id</th>
                   	    
                   	        <g:sortableColumn property="startDate" title="Start Date" />
                        
                   	        <g:sortableColumn property="endDate" title="End Date" />
                        
                   	        <g:sortableColumn property="createdBy" title="Created By" />
                        
                   	        <g:sortableColumn property="updatedBy" title="Updated By" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${certificateRecordInstanceList}" status="i" var="certificateRecordInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${certificateRecordInstance.id}">${fieldValue(bean:certificateRecordInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:certificateRecordInstance, field:'applicationId')}</td>
                        
                            <td>${fieldValue(bean:certificateRecordInstance, field:'startDate')}</td>
                        
                            <td>${fieldValue(bean:certificateRecordInstance, field:'endDate')}</td>
                        
                            <td>${fieldValue(bean:certificateRecordInstance, field:'createdBy')}</td>
                        
                            <td>${fieldValue(bean:certificateRecordInstance, field:'updatedBy')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${certificateRecordInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
