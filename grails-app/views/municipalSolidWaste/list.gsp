

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>MunicipalSolidWaste List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New MunicipalSolidWaste</g:link></span>
        </div>
        <div class="body">
            <h1>MunicipalSolidWaste List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="locationSite" title="Location Site" />
                        
                   	        <g:sortableColumn property="qtyProcessed" title="Qty Processed" />
                        
                   	        <g:sortableColumn property="invenstment" title="Invenstment" />
                        
                   	        <g:sortableColumn property="expectedReturn" title="Expected Return" />
                        
                   	        <g:sortableColumn property="numSites" title="Num Sites" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${municipalSolidWasteInstanceList}" status="i" var="municipalSolidWasteInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${municipalSolidWasteInstance.id}">${fieldValue(bean:municipalSolidWasteInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:municipalSolidWasteInstance, field:'locationSite')}</td>
                        
                            <td>${fieldValue(bean:municipalSolidWasteInstance, field:'qtyProcessed')}</td>
                        
                            <td>${fieldValue(bean:municipalSolidWasteInstance, field:'invenstment')}</td>
                        
                            <td>${fieldValue(bean:municipalSolidWasteInstance, field:'expectedReturn')}</td>
                        
                            <td>${fieldValue(bean:municipalSolidWasteInstance, field:'numSites')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${municipalSolidWasteInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
