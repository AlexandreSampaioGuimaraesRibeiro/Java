public class PJ extends DiaDeTrabalho {
    
    public PJ(Hora horaEntrada, int MINUTOS_ALMOCO, Hora saidaProgramada) {
        super(LocalDate.now(), horaEntrada, MINUTOS_ALMOCO, saidaProgramada);
    }
    
    @Override
    public Hora registrarSaida(Hora saida) {
        if(horaSaida !=null || horaEntrada.estaNaFrente(saida)){
            throw new IllegalArgumentException("Hora de saída inválida ou jornada já finalizada");
        }
        horaSaida = saida;
        SaldoDeMinutos();
        return horaSaida;
    }

    private int SaldoDeMinutos() {
        saldoMinutos = horaSaida.diferenciaEmMinutos(horaEntrada);
        return saldoMinutos;
    }
}
