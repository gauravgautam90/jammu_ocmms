

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit SampleHandover</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">SampleHandover List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New SampleHandover</g:link></span>
        </div>
        <div class="body">
            <h1>Edit SampleHandover</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${sampleHandoverInstance}">
            <div class="errors">
                <g:renderErrors bean="${sampleHandoverInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${sampleHandoverInstance?.id}" />
                <input type="hidden" name="version" value="${sampleHandoverInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Description:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:sampleHandoverInstance,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:sampleHandoverInstance,field:'description')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="groupMasterInstance">Group Master Instance:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:sampleHandoverInstance,field:'groupMasterInstance','errors')}">
                                    <g:select optionKey="id" from="${GroupMaster.list()}" name="groupMasterInstance.id" value="${sampleHandoverInstance?.groupMasterInstance?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="handoverDate">Handover Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:sampleHandoverInstance,field:'handoverDate','errors')}">
                                    <g:datePicker name="handoverDate" value="${sampleHandoverInstance?.handoverDate}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="indUser">Ind User:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:sampleHandoverInstance,field:'indUser','errors')}">
                                    <g:select optionKey="id" from="${IndustryRegMaster.list()}" name="indUser.id" value="${sampleHandoverInstance?.indUser?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="sampleId">Sample Id:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:sampleHandoverInstance,field:'sampleId','errors')}">
                                    <input type="text" id="sampleId" name="sampleId" value="${fieldValue(bean:sampleHandoverInstance,field:'sampleId')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="sampleType">Sample Type:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:sampleHandoverInstance,field:'sampleType','errors')}">
                                    <input type="text" id="sampleType" name="sampleType" value="${fieldValue(bean:sampleHandoverInstance,field:'sampleType')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="sourceOfSample">Source Of Sample:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:sampleHandoverInstance,field:'sourceOfSample','errors')}">
                                    <input type="text" id="sourceOfSample" name="sourceOfSample" value="${fieldValue(bean:sampleHandoverInstance,field:'sourceOfSample')}"/>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
