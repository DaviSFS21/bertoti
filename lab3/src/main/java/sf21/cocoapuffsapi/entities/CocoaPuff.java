package sf21.cocoapuffsapi.entities;

import java.util.UUID;

public class CocoaPuff {
    private final String id;
    private String name;
    private boolean archived;

    public CocoaPuff(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.archived = true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
