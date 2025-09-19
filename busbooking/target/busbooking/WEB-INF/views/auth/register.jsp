<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Register</title>
  <link rel="stylesheet" href="<c:url value='/resources/css/styles.css'/>">
</head>
<body>
  <h2>Register</h2>
  <c:if test="${not empty error}"><div style="color:red;">${error}</div></c:if>
  <form method="post" action="<c:url value='/auth/register'/>">
    <label>Name</label>
    <input type="text" name="name" value="${user.name}" required />
    <label>Email</label>
    <input type="email" name="email" value="${user.email}" required />
    <label>Password</label>
    <input type="password" name="passwordHash" minlength="6" required />
    <button type="submit">Create Account</button>
  </form>
  <p>Already have an account? <a href="<c:url value='/auth/login'/>">Login</a></p>
</body>
</html>


