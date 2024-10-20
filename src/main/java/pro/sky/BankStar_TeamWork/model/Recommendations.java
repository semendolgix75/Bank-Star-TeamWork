package pro.sky.BankStar_TeamWork.model;

import java.util.Objects;
import java.util.UUID;

public class Recommendations {
  private String name;
  private UUID ID;
  private String text;


    public Recommendations(String name, UUID ID, String text) {
        this.name = name;
        this.ID = ID;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recommendations that)) return false;
        return Objects.equals(name, that.name) && Objects.equals(ID, that.ID) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ID, text);
    }

    @Override
    public String toString() {
        return "Recommendations{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", text='" + text + '\'' +
                '}';
    }
}
