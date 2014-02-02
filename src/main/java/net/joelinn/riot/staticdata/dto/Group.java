package net.joelinn.riot.staticdata.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Joe Linn
 * 1/29/14
 */
@JsonIgnoreProperties({"MaxGroupOwnable"})  // ignore redundant property
public class Group {
    public String maxGroupOwnable;
    public String id;
}
