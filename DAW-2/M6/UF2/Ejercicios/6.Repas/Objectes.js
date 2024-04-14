const producte = {
    S124234G : {
    Descripcio: "Samarreta",
    preu : 45,
    colors : ["blau", "negre", "blanc"],
    stock : {
    "M":{"blau":5,"negre":10,"blanc":7},
    "L":{"blau":2,"negre":5,"blanc":1},
    "XL":{"blau":4,"negre":7,"blanc":0}
    }
    },
    P785745Y : {
    Descripcio: "Pantaló",
    preu : 84,
    colors : ["blau", "negre"],
    stock : {
    "M":{"blau":5,"negre":10},
    "L":{"blau":2,"negre":5},
    "XL":{"blau":4,"negre":7}
    }
    },
    A234578W : {
    Descripcio: "Abric",
    preu : 129,
    colors : ["blau", "verd"],
    stock : {
    "M":{"blau":1,"verd":0},
    "L":{"blau":7,"verd":15},
    "XL":{"blau":4,"verd":3}
    }
    }
};

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 1                     +\n"
           + "+-----------------------------------------------------+");
console.log(producte.S124234G.colors);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 2                     +\n"
           + "+-----------------------------------------------------+");
console.log(producte.S124234G.stock.M);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 3                     +\n"
           + "+-----------------------------------------------------+");
let suma2 = 0;
for (const prod in producte) {
    suma2 += producte[prod].stock.L.blau;
}
console.log(suma2);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 4                     +\n"
           + "+-----------------------------------------------------+");
let suma3 = 0;
for (const prod in producte) {
    for (const talla in producte[prod].stock)
    suma3 += producte[prod].stock[talla].blau;
}
console.log(suma3);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 5                     +\n"
           + "+-----------------------------------------------------+");

const nom = "Pere";
const cognom = "Garcia";
const client = {
nom : 'Ramon',
cognom : 'Llull',
naixement : '1232',
nomSencer : function(){
    return this.nom + " " + this.cognom;
}};
console.log(client.nomSencer()); 

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 6                     +\n"
           + "+-----------------------------------------------------+");
const cotxes = {
marques: ["Maserati","Ferrari","BMW"],
categoria : "Esportiu",
missatge : function() {
    const mq = [];
    const c = this;
    this.marques.forEach(function (marca) {
        m = marca + " es " + c.categoria;
        mq.push(m);
    });
    return mq;
}};
console.log(cotxes.missatge()); 

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 7                     +\n"
           + "+-----------------------------------------------------+");
const cotxes2 = {
marques: ["Maserati","Ferrari","BMW"],
categoria : "Esportiu",
missatge : function() {
    const mq = [];
    this.marques.forEach(marca => {
        m = marca + " es " + this.categoria;
        mq.push(m);
    });
    return mq;
}};
console.log(cotxes2.missatge()); 

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 8                     +\n"
           + "+-----------------------------------------------------+");
let keys = Object.keys(producte);
for (keys in producte){
    console.log(producte[keys]);
};