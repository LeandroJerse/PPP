// Assuming these classes are in the same package or need to be imported from another package

import java.util.List;
import TwoElement;
import ThreeElement;
import NumberElement;

public interface NumberVisitor {
    
    public void visit(TwoElement twoElement);
    public void visit(ThreeElement threeElement);
    public void visit(List<NumberElement> elementList);    
}