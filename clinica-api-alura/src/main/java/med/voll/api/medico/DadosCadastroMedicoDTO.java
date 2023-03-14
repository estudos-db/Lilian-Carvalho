package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEnderecoDTO;

public record DadosCadastroMedicoDTO(@NotBlank String nome, @NotBlank @Email String email,

                                     @NotBlank String telefone,

                                     @NotBlank @Pattern(regexp = "\\d{4,6}") //Expressão regular
                                     // que vai receber de 4 a 6 digitos
                                     String crm,

                                     @NotNull Especialidade especialidade,
                                     @NotNull @Valid DadosEnderecoDTO endereco) {}
