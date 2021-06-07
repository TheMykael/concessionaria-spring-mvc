package br.com.themykael.concessionaria.dao;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.themykael.concessionaria.domain.Carro;
import br.com.themykael.concessionaria.domain.TipoCambio;

@Repository
public class CarroDaoImpl implements CarroDao {

	private static List<Carro> car;

	public CarroDaoImpl() {
		createCarroList();
	}

	private List<Carro> createCarroList() {
		if (car == null) {
			car = new LinkedList<>();
			car.add(new Carro(System.currentTimeMillis() + 1L, "BMW", "M3 GTR", LocalDate.of(2001, 2, 1), 
					TipoCambio.MANUAL));
			car.add(new Carro(System.currentTimeMillis() + 2L, "Audi", "Le Mans TT Quattro", LocalDate.of(2003, 2, 1),
					TipoCambio.MANUAL));
			car.add(new Carro(System.currentTimeMillis() + 3L, "Volkswagen", "Golf GTI", LocalDate.of(2018, 4, 1),
					TipoCambio.MANUAL));
			car.add(new Carro(System.currentTimeMillis() + 4L, "Mercedes Benz", "CLK 500"));
			car.add(new Carro(System.currentTimeMillis() + 5L, "Aston Martin", "DB9"));
			car.add(new Carro(System.currentTimeMillis() + 6L, "Dodge", "Viper SRT 10"));
		}
		return car;
	}

	@Override
	public void salvar(Carro Carro) {
		Carro.setId(System.currentTimeMillis());
		car.add(Carro);
	}

	@Override
	public void editar(Carro carro) {
		car.stream()
			.filter((c) -> c.getId().equals(carro.getId()))
			.forEach((c) -> {
				c.setMarca(carro.getMarca());
				c.setModelo(carro.getModelo());
				c.setDataLancamento(carro.getDataLancamento());
				c.setCambio(carro.getCambio());
			});
	}

	@Override
	public void excluir(Long id) {
		car.removeIf((c) -> c.getId().equals(id));
	}

	@Override
	public Carro getId(Long id) {
		return car.stream()
				.filter((c) -> c.getId().equals(id))
				.collect(Collectors.toList())
				.get(0);
	}

	@Override
	public List<Carro> getTodos() {
		return car;
	}

}
