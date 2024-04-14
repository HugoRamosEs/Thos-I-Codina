import * as Filtre from "./filtre.js";

export class Canvas {
    #id = null;
    #canvas = null;
    #ctx = null;
    #img = null;
    #filtre = null;

    constructor(id) {
        this.#id = id;
        this.#canvas = null;
        this.#ctx = null;
        this.#img = null;
        this.#filtre = null;
    }

    getContext() {
        this.#canvas = document.getElementById(this.#id);
        this.#ctx = this.#canvas.getContext("2d");
        return this;
    }

    loadImage(imgName) {
        this.#img = new Image();
        this.#img.onload = () => {
            this.#canvas.width = this.#img.width + 20;
            this.#canvas.height = this.#img.height + 20;
            this.#ctx.clearRect(0, 0, this.#canvas.width, this.#canvas.height);
            this.#ctx.fillStyle = "green";
            this.#ctx.fillRect(0, 0, this.#canvas.width, this.#canvas.height);
            this.#ctx.drawImage(this.#img, 10, 10);
        };
        this.#img.src = `img/${imgName}`;
    }

    applyFilter(filterName, sliderValue) {
        if (filterName !== "limpiar.png" && filterName !== "descarga.png") {
            this.#ctx.clearRect(0, 0, this.#canvas.width, this.#canvas.height);
            this.#canvas.width = this.#img.width * 2 + 30;
            this.#ctx.fillStyle = "green";
            this.#ctx.fillRect(0, 0, this.#canvas.width, this.#canvas.height);
            this.#ctx.drawImage(this.#img, 10, 10);
            this.#ctx.drawImage(this.#img, this.#img.width + 20, 10);
            this.#filtre = new Filtre.Filtre(this.#ctx, this.#img, filterName);
            this.#filtre.transform(sliderValue);
        }
    }

    clear() {
        this.#ctx.clearRect(0, 0, this.#canvas.width, this.#canvas.height);
        this.#filtre = null;
    }

    save() {
        if (this.#filtre) {
            const savedCanvas = document.createElement("canvas");
            savedCanvas.width = this.#img.width;
            savedCanvas.height = this.#img.height;
            const savedContext = savedCanvas.getContext("2d");
            const imgData = this.#ctx.getImageData(this.#img.width + 20, 10, this.#img.width, this.#img.height);
            savedContext.putImageData(imgData, 0, 0);
            const download = document.createElement("a");
            download.href = savedCanvas.toDataURL("image/jpeg");
            download.download = "img-filtre.jpg";
            document.body.appendChild(download);
            download.click();
            document.body.removeChild(download);
        } else {
            alert("Has de seleccionar un filtre per descarregar l'imatge.");
        }
    }

    get id() {
        return this.#id;
    }

    get canvas() {
        return this.#canvas;
    }

    get ctx() {
        return this.#ctx;
    }

    get img() {
        return this.#img;
    }

    get filtre() {
        return this.#filtre;
    }

    set id(newId) {
        this.#id = newId;
    }

    set canvas(newCanvas) {
        this.#canvas = newCanvas;
    }

    set ctx(newCtx) {
        this.#ctx = newCtx;
    }

    set img(newImg) {
        this.#img = newImg;
    }

    set filtre(newFiltre) {
        this.#filtre = newFiltre;
    }
}