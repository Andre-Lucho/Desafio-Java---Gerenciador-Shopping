import java.util.Arrays;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;

        if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && ano >= 2000) verificaDia(dia, mes);
        else dataInvalida();
        
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

    public void dataInvalida() {
        System.out.println("Data inválida");
        this.dia = 1;
        this.mes = 1;
        this.ano = 2000;
    }

    public boolean verificaAnoBissexto() {
        if ((ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0)) return true;
        else return false;
    }
    

    public void verificaDia(int dia, int mes) {
        int[] lista = { 1, 3, 5, 7, 8, 10, 12 };

        boolean diacom31 = Arrays.stream(lista).anyMatch(x -> x == mes);

        if (dia == 31) {
            if (!diacom31)
                dataInvalida();
        } else if (mes == 2) {
            if (dia == 30)
                dataInvalida();
            else if (dia == 29)
                this.dia = verificaAnoBissexto() ? 29 : 28;
        } else {
            this.dia = dia;
        }
    }

    @Override
    public String toString() {
        return String.format("%d/%d/%d", dia, mes, ano);
    }

}
