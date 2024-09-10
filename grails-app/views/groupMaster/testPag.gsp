<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Paginate</title>
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
                    <table width="85%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#cbcbcd" class="tab-txt" style="border-collapse:collapse;">
                    <thead>
                       <tr height="30" bgcolor="#F4F7FB">
                        
                   	        <td> Id </td>
                        
                   	        <td>Industry User </td>
                   	        <td>Application Type</td>
                   	        <td>Application For</td>
                   	        <td>Application Date</td>
                   	        <td>Application Name</td>
                   	        <td>Certificate For</td>
                        
                   	        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${abc}" status="i" var="abc">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                       
                            <td><g:link controller="indApplicationDetails" action="show" id="${abc.id}">${fieldValue(bean:abc, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:abc, field:'indUser')}</td>
                        
                            <td>${fieldValue(bean:abc, field:'applicationType')}</td>
                        
                            <td>${fieldValue(bean:abc, field:'applicationFor')}</td>
                        
                            <td>${fieldValue(bean:abc, field:'applicationDate')}</td>
                        
                            <td>${fieldValue(bean:abc, field:'applicationName')}</td>
                            
                           
                        
                            <td>${fieldValue(bean:abc, field:'certificateFor')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
           <g:paginate 
             controller="groupMaster"
            action="testPag" total="${total}" />
        </div>
       
    </body>
</html>
