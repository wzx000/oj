package com.oj.backend.service.user;

import java.util.Map;

public interface LoginService {
    public Map<String, String> getLogin(String username,
                                        String password
                                        );
}
