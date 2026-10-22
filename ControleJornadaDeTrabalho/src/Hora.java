public class Hora {
    private int horas;
    private int minutos;
    private int segundos;

    Hora(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public Hora incrementar(int minutos) {
        this.minutos += minutos;
        if (this.minutos >= 60) {
            this.horas += this.minutos / 60;
            this.minutos = this.minutos % 60;
        }
        return this;
    }

    public boolean estaNaFrente(Hora outraHora) {
        boolean estaNaFrente = true;
        if (this.horas < outraHora.horas) {
            estaNaFrente = false;
        } else if (this.horas == outraHora.horas && this.minutos < outraHora.minutos) {
            estaNaFrente = false;
        } else if (this.horas == outraHora.horas && this.minutos == outraHora.minutos && this.segundos < outraHora.segundos) {
            estaNaFrente = false;
        }

        return estaNaFrente;
    }

    public int diferenciaEmMinutos(Hora outraHora) {
        int diferenca = 0;
        if (this.estaNaFrente(outraHora)) {
            diferenca = (this.horas - outraHora.horas) * 60 + (this.minutos - outraHora.minutos);
        } else {
            diferenca = (outraHora.horas - this.horas) * 60 + (outraHora.minutos - this.minutos);
        }
        return diferenca;
    }
}
