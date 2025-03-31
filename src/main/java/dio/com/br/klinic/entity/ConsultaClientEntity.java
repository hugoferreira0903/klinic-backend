package dio.com.br.klinic.entity;


import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "CONSULTAS_CLIENTS")
public class ConsultaClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "data_consulta")
    private OffsetDateTime dataConsulta;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private ClientEntity client = new ClientEntity();

    @ManyToOne
    @JoinColumn(name = "id_consulta")
    private ConsultaEntity consulta = new ConsultaEntity();

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public ConsultaEntity getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaEntity consulta) {
        this.consulta = consulta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(OffsetDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    @Override
    public String toString() {
        return "ConsultaClientEntity{" +
                "id=" + id +
                ", dataConsulta=" + dataConsulta +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultaClientEntity that = (ConsultaClientEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(dataConsulta, that.dataConsulta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataConsulta);
    }
}
