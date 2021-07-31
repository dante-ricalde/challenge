package com.auto1.storage;

import com.auto1.storage.dao.StorageDao;
import com.auto1.storage.model.Secret;
import lombok.RequiredArgsConstructor;

/**
 * [Description].
 * <br/>
 * <b>Class</b>: {@link DefaultStorageService}<br/>
 *
 * @author dante<br />
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>Dante Raphael Ricalde Delgado. (DRD)</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>Jul 26, 2021 (DRD) Creation class.</li>
 * </ul>
 * @version 1.0
 */
@RequiredArgsConstructor
public class DefaultStorageService implements StorageService {

    private final StorageDao storageDao;

    @Override
    public <K> K store(K key, Secret secret) {
        K result = null;
        if (key != null) {
            if (key instanceof String && ((String) key).length() > 20) {
                throw new RuntimeException("key length must not be bigger than 20");
            }
        }
        if (key != null) {
            result = storageDao.store(key, secret);
        }
        return result;
    }

    @Override
    public <K> Secret get(K key) {
        Secret result = null;
        if (key != null) {
            return storageDao.get(key);
        }
        return result;
    }
}
