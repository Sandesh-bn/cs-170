import csv

with open('winequality-white.csv','rb') as i:
    with open('winequality-white-processed.txt','wb') as o:
        r = csv.reader(i, delimiter=";")
        r.next()
        index = 0
        for a in r:
        	index+=1
        	if index <= 2000:
	        	x = []
	        	x.append(a[-1])
	        	x += a[:len(a) - 1]
	        	o.write(" ".join(x))
	        if index < 2000:
	        	o.write("\n")
            # print a