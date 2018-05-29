package principal;

import menus.MenuMedico;
import menus.MenuSecretaria;

public class PrincipalTeste {

    public static void main(String args[]) {

        MenuSecretaria menuSecretaria = new MenuSecretaria();
        MenuMedico menuMedico = new MenuMedico();

        menuSecretaria.executarMenu();
        //menuMedico.executarMenu();

    }

}
