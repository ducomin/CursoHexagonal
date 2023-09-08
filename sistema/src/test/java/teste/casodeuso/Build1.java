package teste.casodeuso;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Responsável por configurar os serviços do spring
@Configuration
// objetos de sistema , adptadores falsos
@ComponentScan({"conta.sistema", "conta.adaptador"})
public class Build1 {
	// Build 1: Adaptador Testes -> Sistema <- Adptadores Mocks
}
