#manejo de valores infinitos
import math

infinito_positivo = float('inf')

print(f'infinito positivo= {infinito_positivo}')
print(f'Es infinito :{math.isinf(infinito_positivo)} ')

infinito_negativo = float('-inf')
print(f'Infinito negativo: {infinito_negativo}')
print(f'es infinito:{math.isinf(infinito_negativo)}')

#modulo math

infinito_positivo = math.inf
print(f'infinito positivo= {infinito_positivo}')
print(f'Es infinito :{math.isinf(infinito_positivo)} ')

infinito_positivo = -math.inf
print(f'infinito positivo= {infinito_positivo}')
print(f'Es infinito :{math.isinf(infinito_positivo)} ')