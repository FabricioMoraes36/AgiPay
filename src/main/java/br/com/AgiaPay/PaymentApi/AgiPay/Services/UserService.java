package br.com.AgiaPay.PaymentApi.AgiPay.Services;

import br.com.AgiaPay.PaymentApi.AgiPay.Models.CompanyModel;
import br.com.AgiaPay.PaymentApi.AgiPay.Models.UserModel;
import br.com.AgiaPay.PaymentApi.AgiPay.Repositories.CompanyRepository;
import br.com.AgiaPay.PaymentApi.AgiPay.Repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    //Injeção do repository
    private UserRepository userRepository;
    private CompanyRepository companyRepository;

    public UserService(UserRepository userRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    //Metodos post,get,getbyid e delete

    public UserModel saveUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(UUID id) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));
            return user;

    }
    public void deleteUserById(UUID id) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));
        userRepository.delete(user);
    }
    public UserModel updateUser(UserModel userModel,UUID id) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado,verifique o id e tente novamente"));
        if (userModel.getUsername() != null) user.setUsername(userModel.getUsername());
        return userRepository.save(user);
    }

    //Metodo de pessoa para pessoa
    public void p2pTransfer(UUID sender, UUID receiver, BigDecimal amount) {
        Optional<UserModel> senderOpt = userRepository.findById(sender);
        Optional<UserModel> receiverOpt = userRepository.findById(receiver);
        if (senderOpt.isPresent() && receiverOpt.isPresent()) {
            UserModel senderUser = senderOpt.get();
            if (senderUser.getBalance().compareTo(amount) < 0) {
                throw new IllegalArgumentException("Saldo insuficiente");
            }
            UserModel receiverUser = receiverOpt.get();
            senderUser.setBalance(senderUser.getBalance().subtract(amount));
            receiverUser.setBalance(receiverUser.getBalance().add(amount));
            userRepository.save(senderUser);
            userRepository.save(receiverUser);
        }
    }
    //Metodo de pessoa para empresa

    public void b2cTransfer(UUID sender, UUID companyReceiver, BigDecimal amount) {
        UserModel senderOpt = userRepository.findById(sender).orElseThrow(() -> new EntityNotFoundException("A conta de origem não foi encontrada!! Verifique se o id esta correto"));
        CompanyModel companyOpt = companyRepository.findById(companyReceiver).orElseThrow(() -> new EntityNotFoundException("A conta de destino não foi encontrda!! Verifique se o id esta correto"));
        if (senderOpt.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        senderOpt.setBalance(senderOpt.getBalance().subtract(amount));
        companyOpt.setCompanyBalance(companyOpt.getCompanyBalance().add(amount));
        userRepository.save(senderOpt);
        companyRepository.save(companyOpt);

        }
    }

