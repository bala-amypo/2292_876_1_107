// package com.example.demo.controller;

// import com.example.demo.model.User;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserService;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;
//     private final JwtUtil jwtUtil;
//     private final PasswordEncoder passwordEncoder;

//     public AuthController(
//             UserService userService,
//             JwtUtil jwtUtil,
//             PasswordEncoder passwordEncoder) {
//         this.userService = userService;
//         this.jwtUtil = jwtUtil;
//         this.passwordEncoder = passwordEncoder;
//     }

//     @PostMapping("/register")
//     public User register(@RequestBody User user) {
//         user.setPassword(passwordEncoder.encode(user.getPassword()));
//         return userService.register(user);
//     }

//     @PostMapping("/login")
//     public String login(@RequestBody User user) {
//         User dbUser = userService.findByEmail(user.getEmail());

//         if (!passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
//             throw new RuntimeException("invalid credentials");
//         }

//         return jwtUtil.generateToken(
//                 dbUser.getId(),
//                 dbUser.getEmail(),
//                 dbUser.getRole());
//     }
// }



package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // ✅ MUST BE permitAll
    @PostMapping("/register")
    @PreAuthorize("permitAll()")
    public ResponseEntity<User> register(@RequestBody User user) {
        return new ResponseEntity<>(userService.register(user), HttpStatus.CREATED);
    }
}
