package f_alerta;

public class Tipos {
	private int ID;
	private String Descricao;
	
	
	
	public Tipos(int iD, String descricao) {
		super();
		ID = iD;
		Descricao = descricao;
	}
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Descricao == null) ? 0 : Descricao.hashCode());
		result = prime * result + ID;
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
		Tipos other = (Tipos) obj;
		if (Descricao == null) {
			if (other.Descricao != null)
				return false;
		} else if (!Descricao.equals(other.Descricao))
			return false;
		if (ID != other.ID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Tipos [ID=" + ID + ", Descricao=" + Descricao + "]";
	}
	
	
	

}
