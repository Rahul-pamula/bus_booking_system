<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
  <h2>Bus Booking System</h2>
  <ul>
    <li><a href="<c:url value='/auth/login'/>">Login</a></li>
    <li><a href="<c:url value='/auth/register'/>">Register</a></li>
    <li><a href="<c:url value='/buses/search'/>">Search Buses</a></li>
    <li><a href="<c:url value='/bookings/my'/>">My Bookings</a></li>
  </ul>
</body>
</html>
