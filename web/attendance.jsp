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
    <title>New attendance form</title>
    <script type="module" src="js/attendance.js"></script>

</head>
<body>
<div>
    <h3><p>Enter new attendance</p></h3>
    <p>Date:</p>
    <input type="date" id="date">
    <p>Subject:</p>
    <select id="subject"></select>
    <p>Teacher:</p>
    <select id="teacher"></select>
    <br><br>
    <button id="create-attendance">Submit</button>
</div>
<div id="created-attendance"></div>
</body>
</html>