import java.text.DecimalFormat;

public class SimuladorTributario {

    public static double calcularImpostoAntigo(double valorFaturamento, int aliquotaBase) {
        return valorFaturamento * (aliquotaBase / 100.0);
    }

    
    public static double calcularImpostoProposto(double valorFaturamento, int aliquotaProposta) {
        return valorFaturamento * (aliquotaProposta / 100.0);
    }

    
    public static double calcularDiferenca(double impostoAntigo, double impostoProposto) {
        return impostoProposto - impostoAntigo;
    }


    public void statusDialogo(boolean acessoAoGoverno) {
        if (acessoAoGoverno) {
            System.out.println("STATUS: Diálogo aberto. Há espaço para negociação.");
        } else {
            System.out.println("STATUS: Fintechs reclamam de falta de acesso ao governo. Risco de derrota política.");
        }
    }

    public static void main(String[] args) {
        double faturamento = 50000000.00;
        DecimalFormat df = new DecimalFormat("#,##0.00");

        System.out.println("=== Análise de Tributação de Fintechs ===");
        System.out.println("");
        System.out.println("Faturamento Base: R$ " + df.format(faturamento));
        System.out.println("");

        /
        double impostoAntigoA = calcularImpostoAntigo(faturamento, 9);
        double impostoPropostoA = calcularImpostoProposto(faturamento, 15);
        double diferencaA = calcularDiferenca(impostoAntigoA, impostoPropostoA);

        System.out.println("-- Proposta A (9% -> 15%) --");
        System.out.println("Imposto Antigo (9%): R$ " + df.format(impostoAntigoA));
        System.out.println("Imposto Proposto (15%): R$ " + df.format(impostoPropostoA));
        System.out.println("Aumento de Imposto: R$ " + df.format(diferencaA));
        System.out.println("");

   
        double impostoAntigoB = calcularImpostoAntigo(faturamento, 15);
        double impostoPropostoB = calcularImpostoProposto(faturamento, 20);
        double diferencaB = calcularDiferenca(impostoAntigoB, impostoPropostoB);

        System.out.println("-- Proposta B (15% -> 20%) --");
        System.out.println("Imposto Antigo (15%): R$ " + df.format(impostoAntigoB));
        System.out.println("Imposto Proposto (20%): R$ " + df.format(impostoPropostoB));
        System.out.println("Aumento de Imposto: R$ " + df.format(diferencaB));
        System.out.println("");

        System.out.println("-- Análise de Diálogo --");
        SimuladorTributario sim = new SimuladorTributario();
        sim.statusDialogo(true);
        sim.statusDialogo(false)
    }
}
