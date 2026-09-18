public class Estatisticas {
    private final int maxPartidas = 9;
    public  int vitorias;
    public int empates;
    public int derrotas;

    public Estatisticas(){
        vitorias =0;
        empates = 0;
        derrotas = 0;
    }

    public int derrota(){
        if (verificacao()) {
            return derrotas++;    
        }
        return derrotas;
    }

    public int empate(){
        if (verificacao()) {
            return empates++;        
        }
        return empates;
    }

    public int vitoria(){
         if (verificacao()) {
            return vitorias++;        
        }
        return vitorias;
    }

    public int pontuacao(){
        return (vitorias*3)+(empates*1);
    }

    private boolean verificacao(){
        return vitorias+derrotas+empates<maxPartidas;
    }

}
 