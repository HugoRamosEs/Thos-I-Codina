// 1. Crea una funció constructora Llibres() amb els següents paràmetres.
console.log("+-----------------------------------------------------+\n"
          + "+                      EXERCICI 1                     +\n"
          + "+-----------------------------------------------------+");
function Llibres(titol, pagines, tematica, nomAutor, CognomAutor) {
    this.titol = titol;
    this.pagines = pagines;
    this.tematica = tematica;
    this.nomAutor = nomAutor;
    this.CognomAutor = CognomAutor;
    this.valoracio = 0; // Afegit al punt 3.
}
    // 1. Un mètode info() que mostri la informació del llibre emmagatzemada en els paràmetres. Crea una instància que mostri per exemple:
    // “El Quijote de la Mancha, 650 pàg. Novel·la, Miguel Cervantes”
    Llibres.prototype.info = function() {
        console.log(this.titol + ", " + this.pagines + " pàg. " + this.tematica + ", " + this.nomAutor + " " + this.CognomAutor);
    }
    const llibre1 = new Llibres("El Quijote de la Mancha", 650, "Novel·la", "Miguel", "Cervantes");
    llibre1.info();
    console.log("\n");

    // 2. Una propietat valoracio, i un mètode rating() que mostri el titol del llibre i propietat valoracio. Crea dues instància de Llibres() i comprova que es pot aplicar rating() ambdues.
    Llibres.prototype.rating = function() {
        Llibres.prototype.valoracio = Math.floor(Math.random() * 5) + 1;
        console.log("Titol: " + this.titol + ", Valoració: " +  Llibres.prototype.valoracio + "/5");
    }
    const llibre2 = new Llibres("Memorias de Idhún I", 560, "Literatura Fantástica", "Laura", "Gallego");
    const llibre3 = new Llibres("Sangre y Cenizas", 672, "Literatura Fantástica", "Jennifer", "L. Armentrout");
    llibre2.rating();
    llibre3.rating();

    /*  3. Crea una propietat valoracio en les “own properties” de la funció constructora Llibres i mostra com afecta a les instàncies creades en el punt anterior. Explica el motiu.
        Una vegada creada la propietat valoració en les own properties, aquesta agafa prioritat respecte a les propietats del prototype, llavors es posa el valor assignat al constructor.
    */
    console.log("\n")
    console.log(llibre2);
    console.log(llibre3);

    // 4. Mitjançant hasOwnProperty() o propertyIsEnumerable():
        // Mostra les “own properties” d’una de les instàncies creades en el punt 2.
        hiEsProperty = false;
        for (const prop in llibre2){
            if (llibre2.hasOwnProperty(prop)){
                hiEsProperty = true;
            }
        }
        console.log("\nOwn Properties: " + hiEsProperty);

        // Mostra les prototype properties d’una de les instàncies creades en el punt 2.
        hiEsPrototype = false;
        for (const prop in llibre2) {
            if (llibre2.propertyIsEnumerable(prop)) {
                hiEsPrototype = true;
            }
        }
        console.log("\nPrototype Properties: " + hiEsPrototype);

        /*  Explica que ocorre amb la propietat valoracio que es troba en les dues parts:
            Donarà true en ambdos casos, ya que la propietat existeix tant a prototype com a les own properties.
        */

// 2. Afegeix un mètode al objecte Array (perquè es pugui aplicar a tots els array) que realitzi l’ordenació de l'array tenint en compte els valors numèrics:
console.log("+-----------------------------------------------------+\n"
          + "+                      EXERCICI 2                     +\n"
          + "+-----------------------------------------------------+");
Array.prototype.ordenarNums = function(descendent){
    if (!descendent){
        this.sort(function(a, b){return a - b});
    }else{
        this.sort(function(a, b){return b - a});
    }
    return this;
};
const array = [5, 6, 0, 1, 45, 2];
console.log("Ascendent: " + array.ordenarNums());
console.log("Descendent: " + array.ordenarNums(true));

// 3. Herència per Prototypes i Classes ES6
// console.log("+-----------------------------------------------------+\n"
//           + "+                      EXERCICI 3                     +\n"
//           + "+-----------------------------------------------------+");
// Els atributs marca, model, matricula, color i combustible es passaran en un objecte.
function Vehicle(marca, model, matricula, color, combustible) {
    this.marca = marca;
    this.model = model;
    this.matricula = matricula;
    this.color = color;
    this.combustible = combustible;
    this.disponibilitat = false; 
}

Vehicle.prototype.mostrarCaracteristiques = function() {
    console.log("Vehicle: " + this.marca + ", " + this.model + ", " + this.matricula + ", " + this.color + " " + this.combustible + " " + this.disponibilitat);
}

Vehicle.prototype.teDisponibilitat = function() {

}

Vehicle.prototype.desarVehicle = function () {

}

    // 1. Implementa l'estructura de classes de la part esquerra del diagrama mitjançant el paradigma d'encadenament de Prototypes.
    function QuatreRodes(marca, model, matricula, color, combustible, tipusCarnet) {
        Vehicle.call(this, marca, model, matricula, color, combustible);
        this.numRodes = 4;
        this.tipusCarnet = tipusCarnet;
    }
    QuatreRodes.prototype = Object.create(Vehicle.prototype);
    QuatreRodes.prototype.constructor = QuatreRodes;

    function Cotxe(marca, model, matricula, color, combustible, tipusCarnet, nPlaces) {
        QuatreRodes.call(this, marca, model, matricula, color, combustible, tipusCarnet);
        this.tipusVehicle = "cotxe";
        this.nPlaces = nPlaces;
    }
    Cotxe.prototype = Object.create(QuatreRodes.prototype);
    Cotxe.prototype.constructor = Cotxe;

    function Furgoneta(marca, model, matricula, color, combustible, tipusCarnet, nPlaces) {
        QuatreRodes.call(this, marca, model, matricula, color, combustible, tipusCarnet);
        this.tipusVehicle = "furgoneta";
        this.nPlaces = nPlaces;
    }
    Furgoneta.prototype = Object.create(QuatreRodes.prototype);
    Furgoneta.prototype.constructor = Furgoneta;

    // 2. Implementa l'estructura de classes de la part esquerra del diagrama mitjançant el paradigma ES6.
    // class Vehicle{
    //     constructor(marca, model, matricula, color, combustible){
    //         this.marca = marca;
    //         this.model = model;
    //         this.matricula = matricula;
    //         this.color = color;
    //         this.combustible = combustible;
    //         this.disponibilitat = false;
    //     }

    //     mostrarCaracteristiques(){
    //         console.log("Vehicle: " + this.marca + ", " + this.model + ", " + this.matricula + ", " + this.color + " " + this.combustible + " " + this.disponibilitat);
    //     }

    //     teDisponibilitat(){

    //     }

    //     desarVehicle(){

    //     }
    // }

    // class QuatreRodes extends Vehicle{
    //     constructor(marca, model, matricula, color, combustible, tipusCarnet){
    //         super(marca, model, matricula, color, combustible);
    //         this.numRodes = 4;
    //         this.tipusCarnet = tipusCarnet;
    //     }
    // }

    // class Cotxe extends QuatreRodes {
    //     constructor(marca, model, matricula, color, combustible, tipusCarnet, nPlaces) {
    //         super(marca, model, matricula, color, combustible, tipusCarnet);
    //         this.tipusVehicle = "cotxe";
    //         this.nPlaces = nPlaces;
    //     }
    // }
    
    // class Furgoneta extends QuatreRodes {
    //     constructor(marca, model, matricula, color, combustible, tipusCarnet,  nPlaces) {
    //         super(marca, model, matricula, color, combustible, tipusCarnet);
    //         this.tipusVehicle = "furgoneta";
    //         this.nPlaces = nPlaces;
    //     }
    // }

    // // 3. Implementa l'estructura de classes de la part dreta Vehicle i DuesRodes mitjançant el paradigma d'encadenament de Prototypes, i Moto i Bicicleta mitjançant el paradigma ES6.
    // function DuesRodes(marca, model, matricula, color, combustible, tipusCarnet) {
    //     Vehicle.call(this, marca, model, matricula, color, combustible);
    //     this.numRodes = 2;
    //     this.tipusCarnet = tipusCarnet;
    // }
    // DuesRodes.prototype = Object.create(Vehicle.prototype);
    // DuesRodes.prototype.constructor = DuesRodes;

    // class Moto extends DuesRodes {
    //     constructor(marca, model, matricula, color, combustible, tipusCarnet) {
    //         super(marca, model, matricula, color, combustible, tipusCarnet);
    //         this.tipusVehicle = "moto";
    //     }
    // }
    
    // class Bicicleta extends DuesRodes {
    //     constructor(marca, model, matricula, color, combustible, tipusCarnet, esElectrica) {
    //         super(marca, model, matricula, color, combustible, tipusCarnet);
    //         this.tipusVehicle = "bicicleta";
    //         this.esElectrica = esElectrica;
    //     }
    // }
