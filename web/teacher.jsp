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
    <title>New teacher form</title>
    <script type="module" src="js/teacher.js"></script>

</head>
<body>
<div>
    <h3><p>Enter new teacher</p></h3>
    <p>First name:</p>
    <input type="text" id="firstName">
    <p>Last name:</p>
    <input type="text" id="lastName">
    <p>Email:</p>
    <input type="text" id="email">
    <p>Birthday:</p>
    <input type="date" id="birthday">
    <br><br>
    <button id="create-teacher">Submit</button>
</div>
<div id="created-teacher"></div>
</body>
</html>