abstract public class DiaDeTrabalho {
    protected int minutosJonada;
    protected int minutosAlmoco;
    protected LocalDate data;
    protected Hora horaEntrada;
    protected Hora horaSaida;
    protected int saldoMinutos;

    protected DiaDeTrabalho(LocalDate data, Hora horaEntrada, int MINUTOS_JORNADA, int MINUTOS_ALMOCO) {
        this.data = data;
        this.horaEntrada = horaEntrada;
        this.minutosJonada = MINUTOS_JORNADA;
        this.minutosAlmoco = MINUTOS_ALMOCO;
    }

    protected Hora registrarSaida(Hora horaSaida) {
        if (finalizado()) {
            throw new IllegalStateException("Dia de trabalho já finalizado");
        }
        this.horaSaida = horaSaida;
        retornaSaldoMinutos();
        return this.horaSaida;
    }

    protected int retornaSaldoMinutos() {
        if (!finalizado()) {
            throw new IllegalStateException("Dia de trabalho não finalizado");
        }
        saldoMinutos = horaSaida.diferenciaEmMinutos(horaEntrada) - minutosJonada - minutosAlmoco;
        return saldoMinutos;
    }

    protected boolean finalizado() {
        return horaSaida != null;
    }
}
