package quintwong;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import quintwong.mapper.CategoryMapper;
import quintwong.mapper.OrderMapper;
import quintwong.mapper.ProductMapper;
import quintwong.pojo.Category;
import quintwong.pojo.Order;
import quintwong.pojo.OrderItem;
import quintwong.pojo.Product;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        ProductMapper mapper = session.getMapper(ProductMapper.class);
        CategoryMapper mapper2 = session.getMapper(CategoryMapper.class);

        System.out.println(mapper2.count());

        session.commit();
        session.close();
    }

    //    private static void listProduct(SqlSession session){
//        List<Product> ps = session.selectList("listProduct");
//        for (Product p :
//                ps) {
//            System.out.println(p);
//        }
//    }
    private static void add(CategoryMapper mapper, int id, String name) {
        Category c = new Category();
        c.setId(id);
        c.setName(name);
        mapper.add(c);
        listAll(mapper);
    }

    private static void delete(CategoryMapper mapper, int id) {
        mapper.delete(id);
        listAll(mapper);
    }

    private static void get(CategoryMapper mapper, int id) {
        Category c = mapper.get(id);
        System.out.println(c.getName());
    }

    private static void update(CategoryMapper mapper) {
        Category c = mapper.get(8);
        c.setId(2);
        c.setName("Category2");
        mapper.update(c);
        listAll(mapper);
    }

    private static void listAll(CategoryMapper mapper) {
        List<Category> cs = mapper.list();
        for (Category c : cs) {
            System.out.println(c.getName());
            List<Product> ps = c.getProducts();
            for (Product p :
                    ps) {
                System.out.println("\t" + p.getName());
            }
        }
    }


    private static void listProduct(SqlSession session) {
        Map<String, Object> params = new HashMap<>();
//        params.put("name","a");
//        params.put("price","50");
        List<Product> ps = session.selectList("listProduct", params);
        for (Product p :
                ps) {
            System.out.println(p);
        }
    }


    private static void deleteOrderItem(SqlSession session) {
        Order o1 = session.selectOne("getOrder", 1);
        Product p6 = session.selectOne("getProduct", 6);
        OrderItem oi = new OrderItem();
        oi.setProduct(p6);
        oi.setOrder(o1);

        session.delete("deleteOrderItem", oi);
    }

    private static void addOrderItem(SqlSession session) {

    }

    private static void listOrder(SqlSession session) {
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        List<Order> os = mapper.list();
        for (Order o : os) {
            System.out.println(o.getCode());
            List<OrderItem> ois = o.getOrderItems();
            if (null != ois) {
                for (OrderItem oi : ois) {
                    System.out.println("\t" + oi.getProduct().getName() + "\t" + oi.getProduct().getPrice() + "\t" + oi.getNumber());
                }
            }
        }
    }
}