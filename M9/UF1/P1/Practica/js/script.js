function aplicarTema(){
    if (fosc){
        html.classList.add("clar");
        html.classList.remove("fosc");
        logoImg.setAttribute("src", "images/Logo.png");
    }else{
        html.classList.add("fosc");
        html.classList.remove("clar");
        logoImg.setAttribute("src", "images/Logo-Dark.png");
    }
}

function guardarLocalStorage(){
    localStorage.setItem("fosc", fosc.toString());
}

function carregarLocalStorage() {
    const foscGuardat = localStorage.getItem("fosc");
    if (foscGuardat !== null) {
        fosc = foscGuardat === "true";
        aplicarTema(fosc);
    }
}

const body = document.querySelector("body");
const html = document.querySelector("html");
const nav2 = document.querySelector(".nav2");
const logoImg = document.querySelector(".logo-icon");
const temaIcon = document.querySelector(".tema-icon");
const menuIcon = document.querySelector(".menu-icon");
let visibilitat = false;
let fosc = false;

carregarLocalStorage();

window.addEventListener("resize", () => {
    if (body.clientWidth > 1023) {
        nav2.style.display = "none";
    }else{
        nav2.style.display = visibilitat ? "block" : "none";
    }
});

menuIcon.addEventListener("click", () => {
    if (visibilitat) {
        nav2.style.display = "none";
        menuIcon.innerText = "";
    } else {
        nav2.style.display = "block";
        menuIcon.innerText = "";
    }
    visibilitat = !visibilitat;
});

temaIcon.addEventListener("click", () => {
    fosc = !fosc;
    aplicarTema();
    guardarLocalStorage();
});