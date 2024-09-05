print("hello world")

for num in 0 ... 100 where num % 2 == 0 {
    print (num)
}
print("*********")

var a = 7
var b = 20
if a*b > 10 {
    print (a)
} else {
    print (b)
}
print("*********")

var k = 9
for i in 10...50 where i % 2 != 0 {
if (i + k) % 2 == 0 {
k += 2
} else {
print("Next")
continue
}
}
print("*********")

var kk = 9
for i in 10...50 where i % 2 != 0 {
if (i + kk) % 2 == 0 {
kk += 1
} else {
print("Next")
break
}
}