package EstacaoFerroviaria;

public class BancoDeDados{
	
	private Vagao vagoes[];
	private Locomotiva locomotivas[];
	private Trem trens[];
	private Estacao estacoes[];
	private LinhaFerroviaria linhas[];
	
	private int countVagao = 0;
	private int countLocomotiva = 0;
	private int countTrem = 0;
	private int countEstacao = 0;
	private int countLinha = 0;
		
	public void adicionaVagao(Vagao vagao){
		countVagao++;
		vagoes[countVagao -1] = vagao;
	}
	
	public void adicionaLocomotiva(Locomotiva locomotiva){
		countLocomotiva++;
		locomotivas[countLocomotiva - 1] = locomotiva;
	}
	
	public void adicionaTrem(Trem trem){
		countTrem++;
		trens[countTrem - 1] = trem;
	}
	
	public void adicionaEstacao(Estacao estacao){
		countEstacao++;
		estacoes[countEstacao - 1] = estacao;
	}
	
	public void adicionaLinhaFerroviaria(LinhaFerroviaria linha){
		countLinha++;
		linhas[countLinha - 1] = linha;
	}
	
}
