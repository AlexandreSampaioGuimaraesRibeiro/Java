import java.util.ArrayList;
import java.util.List;

public class App {
       
    static List<Campeonatos> campeonatos = new ArrayList<>();
    
    public void pausa(){
        IO.readln();
    }
    
    public String lerString(String mensagem){
        return IO.readln(mensagem);
    }

    public int lerInteiro(String mensagem){
        return Integer.parseInt(IO.readln(mensagem));
    }

    private void cabecalho(){
        IO.println("Campeonato v0.1");
        IO.println("==================");
    }
    
    public int menuprincipal() {
        cabecalho();
        IO.println("1- Iniciar Capeonato");
        IO.println("2- Mostrar Todos os campeonatos");
        IO.println("0- Sair");
        return lerInteiro("Digite sua opição:");
    }
    
    void iniciarCampeonato() {
        Campeonatos campeonato = new Campeonatos(lerString("Digite o nome do campeonato:"));
        campeonatos.add(campeonato);
        IO.println("Campeonato iniciado com sucesso!");
    }
    
    void mostrarCampeonatos() {
        if (campeonatos.isEmpty()) {
            IO.println("Nenhum campeonato disponível.");
            return;
        }
        
        for (int i = 0; i < campeonatos.size(); i++) {
            IO.println("Campeonato " + (i + 1) + ":");
            IO.println(campeonatos.get(i).tabela());
            pausa();
        }
        
        escolherCampeonato();
    }

    void gerarPartida(Campeonatos campeonato) {
        Partida partida = campeonato.partida();
        if (partida == null) {
            IO.println("Número máximo de partidas atingido.");
            return;
        }
        
        int golsMandante = lerInteiro("Digite o número de gols do mandante (" + partida.mandante.nome + "):");
        int golsVisitante = lerInteiro("Digite o número de gols do visitante (" + partida.visitante.nome + "):");
        
        for (int i = 0; i < golsMandante; i++) {
            partida.golEquipe(partida.mandante.nome);
        }
        
        for (int i = 0; i < golsVisitante; i++) {
            partida.golEquipe(partida.visitante.nome);
        }
        
        IO.println("Resultado da partida: " + partida.resultado());
    }

    void menuCampeonato(Campeonatos campeonato) {
        int opcao;
        do {
            IO.println("1- Gerar Partida");
            IO.println("2- Mostrar Tabela");
            IO.println("0- Voltar");
            opcao = lerInteiro("Digite sua opção:");
            
            switch (opcao) {
                case 1 -> gerarPartida(campeonato);
                case 2 -> IO.println(campeonato.tabela());
                case 0 -> IO.println("Voltando ao menu principal...");
                default -> IO.println("Opção inválida. Tente novamente.");
            }
            pausa();
        } while (opcao != 0);
    }

    void escolherCampeonato() {
        int escolha = lerInteiro("Digite o número do campeonato que deseja visualizar (ou 0 para voltar):");
        
        if (escolha == 0) {
            return; // Voltar ao menu principal
        }
        
        if (escolha < 1 || escolha > campeonatos.size()) {
            IO.println("Opção inválida. Tente novamente.");
            escolherCampeonato();
            return;
        }
        
        Campeonatos campeonatoSelecionado = campeonatos.get(escolha - 1);
        IO.println(campeonatoSelecionado.tabela());

        menuCampeonato(campeonatoSelecionado);
    }
    
    void  main(){
        int opcao;
        do {
            opcao = menuprincipal();
            switch (opcao) {
                case 1 -> iniciarCampeonato();
                case 2 -> mostrarCampeonatos();
                case 0 -> IO.println("Saindo...");
                default -> IO.println("Opção inválida. Tente novamente.");
            }
            pausa();
        } while (opcao != 0);
    }


}
