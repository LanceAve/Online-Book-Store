document.addEventListener("DOMContentLoaded", function () {
    const cartCountElement = document.getElementById("cart-count");

    // Fetch the real cart count from the server
    fetch("/cart/count")
        .then(response => response.json())
        .then(count => {
            cartCountElement.innerText = count.toString();
        })
        .catch(error => {
            console.error("Error fetching cart count:", error);
            cartCountElement.innerText = "0"; // fallback
        });

    // Handle add-to-cart clicks
    document.querySelectorAll(".add-to-cart").forEach(button => {
        button.addEventListener("click", function () {
            const isbn = this.getAttribute("data-isbn");

            fetch(`/cart/add/${isbn}`, { method: "POST" })
                .then(response => response.text())
                .then(() => {
                    // Re-fetch updated count
                    return fetch("/cart/count");
                })
                .then(response => response.json())
                .then(updatedCount => {
                    cartCountElement.innerText = updatedCount.toString();
                })
                .catch(error => console.error("Error updating cart count:", error));
        });
    });
});