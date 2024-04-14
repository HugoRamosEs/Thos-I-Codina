/*
- developer.mozilla.org es un manual. La página web esta en el Moodle.
- Por defecto siempre utilizaremos const para asignar las variables.
- En los casos que necesitemos reasignar valores, utilizaremos let, todo y que exista var. var se puede encontrar en codigos antiguos, vigilar con esto.
- String es un objeto con sus propios metodos. Ejemplo: String.prototype,includes().
- undefined --> significa que no tiene valor, no esta definida.
- Para las comparativas utilizaremos el tripe = (null === undefined).
- words.filter(word) => word.lenght > 6); Funcion de flecha como callback.
*/

// array = [3,2,3]; --> No funciona, salta error.
const array = [1,2,3];
array [0] = 3; // Funciona el cambio de valor, aunque sea una constante.
console.log(array);