from logger_base import log
from psycopg2 import pool
import sys

class Connection:
    _DATABASE = 'test_bd'
    _USERNAME = 'postgres'
    _PASSWORD = 'admin'
    _DB_PORT = '5432'
    _HOST = '127.0.0.1'
    _MIN_CON = 1
    _MAX_CON = 5
    _pool = None

    @classmethod
    def Obtenerconnection(cls):
        conexion = cls.obtenerpool().getconn()
        log.debug(f'conexion obtenida del pool: {conexion}')
        return conexion

    @classmethod
    def obtenerCursor(cls, conexion):
        return conexion.cursor()

    @classmethod
    def obtenerpool(cls):
        if cls._pool is None:
            try:
                cls._pool = pool.SimpleConnectionPool(cls._MIN_CON,
                                                      cls._MAX_CON,
                                                      host=cls._HOST,
                                                      user=cls._USERNAME,
                                                      password = cls._PASSWORD,
                                                      port = cls._DB_PORT,
                                                      database = cls._DATABASE)
                log.debug(f'creacion de pool de conexion exitosa:  {cls._pool}')
                return cls._pool
            except Exception as e:
                log.error(f'ocurrio un error al obtener el pool: {e}')
                sys.exit()
        else:
            return cls._pool

    @classmethod
    def liberarConexion(cls, conexion):
            cls.obtenerpool().putconn(conexion)
            log.debug(f'Regresamos la conexión al pool: {conexion}')

    @classmethod
    def cerrarConexiones(cls):
            cls.obtenerpool().closeall()


if  __name__ == '__main__':
    conexion1 = Connection.Obtenerconnection()
    Connection.liberarConexion(conexion1)
    conexion2 = Connection.Obtenerconnection()
    Connection.liberarConexion(conexion2)
    conexion3 = Connection.Obtenerconnection()
    Connection.liberarConexion(conexion3)
    conexion4 = Connection.Obtenerconnection()
    Connection.liberarConexion(conexion4)
    conexion5 = Connection.Obtenerconnection()
    Connection.liberarConexion(conexion5)



