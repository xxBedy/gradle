/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.tooling.model.internal;

import org.gradle.tooling.model.UnsupportedMethodException;

/**
 * by Szczepan Faber, created at: 12/22/11
 */
public class Exceptions {

    public static UnsupportedMethodException unsupportedMethod(String method, Throwable cause) {
        return new UnsupportedMethodException(formatMessage(method), cause);
    }

    public static UnsupportedMethodException unsupportedMethod(String method) {
        return new UnsupportedMethodException(formatMessage(method));
    }

    private static String formatMessage(String method) {
        return String.format("Method not found. The version of Gradle you connect to does not support this method: %s()\n"
                        + "Most likely, this method was added in one of the later versions of Gradle.\n"
                        + "To resolve the problem you can change/upgrade the target version of Gradle you connect to.\n"
                        + "Alternatively, you can handle and ignore this exception."
                        , method);
    }
}
