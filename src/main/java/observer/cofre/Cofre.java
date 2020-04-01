package observer.cofre;

import java.util.ArrayList;
import java.util.List;

public class Cofre {

	private int senha;
	private boolean aberto;
	private List<CofreAbertoListener> cofreAbertoListeners = new ArrayList<>();
	private List<CofreFechadoListener> cofreFechadoListeners = new ArrayList<>();
	private List<CofreSenhaIncorretaListener> cofreSenhaIncorretaListeners = new ArrayList<>();

	public Cofre(int senha) {
		this.senha = senha;
		this.aberto = true;
	}

	public boolean isAberto() {
		return this.aberto;
	}

	public void fechar() {
		this.aberto = false;
		this.cofreFechadoListeners.forEach(CofreFechadoListener::cofreFoiFechado);
	}

	public void abrir(int senhaInformada) throws SenhaIncorretaException {
		if (senhaInformada == this.senha) {
			this.aberto = true;
			cofreAbertoListeners.forEach(CofreAbertoListener::cofreFoiAberto);
			return;
		}
		cofreSenhaIncorretaListeners.forEach(listener -> listener.senhaIncorretaFoiInformada(senhaInformada));
		throw new SenhaIncorretaException("A senha " + senhaInformada + " é senha incorreta.");
	}

	public void addListener(CofreListener listener) {
		if (listener instanceof CofreAbertoListener) {
			cofreAbertoListeners.add((CofreAbertoListener) listener);
		}
		if (listener instanceof CofreFechadoListener) {
			cofreFechadoListeners.add((CofreFechadoListener) listener);
		}
		if (listener instanceof CofreSenhaIncorretaListener) {
			cofreSenhaIncorretaListeners.add((CofreSenhaIncorretaListener) listener);
		}

	}

}
