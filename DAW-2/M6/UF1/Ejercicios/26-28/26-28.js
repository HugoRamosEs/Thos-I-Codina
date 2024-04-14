console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 26                    +\n"
           + "+-----------------------------------------------------+");
const n = 3;
const array = new Array(n);
for (let i=0; i<n; i ++) {
    array[i] = new Array(n);
}
for (let i=0; i<array.length; i++) {
    for(let j=0; j<array[i].length; j++) {
        const numAleatori = Math.floor(Math.random() * 29);
        array[i][j] = numAleatori;
    }
}
console.log(array);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 27                    +\n"
           + "+-----------------------------------------------------+");
const array2 = new Array(n);
for (let i=0; i<n; i ++) {
    array2[i] = new Array(n);
}
for (let i=0; i<array2.length; i++) {
    let base = i * 10;
    for(let j=0; j<array2[i].length; j++) {
        array2[j][i] = Math.floor(Math.random() * 9) + base;
    }
}
console.log(array2);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 28                    +\n"
           + "+-----------------------------------------------------+");
const array3 = array2.slice();
for (let i=0; i<array3.length; i++){
    if (i === 2){
        let arrVert = array3.map(a => a[i]);
        arrVert.sort((a,b) => b-a);
        array3.map((a, index) => a[i] = arrVert[index]);
    }else{
        let arrVert = array3.map(a => a[i]);
        arrVert.sort((a,b) => a-b);
        array3.map((a, index) => a[i] = arrVert[index]);
    }
}
console.log(array3);