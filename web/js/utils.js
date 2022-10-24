export function showCreatedObject(data, name, id) {
  const div = document.querySelector(`#${id}`);
  const elementHeader = document.createElement("h2");
  elementHeader.innerText = `\nCreated ${name}:`;
  div.append(elementHeader);

  for (const [key, value] of Object.entries(data)) {
    let element = document.createElement("p");
    element.innerText = `\n${name} ${key}: ${JSON.stringify(value)}`
    div.append(element);
  }
}

/**
 * @param {string} nameField
 * @param data
 * @param id
 */
export async function createSelectWithOptions(data, nameField, id) {
  let select = document.getElementById(id);
  data = await data;
  console.log("Data for select: " + data)
  for (const obj of data) {
    let option = document.createElement("option");
    option.text = obj[nameField];
    option.value = obj["id"];
    select.appendChild(option);
  }
}

// TODO: do not rely on full address instead use relative path ex: /student
export async function postCall(data, name, createdObjId) {
  await fetch(`http://localhost:8080/Attendance_war_exploded/${name}`, {
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

export function getUrl(name, id) {
  let query = id !== undefined ? `id=${id}` : "";
  return `http://localhost:8080/Attendance_war_exploded/${name}?` + query
}

/**
 * @param {string} name
 * @param id
 * @returns {string}
 */
export async function getCall(name, id) {
  let result;

  await fetch(getUrl(name, id), {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
  })
      .then((response) => response.json())
      .then((data) => {
        console.log('Success:', data);
        result = data;
      })
      .catch((error) => {
        console.error('Error:', error);
      });
  return result;
}