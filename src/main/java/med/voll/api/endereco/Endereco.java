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

}
