package br.com.grupo05.AgiPay.service;

import br.com.grupo05.AgiPay.dto.UserRequestDTO;
import br.com.grupo05.AgiPay.dto.UserResponseDTO;
import br.com.grupo05.AgiPay.model.UserModel;
import br.com.grupo05.AgiPay.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDTO> findAll (){
        return userRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public UserResponseDTO findById(UUID id) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        return toResponseDTO(user);
    }

    public UserResponseDTO save(UserRequestDTO dto) {
        UserModel user = new UserModel();
        user.setUsername(dto.getUsername());
        user.setCpf(dto.getCpf());
        user.setEmail(dto.getEmail());
        UserModel save = userRepository.save(user);
        return toResponseDTO(save);

    }

    private UserResponseDTO toResponseDTO(UserModel user) {
            UserResponseDTO dto = new UserResponseDTO();
            dto.setCpf(user.getCpf());
            dto.setUsername(user.getUsername());
            dto.setEmail(user.getEmail());
            return dto;
        }


    public UserResponseDTO alter(UUID id, UserRequestDTO userRequestDTO){
        UserModel userModel = userRepository.findById(id).orElseThrow(()-> new RuntimeException("Id não existe"));
        toResponseDTO(userModel);
       UserResponseDTO userResponseDTO = save(userRequestDTO);
        return userResponseDTO;
     }

    }

