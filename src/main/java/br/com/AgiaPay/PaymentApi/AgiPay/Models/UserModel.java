package br.com.AgiaPay.PaymentApi.AgiPay.Models;


//"\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}",
//message = "CPF deve estar no formato XXX.XXX.XXX-XX")

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class UserModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Email
    private String email;

    @Column(nullable = false)
    @NotBlank
    private String password;

    @Column(nullable = false)
    @NotBlank
    private String username;


    @Column(nullable = false)
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}",
message = "CPF deve estar no formato XXX.XXX.XXX-XX")
    private String cpf;

    private BigDecimal balance;

    private UsersRoles role;

    public UserModel(String email, String username, String password, String cpf, UsersRoles role){
        this.email = email;
        this.password = password;
        this.username = username;
        this.cpf = cpf;
        this.role = role;
    }


    //Config da role,caso ela seja admin garante a autoridade de admin e user,se não so concede a autoridade de user
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UsersRoles.ADMIN) return List.of(new SimpleGrantedAuthority("ADMIN"), new  SimpleGrantedAuthority("USER"));
        else return List.of(new SimpleGrantedAuthority("USER"));
    }


    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
