package com.auto1.storage.dao.impl;

import com.auto1.storage.dao.StorageDao;
import com.auto1.storage.model.Secret;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.lang.String.CASE_INSENSITIVE_ORDER;

/**
 * [Description].
 * <br/>
 * <b>Class</b>: {@link DefaultStorageDao}<br/>
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
@Component
public class DefaultStorageDao implements StorageDao {

    Map<Object, Secret> secrets = new HashMap<>();

    @Override
    public <K> K store(K key, Secret secret) {
        secrets.put(key, secret);
        return key;
    }

    @Override
    public <K> Secret get(K key) {
        if (key instanceof String) {
            final Map<Object, Secret> stringSecrets = secrets.entrySet().stream().filter(e -> e.getKey() instanceof String).collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
            final TreeMap<String, Secret> stringTreeMap = new TreeMap<>(CASE_INSENSITIVE_ORDER);
            stringSecrets.entrySet().forEach(entry -> stringTreeMap.put((String) entry.getKey(), entry.getValue()));
            return stringTreeMap.get(key);
        }
        return secrets.get(key);
    }
}
