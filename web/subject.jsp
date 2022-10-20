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
    <title>New subject form</title>
    <script type="module" src="js/subject.js"></script>

</head>
<body>
<div>
    <h3><p>Enter new subject</p></h3>
    <p>Name:</p>
    <input type="text" id="name">
    <p>Credits:</p>
    <input type="number" id="credit">
    <br><br>
    <button id="create-subject">Submit</button>
</div>
<div id="created-subject"></div>
</body>
</html>