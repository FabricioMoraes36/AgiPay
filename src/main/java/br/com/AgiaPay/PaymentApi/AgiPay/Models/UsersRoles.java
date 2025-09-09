package br.com.AgiaPay.PaymentApi.AgiPay.Models;

//Enum para as roles dos usuarios
public enum UsersRoles {
    USER("user"),
    ADMIN("admin");

    private String role;

    UsersRoles(String role) {
        this.role = role;
    }
}
