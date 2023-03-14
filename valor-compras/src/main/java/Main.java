import java.math.BigDecimal;
import model.Produto;
import services.CompraService;

public class Main {

	public static void main(String[] args) {
		Produto apoioDeNotebook = new Produto("Apoio De Notebook", BigDecimal.valueOf(12.99), 10);
		Produto penDrive = new Produto("Pen Drive Sandisk 16GB ", BigDecimal.valueOf(18.90), 12);
		Produto hubUSB = new Produto("Hub Usb 2.0", BigDecimal.valueOf(7.94), 30);
		Produto mousePad = new Produto("Mouse Pad 18x22cm", BigDecimal.valueOf(4.88), 55);

		CompraService.criarListaDecompras(apoioDeNotebook);
		CompraService.criarListaDecompras(penDrive);
		CompraService.criarListaDecompras(hubUSB);
		CompraService.criarListaDecompras(mousePad);

		CompraService.realizarCompra();

		CompraService.gerarNotaFiscal();


	}

	;
}
