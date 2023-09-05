
# bool contiene los valores de true y false
# los tipos numericos, es false para el 0 (cero), true para los demas valores
valor = 0
resultado = bool(valor)
print(f'valor: {valor}, resultado: {resultado}')

valor = 0.1
resultado = bool(valor)
print(f'valor: {valor}, resultado: {resultado}')

#tipo string -> false '', true demas valores
valor = ''
resultado = bool(valor)
print(f'valor: {valor}, resultado: {resultado}')

valor = 'Hola'
resultado = bool(valor)
print(f'valor: {valor}, resultado: {resultado}')

#tipo colleciones -> false para colecciones vacias
#tipo colecciones -> true para todas las demas
# lista
valor = []
resultado = bool(valor)
print(f'valor de una lista vacia: {valor}, resultado: {resultado}')

valor = [2, 3, 4]
resultado = bool(valor)
print(f'valor de una lista de elementos: {valor}, resultado: {resultado}')

#tupla
valor = ()
resultado = bool(valor)
print(f'valor de una tupla vacia: {valor}, resultado: {resultado}')

valor = (5,)
resultado = bool(valor)
print(f'valor de una tupla con elementos: {valor}, resultado: {resultado}')

#diccionario
valor = {}
resultado = bool(valor)
print(f'valor de un diccionario vacio: {valor}, resultado: {resultado}')

valor = {'Nombre': 'Juan', 'Apellido': 'Perez'}
resultado = bool(valor)
print(f'valor de un diccionario con elementos: {valor}, resultado: {resultado}')

#sentencias de control con bool
if (1,):
    print('Regresa verdadero')
else:
    print('Regresa falso')

#ciclos
variable = 17
while variable:
    print('Regresa verdadero')
    break
else:
    print('Regresa falso')
