## Loja.java

### 1. `List<Produto> estoqueProdutos1`:

---

- **`List` (A Interface):** Em Java, `List` representa o conceito genérico de uma lista sequencial de elementos. É uma boa prática de mercado usá-la na declaração porque ela define _o que_ a variável pode fazer (adicionar, remover, percorrer), deixando aberta a escolha de _qual_ tipo de lista real ela será (como o próprio `ArrayList`).
- **`<Produto>` (Generics):** Garantir a **segurança de tipos** (_Type Safety_). Eles informam ao Java: _“Esta lista é exclusiva para guardar objetos do tipo `Produto`.”_
- **`estoqueProdutos1` (Variável):** estoque dinâmico no código.

**A Aplicação Prática:**

1. **Fim do tamanho fixo:** Com a `List`, o tamanho é dinâmico e cresce conforme a necessidade.
2. **Código muito mais limpo ("Clean Code"):** Com a `List`, o Java faz o trabalho pesado: basta chamar `estoqueProdutos1.add(produto);` e o item vai automaticamente para o final da fila!

<br>

### 2. Método removeIf():

---

Remove TODOS os produtos (e não apenas o primeiro == removeProduto()) com o nome passados e retorna `TRUE` se removeu pelo menos um produto

<br>

### 3. Método String toString():

---

```java
String estoqueFormatado = Arrays.stream(getEstoqueProdutos())
                                .map(prod -> prod == null ? "" : prod.toString())
                                .collect(Collectors.joining(" | ", "[", "]"));
```

#### Parte 1 — `Arrays.stream(getEstoqueProdutos())`

- `getEstoqueProdutos()` retorna o array `Produto[]` (o estoque da loja)
- `Arrays.stream(...)` **converte o array em um `Stream<Produto>`** — uma sequência de elementos que pode ser processada em pipeline
- Pense no Stream como uma "esteira" por onde cada `Produto` passa, um a um

---

## Parte 2 — `.map(prod -> prod == null ? "" : prod.toString())`

Aqui entra uma lambda com **operador ternário**. Para cada `prod` na esteira:

| Condição                                | Resultado                                             |
| --------------------------------------- | ----------------------------------------------------- |
| `prod == null` (posição vazia no array) | Transforma em `""` (string vazia)                     |
| `prod != null` (tem produto)            | Chama `prod.toString()`, ex: `"Notebook - R$3500.00"` |

Após o `map`, o `Stream<Produto>` vira um **`Stream<String>`** — cada produto virou seu texto equivalente.

---

## Parte 3

```java
.collect(Collectors.joining(" | ", "[", "]"))
//                            ↑      ↑    ↑
//                         separador prefixo sufixo
```

- **Coleta** todos os elementos do Stream e **une em uma única String**
- `Collectors.joining` aceita 3 argumentos:
    - `" | "` → separador entre cada elemento
    - `"["` → prefixo (coloca no início)
    - `"]"` → sufixo (coloca no fim)

---

## Exemplo visual completo

Suponha um estoque com 3 posições: `[Notebook, null, Mouse]`

```
Stream criado:   [Produto("Notebook"),  null,  Produto("Mouse")]
         ↓ .map()
Stream mapeado:  ["Notebook - R$3500", "",   "Mouse - R$150"]
         ↓ .collect(joining)
Resultado:       "[Notebook - R$3500 |  | Mouse - R$150]"
```

O resultado final é a String `estoqueFormatado`, que é então inserida no `String.format()` do `toString()` da Loja.

---

### Resumo da cadeia:

```
array Produto[]  →  Stream<Produto>  →  Stream<String>  →  String formatada
               stream()            map()              collect()
```

<br>

### A) Método `.map()`:

O método `.map()` aceita como argumento uma **`Function<T, R>`** — uma interface funcional do Java. Ela tem um único método abstrato:

```java
R apply(T t);  // recebe um T, retorna um R
```

Quando você escreve:

```java
.map(prod -> prod == null ? "" : prod.toString())
```

O Java **converte a lambda** automaticamente numa implementação de `Function<Produto, String>`. É equivalente a escrever:

```java
.map(new Function<Produto, String>() {
    @Override
    public String apply(Produto prod) {
        return prod == null ? "" : prod.toString();
    }
})
```

A lambda é só uma **sintaxe mais curta** para isso.

---

#### Como o `.map()` chama a lambda a cada iteração?

Internamente, o `.map()` faz algo equivalente a isso:

```java
// Pseudocódigo do que o map() faz por baixo dos panos:
for (Produto prod : estoqueProdutos) {
    String resultado = minhaFuncao.apply(prod); // ← chama a lambda aqui
    streamDeSaida.add(resultado);
}
```

Ou seja, para **cada elemento** do Stream, o `.map()` invoca o método `.apply()` da `Function`, passando o elemento atual como argumento — que no seu código é o parâmetro `prod`.

---

#### Rastreando iteração a iteração de .map():

Para cada element da array é chamado um callbak da função toString da classe Produto.java

- getEstoqueProdutos() retorna Produto[]

Suponha `estoqueProdutos = [Notebook, null, Mouse]`:

```
Iteração 1: prod = Produto("Notebook")
            prod == null? → NÃO
            → chama prod.toString() → "Notebook - R$3500.00"

Iteração 2: prod = null
            prod == null? → SIM
            → retorna ""

Iteração 3: prod = Produto("Mouse")
            prod == null? → NÃO
            → chama prod.toString() → "Mouse - R$150.00"
```

O Stream resultante contém: `["Notebook - R$3500.00", "", "Mouse - R$150.00"]`

---

#### E qual `toString()` é chamado?

O `prod.toString()` chama o **`toString()` da classe `Produto`** — não o da `Loja`
**Polimorfismo**: o método chamado depende do tipo **real** do objeto em `prod` em tempo de execução.

<br>

---

### B) `Arrays.stream()`:

`Arrays` é uma **classe utilitária** do pacote `java.util`. Ela contém métodos **estáticos** para manipular arrays. O `stream()` é um desses métodos — introduzido no **Java 8** junto com a Stream API.

### O que ele faz?

Ele **"embrulha" um array** numa estrutura chamada `Stream`, que permite processar os elementos em pipeline (encadeando operações como `.map()`, `.filter()`, `.collect()`, etc.).

```
Produto[]  ──Arrays.stream()──▶  Stream<Produto>
  (array)                          (stream)
```

**Por que isso é necessário?** Arrays em Java são estruturas "brutas" — não têm métodos como `.map()` ou `.filter()`. Ao convertê-lo em Stream, você ganha acesso a toda a API funcional do Java.

---

### Assinaturas do método

`Arrays.stream()` tem **sobrecargas** para diferentes tipos:

```java
// Para arrays de objetos:
static <T> Stream<T>   stream(T[] array)

// Para arrays primitivos (retornam streams especializados):
static IntStream    stream(int[] array)
static LongStream   stream(long[] array)
static DoubleStream stream(double[] array)
```

No seu código, como o array é `Produto[]` (objeto), o retorno é `Stream<Produto>`.

---

### Variações úteis do `Arrays.stream()`

Você também pode criar um Stream de **parte** do array passando índices:

```java
Arrays.stream(array, inicio, fim) // fim é exclusivo
```

| Chamada                    | O que faz                         |
| -------------------------- | --------------------------------- |
| `Arrays.stream(arr)`       | Stream com **todos** os elementos |
| `Arrays.stream(arr, 1, 4)` | Stream só com índices `[1, 2, 3]` |

---

### Comparação: array vs Stream

|                      | `Produto[]` (array) | `Stream<Produto>`      |
| -------------------- | ------------------- | ---------------------- |
| Acessa por índice    | ✅ `arr[i]`         | ❌                     |
| `.map()`             | ❌                  | ✅                     |
| `.filter()`          | ❌                  | ✅                     |
| `.collect()`         | ❌                  | ✅                     |
| Tamanho fixo         | ✅                  | — (lazy/preguiçoso)    |
| Pode ser reutilizado | ✅                  | ❌ (consumido uma vez) |

---

### Ponto importante: Stream é "preguiçoso" (lazy)

`Arrays.stream()` **não processa nada imediatamente**. Ele apenas prepara o pipeline. O processamento real só acontece quando você chama uma **operação terminal** — no seu caso, o `.collect()`:

```java
Arrays.stream(getEstoqueProdutos())  // prepara o pipeline (lazy)
    .map(prod -> ...)                // ainda não executa (lazy)
    .collect(...)                    // ← AQUI tudo é executado de fato (terminal)
```

---

É essencialmente uma **"porta de entrada"** para transformar seu array numa sequência processável funcionalmente.
