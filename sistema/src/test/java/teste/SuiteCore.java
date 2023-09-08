package teste;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({
		// testando regras
		"teste.unidade.dominio.modelo",
		// testando servicos
		"teste.unidade.dominio.servico",
		// testando porta entrada (driver)
		"teste.casodeuso"})
public class SuiteCore {
	// 100% da solução testada independente de front-end e serviços externos (banco de dados)
}
