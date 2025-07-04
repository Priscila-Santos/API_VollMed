package med.voll.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco (
        @NotBlank
        String logradouro,

        @NotBlank
        String cidade,

        @NotBlank
        String uf,

        @NotBlank
        String bairro,

        @NotBlank @Pattern(regexp = "\\d{8}")
        String cep,

        String complemento,
        Integer numero

) {}
