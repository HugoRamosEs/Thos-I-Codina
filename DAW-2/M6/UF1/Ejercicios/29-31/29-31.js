console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 29                    +\n"
           + "+-----------------------------------------------------+");
// HTML
const input1 = document.createElement("input");
    input1.setAttribute("style", "margin: 5px");
    input1.setAttribute("type", "text");
    input1.setAttribute("name", "text1");
    input1.setAttribute("id", "text1");
    input1.setAttribute("class", "form-element");
    input1.setAttribute("required", "required");
    input1.setAttribute("placeholder", "Introdueix un número...");

const opcions = ['+', '-', '*', '/', '^'];
let selector = `<select id="selector" name="selector">`
    opcions.forEach(element => {
        selector += ` <option>${element}</option> `
    });
selector += "</select>";

const input2 = document.createElement("input");
    input2.setAttribute("style", "margin: 5px");
    input2.setAttribute("type", "text");
    input2.setAttribute("name", "text2");
    input2.setAttribute("id", "text2");
    input2.setAttribute("class", "form-element");
    input2.setAttribute("required", "required");
    input2.setAttribute("placeholder", "Introdueix un número...");

const igual = document.createTextNode("=");

const input3 = document.createElement("input");
    input3.setAttribute("style", "margin: 5px");
    input3.setAttribute("type", "text");
    input3.setAttribute("name", "text3");
    input3.setAttribute("id", "text3");
    input3.setAttribute("class", "form-element");
    input3.setAttribute("placeholder", "Resultat...");
    input3.setAttribute("readonly", "readonly");

const saltLinia = document.createElement("br");

const button1 = document.createElement("button");
    button1.setAttribute("style", "margin: 5px");
    button1.setAttribute("type", "submit");
    button1.setAttribute("id", "calcula");

const text1 = document.createTextNode("Calcula");

const button2 = document.createElement("button");
    button2.setAttribute("style", "margin: 5px");
    button2.setAttribute("type", "submit");
    button2.setAttribute("id", "reset");

const text2 = document.createTextNode("Reseteja");

const formCalculadora = document.getElementById("calculadora");
    formCalculadora.appendChild(input1);
    document.querySelector("#calculadora").insertAdjacentHTML("beforeend", selector);
    formCalculadora.appendChild(input2);
    formCalculadora.appendChild(igual);
    formCalculadora.appendChild(input3);
    formCalculadora.appendChild(saltLinia);
    formCalculadora.appendChild(button1);
    button1.appendChild(text1);
    formCalculadora.appendChild(button2);
    button2.appendChild(text2);

// FUNCIONS
function reseteja(e) {
    e.preventDefault();
    const op1 = document.getElementById("text1");
    const op2 = document.getElementById("text2");
    const resultat = document.getElementById("text3");

    op1.value = "";
    op2.value = "";
    resultat.value = "";
}

function calcula(e){
    e.preventDefault();
    const op1 = Number(document.getElementById("text1").value.replace(',', '.'));
    const op2 = Number(document.getElementById("text2").value.replace(',', '.'));
    const simbol = document.getElementById("selector").value;
    const resultat = document.getElementById("text3");
    let operacio = 0;

    switch (simbol) {
        case '+':
            operacio = op1 + op2;
            break;
        case '-':
            operacio = op1 - op2;
            break;
        case '*':
            operacio = op1 * op2;
            break;
        case '/':
            operacio = op1 / op2;
            break;
        case '^':
            operacio = Math.pow(op1, Math.trunc(op2));
            break;
        default:
          console.log("Operador invàlid");
          return;
    }

    if (isNaN(operacio)) {
        resultat.value = "Error: Not a Number";
        resultat.style.color = "red";
    }else if (!isFinite(operacio)){
        resultat.value = "Error: Infinity";
        resultat.style.color = "red";
    }else {
        resultat.value = operacio.toFixed(2);
        resultat.style.color = "black";
    }
}

// EVENTS
button1.addEventListener("click", calcula);
button2.addEventListener("click", reseteja);
      
console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 30                    +\n"
           + "+-----------------------------------------------------+");
const emails = [
    "p.escosa@gmail.com",
    "j.garcia@info.yahoo.es",
    "r.esteban@sales.gmail.com",
    "a.gomez@gmail.es",
    "l.mesa@gmail.com",
    "t.sants@hotmail.es",
    "v.ros@hotmail.com"
];
let template = "<nav><ul>"
    emails.forEach(element => {
       template += ` <li>${element}</li> `
    });
template += "</ul></nav>";

const email = document.createElement("input");
    email.setAttribute("type", "email");
    email.setAttribute("name", "email");
    email.setAttribute("id", "email");
    email.setAttribute("class", "form-element");
    email.setAttribute("required", "required");
    email.setAttribute("placeholder", "Introdueix un email...");

const long = document.createTextNode("Longitud substring usuari = ");
const tld = document.createTextNode("Tipus TLD = ");
const nouDomini = document.createTextNode("Email amb nou domini = ");

const inputLong = document.createElement("input");
    inputLong.setAttribute("style", "margin: 5px");
    inputLong.setAttribute("type", "text");
    inputLong.setAttribute("name", "long");
    inputLong.setAttribute("id", "long");
    inputLong.setAttribute("class", "form-element");
    inputLong.setAttribute("placeholder", "Longitud...");
    inputLong.setAttribute("readonly", "readonly");

const inputTld = document.createElement("input");
    inputTld.setAttribute("style", "margin: 5px");
    inputTld.setAttribute("type", "text");
    inputTld.setAttribute("name", "tld");
    inputTld.setAttribute("id", "tld");
    inputTld.setAttribute("class", "form-element");
    inputTld.setAttribute("placeholder", "TLD...");
    inputTld.setAttribute("readonly", "readonly");

const inputNouDomini = document.createElement("input");
    inputNouDomini.setAttribute("style", "margin: 5px");
    inputNouDomini.setAttribute("type", "text");
    inputNouDomini.setAttribute("name", "nouDomini");
    inputNouDomini.setAttribute("id", "nouDomini");
    inputNouDomini.setAttribute("class", "form-element");
    inputNouDomini.setAttribute("placeholder", "Email amb nou domini...");
    inputNouDomini.setAttribute("readonly", "readonly");

const executa = document.createElement("button");
    executa.setAttribute("type", "submit");
    executa.setAttribute("id", "executa");

const textExecuta = document.createTextNode("Executa");

const reset = document.createElement("button");
    reset.setAttribute("style", "margin: 5px");
    reset.setAttribute("type", "submit");
    reset.setAttribute("id", "reset2");

const textReseteja = document.createTextNode("Reseteja");

const salt1 = document.createElement("br");
const salt2 = document.createElement("br");
const salt3 = document.createElement("br");
const salt4 = document.createElement("br");

const formEmail = document.getElementById("emailForm");
    formEmail.appendChild(email);
    formEmail.appendChild(salt1);
    formEmail.appendChild(long);
    formEmail.appendChild(inputLong);
    formEmail.appendChild(salt2);
    formEmail.appendChild(tld);
    formEmail.appendChild(inputTld);
    formEmail.appendChild(salt3);
    formEmail.appendChild(nouDomini);
    formEmail.appendChild(inputNouDomini);
    formEmail.appendChild(salt4);
    formEmail.appendChild(executa);
    executa.appendChild(textExecuta);
    formEmail.appendChild(reset);
    reset.appendChild(textReseteja);
    document.querySelector("#emails").insertAdjacentHTML("beforeend", template);

function reseteja2(e) {
    e.preventDefault();
    const email = document.getElementById("email");
    const long = document.getElementById("long");
    const tld = document.getElementById("tld");
    const nouDomini = document.getElementById("nouDomini");

    email.value = "";
    long.value = "";
    tld.value = "";
    nouDomini.value = "";
}

function executar(e) {
    e.preventDefault();
    const emailInput = document.getElementById("email").value;
    const longInput = document.getElementById("long");
    const tldInput = document.getElementById("tld");
    const nouDominiInput = document.getElementById("nouDomini");
    const emailsContainer = document.getElementById("emails");

    let index = emailInput.indexOf("@");
    let index2 = emailInput.indexOf(".");
    let long2 = emailInput.substring(0, index);
    let numLong = long2.length;
    longInput.value = numLong;

    let lastIndex = emailInput.lastIndexOf(".");
    let tld2 = emailInput.substring(lastIndex + 1);
    tldInput.value = tld2;

    let nouDomini = long2 + "@iesthosicodina." + tld2;
    nouDominiInput.value = nouDomini;

    const comEmails = emails.filter((email) => email.endsWith("gmail.com"));
    const esEmails = emails.filter((email) => email.endsWith(".es"));

    let emailsCom = "<nav><ul>";
    comEmails.forEach((element) => {
        emailsCom += ` <li>${element}</li> `;
    });
    emailsCom += "</ul></nav>";

    let emailsEs = "<nav><ul>";
    esEmails.forEach((element) => {
        emailsEs += ` <li>${element}</li> `;
    });
    emailsEs += "</ul></nav>";

    emailsContainer.innerHTML = emailsCom + emailsEs;
}

executa.addEventListener("click", executar);
reset.addEventListener("click", reseteja2);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 31                    +\n"
           + "+-----------------------------------------------------+");
const dataActual = new Date(Date.now()).toString();
const data = document.createElement("p");
    data.setAttribute("id", "data")
    data.textContent = dataActual;

const divData = document.getElementById("canviFormat");
    divData.appendChild(data);

function canviarFormat(e) {
    e.preventDefault();
    const data = document.getElementById("data");
    
    if (data.textContent === new Date(Date.now()).toLocaleString()) {
        data.textContent = new Date(Date.now()).toString();
        dataActual = new Date(Date.now()).toString();
    }else {
        data.textContent = new Date(Date.now()).toLocaleString();
        dataActual = new Date(Date.now()).toLocaleString();
    }
}

divData.addEventListener("dblclick", canviarFormat);

       

