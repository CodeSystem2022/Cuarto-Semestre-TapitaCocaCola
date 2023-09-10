from capadatospersonas.Usuario import Usuario
from logger_base import log
from capadatospersonas.usuarioDao import UsuarioDao

opcion = None
while opcion != 5:
    print('Opciones')
    print('1-listar usuarios')
    print('2-Agregar usuario')
    print('3-modificar usuario')
    print('4-eliminar usuario')
    print('5-salir')

    try:
        opcion = int(input('digite la opcion (1-5): '))

        if opcion == 1:
            usuarios = UsuarioDao.seleccionar()
            for usuario in usuarios:
                log.info(usuario)

        elif opcion == 2:
            id_usuario_var = int(input("ingrese el id del usuario: "))
            username_var = input("ingrese el nombre del usuario: ")
            password_var = input("ingrese la contraseña: ")
            usuario = Usuario(id_usuario=id_usuario_var, username=username_var, password=password_var)
            usuario_insertado = UsuarioDao.insertar(usuario)
            log.info(f'Usuario insertado: {usuario_insertado}')

        elif opcion == 3:
            id_usuario_var = int(input('digite el id del usuario a modificar: '))
            username_var = input('digite el nombre: ')
            password_var = input('digite la contraseña: ')
            usuario = Usuario(id_usuario=id_usuario_var, username=username_var, password=password_var)
            usuario_actualizado = UsuarioDao.actualizar(usuario)
            log.info(f'usuario actualizado: {usuario_actualizado}')

        elif opcion == 4:
            id_usuario_var = int(input('digite el id del usuario a eliminar: '))
            usuario = Usuario(id_usuario=id_usuario_var)
            usuario_eliminado = UsuarioDao.eliminar(usuario)
            log.info(f'el usuario eliminado es: {usuario_eliminado}')

        elif opcion == 5:
            log.info('salimos de la app')
            break  # Exit the loop when the user chooses to exit

        else:
            log.warning('Opción no válida. Por favor, elija una opción válida (1-5).')

    except ValueError:
        log.error('Error: Por favor, ingrese un valor numérico válido.')

    except Exception as e:
        log.error(f'Error inesperado: {e}')