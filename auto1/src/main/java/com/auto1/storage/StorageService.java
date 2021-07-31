package com.auto1.storage;

import com.auto1.storage.model.Secret;

/**
 * [Description].
 * <br/>
 * <b>Class</b>: {@link StorageService}<br/>
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
public interface StorageService {

    <K> K store(K key, Secret secret);

    <K> Secret get(K key);
}
