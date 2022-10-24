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
    <title>New attendance students form</title>
    <script type="module" src="js/attendanceStudents.js"></script>

</head>
<body>
<div>
    <h3><p>Select student for attendance</p></h3>
    <p>Attendance:</p>
    <select id="attendance"></select>
    <p>Student:</p>
    <select id="student"></select>
    <br><br>
    <p>Date:</p>
    <input type="date" id="date">
    <p>State:</p>
    <input type="text" id="state">
    <p>Comment:</p>
    <input type="text" id="comment">
    <br><br>
    <button id="create-attendance-student">Submit</button>
</div>
<div id="created-attendance-student"></div>
</body>
</html>