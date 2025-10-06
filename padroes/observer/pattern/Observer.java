import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Subscriber {
    void update(String topic, String message);
}

class NewsSubscriber implements Subscriber {
    private final String name;

    public NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String topic, String message) {
        System.out.printf("%s received update on %s: %s%n", name, topic, message);
    }
}

class NewsPublisher {
    private final Map<String, List<Subscriber>> subscribers = new HashMap<>();

    public void subscribe(String topic, Subscriber subscriber) {
        subscribers.computeIfAbsent(topic, k -> new ArrayList<>()).add(subscriber);
    }

    public void unsubscribe(String topic, Subscriber subscriber) {
        List<Subscriber> subs = subscribers.get(topic);
        if (subs != null) {
            subs.remove(subscriber);
        }
    }

    public void publish(String topic, String message) {
        List<Subscriber> subs = subscribers.get(topic);
        if (subs != null) {
            for (Subscriber sub : subs) {
                sub.update(topic, message);
            }
        }
    }
}

void main() {
    NewsPublisher publisher = new NewsPublisher();

    Subscriber alice = new NewsSubscriber("Alice");
    Subscriber bob = new NewsSubscriber("Bob");

    publisher.subscribe("Sports", alice);
    publisher.subscribe("Technology", bob);
    publisher.subscribe("Sports", bob);

    publisher.publish("Sports", "Local team wins championship!");
    publisher.publish("Technology", "New smartphone released!");

    publisher.unsubscribe("Sports", bob);
    publisher.publish("Sports", "Star player traded to another team.");
}
