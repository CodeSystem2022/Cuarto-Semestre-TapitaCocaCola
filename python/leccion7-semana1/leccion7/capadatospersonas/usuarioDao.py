import logging

from capadatospersonas.Usuario import Usuario
from capadatospersonas.cursor_del_pool import CursorDelPool
log = logging.getLogger(__name__)

class UsuarioDao:
    """
    DAO->Data Acces object
    CRUD
    """

    _SELECT = 'SELECT * FROM usuario ORDER BY id_usuario'
    _INSERTAR = 'INSERT INTO usuario (id_usuario, username, password) VALUES (%s, %s, %s)'
    _ACTUALIZAR = 'UPDATE usuario SET username=%s, password=%s WHERE id_usuario= %s'
    _ELIMINAR = 'DELETE FROM usuario WHERE id_usuario=%s'

    @classmethod
    def seleccionar(cls):
        with CursorDelPool() as cursor:
            log.debug('Seleccionando usuarios')
            cursor.execute(cls._SELECT)
            registros = cursor.fetchall()
            usuarios = []
            for registro in registros:
                usuario = Usuario(registro[0], registro[1], registro[2])  # Create a single Usuario object
                usuarios.append(usuario)  # Append the Usuario object to the usuarios list
            return usuarios

    @classmethod
    def insertar(cls,usuario):
        with CursorDelPool() as cursor:
            log.debug(f'usuario a insertar: {usuario}')
            valores= (usuario.id_usuario,usuario.username,usuario.password)
            cursor.execute(cls._INSERTAR,valores)
            return cursor.rowcount

    @classmethod
    def actualizar(cls,usuario):
        with CursorDelPool() as cursor:
            log.debug(f'usuario a actualizar{usuario}')
            valores = (usuario.username,usuario.password,usuario.id_usuario)
            cursor.execute(cls._ACTUALIZAR,valores)
        return cursor.rowcount

    @classmethod
    def eliminar(cls,usuario):
        with CursorDelPool() as cursor:
            log.debug(f'Usuario a eliminar {usuario}')
            valores= (usuario._id_usuario)
            cursor.execute(cls._ELIMINAR,valores)
        return  cursor.rowcount


if __name__ == '__main__':
    #eliminar usuario
    usuario = Usuario(id_usuario=2)
    usuario_eliminado = UsuarioDao.eliminar(usuario)
    log.debug(f'Usuario eliminado {usuario_eliminado}')

    #insetar usuario
    usuario = Usuario(username='ema',password='3214')
    usuario_insertado = UsuarioDao.insertar(usuario)
    log.debug(f'el usuario insertado es {usuario_insertado}')


    #usuario actualizado
    usuario = Usuario(id_usuario=1,username='',password='nuevopass')
    usuario_modificado= UsuarioDao.actualizar(usuario)
    log.debug(f'el usuario modificado fue { usuario_modificado}')


    #listar o seleccionar

    usuarios = UsuarioDao.seleccionar()
    for usuario in usuarios:
        log.debug(usuario)






