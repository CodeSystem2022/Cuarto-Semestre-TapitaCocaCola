
#help(str.capitalize)
mensaje1='Hola mundo'
mensaje2=mensaje1.capitalize()
print(f'Mensaje1: {mensaje1}, id: {id(mensaje1)}')
print(f'Mensaje: {mensaje2}, id {id(mensaje2)}')

mensaje1+=' Adios'
print(f'Mensaje1: {mensaje1}, id: {id(mensaje1)}')