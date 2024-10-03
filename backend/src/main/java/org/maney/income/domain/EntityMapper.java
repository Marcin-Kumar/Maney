package org.maney.income.domain;

public interface EntityMapper<E, M> {
    M toModel(E entity);
}
