package JFF;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends NewWindow {



    public void getHome() throws IOException {

      newWindow("Home.fxml","JFF Online Store");
    }

    public void getShop() throws IOException {

        newWindow("Shop.fxml","JFF Online Store");
    }

   /* public void getNewLetter(){

        String news = "Welcome to JFF's Fishing Store /n/n/n/tYou can get the perfect fishing items from us/n/n/t/tAnd we have the " +
                "perfect collection for your needs/n/n/n/n/t/t/t/t We have special offers this weekend come and vist our shop";

        SetMail newMail = new SetMail();
        newMail.mailConfig(news );
    }*/
}
