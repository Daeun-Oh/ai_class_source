window.addEventListener("DOMContentLoaded", function() {
    var swiper = new Swiper(".slide-banner", {
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
        pagination: {
            el: ".swiper-pagination",
        },
        loop: true,
    });
});