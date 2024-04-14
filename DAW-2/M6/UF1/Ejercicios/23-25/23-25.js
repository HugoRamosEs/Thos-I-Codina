console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 23                    +\n"
           + "+-----------------------------------------------------+");
const input = document.createElement("input");
input.setAttribute("type", "email");
input.setAttribute("name", "email");
input.setAttribute("id", "email");
input.setAttribute("class", "form-element");
input.setAttribute("required", "required");
input.setAttribute("placeholder", "Please enter a valid email account");

const formulari = document.getElementById("formulari");
formulari.appendChild(input);

input.removeAttribute("id");
const formulariNoId = document.getElementById("formulari");
formulariNoId.appendChild(input);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 24                    +\n"
           + "+-----------------------------------------------------+");
const form = 
`<form action="#" method="post" id="user-data" name="user-data" novalidate>
    <input type="email" name="email" class="form-element" required="required" placeholder="Please enter a valid email account"/>
    <button type="submit" id="send">Enviar</button>
</form>`;
const formulari2 = document.getElementById("formulari2");
formulari2.insertAdjacentHTML("afterbegin", form);

// FORMA AMB APPENDCHILD

//const form = document.createElement("form");
//form.setAttribute("action", "#");
//form.setAttribute("method", "post");
//form.setAttribute("id", "user-data");
//form.setAttribute("name", "user-data");
//form.setAttribute("novalidate", "");
//const button = document.createElement("button")
//button.setAttribute("type", "submit");
//button.setAttribute("id", "send");
//const text = document.createTextNode("Enviar");

//const formulari2 = document.getElementById("formulari2");
//formulari2.appendChild(form);
//form.appendChild(input);
//form.appendChild(button);
//button.appendChild(text);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 25                    +\n"
           + "+-----------------------------------------------------+");
const menu = ['home','about','products','contact']
let template = "<nav><ul>"
    menu.forEach(element => {
       template += ` <li>${element}</li> `
    });
template += "</ul></nav>";
document.querySelector("#menu").insertAdjacentHTML("beforeend", template);