
#help(str.join)

tupla_str=('Hola',"Alumnos",'Tecnicatura','Universitaria')

mensaje='.'.join(tupla_str)
print(f'Mensaje {mensaje}')

lista_cursos=['Java','Puthon','Angular','Spring']
mensaje=', '.join(lista_cursos)
print(f'Mensaje: {mensaje}')

cadena='Hola mundo'
mensaje='.'.join(cadena)
print(f'Mensaje: {mensaje} ')

diccionari={'nombre':'Juan','Apellido': 'Perez', 'Edad':'18'}
llaves='-'.join(diccionari.keys())
valores='-'.join(diccionari.values())
print(f'llaves: {llaves},Type:{type(llaves)}')
print(f'Valores:{valores},Type:{type(valores)}')