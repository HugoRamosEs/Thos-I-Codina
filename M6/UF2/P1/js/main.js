// IMPORTANCIONS
import * as domClass from "./modules/domClass.js";

// FUNCIONS
let existingKeys = {};
let image;
let characterName;
let currentPage = "form";

function cardValues(e) {
    e.preventDefault();
    const key = e.target.name;
    if (existingKeys[key]) {
        console.log(`La clau ${key} ya existeix.`);
        return;
    }
    const formData = {
        [key]: e.target.value,
    };
    if (e.target.type === 'file') {
        const file = e.target.files[0];
        const reader = new FileReader();

        reader.onload = function (event) {
            formData[key] = event.target.result;
            processFormData(formData);
        };
        reader.readAsDataURL(file);
    } else {
        processFormData(formData);
    }
}

function processFormData(formData) {
    let name;
    let text2;
    let imageLoaded = false;
    for (const [formKey, value] of Object.entries(formData)) {
        const text1 = new domClass.InlineElement("p", {id:`${formKey.charAt(0).toLowerCase()}${formKey.slice(1)}-key`, class: "card-key"}, formKey).createElement();
        if (formKey === "Image") {
            image = new domClass.InlineElement("img", {id:`${formKey.charAt(0).toLowerCase()}${formKey.slice(1)}-img`, src:value, alt:"Uploaded Image"}).createElement();
            image.addListener("load", function (){
                const width = image.element.width;
                divMainCard.setStyle({'max-width':`${width}px`});
                mainCardText.setStyle({'max-width':`${width}px`});
            });
            imageLoaded = true;
        } else {
            if (formKey === "Character") {
                characterName = value;
                name = new domClass.InlineElement("p", { id: `${formKey.charAt(0).toLowerCase()}${formKey.slice(1)}-name` }, value).createElement();
            }
            text2 = new domClass.InlineElement("p", { id: `${formKey.charAt(0).toLowerCase()}${formKey.slice(1)}-p` }, value).createElement();
        }
        mainCard.addChildren([image].filter(child => child !== undefined && child !== null));
        mainCardText.addChildren([text1, text2, name].filter(child => child !== undefined && child !== null));
    }
    if (characterName) {
        mainCard.element.id = `${characterName.toLowerCase()}-mainCard`;
    }
}

function save(e){
    e.preventDefault();
    const card = document.getElementById("divMainCard");
    const data = JSON.parse(localStorage.getItem("God of War")) || {};
    if (characterName) {
        data[characterName] = card.innerHTML;
        localStorage.setItem("God of War", JSON.stringify(data));
        alert("Carta desada correctament.");
    }
}

function reset(e){
    e.preventDefault();
    existingKeys = {};
    characterName = "";
    const inputs = document.querySelectorAll("input");
    const selects = document.querySelectorAll("select");
    descriptionTextarea.element.value = "";
    inputs.forEach(input => {
        if (input.type !== "submit") {
            input.value = "";
        }
    });
    selects.forEach(select => {
        select.selectedIndex = 0;
    });
    mainCard.element.id = "mainCard";
    mainCard.deleteChild(image);
    mainCardText.deleteChildren();
}


function load(e) {
    e.preventDefault();
    const dataRecovered = JSON.parse(localStorage.getItem("God of War"));
    if (!cardsDiv) {
        cardsDiv = new domClass.CompoundElement("div", {id: "cardsDiv"}).createElement().printElement({parentId: "contenedor", position: "beforeend"});
    }else {
        cardsDiv.innerHTML("");
    }

    if (!dataRecovered) {
        alert("No hi han cartes desades, per tant no es poden carregar.");
    }else {
        for (const key in dataRecovered) {
            const value = dataRecovered[key];
            let loadedCard = new domClass.OnlyTagElement("div", {class: "loadedCard"}).createElement().innerHTML(value);
            cardsDiv.addChildren([loadedCard]);
        }
    }
}

function resetCards(e) {
    e.preventDefault();
    const dataRecovered = JSON.parse(localStorage.getItem("God of War"));
    if(!dataRecovered){
        alert("No hi han cartes desades, per tant no hi ha res per eliminar.");
    }else{
        cardsDiv.innerHTML("");
        localStorage.removeItem("God of War");
        alert("Cartes eliminades correctament.");
    }
}

function showGallery(e) {
    e.preventDefault();
    currentPage = "gallery";
    updatePage();
}

function showForm(e) {
    e.preventDefault();
    currentPage = "form";
    updatePage();
}

function updatePage(){
    if (currentPage === "gallery"){
        divForm.setStyle({display:"none"});
        divMainCard.setStyle({display:"none"});
        cardTitle.setStyle({display:"none"});
        buttonsGallery.setStyle({display:"block"});
        cardsDiv.setStyle({display:"flex"});
        document.getElementById("contenedor").classList.remove("c-form");
        document.getElementById("contenedor").classList.add("c-gallery");
        formTitle.changeText("Character List");
        galleryButton.changeText("CREATE CHARACTER");
        galleryButton.removeListener("click", showGallery);
        galleryButton.addListener("click", showForm);
    }else if(currentPage === "form"){
        divForm.setStyle({display:"block"});
        divMainCard.setStyle({display:"block"});
        cardTitle.setStyle({display:"block"});
        buttonsGallery.setStyle({display:"none"});
        cardsDiv.setStyle({display:"none"});
        document.getElementById("contenedor").classList.remove("c-gallery");
        document.getElementById("contenedor").classList.add("c-form");
        formTitle.changeText("Create Character");
        galleryButton.changeText("CHARACTER GALLERY");
        galleryButton.removeListener("click", showForm);
        galleryButton.addListener("click", showGallery);
    }else{
        console.log("ERROR: Pàgina no trobada.")
    }
}

//  LABELS
const imageLabel = new domClass.InlineElement("label", {for:"imageInput", name:"imageLabel"}, "Image:").createElement();
const characterLabel = new domClass.InlineElement("label", {for:"characterInput", name:"characterLabel"}, "Character:").createElement();
const descriptionLabel = new domClass.InlineElement("label", {for:"descriptionTextarea", name:"descriptionLabel"}, "Description:").createElement();
const originLabel = new domClass.InlineElement("label", {for:"originInput", name:"originLabel"}, "Origin:").createElement();
const kindLabel = new domClass.InlineElement("label", {for:"kindSelect", name:"kindLabel"}, "Kind:").createElement();
const homeLabel = new domClass.InlineElement("label", {for:"homeInput", name:"homeLabel"}, "Home:").createElement();
const stateLabel = new domClass.InlineElement("label", {for:"stateSelect", name:"stateLabel"}, "State:").createElement();

// INPUTS
const imageInput = new domClass.OnlyTagElement("input", {type:"file", id:"imageInput", name:"Image", accept:"image/png, image/jpeg, image/webp"}).createElement();
const characterInput = new domClass.OnlyTagElement("input", {type:"text", id:"characterInput", name:"Character", placeholder:"Enter character name"}).createElement();
const descriptionTextarea = new domClass.OnlyTagElement("textarea", {id:"descriptionTextarea", name:"Description", placeholder:"Enter character description", rows:"6"}).createElement();
const originInput = new domClass.OnlyTagElement("input", {type:"text", id:"originInput", name:"Origin", placeholder:"Enter origin"}).createElement();
const kindSelect = new domClass.SelectElement("select", {id:"kindSelect", name:"Kind"}, [
    {tag:"option", attributes:{value:"-Select an Option-", disabled:"disabled", selected:"selected"}, text:"-Select an Option-"},
    {tag:"option", attributes:{value:"God"}, text:"God"},
    {tag:"option", attributes:{value:"Demigod"}, text:"Demigod"},
    {tag:"option", attributes:{value:"Giant"}, text:"Giant"},
]).createElement();
const homeInput = new domClass.OnlyTagElement("input", {type:"text", id:"homeInput", name:"Home", placeholder:"Enter home"}).createElement();
const stateSelect = new domClass.SelectElement("select", {id:"stateSelect", name:"State"}, [
    {tag:"option", attributes:{value:"-Select an Option-", disabled:"disabled", selected:"selected"}, text:"-Select an Option-"},
    {tag:"option", attributes:{value:"Alive"}, text:"Alive"},
    {tag:"option", attributes:{value:"Dead"}, text:"Dead"},
]).createElement();
const saveInput = new domClass.OnlyTagElement("input", {type:"submit", id:"saveInput", name:"Save", value:"Save"}).createElement().addListener("click" , save);
const resetInput = new domClass.OnlyTagElement("input", {type:"submit", id:"resetInput", name:"Reset", value:"Reset"}).createElement().addListener("click", reset);
const buttons = new domClass.CompoundElement("div", {id:"buttons", name:"buttons"}).createElement().addChildren([saveInput, resetInput]);

// TITOLS
const galleryButton = new domClass.InlineElement("button", {id:"galleryButton"}, "CHARACTER GALLERY").createElement().addListener("click", showGallery);
const divGallery = new domClass.CompoundElement("div", {id:"divGallery", name:"divGallery"}).createElement().addChildren([galleryButton]).printElement({parentId:"contenedor", position:"beforebegin"});
const mainTitle = new domClass.InlineElement("h1", {}, "UF2. Pràctica 1. Programació amb herència de classes").createElement().printElement({parentId:"contenedor", position:"beforebegin"});

// FORMULARI
const formTitle = new domClass.InlineElement("h2", {id:"formTitle"}, "Create Character").createElement().printElement({parentId:"contenedor", position:"afterbegin"});
const mainForm = new domClass.CompoundElement("form", {id:"mainForm", action:"", method:"get"}).createElement().addChildren([
    imageLabel,
    imageInput,
    characterLabel,
    characterInput,
    descriptionLabel,
    descriptionTextarea,
    originLabel,
    originInput,
    kindLabel,
    kindSelect,
    homeLabel,
    homeInput,
    stateLabel,
    stateSelect,
    buttons
]).addListener("change", cardValues);
const divForm = new domClass.CompoundElement("div", {id:"divMainForm", class:"divContenedor"}).createElement().addChildren([mainForm]).printElement({parentId:"contenedor", position:"beforeend"});

// CARTA
const cardTitle = new domClass.InlineElement("h2", {id:"cardTitle"}, "Character Card").createElement().printElement({parentId:"contenedor", position:"beforeend"});
const mainCard = new domClass.CompoundElement("div", {id:"mainCard", class:"card"}).createElement().printElement({parentId:"contenedor", position: "beforeend"});
const mainCardText = new domClass.CompoundElement("div", {id:"mainCardText"}).createElement().printElement({parentId:"mainCard", position: "beforeend"});
const divMainCard = new domClass.CompoundElement("div", {id:"divMainCard", class:"divContenedor"}).createElement().addChildren([mainCard]).printElement({parentId:"contenedor", position:"beforeend"});

// GALLERY
const loadInput = new domClass.OnlyTagElement("input", {type:"submit", id:"loadCards", name:"Load Cards", value:"Load Cards"}).createElement().addListener("click" , load);
const resetCardsInput = new domClass.OnlyTagElement("input", {type:"submit", id:"deleteCards", name:"Delete Cards", value:"Delete Cards"}).createElement().addListener("click" , resetCards);
const buttonsGallery = new domClass.CompoundElement("div", {id:"buttonsGallery", name:"buttonsGalley"}).createElement().addChildren([loadInput, resetCardsInput]).printElement({parentId:"contenedor", position:"beforeend"});
const cardsDiv = new domClass.CompoundElement("div", {id:"cardsDiv"}).createElement().printElement({parentId:"contenedor", position:"beforeend"});
buttonsGallery.setStyle({display:"none"});
cardsDiv.setStyle({display:"none"});