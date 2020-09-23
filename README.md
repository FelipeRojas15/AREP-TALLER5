# AREP-TALLER5 modularización con virtualización e Introducción a Docker y a AWS
En este laboratorio crearemos una aplicacion web que permita ingresar datos y los muestre con su fecha respectiva.  Esto se realizara usando el framework de Spark java, una base de datos Mongo DB, Contenedores Docker y una maquina virtual en AWS.

## Diseño arquitectural de la Aplicación
Para desarrollar esta aplicacion, utlizaremos 5 contenedores Docker que se distribuiran de la siguiente manera:
- La aplicación web sera alojada en 3 contenedores Docker y se conectara al contenedor de la base de datos.
- La base de datos tendra un contenedor.
- El LoadBalancer tendra un contenedor que se encargara de distribuir las solicitudes entre los 3 nodos de la aplicación web.
![Desing](https://i.ibb.co/VHj25bg/Arquitecture-Design.png)

## Integracion Continua
- LoadBalancer
[![CircleCI](https://circleci.com/gh/FelipeRojas15/AREP-TALLER5LOADBALANCER.svg?style=svg)](https://circleci.com/gh/FelipeRojas15/AREP-TALLER5LOADBALANCER)
- Spark Web
[![CircleCI](https://circleci.com/gh/FelipeRojas15/AREP-TALLER5SPARKWEB.svg?style=svg)](https://circleci.com/gh/FelipeRojas15/AREP-TALLER5SPARKWEB)
## Requerimientos 
Se necesita que tenga instalado en su computadora:
```sh
$ Java 1.8
$ Maven 3.6.3
$ Docker
```
## Getting to Start
> **Clonar el repositorio**
```sh
$ https://github.com/FelipeRojas15/AREP-TALLER5
```
> **Clonar imagenes de DockerHub**
```sh
$ docker pull felipereds/loadbalancerdocker:latest
$ docker pull felipereds/sparkwebdocker:latest
```
> **Compilar el proyecto:**
```sh
$ mvn package
```
> **Ejecutar el siguiente comando desde la carpeta docker-compose para visualizar la aplicacion de manera local**
```sh
$ docker-compose up -d --scale web=3
```
> **Ingresar al navegador**
```sh
Para ver la aplicacion
$ localhost:8001 
Para ver los datos registrados
$ localhost:8001/result 
```
## Pruebas para la aplicación
Ingresando un dato para ver el funcionamiento
![Pagina inical](https://i.ibb.co/Hdms8ZZ/HomePage.png)
Vemos un alert con la verificacion de dato ingresado
![datoInsert](https://i.ibb.co/RgK2gXy/Insert-Data.png)
Ahora nos vamos a revisar si se guardo en la base de datos
![Result](https://i.ibb.co/Xz88dFv/Data-Result.png)
## Link AWS
Para ver la aplicación 
http://ec2-18-206-57-11.compute-1.amazonaws.com:8000
Para ver los resultados registrados agregar /result al final del link

## Autor
**Brayan Felipe Rojas Bernal**
## Lincencia
Este proyecto cuenta con la licencia MIT. Para mas detalles [Licencia](https://github.com/FelipeRojas15/AREP-TALLER5/blob/master/LICENSE.txt).
