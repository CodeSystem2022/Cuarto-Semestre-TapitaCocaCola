valor = 15
resultado = bool(valor)
print(f'valor: {valor} Resultado: { resultado}')


valor = 0.1
resultado = bool(valor)
print(f'valor:{valor},Resultado{resultado}')

#tipo string

valor = "hola"
resultado = bool(valor)
print(f'valor:{valor},Resultado: {resultado}')

#tipo de colecciones

#->false colecciones vcias
#->true para todas las demas

#lista


valor = [2,3,4]
resultado = bool(valor)
print(f'valor:{valor},Resultado{resultado}')

#tupla
valor = (9,)
resultado = bool(valor)
print(f'valor:{valor},Resultado{resultado}')

#diccionario

valor = {'nombre':'juan'}
resultado = bool(valor)
print(f'valor:{valor},Resultado: {resultado}')

print(f'valor diccionario lleno:{valor},Resultado: {resultado}')

#sentencias de control con bool

if '1':
    print(f'Regresa verdadero')
else:
    print('regresa falso')


#ciclos

variable = ''
while variable:
    print('regresa verdadero')
    break
else:
    print('regresa falso')




