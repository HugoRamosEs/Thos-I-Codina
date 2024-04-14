import * as Canvas from "./modules/canvas.js";

const canvas = new Canvas.Canvas("myCanvas").getContext();
const slider = document.querySelector(".slider");
const range = document.getElementById("myRange");
const rangeValueElement = document.getElementById("rangeValue");

document.addEventListener("DOMContentLoaded", function() {
    let selImg = null;
    let selButton = null;
    const images = document.querySelectorAll(".images .image img");
    images.forEach(img => {
        img.addEventListener("click", function(){
            if (selImg) {
                slider.classList.remove("show");
                selImg.classList.remove("selected-img");
                if (selButton) {
                    selButton.classList.remove("selected-button");
                    selButton = null;
                }
            }
            img.classList.add("selected-img");
            selImg = img;
            canvas.loadImage(img.alt);
        });
    });

    const buttons = document.querySelectorAll(".buttons img");
    buttons.forEach(button => {
        button.addEventListener("click", function() {
            if (selImg) {
                if (selButton) {
                    selButton.classList.remove("selected-button");
                }
                button.classList.add("selected-button");
                slider.classList.remove("show");
                selButton = button;
                if (button.alt === "limpiar.png") {
                    selImg.classList.remove("selected-img");
                    setTimeout(function() {
                        selButton.classList.remove("selected-button");
                    }, 1000);
                    canvas.clear();
                    selImg = null;
                }
                if (button.alt === "descarga.png") {
                    canvas.save();
                }
                canvas.applyFilter(button.alt, 0);
                if (button.alt === "brillo.png" || button.alt === "opacidad.png" || button.alt === "tono.png") {
                    slider.classList.add("show");
                    range.value = 0;
                    rangeValueElement.textContent = 0;
                    range.addEventListener("input", function() {
                        rangeValueElement.textContent = range.value;
                        canvas.applyFilter(button.alt, range.value);
                    });
                }
            }else {
                alert("Has de seleccionar una imatge.");
            }
        });
    });
});
