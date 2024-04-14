function draw(e) {
    const c = document.getElementById("canvas");
    const nom = e.target.name;
    const myImatge = new Image();
    myImatge.src = `img/${nom}`;
    c.width = myImatge.width + 20;
    c.height = myImatge.height + 20;
    const ctx = c.getContext("2d");
    ctx.fillStyle = "green";
    ctx.clearRect(0, 0, c.width, c.height);
    ctx.drawImage(myImatge, 10, 10);
}

const contenedor = document.getElementById("contenedor");
let template = `<canvas id="canvas"></canvas><div id="imgs"><img src="img/lobo.png" name="lobo.png"> <img src="img/flor.jpg" name="flor.jpg"> <img src="img/pizza.jpg" name="pizza.jpg"> <img src="img/arbol.jpeg" name="arbol.jpeg"><div>`
contenedor.insertAdjacentHTML("beforeend", template);

const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");
ctx.fillStyle = "green";
ctx.fillRect(10, 10, 100, 100);

contenedor.addEventListener("click", draw);