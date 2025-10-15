import java.util.ArrayList;
import java.util.List;


class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class Section {
    private List<Object> items = new ArrayList<>();

    public void addItem(Object item) {
        items.add(item);
    }

    public void displayItems() {
        for (Object item : items) {
            if (item instanceof Movie) {
                System.out.println("Movie: " + ((Movie) item).getTitle());
            } else if (item instanceof Section) {
                System.out.println("Sub-shelf:");
                ((Section) item).displayItems();
            } else {
                System.out.println("Unknown item type");
            }
        }
    }
}

public class MovieAntipatternDemo {
    public static void main(String[] args) {
        Movie movie1 = new Movie("Inception");
        Movie movie2 = new Movie("The Matrix");
        Movie movie3 = new Movie("Interstellar");

        Section subSection = new Section();
        subSection.addItem(movie1);
        subSection.addItem(movie2);

        Section mainSection = new Section();
        mainSection.addItem(movie3);
        mainSection.addItem(subSection);

        mainSection.displayItems();
    }
}
