package system.plan;

import system.enums.ElementType;
import system.interfaces.IGetElementType;

abstract public class Element implements IGetElementType {
    public abstract ElementType getElementType();
}
