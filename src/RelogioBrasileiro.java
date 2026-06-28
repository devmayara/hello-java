public class RelogioBrasileiro extends Relogio {
    @Override
    public void setHora(int hora) {
        if (hora >= 0 && hora < 24) {
            this.hora = hora;
        }
    }

    @Override
    public String getHorario() {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

    @Override
    public void sincronizar(Relogio outro) {
        hora = outro.getHora();
        minuto = outro.getMinuto();
        segundo = outro.getSegundo();
    }
}
