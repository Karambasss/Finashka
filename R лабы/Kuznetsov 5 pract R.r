print("������� 1")
{
  n <-readline(" ������� ����� N -> ")
  n = as.numeric(n)
  year <- n %/% 360
  nw = n - year*360
  month <- (nw) %/% 30 * 1
  weekday <- n %% 7
  day <- n %% 30
  weekday.name <- c("�����������", "�������", "�����", "�������", "�������", "�������", "�����������")
  month.name <- c("������", "�������", "����", "������", "���", "����", "����", "������", "��������", "�������", "������", "�������")
  print(paste("��������� ����� N �������������", weekday.name[weekday], day, month.name[month], year+1,  "���"))
}

print("������� 2")
{
  x <- scan()
  x <- sort(x ,decreasing = T)

  print(paste(x[1] , " > ",x[2] , " > ",x[3] , " > ",x[4] , " > ",x[5] , " > ",x[6] , " > ",x[7] , " > ",x[8]))

}

print("������� 3")

{
  digit = readline("������� �����: ")
  digit = tolower(digit)
  while (digit != "����"){
    digit = readline("������� �����: ")
    digit = tolower(digit)
  }
}

print("������� 4")

{
  numm <- readline("������� �����: ")
  numm <-  as.integer(numm)
  x = 0
  range <- seq(1:numm)
  range
  for (i in range){
    x = x + i
  }
  print(x)
}

print("������� 5")

{
  numm <- readline()
  numm1 <- as.double(numm)
  numm2 <- as.integer(numm)
  
  if (numm1 == numm2){
    print("Yes")
  }else{
    print("No")
  }
  
}

print("������� 6")

{
  a <- readline()
  a1 <- as.integer(a)
  b <- readline()
  b1 <- as.integer(b)
  
  range <- (a1:b1)
  for (i in range){
    if (i %% 3 == 0){
      print(i)
    }
  }
}

print("������� 7")

{
  n <- readline("������� �����: ")
  n <- as.integer(n)
  
  i = 0
  daysMonth <- c(31, 28, 31, 30, 31, 30,  31, 30, 31, 30, 31, 31)
  
  monthLst <- c("������", "�������", "�����","������","���","����","����","�������","��������",
                "�������","������","�������")
  
  week <- c("������������", "��������", "�����","��������","�������","�������","�����������")
  
  year = n %/% 365 + 1
  digit <- n - 365 * (year - 1)
  
  while (digit > 28){
    i = i + 1
    if (daysMonth[i] == digit){
      digit = daysMonth[i]
      break
    }else{
      digit = digit - daysMonth[i]
    }
  }
  
  day <- week[n %% 7]
  
  i = 0
  numberMounth = n%% 365
  while (numberMounth > 0){
    i = i + 1
    numberMounth = numberMounth - daysMonth[i]
  }
  
  mounth = monthLst[i]
  
  
  print(paste(
    "��������� �������� N �������������" ,
    day ,
    digit,
    mounth ,
    ", " ,
    year ,
    "-� ���."
  ))
}
