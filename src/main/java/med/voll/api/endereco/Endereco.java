package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Getter
@Embeddable
public class Endereco {
    private String logradouro;
    private Integer numero;
    private String cidade;
    private String bairro;
    private String complemento;
    private String uf;
    private String cep;


    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.cidade = dados.cidade();
        this.bairro = dados.bairro();
        this.complemento = dados.complemento();
        this.uf = dados.uf();
        this.cep = dados.cep();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.logradouro() != null) this.logradouro = dados.logradouro();
        if (dados.numero() != null) this.numero = dados.numero();
        if (dados.cidade() != null) this.cidade = dados.cidade();
        if (dados.bairro() != null) this.bairro = dados.bairro();
        if (dados.complemento() != null) this.complemento = dados.complemento();
        if (dados.uf() != null) this.uf = dados.uf();
        if (dados.cep() != null) this.cep = dados.cep();
    }
}
