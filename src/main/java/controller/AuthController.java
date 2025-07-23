package controller;

import dto.LoginRequestDTO;
import dto.UserRegisterDTO;
import dto.UserResponseDTO;
import entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import security.JwtUtil;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid UserRegisterDTO dto) {
        User user = new User(dto.getName(), dto.getEmail(), passwordEncoder.encode(dto.getPassword()));
        User saved = userService.registerUser(user);
        return ResponseEntity.ok(new UserResponseDTO(saved.getId(), saved.getName(), saved.getEmail()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO dto) {
        Optional<User> userOpt = userService.findByEmail(dto.getEmail());

        if (userOpt.isEmpty() || !passwordEncoder.matches(dto.getPassword(), userOpt.get().getPassword())) {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }

        String token = jwtUtil.generateToken(dto.getEmail());
        return ResponseEntity.ok(token);
    }
}
