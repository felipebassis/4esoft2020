package observer.cofre;

public class AppCofre {

	public static void main(String[] args) {
		Cofre daSala = new Cofre(123456);
		
		daSala.addListener(new CofreListenerConsole());
		
		System.out.println(daSala.isAberto());
		
		daSala.fechar();
		System.out.println(daSala.isAberto());

		try {
			daSala.abrir(111);
		} catch (SenhaIncorretaException e) {
			System.out.println(e.getLocalizedMessage());
		}
		System.out.println(daSala.isAberto());

		try {
			daSala.abrir(123456);
		} catch (SenhaIncorretaException e) {
			System.out.println(e.getLocalizedMessage());
		}
		System.out.println(daSala.isAberto());
		
		System.out.println("Fim.");
		
	}

}
