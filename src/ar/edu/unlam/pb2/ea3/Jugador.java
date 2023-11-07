package ar.edu.unlam.pb2.ea3;

import java.util.Objects;

public class Jugador implements Comparable<Jugador> {
	
	private Integer numeroCamiseta;
	private String nombre;
	private Integer valorDeCompra;
	
	public Jugador() {
	}

	public Jugador(Integer numeroCamiseta, String nombre, Integer valorDeCompra) {
		super();
		this.numeroCamiseta = numeroCamiseta;
		this.nombre = nombre;
		this.valorDeCompra = valorDeCompra;
	}

	public Integer getNumeroCamiseta() {
		return numeroCamiseta;
	}

	public void setNumeroCamiseta(Integer numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getValorDeCompra() {
		return valorDeCompra;
	}

	public void setValorDeCompra(Integer valorDeCompra) {
		this.valorDeCompra = valorDeCompra;
	}

	@Override
	public int compareTo(Jugador o) {
		return this.nombre.compareTo(o.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
	
}
