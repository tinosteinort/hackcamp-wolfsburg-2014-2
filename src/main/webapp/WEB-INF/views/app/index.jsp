<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Hackcamp (<c:out value="${blogCount}" /> Blog Posts)</h1>

    <a href="<c:url value="/create" />">BlogPost anlegen</a>

	<c:forEach items="${blogPosts}" var="blogPost">
		<h2>${blogPost.subject}</h2>
		${blogPost.createdOn}<br />
		<br />
        ${blogPost.content}
        <hr />
	</c:forEach>

</body>
</html>