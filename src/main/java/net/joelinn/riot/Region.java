package net.joelinn.riot;

/**
 * Joe Linn
 * 12/17/13
 */
public enum Region {
    NA ("na"),
    EUW ("euw"),
    EUNE ("eune"),
    BR ("br"),
    TR ("tr"),
    LAN ("lan"),
    LAS ("las"),
    OCE ("oce"),
    RU ("ru"),
    KR ("kr");

    private String name;

    Region(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
