#Profundizando en tipo float

a = 3.0
print(f'a:{a:.2f}')


#el constructor de tipo float puede recibir enteros y strings

a = float(10)#Le pasamos un tipo entero
print(f'a:{a:.2f}')

a = float('10')#le pasamos un string
print(f'a:{a:.2f}')

#Notacion exponencial(valores positivos y negativos)
a = 3e5
print(f'a exponencial = {a}')
print(f'a:{a:.2f}')

a =3e-5#negativo
print(f'a: {a:.5f}')

#Cualquier calculo que incluye un float todo cambia a float


