/**
 * Copyright (c) 2010-2023 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.miio.internal.robot;

import org.eclipse.jdt.annotation.NonNullByDefault;

@NonNullByDefault
public enum DockStatusType {

    UNKNOWN(-1, "Unknown"),
    OK(0, "OK"),
    ERROR_SUCTION(34, "Suction Error"),
    ERROR_FRESH_WATER_TANK(38, "Error fresh water tank"),
    ERROR_FRESH_DIRTY_WATER_TANKL(39, "Error dirty water tank"),
    ERROR_DUST_CONTAEINERL(46, "Missing dust container/duts bag");

    private final int id;
    private final String description;

    DockStatusType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public static DockStatusType getType(int value) {
        for (DockStatusType st : DockStatusType.values()) {
            if (st.getId() == value) {
                return st;
            }
        }
        return UNKNOWN;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Status " + Integer.toString(id) + ": " + description;
    }
}
