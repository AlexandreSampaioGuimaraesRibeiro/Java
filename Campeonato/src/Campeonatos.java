import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Campeonatos {
    private List<Equipe> equipes = new ArrayList<>();
    private List<Partida> partidas = new ArrayList<>();
    private String nomeCampeonato;
    private final int maxPartidas = 45;
    private final int numeroDeEquipes=10;

    public Campeonatos(String nomeCampeonato, int numeroEquipes, List<String> nomesEquipes) {
        this.nomeCampeonato = nomeCampeonato;
        acrecentarEquipes(numeroEquipes, nomesEquipes);
    }

    private void acrecentarEquipes(int repetir, List<String> nomesEquipes) {
        if (repetir <= 0 || nomesEquipes.isEmpty()) return;
        Equipe equipe = new Equipe(nomesEquipes.get(0));
        equipes.add(equipe);
        acrecentarEquipes(repetir - 1, nomesEquipes.subList(1, nomesEquipes.size()));
    }

    public Campeonatos(String nomeCampeonato) {
        this.nomeCampeonato = nomeCampeonato;
        acrecentarEquipe(numeroDeEquipes);
    }

    private void acrecentarEquipe(int repetir){
        if (repetir<=0) return;   
        Equipe equipe = new Equipe(IO.readln("Nome da equipe:"));
        equipes.add(equipe);
        acrecentarEquipe(repetir-1);  
    }

    private boolean verificacao(){
        return partidas.size()<maxPartidas;
    }

    public Partida partida(){
        if (!verificacao()) {
            return null;
        }
        Random random = new Random();
    
        Equipe mandante = equipes.get(random.nextInt(equipes.size()));
        Equipe visitante;
        
        do {
            visitante = equipes.get(random.nextInt(equipes.size()));
        } while (visitante == mandante); // garante que não seja o mesmo time
        
        Partida novaPartida = new Partida(mandante, visitante);
        partidas.add(novaPartida);
        
        return novaPartida;
    }

    public String tabela(){
        organizar();
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("Tabela do Campeonato: ").append(nomeCampeonato).append("\n");

        // Cabeçalho
        sb.append(String.format("%-3s %-15s %3s %3s %3s %3s %4s %4s %4s%n",
            "Pos", "Equipe", "P", "V", "E", "D", "GM", "GS", "SG"));
        sb.append("-".repeat(55)).append("\n");
        
        // Linhas com os dados de cada equipe
        int posicao = 1;
        for (Equipe equipe : equipes) {
            int pontos = equipe.estatisticas.pontuacao();
            int vitorias = equipe.estatisticas.vitorias;
            int empates = equipe.estatisticas.empates;
            int derrotas = equipe.estatisticas.derrotas;
            int golsMarcados = equipe.golsMarcados;
            int golsSofridos = equipe.golsSofridos;
            int saldoDeGols = equipe.saldoDeGols();
            
            sb.append(String.format("%-3d %-15s %3d %3d %3d %3d %4d %4d %4d%n",
                posicao, equipe.nome, pontos, vitorias, empates, derrotas,
                golsMarcados, golsSofridos, saldoDeGols));
            
            posicao++;
        }
        
        return sb.toString();
    }

    private void organizar(){
        for (int i = 0; i < equipes.size(); i++) {
            for (int j = i; j < equipes.size(); j++) {
                if (equipes.get(i).estatisticas.pontuacao()<equipes.get(j).estatisticas.pontuacao()) {
                    Equipe temp = equipes.get(i);
                    equipes.set(i, equipes.get(j));
                    equipes.set(j, temp);
                }
            }
        }
    }
}
