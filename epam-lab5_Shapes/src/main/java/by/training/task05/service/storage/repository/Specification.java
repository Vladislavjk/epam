package by.training.task05.service.storage.repository;

@FunctionalInterface
public interface Specification<T> {
    boolean specify(T t);
}
