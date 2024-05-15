Titulo: conversor de monedas 
Descripcion: Este es el challenge lanzado por alura latam para la formacion ONE G6
El proyecto funciona seleccionando una cantidad de un tipo de moneda para convertirlo en otra por medio de la informacion brindada por la api exchangeRate-API
Los elementos/funcionalidades  extra que tiene el proyecto son las siguientes:
*Seleccion del tipo de moneda; como un extra a los requerimientos del proyecto, se le permite al usuario seleccionar entre 8 tipos de moneda diferente
*Historial, se guarda en un arraylist todas las solicitudes de conversion realizadas 

Se recomienda correr solo el archivo "PrincipalConExtra" en lugar del archivo "Principal", pues se modificaron algunos de los otros archivos para ser compatibles con esta version y podrian llegar a afectar a la version mas simple del codigo.

El programa sacrifica la cantidad de monedas a elegir con el fin de evitar errores, ya que se aprovecha la funcionalidad de la API llamada pair conversion para realizar el calculo directamente, por lo que el algoritmo del programa se basa en obtener los tipos de cambio deseados y la cantidad para conseguir el link de la API del tipo: GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP.

