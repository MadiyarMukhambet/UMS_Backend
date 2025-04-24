package com.unims.service;
import com.unims.entity.Role;
import com.unims.dto.AuthResponse;
import com.unims.dto.LoginRequest;
import com.unims.dto.RegisterRequest;
import com.unims.entity.Student;
import com.unims.entity.User;
import com.unims.repository.StudentRepository;
import com.unims.repository.UserRepository;
import com.unims.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    @Transactional
    public void register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        if (request.getRole() == Role.STUDENT) {
            Student student = Student.builder()
                    .name(request.getName()) // Предполагаем, что RegisterRequest содержит имя и email для студента
                    .email(request.getEmail())
                    .user(user)
                    .build();
            studentRepository.save(student);
            user.setStudent(student);
        }

        userRepository.save(user);
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtTokenProvider.generateToken(user.getUsername(), user.getRole());
        return new AuthResponse(token);
    }
}
