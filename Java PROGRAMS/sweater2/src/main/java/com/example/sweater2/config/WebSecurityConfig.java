package com.example.sweater2.config;

import com.example.sweater2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

// Класс который при старте приложение конфигурирует вебСекюрити
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    @Override
    protected void configure(HttpSecurity http) throws Exception { // Авторизация - проверка подлинности данных человека который хочет войти
        http
                .authorizeRequests() // добавляем авторизацию
                .antMatchers("/","/registration").permitAll() //не требует авторизации если это не вот такие юрл как написано ( то вызываем форму логина )
                .anyRequest().authenticated() // дЛя всех остальных юрл авторизация нужна
                .and()
                .formLogin() // Включаем форму логин
                .loginPage("/login") //находится на таком юрл форма регистрации то где можно войти во все приложения кроме тех которые не требуют авторизации
                .permitAll() // разрешаем всем пользоваться
                .and()
                .logout() // Включаем выход (логаут)
                .permitAll(); // разрешаем всем пользоваться
    }

    @Override // Каким именно образом будет происходить авторизация ( тут он будет проверку делать данных из авторизации )
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // аутентификация - сопоставление пользователя уже индентифицированного
        auth.userDetailsService(userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
