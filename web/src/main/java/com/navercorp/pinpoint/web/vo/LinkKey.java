/*
 * Copyright 2014 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.pinpoint.web.vo;

import com.navercorp.pinpoint.common.ServiceType;

/**
 * @author emeroad
 */
public final class LinkKey {

    private final String fromApplication;
    private final ServiceType fromServiceType;

    private final String toApplication;
    private final ServiceType toServiceType;

    private int hash;

    public LinkKey(Application fromApplication, Application toApplication) {
        if (fromApplication == null) {
            throw new NullPointerException("fromApplication must not be null");
        }
        if (toApplication == null) {
            throw new NullPointerException("toApplication must not be null");
        }
        this.fromApplication = fromApplication.getName();
        this.fromServiceType = fromApplication.getServiceType();

        this.toApplication = toApplication.getName();
        this.toServiceType = toApplication.getServiceType();
    }

    public LinkKey(String fromApplication, ServiceType fromServiceType, String toApplication, ServiceType toServiceType) {
        if (fromApplication == null) {
            throw new NullPointerException("fromApplication must not be null");
        }
        if (fromServiceType == null) {
            throw new NullPointerException("fromServiceType must not be null");
        }
        if (toApplication == null) {
            throw new NullPointerException("toApplication must not be null");
        }
        if (toServiceType == null) {
            throw new NullPointerException("toServiceType must not be null");
        }

        this.fromApplication = fromApplication;
        this.fromServiceType = fromServiceType;

        this.toApplication = toApplication;
        this.toServiceType = toServiceType;
    }

    public String getFromApplication() {
        return fromApplication;
    }

    public ServiceType getFromServiceType() {
        return fromServiceType;
    }

    public String getToApplication() {
        return toApplication;
    }

    public ServiceType getToServiceType() {
        return toServiceType;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkKey linkKey = (LinkKey) o;

        if (fromServiceType != linkKey.fromServiceType) return false;
        if (toServiceType != linkKey.toServiceType) return false;
        if (!fromApplication.equals(linkKey.fromApplication)) return false;
        if (!toApplication.equals(linkKey.toApplication)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int hash = this.hash;
        if (hash == 0) {
            return hash;
        }
        int result = fromApplication.hashCode();
        result = 31 * result + fromServiceType.hashCode();
        result = 31 * result + toApplication.hashCode();
        result = 31 * result + toServiceType.hashCode();
        this.hash = result;
        return result;
    }

    @Override
    public String toString() {
        return "LinkKey{" +
                "fromApplication='" + fromApplication + '\'' +
                ", fromServiceType=" + fromServiceType +
                ", toApplication='" + toApplication + '\'' +
                ", toServiceType=" + toServiceType +
                '}';
    }
}
