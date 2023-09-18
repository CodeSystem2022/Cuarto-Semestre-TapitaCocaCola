#help(str.join())

tupla_str = ('Hola','mundo','Tecnicatura','universitaria')

mensaje = '.'.join(tupla_str)

print(f'Mensaje: {mensaje}')

lista_cursos = ['java','angular','python','spring']
print(f'mensaje: {mensaje}')


cadena = 'holamundo'
mensaje = '.'.join(cadena)

print(f'mensaje{mensaje}')

diccionario = {'nombre': 'juan','apellido':'Perez','edad':'18'}
llaves = '-'.join(diccionario)
valores = '_'.join(diccionario.values())
print(f'llaves: {llaves},Type:{type(llaves)}')

print(f'Valores: {valores},Type:{type(valores)}')

