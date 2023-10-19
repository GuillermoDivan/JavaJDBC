package persistence;
import entities.Producer;
import java.util.ArrayList;
import java.util.List;

public class ProducerDAOExt extends DAO {

    public void saveProducer(Producer producer) throws Exception {
        try {
            if (producer == null) throw new Exception("Debe ingresar un fabricante válido");
            String sql = " INSERT INTO fabricante (nombre) VALUES ( ' " + producer.getProducerName() + " ' ) ";
            this.executeCommands(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void updateProducer(Producer producer) throws Exception {
        try {
            if (producer == null) throw new Exception("Debe ingresar un fabricante válido");
            String sql = " UPDATE fabricante SET nombre = ' " + producer.getProducerName() + " ' " +
                    " WHERE codigo = " + producer.getProducerId();
            this.executeCommands(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteProducer(Long producerId) throws Exception {
        try {
            if (producerId == null) throw new Exception("Debe ingresar un id válido");
            String sql = " DELETE FROM fabricante WHERE codigo = " + producerId;
            this.executeCommands(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public Producer showProducerByName(String producerName) throws Exception {
        try {
            if (producerName == null) throw new Exception("Debe ingresar un nombre válido");
            String sql = " SELECT * FROM fabricante WHERE nombre = ' " + producerName + " ' ";
            this.executeQueries(sql);
            Producer producer1 = null;
            while (result.next()) {
                producer1 = new Producer();
                producer1.setProducerId(result.getLong(1));
                producer1.setProducerName(result.getString(2));
            }
            return producer1;
        } catch (Exception e) {
            throw e;
        }
        finally{
            disconnectDataBase();
        }
    }

    public Producer showProducerById(Long producerId) throws Exception {
        try {
            if (producerId == null) throw new Exception("Debe ingresar un nombre válido");
            String sql = " SELECT * FROM fabricante WHERE codigo = " + producerId;
            this.executeQueries(sql);
            Producer producer1 = null;
            while (result.next()) {
                producer1 = new Producer();
                producer1.setProducerId(result.getLong(1));
                producer1.setProducerName(result.getString(2));
            }
            return producer1;
        } catch (Exception e) {
            throw e;
        }
        finally{
            disconnectDataBase();
        }
    }

    public List<Producer> showProducerList() throws Exception {
        try {
            String sql = " SELECT * FROM fabricante ";
            this.executeQueries(sql);
            Producer producer1 = null;
            List<Producer> producerList = new ArrayList<>();

            while (result.next()) {
                producer1 = new Producer();
                producer1.setProducerId(result.getLong(1));
                producer1.setProducerName(result.getString(2));
                producerList.add(producer1);
            }
            return producerList;
        } catch (Exception e) {
            throw e;
        }
        finally{
            disconnectDataBase();
        }
    }

}