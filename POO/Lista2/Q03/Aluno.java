public class Aluno extends Pessoa{
	
	//ATRIBUTOS
	private String matricula;
	private String escola;
	
	//METODOS SET E GET
	public void setMatricula(String matricula){
		this.matricula = matricula;
	}
	public String getMatricula(){
		return matricula;
	}
	
	public void setEscola(String escola){
		this.escola = escola;
	}
	public String getEscola(){
		return escola;
	}
	
	//CONTRUTORES
	
	public Aluno(String nome, String cpf, String dataNascimento, String logradouro, double numero, String bairro, String cidade, String UF, String matricula, String escola){
	
		super(nome, cpf, dataNascimento, logradouro, numero, bairro, cidade, UF);
		this.matricula = matricula;
		this.escola = escola;
	}
	
	//METODO TOSTRING
	public String toString(){
	
		String str = "";
		str += "*------------------------------------------------------*\n";
		str += "Nome: " + this.nome +  "\n";
		str += "CPF: " +  this.cpf +  "\n";
		str += "Data de nascimento: " + this.dataNascimento + "\n";
		str += "Logradouro: " + this.logradouro + "\n";
		str += "Número: " + this.numero + "\n";
		str += "Bairro: " + this.bairro + "\n";
		str += "Cidade: " + this.cidade + "\n";
		str += "UF: " + this.UF + "\n";
		str += "Matrícula: " + this.matricula + "\n";
		str += "Escola: " + this.escola + "\n";
		str += "*------------------------------------------------------*\n";
		
		return str;
	}
	
}
