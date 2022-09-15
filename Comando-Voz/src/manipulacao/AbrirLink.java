package manipulacao;

import java.awt.Desktop;
import java.net.URI;

public class AbrirLink {

	public static void main(String [] args) {
		try {
			URI link = new URI("www.github.com");
			Desktop.getDesktop().browse(link);
		} catch(Exception erro) {
			System.out.print(erro);
		}
		
	}
}
