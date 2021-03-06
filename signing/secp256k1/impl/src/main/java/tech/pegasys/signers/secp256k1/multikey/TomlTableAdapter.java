/*
 * Copyright 2019 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package tech.pegasys.signers.secp256k1.multikey;

import java.util.Optional;

import org.apache.tuweni.toml.TomlTable;

public class TomlTableAdapter {

  private final TomlTable table;

  public TomlTableAdapter(final TomlTable table) {
    this.table = table;
  }

  public String getString(final String key) {
    return Optional.ofNullable(table.getString(key))
        .orElseThrow(() -> new IllegalArgumentException(key + " was not specified in TOML input."));
  }

  public Long getLong(final String key) {
    return Optional.ofNullable(table.getLong(key))
        .orElseThrow(() -> new IllegalArgumentException(key + " was not specified in TOML input."));
  }

  public Optional<String> getOptionalString(final String key) {
    return Optional.ofNullable(table.getString(key));
  }

  public Optional<Boolean> getOptionalBoolean(final String key) {
    return Optional.ofNullable(table.getBoolean(key));
  }
}
