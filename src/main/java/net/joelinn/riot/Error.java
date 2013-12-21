package net.joelinn.riot;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 * Joe Linn
 * 12/10/13
 */
@JsonRootName("status")
public class Error {
    public String message;

    @JsonProperty("status_code")
    public int statusCode;
}
