package com.ornellas.ms.productcatalogservice.service.operation;

import java.util.List;
import java.util.Optional;

public interface Search<T, ID> {
    Optional<T> findById(ID id);

    List<T> findAll();

    List<T> findAllById(Iterable<ID> ids);
}
