package org.bonitasoft.web.client.log;

public enum LogContentLevel {
  /** Headers + Body */
  FULL,
  /** Headers */
  HEADER,
  /** HTTP trace (url + verb + response code) */
  BASIC,
  /** No log */
  OFF
}
