/**
 * Copyright 2007-2015, Kaazing Corporation. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kaazing.k3po.lang.internal.ast.matcher;

import static org.kaazing.k3po.lang.internal.ast.util.AstUtil.equivalent;

import java.util.Arrays;

import org.kaazing.k3po.lang.internal.ast.AstRegion;
import org.kaazing.k3po.lang.internal.el.ExpressionContext;

public final class AstExactBytesMatcher extends AstValueMatcher {

    private final byte[] value;

    public AstExactBytesMatcher(byte[] value, ExpressionContext environment) {
        if (value == null) {
            throw new NullPointerException("value");
        }
        this.value = value;
    }

    public byte[] getValue() {
        return value;
    }

    @Override
    public <R, P> R accept(Visitor<R, P> visitor, P parameter) throws Exception {

        return visitor.visit(this, parameter);
    }

    @Override
    protected int hashTo() {
        return Arrays.hashCode(value);
    }

    @Override
    protected boolean equalTo(AstRegion that) {
        return (that instanceof AstExactBytesMatcher) && equalTo((AstExactBytesMatcher) that);
    }

    protected boolean equalTo(AstExactBytesMatcher that) {
        return equivalent(this.value, that.value);
    }

    @Override
    protected void describe(StringBuilder buf) {
        if (value == null || value.length == 0) {
            buf.append("[]");
        }
        else {
            for (byte b : value) {
                buf.append(String.format(" 0x%02x", b));
            }

            buf.setCharAt(0, '[');
            buf.append(']');
        }
    }
}
