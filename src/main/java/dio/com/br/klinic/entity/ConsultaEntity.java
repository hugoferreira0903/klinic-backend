package dio.com.br.klinic.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "CONSULTAS")
public class ConsultaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(nullable = false, length = 150)
    private String atendimento;


    @ManyToOne
    @JoinColumn(name = "id_medico")
    private MedicoEntity medico = new MedicoEntity();

    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(String atendimento) {
        this.atendimento = atendimento;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultaEntity that = (ConsultaEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(preco, that.preco) && Objects.equals(atendimento, that.atendimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, preco, atendimento);
    }

    @Override
    public String toString() {
        return "ConsultaEntity{" +
                "id=" + id +
                ", preco=" + preco +
                ", atendimento='" + atendimento + '\'' +
                '}';
    }
}
