## Diagrama de UML para o Strategy Antipattern

```mermaid
classDiagram
    direction LR

    class Component {
    <<interface>>
        + showPrice()
        + showTotal(): double
    }
    
    class Leaf {
        - String name
        - double price
        + Leaf(name, price)
        + showPrice()
        + showTotal(): double
    }
    
    class GroupComposite {
        - String name
        - List~Component~ components
        + GroupComposite(name)
        + addComponent(component)
        + showPrice()
        + showTotal(): double
    }
    
    Leaf ..|> Component : implements
    GroupComposite ..|> Component : implements
    
    GroupComposite "1" *-- "*" Component : contains
```