package services;
import entities.Producer;
import persistence.ProducerDAOExt;
import java.util.List;

public class ProducerService {

    private ProducerDAOExt producerDAOExt;

    public ProducerService(ProducerDAOExt producerDAOExt) {
        this.producerDAOExt = producerDAOExt;
    }

    /*public ProducerService() {
        this.producerDAOExt = new ProducerDAOExt();
    }*/
    /*public void addProducer(Producer producer) throws Exception {
        try { if (producer == null) { throw new Exception
                ("Debe indicar el nombre de fabricante."); }
            Producer p1 = new Producer();
            p1.setProducerName(producer.getProducerName());
            producerDAOExt.saveProducer(p1); }
        catch (Exception e) { throw e; }
    }*/

    public void addProducer(String producerName) throws Exception {
        try { if (producerName == null) { throw new Exception
                ("Debe indicar el nombre de fabricante."); }
        Producer p1 = new Producer();
            p1.setProducerName(producerName);
            producerDAOExt.saveProducer(p1); }
        catch (Exception e) { throw e; }
    }

    public void updateProducer(Long id, String name) throws Exception {
        try{
            if (id < 0) { throw new Exception("Debe indicar el id"); }
            if (name == null || name.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre ");
            }
            Producer producer = producerDAOExt.showProducerById(id);
            producerDAOExt.updateProducer(producer);
        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteProducer(Long id) throws Exception {
        try { if (id < 0) { throw new Exception("Debe indicar el Id"); }
            producerDAOExt.deleteProducer(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public Producer findProducerById(Long id) throws Exception {
        try { if (id < 0) { throw new Exception("Debe indicar el id");  }
            Producer producer = producerDAOExt.showProducerById(id);
            if (producer == null) { throw new Exception("No se encontró fabricante para el id indicado"); }
            return producer;
        } catch (Exception e) {
            throw e;
        }
    }

    public Producer findProducerByName(String name) throws Exception {
        try { if (name == null) { throw new Exception("Debe indicar el nombre.");  }
            Producer producer = producerDAOExt.showProducerByName(name);
            if (producer == null) { throw new Exception("No se encontró fabricante para el nombre indicado"); }
            return producer;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Producer> findAllProducers() throws Exception {
        try { List<Producer> producerList = producerDAOExt.showProducerList();
            for (Producer p : producerList) { System.out.println(p.toString()); }
            return producerList;
        } catch (Exception e) {throw e; }
    }

}


