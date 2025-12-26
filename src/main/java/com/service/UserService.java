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

    User registerUser(User user);

    User register(User user);

    User getUserById(Long id);

    // 🔧 FIX: return User, not boolean
    User validateLogin(String username, String password);
}
