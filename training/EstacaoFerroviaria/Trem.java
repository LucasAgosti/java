package EstacaoFerroviaria;
import java.util.Date;
public class Trem{
	
	private Vagao vagao;
	private Locomotiva locomotiva;
	private Date dataDeFormacao;
	private Estacao origem;
	private Estacao destino;
	private int limite;
	
	//MÉTODOS SET E GET
	
	public void setLimite(int limite){
		this.limite = limite;
	}
	public int getLimite(){
		return limite;
	}
	
	public Trem(Vagao vagao, Locomotiva locomotiva, Date dataDeFormacao, Estacao origem, Estacao destino, int limite){
		this.vagao = vagao;
		this.locomotiva = locomotiva;
		this.dateDeFormacao = dateDeFormacao;
		this.origem = origem;
		this.destino = destino;
		this.limite = limite;
	}
	public Trem(Locomotiva locomotiva, Date dataDeFormacao, Estacao origem, Estacao destino, int limite){
		this.locomotiva = locomotiva;
		this.dateDeFormacao = dateDeFormacao;
		this.origem = origem;
		this.destino = destino;
		this.limite = limite;
	}
	public Trem(Vagao vagao, Date dataDeFormacao, Estacao origem, Estacao destino, int limite){
		this.vagao = vagao;
		this.dateDeFormacao = dateDeFormacao;
		this.origem = origem;
		this.destino = destino;
		this.limite = limite;
	}
	
	public void percurso(Estacao origem, Estacao destino){
		System.out.println("O trem vai da estação " + origem.getSigla + " até a " + destino.getSigla + ".");
			
	}
	
}
