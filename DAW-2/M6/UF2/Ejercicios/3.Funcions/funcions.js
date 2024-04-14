// 1. Funcions de Callback. Crea una funció que rebi com a paràmetres un array d'enters i dues funcions Callback.
console.log("+-----------------------------------------------------+\n"
          + "+                      EXERCICI 1                     +\n"
          + "+-----------------------------------------------------+");
    // 1. La primera retornarà la mitjana dels valors de l'array passat com a paràmetre.
    function mitjanaValors(array) {
        let suma = 0;
        let longitud = 0;
        array.forEach(valor => {
            suma = suma + valor;
            longitud++;
        });
        return suma / longitud;
    }
    // 2. La segona retornarà la diferència entre el valor màxim i mínim dels valors de l'array passats com a paràmetre.
    function diferenciaValors(array) {
        let min = 0;
        let max = 0;
        array.forEach(valor => {
            if (valor < min) {
                min = valor;
            }
            if (valor > max) {
                max = valor;
            }
        });
        return max - min;
    }
    // 3. La funció principal retornarà la potència del primer valor retornat per la primera funció elevat al valor retornat per la segona.
    function potenciaFuncions(array, funcio1, funcio2) {
        const val1 = funcio1(array);
        const val2 = funcio2(array);
        return Math.pow(val1, val2);
    }
const enters = [4, 2, 8, 7, 3, 6];
console.log("Valor: " + potenciaFuncions(enters, mitjanaValors, diferenciaValors));

// Crea una funció que es pugui executar en diferents objectes mitjançant Apply() o Call(). Aquesta funció calcularà:
console.log("+-----------------------------------------------------+\n"
          + "+                      EXERCICI 2                     +\n"
          + "+-----------------------------------------------------+");
    // 1. La mitjana de les puntuacions obtingudes a partir dels valors de l’array scores de l’objecte, i la desarà en una variable avgScores.
    // Si la mitjana és igual o superior a 50 una variable overcame es posarà a true, en cas contrari a false.
    // Executa una funció mitjançant call(). L’objecte que es passarà com a paràmetre té el següent format:
    // i se li han d’afegir dues propietats avgScores i overcame calculades per la funció.
    function calcularMitjana(){
        if (!this.scores || !Array.isArray(this.scores)){
            console.log("L'objecte no té una propietat scores.");
        }else{
            let suma = 0;
            let long = 0;
            let overcome = false;
            this.scores.forEach(score =>{
                suma = suma + score;
                long++;
            });
            const avgScores = suma / long;
            
            if (avgScores > 50){
                overcome = true;
            }else{
                overcome = false;
            }
            Object.assign(this, {["avgScores"]: avgScores});
            Object.assign(this, {["overcome"]: overcome});
        }
    }
const student = {
    name : "Antoni",
    surname : "Batllori",
    scores : [40,25,37,65,72,55]
};
calcularMitjana.call(student);
console.log(student);

// 3. Aplica la funció del punt anterior a un array d'objects.
console.log("+-----------------------------------------------------+\n"
          + "+                      EXERCICI 3                     +\n"
          + "+-----------------------------------------------------+");
const students = [
    {name : "Antoni", surname : "Batllori", scores : [40,75,22,78]},
    {name : "Pere", surname : "Rodríguez", scores : [10,28,85,35]},
    {name : "Josepa", surname : "Rovira", scores : [62,71,23,44]},
    {name : "Joan", surname : "Revert", scores : [14,65,18,88]},
    {name : "Maria", surname : "Palau", scores : [52,45,24,55]}
];
students.forEach(student =>{
    calcularMitjana.call(student);
})
console.log(students);

// 4. Altres característiques de les funcions
console.log("+-----------------------------------------------------+\n"
          + "+                      EXERCICI 4                     +\n"
          + "+-----------------------------------------------------+");
    // 1. Funció Anonima
    // Una funció anònima en JavaScript és simplement una funció que no té un nom associat. S'utilitza amb freqüència per passar funcions com a arguments a altres funcions o per assignar-les a variables.
    setTimeout(function () {
        console.log("Ha passat 1 segon.");
    }, 1000);

    // 2. Closure        
    function init() { 
    var name = "Mozilla"; // name es una variable local creada per la funció init.
    function displayName() {
        // displayName() es una funció interna, que forma la conclusió.
        console.log(name); // fa servir la variable declarada a la funció pare.
    }
    displayName();
    }
    init();