package observer.cofre;

import java.util.Date;

public class CofreListenerConsole implements CofreAbertoListener, CofreFechadoListener, CofreSenhaIncorretaListener {

	@Override
	public void cofreFoiAberto() {
		System.out.println("O cofre foi aberto: " + new Date().toLocaleString());
	}

	@Override
	public void cofreFoiFechado() {
		System.out.println("O cofre foi fechado: " + new Date().toLocaleString());		
	}

	@Override
	public void senhaIncorretaFoiInformada(int senhaInformada) {
		System.out.println("A senha informada é Incorreta: " + senhaInformada + " - " + new Date().toLocaleString());
	}
}
