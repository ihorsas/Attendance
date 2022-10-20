import { postCall } from './utils.js';

export async function createTeacher() {
  const data = {
    firstName: document.getElementById('firstName').value,
    lastName: document.getElementById('lastName').value,
    email: document.getElementById('email').value,
    birthday: document.getElementById('birthday').value,
  };

  console.log("Data to be saved:" + data);
  console.log("Data to be saved in JSON:" + JSON.stringify(data));
  postCall(data, "teacher", "created-teacher")
}

document.getElementById("create-teacher").addEventListener('click', createTeacher);
