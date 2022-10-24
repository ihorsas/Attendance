import {createSelectWithOptions, getCall, postCall} from './utils.js';

export async function createAttendanceStudent() {
  let attendance = await getCall("attendance", document.getElementById('attendance').value)
  let student = await getCall("student", document.getElementById('student').value)
  const data = {
    id: {
      attendanceId: attendance["id"],
      studentId: student["id"],
    },
    attendance: attendance,
    student: student,
    date: document.getElementById('date').value,
    state: document.getElementById('state').value,
    comment: document.getElementById('comment').value,
  };

  console.log("Data to be saved in JSON:" + JSON.stringify(data));
  await postCall(data, "attendance-student", "created-attendance-student")
}

export async function createAttendanceStudentOptions(id) {
  let data = await getCall("attendance")
  let select = document.getElementById(id);
  console.log("Data for select: " + data)
  for (const obj of data) {
    let option = document.createElement("option");
    option.text = `${obj["subject"]["name"]}(${obj["teacher"]["firstName"]} ${obj["teacher"]["lastName"]}) ${obj["date"]}`;
    option.value = obj["id"];
    select.appendChild(option);
  }
}

document.addEventListener('load', createAttendanceStudentOptions("attendance"));
document.addEventListener('load', createSelectWithOptions(getCall("student"), "lastName", "student"));
document.getElementById("create-attendance-student").addEventListener('click', createAttendanceStudent);
