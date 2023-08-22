from capadatospersonas.Persona import Persona
from connection import Connection
from logger_base import log


class PersonaDao:
    """
    DAO=data access object
    CRUD= create,read,update,delete
    """
    _seleccionar = 'SELECT * FROM persona ORDER BY id_persona'
    _insertar = 'INSERT INTO persona(nombre,apellido,email)VALUES(%s,%s,%s)'
    _actualizar = 'UPDATE persona SET nombre = %s,apellido = %s,email=%s WHERE id_persona=%s'
    _eliminar = 'DELETE FROM persona WHERE id_persona= %s'

    #definimos los metodos de clase

    @classmethod
    def seleccionar(cls):
        with Connection.Obtenerconnection():
            with Connection.ObtenerCursor() as Cursor:
                Cursor.execute(cls._seleccionar)
                registros = Cursor.fetchall()
                personas = []  # creamos una lista
                for registro in registros:
                    persona = Persona(registro[0], registro[1], registro[2], registro[3])
                    personas.append(persona)
                return personas






    @classmethod
    def insertar(cls,persona):
        with Connection.Obtenerconnection():
            with Connection.ObtenerCursor() as Cursor:
                valores = (persona.nombre,persona.apellido,persona.email)
                Cursor.execute(cls._insertar,valores)
                log.debug(f'Persona insertada: {persona}')
                return Cursor.rowcount

    @classmethod
    def actualizar(cls,persona):
        with Connection.Obtenerconnection():
            with Connection.ObtenerCursor() as Cursor:
                valores = (persona.nombre,persona.apellido,persona.email,persona.id_persona)
                Cursor.execute(cls._actualizar, valores)
                log.debug(f'Persona actualizada {persona}')
                return Cursor.rowcount

    @classmethod
    def eliminar(cls, persona):
        with Connection.Obtenerconnection():
            with Connection.ObtenerCursor() as Cursor:
                valores = (persona.id_persona,)
                Cursor.execute(cls._eliminar,valores)
                log.debug(f'El objeto eliminado: {persona}')
                return Cursor.rowcount








if __name__ == "__main__":
#Eliminar
    persona1 = Persona(id_persona=18)
    personas_eliminadas=PersonaDao.eliminar(persona1)
    log.debug(f'personas eliminadas: { personas_eliminadas}')


    #Actualizar
    #persona1 = Persona(1,'juanjose', 'pena', 'jjpena@gmail.com',)
    #personas_upgrades = PersonaDao.actualizar(persona1)
    #log.debug(f'Personas upgrades: {personas_upgrades}')


    # seleccionar
   # personas = PersonaDao.seleccionar() #aca esta la prueba de seleccionar
    #for persona in personas:
     #   log.debug(persona)


    #insertar un registro
    #objeto1 = Persona(nombre='evita', apellido='amorino',email='uvita@mail.com')
    #personas_insertadas = PersonaDao.insertar(objeto1)
    #log.debug(f'Personas insertadas: {personas_insertadas}')










