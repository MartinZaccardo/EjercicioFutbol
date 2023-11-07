package ar.edu.unlam.pb2.ea3;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EquipoDeFutbol {

	private String nombre;
	private TreeSet<Jugador> jugadores;

	public EquipoDeFutbol(String nombre) {
		this.nombre = nombre;
		jugadores = new TreeSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TreeSet<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(TreeSet<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	/*
	 * La capacidad m�xima de un equipo es 23. Cualquier intento de agregar m�s
	 * jugadores generar� una excepci�n (CapacidadMaximaException). Adem�s, no
	 * deber� permitir duplicar Jugadores (JugadorDuplicadoException).
	 */
	public void agregarJugador(Jugador jugador) throws CapacidadMaximaException, JugadorDuplicadoException {
		if (jugadores.size() >= 23) {
			throw new CapacidadMaximaException("El equipo tiene la capacidad maxima de jugadores");
		}
		
		if (jugadores.contains(jugador)) {
			throw new JugadorDuplicadoException("El jugador ya esta en el equipo");
		}

		jugadores.add(jugador);
	}

	/*
	 * Permite cambiar cualquier jugador. Un intento de cambiar un jugador no
	 * presente en el equipo generar� una excepci�n (JugadoreInexistenteException).
	 */
	public Boolean cambiarJugador(Jugador saliente, Jugador entrante) throws JugadoreInexistenteException {
		Boolean jugadoresCambiados = false;

		if (!jugadores.contains(saliente)) {
			throw new JugadoreInexistenteException("El jugador saliente no existe en el equipo");
		} else {
			jugadores.remove(saliente);
			jugadores.add(entrante);
			jugadoresCambiados = true;
		}

		return jugadoresCambiados;
	}

	public TreeSet<Jugador> devolverPlantelOrdenadoPorNombreDeJugador() {
		TreeSet<Jugador> plantelOrdenadoPorNombre = new TreeSet<>(new comparadorJugador());

		plantelOrdenadoPorNombre.addAll(jugadores);

		return plantelOrdenadoPorNombre;
	}

	public TreeSet<Jugador> devolverPlantelOrdenadoPorPrecioDeCompraDeJugador() {
		TreeSet<Jugador> plantelOrdenadoPorPrecioDeCompraDeJugador = new TreeSet<>(new comparadorJugadorPorPrecio());

		plantelOrdenadoPorPrecioDeCompraDeJugador.addAll(jugadores);

		return plantelOrdenadoPorPrecioDeCompraDeJugador;
	}

	public TreeSet<Jugador> devolverPlantelOrdenadoPorNumeroDeCamisetaDeJugador() {
		TreeSet<Jugador> plantelOrdenadoPorNumeroDeCamiseta = new TreeSet<>(new comparadorJugadorPorNumeroCamiseta());

		plantelOrdenadoPorNumeroDeCamiseta.addAll(jugadores);

		return plantelOrdenadoPorNumeroDeCamiseta;
	}

}
