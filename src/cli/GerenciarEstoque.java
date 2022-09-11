package cli;

import model.Estoque;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarEstoque {
    public List<Estoque> lista = new ArrayList<>();

    public static void main(String[] args) {
        GerenciarEstoque gc =new GerenciarEstoque();
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        do{
            opc = construirMenu(gc, sc);
        }while(opc!=9);
    }

    private static int construirMenu(GerenciarEstoque gc, Scanner sc) {
        int opc;
        System.out.println("MENU");
        System.out.println("1. Cadastrar Produto");
        System.out.println("2. Entrada Produto");
        System.out.println("3. Retirar Produto");
        System.out.println("4. Saldo Estoque");
        System.out.println("5. Saldo de Todo o Estoque");
        System.out.println("6. Patrimonio Liquido");
        System.out.println("9. Sair");
        System.out.println("Digite sua opcao: ");
        opc = Integer.parseInt(sc.nextLine());
        switch (opc){
            case 1:
                gc.execCadastrarProduto(sc);
                break;
            case 2:
                gc.execEntradaProduto(sc);
                break;
            case 3:
                gc.execRetirarProduto(sc);
                break;
            case 4:
                gc.execSaldoEstoque(sc);
                break;
            case 5:
                gc.execSaldoTodoEstoque();
                break;
            case 6:
                gc.execMostrarPatrimonio();
                break;
            case 9:
                System.out.println("FIM");
                break;
            default:
                System.out.println("Opcao invalida !");
        }
        return opc;
    }

    public void execCadastrarProduto(Scanner sc){
        //Cadastra uma nova e coloca na lista de produtos
        Estoque estoque = new Estoque();
        System.out.println("Digite o numero do produto");
        estoque.setNumProduto(Integer.parseInt(sc.nextLine()));
        System.out.println("Digite o nome do produto");
        estoque.setNomeProduto(sc.nextLine());
        lista.add(estoque);
        System.out.println("Produto cadastro com sucesso !");

    }

    public void execEntradaProduto(Scanner sc){
        System.out.println("Digite o numero do produto para dar entrada no estoque: ");
        int proc = Integer.parseInt(sc.nextLine());
        Estoque estoque = null;
        for(Estoque e : lista){
            if(e.getNumProduto()==proc) {
                estoque = e;
                break;
            }
        }
        if(estoque!=null){
            System.out.println("Digite o valor para incluir o produto no estoque: ");
            boolean ok = estoque.incluirProduto(Integer.parseInt(sc.nextLine()));
            if(ok){
                System.out.println("Produto incluso no estoque com sucesso");
            }else{
                System.out.println("Valor não pode ser menor ou igual a ZERO");
            }
        }else{
            System.out.println("Produto não encontrado !");
        }
    }

    public void execRetirarProduto(Scanner sc){
        System.out.println("Digite o numero do produto para dar baixa no estoque: ");
        int proc = Integer.parseInt(sc.nextLine());
        Estoque estoque = null;
        for(Estoque e : lista){
            if(e.getNumProduto()==proc) {
                estoque = e;
                break;
            }
        }
        if(estoque!=null){
            System.out.println("Digite a quantidade de retirada de produtos: ");
            boolean ok = estoque.retirarProduto(Integer.parseInt(sc.nextLine()));
            if(ok) {
                System.out.println("Produto retirado do estoque com sucesso !");
            }else{
                System.out.println("Sem estoque para retirar o produto !");
            }
        }else{
            System.out.println("Produto não encontrado !");
        }
    }

    public void execSaldoEstoque(Scanner sc){
        System.out.println("Digite o numero da produto para verificar o saldo do estoque: ");
        int proc = Integer.parseInt(sc.nextLine());
        Estoque estoque = null;
        for(Estoque e : lista){
            if(e.getNumProduto()==proc) {
                estoque = e;
                break;
            }
        }
        if(estoque!=null){
            System.out.println("O saldo do estoque eh: " + estoque.getSaldoProduto());
        }
    }

    public void execSaldoTodoEstoque(){
        for(Estoque e: lista){
            System.out.println(e.toString());
        }
    }

    public void execMostrarPatrimonio(){
        double total = 0;
        for(Estoque e: lista){
            total +=e.getSaldoProduto();
        }
        System.out.println("O Total de produtos no estoque: " + total);
    }



}