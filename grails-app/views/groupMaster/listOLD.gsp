

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>GroupMaster List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New GroupMaster</g:link></span>
        </div>
        <div class="body">
            <h1>GroupMaster List</h1>
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
                        
                   	        <g:sortableColumn property="groupDesc" title="Group Desc" />
                        
                   	        <g:sortableColumn property="groupName" title="Group Name" />
                        
                   	        <g:sortableColumn property="lastUpdated" title="Last Updated" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${groupMasterInstanceList}" status="i" var="groupMasterInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${groupMasterInstance.id}">${fieldValue(bean:groupMasterInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:groupMasterInstance, field:'createdBy')}</td>
                        
                            <td>${fieldValue(bean:groupMasterInstance, field:'dateCreated')}</td>
                        
                            <td>${fieldValue(bean:groupMasterInstance, field:'groupDesc')}</td>
                        
                            <td>${fieldValue(bean:groupMasterInstance, field:'groupName')}</td>
                        
                            <td>${fieldValue(bean:groupMasterInstance, field:'lastUpdated')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
          <g:paginate next="Forward" prev="Back"
            maxsteps="0" controller="groupMaster"
            action="list" total="${groupMasterInstanceTotal}" />
               
            </div>
        </div>
       
    </body>
</html>
