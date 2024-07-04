package ec.edu.ups.ppw63.carros_crud.business;

import java.util.List;

import ec.edu.ups.ppw63.carros_crud.dao.CarroDAO;
import ec.edu.ups.ppw63.carros_crud.model.Carro;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCarros {
	
	@Inject
	private CarroDAO daoCarro;

	
	public void guardarCarro(Carro carro) {
		Carro car = daoCarro.read(carro.getCodigo());
		if (car != null){
			daoCarro.update(carro);
		}else {
			daoCarro.insert(carro);
		}
	}
	
	
	public void actualizarCarro(Carro carro) throws Exception {
		Carro car = daoCarro.read(carro.getCodigo());
		if (car != null){
			daoCarro.update(carro);
		}else {
			throw new Exception("Carro no existe");
		}
	}
	

	public Carro getCarroPorCodigo(int codigo) throws Exception{
		
		if(codigo<0)
			throw new Exception("Codigo incorrecto");
			
		return daoCarro.getCarroPorCodigo(codigo);
	}
	

	public void borrarCarro(int codigo){
		
		daoCarro.remove(codigo);
	}
	

	public List<Carro> getCarros(){
		return daoCarro.getAll();
	}
	
}


