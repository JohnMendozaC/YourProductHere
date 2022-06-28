# YourProductHere
App que permite realizar la búsqueda, visualización y detalle de los productos, utilizando una de las APIs de Mercado libre.

## Funcionamiento
La app consta de tres pantallas, cada pantalla tiene una secuencia, donde una depende de la otra para consultar, listar y detallar los productos.

1. Pantalla para la búsqueda de productos: en esta pantalla válida si el producto ingresado tiene resultados para mostrar.
  - Cuenta con las siguientes validaciones:
    - Número de caracteres máximo 40.
    - Permite solo el ingreso de caracteres alfanuméricos, no permite ingresar caracteres especiales.
    - Valida si hay conexión a internet para realizar la búsqueda.
    - Valida si la búsqueda que realiza encuentra resultados para mostrar.
  - Funcionamiento:
    - Ingresar en la caja de texto el producto que desea buscar.
    - Darle click al botón de buscar.  

   ![picture](https://github.com/JohnMendozaC/YourProductHere/blob/main/busqueda_producto.png)

2. Pantalla para listar los productos: en esta pantalla se muestra un listado de productos que fue consultado en la pantalla de búsqueda.
  - Cuenta con las siguientes validaciones:
    - Si no hay productos muestra una pantalla indicando que no hay productos que mostrar.
  - Funcionamiento:
    - Scroll en el listado para visualizar los productos resultado de la búsqueda.
    - Clickear uno de los productos de la lista para ver el producto con más detalle. 

   ![picture](https://github.com/JohnMendozaC/YourProductHere/blob/main/listado_productos.png)

3. Pantalla para el detalle del producto: en esta pantalla se muestra el detalle del productos que fue consultado en la pantalla del listado de productos.
  - Cuenta con las siguientes validaciones:
    - Si no hay producto muestra una pantalla indicando que no hay productos que mostrar.
  - Funcionamiento:
    - Visualizar detalles del producto.
    - Si desea comprar el producto, al darle click en el link de compra lo dirige al navegador donde se encuentra la publicación del producto en la página de mercado libre.

   ![picture](https://github.com/JohnMendozaC/YourProductHere/blob/main/detalle_producto.png)

## Descripción de arquitectura
Esta app fue construida con un modelo por capas, donde se encuentra application, domain e infraestructure, cada una de las capas cuenta con una responsabilidad, esto facilita el escalamiento de funcionalidades y mantenimiento.

 - Application: en esta capa se encontrara todo lo relacionado a la comunicación del contrato con la vista y lógica visual, se encuentran el activity, fragments y la inyección de dependencias.
   - Se integran componentes del guideline de google como lo son viewbinding, navigation, livedata y viewmodel.
   - Para la comunicación con el dominio, se hace mediante interfaces para evitar que se acople la logica del negocio con la lógica visual.
   - Para la inyección de dependencias se hace uso de Hilt.
   - Se agrega capa 'intent', para agregar las intenciones dirigidas a la vista, como lo seria 'loadProduct' o cargar el producto.

 - Domain: en esta capa se encontrara todo lo relacionado a la lógica del negocio, donde se ve todo lo que debe validar y mostrar en llegados eventos. Por ejemplo, si no tiene conexión a internet, enviar un código de error para que la capa application pueda mostrar un mensaje.
   - En esta capa se realizan las pruebas unitarias, ya que es donde se encuentra la logica de negocio y es la que aporta valor probar y validar la calidad de los eventos y reglas respecto al objetivo de la app.

 - Infraestructure: en esta capa se encontrara todo lo relacionado a la lógica de obteción de data, para este caso el consumo del servicio del APIs, esto es para separar la responsabilidad de interacción con sistemas externos.
   - Para el consumo del servicio se hace uso de retrofit.    


## Análisis de vistas

 - Pantalla de búsqueda:


   ![picture](https://github.com/JohnMendozaC/YourProductHere/blob/main/pantalla_busqueda_productos.png)

 - Pantalla de listado de productos:


   ![picture](https://github.com/JohnMendozaC/YourProductHere/blob/main/pantalla_listado_de_productos.png)

 - Pantalla de detalle de producto: 


   ![picture](https://github.com/JohnMendozaC/YourProductHere/blob/main/pantalla_detalle_producto.png)
