public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(0);
        arvoreBinaria.inserir(-3);
        arvoreBinaria.inserir(-5);
        arvoreBinaria.inserir(-4);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(3);
        arvoreBinaria.inserir(4);
        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(9);
        arvoreBinaria.exibir("Pre");
        arvoreBinaria.buscar(5);

    }
}
