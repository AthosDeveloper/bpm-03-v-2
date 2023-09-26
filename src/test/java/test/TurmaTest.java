package test;

import meusTests.Pessoa;
import meusTests.Turma;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TurmaTest {
    private Turma turma;


    public  TurmaTest(){

    }
    @BeforeEach
    public  void setUp(){
        Pessoa pessoa1 = new Pessoa(1, "fernando");
        Pessoa pessoa2 = new Pessoa(2, "juliana");
        Pessoa pessoa3 = new Pessoa(3, "gabriela");
        this.turma = new Turma();
        this.turma.adicionarPessoa(pessoa1);
        this.turma.adicionarPessoa(pessoa2);
        this.turma.adicionarPessoa(pessoa3);


    }

    @AfterEach
    public void tearDown() {
        this.turma.removerTodasPessoas();
    }

    @Test
    public void deveRetornarExcecaoPessoaInvalida() {
        try {
            this.turma.adicionarPessoa(new Pessoa(-1, "teste"));
        } catch (Exception ex) {
            assert ex.getMessage().equals("Objeto pessoa invalido");
        }

    }

    @Test
    public void deveRetornarExcecaoPessoaExistente() {
        try {
            this.turma.adicionarPessoa(new Pessoa(1, "teste"));
        } catch (Exception ex) {
            assert ex.getMessage().equals("Objeto pessoa ja esta atribuido a turma");
        }

    }

    @Test
    public void deveRetornarSucessoAdicionarPessoa() throws Exception {
        this.turma.adicionarPessoa(new Pessoa(4, "teste"));

        assert this.turma.getPessoas().size() == 4;

    }

    @Test
    public void deveRetornarSucessoRemoverTodasPessoas() throws Exception {
        this.turma.removerTodasPessoas();

        assert this.turma.getPessoas().isEmpty();

    }


}
