public class RelogioAmericano extends Relogio {
    private String periodo;

    public RelogioAmericano() {
        this.periodo = "AM";
    }

    @Override
    public void setHora(int hora) {
        if (hora >= 1 && hora <= 12) {
            this.hora = hora;
        }
    }

    public void setPeriodo(String periodo) {
        if (periodo.equals("AM") || periodo.equals("PM")) {
            this.periodo = periodo;
        }
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getHorarioAmericano() {
        return String.format("%02d:%02d:%02d %s", hora, minuto, segundo, periodo);
    }

    @Override
    public String getHorario() {
        return getHorarioAmericano();
    }

    @Override
    public void sincronizar(Relogio outro) {
        var horaOutro = outro.getHora();
        if (horaOutro == 0) {
            hora = 12;
            periodo = "AM";
        } else if (horaOutro < 12) {
            hora = horaOutro;
            periodo = "AM";
        } else if (horaOutro == 12) {
            hora = 12;
            periodo = "PM";
        } else {
            hora = horaOutro - 12;
            periodo = "PM";
        }
        minuto = outro.getMinuto();
        segundo = outro.getSegundo();
    }
}
