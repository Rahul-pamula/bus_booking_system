<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>My Bookings</title>
  <link rel="stylesheet" href="<c:url value='/resources/css/styles.css'/>">
</head>
<body>
  <h2>My Bookings</h2>
  <c:if test="${empty bookings}">
    <p>No bookings yet.</p>
  </c:if>
  <c:if test="${not empty bookings}">
    <table border="1" cellpadding="6">
      <tr>
        <th>Bus</th>
        <th>From</th>
        <th>To</th>
        <th>Seats</th>
        <th>Booked At</th>
      </tr>
      <c:forEach var="bk" items="${bookings}">
        <tr>
          <td>${bk.bus.id}</td>
          <td>${bk.bus.source}</td>
          <td>${bk.bus.destination}</td>
          <td>${bk.seats}</td>
          <td>${bk.bookedAt}</td>
        </tr>
      </c:forEach>
    </table>
  </c:if>
</body>
</html>


