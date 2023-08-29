const shopContent = document.getElementById("shopContent");
const cart = [];

productos.forEach((product) => {
    const content = document.createElement("div");
    content.innerHTML = `
        <img src="${product.img}">
        <h3>${product.productName}</h3>
        <p>${product.price}$</p>
    `;

    const buyButton = document.createElement("button");
    buyButton.innerText = "Comprar";

    buyButton.addEventListener("click", () => {
        const cartItem = {
            id: product.id,
            productName: product.productName,
            price: product.price,
            quantity: product.quantity,
            img: product.img
        };

        cart.push(cartItem);
        console.log(cart);
    });

    content.appendChild(buyButton); // Usar appendChild para consistencia

    shopContent.appendChild(content);
});
