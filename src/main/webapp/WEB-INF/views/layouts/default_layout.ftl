<!DOCTYPE html>
<html>
	<head>
		<#include "head.ftl" />
	</head>
	<body>
		<header>
			<#include "header.ftl">
		</header>
		<nav>
			<#include "navigation.ftl" />
		</nav>
		<main>
			${page_content}
		</main>
		<footer>
			<#include "footer.ftl" />
		</footer>
	</body>
</html>