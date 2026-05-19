# Relatório
## Gabriela Sosigan Pavaneli Silva

### Buscar/Buscar Recursivo
Assim como as funções de inserção que já estavam no código, optei por fazer as funções de busca de forma recursiva, seguindo um padrão parecido. Também escolhi essa abordagem por sua praticidade: se o valor buscado é menor que o atual, o método troca a direção, mas faz a mesma função, mudando apenas o apontamento. Embora o uso de laços de repetição como `while` seja eficiente em termos de memória, a versão recursiva corta o problema pela metade a cada execução e elimina a necessidade de ponteiros auxiliares para controle de fluxo, deixando o código menos propício a erros de lógica de ponteiros.

### BuscarTipo
O método `buscarTipo` possui uma implementação direta. Ele foi construído dessa maneira porque sua única responsabilidade é verificar o estado dos apontamentos (esquerda e direita) de um nó específico que já foi encontrado, não necessitando de repetições ou caminhadas pela estrutura da árvore.

### BuscarPai
A função `buscarPai` utiliza a abordagem recursiva para contornar os apontamentos da estrutura, onde os nós apontam apenas para baixo (esquerda e direita) e não possuem referência para os nós acima deles. A recursão permite descer a árvore a partir da raiz aplicando o conceito de "olhar à frente" para checar se o filho direto do nó atual é o alvo procurado, aproveitando a regra matemática de ordenação da árvore para decidir recursivamente por qual direção descer.

### Remover
A função `remover` funciona como um método direto, sem laços de repetição ou recursões próprias, focando no controle de fluxo. A decisão por esse formato se dá porque o papel do método é apenas reunir as informações coletadas pelas outras funções (nó alvo, seu pai e tipo anatômico) e, através de uma estrutura `switch/case`, direcionar o programa para o método de exclusão específico.

### RemoverFolha
A função tem estrutura direta e sequencial, não exigindo execuções iterativas ou chamadas recursivas. Isso se justifica pelo fato de que, como o nó alvo e seu pai já foram previamente localizados, a operação estrutural se resume a uma atualização de ponteiros.

### RemoverUmFilho
Também possui execução direta, pelo mesmo princípio anatômico da remoção de nós folha. A ação requer um rearranjo local de referências, onde o método faz com que o pai do nó removido adote o único filho do nó alvo, pulando o elemento deletado sem precisar caminhar pela árvore novamente.

### RemoverDoisFilhos
Opera de forma sequencial, gerenciando o processo de substituição de valores sem iterar por conta própria na árvore. Ela busca o sucessor por meio de uma função específica e aciona recursivamente o método principal de remoção para deletar o nó original, evitando uma reestruturação complexa e manual de múltiplos ponteiros.

### ObterSucessor
Foi implementada de forma iterativa baseada em um laço de repetição `while`. Como o algoritmo exige apenas dar um passo para a direita e descer continuamente para a esquerda até encontrar um valor nulo, atualizar iterativamente uma única referência gasta menos recursos do que empilhar chamadas recursivas da função no sistema.
