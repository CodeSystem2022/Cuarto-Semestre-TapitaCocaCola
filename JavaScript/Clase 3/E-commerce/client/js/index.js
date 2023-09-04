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
        const repeat = cart.some((repeatProduct) => repeatProduct.id === product.id);

        if (repeat) {
            cart.forEach((prod) => {
                if (prod.id === product.id) {
                    prod.quantity++;
                }
            });
        } else {
            const cartItem = {
                id: product.id,
                productName: product.productName,
                price: product.price,
                quantity: 1, // Inicializar la cantidad en 1 para productos nuevos
                img: product.img,
            };
            cart.push(cartItem);
        }

        console.log(cart);
    });

    content.appendChild(buyButton);

    shopContent.appendChild(content);
});
