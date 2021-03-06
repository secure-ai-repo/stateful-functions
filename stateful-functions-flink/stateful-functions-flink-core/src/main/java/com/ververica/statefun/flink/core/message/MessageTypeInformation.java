/*
 * Copyright 2019 Ververica GmbH.
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

package com.ververica.statefun.flink.core.message;

import java.util.Objects;
import org.apache.flink.api.common.ExecutionConfig;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.common.typeutils.TypeSerializer;

public class MessageTypeInformation extends TypeInformation<Message> {

  private static final long serialVersionUID = 1L;

  private final MessageFactoryType messageFactoryType;

  public MessageTypeInformation(MessageFactoryType messageFactoryType) {
    this.messageFactoryType = Objects.requireNonNull(messageFactoryType);
  }

  @Override
  public boolean isBasicType() {
    return false;
  }

  @Override
  public boolean isTupleType() {
    return false;
  }

  @Override
  public int getArity() {
    return 0;
  }

  @Override
  public int getTotalFields() {
    return 0;
  }

  @Override
  public Class<Message> getTypeClass() {
    return Message.class;
  }

  @Override
  public boolean isKeyType() {
    return false;
  }

  @Override
  public TypeSerializer<Message> createSerializer(ExecutionConfig executionConfig) {
    return new MessageTypeSerializer(messageFactoryType);
  }

  @Override
  public String toString() {
    return "MessageTypeInformation(" + messageFactoryType + ")";
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof MessageTypeInformation;
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }

  @Override
  public boolean canEqual(Object o) {
    return o instanceof MessageTypeInformation;
  }
}
