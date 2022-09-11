package model;

public class Estoque {
    private int numProduto;
    private String nomeProduto;
    private double saldoProduto;

    public int getNumProduto() {
        return numProduto;
    }

    public void setNumProduto(int numProduto) {
        this.numProduto = numProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getSaldoProduto() {
        return saldoProduto;
    }

    public void setSaldoProduto(double saldoProduto) {
        this.saldoProduto = saldoProduto;
    }

    @Override
    public String toString() {
        return "numProduto=" + numProduto + "\n" +
                "nomeProduto=" + nomeProduto + "\n" +
                "saldoProduto=" + saldoProduto + "\n";
    }

    public boolean incluirProduto(double valor){
        if(valor>0){
            saldoProduto +=  valor;
            return true;
        }
        return false;
    }

    public boolean retirarProduto(double valor){
        if(valor<= saldoProduto){
            saldoProduto -=valor;
            return true;
        }
        return false;
    }

}