const slides = document.querySelectorAll(".slide");
let atual = 0;

setInterval(() => {

    slides[atual].classList.remove("active");

    atual++;

    if(atual >= slides.length){
        atual = 0;
    }

    slides[atual].classList.add("active");

}, 4000);