import java.util.Arrays;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        if(verificaDia(dia, mes, ano)){
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            dataInvalida();
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

    public void dataInvalida() {
        System.out.println("Data inválida");
        this.dia = 1;
        this.mes = 1;
        this.ano = 2000;
    }

    public void verificaAnoBissexto() {
        if ((ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0))
            this.dia = 29;
        else
            this.dia = 28;
    }
    

    public boolean verificaDia(int dia, int mes, int ano) {

        if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && ano >= 2000){
            
            int[] lista = { 1, 3, 5, 7, 8, 10, 12 };

            boolean mesCom31 = Arrays.stream(lista).anyMatch(x -> x == mes);
        
            if (dia == 31) {
                if (!mesCom31){
                    return false;
                }
            } else if (mes == 2) {
                if (dia == 30){
                    return false;
                }
                else if (dia == 29)
                    verificaAnoBissexto();
            } 
            return true;
        } else {
            return false;
        } 
        
    }

    @Override
    public String toString() {
        return String.format("%d/%d/%d", dia, mes, ano);
    }

}
