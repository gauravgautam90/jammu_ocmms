<html>
<head>

	
	<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />


<script type="text/javascript" src="${createLinkTo(dir:'js',file:'calendar_us.js')}" ></script>
	
</head>
<body>


<FORM name=myForm action=create>

<input type="text" name="testinput" />
	<script language="JavaScript">
	new tcal ({
		// form name
		'formname': 'myForm',
		// input name
		'controlname': 'testinput'
	});

	</script>
	<input type="submit">
</form>



</body>
</html>