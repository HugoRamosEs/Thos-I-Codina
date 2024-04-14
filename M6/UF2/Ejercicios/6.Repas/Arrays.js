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
] ;

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 1                     +\n"
           + "+-----------------------------------------------------+");
usuaris.forEach(usuari => {
    console.log(usuari.nom + " " + usuari.professio);
});

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 2                     +\n"
           + "+-----------------------------------------------------+");
const usuaris2 = usuaris.map(usuari =>{
    if (usuari.sou < 1000){
        return {nom:usuari.nom, edat:usuari.edat, professio:usuari.professio, sou:(usuari.sou * 1.02).toFixed(0), idioma:usuari.idioma};
    }else if (usuari.sou >= 1000){
        return {nom:usuari.nom, edat:usuari.edat, professio:usuari.professio, sou:(usuari.sou * 1.017).toFixed(0), idioma:usuari.idioma};
    }
});

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 3                     +\n"
           + "+-----------------------------------------------------+");
let souFiltre = usuaris2.filter((usuari) => usuari.sou >= 500 && usuari.sou <= 1500);
console.log(souFiltre);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 4                     +\n"
           + "+-----------------------------------------------------+");
if (usuaris.every((usuari) => usuari.edat >= 18)){
    console.log("Mayors d'edat");
}else{
    console.log("Menors d'edat");
}

if (usuaris.some((usuari) => usuari.edat >= 65)){
    console.log("Hi han majors");
}else{
    console.log("No n'hi han majors");
}

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 5                     +\n"
           + "+-----------------------------------------------------+");
const sumaTotal = usuaris.reduce((sumaTotal, usuari) => sumaTotal + usuari.sou, 0,);
console.log(sumaTotal);

console.log( "+-----------------------------------------------------+\n"
           + "+                      EXERCICI 6                     +\n"
           + "+-----------------------------------------------------+");
const usuari1 = {nom : "Hugo", edat : 19, professio : "informàtic", sou : 2000, idioma : ["espanyol"]}
const usuari2 = {nom : "Mario", edat : 27, professio : "metge", sou : 1800, idioma : ["català"]}
usuaris.splice(7, 0, usuari1, usuari2);
console.log(usuaris);

const usuaris3 = usuaris.splice(3, 2);
console.log(usuaris3);

// Slice solo mostrar
// Splice quitar y poner