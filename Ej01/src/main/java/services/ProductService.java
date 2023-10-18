package services;
import entities.Product;
import persistence.ProductDAOExt;

import java.util.List;

public class ProductService {

    private ProductDAOExt productDAOExt;

    public ProductService(ProductDAOExt productDAOExt) {
        this.productDAOExt = productDAOExt;
    }

    public void addProduct(String productName, double price, Long producerId) throws Exception {
        Product p1 = new Product();
        try { if (productName == null) { throw new Exception("Debe indicar el nombre del producto."); }
            p1.setProductName(productName); }
        catch (Exception e) { throw e; }
        try { if (price < 0) { throw new Exception("Debe indicar el valor del producto."); }
            p1.setPrice(price);} catch (Exception e) { throw e; }
        try { if (producerId < 0) { throw new Exception("Debe indicar el id del fabricante."); }
            p1.setProducerId(producerId);} catch (Exception e) { throw e; }
        productDAOExt.saveProduct(p1);
            }

    public void updateProduct(Long id, String name, double price, Long producerId) throws Exception {
        try{
            if (id < 0) { throw new Exception("Debe indicar el id"); }
            if (name == null || name.trim().isEmpty()) { throw new Exception("Debe indicar el nombre "); }
            if (price < 0) { throw new Exception("Debe indicar el precio."); }
            if (producerId < 0) { throw new Exception("Debe indicar el id de fabricante."); }
            Product product = productDAOExt.showProductById(id);
            productDAOExt.updateProduct(product);
        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteProduct(Long id) throws Exception {
        try { if (id < 0) { throw new Exception("Debe indicar el Id"); }
            productDAOExt.deleteProduct(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public Product findProductById(Long id) throws Exception {
        try { if (id < 0) { throw new Exception("Debe indicar el id");  }
            Product product = productDAOExt.showProductById(id);
            if (product == null) { throw new Exception("No se encontró producto para el id indicado"); }
            return product;
        } catch (Exception e) {
            throw e;
        }
    }

    public Product findProductByName(String name) throws Exception {
        try { if (name == null) { throw new Exception("Debe indicar el nombre.");  }
            Product product = productDAOExt.showProductByName(name);
            if (product == null) { throw new Exception("No se encontró producto para el nombre indicado"); }
            return product;
        } catch (Exception e) {
            throw e;
        }
    }

    public Product findProductByPrice(Double price) throws Exception {
        try { if (price < 0) { throw new Exception("Debe indicar el precio.");  }
            Product product = productDAOExt.showProductByPrice(price);
            if (product == null) { throw new Exception("No se encontró producto para el nombre indicado"); }
            return product;
        } catch (Exception e) {
            throw e;
        }
    }

    public Product findProductByProducerId(Long id) throws Exception {
        try { if (id < 0) { throw new Exception("Debe indicar el id del fabricante.");  }
            Product product = productDAOExt.showProductByProducerId(id);
            if (product == null) { throw new Exception("No se encontró producto para el id de fabricante indicado"); }
            return product;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Product> findAllProducts() throws Exception {
        try { List<Product> productList = productDAOExt.showProductList();
            for (Product p : productList) { System.out.println(p.toString()); }
            return productList;
        } catch (Exception e) {throw e; }
    }

}
