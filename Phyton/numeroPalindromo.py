def palindromo(num):
	x  = 0
	aux = num

	while num > 0:
		x += num % 10
		num = num / 10
		x = x*10

	x = x / 10
	if x == aux:
		print("palindromo\n")
	else:
		print("Nao e palindromo\n")

print("\n")
num = input();
(palindromo(num))
