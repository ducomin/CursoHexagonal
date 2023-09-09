package conta.tela;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import conta.dsv.Build2;
import javafx.application.Application;
import javafx.stage.Stage;

public class AdaptadoraJavaFx extends Application {
	private ApplicationContext spring;

	@Override
	public void init() {
		System.out.println("iniciando spring..");
		spring = new AnnotationConfigApplicationContext(Build2.class);
	}

	@Override
	public void start(Stage stage) {
		var form = spring.getBean(TransferenciaFrm.class);
		form.mostrar(stage);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
