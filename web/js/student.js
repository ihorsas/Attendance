import { postCall } from './utils.js';

export async function createStudent() {
  const data = {
    firstName: document.getElementById('firstName').value,
    lastName: document.getElementById('lastName').value,
    email: document.getElementById('email').value,
    birthday: document.getElementById('birthday').value,
    joiningDate: document.getElementById('joiningDate').value
  };

  console.log("Data to be saved:" + data);
  console.log("Data to be saved in JSON:" + JSON.stringify(data));
  postCall(data, "student", "created-student")
}

document.getElementById("create-student").addEventListener('click', createStudent);
