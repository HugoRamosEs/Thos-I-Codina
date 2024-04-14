const formulari = document.getElementById("formulari");
const botoReset = document.getElementById("reset");
const botoEnvia = document.getElementById("envia");

const dades = {
    //"nom": nom,
    //"cognom": cognom,
    //"email": email,
    //"adreça": adreca
}

const dadesObtingudes = JSON.parse(localStorage.getItem("dadesObtingudes")) || {};
console.log("Dades:", dades);

if (dadesObtingudes) {
    for (const prop in dadesObtingudes) {
        dades[prop] = dadesObtingudes[prop];
        document.getElementById(prop).value = dades[prop];
        //console.log(`obj.${prop} = ${dades[prop]}`);
    }
}

formulari.addEventListener("change", (e)=>{
    dades[e.target.name] = e.target.value;
    localStorage.setItem("dadesObtingudes", JSON.stringify(dades));
});

botoEnvia.addEventListener("click", (e)=>{
    e.preventDefault();
});

botoReset.addEventListener("click", (e)=>{
    e.preventDefault();
    const inputs = formulari.getElementsByTagName("input");
    for (let i = 0; i < inputs.length; ++i) {
      inputs[i].value = "";
    }
    localStorage.removeItem("dadesObtingudes");
});


