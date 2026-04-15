package data_binding.session08bt04.model.dto;

import jakarta.validation.constraints.NotBlank;

public class Register {
    @NotBlank(message = "Không được để trống")
    private String username;

    @NotBlank(message = "Không được để trống")
    private String password;

    @NotBlank(message = "Không được để trống")
    private String confirmPassword;

    public Register() {
    }

    public Register(String username, String password, String confirmPassword) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
