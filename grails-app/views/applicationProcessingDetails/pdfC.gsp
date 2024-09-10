<html>
<head>pdf</head>
<body>
<g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
<g:form action="pdfC1">
<input type="textField" name="pdfc"/>
<input type="textField" name="pdfc2"/>
<input type="textField" name="pdfc3"/>
<input type="submit">
</g:form>
</body></html>
