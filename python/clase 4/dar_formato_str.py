
#Dar formato a un string

nombre='Ariel'
edad=28
mensaje_con_Formato='Mi nombre es %s y tengo %d años'%(nombre,edad)

#Creamos una tupla
persona=('Carla','Gomez',5000.00)
mensaje_con_Formato='Hola %s %s . Tu sueldo es %.2f' # % persona %Aqui le pasamos el objeto que es tupla


nombre='Juan'
edad=28
sueldo=3000
#mensaje_con_Formato= 'Nombre {} Edad {} Sueldo {:.2f}' .format(nombre,edad,sueldo)
#mensaje='Nombre{0} Edad {1} Sueldo {2:.2f}'.format(nombre,edad,sueldo)
#mensaje='Nombre{2:.2f} Edad {1} Sueldo {0}'.format(nombre,edad,sueldo)
#print(mensaje)
mensaje='Nombre {n} Edad {e} Sueldo {s}'.format(n=nombre,e=edad,s=sueldo)
#print(mensaje)

diccionario={'nombre':'Ivan','edad':35,'sueldo':8000.00}
mensaje='nombre {persona[nombre]} edad {persona[edad]} sueldo{persona[sueldo]:.2f}'.format(persona=diccionario)
print(mensaje)