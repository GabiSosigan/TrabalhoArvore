public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
        System.out.println("Árvore Binária criada com sucesso!");
    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);

        if(estaVazia()) {
            this.raiz = novoNo;
        } else {
            inserirRecursivo(novoNo, this.raiz);
        }
    }

    public void inserirRecursivo(No novoNo, No atual) {
        if (atual.getConteudo() > novoNo.getConteudo()) {
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novoNo);
                System.out.println("O nó " + novoNo.getConteudo() + " foi inserido na Árvore.");
                return;
            } else {
                inserirRecursivo(novoNo, atual.getEsquerda());
            }
        } else if (atual.getConteudo() == novoNo.getConteudo()) {
            System.out.println("Não é possível informar nós repetidos.");
            return;
        } else {
            if (atual.getDireita() == null) {
                atual.setDireita(novoNo);
                System.out.println("O nó " + novoNo.getConteudo() + " foi inserido na Árvore.");
                return;
            } else {
                inserirRecursivo(novoNo, atual.getDireita());
            }
        }
    }

    public No buscar(Integer busca){
        if (estaVazia()){
            System.out.println("A árvore está vazia!");
            return null;
        }
        return buscarRecursivo(this.raiz, busca);
    }

    public No buscarRecursivo(No atual, Integer busca){
        if (atual == null){
            System.out.println("O nó buscado não existe!");
            return null;
        }
        if (busca.equals(atual.getConteudo())){
            System.out.println("O nó " + atual.getConteudo() + " foi encontrado!");
            System.out.println(buscarTipo(atual));
            return atual;
        }
        if (busca < atual.getConteudo()){
            System.out.println("Esquerda");
            return buscarRecursivo(atual.getEsquerda(), busca);
        }
        else {
            System.out.println("Direita");
            return buscarRecursivo(atual.getDireita(), busca);
        }
    }

    public String buscarTipo(No busca){
        if (busca == null){
            return "O nó buscado não existe.";
        }
        if (busca.getEsquerda() == null && busca.getDireita() == null){
            return "Nó folha";
        }
        if (busca.getEsquerda() != null && busca.getDireita() != null){
            return "Nó com dois filhos";
        }
        return "Nó com um filho";
    }

    public No buscarPai(No atual, Integer conteudo){
        if (atual == null || atual.getConteudo().equals(conteudo)){
            return null;
        }
        if (atual.getEsquerda() != null && atual.getEsquerda().getConteudo().equals(conteudo)){
            return atual;
        }
        if (atual.getDireita() != null && atual.getDireita().getConteudo().equals(conteudo)){
            return atual;
        }
        if (conteudo < atual.getConteudo()) {
            return buscarPai(atual.getEsquerda(), conteudo);
        } else {
            return buscarPai(atual.getDireita(), conteudo);
        }
    }

    public void remover(Integer valor){
        No alvo = buscar(valor);
        No pai = buscarPai(this.raiz, valor);

        if (alvo == null) {
            System.out.println("O valor inserido não existe!");
            return;
        }

        String tipo = buscarTipo(alvo);

        switch (tipo) {
            case "Nó folha":
                removerFolha(pai, alvo);
                break;
            case "Nó com um filho":
                removerUmFilho(pai, alvo);
                break;
            case "Nó com dois filhos":
                removerDoisFilhos(alvo);
                break;
        }
    }

    public void removerFolha(No pai, No alvo){
        if (pai == null){
            this.raiz = new No(null);
            System.out.println("A raiz folha foi removida");
            return;
        }
        if (pai.getEsquerda() == alvo){
            pai.setEsquerda(null);
        }
        else{
            pai.setDireita(null);
        }
        System.out.println("Nó folha removido: " + alvo.getConteudo());
    }

    public void removerUmFilho(No pai, No alvo){
        No neto;
        if (alvo.getEsquerda() != null){
            neto = alvo.getEsquerda();
        } else {
            neto = alvo.getDireita();
        }
        if (pai == null){
            this.raiz = neto;
            System.out.println("A raíz foi removida e o nó " + neto.getConteudo() + " é a nova raíz.");
            return;
        }
        if (pai.getEsquerda() == alvo){
            pai.setEsquerda(neto);
        } else {
            pai.setDireita(neto);
        }
        System.out.println("Nó com um filho removido: " + alvo.getConteudo());
    }

    public No obterSucessor (No suc){
        No atual = suc.getDireita();

        while(atual.getEsquerda() != null){
            atual = atual.getEsquerda();
        }
        System.out.println("O sucessor é " + atual.getConteudo());
        return atual;
    }

    public void removerDoisFilhos(No alvo){
        No sucessor = obterSucessor(alvo);
        Integer valorSuc = sucessor.getConteudo();
        remover(valorSuc);
        alvo.setConteudo(valorSuc);
        System.out.println("Nó com dois filhos removido: " + alvo.getConteudo());
    }

    public boolean estaVazia() {
        if(this.raiz.getConteudo() == null) {
            return true;
        } else {
            return false;
        }
    }

    private void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    private void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

    private void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }

    public void exibir(String percurso) {
        switch (percurso){
            case("Pre"):
                preOrdem(this.raiz);
                break;
            case("Em"):
                emOrdem(this.raiz);
                break;
            case("Pos"):
                posOrdem(this.raiz);
                break;
        }
    }


}
