package br.com.mvabrito.validadorDTO;

import java.math.BigDecimal;

import br.com.mvabrito.validadorDTO.annotation.Max;
import br.com.mvabrito.validadorDTO.annotation.NotNull;
import br.com.mvabrito.validadorDTO.annotation.Parametro;
import br.com.mvabrito.validadorDTO.annotation.Strategy;
import br.com.mvabrito.validadorDTO.annotation.ValidateField;

public class ExemploVO {

	@ValidateField(parametro = @Parametro(strategy = Strategy.NOT_NULL, variaveis = "teste"))
	@NotNull(msgErro = "Este valor não pode ser nulo")
	private String nome;
	@ValidateField(parametro = @Parametro(strategy = Strategy.NOT_NULL, variaveis = "teste"))
	private String end;

	@Max(valueMax = 32, msgErro = "Valor maior Max")
	private BigDecimal dec;

	public BigDecimal getDec() {
		return this.dec;
	}

	public String getEnd() {
		return this.end;
	}

	public String getNome() {
		return this.nome;
	}

	public void setDec(BigDecimal dec) {
		this.dec = dec;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public void setNome(String nome) {
		Strategy.NOT_NULL.name();
		this.nome = nome;
	}

}
