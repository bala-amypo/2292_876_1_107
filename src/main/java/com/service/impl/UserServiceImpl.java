// package com.example.demo.service.impl;

// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;
// import org.springframework.stereotype.Service;

// @Service
// public class UserServiceImpl implements UserService {

//     private final UserRepository userRepository;

//     public UserServiceImpl(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     @Override
//     public User register(User user) {
//         if (userRepository.existsByEmail(user.getEmail())) {
//             throw new BadRequestException("email exists");
//         }

//         if (user.getRole() == null) {
//             user.setRole("AGENT");
//         }

//         return userRepository.save(user);
//     }

//     @Override
//     public User findByEmail(String email) {
//         return userRepository.findByEmail(email)
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found"));
//     }
// }

// package com.example.demo.service.impl;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// @Service
// public class UserServiceImpl implements UserService {

//     private final UserRepository userRepository;
//     private final PasswordEncoder passwordEncoder;

//     // ✅ Spring will use THIS
//     @Autowired
//     public UserServiceImpl(UserRepository userRepository,
//                            PasswordEncoder passwordEncoder) {
//         this.userRepository = userRepository;
//         this.passwordEncoder = passwordEncoder;
//     }

//     // ✅ Tests will use THIS
//     public UserServiceImpl(UserRepository userRepository) {
//         this.userRepository = userRepository;
//         this.passwordEncoder = null;
//     }

//     @Override
//     public User registerUser(User user) {
//         if (passwordEncoder != null) {
//             user.setPassword(passwordEncoder.encode(user.getPassword()));
//         }
//         return userRepository.save(user);
//     }

//     @Override
//     public User getUserById(Long id) {
//         return userRepository.findById(id).orElse(null);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = null;
    }

    // ✅ declared in interface → KEEP @Override
    @Override
    public User registerUser(User user) {
        if (passwordEncoder != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository.save(user);
    }

    // ✅ declared in interface → KEEP @Override
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // ❌ NOT in interface → REMOVE @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ❌ NOT in interface → REMOVE @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
