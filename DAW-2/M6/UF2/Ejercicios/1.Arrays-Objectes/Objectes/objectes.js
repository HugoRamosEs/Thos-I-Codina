// 1. A partir del següent Object realitza els exercicis.
const producte = {
    S124234G: {
        Descripcio: "Samarreta",
        preu: 45,
        colors: ["blau", "negre", "blanc"],
        stock: {
            "M": { "blau": 5, "negre": 10, "blanc": 7 },
            "L": { "blau": 2, "negre": 5, "blanc": 1 },
            "XL": { "blau": 4, "negre": 7, "blanc": 0 }
        }
    },
    P785745Y: {
        Descripcio: "Pantaló",
        preu: 84,
        colors: ["blau", "negre"],
        stock: {
            "M": { "blau": 5, "negre": 10 },
            "L": { "blau": 2, "negre": 5 },
            "XL": { "blau": 4, "negre": 7 }
        }
    },
    A234578W: {
        Descripcio: "Abric",
        preu: 129,
        colors: ["blau", "verd"],
        stock: {
            "M": { "blau": 1, "verd": 0 },
            "L": { "blau": 7, "verd": 15 },
            "XL": { "blau": 4, "verd": 3 }
        }
    }
};

// 1. En quants colors està disponible l’article S124234G.
console.log("+-----------------------------------------------------+\n"
          + "+                      EXERCICI 1.1                   +\n"
          + "+-----------------------------------------------------+");
console.log(producte.S124234G.colors);

// 2. El nombre de samarretes de color blanc de la talla M de l'article S124234G.
console.log("+-----------------------------------------------------+\n"
          + "+                      EXERCICI 1.2                   +\n"
          + "+-----------------------------------------------------+");
console.log(producte.S124234G.stock.M.blanc);

// 3. La suma de les unitats de la talla L de color blau dels tres articles.
console.log("+-----------------------------------------------------+\n"
          + "+                      EXERCICI 1.3                   +\n"
          + "+-----------------------------------------------------+");
let suma3 = 0;
for (const prod in producte) {
    suma3 += producte[prod].stock.L.blau;
}
console.log(suma3);

// 4. La suma de les unitats de totes les talles de color blau dels tres articles.
console.log("+-----------------------------------------------------+\n"
          + "+                      EXERCICI 1.4                   +\n"
          + "+-----------------------------------------------------+");
let suma4 = 0;
for (const prod in producte) {
    for (const talla in producte[prod].stock)
    suma4 += producte[prod].stock[talla].blau;
}
console.log(suma4);

// 2. Crea el mètode nomSencer() que retorni el nom i cognom de l'objecte client.
console.log("+-----------------------------------------------------+\n"
          + "+                      EXERCICI 2                     +\n"
          + "+-----------------------------------------------------+");
const nom = "Pere";
const cognom = "Garcia";
const client = {
    nom : 'Ramon',
    cognom : 'Llull',
    naixement : '1232',
    nomSencer : function(){
        return this.nom + " " + this.cognom;
    }
};
console.log(client.nomSencer());

// 3. Donat aquest objecte, crea el codi del mètode missatge perquè mostri per consola:
    // Maserati es un Esportiu
    // Ferrari es un Esportiu
    // BMW es un Esportiu
console.log("+-----------------------------------------------------+\n"
          + "+                      EXERCICI 3                     +\n"
          + "+-----------------------------------------------------+");
const cotxes3 = {
    marques: ["Maserati","Ferrari","BMW"],
    categoria : "Esportiu",
    missatge : function() {
        // Introduir codi. Utilitza el mètode forEach()
        const msg = [];

        // SENSE FUNCIÓ DE FLETXA
        // const that = this;
        // this.marques.forEach(function (marca) {
        //     msg.push(marca + " " + that.categoria);
        // });

        // AMB FUNCIÓ DE FLETXA (Millor així, perquè no es perd la referència del this)
        this.marques.forEach(marca => {
            msg.push(marca + " " + this.categoria);
        });
        return msg;
    }
}
console.log(cotxes3.missatge());

// 4. Repeteix l'exercici anterior aquesta vegada utilitzant la funció fletxa (=>) per definir el mètode
console.log("+-----------------------------------------------------+\n"
          + "+                      EXERCICI 4                     +\n"
          + "+-----------------------------------------------------+");
const cotxes4 = {
    marques: ["Maserati","Ferrari","BMW"],
    categoria : "Esportiu",
    missatge : () => {
        const msg = [];
        cotxes4.marques.forEach(marca => {
            msg.push(marca + " " + cotxes4.categoria);
        });
        return msg;
    }
}
console.log(cotxes4.missatge());

// 5. Veure aquests mètodes d'Object:
console.log("+-----------------------------------------------------+\n"
          + "+                      EXERCICI 5                     +\n"
          + "+-----------------------------------------------------+");
console.log(Object.entries(producte));
console.log(Object.keys(producte));
console.log(Object.values(producte));

// 6. Per iterar Objects:
    // 1. for...in
    // 2. Recorrent l'array generat per Object.keys()
console.log("+-----------------------------------------------------+\n"
          + "+                      EXERCICI 6                     +\n"
          + "+-----------------------------------------------------+");
let keys = Object.keys(producte);
for (keys in producte){
    console.log(producte[keys]);
}    