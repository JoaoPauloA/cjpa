def maximoRec(b, a):
	if a == 0:
	    return b[a]
	c = maximoRec(b, a -1)
	if b[a] >= c:
		return b[a]
	return c
    

v  = [10, 2, 3, 9, 1]

v.sort

print "\n o maior elemento = %d \n" % (maximoRec(v, len(v) - 1))
