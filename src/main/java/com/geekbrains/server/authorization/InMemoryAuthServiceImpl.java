package com.geekbrains.server.authorization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryAuthServiceImpl implements AuthService {
    private final Map<String, UserData> users;

    public InMemoryAuthServiceImpl() {
        users = new HashMap<>();
        users.put("nick1", new UserData("login1", "password1", "nick1"));
        users.put("nick2", new UserData("login2", "password2", "nick2"));
        users.put("nick3", new UserData("login3", "password3", "nick3"));
    }

    @Override
    public void start() {
        System.out.println("Сервис аутентификации инициализирован");
    }

    @Override
    public synchronized String getNickNameByLoginAndPassword(String login, String password) {
        UserData user = users.get(login);
        // Ищем пользователя по логину и паролю, если нашли то возвращаем никнэйм
        if (user != null && user.getPassword().equals(password)) {
            return user.getNickName();
        }
        return null;
    }

    @Override
    public void end() {
        System.out.println("Сервис аутентификации отключен");
    }
}
