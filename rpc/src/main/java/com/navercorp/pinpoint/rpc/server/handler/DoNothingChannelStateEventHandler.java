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

package com.navercorp.pinpoint.rpc.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.navercorp.pinpoint.rpc.server.PinpointServer;
import com.navercorp.pinpoint.rpc.server.PinpointServerStateCode;

/**
 * @author koo.taejin
 */
public class DoNothingChannelStateEventHandler implements ChannelStateChangeEventHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final ChannelStateChangeEventHandler INSTANCE = new DoNothingChannelStateEventHandler();

    @Override
    public void eventPerformed(PinpointServer pinpointServer, PinpointServerStateCode stateCode) {
        logger.info("{} eventPerformed(). pinpointServer:{}, code:{}", this.getClass().getSimpleName(), pinpointServer, stateCode);
    }
    
    @Override
    public void exceptionCaught(PinpointServer pinpointServer, PinpointServerStateCode stateCode, Throwable e) {
        logger.warn("{} exceptionCaught(). pinpointServer:{}, code:{}. Error: {}.", this.getClass().getSimpleName(), pinpointServer, stateCode, e.getMessage(), e);
    }

}
