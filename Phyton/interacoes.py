#raw_input serve para entrada de strings#
nomes = []
cont = 0

while cont < 3 :
	nomes.append(raw_input());
	cont+=1

print("\n")

for n in nomes:
	print(n)
	
print("\n")