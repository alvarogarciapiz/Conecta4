
# Conecta 4

El juego Conecta 4 es la evolución del famoso Tres en Raya, con la peculiaridad de que se juega en un tablero de 6 filas por 7 columnas. Cada jugador dispone de 21 fichas de un color (rojo o amarillo) y por turnos deben introducir un ficha en la columna que deseen cayendo esta a la posición más baja no ocupada por otra ficha. El primer jugador que consiga alinear cuatro fichas de su color, gana la partida.


## Funcionamiento
El servidor deberá estar en funcionamiento para que los clientes puedan realizarle peticiones.
Los clientes deberán registrarse para poder acceder a la interfaz de juego. Se tienen dos interfaces:
la de Registro y Login y la de Juego.

- Interfaz de Registro y Login:
![Pantalla de Login](https://i.ibb.co/ZzDNWHZ/Captura-de-Pantalla-2022-06-04-a-las-13-27-43.png)

 Se muestra la opción de logearse en el lado izquierdo y la de registro en el derecho.
 Justo en la parte inferior de los botones se mostrarán los mensajes de error o éxito
 al realizar ambas acciones como: Login correcto, login incorrecto, email repetido,
 nick repetido, la contraseña no cumple con las condiciones de seguridad necesarias o registro correcto.
 
 Si el login es correcto se habilita el botón de 'Acceder al juego', si se trata de acceder sin
 estar previamente logeado se muestra un mensaje de que hay que logearse previamente.

 - Interfaz de Juego:
 ![Pantalla de Juego](https://i.ibb.co/2j2xDzt/Captura-de-Pantalla-2022-06-04-a-las-13-32-54.png)

La interfaz de juego se divide en dos componentes principales, la columna derecha que muestra información sobre el ranking
y los jugadores conectados y la zona izquierda con el propio juego.

/  Ranking: Muestra los 5 mejores jugadores basándose en el número de partidas ganadas. Si el usuario
logeado se encuentra en el ranking su nombre aparecerá en negrita. Existe un botón para actualizar el ranking.

/  Jugadores conectados: Aquís e meustran todos los usuarios que se encuentran logeados en el sistema
para cargarlos hay que rpesionar el botón 'cargar jugadores'. Desde aquí se puede retar a cada uno de ellos
presionando el icono de las espadas. Una vez presionado se manda el reto al otro usuario. En caso de 
cargar jugadores conectados y no haber ninguno se moestrará un aviso.


/  Ayuda: Existe un pequeño botón que muestra o oculta ayuda para el juego incluyendo las normas o funciones básicas
como retar a un jugador o aceptar un reto.

/  Estadísticas: El usuario es representado a la derecha del tablero, aquí se puede ver su nick y sus estadísticas
de juego: partidas ganadas, perdidas y jugadas.

/  Estadísticas rival: Al igual que para el usuario, cuando haya un reto activo se podrán cargra las estadísticas del rival 
para visualizarlas.

/  Retos pendientes: Deajo de la zona del jugador rival se muestran dos botones: Aceptar Reto y 
Denegar reto. Cuando un usuario nos lance un reto nos aparecerá en este espacio. Si se acepta comenzará la partida.

/  Tablero: Finalmente contamos en el tablero, el espacio de juego. Las fichas propias serán representadas
con 'X' y las fichas rivales con 'O'. Para colocar una ficha en una de las columnas se usarán los botones
situados encima de las mismas. En la parte inferior del tablero se mostrarán los mensajes de aviso del juego
como: no es tu turno, columna llena o si la partida ha finalizado se mostrará el ganador y el perdedor.


- Servidor:

El servidor recoge todas las peticiones de los clientes/usuarios, las gestiona y les ofrece la respuesta
acorde. Desde el propio servidor se pueden realizar peticiones desde la consola como: parar el funcionamiento, conocer información
sobre una partida o un jugador o incluso ver el ranking al completo.

## Ejecución
Primero se debe ejecutar el servidor desde la clase 'Principal' y acto seguido la clase 'pantallaLogin' tantas veces como clientes se quieran conectados.

## Autores

- [Álvaro García Pizarro](https://github.com/alvarogarciapiz)
- [Julio Jaime Armengod](https://github.com/JulioJaimeA)
