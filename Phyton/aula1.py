def maratona(a):
	return a % 3

def pot(b, e):
	if e == 0:
		return 1
	if e == 1:
		return b
	return b * pot(b, e-1)

def fib(a):
	if a == 0:
		return 0
	if a == 1:
		return 1
	return fib(a-1) + fib(a-2)

def main():
	a = input();
	b = input();
	print "resultado =  %d" % (pot(a, b))

if __name__=="__main__":
   	main()