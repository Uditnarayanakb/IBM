package org.bank.cachedemo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Cacheable("users")
    public String getUser(Long id) {

        System.out.println(
                "Fetching from DB...");

        try {
            Thread.sleep(5000);
        }
        catch(Exception e) {
        }

        return "User-" + id;
    }
}