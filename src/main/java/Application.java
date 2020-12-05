import com.alipour.learn.components.ShoppingCard;
import com.alipour.learn.configs.AppConfig;
import com.alipour.learn.models.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Product aaa = context.getBean("aaa", Product.class);
        Product cdrw = context.getBean("cdrw", Product.class);
        Product dvdrw = context.getBean("dvdrw", Product.class);

        ShoppingCard card_1 = context.getBean(ShoppingCard.class);
        card_1.addItem(aaa);
        card_1.addItem(cdrw);
        System.out.println("Items in card 1: " + card_1.toString());

        ShoppingCard card_2 = context.getBean(ShoppingCard.class);
        card_2.addItem(dvdrw);


        System.out.println("Items in card 2: " + card_2.toString());
    }
}
