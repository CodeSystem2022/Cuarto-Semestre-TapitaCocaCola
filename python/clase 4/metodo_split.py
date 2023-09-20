help(str.split)

cursos = 'java javascript node python diseño'
lista_cursos = cursos.split()
print(f'list de cursos: {lista_cursos}')

print(type(lista_cursos))

cursos_separados_coma = 'Java,Python,Node,JavaScript,Spring'
lista_cursos = cursos_separados_coma.split(',',5)
print(f'lista de curso: {lista_cursos}')
print(len(lista_cursos))