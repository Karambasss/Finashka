print("������� 2")

a <- c(7:4, 0)
b <-c(8, 10.5, 0, -2, 9)

a + b
a * b
a / b

mean(a)

mean(b)

sum(a)

sum(b)


print("������� 4")

a <- c(1:9)
b <-c(1:3)

a + b

a <- c(1, "A", 2.5)

b <-c("E", "A", 7)

a + b


print("������� 6")

as.integer(runif(10)*(28 + 7) - 7)

print("������� 7")

sample(x = -7:-1, size = 20, replace = T) + sample(x = 0:1000, size = 20)/1000


print("������� 8")

numbb <- 4
alph <- c("�", "�", "�", "�", "�", "�", "�", "�", "�")
strsplit(alph, "")
alph[sample(1:length(alph),size = numbb)]

  
  


