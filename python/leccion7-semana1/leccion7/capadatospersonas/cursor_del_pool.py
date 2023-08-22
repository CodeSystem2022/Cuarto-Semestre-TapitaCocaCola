from logger_base import log
from connection import Connection

class CursorDelPool:
    def __init__(self):
        self._connection = None
        self._cursor = None

    def __enter__(self):
        log.debug('Inicio del método with y __enter__')
        self._connection = Connection.Obtenerconnection()
        self._cursor = self._connection.cursor()
        return self._cursor

    def __exit__(self, tipo_exception, valor_exception, detalle_exception):
        log.debug('Se ejecuta el método __exit__')
        if valor_exception:
            self._connection.rollback()  # Change _conexion to _connection
            log.debug(f'Ocurrió una excepción: {valor_exception}')
        else:
            self._connection.commit()  # Change _conexion to _connection
            log.debug('Commit de la transacción')
        self._cursor.close()
        Connection.liberarConexion(self._connection)

if __name__ == '__main__':
    with CursorDelPool() as cursor:
        log.debug('Dentro del bloque with')
        cursor.execute('SELECT * FROM persona')
        log.debug(cursor.fetchall())