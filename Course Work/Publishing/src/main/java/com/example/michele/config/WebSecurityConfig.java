package com.example.michele.config;

import com.example.michele.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
/**
 * <p>Класс, необходимый для реализации функционала, служит для работы авторизации и аутентификации пользователей</p>
 * @author Кузнецов Михаил
 * */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;
    /**
     * <p>Метод для настроек авторизаци, в нем устанавливаются различные параметры для авторизации</p>
     * Так же в данном методе существует настройка страниц, не требующих авторизации, предусмотрена кнопка выхода из личного аккаунта
     * */
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests() // добавляем авторизацию
                .antMatchers("/","/mainPage","/aboutMe", "/registration").permitAll() //не требует авторизации если это не вот такие юрл как написано ( то вызываем форму логина )
                .anyRequest().authenticated() // дЛя всех остальных юрл авторизация нужна
                .and()
                .formLogin() // Включаем форму логин
                .loginPage("/login") //находится на таком юрл форма регистрации то где можно войти во все приложения кроме тех которые не требуют авторизации
                .permitAll() // разрешаем всем пользоваться
                .failureUrl("/login?error=true")
                .and()
                .logout() // Включаем выход (логаут)
                .permitAll(); // разрешаем всем пользоваться

    }
    /**
     * <p>Данный метод показывает, каким образом будет проходить авторизация</p>
     * */
    @Override // Каким именно образом будет происходить авторизация ( тут он будет проверку делать данных из авторизации )
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // аутентификация - сопоставление пользователя уже индентифицированного
        auth.userDetailsService(userService) //проверь информацию
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

}
