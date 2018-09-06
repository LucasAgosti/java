public class Poligono{
	
	private  String poligono;
	
	public void setNome(int N){
		if(N == 1){
			poligono = "Ponto";
			this.poligono = poligono;	
		}else if(N == 2){
			poligono = "Reta";
			this.poligono = poligono;
		}else if(N == 3){
			poligono = "Trilátero";
			this.poligono = poligono;
		}else if(N == 4){
			poligono = "Quadrilátero";
			this.poligono = poligono;
		}else if(N == 5){
			poligono = "Pentalátero";
			this.poligono = poligono;
		}else if(N == 6){
			poligono = "Hexalátero";
			this.poligono = poligono;
		}else if(N == 7){
			poligono = "Heptalátero";
			this.poligono = poligono;
		}else if(N == 8){
			poligono = "Octalátero";
			this.poligono = poligono;
		}else if(N == 9){
			poligono = "Enealátero";
			this.poligono = poligono;
		}else if(N == 10){
			poligono = "Decalátero";
			this.poligono = poligono;
		}
	}
	public String getNome(){
		return poligono;
	}
	
	public String toString(){
		String str = "";
		str = str + "Nome do polígono: ";
		str = str + this.poligono + "\n";
		return str;
	}
}
