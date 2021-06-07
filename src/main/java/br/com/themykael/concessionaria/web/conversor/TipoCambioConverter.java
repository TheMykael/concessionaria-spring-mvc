package br.com.themykael.concessionaria.web.conversor;

import org.springframework.core.convert.converter.Converter;

import br.com.themykael.concessionaria.domain.TipoCambio;

public class TipoCambioConverter implements Converter<String, TipoCambio> {

	@Override
	public TipoCambio convert(String texto) {
		char tipo = texto.charAt(0);
		return tipo == TipoCambio.AUTOMATICO.getDesc() ? TipoCambio.AUTOMATICO : TipoCambio.MANUAL;
	}
	
}
