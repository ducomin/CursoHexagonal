package conta.sistema.casodeuso.porta;

import java.math.BigDecimal;

import conta.sistema.dominio.modelo.Conta;

// Responsável por definir a porta de entrada (driver) de operações para caso de uso de transferência.
public interface PortaTransferencia {
	Conta getConta(Integer numero);
	void transferir(Integer contaDebito, Integer contaCredito, BigDecimal valor);
}
