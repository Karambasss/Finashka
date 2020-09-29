print("Задание 1")
{
  n <-readline(" Введите число N -> ")
  n = as.numeric(n)
  year <- n %/% 360
  nw = n - year*360
  month <- (nw) %/% 30 * 1
  weekday <- n %% 7
  day <- n %% 30
  weekday.name <- c("Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье")
  month.name <- c("Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь")
  print(paste("Введенное число N соответствует", weekday.name[weekday], day, month.name[month], year+1,  "Год"))
}

print("Задание 2")
{
  x <- scan()
  x <- sort(x ,decreasing = T)

  print(paste(x[1] , " > ",x[2] , " > ",x[3] , " > ",x[4] , " > ",x[5] , " > ",x[6] , " > ",x[7] , " > ",x[8]))

}

print("Задание 3")

{
  digit = readline("Введите число: ")
  digit = tolower(digit)
  while (digit != "стоп"){
    digit = readline("Введите число: ")
    digit = tolower(digit)
  }
}

print("Задание 4")

{
  numm <- readline("Введите число: ")
  numm <-  as.integer(numm)
  x = 0
  range <- seq(1:numm)
  range
  for (i in range){
    x = x + i
  }
  print(x)
}

print("Задание 5")

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

print("Задание 6")

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

print("Задание 7")

{
  n <- readline("Введите число: ")
  n <- as.integer(n)
  
  i = 0
  daysMonth <- c(31, 28, 31, 30, 31, 30,  31, 30, 31, 30, 31, 31)
  
  monthLst <- c("Января", "Февраля", "Марта","Апреля","Мая","Июня","Июля","Августа","Сентября",
                "Октября","Ноября","Декабря")
  
  week <- c("Понедельнику", "Вторнику", "Среде","Четвергу","Пятнице","Субботе","Воскресенью")
  
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
    "Введенное значение N соответствует" ,
    day ,
    digit,
    mounth ,
    ", " ,
    year ,
    "-й год."
  ))
}
