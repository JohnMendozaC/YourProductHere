# YourProductHere
App que permite realizar la búsqueda de productos, visualizar los productos y el detalle de un producto seleccionado, utilizando una de las APIs de Mercado libre.

## Funcionamiento
La app consta de tres pantallas, cada pantalla tiene una secuencia, donde una depende de la otra para consultar, listar y detallar los productos.

 1. Pantalla para la busqueda de productos: en esta pantalla de encuentra una caja de texto, donde el usuario puede ingresar el producto que desea buscar.
  - Cuenta con las siguientes validaciones:
    - Numero de caracteres maximo 40.
    - Permite solo el ingreso de caracteres alfanumericos, no permite ingresar caracteres especiales.
    - Valida si hay conexion a internet para realizar la busqueda.
    - Valida si la busqueda que realiza encuentra resultados para mostrar.
  - Funcionamiento:
   - Ingresar en la caja de texto el producto que desea buscar.
   - Darle click al boton de buscar.  

   Imagen: 
   ![picture](https://github.com/JohnMendozaC/YourProductHere/blob/main/busqueda_producto.png)


 2. Pantalla para listar los productos: en esta pantalla se muestra un listado de productos que fue consultado en la pantalla de busqueda.
  - Cuenta con las siguientes validaciones:
    - Si no hay productos muestra una pantalla indicando que no hay productos que mostrar.
  - Funcionamiento:
   - Scroll en el listado para visualizar los productos resultado de la busqueda.
   - Clickear uno de los productos de la lista para ver el producto con mas detalle. 

   Imagen: 
   ![picture](https://github.com/JohnMendozaC/YourProductHere/blob/main/listado_productos.png)

3. Pantalla para el detalle del producto: en esta pantalla se muestra el detalle del productos que fue consultado en la pantalla del listado de productos.
  - Cuenta con las siguientes validaciones:
    - Si no hay producto muestra una pantalla indicando que no hay productos que mostrar.
  - Funcionamiento:
   - Visualizar detalles del producto.
   - Si desea comprar el producto, al darle click en el link de compra lo dirige al navegador donde se encuentra la publicacion del producto en la pagina de mercado libre.

   Imagen: 
   ![picture](https://github.com/JohnMendozaC/YourProductHere/blob/main/detalle_producto.png)

## Descripcion de arquitectura
Esta app fue construida con un modelo por capas, donde se encuentra application, domain e infraestructure, cada una de las capas cuenta con una responsabilidad, esto facilita el escalamiento de funcionalidades y mantenimiento.

 - application: en esta capa se encontrara todo lo relacionado a la comunicacion con el contrato con la vista y logica visual, se encuentran el activity, fragments y la inyeccion de dependencias.
   - Se integran componentes del guideline de google como lo son viewbinding, navigation, livedata y viewmodel.
   - Para la comunicacion con el dominio, se hace mediante interfaces, para evitar que se acople la logica del negocio, con la logica visual.
   - Para la inyeccion de dependencias se hace uso de Hilt.

 - domain: en esta capa se encontrara todo lo relacionado a la logica del negocio, donde se ve todo lo que debe validar y mostrar en llegados eventos, por ejemplo si no tiene conexion a internet, enviar un codigo de error para que la capa application pueda mostrar un mensaje.
  - En esta capa se realizan las pruebas unitarias, ya que es donde se encuentra la logica de negocio y es la que aporta valor probar y validar la calidad de los eventos y reglas respecto al objetivo de la app.

- Infraestructure: en esta capa se encontrara todo lo relacionado a la logica de obtecion de data, para este caso el consumo del servicio del APIs, esto debe estar separa ya que separa la responsabilidad de interactura con sistemas externos.
 - Para el consumo del servicio se hace uso de retrofit.    


## Analisis de vistas

 - Pantalla de busqueda:

 Imagen: 
   ![picture](https://github.com/JohnMendozaC/YourProductHere/blob/main/pantalla_busqueda_productos.png)

 - Pantalla de listado de productos:

 Imagen: 
   ![picture](https://github.com/JohnMendozaC/YourProductHere/blob/main/pantalla_listado_de_productos.png)

 - Pantalla de detalle de producto: 

 Imagen: 
   ![picture](https://github.com/JohnMendozaC/YourProductHere/blob/main/pantalla_detalle_producto.png)
