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
        return userService.save(user);
    }
    @GetMapping("/list")
    public  List<UserResponseDTO> findAll(){
        return userService.findAll();
    }
    @GetMapping("/list/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable UUID id){
        UserResponseDTO userResponseDTO = userService.findById(id);
        return ResponseEntity.ok(userResponseDTO);
    }
    @PutMapping("alter/{id}")
    public ResponseEntity<UserResponseDTO> alter2(@PathVariable UUID id, @RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = userService.alter(id,userRequestDTO);
        return ResponseEntity.ok().body(userResponseDTO);
    }

}
