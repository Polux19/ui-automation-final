# Casos de Prueba - SauceDemo

Este documento detalla los escenarios de prueba para las funcionalidades de Login y Carrito.

## 1. Funcionalidad: Inicio de Sesión (Login)

| ID | Escenario | Pasos | Resultado Esperado |
|:---|:---|:---|:---|
| CP-01 | Login Exitoso | Ingresar `standard_user` y `secret_sauce`. Clic en Login. | El usuario ingresa a la pantalla de productos. |
| CP-02 | Usuario Bloqueado | Ingresar `locked_out_user` y `secret_sauce`. Clic en Login. | Aparece mensaje: "Epic sadface: Sorry, this user has been locked out." |
| CP-03 | Contraseña Incorrecta | Ingresar `standard_user` y clave errónea. Clic en Login. | Aparece mensaje de credenciales inválidas. |
| CP-04 | Usuario Inexistente | Ingresar un usuario que no existe. Clic en Login. | Aparece mensaje de credenciales inválidas. |
| CP-05 | Campos Vacíos | Dejar usuario y clave vacíos. Clic en Login. | Aparece mensaje indicando que el usuario es requerido. |

## 2. Funcionalidad: Carrito de Compras

| ID | Escenario | Pasos | Resultado Esperado |
|:---|:---|:---|:---|
| CP-06 | Agregar Producto | Clic en "Add to cart" de un producto. | El botón cambia a "Remove" y el icono del carrito muestra "1". |
| CP-07 | Verificar Detalle | Agregar producto e ingresar al carrito. | El nombre y precio del producto coinciden con el catálogo. |
| CP-08 | Quitar desde Inicio | Agregar un producto y hacer clic en "Remove" en la misma pantalla. | El botón vuelve a decir "Add to cart" y el contador del carrito desaparece. |
| CP-09 | Quitar desde Carrito | Entrar al carrito y hacer clic en "Remove" al lado del producto. | El producto desaparece de la lista del carrito. |
| CP-10 | Agregar Múltiples | Clic en "Add to cart" en tres productos diferentes. | El contador del carrito muestra el número "3". |