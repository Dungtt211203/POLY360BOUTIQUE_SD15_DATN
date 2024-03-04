var cartDropdown = document.getElementById("cartDropdown");
var dropdownMenu = document.getElementsByClassName("dropdown-menu")[0];

cartDropdown.addEventListener("click", function() {
    dropdownMenu.classList.toggle("show");
});

window.addEventListener("click", function(event) {
    if (!event.target.matches("#cartDropdown")) {
        if (dropdownMenu.classList.contains("show")) {
            dropdownMenu.classList.remove("show");
        }
    }
});

