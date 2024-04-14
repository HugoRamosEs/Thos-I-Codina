function generarAleatori(arrayAux) {
    // Genera dos files d'un array de manera aletaria, de tal manera que hi hagin sempre 4 "0" en cada linia.
    for (let i = 0; i < 2; i++) {
        let ceros = 0;
        while (ceros < 4) {
            for (let j = 0; j < 9; j++) {
                if (ceros < 4 && arrayAux[j][i] != 0) {
                    let aleatori = Math.floor(Math.random() * 2);
                    arrayAux[j][i] = aleatori;
                    if (aleatori == 0) {
                        ceros++;
                    }
                }
            }
        }
    }
}

function generarBingo() {
    // Generar array amb números aleatoris.
    let array = new Array(9);
    for (let i = 0; i < 9; i++) {
        array[i] = new Array(3);
    }
    for (let i = 0; i < 3; i++) {
        for (let j = 0; j < 9; j++) {
            let existeix = false;
            let numAleatori;
            let base = j * 10 + 1;
            while (!existeix) {
                numAleatori = Math.floor(Math.random() * 9) + base;
                if (!array[j].includes(numAleatori)) {
                    existeix = true;
                    array[j][i] = numAleatori;
                }
            }
        }
    }
    // Ordenar l'array amb les columnes ascendent i descendent.
    for (let i = 0; i < array.length; i++) {
        if (i % 2 === 0) {
            array[i].sort((a, b) => a - b);
        } else {
            array[i].sort((a, b) => b - a);
        }
    }
    // Generar array auxiliar.
    let arrayAux = new Array(9);
    for (let i = 0; i < 9; i++) {
        arrayAux[i] = new Array(3);
    }
    // Rellenar l'array auxiliar.
    generarAleatori(arrayAux);
    let iguals = true;
    while (iguals) {
        for (let j = 0; j < 9; j++) {
            if (arrayAux[j][0] != arrayAux[j][1]) {
                iguals = false;
            }
        }
        if (iguals) {
            generarAleatori(arrayAux);
        }
    }
    // Rellenar la tercera fila.
    let ceros3Fila = 0;
    // 1r es rellenen totes les caselles que buides de les files 1 i 2.
    for (let j = 0; j < 9; j++) {
        if (arrayAux[j][0] != 0 && arrayAux[j][1] != 0) {
            arrayAux[j][2] = 0;
            ceros3Fila++;
        }
    }
    // Posar de forma aleatoria tots els ceros que falten a la 3ra fila.
    while (ceros3Fila < 4) {
        for (let j = 0; j < 9; j++) {
            if (arrayAux[j][0] != 0 || arrayAux[j][1] != 0) {
                if (ceros3Fila < 4 && arrayAux[j][2] != 0) {
                    aleatori = Math.floor(Math.random() * 2);
                    arrayAux[j][2] = aleatori;
                    if (aleatori == 0) {
                        ceros3Fila++;
                    }
                }
            }
        }
    }
    // Cambiar els 0 per cadenes buides ("").
    for (let i = 0; i < 3; i++) {
        for (let j = 0; j < 9; j++) {
            if (arrayAux[j][i] === 0) {
                array[j][i] = "";
            }
        }
    }
    // Retornar l'array per crear el Bingo.
    return array;
}

function imprimirBingo(id, array){
    // Crear un template per imprimir el bingo, es a dir, generalo en HTML amb l'array generada.
    let template = `<div id="${id}"><table><thead><tr><th colspan="9">Bingo ${id}</th></tr></thead><tbody>`;
    for (let i = 0; i < 3; i++) {
        template += '<tr>';
        for (let j = 0; j < 9; j++) {
            if (array[j][i] === ""){
                template += `<td class="negre">${array[j][i]}</td>`;
            }else{
                template += `<td class="T${array[j][i]}">${array[j][i]}</td>`;
            }
        }
        template += '</tr>';
    }
    template += '</tbody></table></div>';
    contenedor.insertAdjacentHTML("beforeend", template);
}

function generarBoles() {
    // Crear l'array boles amb numeros del 0 al 88.
    const boles = new Array();
    for (let i = 0; i < 89; i++) {
        boles[i] = i + 1;
    }
    // Ordenar l'array de forma aleatoria.
    for (let i = boles.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        const temp = boles[i];
        boles[i] = boles[j];
        boles[j] = temp;
    }
    // Retornar l'array de les boles.
    return boles;
}

function extraureBola(arrayBoles, arrayTaula, arrayTaula2) {
    // Agafar un valor de l'array boles i fer la comparació amb la taula, si coincideixen agregar un estil a la casella.
    const bola = arrayBoles.pop();
    let trobada1 = false;
    let trobada2 = false;
    let div1 = document.getElementById("J1");
    let div2 = document.getElementById("J2");
    for (let i = 0; i < 3; i++) {
        for (let j = 0; j < 9; j++) {
            if (bola === arrayTaula[j][i]) {
                trobada1 = true;
                let td1 = div1.querySelector(".T" + arrayTaula[j][i]);
                if (td1) {
                    td1.classList.add("tdBola");
                }
            }
            if (bola === arrayTaula2[j][i]) {
                trobada2 = true;
                let td2 = div2.querySelector(".T" + arrayTaula2[j][i]);
                if (td2) {
                    td2.classList.add("tdBola");
                }
            }
        }
    }
    // Si la bola coinxideix en ambdues taules, aplica l'estil.
    if (trobada1 && trobada2) {
        return `<span class="bolaIgual">${bola}</span>`;
    } else if (trobada1 || trobada2) {
        // Si la bola coinxideix en una de les taules, aplica l'estil.
        return `<span class="bolaIgual">${bola}</span>`;
    } else {
        // Si la bola no coinxideix, s'aplica un estil neutral.
        return `<span class="bola">${bola}</span>`;
    }
}

function cantarLinia(div){
    // Verifica i mostra una alerta si es completa una línia a la taula (div), indicant el número de fila i l'ID de la taula, i després desactiva liniaCantada.
    let files = div.querySelectorAll("tbody tr");
    files.forEach((fila , index) => {
        let caselles = fila.querySelectorAll("td:not(.negre)");
        if ([...caselles].every(casella => casella.classList.contains("tdBola")) && liniaCantada == false) {
            setTimeout(function () {
                alert("Linia a la fila " + (index + 1) + " del bingo " + div.id);
            }, 50);
            liniaCantada = true;
        }
    });    
}

function cantarBingo(div){
    // Verifica si s'ha aconseguit un bingo dins de l'element div, i en cas afirmatiu, mostra un missatge d'alerta i realitza algunes accions addicionals com deshabilitar un element d'entrada.
    if (div){
        let caselles = div.querySelectorAll("table tbody td:not(.negre)");
        if ([...caselles].every(casella => casella.classList.contains("tdBola")) && bingoCantat == false) {
            setTimeout(function () {
                alert("Bingo " + div.id);
            }, 50);
            bingoCantat = true;
            input.disabled = true;
        }
    }
}

function actualitzarTemporizador() {
    // Genera un temporitzador progressiu.
    const tempsElement = document.getElementById("temps");
    segons++;
    if (segons === 60) {
        segons = 0;
        minuts++;
    }
    let segonsF = segons < 10 ? `0${segons}` : segons;
    let minutsF = minuts < 10 ? `0${minuts}` : minuts;
    tempsElement.innerText = `Temps: ${minutsF}:${segonsF}`;
    setTimeout(actualitzarTemporizador, 1000);
}

function contadorBoles(){
    // Es un contador de les boles extretes.
    let num = 0;
    let bolesSpan = bolesDiv.querySelectorAll("span");
    bolesSpan.forEach(span =>{
        if (span){
            num++;
        }
    });
    return num;
}

function informacio(){
    // Mostra un cartell amb l'informació per jugar al Bingo.
    let info = "+-----------------------------------------------------+\n"
    +          "+             INFORMACIÓ BINGO             +\n"
    +          "+-----------------------------------------------------+\n"
    +          "Informació per jugar al bingo correctament.\n\n"
    +          "Extreure Bola: Donar-li per extreure les boles del bombo, si surt\n"
    +          "una bola que hi estigui en un dels dos cartrons o estigui en els dos\n"
    +          "cartrons, es marcarà automaticament.\n\n"
    +          "Guanyador: El guanyador de la partida es verifica automaticament quan\n"
    +          "es completa el bingo en un dels dos cartrons. La linia també es verifica\n"
    +          "automaticament quan un dels dos cartrons completa la primera linia.\n\n"
    +          "Nous Cartrons: Per resetejar la partida, donar-li al botó.";
    alert(info);
}

function guardarLocalStorage() {
    // Guarda totes les variables necesaries, per despres carregar el localStorage.
    localStorage.setItem("taula", JSON.stringify(array));
    localStorage.setItem("taula2", JSON.stringify(array2));
    localStorage.setItem("arrayBoles", JSON.stringify(boles));
    localStorage.setItem("bolesExtraides", bolesDiv.innerHTML);
    localStorage.setItem("minuts", JSON.stringify(minuts));
    localStorage.setItem("segons", JSON.stringify(segons));
    localStorage.setItem("num", JSON.stringify(num));
    localStorage.setItem("bingoCantat", JSON.stringify(bingoCantat));
    localStorage.setItem("liniaCantada", JSON.stringify(liniaCantada));
}

function inicialitzar() { // Primera part al carregar el localStorage.
    // Inicialitza els valors amb el localStorage, en cas de que no hi hagi res, ho genera.
    let taulaObtinguda = JSON.parse(localStorage.getItem("taula"));
    array = taulaObtinguda ? taulaObtinguda : generarBingo();
    let taulaObtinguda2 = JSON.parse(localStorage.getItem("taula2"));
    array2 = taulaObtinguda2 ? taulaObtinguda2 : generarBingo();
    let arrayBolesObtingut = JSON.parse(localStorage.getItem("arrayBoles"));
    boles = arrayBolesObtingut ? arrayBolesObtingut : generarBoles();
    let minutsObtinguts = JSON.parse(localStorage.getItem("minuts"));
    minuts = minutsObtinguts ? minutsObtinguts : 0;
    let segonsObtinguts = JSON.parse(localStorage.getItem("segons"));
    segons = segonsObtinguts ? segonsObtinguts : 0;
    let numObtingut = JSON.parse(localStorage.getItem("num"));
    num = numObtingut ? numObtingut : 0;
    let bingoCantatObtingut = JSON.parse(localStorage.getItem("bingoCantat"));
    bingoCantat = bingoCantatObtingut ? bingoCantatObtingut : false;
    let liniaCantadaObtinguda = JSON.parse(localStorage.getItem("liniaCantada"));
    liniaCantada = liniaCantadaObtinguda ? liniaCantadaObtinguda : false;
}

function carregarBoles() { // Segona part al carregar el localStorage.
    // Carrega les boles guardades al localStorage.
    let div1 = document.getElementById("J1");
    let div2 = document.getElementById("J2");
    let bolesObtingudes = localStorage.getItem("bolesExtraides");
    if (bolesObtingudes) {
        bolesDiv.innerHTML = bolesObtingudes;
        setTimeout(function () {
            let spans = document.querySelectorAll(".bolaIgual");
            spans.forEach(span => {
                let valor = span.innerText;
                let td1 = div1.querySelector(".T" + valor);
                let td2 = div2.querySelector(".T" + valor);
                if (td1) {
                    td1.classList.add("tdBola");
                }
                if (td2){
                    td2.classList.add("tdBola");
                }
            });
        }, 10);
    }
}

function eliminarLocalStorage() {
    // Elimina totes les variables guardades en el localStorage.
    localStorage.removeItem("taula"); 
    localStorage.removeItem("taula2");
    localStorage.removeItem("arrayBoles");
    localStorage.removeItem("bolesExtraides");
    localStorage.removeItem("minuts");
    localStorage.removeItem("segons");
    localStorage.removeItem("num");
    localStorage.removeItem("bingoCantat");
    localStorage.removeItem("liniaCantada");
    location.reload();  // Torna a carregar la pàgina.
};
  
// Creació del div que contindrà les boles extretes.
const contenedor = document.getElementById("contenedor"); // agafar com a referencia el contenidor que contindrà tot HTML.
const bolesDiv = document.createElement("div"); // crear div que contindra totes boles extretes.
bolesDiv.setAttribute("id", "bolesDiv"); // afegir un atribut al bolesDiv.

// Inicialitzar les variables. Això ajudarà a la funció inicialitzar().
let array;
let array2;
let boles;
let segons;
let minuts;
let num;
let liniaCantada;
let bingoCantat;
inicialitzar();

// Creació dels cartons, botons i temporitzador.
let preTaula = `<div id="preTaula"><h1>M6.UF1. Pràctica 3</h1> <span id="temps"></span> </button> <input type="submit" id="info" name="info" value="Informació"></button></div>`
contenedor.insertAdjacentHTML("beforeend", preTaula);
let bingoImpres1 = imprimirBingo("J1", array);
let bingoImpres2 = imprimirBingo("J2", array2);
let botons = `<div id="botons"><input type="submit" id="extraure" name="extraure" value="Extreure Bola (${num})"> <input type="submit" id="eliminar" name="eliminar" value="Nous Cartrons"></button></div>`;
contenedor.insertAdjacentHTML("beforeend", botons);

// Funció que va actualitzant el temporitzador.
actualitzarTemporizador();

// Funció que carrega les boles del localStorage.
carregarBoles();

// Cada vegada que es clica al botó s'agrega a un div (boles), la bola generada per la funcio generarBoles, fins que l'array s'acabi.
let input = document.getElementById("extraure");
let eliminar = document.getElementById("eliminar");
let info = document.getElementById("info");
let bolesAgotades = false;
let div1 = document.getElementById("J1");
let div2 = document.getElementById("J2");
contenedor.appendChild(bolesDiv);
input.addEventListener("click", (e) => {
    e.preventDefault();
    if (!bolesAgotades) {
        // Crea una bola amb la funció i l'agrega al div on es posen totes les boles extretes.
        const bola = extraureBola(boles, array, array2);
        bolesDiv.innerHTML = bola + bolesDiv.innerHTML;
        if (boles.length === 0) {
            bolesAgotades = true;
            input.disabled = true;
        }
        // Agafa tots els td que contenen tdBola i si es cumpleix la linia, es canta.
        cantarLinia(div1);
        cantarLinia(div2);

        // Agafa tots els td que contenen tdBola de la taula i si es cumpleix el bingo, es canta.
        cantarBingo(div1);
        cantarBingo(div2);
    }
    // Actualitza el contador de les boles extretes.
    num = contadorBoles();
    input.value = `Extreure Bola (${num})`;
    // Cada vegada que es pulsa el botó de extreure bola, es guarda l'estat de la pàgina.
    guardarLocalStorage();
});

// Mostra l'informació pulsant el botó.
info.addEventListener("click", (e) =>{
    e.preventDefault();
    informacio();
});

// Eliminar el localStorage pulsant el botó.
eliminar.addEventListener("click", (e) =>{
    e.preventDefault();
    eliminarLocalStorage();
});