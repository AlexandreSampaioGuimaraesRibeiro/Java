import java.util.ArrayList;
import java.util.List;

public class Equipe {
    public  String nome;
    public int golsMarcados;
    public int golsSofridos;
    public Estatisticas estatisticas;
    public List<Partida> partidas = new ArrayList<>();

    public Equipe(String nome){
        this.nome = nome;
        golsMarcados = 0;
        golsSofridos = 0;
        estatisticas = new Estatisticas(); 
    }

    public int golMarcado(int marcado){
        return golsMarcados+=marcado;
    }

    public int golSofrido(int sofrido){
        return golsSofridos+=sofrido;
    }

    public int saldoDeGols(){
        return golsMarcados-golsSofridos;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append(String.format("Equipe: %s%n", nome));
        sb.append(String.format("Gols Marcados: %d%n", golsMarcados));
        sb.append(String.format("Gols Sofridos: %d%n", golsSofridos));
        sb.append(String.format("Saldo de Gols: %d%n", saldoDeGols()));
        sb.append(String.format("Pontuação: %d%n", estatisticas.pontuacao()));
        
        sb.append("Partidas:\n");
        if (partidas.isEmpty()) {
            sb.append("Nenhuma partida jogada ainda.\n");
        } else {
            for (Partida partida : partidas) {
                sb.append(partida.resultado()).append("\n");
            }
        }
        
        return sb.toString();
    }
}
