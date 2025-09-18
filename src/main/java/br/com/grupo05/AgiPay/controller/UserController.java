package br.com.grupo05.AgiPay.controller;

import br.com.grupo05.AgiPay.dto.UserRequestDTO;
import br.com.grupo05.AgiPay.dto.UserResponseDTO;
import br.com.grupo05.AgiPay.model.UserModel;
import br.com.grupo05.AgiPay.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/create")
    public UserResponseDTO create(@RequestBody UserRequestDTO user){
        //return da camada service - sugestão de metodo:
        // public UserModel create(UserModel user){return userRepository.save(user)}
        return userService.save(user);
    }
    @GetMapping("/list")
    public  List<UserResponseDTO> findAll(){
        //return da camada service - sugestão de metodo:
        // public UserModel create(UserModel user){return userRepository.findAll()}
        return userService.findAll();
    }
    @GetMapping("/list/{id}")
    public ResponseEntity<UserModel> findById(@PathVariable UUID id){
        //return da camada service - sugestão de metodo:
        // public Optional<UserModel> findByid(UUID id){return userRepository.findByid(id).orElsethrow(() -> new EntityNotFoundException())}
        return null;
    }
    @PutMapping("alter/{id}")
    public ResponseEntity<UserModel> alterByid(@PathVariable UUID id,@RequestBody UserRequestDTO userRequestDTO){
            UserResponseDTO userResponseDTO = userService.alter(id,userRequestDTO);
            return ResponseEntity.ok().body(userResponseDTO);

            return null;
    }
}
