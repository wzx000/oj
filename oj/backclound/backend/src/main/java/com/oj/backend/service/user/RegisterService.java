package com.oj.backend.service.user;

import java.util.Map;

public interface RegisterService {
    public Map<String, String> register(String username,
                                        String password,
                                        String confirmedPassword,
                                        Integer studentId,
                                        String qq,
                                        String telephone
                                        );
}
