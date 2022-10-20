<%--
  Created by IntelliJ IDEA.
  User: isas
  Date: 12.10.2022
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <title>New student form</title>
  <script type="module" src="js/student.js"></script>

</head>
<body>
 <h3><p>Enter new student</p></h3>
  <p>First name:</p>
  <input type="text" id="firstName">
  <p>Last name:</p>
  <input type="text" id="lastName">
  <p>Email:</p>
  <input type="text" id="email">
  <p>Birthday:</p>
  <input type="date" id="birthday">
  <p>Joining date:</p>
  <input type="date" id="joiningDate">
  <br><br>
  <button id="create-student">Submit</button>
  <div id="created-student"></div>
</body>
</html>