import {createSelectWithOptions, getCall, postCall} from './utils.js';

export async function createAttendance() {
  let teachers = await getCall("teacher", document.getElementById('teacher').value)
  let subject = await getCall("subject", document.getElementById('subject').value)
  console.log("subject in createAttendance: " + subject)
  const data = {
    date: document.getElementById('date').value,
    teacher: teachers,
    subject: subject,
  };

  console.log("Data to be saved:" + data);
  console.log("Data to be saved in JSON:" + JSON.stringify(data));
  await postCall(data, "attendance", "created-attendance")
}

document.addEventListener('load', createSelectWithOptions(getCall("subject"), "name", "subject"));
document.addEventListener('load', createSelectWithOptions(getCall("teacher"), "lastName", "teacher"));
document.getElementById("create-attendance").addEventListener('click', createAttendance);
