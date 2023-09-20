#Nan
import math
from decimal import Decimal

#not a number

a = float('NaN')

print(f'a: {a}')

#modulo math

a = float('2.0')
print(f'es a de tipo number? { math.isnan(a)}')

#modulo decimal
a = Decimal('nan')

print(f'es a de tipo number? { math.isnan(a)}')

