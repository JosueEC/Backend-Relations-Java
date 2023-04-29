EJEMPLO DE CREACION DE RELACIONES ONE-TO-ONE, ONE-TO-MANY, MANY-TO-MANY.

1.-Creamos nuestro proyecto a traves de spring initializer o en IntellIj
si es que contamos con la version de paga.

2.-Agregamos las dependencias Spring Web, JPA, y el driver de PostgreSQL

3.-Creamos nuestra division de carpetas

-domain: Almacena las entidades de nuestro proyecto

-repository: Almacena las interfaces para nuestras entidades

4.-Creamos nuestras entidades, estas son clases de Java que se identifican
con la etiqueta @Entity para que JPA pueda identificarlas como un objeto a 
mapear

5.-Definimos los parametros de cada entidad, nombre de la entidad, columnas,
tipos de datos, sequencias, restricciones, etc. Mientras mas explicitos seamos
es mejor.