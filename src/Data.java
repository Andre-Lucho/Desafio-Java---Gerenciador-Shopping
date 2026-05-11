import java.util.Arrays;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        if (dia >= 1 && dia <= 31) {
            if(mes >= 1 && mes <= 12){
                if(ano >= 2000){
                    verificaDia(dia, mes);
                } else {
                    this.dataInvalida();
                }
            } else {
                this.dataInvalida();
            }
        } else{
            this.dataInvalida();
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

    public void dataInvalida(){
        System.out.println("Data inválida");
        this.dia = 1;
        this.mes = 1;
        this.ano = 2000;
    }

    public boolean verificaAnoBissexto() {
        if ((ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }

    public void verificaDia(int dia, int mes){
        int[] lista = {1, 3, 5, 7, 8, 10, 12};

        boolean diacom31 = Arrays.asList(lista).contains(mes);

        if(dia == 31 && diacom31){
            this.dia = 31;
        } else {
            dataInvalida();
        }
        if (dia == 29 && mes == 2) {
            this.dia = verificaAnoBissexto() ? 29 : 28;
        }

        if(dia != 31 || (dia != 29 && mes != 2)){
            this.dia = dia;
        }
    }

    @Override
    public String toString() {
        return String.format("Data: %d/%d/%d", dia, mes, ano);
    }

}
