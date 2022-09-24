package com.microservices.backend_academico.session;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
@Data
public class UserSession {
    private Boolean auth = false;
}
