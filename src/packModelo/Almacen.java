package packModelo;

import packControlador.Controler;

public class Almacen {
	private static Almacen miAlmacen;
	private Armamento miArmamento;
	
	private Almacen(){
		miArmamento= new Armamento();
		miArmamento.GenerarArmamentoAlmacen();
		
	}
	
	public static Almacen getMiAlmacen(){
		if (miAlmacen==null) {
			miAlmacen=new Almacen();
		}
		return miAlmacen;
	}
	
	
	public Armamento getArmamento(){
		return this.miArmamento;
	}
}
