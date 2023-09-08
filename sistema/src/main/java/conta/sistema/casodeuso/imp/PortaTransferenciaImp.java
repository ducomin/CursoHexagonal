package conta.sistema.casodeuso.imp;

import static conta.sistema.dominio.modelo.Erro.inexistente;
import static conta.sistema.dominio.modelo.Erro.mesmaConta;
import static conta.sistema.dominio.modelo.Erro.obrigatorio;
import static java.util.Objects.isNull;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import conta.sistema.casodeuso.porta.PortaTransferencia;
import conta.sistema.dominio.modelo.Conta;
import conta.sistema.dominio.servico.Transferencia;
import conta.sistema.porta.ContaRepositorio;

@Named
public class PortaTransferenciaImp implements PortaTransferencia {

	private ContaRepositorio repositorio;
	private Transferencia transferencia;

	// Ioc por construtor
	@Inject
	public PortaTransferenciaImp(ContaRepositorio repositorio, Transferencia transferencia) {
		this.repositorio = repositorio;
		this.transferencia = transferencia;
	}

	@Override
	public Conta getConta(final Integer numero) {
		return repositorio.get(numero);
	}

	@Override
	@Transactional
	public void transferir(Integer contaDebito, Integer contaCredito, BigDecimal valor)
	{
		//1. validação de parametros
		if (isNull(contaDebito)) {
			obrigatorio("Conta débito");
		}
		if (isNull(contaCredito)) {
			obrigatorio("Conta crédito");
		}
		if (isNull(valor)) {
			obrigatorio("Valor");
		}
		//2. validação de contas
		var debito = repositorio.get(contaDebito);
		if (isNull(debito)) {
			inexistente("Conta débito");
		}
		var credito = repositorio.get(contaCredito);
		if (isNull(credito)) {
			inexistente("Conta crédito");
		}
		//3.validacao mesma conta
		if (debito.getNumero().equals(credito.getNumero())) {
			mesmaConta();
		}
		//4. operação
		transferencia.processar(valor, debito, credito);
		repositorio.alterar(debito);
		repositorio.alterar(credito);
	}
}
