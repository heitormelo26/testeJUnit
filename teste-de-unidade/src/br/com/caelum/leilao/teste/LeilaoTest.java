package br.com.caelum.leilao.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;


public class LeilaoTest {

    @Test
    public void deveReceberUmLance() {
        Leilao leilao = new Leilao("Macbook Pro 15");
        Assert.assertEquals(0, leilao.getLances().size());

        leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));

        Assert.assertEquals(1, leilao.getLances().size());
        Assert.assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
    }

    @Test
    public void deveReceberVariosLances() {
        Leilao leilao = new Leilao("Macbook Pro 15");
        leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));
        leilao.propoe(new Lance(new Usuario("Steve Wozniak"), 3000));

        Assert.assertEquals(2, leilao.getLances().size());
        Assert.assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
        Assert.assertEquals(3000.0, leilao.getLances().get(1).getValor(), 0.00001);
    }
}