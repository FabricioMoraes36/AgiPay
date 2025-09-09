package br.com.AgiaPay.PaymentApi.AgiPay.Models;

//Aqui eu precisei mexer muito no record pq esqueci que existiam alguns campos no model que eram obrigatorios
public record RegisterDto (String email,String username, String password,String cpf,UsersRoles role){

}
//Json exemplo para registro:
//{
//  "email": "usuario@teste.com",
//  "username": "usuario1",
//  "password": "senha123",
//  "cpf": "123.456.789-00",
//  "role": "ADMIN"
//}
