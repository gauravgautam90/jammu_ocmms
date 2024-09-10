

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create IndUser</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">IndUser List</g:link></span>
        </div>
        <div class="body">
            <h1>Create IndUser</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${indUserInstance}">
            <div class="errors">
                <g:renderErrors bean="${indUserInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="createdBy">Created By:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indUserInstance,field:'createdBy','errors')}">
                                    <input type="text" id="createdBy" name="createdBy" value="${fieldValue(bean:indUserInstance,field:'createdBy')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated">Date Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indUserInstance,field:'dateCreated','errors')}">
                                    <g:datePicker name="dateCreated" value="${indUserInstance?.dateCreated}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="hintAnswer">Hint Answer:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indUserInstance,field:'hintAnswer','errors')}">
                                    <input type="text" id="hintAnswer" name="hintAnswer" value="${fieldValue(bean:indUserInstance,field:'hintAnswer')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="hintQuestion">Hint Question:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indUserInstance,field:'hintQuestion','errors')}">
                                    <input type="text" id="hintQuestion" name="hintQuestion" value="${fieldValue(bean:indUserInstance,field:'hintQuestion')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="industryRegMaster">Industry Reg Master:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indUserInstance,field:'industryRegMaster','errors')}">
                                    <g:select optionKey="id" from="${IndustryRegMaster.list()}" name="industryRegMaster.id" value="${indUserInstance?.industryRegMaster?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="password">Password:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indUserInstance,field:'password','errors')}">
                                    <input type="text" id="password" name="password" value="${fieldValue(bean:indUserInstance,field:'password')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="userId">User Id:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:indUserInstance,field:'userId','errors')}">
                                    <input type="text" id="userId" name="userId" value="${fieldValue(bean:indUserInstance,field:'userId')}"/>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
