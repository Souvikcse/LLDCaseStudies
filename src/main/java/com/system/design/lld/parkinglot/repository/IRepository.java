package com.system.design.lld.parkinglot.repository;
/**
 * @author nayanava
 */

import java.io.*;

public interface IRepository<TObj, TId> {
    void save(TObj entity) throws InvalidObjectException;
    TObj get(TId id);
    boolean update(TObj entity);
    void delete(TId id);
}
