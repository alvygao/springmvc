<#assign decorator = JspTaglibs["/WEB-INF/sitemesh-decorator.tld"]/>
<#assign ctx = rc.contextPath>
<@decorator.usePage id="page"/>

<html>
	<head>
	    <link href="${ctx}/css/reset.css" type="text/css" rel="stylesheet">
	    <link href="${ctx}/css/common.css" type="text/css" rel="stylesheet">
		<title><@decorator.title/></title>
		<@decorator.head/>
	</head>
	<body>
		<@decorator.body/>
	</body>
</html>