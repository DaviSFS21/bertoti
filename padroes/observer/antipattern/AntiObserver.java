import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NewsSubscriberAntiPattern {
    private final String name;

    public NewsSubscriberAntiPattern(String name) {
        this.name = name;
    }

    public void updateNews(String topic, String message) {
        System.out.printf("%s received update on %s: %s%n", name, topic, message);
    }

    public String getName() {
        return name;
    }
}

class NewsPublisherAntiPattern {
    private final Map<String, List<NewsSubscriberAntiPattern>> subscribers = new HashMap<>();

    public void subscribe(String topic, NewsSubscriberAntiPattern subscriber) {
        subscribers.computeIfAbsent(topic, k -> new ArrayList<>()).add(subscriber);
    }

    public void unsubscribe(String topic, NewsSubscriberAntiPattern subscriber) {
        List<NewsSubscriberAntiPattern> subs = subscribers.get(topic);
        if (subs != null) {
            subs.remove(subscriber);
        }
    }

    public void publish(String topic, String message) {
        List<NewsSubscriberAntiPattern> subs = subscribers.get(topic);

        if (subs != null) {
            for (NewsSubscriberAntiPattern sub : subs) {
                sub.updateNews(topic, message);
            }
        }
    }
}

void main() {
    NewsPublisherAntiPattern publisher = new NewsPublisherAntiPattern();

    NewsSubscriberAntiPattern alice = new NewsSubscriberAntiPattern("Alice");
    NewsSubscriberAntiPattern bob = new NewsSubscriberAntiPattern("Bob");

    publisher.subscribe("Sports", alice);
    publisher.subscribe("Technology", bob);
    publisher.subscribe("Sports", bob);

    publisher.publish("Sports", "Local team wins championship!");
    publisher.publish("Technology", "New smartphone released!");

    publisher.unsubscribe("Sports", bob);
    publisher.publish("Sports", "Star player traded to another team.");
}