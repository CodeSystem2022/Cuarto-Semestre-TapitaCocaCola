const modalContainer = document.getElementById("modal-container");
const modalOverlay = document.getElementById("modal-overlay");
const cartBtn = document.getElementById("cart-btn");

const displayCart = () => {
    modalContainer.innerHTML = "";
    modalContainer.style.display = "block";
    modalOverlay.style.display = "block";

    const modalHeader = document.createElement("div");
    modalHeader.classList.add("modal-header");

    const modalClose = document.createElement("div");
    modalClose.innerText = "❌";
    modalClose.classList.add("modal-close");
    modalHeader.appendChild(modalClose);

    modalClose.addEventListener("click", () => {
        modalContainer.style.display = "none";
        modalOverlay.style.display = "none";
    });

    const modalTitle = document.createElement("div");
    modalTitle.innerText = "Cart";
    modalTitle.classList.add("modal-title");
    modalHeader.appendChild(modalTitle);

    modalContainer.appendChild(modalHeader);
};

cartBtn.addEventListener("click", displayCart);
