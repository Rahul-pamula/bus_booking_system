<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Login</title>
  <link rel="stylesheet" href="<c:url value='/resources/css/styles.css'/>">
</head>
<body>
  <h2>Login</h2>
  <c:if test="${not empty error}"><div style="color:red;">${error}</div></c:if>
  <form method="post" action="<c:url value='/auth/login'/>">
    <label>Email</label>
    <input type="email" name="email" required />
    <label>Password</label>
    <input type="password" name="password" minlength="6" required />
    <button type="submit">Login</button>
  </form>
  <p>No account? <a href="<c:url value='/auth/register'/>">Register</a></p>
</body>
</html>


