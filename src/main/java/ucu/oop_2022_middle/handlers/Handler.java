package ucu.oop_2022_middle.handlers;

public interface Handler {
    void setNext(Handler h);
    String handle(String domain);
}
