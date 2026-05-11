public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        if (dia >= 1 && dia <= 31) {
            if (dia == 29 && mes == 2) {
                this.dia = verificaAnoBissexto() ? 29 : 28;
            } else {
                this.dia = dia;
            }
        } else if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        } else if (ano >= 2000) {
            this.ano = ano;
        } else {
            System.out.println("Data inválida");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean verificaAnoBissexto() {
        if ((ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("Data: %d/%d/%d", dia, mes, ano);
    }

}
