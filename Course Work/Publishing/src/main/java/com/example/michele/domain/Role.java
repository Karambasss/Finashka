package com.example.michele.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * Класс необходимый для получения и проставления ролей пользователя
 */
public enum Role implements GrantedAuthority {
    USER, ADMIN, TYPOGRAPHY_MANAGER, ACCOUNTANT, CLIENT_MANAGER, AUTHOR_MANAGER, PRODUCTION_MANAGER, CLIENT;

    @Override
    public String getAuthority() {
        return name();
    }
}
