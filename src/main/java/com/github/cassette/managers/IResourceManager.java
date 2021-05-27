package com.github.cassette.managers;

public interface IResourceManager<T> {
    T create(T entity);
    T update(T entity);
    void deleteById(long id);
    void delete(T entity);
}
