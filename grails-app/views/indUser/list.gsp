<!--

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>IndUser List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New IndUser</g:link></span>
        </div>
        <div class="body">
            <h1>IndUser List</h1>
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
                        
                   	        <g:sortableColumn property="hintAnswer" title="Hint Answer" />
                        
                   	        <g:sortableColumn property="hintQuestion" title="Hint Question" />
                        
                   	        <th>Industry Reg Master</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${indUserInstanceList}" status="i" var="indUserInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${indUserInstance.id}">${fieldValue(bean:indUserInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:indUserInstance, field:'createdBy')}</td>
                        
                            <td>${fieldValue(bean:indUserInstance, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:indUserInstance, field:'hintAnswer')}</td>
                        
                            <td>${fieldValue(bean:indUserInstance, field:'hintQuestion')}</td>
                        
                            <td>${fieldValue(bean:indUserInstance, field:'industryRegMaster')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${indUserInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
-->