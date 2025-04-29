import java.util.List;
import TwoElement;
import ThreeElement;
import NumberElement;

public class TotalSumVisitor implements NumberVisitor {

    private int totalSum = 0;

    @Override
    public void visit(TwoElement twoElement) {
        int sum = twoElement.a + twoElement.b;
        totalSum += sum; // Adicionado para somar ao total
        System.out.println("Adding " + twoElement.a + " + " + twoElement.b + " = " + sum + " to total");
    }

    @Override
    public void visit(ThreeElement threeElement) {
        int sum = threeElement.a + threeElement.b + threeElement.c;
        totalSum += sum; // Adicionado para somar ao total
        System.out.println("Adding " + threeElement.a + " + " + threeElement.b + " + " + threeElement.c + " = " + sum + " to total");
    }

    @Override
    public void visit(List<NumberElement> elementList) {
        for (NumberElement ne : elementList) { // Corrigido o pacote para "NumberElement"
            ne.accept(this);
        }
    }

    public int getTotalSum() {
        return totalSum;
    }
}
