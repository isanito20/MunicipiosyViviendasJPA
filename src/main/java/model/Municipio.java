package model;

public class Municipio {
	// Fields
		private int id;
		private int idProvincia;
		private int codMunicipio;
		private String nombre;
	
		/**
		 * 
		 */
		public Municipio() {
			super();
		}
	
		/**
		 * @param id
		 * @param idProvincia
		 * @param codMunicipio
		 * @param nombre
		 */
		public Municipio(int id, int idProvincia, int codMunicipio, String nombre) {
			super();
			this.id = id;
			this.idProvincia = idProvincia;
			this.codMunicipio = codMunicipio;
			this.nombre = nombre;
		}
	
		@Override
		public String toString() {
			return nombre;
		}
	
		public int getId() {
			return id;
		}
	
		public void setId(int id) {
			this.id = id;
		}
	
		public int getIdProvincia() {
			return idProvincia;
		}
	
		public void setIdProvincia(int idProvincia) {
			this.idProvincia = idProvincia;
		}
	
		public int getCodMunicipio() {
			return codMunicipio;
		}
	
		public void setCodMunicipio(int codMunicipio) {
			this.codMunicipio = codMunicipio;
		}
	
		public String getNombre() {
			return nombre;
		}
	
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
	
}

