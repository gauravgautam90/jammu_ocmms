

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>ConditionMaster List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New ConditionMaster</g:link></span>
        </div>
        <div class="body">
            <h1>ConditionMaster List</h1>
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
                        
                   	        <g:sortableColumn property="conditionType" title="Condition Type" />
                        
                   	        <g:sortableColumn property="applicationFor" title="Application For" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${conditionMasterInstanceList}" status="i" var="conditionMasterInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${conditionMasterInstance.id}">${fieldValue(bean:conditionMasterInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:conditionMasterInstance, field:'industryTypeMaster')}</td>
                        
                            <td>${fieldValue(bean:conditionMasterInstance, field:'applicationTypeMaster')}</td>
                        
                            <td>${fieldValue(bean:conditionMasterInstance, field:'consentFor')}</td>
                        
                            <td>${fieldValue(bean:conditionMasterInstance, field:'conditionType')}</td>
                        
                            <td>${fieldValue(bean:conditionMasterInstance, field:'applicationFor')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${conditionMasterInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
