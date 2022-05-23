# Rick and Morty App

Aplicación que consulta a la api  https://rickandmortyapi.com/ y obtiene una lista de los personajes de la serie los cuales, se pueden seleccionar para ver en una vista propia sus caracteristicas principales.

#### Arquitectura
En esta app se aplica el patrón de diseño MVVM de una manera simplificada, utilizando la separación de la lógica y vistas en conjunto con una clase repositorio única.

#### Librerías utilizadas
* Navigation components
* Retrofit
* Kotlin Coroutines
* Viewmodel y Livedata
* Glide

#### Quedó pendiente
* Se agrego la configuración para Firebase Authentication pero no se alcanzó a crear la lógica para crear un login y registro de usuarios.
* Validación de la conexión a internet, aunque este no era un requerimiento especifico.