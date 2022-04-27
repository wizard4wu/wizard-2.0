package com.wizard.security.custom.annotation;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

@AuthenticationPrincipal
public @interface CurrentUser {
}
