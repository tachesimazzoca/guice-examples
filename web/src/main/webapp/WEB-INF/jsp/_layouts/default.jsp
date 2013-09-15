<%@ page
  pageEncoding="UTF-8"
  contentType="text/html; charset=utf-8"
  isELIgnored="false"
  trimDirectiveWhitespaces="true"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% pageContext.setAttribute("basedir", config.getServletContext().getContextPath()); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Google Guice Examples|Web|<c:out value="${param.title}"/></title>
</head>
<body>
<h1><c:out value="${param.title}"/></h1>
${param.content}
<h3>Menu</h3>
<ul>
  <li><a href="${basedir}/">HOME</a></li>
  <li><a href="${basedir}/body.html">/body.html</a></li>
  <li><a href="${basedir}/pages/about.html">/pages/about.html</a></li>
  <li><a href="${basedir}/pages/help.html">/pages/help.html</a></li>
</ul>
</body>
</html>
