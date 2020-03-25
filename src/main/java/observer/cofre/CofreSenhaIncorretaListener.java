package observer.cofre;

public interface CofreSenhaIncorretaListener extends CofreListener{
    void senhaIncorretaFoiInformada(int senhaInformada);
}
