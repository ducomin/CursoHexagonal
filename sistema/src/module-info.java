module conta.sistema {
	// usa spring
	requires javax.inject;
	requires spring.tx;

	// expondo porta de entrada (driver)
	exports conta.sistema.casodeuso.porta;
	exports conta.sistema.casodeuso.imp;
	// expondo sistema negocio
	exports conta.sistema.dominio.modelo;
	exports conta.sistema.dominio.servico;
	// expondo adptadores de saidas (driven)
	exports conta.sistema.porta;
	exports conta.adaptador;

	//necessário para a suiteCore rodar
	exports teste.unidade.dominio.modelo;

	// abre reflexão spring
	opens conta.sistema.casodeuso.porta;
	opens conta.sistema.casodeuso.imp;
	opens conta.sistema.dominio.servico;
	opens conta.adaptador;
}