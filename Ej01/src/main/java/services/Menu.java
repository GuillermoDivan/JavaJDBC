package services;
import persistence.ProducerDAOExt;
import persistence.ProductDAOExt;

import java.util.Scanner;

public class Menu {
    ProductDAOExt DAO1 = new ProductDAOExt();
    ProductService service1 = new ProductService(DAO1);
    ProducerDAOExt DAO2 = new ProducerDAOExt();
    ProducerService service2 = new ProducerService(DAO2);

    public void menu() throws Exception {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        int option;
        do{
            System.out.println("Ingrese la opción que desea: " +
                    " 1) Lista el nombre de todos los productos que hay en la tabla producto." +
                    " 2) Lista los nombres y los precios de todos los productos de la tabla producto. " +
                    " 3) Listar aquellos productos que su precio esté entre 120 y 202." +
                    " 4) Buscar y listar todos los Portátiles de la tabla producto." +
                    " 5) Listar el nombre y el precio del producto más barato." +
                    " 6) Ingresar un producto a la base de datos." +
                    " 7) Ingresar un fabricante a la base de datos." +
                    " 8) Editar un producto con datos a elección." +
                    " 9) Salir.");
            option = input.nextInt();
            switch (option) {
                case 1: service1.findAllProductsByName(); break;
                case 2: service1.findAllProductsByNameByPrice(); break;
                case 3: service1.findAllProductsByPriceRange(120, 202); break;
                case 4: service1.findAllProductsByNameLike("Portátil"); break;
                case 5: service1.findAllProductsByLowerPrice(); break;
                case 6: service1.addProduct("Producto nuevo", 99.99, 1L); break;
                case 7: service2.addProducer("Fabricante nuevo"); break;
                case 8: service1.updateProduct(12L, "Tostadora de Cami", 100, 3L);break;
                default: break;
            }
        } while(option > 0 && option < 9);



    }
}
