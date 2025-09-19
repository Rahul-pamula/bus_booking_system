<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Search Buses</title>
  <link rel="stylesheet" href="<c:url value='/resources/css/styles.css'/>">
</head>
<body>
  <h2>Search Buses</h2>
  <form method="post" action="<c:url value='/buses/search'/>">
    <input type="text" name="source" placeholder="From" required />
    <input type="text" name="destination" placeholder="To" required />
    <input type="date" name="travelDate" required />
    <button type="submit">Search</button>
  </form>

  <c:if test="${not empty buses}">
    <h3>Results</h3>
    <table border="1" cellpadding="6">
      <tr>
        <th>From</th>
        <th>To</th>
        <th>Departure</th>
        <th>Arrival</th>
        <th>Available</th>
        <th>Book</th>
      </tr>
      <c:forEach var="b" items="${buses}">
        <tr>
          <td>${b.source}</td>
          <td>${b.destination}</td>
          <td>${b.departureTime}</td>
          <td>${b.arrivalTime}</td>
          <td>${b.availableSeats}</td>
          <td>
            <form method="post" action="<c:url value='/bookings/create'/>">
              <input type="hidden" name="busId" value="${b.id}" />
              <input type="number" name="seats" min="1" max="${b.availableSeats}" />
              <button type="submit">Book</button>
            </form>
          </td>
        </tr>
      </c:forEach>
    </table>
  </c:if>
</body>
</html>


