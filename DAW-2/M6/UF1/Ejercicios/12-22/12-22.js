console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 12                    +\n"
           + "+-----------------------------------------------------+");
const arr1 = [];
const noArr1 = 'hola';
console.log(Array.isArray(arr1));
console.log(Array.isArray(noArr1));

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 13                    +\n"
           + "+-----------------------------------------------------+");
const arr2 = [1,2,3];
const copyArr2 = [...arr2];
console.log(copyArr2);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 14                    +\n"
           + "+-----------------------------------------------------+");
const arr3 = [1,62,65,12,49];
arr3.sort(function(a, b){return a - b});
console.log(arr3);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 15                    +\n"
           + "+-----------------------------------------------------+");
function shuffle(array) {
    return array.sort(() => Math.random() - 0.5);
}
let arr4 = [1,2,3,4,5,6];
arr4 = shuffle(arr4);
console.log(arr4);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 16                    +\n"
           + "+-----------------------------------------------------+");
const library = [
    { author: 'Bill Gates', title: 'The Road Ahead', libraryID: 1254},
    { author: 'Steve Jobs', title: 'Walter Isaacson', libraryID: 4264},
    { author: 'Suzanne Collins', title: 'Mockingjay: The Final Book of TheHunger Games', libraryID: 3245}
];

library.sort(function(a,b){
    return a.libraryID - b.libraryID;
});
console.log(library);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 17                    +\n"
           + "+-----------------------------------------------------+");
const arr5 = [1,6,7,1,2];
const arr5_2 = ['hola', 'exercici', 'proba'];
const arrUnida = [...arr5, ...arr5_2];
console.log(arrUnida);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 18/21                 +\n"
           + "+-----------------------------------------------------+");
const dataActual = new Date();
let opcions = {
    day: 'numeric',
    month: 'numeric',
    year: 'numeric',
    hour: 'numeric',
    minute: 'numeric',
    second: 'numeric',
}
console.log(new Intl.DateTimeFormat("es-ES", opcions).format(dataActual));

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 19                    +\n"
           + "+-----------------------------------------------------+");
function formatarData(data){
    let opcions = {
        day: 'numeric',
        month: 'numeric',
        year: 'numeric',
    }
    return dataFormatada = new Intl.DateTimeFormat("es-ES", opcions).format(data);
}

const data1 = new Date('2004/02/18');
const data2 = new Date('1997/12/25');
if (data1 < data2){
    console.log('La data ' +formatarData(data2)+ ' es més recent');
}else if (data1 > data2){
    console.log('La data ' +formatarData(data1)+ ' es més recent');
}else{
    console.log('Son iguals');
}

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 20                    +\n"
           + "+-----------------------------------------------------+");
const dataInici = new Date('2004/01/01');
const dataFinal = new Date('2004/12/25');
const dies = dataFinal - dataInici;
console.log('Diferencia de dies: ' +dies / (1000*60*60*24));

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 22                    +\n"
           + "+-----------------------------------------------------+");
const arr6 = [];
while (arr6.length < 10){
    let num = Math.floor(Math.random() * 11);
    let existeix = false;

    for (let i=0; i<arr6.length; i++){
        if (arr6[i] === num){
            existeix = true;
        }    
    }
    if (!existeix){
        arr6.push(num);
    }
}
console.log(arr6);