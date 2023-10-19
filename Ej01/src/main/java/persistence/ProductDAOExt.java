package persistence;
import entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOExt extends DAO{

    public void saveProduct(Product product) throws Exception {
        try{
            if (product == null) throw new Exception ("Debe ingresar un producto válido");
            String sql = " INSERT INTO producto (nombre, precio, codigo_fabricante) VALUES ( ' "
                    + product.getProductName() + " ' , " + product.getPrice() + " , "
                    + product.getProducerId() + " ) ";
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
            String sql = " UPDATE producto SET nombre = ' " + product.getProductName() + " ' " +
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
            String sql = " DELETE FROM producto WHERE codigo = " + productId;
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
            throw e;
        }
        finally{
            disconnectDataBase();
        }
    }

    public Product showProductById(Long productId) throws Exception {
        try {
            if (productId == null) throw new Exception("Debe ingresar un id válido");
            String sql = " SELECT * FROM producto WHERE codigo = ' " + productId + " ' ";
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
            throw e;
        }
        finally{
            disconnectDataBase();
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
            throw e;
        }
        finally{
            disconnectDataBase();
        }
    }

    public Product showProductByProducerId(Long producerId) throws Exception {
        try {
            if (producerId == null) throw new Exception("Debe ingresar un id de fabricante válido");
            String sql = " SELECT * FROM producto WHERE codigo_fabricante = ' " + producerId + " ' ";
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
            throw e;
        }
        finally{
            disconnectDataBase();
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
            throw e;
        }
        finally{
            disconnectDataBase();
        }
    }

    public List<Product> showProductByPriceRange(double min, double max) throws Exception {
        try {
            if (min < 0 || max < 0) throw new Exception("Debe ingresar un valor monetario válido");
            String sql = " SELECT * FROM producto WHERE precio BETWEEN " + min + " AND " + max ;
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
            throw e;
        }
        finally{
            disconnectDataBase();
        }
    }

    public List<Product> showProductByNameLike(String like) throws Exception {
        try {
            if (like == null) throw new Exception("Debe ingresar una cadena de caracteres válida");
            String sql = " SELECT * FROM producto WHERE nombre LIKE '%" + like + "%' " ;
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
            throw e;
        }
        finally{
            disconnectDataBase();
        }
    }

    public List<Product> showProductByLowerPrice() throws Exception {
        try {
            String sql = " SELECT * FROM producto WHERE precio = ( SELECT MIN(precio) FROM producto) " ;
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
            throw e;
        }
        finally{
            disconnectDataBase();
        }
    }

    }