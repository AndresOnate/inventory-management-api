document.addEventListener("DOMContentLoaded", () => {
    const productForm = document.getElementById("product-form");
    const productTable = document.getElementById("product-table");

    const fetchProducts = async () => {
        const response = await fetch("/api/products");
        const products = await response.json();
        productTable.innerHTML = "";
        products.forEach(product => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>
                    <button class="btn btn-danger btn-sm" onclick="deleteProduct(${product.id})">Delete</button>
                </td>
            `;
            productTable.appendChild(row);
        });
    };

    const addProduct = async (name, price) => {
        const response = await fetch("/api/products", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ name, price })
        });
        if (response.ok) fetchProducts();
    };

    const deleteProduct = async (id) => {
        const response = await fetch(`/api/products/${id}`, { method: "DELETE" });
        if (response.ok) fetchProducts();
    };

    productForm.addEventListener("submit", (e) => {
        e.preventDefault();
        const name = document.getElementById("product-name").value;
        const price = parseFloat(document.getElementById("product-price").value);
        if (name && price) {
            addProduct(name, price);
            productForm.reset();
        }
    });

    fetchProducts();
});
