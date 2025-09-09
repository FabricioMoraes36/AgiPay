package br.com.AgiaPay.PaymentApi.AgiPay.Controllers;

import br.com.AgiaPay.PaymentApi.AgiPay.Models.AuthenticationDto;
import br.com.AgiaPay.PaymentApi.AgiPay.Models.RegisterDto;
import br.com.AgiaPay.PaymentApi.AgiPay.Models.UserModel;
import br.com.AgiaPay.PaymentApi.AgiPay.Repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;

    public AuthenticationController(AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDto data){
        if(this.userRepository.findByEmail(data.email()) != null){
            return ResponseEntity.badRequest().build();
        }
        //aqui no uso do construtor estava com um erro pq n usava a senha criptografada,estava usando data.password,mas o correto é chamar a nossa criptografia
        String EncryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserModel user = new UserModel(data.email(), data.username(), EncryptedPassword,data.cpf(), data.role());
        this.userRepository.save(user);
        return ResponseEntity.ok().build();
    }
    //Ex json register:
    //{
    //  "email": "usuario@teeste.com",
    //  "username": "usuario2",
    //  "password": "senha124",
    //  "cpf": "123.456.769-00",
    //  "role": "ADMIN"
    //}


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto data){
        //variavel que chama a classe do Spring security, a UsernamePasswordAuthenticationToken,e os parametros dela são o email e password do nosso dto(record)
        var emailPassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        //A classe authenticationManager do spring security faz a verificação da variavel acima que passamos para a criptografia
        var authentication = this.authenticationManager.authenticate(emailPassword);
        return ResponseEntity.ok().build();
    }
    //Ex Json login:
    //{
    //  "email": "usuario@teeste.com",
    //  "password": "senha124"
    //}
}
