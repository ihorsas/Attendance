import { postCall } from './utils.js';

export async function createSubject() {
  const data = {
    name: document.getElementById('name').value,
    credit: document.getElementById('credit').value
  };

  console.log("Data to be saved:" + data);
  console.log("Data to be saved in JSON:" + JSON.stringify(data));
  postCall(data, "subject", "created-subject")
}

document.getElementById("create-subject").addEventListener('click', createSubject);
