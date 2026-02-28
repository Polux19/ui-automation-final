# Escenarios de Prueba - SauceDemo

## 1. Funcionalidad: Inicio de Sesión
* **Caso 1 (Éxito):** Ingresar con el usuario `standard_user` y la contraseña `secret_sauce`.
    * **Resultado esperado:** El usuario es redirigido a la página de inventario (`https://www.saucedemo.com/inventory.html`).
* **Caso 2 (Error):** Ingresar con el usuario `locked_out_user` y la contraseña `secret_sauce`.
    * **Resultado esperado:** Se muestra el mensaje de error: "Epic sadface: Sorry, this user has been locked out."

## 2. Funcionalidad: Agregado de productos al carrito
* **Caso 3 (Agregar):** En la página de inventario, hacer clic en el botón "Add to cart" del producto "Sauce Labs Backpack".
    * **Resultado esperado:** El contador rojo sobre el icono del carrito de compras aumenta a "1".
* **Caso 4 (Eliminar):** Hacer clic en el botón "Remove" del producto "Sauce Labs Backpack" previamente agregado.
    * **Resultado esperado:** El contador del carrito de compras desaparece o vuelve a estar vacío.