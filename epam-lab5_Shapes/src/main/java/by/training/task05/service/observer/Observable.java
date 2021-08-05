package by.training.task05.service.observer;

public interface Observable<T> {
    void attachObserver(T observer);

    void detachObserver(T observer);

    void notifyObserver();
}
