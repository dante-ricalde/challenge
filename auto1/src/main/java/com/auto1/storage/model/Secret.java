package com.auto1.storage.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * [Description].
 * <br/>
 * <b>Class</b>: {@link Secret}<br/>
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
@Data
@RequiredArgsConstructor
public class Secret {
    private final String key;
    private final String value;
}
