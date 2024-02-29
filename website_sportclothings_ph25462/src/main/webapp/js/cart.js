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
// var cartItems = [];
//
// function addToCart() {
//     var item = "Một sản phẩm"; // Thay đổi tên sản phẩm tại đây hoặc có thể lấy từ người dùng
//     cartItems.push(item);
//     updateCartDropdown();
// }
//
// function updateCartDropdown() {
//     var cartItemsList = document.getElementById("cartItems");
//     cartItemsList.innerHTML = "";
//
//     for (var i = 0; i < cartItems.length; i++) {
//         var listItem = document.createElement("li");
//         listItem.textContent = cartItems[i];
//         cartItemsList.appendChild(listItem);
//     }
// }
//
// var cartIcon = document.getElementById("cartIcon");
// var cartDropdown = document.getElementById("cartDropdown");
//
// cartIcon.addEventListener("click", function() {
//     cartDropdown.classList.toggle("show");
// });
//
// window.addEventListener("click", function(event) {
//     if (!event.target.matches("#cartIcon")) {
//         if (cartDropdown.classList.contains("show")) {
//             cartDropdown.classList.remove("show");
//         }
//     }
// });
