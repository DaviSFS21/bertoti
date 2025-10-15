## Diagrama UML para o Antipattern Composite

```mermaid
classDiagram
    direction LR

    class Movie {
        - title : String
        +Movie(title : String)
        +getTitle() : String
    }

    class Section {
        - items : List<Object>
        +addItem(item : Object) : void
        +displayItems() : void
        +addItem(item : Object) : void
        +displayItems() : void
    }

Section ..o Object : contains
Section ..> Movie : uses
Section ..> Section : uses
```
