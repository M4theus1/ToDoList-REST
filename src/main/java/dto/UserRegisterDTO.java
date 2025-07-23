package dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @Email(message = "E-mail é inválido")
    @NotBlank(message = "E-mail é obrigatório")
    private String email;

    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    @NotBlank(message = "Senha é obrigatória")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
