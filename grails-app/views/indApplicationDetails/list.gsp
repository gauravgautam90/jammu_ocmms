

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>IndApplicationDetails List</title>
        <g:javascript library="prototype" />
        <g:javascript>
function createRow(){
//alert('calling Ajax');
  try{
      var oAjax=new Ajax.Updater({success: 'update'},'tempDoEdit.gsp', { insertion: Insertion.Bottom });
  }catch(e){
      alert('Failed to call Ajax');
  }
}


function hello()
 {
       new Ajax.Updater("update",
          "<%=request.getContextPath()%>/workFlowMaster/updateSelect",
          {method:'get', parameters: {selectedValue : '1'} }
         );
 }
</g:javascript>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New IndApplicationDetails</g:link></span>
        </div>
        <div class="body">
            <h1>IndApplicationDetails List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="applicationDate" title="Application Date" />
                        
                   	        <g:sortableColumn property="applicationFor" title="Application For" />
                        
                   	        <g:sortableColumn property="applicationName" title="Application Name" />
                        
                   	        <th>Application Type</th>
                   	    
                   	        <th>Category</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${indApplicationDetailsInstanceList}" status="i" var="indApplicationDetailsInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${indApplicationDetailsInstance.id}">${fieldValue(bean:indApplicationDetailsInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:indApplicationDetailsInstance, field:'applicationDate')}</td>
                        
                            <td>${fieldValue(bean:indApplicationDetailsInstance, field:'applicationFor')}</td>
                        
                            <td>${fieldValue(bean:indApplicationDetailsInstance, field:'applicationName')}</td>
                        
                            <td>${fieldValue(bean:indApplicationDetailsInstance, field:'applicationType')}</td>
                        
                            <td>${fieldValue(bean:indApplicationDetailsInstance, field:'category')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <a href="#" onclick="window.open('<%=request.getContextPath()%>/indApplicationDetails/pop.gsp', 'ApplicationHistory', 'WIDTH=690,HEIGHT=400,scrollbars=1');"><span class="innerlink">&nbsp;View Form&nbsp;|</span></a> 
            <div id="update"></div>
            
        </div>
    </body>
</html>
