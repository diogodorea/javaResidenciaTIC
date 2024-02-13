package Controller;

import java.util.List;
import java.util.Scanner;

import Menu.Menu;
import Models.Cliente;
import Models.Fatura;
import Models.Imovel;
import Services.ClienteService;
import Services.FaturaService;
import Services.ImovelService;
import Utils.Util;

public class FaturaController {
	
	private static Scanner entrada = new Scanner(System.in);
	
	public static void realizarLeitura() {
		System.out.println("\n======================== Realizar leiruta do imóvel ========================");
		
		Imovel imovelSelecionado = Menu.menuSelecionarImovel(ImovelService.getImoveis());
		
		if (imovelSelecionado != null) {			
			System.out.print("\nValor da leitura: ");
			int leitura = Util.stringToInt(entrada.nextLine());
			
			Fatura fatura = FaturaService.gerarFatura(imovelSelecionado, leitura);
			
			System.out.println("\nImprimindo fatura...\n");
			imprimeFatura(fatura);
		}
		else {
			System.out.println("\nNão existem dados para serem exibidos.");
		}
	}
	
	public static void listarFaturas(boolean isQuitada) {
		String titulo = isQuitada ? "quitadas" : "";
		System.out.println("\n======================== Listar faturas " + titulo +" ========================\n");
		
		List<Fatura> faturas = isQuitada ? FaturaService.getFaturasQuitadas() : FaturaService.getFaturas();
		if (!faturas.isEmpty()) {
			System.out.println("Imóvel \t\t Data Emissão \t Consumo \t\t Valor \t\t Quitada");
			System.out.println("------------------------------------------------------------");
			
			for (Fatura fatura : faturas) {
				System.out.println(fatura.toString());
			}
		}
		else {
			System.out.println("\nNão existem dados para serem exibidos.");
		}
	}
	
	private static void imprimeFatura(Fatura fatura) {
		Imovel imovel = fatura.getImovel();
		Cliente cliente = ClienteService.getClienteByImovel(imovel);
		
		System.out.println("====================================================");
		System.out.println("| COELHO -  COmpalhia ELétrica de Hoje e Ontem Ltda");
		System.out.println("|");
		System.out.println("|");
		System.out.println("| Inscrição: " + imovel.getMatricula());
		System.out.println("| Nome do Responsável: " + cliente.getNome());
		System.out.println("| Endereço: " + imovel.getEndereco());
		System.out.println("|");
		System.out.println("|");
		System.out.println("| Data Emissão: " + fatura.getDataEmissao());
		System.out.println("| Valor: " + fatura.getValorCalculado());
		System.out.println("|");
		System.out.println("|");
		System.out.println("====================================================");
	}

}
