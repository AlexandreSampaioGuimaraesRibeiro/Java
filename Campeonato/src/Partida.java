public class Partida {
    public Equipe mandante;
    public Equipe visitante;
    private int[] placar;
    private boolean finalizada=false;

    public Partida(Equipe mandante,Equipe visitante){
        this.mandante = mandante;
        this.visitante = visitante;
        placar = new int[2];
        placar[0]=0;
        placar[1]=0;

        mandante.partidas.add(this);
        visitante.partidas.add(this);

    }

    public int golEquipe(String nome){
        if (mandante.nome.equals(nome)) {
            return placar[0]++;            
        }
        return placar[1]++;
    }

    public String resultado(){
        finalizar();
        String vencedor;
        if (placar[0] > placar[1]) {
            vencedor = mandante.nome + " venceu!";
        } else if (placar[0] < placar[1]) {
            vencedor = visitante.nome + " venceu!";
        } else {
            vencedor = "Empate!";
        }
        
        return String.format("%s %d x %d %s - %s", 
            mandante.nome, placar[0], placar[1], visitante.nome, vencedor);
    }

    private void finalizar(){
        if (finalizada) return; 
        
        mandante.golMarcado(placar[0]);
        mandante.golSofrido(placar[1]);
        visitante.golMarcado(placar[1]);
        visitante.golSofrido(placar[0]);
        
        int resultado = Integer.compare(placar[0], placar[1]);
        switch (resultado) {
            case 1  -> { mandante.estatisticas.vitoria();  visitante.estatisticas.derrota(); }
            case -1 -> { mandante.estatisticas.derrota();  visitante.estatisticas.vitoria(); }
            default -> { mandante.estatisticas.empate();   visitante.estatisticas.empate();  }
        }
        
        finalizada = true;
    }
}
