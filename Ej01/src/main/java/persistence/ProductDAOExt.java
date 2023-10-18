package persistence;
import entities.Producer;
import entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOExt extends DAO{

    public void saveProduct(Product product) throws Exception {
        try{
            if (product == null) throw new Exception ("Debe ingresar un producto válido");
            String sql = " INSERT INTO fabricante (nombre) VALUES ( ' " + product.getProductName() + " ' ) ";
            this.executeCommands(sql);
        }
        catch(Exception e){
            disconnectDataBase();
            throw e;
        }
    }

    public void updateProduct(Product product) throws Exception {
        try{
            if (product == null) throw new Exception ("Debe ingresar un producto válido");
            String sql = " UPDATE fabricante SET nombre = ' " + product.getProductName() + " ' " +
                    " WHERE codigo = " + product.getProducerId();
            this.executeCommands(sql);
        }
        catch(Exception e){
            disconnectDataBase();
            throw e;
        }
    }

    public void deleteProduct(Long productId) throws Exception {
        try{
            if (productId == null) throw new Exception ("Debe ingresar un id válido");
            String sql = " DELETE FROM fabricante WHERE codigo = " + productId;
            this.executeCommands(sql);
        }
        catch(Exception e){
            disconnectDataBase();
            throw e;
        }
    }

    public Product showProductByName(String productName) throws Exception {
        try {
            if (productName == null) throw new Exception("Debe ingresar un nombre válido");
            String sql = " SELECT * FROM producto WHERE nombre = ' " + productName + " ' ";
            this.executeQueries(sql);
            Product product1 = null;
            while (result.next()) {
                product1 = new Product();
                product1.setProductId(result.getLong(1));
                product1.setProductName(result.getString(2));
                product1.setPrice(result.getDouble(3));
                product1.setProducerId(result.getLong(4));
            }
            return product1;
        } catch (Exception e) {
            disconnectDataBase();
            throw e;
        }
    }

    public Product showProductById(Long productId) throws Exception {
        try {
            if (productId == null) throw new Exception("Debe ingresar un id válido");
            String sql = " SELECT * FROM ptoducto WHERE codigo = ' " + productId + " ' ";
            this.executeQueries(sql);
            Product product1 = null;
            while (result.next()) {
                product1 = new Product();
                product1.setProductId(result.getLong(1));
                product1.setProductName(result.getString(2));
                product1.setPrice(result.getDouble(3));
                product1.setProducerId(result.getLong(4));
            }
            return product1;
        } catch (Exception e) {
            disconnectDataBase();
            throw e;
        }
    }

    public Product showProductByPrice(Double price) throws Exception {
        try {
            if (price == null) throw new Exception("Debe ingresar un valor monetario válido");
            String sql = " SELECT * FROM producto WHERE precio = ' " + price + " ' ";
            this.executeQueries(sql);
            Product product1 = null;
            while (result.next()) {
                product1 = new Product();
                product1.setProductId(result.getLong(1));
                product1.setProductName(result.getString(2));
                product1.setPrice(result.getDouble(3));
                product1.setProducerId(result.getLong(4));
            }
            return product1;
        } catch (Exception e) {
            disconnectDataBase();
            throw e;
        }
    }

    public Product showProductByProducerId(Long producerId) throws Exception {
        try {
            if (producerId == null) throw new Exception("Debe ingresar un id de fabricante válido");
            String sql = " SELECT * FROM ptoducto WHERE codigo_fabricante = ' " + producerId + " ' ";
            this.executeQueries(sql);
            Product product1 = null;
            while (result.next()) {
                product1 = new Product();
                product1.setProductId(result.getLong(1));
                product1.setProductName(result.getString(2));
                product1.setPrice(result.getDouble(3));
                product1.setProducerId(result.getLong(4));
            }
            return product1;
        } catch (Exception e) {
            disconnectDataBase();
            throw e;
        }
    }

    public List<Product> showProductList() throws Exception {
        try {
            String sql = " SELECT * FROM producto ";
            this.executeQueries(sql);
            Product product1 = null;
            List<Product> productList = new ArrayList<>();

            while (result.next()) {
                product1 = new Product();
                product1.setProductId(result.getLong(1));
                product1.setProductName(result.getString(2));
                product1.setPrice(result.getDouble(3));
                product1.setProducerId(result.getLong(4));
                productList.add(product1);
            }
            return productList;
        } catch (Exception e) {
            disconnectDataBase();
            throw e;
        }
    }
}