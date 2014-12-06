<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Hackcamp - Blog Post anlegen</h1>

    <a href="<c:url value="/" />">Zur Übersicht</a>
    <br />
    <br />

	<form method="post" action="<c:url value="/create" />">
		Betreff: <input type="text" name="subject" value="${blogPost.subject}" />
		<br /> 
		Inhalt: <textarea name="content" cols="50" rows="10">${blogPost.content}</textarea>
		<br />
		<input type="submit" value="Anlegen" />
	</form>

</body>
</html>