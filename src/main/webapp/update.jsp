<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
       <h2>ENTER THE RESERVATION ID WHERE YOU WANT AN UPDATE </h2>
       <br>
       Reservation ID: <input type="number" name="resID"> <br> <br>


        <h2>PLEASE FILL THE DETAILS BELOW</h2>
        Name: <input type="text" name="name1"> <br> <br>
		contact: <input type="text" name="contact1"> <br> <br>
		room no: <input type="number" name="room1"> <br> <br>
		<input type="submit" value="Update now">
</form>

</body>
</html>