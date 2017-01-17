package com.poalim.paas.mngr.model;

public class QuotaStock {
	
	private String symbol;
	private String name;
	private double lastTradeValue;
	
	public QuotaStock() {
		super();
	}

	public QuotaStock(String symbol, String name, double lastTradeValue) {
		super();
		this.symbol = symbol;
		this.name = name;
		this.lastTradeValue = lastTradeValue;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLastTradeValue() {
		return lastTradeValue;
	}

	public void setLastTradeValue(double lastTradeValue) {
		this.lastTradeValue = lastTradeValue;
	}

	@Override
	public String toString() {
		return "QuotaStock [symbol=" + symbol + ", name=" + name + ", lastTradeValue=" + lastTradeValue + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(lastTradeValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuotaStock other = (QuotaStock) obj;
		if (Double.doubleToLongBits(lastTradeValue) != Double.doubleToLongBits(other.lastTradeValue))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}

	

}
