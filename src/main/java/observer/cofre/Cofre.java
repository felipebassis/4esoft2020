package observer.cofre;

import java.util.ArrayList;
import java.util.List;

public class Cofre {

    private int senha;
    private boolean aberto;
    private List<CofreListener> listeners = new ArrayList<>();

    public Cofre(int senha) {
        this.senha = senha;
        this.aberto = true;
    }

    public boolean isAberto() {
        return this.aberto;
    }

    public void fechar() {
        this.aberto = false;
        this.listeners.stream()
                .filter(cofreListener -> cofreListener instanceof CofreFechadoListener)
                .map(cofreListener -> (CofreFechadoListener) cofreListener)
                .forEach(CofreFechadoListener::cofreFoiFechado);
    }

    public void abrir(int senhaInformada) throws SenhaIncorretaException {
        if (senhaInformada == this.senha) {
            this.aberto = true;
            this.listeners.stream()
                    .filter(cofreListener -> cofreListener instanceof CofreAbertoListener)
                    .map(cofreListener -> (CofreAbertoListener) cofreListener)
                    .forEach(CofreAbertoListener::cofreFoiAberto);
            return;
        }
        this.listeners.stream()
                .filter(cofreListener -> cofreListener instanceof CofreSenhaIncorretaListener)
                .map(cofreListener -> (CofreSenhaIncorretaListener) cofreListener)
                .forEach(listener -> listener.senhaIncorretaFoiInformada(senhaInformada));
        throw new SenhaIncorretaException("A senha " + senhaInformada + " é senha incorreta.");
    }

    public void addListener(CofreListener listener) {
        this.listeners.add(listener);
    }

}
