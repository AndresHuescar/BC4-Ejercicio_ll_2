Ejercicios Persistencia y bases de datos II 

Con el esquema de la Vuelta Ciclista responde a los siguientes ejercicios: 

Ejercicio 2 

Amplía el programa anterior para ofrecer un menú por consola que permita: 

1. Insertar un nuevo ciclista:
   
  • Pedir por teclado nombre, nacionalidad, edad e id_equipo. 
  
  • Comprobar que el id_equipo existe en la tabla equipo antes de insertar 
    (consulta previa). 
    
  • Insertar en ciclista un nuevo registro generando un id_ciclista nuevo 
    (puedes obtener el máximo actual y sumarle 1).


2. Actualizar un ciclista existente:
   
  • Permitir cambiar la edad y el equipo de un ciclista dado su id_ciclista. 
  
  • Comprobar que el ciclista existe y que el nuevo id_equipo existe.

  
3. Eliminar un ciclista:
   
  • Pedir id_ciclista.
  
  • Antes de eliminarlo de ciclista, eliminar sus filas asociadas en participacion 
    para no violar la clave foránea participacion_ciclista_fk. 
    
  • Confirmar la eliminación por consola. 
