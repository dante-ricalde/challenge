package com.auto1.storage;

import com.auto1.storage.dao.impl.DefaultStorageDao;
import com.auto1.storage.model.Secret;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * [Description].
 * <br/>
 * <b>Class</b>: {@link StorageTest}<br/>
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
class StorageTest {

    private static final DefaultStorageDao storageDao = new DefaultStorageDao();
    private static final StorageService storageService = new DefaultStorageService(storageDao);

    @Test
    void testSaveSecret() {
        final String keySaved = storageService
                .store("mY-cUsTom-kEy", new Secret("mY-cUsTom-kEy", "My secret no one should know!"));
        assertEquals("mY-cUsTom-kEy", keySaved);
    }

    @Test
    void testSaveSecretKeyInteger() {
        final String keySaved = storageService
                .store("mY-cUsTom-kEy", new Secret("mY-cUsTom-kEy", "My secret no one should know!"));
        assertEquals("mY-cUsTom-kEy", keySaved);
    }

    @Test
    void testSaveSecretInvalidKey() {
        assertThrows(RuntimeException.class, () -> storageService
                .store("mY-cUsTom-kEy-123456789", new Secret("mY-cUsTom-kEy-123456789", "My secret no one should know!")));
    }

    @Test
    void testSecretRetrieval() {
        storageService
                .store("mY-cUsTom-kEy", new Secret("mY-cUsTom-kEy", "My secret no one should know!"));
        final Secret secretRetrieved = storageService.get("mY-cUsTom-kEy");
        assertEquals("mY-cUsTom-kEy", secretRetrieved.getKey());
        assertEquals("My secret no one should know!", secretRetrieved.getValue());
    }

    @Test
    void testIgnoreCaseSecretRetrieval() {
        storageService
                .store("mY-cUsTom-kEy", new Secret("mY-cUsTom-kEy", "My secret no one should know!"));
        final Secret secretRetrieved = storageService.get("my-cusTom-kEy");
        assertEquals("mY-cUsTom-kEy", secretRetrieved.getKey());
        assertEquals("My secret no one should know!", secretRetrieved.getValue());
    }
}
