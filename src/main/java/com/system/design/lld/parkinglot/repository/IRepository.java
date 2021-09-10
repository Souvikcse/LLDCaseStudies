package com.system.design.lld.parkinglot.repository;
/**
 * @author nayanava
 */

import java.io.*;
import java.util.List;
import java.util.function.Function;

public interface IRepository<TObj, TId> {
    void save(TObj entity) throws InvalidObjectException;
    TObj get(TId id);
    boolean update(TObj entity);
    void delete(TId id);
}
