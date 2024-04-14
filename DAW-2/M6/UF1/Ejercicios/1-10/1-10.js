console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 1                     +\n"
           + "+-----------------------------------------------------+");
let valor = 2.0335;

if (typeof valor === 'number') {
    // valor = Number(valor.toFixed(2));
    console.log(valor.toFixed(2));
}else{
    console.log(typeof(valor));
}

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 2                    +\n"
           + "+-----------------------------------------------------+");
const title = ['La casa de paper', 'La catedral del mar', 'Panegre', 'Polseres vermelles'];
//title.forEach(function(item,i){ --------------------------> tambien se puede hacer asi title.forEach(item, i) => {...}
    //return title[i] = item.replace(/\s/g,'-').toLowerCase();
//});
for (let i=0; i< title.length; i++){
    title[i] = title[i].replace(/\s/g,'-').toLowerCase();
}
console.log(title);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 3                     +\n"
           + "+-----------------------------------------------------+");
const nums = [];
Array.from({ length: 6 }).forEach(function() {
    const num = Math.floor(Math.random() * 11);
    nums.push(num);
});
console.log(nums);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 4                     +\n"
           + "+-----------------------------------------------------+");
// const max = Math.min.apply(null, nums);
// const min = Math.max.apply(null, nums);
const max = Math.max(...nums);
const min = Math.min(...nums);
console.log('Max: ' + max + ', Min: ' + min);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 5                     +\n"
           + "+-----------------------------------------------------+");
const arrSuma = [3, false, 7, 'Maria', 9]
let suma = 0;
arrSuma.forEach(function(element){
    if (typeof element === 'number'){
        valor = valor + element;
    }
});
console.log('Suma: ' +valor);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 6                     +\n"
           + "+-----------------------------------------------------+");
const paraula = '';
if (paraula === null){
    console.log('Null');
}else if (paraula === undefined){
    console.log('Undefined');
}else if (paraula.length === 0){
    console.log('String buit');
}else{
    console.log(paraula);
}

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 7                     +\n"
           + "+-----------------------------------------------------+");
const str2 = 'Desenvolupament web en entorn client'
const array = str2.split(' ');
console.log(array);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 8                     +\n"
           + "+-----------------------------------------------------+");
const str3 = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua, elit';
const subStr = 'elit';
let cont = 0;
let pos1 = str3.indexOf(subStr);
while (pos1 !== -1){
    cont++;
    pos1 = str3.indexOf(subStr, pos1 + 1);
}
console.log('La subcadena ' +subStr+ ' apareix ' +cont+ ' vegades a la cadena');

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 9                     +\n"
           + "+-----------------------------------------------------+");
const cadena = 'correu@gmail.com';
const pos2 = cadena.indexOf('@');
const resta = cadena.substring(pos2 + 1);
console.log(resta);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 10                    +\n"
           + "+-----------------------------------------------------+");
function comprovarSufix(cadena, sufix) {
    return cadena.endsWith(sufix);
}

const text = 'Hola bon dia';
const suf = 'dia';
if (comprovarSufix(text, suf)){
    console.log('La cadena termina amb el sufix: ' +suf);
}else{
    console.log('La cadena no termina amb el sufix: ' +suf);
}