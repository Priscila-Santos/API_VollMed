package med.voll.api.medicos;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,

        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
