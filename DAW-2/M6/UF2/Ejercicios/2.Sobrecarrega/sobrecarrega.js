const data = new Date(Date.now()).toLocaleString();
const obj = {
    nom: "Huawei P40 Lite",
    categoria: "Smartphone",
    preu: 199,
    log: [],
    gestionarDades: function () {
        if (arguments.length == 0) {
            for (const key in this) {
                if (typeof this[key] !== 'function'){
                    this[key] = null;
                }
            }
        } else if (arguments.length == 1) {
            if (typeof arguments[0] === 'object' && arguments[0] !== null) {
                for (let key in arguments[0]) {
                    if (!(key in this)) {
                        let value = arguments[0][key];
                        Object.assign(this, {[key]: value});
                    } else {
                        this.log.push(`La propietat ${key} existeix (${data}).`);
                    }
                }
            }else if (typeof arguments[0] === 'string'){
                let exists = false;
                for (let key in this) {
                    if (key == arguments[0]){
                        exists = true;
                        delete this[key];
                    }
                }
                if (!exists){
                    this.log.push(`La propietat ${arguments[0]} no existeix (${data}).`);
                }
            }
        } else if (arguments.length == 2){
            if (typeof arguments[0] === 'string'){
                let exists = false;
                let type;
                for (let key in this) {
                    if (key == arguments[0]){
                        exists = true;
                        type = typeof this[key];
                        if (type === typeof arguments[1]) {
                            this[key] = arguments[1];
                        } else {
                            this.log.push(`El tipus de dades de ${key} ha de ser ${type} (${data})`);
                        }
                    }
                }

                if (!exists) {
                    Object.assign(this, {[arguments[0]]: arguments[1]});
                }
            }else if (typeof arguments[0] === 'string' && typeof arguments[1] === 'function'){
                Object.assign(this, {[arguments[0]]: arguments[1]});
            }else{
                this.log.push(`Tipus de dada (${typeof arguments[0]}) no vàlid (${data})`);
            }
        } else{
            console.log("Nombre d'arguments no vàlids.");
        }
    }  
};

console.log("+-----------------------------------------------------+\n"
          + "+                     JOC DE PROVES                   +\n"
          + "+-----------------------------------------------------+");

// DESCOMENTA EL CONTINGUT QUE HI HA DINS DE L'APARTAT D'EXERCICI, PER VEURE ELS RESULTATS.

//  0 ARGUMENTS:
    // Es passa la funció sense arguments, llavors es tornen totes les keys a null, excepte els mètodes.
    // EXERCICI:
        // obj.gestionarDades();
        // console.log(obj);
    
//  1 ARGUMENT:
    // OBJECTE:
        // S'afegiran les keys que no estiguin a l'obj, i les que estiguin, es passarà un missatge al log[], dient que ya existeixen.
        // EXERCICI:
            // const obj1 = {
            //     nom: "Xiaomi Redmi Note 4",
            //     categoria: "Smartphone",
            //     preu: 180,
            //     processador: "Snapdragon 620",
            //     gpu: "Adreno 240"
            // }
            // obj.gestionarDades(obj1);
            // console.log(obj);

    // STRING:
        // Propietat que existeix a l'obj, llavors s'elimina.
        // EXERCICI:
            // obj.gestionarDades("categoria");
            // console.log(obj);   

        // Propietat que no existeix a l'obj, llavors surt un missatge a log[] dient que aquesta propietat no existeix.
        // EXERCICI:
            // obj.gestionarDades("pantalla");
            // console.log(obj);

//  2 ARGUMENTS:
    // STRING, QUALSEVOL TIPUS DE DADES:
        // La propietat (primer argument), no existeix a l'objecte, per tant s'afegeix amb el seu valor (segon argument). El primer argument ha de ser un String, mentre que el segon pot ser qualsevol cosa.
        // EXERCICI:
            // obj.gestionarDades("id", 7);
            // console.log(obj);

        // La propietat (primer argument), si existeix a l'objecte, per tant es modifica el valor que conté amb el segon argument, sempre que aquest sigui del tipus de l'anterior valor. Si no es del mateix
        // tipus, llavors, mostrarà un missatge al log[] dient que no son del mateix tipus, i per tant el valor es manté.
            // Si es del mateix tipus.
            // EXERCICI:
                // obj.gestionarDades("categoria", "tablet");
                // console.log(obj);

            // No es del mateix tipus.
            // EXERCICI:
                // obj.gestionarDades("categoria", 32);
                // console.log(obj);
    
    // STRING, FUNCIÓ:
        // S'ha de donar el cas de que el primer argument ha de ser un String i el segon una funcio. En cas de que es compleixi, llavors el primer argument serà la key de l'objecte i el segon argument, que 
        // serà la funciṕ tindrà el nom del primer argument.
        // EXERCICI:
            // obj.gestionarDades('preuAmbIva', function () {
            //     const preuIva = obj.preu * 1.21;
            //     console.log("Preu amb IVA: " + preuIva);
            // });
            // console.log(obj);
            // console.log(obj.preuAmbIva());

    // ARGUMENTS NO VÀLIDS:
        // Es dona el cas de que els arguments que s'envien no son correctes, es a dir, el primer argument no es un String.
        // EXERCICI:
            // obj.gestionarDades(5, 80);
            // console.log(obj);

//  MÉS DE 2 ARGUMENTS:
    // Es passen més de dos arguments a la funció.
        // Més de dos arguments:
        // EXERCICI:
            // obj.gestionarDades("categoria", 80, 1.2);