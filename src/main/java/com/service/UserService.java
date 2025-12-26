// package com.example.demo.service;

// import com.example.demo.model.User;

// public interface UserService {

//     User register(User user);

//     User findByEmail(String email);
// }


// package com.example.demo.service;

// import com.example.demo.model.User;

// public interface UserService {

//     User register(User user);

//     User findByEmail(String email);

//     User validateLogin(String email, String password);
// }
package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    // already existing
    User registerUser(User user);

    User getUserById(Long id);

    // ✅ ADD THESE (required by AuthController)
    User register(User user);

    boolean validateLogin(String username, String password);
}
