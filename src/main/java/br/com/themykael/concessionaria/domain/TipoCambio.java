package br.com.themykael.concessionaria.domain;

public enum TipoCambio {
	
	AUTOMATICO('A'), MANUAL('M');
	
	private char desc;
	
	private TipoCambio(char desc) {
		this.setDesc(desc);
	}

	public char getDesc() {
		return desc;
	}

	public void setDesc(char desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
