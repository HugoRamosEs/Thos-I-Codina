// PART 1
// Exercici 1
const contenedor = document.getElementById("contenedor");
const h1 = document.createElement("h1");
const titol = document.createTextNode("M6.UF1. Pràctica 2");

const table = document.createElement("table");
    table.setAttribute("id", "taula");

const thead = document.createElement("thead");
const tr = document.createElement("tr");

contenedor.appendChild(h1);
h1.appendChild(titol);
contenedor.appendChild(table);
table.appendChild(thead);
thead.appendChild(tr);

const headItem = ['Codi','Imatge', 'Descripció', 'Quantitat', 'Preu', 'Import', ''];
headItem.forEach(element => {
    const th = document.createElement("th")
    const text = document.createTextNode(element);
    tr.appendChild(th);
    th.appendChild(text);
});

// Exercici 2, 3, 4
const products = [
    [101,'steelseires-arctis-5-rgb-negros.webp', 'Steelseires Artics 5 Auriculars Gaming RGB Negres', 108.59],
    [102,'1202-agfa-photo-ac7000-camara-deportiva-16mp.webp', 'Agfa Photo AC7000 Càmera Esportiva 16MP', 119.50],
    [103,'1920-xiaomi-poco-m3-pro-5g-4-64gb-amarillo-libre.webp', 'Xiaomi POCO M3 Pro 5G 4/64GB Groc LLiure', 315.99],
    [104,'logitech.webp', 'Logitech G Saitek X52 Flight Control System Sistema de Control de Vol', 158.60],
    [105,'115-msi-raider.webp', 'MSI Raider GE77HX 12UGS-020ES Intel Core i9-12900HX/64GB/2TB SSD/RTX 3070Ti/17.3"', 3599.00]
];

let template = "<tbody>"
    products.forEach(element => {
        template += "<tr>"
        template += `<td class="codi">${element[0]}</td>`
        template += `<td><img src="img/${element[1]}"></td>`
        template += `<td class="desc">${element[2]}</td>`
        template += `<td><input type="number" class="quantitat" name="${element[0]}" min="0" max="10" value="1"></td>`
        template += `<td class="preu">${element[3].toFixed(2)}</td>`
        template += `<td class="import">${element[3].toFixed(2)}</td>`
        template += `<td><button class="eliminar" name="eliminar">X</button></td>`
        template += "</tr>";
    });
template += "<tr>"
template += `<td colspan="4"></td>`
template += `<td id="iT">Import total:</td>`
template += `<td id="importTotal"></td>`
template += "</tr>";
template += "</tbody";
table.insertAdjacentHTML("beforeend", template);


// Exercici 5
table.insertAdjacentHTML("afterend", '<button id="buidar" name="buidar">Buidar Carretó</button>');

// PART 2
// Exercici 6
const botonsEliminar = document.querySelectorAll(".eliminar");
botonsEliminar.forEach(boto => {
    boto.addEventListener("click", (e) => {
        e.preventDefault();
        const trEliminar = e.target.closest("tr");
        trEliminar.remove();
        calcularImportTotal();
        guardarLocalStorage();
    });
});

// Exercici 7
const botoBuidar = document.getElementById("buidar");
botoBuidar.addEventListener("click", (e) =>{
    e.preventDefault();
    table.remove();
    document.getElementById("cercador").remove();
    document.getElementById("cercar").remove();
    document.getElementById("reset").remove();
    botoBuidar.remove();
    contenedor.insertAdjacentHTML("beforeend", "<h2>No hi ha productes al carretó</h2>");
    guardarLocalStorage();
});

// PART 3
const productes = {};

// Exercici 8
function calcularImportEspecific(input){
    input.addEventListener("input", (e)=>{
        const tr = e.target.closest("tr");
        const preuElm = tr.querySelector(".preu");
        const importElm = tr.querySelector(".import");
        productes[e.target.name] = e.target.value;
        if(input.value <= 0){
            tr.remove();
            calcularImportTotal();
            guardarLocalStorage();
        }else{
            const quantitat = parseInt(e.target.value);
            const preu = parseFloat(preuElm.textContent);
            const importCalculat = quantitat * preu;
            importElm.textContent = importCalculat.toFixed(2);
            calcularImportTotal();
            guardarLocalStorage();
        }
    });
}

const inputs = document.querySelectorAll('.quantitat');
inputs.forEach(element => {
    calcularImportEspecific(element);
});

// Exercici 9
function calcularImportTotal(){
    const importElms = document.querySelectorAll(".import");
    const importTotal = document.getElementById("importTotal");
    let total = 0;

    importElms.forEach(i =>{
        total += parseFloat(i.textContent);
    });

    importTotal.textContent = total.toFixed(2);
}

calcularImportTotal();

// Exercici 10
function guardarLocalStorage() {
    localStorage.setItem("productes", JSON.stringify(productes));
}

/*
    Al carregar el localStorage funciona correctament, pero hi ha un problema que no he pogut resoldre. Aquest es que si no fas un canvi en l'input tras recarregar la pàgina, l'import
    del producte no canvia, i per tant tampoc canvia l'import total. Perque funcioni, has de carregar la pagina, carregará el localStorage, i per veure correctament l'import recalculat
    i l'import total recalculat, has de pujar o baixar un numero dels inputs, dona igual de quin producte.
*/
function carregarLocalStorage(){
    const productesObtinguts = JSON.parse(localStorage.getItem("productes"));
    console.log("Productes:", productesObtinguts);
    const inputList = document.getElementsByTagName("input");

    if (productesObtinguts) {
        for (let i = 0; i < inputList.length; i++) {
            const key = inputList[i].name
            if (key in productesObtinguts) {
                inputList[i].value = productesObtinguts[key];
                if (inputList[i].value === "0") {
                    const tr = inputList[i].closest("tr");
                    if (tr) {
                        tr.style.display = "none";
                    }
                }
            }
        };
    }
}

carregarLocalStorage();

// Exercici 11
/*
    La funcionalitat que he afegit al programa es una barra de cerca, per poder cercar un producte que hi sigui al carretó. La funcionalitat consta de 1 input que es per introduir el text i 
    2 botons. El botó de cerca el que fa es comparar el que hi ha escrit al cercador amb la descripció del producte. Si existeix mostra la fila, sino mostra no mostra res. El botó de reset el
    que fa es resetejar la cerca, i tornar a mostrar tots els productes del carretó i vaciar el cercador.
*/ 
h1.insertAdjacentHTML("afterend", '<div><input type="text" id="cercador" placeholder="Cercar un producte..."><button id="cercar">Cercar</button><button id="reset">Resetejar</button></div>');
const cercador = document.getElementById("cercador");
const botoCercar = document.getElementById("cercar");
const botoReset = document.getElementById("reset");

botoCercar.addEventListener("click", (e) => {
    e.preventDefault();
    const text = cercador.value.toUpperCase();
    const productes = document.querySelectorAll("tbody tr");
    productes.forEach(p => {
        const desc = p.querySelector(".desc").textContent.toUpperCase();
        const visibilitat = desc.includes(text) ? "" : "none";
        p.style.display = visibilitat;
    });
});

botoReset.addEventListener("click", (e) => {
    e.preventDefault();
    const productes = document.querySelectorAll("tbody tr");
    productes.forEach(p => {
        p.style.display = "";
    });
    cercador.value = "";
});
