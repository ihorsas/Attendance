export function showCreatedObject(data, name, id) {
  const div = document.querySelector(`#${id}`);
  const elementHeader = document.createElement("h2");
  elementHeader.innerText = `\nCreated ${name}:`;
  div.append(elementHeader);

  for (const [key, value] of Object.entries(data)) {
    let element = document.createElement("p");
    element.innerText = `\n${name} ${key}: ${value}`
    div.append(element);
  }
}

// TODO: do not rely on full address instead use relative path ex: /student
export function postCall(data, name, createdObjId) {
  fetch(`http://localhost:8080/Attendance_war_exploded/${name}`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  })
      .then((response) => response.json())
      .then((data) => {
        console.log('Success:', data);
        showCreatedObject(data, name, createdObjId);
      })
      .catch((error) => {
        console.error('Error:', error);
      });
}