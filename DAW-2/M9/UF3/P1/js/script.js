let theme;
const html = document.querySelector("html");
const icon = document.querySelector(".icon");
const arrow = document.querySelector(".arrow");
const ffvii = document.querySelector(".ffvii");

const applyTheme = () => {
    if (theme === "dark") {
        html.classList.add("dark");
        html.classList.remove("light");
        if (arrow) {
            arrow.src = "public/img/flecha_blanca.png";
        }
        if (ffvii) {
            ffvii.src = "public/img/ff7_dark.gif";
        }
    } else {
        html.classList.add("light");
        html.classList.remove("dark");
        if (arrow) {
            arrow.src = "public/img/flecha_oscura.png";
        }
        if (ffvii) {
            ffvii.src = "public/img/ff7_light.gif";
        }
    }
};

const loadTheme = () => {
    theme = localStorage.getItem("theme");
    if (theme === null) {
        theme = "dark";
    }
    applyTheme();
};

loadTheme();

icon.addEventListener("click", () => {
    if (theme === "dark") {
        theme = "light";
    } else {
        theme = "dark";
    }

    applyTheme();
    localStorage.setItem("theme", theme);
});
