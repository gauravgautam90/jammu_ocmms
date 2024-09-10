

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>BioMedicalWaste List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New BioMedicalWaste</g:link></span>
        </div>
        <div class="body">
            <h1>BioMedicalWaste List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="activityAuthorizationSoughtFor" title="Activity For Which Authorization Is Sought" />
                        
                   	        <g:sortableColumn property="addrPlaceDisposalOfWaste" title="Addr Place Disposal Of Waste" />
                        
                   	        <g:sortableColumn property="addrTreatmentFacility" title="Addr Treatment Facility" />
                        
                   	        <g:sortableColumn property="authorizationType" title="Authorization Type" />
                        
                   	        <g:sortableColumn property="createdBy" title="Created By" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${bioMedicalWasteInstanceList}" status="i" var="bioMedicalWasteInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${bioMedicalWasteInstance.id}">${fieldValue(bean:bioMedicalWasteInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:bioMedicalWasteInstance, field:'activityAuthorizationSoughtFor')}</td>
                        
                            <td>${fieldValue(bean:bioMedicalWasteInstance, field:'addrPlaceDisposalOfWaste')}</td>
                        
                            <td>${fieldValue(bean:bioMedicalWasteInstance, field:'addrTreatmentFacility')}</td>
                        
                            <td>${fieldValue(bean:bioMedicalWasteInstance, field:'authorizationType')}</td>
                        
                            <td>${fieldValue(bean:bioMedicalWasteInstance, field:'createdBy')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${bioMedicalWasteInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
