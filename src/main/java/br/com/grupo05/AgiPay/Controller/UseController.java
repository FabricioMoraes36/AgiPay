package br.com.grupo05.AgiPay.Controller;

import br.com.grupo05.AgiPay.Models.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UseController {

    @PostMapping("/create")
    public ResponseEntity<UserModel> create(@RequestBody UserModel user){
        //return da camada service - sugestão de metodo:
        // public UserModel create(UserModel user){return userRepository.save(user)}
        return null;
    }
    @GetMapping("/list")
    public ResponseEntity<List<UserModel>> findAll(){
        //return da camada service - sugestão de metodo:
        // public UserModel create(UserModel user){return userRepository.findAll()}
        return null;
    }
    @GetMapping("/list/{id}")
    public ResponseEntity<UserModel> findById(@PathVariable UUID id){
        //return da camada service - sugestão de metodo:
        // public Optional<UserModel> findByid(UUID id){return userRepository.findByid(id).orElsethrow(() -> new EntityNotFoundException())}
        return null;
    }
    @PutMapping("alter/{id}")
    public ResponseEntity<UserModel> alterByid(@PathVariable UUID id,@RequestBody UserModel user){
        //return da camada service - sugestão de metodo:
        // public UserModel alter(UUID id,UserModel user){UserModel findUser = userRepository.findById(id).orElseThrow(() -> new RunTimeException("User not found"));
        // findUser.setEmail(user.getEmail())
        // findUser.setUsername(user.getUsername())
        // findUser.setCpf(user.getCpf())
        // return userRepository.save(findUser);
        return null;
    }
}
