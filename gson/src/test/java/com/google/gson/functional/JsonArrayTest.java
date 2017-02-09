/*
 * Copyright (C) 2008 Google Inc.
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

package com.google.gson.functional;

import com.google.gson.JsonArray;
import junit.framework.TestCase;

import java.math.BigInteger;

/**
 * Functional tests for adding primitives to a JsonArray.
 *
 * @author Dillon Dixon
 */
public class JsonArrayTest extends TestCase {

  public void testStringPrimitiveAddition() {
    JsonArray jsonArray = new JsonArray();

    jsonArray.add("Hello");
    jsonArray.add("Goodbye");
    jsonArray.add("Thank you");
    jsonArray.add((String) null);
    jsonArray.add("Yes");

    assertEquals("[\"Hello\",\"Goodbye\",\"Thank you\",null,\"Yes\"]", jsonArray.toString());
  }

  public void testIntegerPrimitiveAddition() {
    JsonArray jsonArray = new JsonArray();

    int x = 1;
    jsonArray.add(x);

    x = 2;
    jsonArray.add(x);

    x = -3;
    jsonArray.add(x);

    jsonArray.add((Integer) null);

    x = 4;
    jsonArray.add(x);

    x = 0;
    jsonArray.add(x);

    assertEquals("[1,2,-3,null,4,0]", jsonArray.toString());
  }

  public void testDoublePrimitiveAddition() {
    JsonArray jsonArray = new JsonArray();

    double x = 1.0;
    jsonArray.add(x);

    x = 2.13232;
    jsonArray.add(x);

    x = 0.121;
    jsonArray.add(x);

    jsonArray.add((Double) null);

    x = -0.00234;
    jsonArray.add(x);

    jsonArray.add((Double) null);

    assertEquals("[1.0,2.13232,0.121,null,-0.00234,null]", jsonArray.toString());
  }

  public void testBooleanPrimitiveAddition() {
    JsonArray jsonArray = new JsonArray();

    jsonArray.add(true);
    jsonArray.add(true);
    jsonArray.add(false);
    jsonArray.add(false);
    jsonArray.add((Boolean) null);
    jsonArray.add(true);

    assertEquals("[true,true,false,false,null,true]", jsonArray.toString());
  }

  public void testCharPrimitiveAddition() {
    JsonArray jsonArray = new JsonArray();

    jsonArray.add('a');
    jsonArray.add('e');
    jsonArray.add('i');
    jsonArray.add((char) 111);
    jsonArray.add((Character) null);
    jsonArray.add('u');
    jsonArray.add("and sometimes Y");

    assertEquals("[\"a\",\"e\",\"i\",\"o\",null,\"u\",\"and sometimes Y\"]", jsonArray.toString());
  }

  public void testMixedPrimitiveAddition() {
    JsonArray jsonArray = new JsonArray();

    jsonArray.add('a');
    jsonArray.add("apple");
    jsonArray.add(12121);
    jsonArray.add((char) 111);
    jsonArray.add((Boolean) null);
    jsonArray.add((Character) null);
    jsonArray.add(12.232);
    jsonArray.add(BigInteger.valueOf(2323));

    assertEquals("[\"a\",\"apple\",12121,\"o\",null,null,12.232,2323]", jsonArray.toString());
  }

  public void testNullPrimitiveAddition() {
    JsonArray jsonArray = new JsonArray();

    jsonArray.add((Character) null);
    jsonArray.add((Boolean) null);
    jsonArray.add((Integer) null);
    jsonArray.add((Double) null);
    jsonArray.add((Float) null);
    jsonArray.add((BigInteger) null);
    jsonArray.add((String) null);
    jsonArray.add((Boolean) null);
    jsonArray.add((Number) null);

    assertEquals("[null,null,null,null,null,null,null,null,null]", jsonArray.toString());
  }

  public void testSameAddition() {
    JsonArray jsonArray = new JsonArray();

    jsonArray.add('a');
    jsonArray.add('a');
    jsonArray.add(true);
    jsonArray.add(true);
    jsonArray.add(1212);
    jsonArray.add(1212);
    jsonArray.add(34.34);
    jsonArray.add(34.34);
    jsonArray.add((Boolean) null);
    jsonArray.add((Boolean) null);

    assertEquals("[\"a\",\"a\",true,true,1212,1212,34.34,34.34,null,null]", jsonArray.toString());
  }

  public void testStringPrimitiveContains() {
    JsonArray jsonArray = new JsonArray();

    jsonArray.add("Hello");
    jsonArray.add("Goodbye");
    jsonArray.add("Thank you");
    jsonArray.add((String) null);
    jsonArray.add("Yes");

    assertTrue(jsonArray.contains("Hello"));
    assertTrue(jsonArray.contains("Goodbye"));
    assertTrue(jsonArray.contains("Thank you"));
    assertTrue(jsonArray.contains((String) null));
    assertTrue(jsonArray.contains("Yes"));

    assertFalse(jsonArray.contains("abc"));
    assertFalse(jsonArray.contains(1212));
    assertFalse(jsonArray.contains(34.34));
    assertFalse(jsonArray.contains(false));
    assertFalse(jsonArray.contains('a'));
  }

  public void testIntegerPrimitiveContains() {
    JsonArray jsonArray = new JsonArray();

    jsonArray.add(1);
    jsonArray.add(2);
    jsonArray.add(-3);
    jsonArray.add((Integer) null);
    jsonArray.add(4);
    jsonArray.add(0);

    assertTrue(jsonArray.contains(1));
    assertTrue(jsonArray.contains(2));
    assertTrue(jsonArray.contains(-3));
    assertTrue(jsonArray.contains((Integer) null));
    assertTrue(jsonArray.contains(4));
    assertTrue(jsonArray.contains(0));

    assertFalse(jsonArray.contains("abc"));
    assertFalse(jsonArray.contains(1212));
    assertFalse(jsonArray.contains(34.34));
    assertFalse(jsonArray.contains(false));
    assertFalse(jsonArray.contains('a'));
  }

  public void testDoublePrimitiveContains() {
    JsonArray jsonArray = new JsonArray();

    jsonArray.add(1.0);
    jsonArray.add(2.13232);
    jsonArray.add(0.121);
    jsonArray.add((Double) null);
    jsonArray.add(-0.00234);
    jsonArray.add((Number) null);

    assertTrue(jsonArray.contains(1.0));
    assertTrue(jsonArray.contains(2.13232));
    assertTrue(jsonArray.contains(0.121));
    assertTrue(jsonArray.contains((Double) null));
    assertTrue(jsonArray.contains(-0.00234));
    assertTrue(jsonArray.contains((Number) null));

    assertFalse(jsonArray.contains("abc"));
    assertFalse(jsonArray.contains(1212));
    assertFalse(jsonArray.contains(34.34));
    assertFalse(jsonArray.contains(false));
    assertFalse(jsonArray.contains('a'));
  }

  public void testBooleanPrimitiveContains() {
    JsonArray jsonArray = new JsonArray();

    jsonArray.add(true);
    jsonArray.add(true);
    jsonArray.add(false);
    jsonArray.add(false);
    jsonArray.add((Boolean) null);
    jsonArray.add(true);

    assertTrue(jsonArray.contains(true));
    assertTrue(jsonArray.contains(true));
    assertTrue(jsonArray.contains(false));
    assertTrue(jsonArray.contains(false));
    assertTrue(jsonArray.contains((Boolean) null));
    assertTrue(jsonArray.contains(true));

    assertFalse(jsonArray.contains("abc"));
    assertFalse(jsonArray.contains(1212));
    assertFalse(jsonArray.contains(34.34));
    assertFalse(jsonArray.contains('a'));
  }

  public void testCharPrimitiveContains() {
    JsonArray jsonArray = new JsonArray();

    jsonArray.add('a');
    jsonArray.add('e');
    jsonArray.add('i');
    jsonArray.add((char) 111);
    jsonArray.add((Character) null);
    jsonArray.add('u');
    jsonArray.add("and sometimes Y");

    assertTrue(jsonArray.contains('a'));
    assertTrue(jsonArray.contains('e'));
    assertTrue(jsonArray.contains('i'));
    assertTrue(jsonArray.contains((char) 111));
    assertTrue(jsonArray.contains((Character) null));
    assertTrue(jsonArray.contains('u'));
    assertTrue(jsonArray.contains("and sometimes Y"));

    assertFalse(jsonArray.contains("abc"));
    assertFalse(jsonArray.contains(1212));
    assertFalse(jsonArray.contains(34.34));
    assertFalse(jsonArray.contains(false));
    assertFalse(jsonArray.contains('@'));
  }

  public void testMixedPrimitiveContains() {
    JsonArray jsonArray = new JsonArray();

    jsonArray.add('a');
    jsonArray.add("apple");
    jsonArray.add(12121);
    jsonArray.add((char) 111);
    jsonArray.add((Boolean) null);
    jsonArray.add((Character) null);
    jsonArray.add(12.232);
    jsonArray.add(BigInteger.valueOf(2323));

    assertTrue(jsonArray.contains('a'));
    assertTrue(jsonArray.contains("apple"));
    assertTrue(jsonArray.contains(12121));
    assertTrue(jsonArray.contains((char) 111));
    assertTrue(jsonArray.contains((Boolean) null));
    assertTrue(jsonArray.contains((Character) null));
    assertTrue(jsonArray.contains(12.232));
    assertTrue(jsonArray.contains(BigInteger.valueOf(2323)));

    assertFalse(jsonArray.contains("abc"));
    assertFalse(jsonArray.contains(1212));
    assertFalse(jsonArray.contains(34.34));
    assertFalse(jsonArray.contains(false));
    assertFalse(jsonArray.contains('@'));
  }

  public void testNullPrimitiveContains() {
    JsonArray jsonArray = new JsonArray();

    jsonArray.add((Character) null);
    jsonArray.add((Boolean) null);
    jsonArray.add((Integer) null);
    jsonArray.add((Double) null);
    jsonArray.add((Float) null);
    jsonArray.add((BigInteger) null);
    jsonArray.add((String) null);
    jsonArray.add((Boolean) null);
    jsonArray.add((Number) null);

    assertTrue(jsonArray.contains((Character) null));
    assertTrue(jsonArray.contains((Boolean) null));
    assertTrue(jsonArray.contains((Integer) null));
    assertTrue(jsonArray.contains((Double) null));
    assertTrue(jsonArray.contains((Float) null));
    assertTrue(jsonArray.contains((BigInteger) null));
    assertTrue(jsonArray.contains((String) null));
    assertTrue(jsonArray.contains((Boolean) null));
    assertTrue(jsonArray.contains((Number) null));

    assertFalse(jsonArray.contains("abc"));
    assertFalse(jsonArray.contains(1212));
    assertFalse(jsonArray.contains(34.34));
    assertFalse(jsonArray.contains(false));
    assertFalse(jsonArray.contains('@'));
  }

  public void testSameContains() {
    JsonArray jsonArray = new JsonArray();

    jsonArray.add('a');
    jsonArray.add('a');
    jsonArray.add(true);
    jsonArray.add(true);
    jsonArray.add(1212);
    jsonArray.add(1212);
    jsonArray.add(34.34);
    jsonArray.add(34.34);
    jsonArray.add((Boolean) null);
    jsonArray.add((Boolean) null);

    assertTrue(jsonArray.contains('a'));
    assertTrue(jsonArray.contains('a'));
    assertTrue(jsonArray.contains(true));
    assertTrue(jsonArray.contains(true));
    assertTrue(jsonArray.contains(1212));
    assertTrue(jsonArray.contains(1212));
    assertTrue(jsonArray.contains(34.34));
    assertTrue(jsonArray.contains(34.34));
    assertTrue(jsonArray.contains((Boolean) null));
    assertTrue(jsonArray.contains((Boolean) null));

    assertFalse(jsonArray.contains("abc"));
    assertFalse(jsonArray.contains(12121));
    assertFalse(jsonArray.contains(12.232));
    assertFalse(jsonArray.contains(false));
    assertFalse(jsonArray.contains('@'));
  }
}
