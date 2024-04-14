const usuaris = [
    {nom : "Joan", edat : 45, professio : "mecànic", sou : 1750, idioma :
    ["espanyol"]},
    {nom : "Pere", edat : 57, professio : "administratiu", sou : 1860,
    idioma : ["espanyol", "catala", "francès"]},
    {nom : "Laia", edat : 24, professio : "imformatica", sou : 1500, idioma
    : ["espanyol", "catala", "anglès", "francès"]},
    {nom : "Joana", edat : 88, professio : "jubilada", sou : 480, idioma :
    ["catala"]},
    {nom : "Mark", edat : 71, professio : "jubilat", sou : 650, idioma :
    ["anglès"]},
    {nom : "Josep", edat : 21, professio : "estudiant", sou : 0, idioma :
    ["espanyol", "catala", "anglès"]},
    {nom : "Maria", edat : 19, professio : "estudiant", sou : 0, idioma :
    ["espanyol", "catala", "anglès", "francès"]},
    {nom : "Eva", edat : 24, professio : "periodista", sou : 2750, idioma :
    ["espanyol", "catala", "italià", "francès"]},
    {nom : "Mireia", edat : 36, professio : "perruquera", sou : 1240,
    idioma : ["espanyol", "catala"]},
    {nom : "Esteve", edat : 54, professio : "dentista", sou : 4507, idioma
    : ["espanyol", "francès"]},
    {nom : "Joaquim", edat : 62, professio : "jubilat", sou : 1100, idioma
    : ["espanyol", "catala"]},
    {nom : "Ernest", edat : 14, professio : "estudiant", sou : 0, idioma :
    ["catala", "anglès"]},
    {nom : "Eric", edat : 28, professio : "disenyador", sou : 850, idioma :
    ["espanyol", "catala", "anglès", "alemany"]},
    {nom : "Maiol", edat : 20, professio : "estudiant", sou : 0, idioma :
    ["espanyol", "catala"]},
    {nom : "Carles", edat : 18, professio : "estudiant", sou : 0, idioma :
    ["espanyol"]},
    {nom : "Antoni", edat : 32, professio : "metge", sou : 7800, idioma :
    ["espanyol", "catala", "anglès"]},
];

// 1. Mostra el nom i la professió de cada usuari. Utilitza forEach().
console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 1                     +\n"
           + "+-----------------------------------------------------+");
usuaris.forEach(usuari =>{
    console.log(usuari.professio + " " + usuari.nom);
});

// 2. Crea un nou amb el sou augmentat en un 2% si el sou és menor de 1000 i en un 1.7% si és igual o més gran. Utilitza map()
console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 2                     +\n"
           + "+-----------------------------------------------------+");
let nouSou = usuaris.map(function (usuari) {
    if (usuari.sou < 1000){
        return {nom:usuari.nom, edat:usuari.edat, professio:usuari.professio, sou:(usuari.sou * 1.02).toFixed(0), idioma:usuari.idioma};
    }else{
        return {nom:usuari.nom, edat:usuari.edat, professio:usuari.professio, sou:(usuari.sou * 1.017).toFixed(0), idioma:usuari.idioma};
    }
});
console.log(nouSou);

// 3. A partir de l’array anterior retorna els items amb un sou entre 500 i 1500 ambdós inclosos. Utilitza filter().
console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 3                     +\n"
           + "+-----------------------------------------------------+");
let filtreSou = nouSou.filter((usuari) => usuari.sou >= 500 && usuari.sou <= 1500);
console.log(filtreSou);

// 4. Utilitzant every() i some():
console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 4                     +\n"
           + "+-----------------------------------------------------+");
// 1. Mostra un missatge que indiqui si tots els usuaris són majors d’edat o no ho són.
const mayorEdat = usuaris.every((usuari) => (usuari.edat >= 18));
if (mayorEdat){
    console.log("Tots son majors d'edat.");
}else{
    console.log("No tots son majors d'edat.");
}
//2. Mostra un missatge que indiqui si hi han usuaris que tenen 65 anys o més.
console.log("-----------------------------------------------");
const anys65 = usuaris.some((usuari) => (usuari.edat >= 65));
if (anys65){
    console.log("Hi han usuaris de més de 65 anys.");
}else{
    console.log("No hi han usuaris de més de 65 anys.");
}

// 5. Retorna el valor de la suma total del sou de tots els usuaris. Utilitza reduce().
console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 5                     +\n"
           + "+-----------------------------------------------------+");
const valor = 0;
const suma = usuaris.reduce(
  (suma, usuari) => suma + usuari.sou,
  valor,
);
console.log("Total: " + suma);

// 6. Mitjançant splice() a l’array usuaris:
console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 6                     +\n"
           + "+-----------------------------------------------------+");
// 1. Insereix dos elements nous a partir de la posició 7.
const usuari1 = {nom : "Hugo", edat : 19, professio : "informàtic", sou : 2000, idioma : ["espanyol"]}
const usuari2 = {nom : "Mario", edat : 27, professio : "metge", sou : 1800, idioma : ["català"]}
usuaris.splice(7, 0, usuari1, usuari2);
console.log(usuaris);

// 2. Extreu els elements de les posicions 3 a 5 (ambdós inclosos) eliminant-los de l’array original desant-los en un de nou.
const usuarisSplice = [];
console.log (usuaris.splice(3, 3, usuarisSplice));
