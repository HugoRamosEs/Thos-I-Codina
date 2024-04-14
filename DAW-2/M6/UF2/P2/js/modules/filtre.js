export class Filtre {
    constructor(ctx, img, filterName) {
        this.ctx = ctx;
        this.img = img;
        this.filterName = filterName;
    }

    transform(sliderValue){
        if (this.filterName === "brillo.png"){
            const brightness = new Brightness(this.ctx, this.img);
            brightness.applyBrightness(sliderValue);
        }else if (this.filterName === "blanco-negro.png"){
            const blackWhite = new BlackWhite(this.ctx, this.img);
            blackWhite.applyBlackWhite();
        }else if (this.filterName === "negativo.png"){
            const negative = new Negative(this.ctx, this.img);
            negative.applyNegative();
        }else if (this.filterName === "espejo.png"){
            const mirror = new Mirror(this.ctx, this.img);
            mirror.applyMirror();
        }else if (this.filterName === "sepia.png"){
            const sepia = new Sepia(this.ctx, this.img);
            sepia.applySepia();
        }else if (this.filterName === "opacidad.png"){
            const opacity = new Opacity(this.ctx, this.img);
            opacity.applyOpacity(sliderValue);
        }else if (this.filterName === "tono.png"){
            const tone = new Tone(this.ctx, this.img);
            tone.applyTone(sliderValue);
        }else if (this.filterName === "no-filtro.png"){
            const noFilter = new NoFilter(this.ctx, this.img);
            noFilter.applyNoFilter();
        }
    }
}

export class Brightness extends Filtre {
    constructor(ctx, img) {
        super(ctx, img, "brillo.png");
    }

    applyBrightness(brightnessValue) {
        brightnessValue = Math.min(150, Math.max(-150, brightnessValue));
        const imgData = this.ctx.getImageData(this.img.width + 20, 10, this.img.width, this.img.height);
        for (let i=0; i<imgData.data.length; i=i+4) {
            imgData.data[i] = Math.min(255, Math.max(0, imgData.data[i] + brightnessValue));
            imgData.data[i+1] = Math.min(255, Math.max(0, imgData.data[i+1] + brightnessValue));
            imgData.data[i+2] = Math.min(255, Math.max(0, imgData.data[i+2] + brightnessValue));
        }
        this.ctx.clearRect(0, 0, this.img.width * 2 + 30, this.img.height + 20);
        this.ctx.fillStyle = "green";
        this.ctx.fillRect(0, 0, this.img.width * 2 + 30, this.img.height + 20);
        this.ctx.drawImage(this.img, 10, 10);
        this.ctx.putImageData(imgData, this.img.width + 20, 10);
    }
}

export class BlackWhite extends Filtre {
    constructor(ctx, img) {
        super(ctx, img, "blanco-negro.png");
    }

    applyBlackWhite() {
        const imgData = this.ctx.getImageData(this.img.width + 20, 10, this.img.width, this.img.height);
        for (let i=0; i<imgData.data.length; i=i+4) {
            const avg = (imgData.data[i] + imgData.data[i+1] + imgData.data[i+2]) / 3;
            imgData.data[i] = avg;
            imgData.data[i+1] = avg;
            imgData.data[i+2] = avg;
        }
        this.ctx.clearRect(0, 0, this.img.width * 2 + 30, this.img.height + 20);
        this.ctx.fillStyle = "green";
        this.ctx.fillRect(0, 0, this.img.width * 2 + 30, this.img.height + 20);
        this.ctx.drawImage(this.img, 10, 10);
        this.ctx.putImageData(imgData, this.img.width + 20, 10);
    }
}

export class Negative extends Filtre {
    constructor(ctx, img) {
        super(ctx, img, "negativo.png");
    }

    applyNegative() {
        const imgData = this.ctx.getImageData(this.img.width + 20, 10, this.img.width, this.img.height);
        for (let i=0; i<imgData.data.length; i=i+4) {
            imgData.data[i] = 255 - imgData.data[i];
            imgData.data[i+1] = 255 - imgData.data[i+1];
            imgData.data[i+2] = 255 - imgData.data[i+2];
        }
        this.ctx.clearRect(0, 0, this.img.width * 2 + 30, this.img.height + 20);
        this.ctx.fillStyle = "green";
        this.ctx.fillRect(0, 0, this.img.width * 2 + 30, this.img.height + 20);
        this.ctx.drawImage(this.img, 10, 10);
        this.ctx.putImageData(imgData, this.img.width + 20, 10);
    }
}

export class Mirror extends Filtre {
    constructor(ctx, img) {
        super(ctx, img, "espejo.png");
    }

    applyMirror() {
        const imgData = this.ctx.getImageData(this.img.width + 20, 10, this.img.width, this.img.height);
        for (let y=0; y<this.img.height; y++) {
            for (let x=0; x<this.img.width/2; x++) {
                const leftIndex = (y * this.img.width + x) * 4;
                const rightIndex = (y * this.img.width + (this.img.width - x) - 1) * 4;
                for (let i=0; i<4; i++) {
                    const temp = imgData.data[leftIndex + i];
                    imgData.data[leftIndex + i] = imgData.data[rightIndex + i];
                    imgData.data[rightIndex + i] = temp;
                }
            }
        }
        this.ctx.clearRect(0, 0, this.img.width * 2 + 30, this.img.height + 20);
        this.ctx.fillStyle = "green";
        this.ctx.fillRect(0, 0, this.img.width * 2 + 30, this.img.height + 20);
        this.ctx.drawImage(this.img, 10, 10);
        this.ctx.putImageData(imgData, this.img.width + 20, 10);
    }
}

export class Sepia extends Filtre {
    constructor(ctx, img) {
        super(ctx, img, "sepia.png");
    }

    applySepia() {
        const imgData = this.ctx.getImageData(this.img.width + 20, 10, this.img.width, this.img.height);
        for (let i=0; i<imgData.data.length; i=i+4) {
            const r = imgData.data[i];
            const g = imgData.data[i+1];
            const b = imgData.data[i+2];
            imgData.data[i] = Math.min(255, (r * 0.393) + (g * 0.769) + (b * 0.189));
            imgData.data[i+1] = Math.min(255, (r * 0.349) + (g * 0.686) + (b * 0.168));
            imgData.data[i+2] = Math.min(255, (r * 0.272) + (g * 0.534) + (b * 0.131));
        }
        this.ctx.clearRect(0, 0, this.img.width * 2 + 30, this.img.height + 20);
        this.ctx.fillStyle = "green";
        this.ctx.fillRect(0, 0, this.img.width * 2 + 30, this.img.height + 20);
        this.ctx.drawImage(this.img, 10, 10);
        this.ctx.putImageData(imgData, this.img.width + 20, 10);
    }
}

export class Opacity extends Filtre {
    constructor(ctx, img) {
        super(ctx, img, "opacidad.png");
    }

    applyOpacity(opacityValue) {
        opacityValue = Math.min(150, Math.max(-150, opacityValue));
        const opValue = (opacityValue + 150) / 300;
        const imgData = this.ctx.getImageData(this.img.width + 20, 10, this.img.width, this.img.height);
        for (let i=0; i<imgData.data.length; i=i+4) {
            const alpha = Math.min(255, Math.max(0, imgData.data[i+3] * opValue));
            imgData.data[i+3] = Math.max(20, alpha);
        }
        this.ctx.clearRect(0, 0, this.img.width * 2 + 30, this.img.height + 20);
        this.ctx.fillStyle = "green";
        this.ctx.fillRect(0, 0, this.img.width * 2 + 30, this.img.height + 20);
        this.ctx.drawImage(this.img, 10, 10);
        this.ctx.putImageData(imgData, this.img.width + 20, 10);
    }
}

export class Tone extends Filtre {
    constructor(ctx, img) {
        super(ctx, img, "tono.png");
    }

    applyTone(sliderValue) {
        const imgData = this.ctx.getImageData(this.img.width + 20, 10, this.img.width, this.img.height);
        const c = (sliderValue / 150) * 75;
        for (let i=0; i<imgData.data.length; i=i+4){
            imgData.data[i] = imgData.data[i] + c;
            imgData.data[i+2] = imgData.data[i+2] - c;
        }
        this.ctx.clearRect(0, 0, this.img.width * 2 + 30, this.img.height + 20);
        this.ctx.fillStyle = "green";
        this.ctx.fillRect(0, 0, this.img.width * 2 + 30, this.img.height + 20);
        this.ctx.drawImage(this.img, 10, 10);
        this.ctx.putImageData(imgData, this.img.width + 20, 10);
    }
}

export class NoFilter extends Filtre {
    constructor(ctx, img) {
        super(ctx, img, "no-filtro.png");
    }

    applyNoFilter() {
        const imgData = this.ctx.getImageData(this.img.width + 20, 10, this.img.width, this.img.height);
        this.ctx.clearRect(0, 0, this.img.width * 2 + 30, this.img.height + 20);
        this.ctx.fillStyle = "green";
        this.ctx.fillRect(0, 0, this.img.width * 2 + 30, this.img.height + 20);
        this.ctx.drawImage(this.img, 10, 10);
        this.ctx.putImageData(imgData, this.img.width + 20, 10);
    }
}