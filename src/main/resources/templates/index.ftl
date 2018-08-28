<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8" />
<title>freeMarker</title>
</head>
<body>
	  ${name}
	  <#if sex==1>
	  	男
	  <#elseif sex==0>
	  	女
	  <#else>
	  	其他
	  </#if>
	  
	  <#list userList as user>
	  	${user}
	  </#list>
</body> 
</html>
