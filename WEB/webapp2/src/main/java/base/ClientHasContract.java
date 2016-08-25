package base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Artyom Karnov on 8/21/16.
 * artyom-karnov@yandex.ru
 **/
@Entity
@Table(name = "Client_has_Contract", schema = "operator", catalog = "")
public class ClientHasContract {
    private int clientId;

    @Id
    @Column(name = "Client_id")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientHasContract that = (ClientHasContract) o;

        if (clientId != that.clientId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return clientId;
    }
}
